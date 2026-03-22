package com.mcnair.atomic.recipe.recipes;

import com.mcnair.atomic.AtomicCompression;
import com.mcnair.atomic.recipe.AtomicRecipes;
import com.mcnair.atomic.recipe.base.MachineBasicRecipe;
import com.mcnair.atomic.recipe.base.input.InputItemWithCount;
import com.mcnair.atomic.recipe.base.output.OutputItemWithPercent;
import com.mcnair.atomic.utility.external.ArrayCodec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.Identifier;
import net.minecraft.server.dialog.Input;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ExplosiveRefinerRecipe implements MachineBasicRecipe<RecipeInput> {
    private final ItemStack output;
    private final OutputItemWithPercent secondaryOutput;
    private final InputItemWithCount[] inputs;

    public ExplosiveRefinerRecipe(ItemStack output, OutputItemWithPercent secondaryOutput, InputItemWithCount[] inputs) {
        this.output = output;
        this.secondaryOutput = secondaryOutput;
        this.inputs = inputs;
    }

    public ItemStack getOutput() {
        return output;
    }

    public OutputItemWithPercent getSecondaryOutput() {
        return secondaryOutput;
    }

    public InputItemWithCount[] getInputs() {
        return inputs;
    }

    public ItemStack[] getMaxOutputCounts() {
        ItemStack[] generatedOutputs = new ItemStack[2];

        generatedOutputs[0] = output.copyWithCount(output.getCount());
        generatedOutputs[1] = secondaryOutput.output().copyWithCount(secondaryOutput.percentages().length);

        return generatedOutputs;
    }

    public ItemStack[] generateOutputs(RandomSource randomSource) {
        ItemStack[] generatedOutputs = new ItemStack[2];

        generatedOutputs[0] = output.copyWithCount(output.getCount());

        int count = 0;
        for (double percentage : secondaryOutput.percentages())
            if (randomSource.nextDouble() <= percentage)
                count++;

        generatedOutputs[1] = secondaryOutput.output().copyWithCount(count);

        return generatedOutputs;
    }

    @Override
    public boolean matches(RecipeInput container, Level level) {
        if (level.isClientSide())
            return false;

        boolean[] usedIndices = new boolean[3];
        for (int i = 0; i < 3; i++)
            usedIndices[i] = container.getItem(i).isEmpty();

        int len = Math.min(inputs.length, 3);
        for (int i = 0; i < len; i++) {
            InputItemWithCount input = inputs[i];

            int indexMinCount = -1;
            int minCount = Integer.MAX_VALUE;

            for (int j = 0; j < 3; j++) {
                if (usedIndices[j])
                    continue;

                ItemStack item = container.getItem(j);

                if ((indexMinCount == -1 || item.getCount() < minCount) && input.input().test(item) &&
                        item.getCount() >= input.count()) {
                    indexMinCount = j;
                    minCount = item.getCount();
                }
            }

            if (indexMinCount == -1)
                return false; //Ingredient did not match any item

            usedIndices[indexMinCount] = true;
        }

        for (boolean usedIndex : usedIndices)
            if (!usedIndex) //Unused items present
                return false;

        return true;
    }

    @Override
    public ItemStack assemble(RecipeInput container, HolderLookup.Provider registries) {
        return ItemStack.EMPTY;
    }

    @Override
    public PlacementInfo placementInfo() {
        return PlacementInfo.NOT_PLACEABLE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    @Override
    public RecipeSerializer<? extends Recipe<RecipeInput>> getSerializer() {
        return ExplosiveRefinerRecipe.Serializer.INSTANCE;
    }

    @Override
    public RecipeType<? extends Recipe<RecipeInput>> getType() {
        return ExplosiveRefinerRecipe.Type.INSTANCE;
    }

    @Override
    public List<Ingredient> getIngredients() {
        return Arrays.stream(inputs).map(InputItemWithCount::input).toList();
    }

    @Override
    public boolean isIngredient(ItemStack itemStack) {
        return Arrays.stream(inputs).map(InputItemWithCount::input).anyMatch(ingredient -> ingredient.test(itemStack));
    }

    @Override
    public boolean isResult(ItemStack itemStack) {
        return ItemStack.isSameItemSameComponents(output, itemStack) || (secondaryOutput != null &&
                ItemStack.isSameItemSameComponents(secondaryOutput.output(), itemStack));
    }

    public static final class Type implements RecipeType<ExplosiveRefinerRecipe> {
        private Type() {
        }

        public static final ExplosiveRefinerRecipe.Type INSTANCE = new ExplosiveRefinerRecipe.Type();
        public static final String ID = AtomicRecipes.Types.EXPLOSIVE_REFINER;
    }

    public static final class Serializer implements RecipeSerializer<ExplosiveRefinerRecipe> {
        private Serializer() {
        }

        public static final ExplosiveRefinerRecipe.Serializer INSTANCE = new ExplosiveRefinerRecipe.Serializer();
        public static final Identifier ID = Identifier.fromNamespaceAndPath(AtomicCompression.MOD_ID, AtomicRecipes.Types.EXPLOSIVE_REFINER);

        private final MapCodec<ExplosiveRefinerRecipe> CODEC = RecordCodecBuilder.mapCodec((instance) -> {
            return instance.group(
                    ItemStack.CODEC.fieldOf("result").forGetter((recipe) -> {
                        return recipe.output;
                    }), OutputItemWithPercent.CODEC_NONEMPTY.optionalFieldOf("secondaryResult").forGetter((recipe) -> {
                        return Optional.ofNullable(recipe.secondaryOutput.isEmpty() ? null : recipe.secondaryOutput);
                    }), new ArrayCodec<>(InputItemWithCount.CODEC, InputItemWithCount[]::new).fieldOf("ingredients").forGetter((recipe) -> {
                        return recipe.inputs;
                    })
            ).apply(instance, (output, secondaryOutput, inputs) -> new ExplosiveRefinerRecipe(output,
                    secondaryOutput.orElse(OutputItemWithPercent.EMPTY), inputs));
        });

        private final StreamCodec<RegistryFriendlyByteBuf, ExplosiveRefinerRecipe> STREAM_CODEC = StreamCodec.of(
                ExplosiveRefinerRecipe.Serializer::write, ExplosiveRefinerRecipe.Serializer::read);

        @Override
        public MapCodec<ExplosiveRefinerRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, ExplosiveRefinerRecipe> streamCodec() {
            return STREAM_CODEC;
        }

        private static ExplosiveRefinerRecipe read(RegistryFriendlyByteBuf buffer) {
            int len = buffer.readInt();
            InputItemWithCount[] inputs = new InputItemWithCount[len];
            for (int i = 0; i < len; i++)
                inputs[i] = InputItemWithCount.STREAM_CODEC.decode(buffer);

            ItemStack output = ItemStack.OPTIONAL_STREAM_CODEC.decode(buffer);

            OutputItemWithPercent secondaryOutput = OutputItemWithPercent.OPTIONAL_STREAM_CODEC.decode(buffer);

            return new ExplosiveRefinerRecipe(output, secondaryOutput, inputs);
        }

        private static void write(RegistryFriendlyByteBuf buffer, ExplosiveRefinerRecipe recipe) {
            buffer.writeInt(recipe.inputs.length);
            for (int i = 0; i < recipe.inputs.length; i++)
                InputItemWithCount.STREAM_CODEC.encode(buffer, recipe.inputs[i]);

            ItemStack.OPTIONAL_STREAM_CODEC.encode(buffer, recipe.output);

            OutputItemWithPercent.OPTIONAL_STREAM_CODEC.encode(buffer, recipe.secondaryOutput);
        }
    }
}
