package com.mcnair.atomic.recipe.base.output;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.handler.codec.DecoderException;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public record OutputItemWithPercent(ItemStack output, double[] percentages) {
    public static final OutputItemWithPercent EMPTY = new OutputItemWithPercent(ItemStack.EMPTY, new double[0]);

    public OutputItemWithPercent(ItemStack output, double percentage) {
        this(output, new double[] {
                percentage
        });
    }

    public OutputItemWithPercent(ItemStack output) {
        this(output, 1.0);
    }

    public boolean isEmpty() {
        return output.isEmpty() || percentages.length == 0;
    }

    private static final Codec<double[]> DOUBLE_ARRAY_CODEC = new Codec<>() {
        private static final Codec<List<Double>> DOUBLE_LIST_CODEC = Codec.doubleRange(0, 1).listOf();

        @Override
        public <T> DataResult<Pair<double[], T>> decode(DynamicOps<T> ops, T input) {
            return DOUBLE_LIST_CODEC.decode(ops, input).map(res -> {
                return Pair.of(res.getFirst().stream().mapToDouble(Double::doubleValue).toArray(), res.getSecond());
            });
        }

        @Override
        public <T> DataResult<T> encode(double[] input, DynamicOps<T> ops, T prefix) {
            return DOUBLE_LIST_CODEC.encode(Arrays.stream(input).boxed().toList(), ops, prefix);
        }
    };

    public static final Codec<OutputItemWithPercent> CODEC_NONEMPTY = RecordCodecBuilder.create((instance) -> {
        return instance.group(ItemStack.CODEC.fieldOf("result").forGetter((output) -> {
            return output.output;
        }), DOUBLE_ARRAY_CODEC.fieldOf("percentages").forGetter((output) -> {
            return output.percentages;
        })).apply(instance, OutputItemWithPercent::new);
    });

    public static final StreamCodec<RegistryFriendlyByteBuf, OutputItemWithPercent> OPTIONAL_STREAM_CODEC = new StreamCodec<>() {
        @Override
        @NotNull
        public OutputItemWithPercent decode(@NotNull RegistryFriendlyByteBuf buffer) {
            int percentageCount = buffer.readInt();
            if(percentageCount <= 0)
                return OutputItemWithPercent.EMPTY;

            double[] percentages = new double[percentageCount];
            for(int j = 0;j < percentageCount;j++)
                percentages[j] = buffer.readDouble();

            ItemStack output = ItemStack.OPTIONAL_STREAM_CODEC.decode(buffer);

            return new OutputItemWithPercent(output, percentages);
        }

        @Override
        public void encode(@NotNull RegistryFriendlyByteBuf buffer, OutputItemWithPercent output) {
            if(output.isEmpty()) {
                buffer.writeInt(0);
            }else {
                buffer.writeInt(output.percentages.length);
                for(double percentage:output.percentages)
                    buffer.writeDouble(percentage);

                ItemStack.OPTIONAL_STREAM_CODEC.encode(buffer, output.output);
            }
        }
    };

    public static final StreamCodec<RegistryFriendlyByteBuf, OutputItemWithPercent> STREAM_CODEC = new StreamCodec<>() {
        @Override
        @NotNull
        public OutputItemWithPercent decode(@NotNull RegistryFriendlyByteBuf buffer) {
            OutputItemWithPercent ingredient = OutputItemWithPercent.OPTIONAL_STREAM_CODEC.decode(buffer);
            if(ingredient.isEmpty())
                throw new DecoderException("Empty OutputItemWithPercent not allowed");

            return ingredient;
        }

        @Override
        public void encode(@NotNull RegistryFriendlyByteBuf buffer, OutputItemWithPercent output) {
            if(output.isEmpty())
                throw new DecoderException("Empty OutputItemWithPercent not allowed");

            OutputItemWithPercent.OPTIONAL_STREAM_CODEC.encode(buffer, output);
        }
    };
}