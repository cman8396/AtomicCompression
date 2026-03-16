package com.mcnair.atomic.recipe.base.input;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.handler.codec.DecoderException;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

public record InputItemWithCount(Ingredient input, int count) {
    public InputItemWithCount(Ingredient input) {
        this(input, 1);
    }

    public static final Codec<InputItemWithCount> CODEC = RecordCodecBuilder.create((instance) -> {
        return instance.group(Ingredient.CODEC.fieldOf("ingredient").forGetter((input) -> {
            return input.input;
        }), ExtraCodecs.POSITIVE_INT.optionalFieldOf("count", 1).forGetter((input) -> {
            return input.count;
        })).apply(instance, InputItemWithCount::new);
    });

    public static final StreamCodec<RegistryFriendlyByteBuf, InputItemWithCount> STREAM_CODEC = new StreamCodec<>() {
        @Override
        @NotNull
        public InputItemWithCount decode(@NotNull RegistryFriendlyByteBuf buffer) {
            int count = buffer.readInt();
            if(count <= 0)
                throw new DecoderException("Empty InputItemWithCount not allowed");

            Ingredient input = Ingredient.CONTENTS_STREAM_CODEC.decode(buffer);
            return new InputItemWithCount(input, count);
        }

        @Override
        public void encode(@NotNull RegistryFriendlyByteBuf buffer, InputItemWithCount ingredient) {
            if(ingredient.count <= 0)
                throw new DecoderException("Empty InputItemWithCount not allowed");

            buffer.writeInt(ingredient.count);
            Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, ingredient.input);
        }
    };
}