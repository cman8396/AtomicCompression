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
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ExplosiveSeparatorRecipe implements MachineBasicRecipe<RecipeInput> {
    private final ItemStack output;
    private final OutputItemWithPercent secondaryOutput;
    private final OutputItemWithPercent tertiaryOutput;
    private final Ingredient input;

    public ExplosiveSeparatorRecipe(ItemStack output, OutputItemWithPercent secondaryOutput, OutputItemWithPercent tertiaryOutput, Ingredient input) {
        this.output = output;
        this.secondaryOutput = secondaryOutput;
        this.tertiaryOutput = tertiaryOutput;
        this.input = input;
    }

    public ItemStack getOutput() {
        return output;
    }

    public OutputItemWithPercent getSecondaryOutput() {
        return secondaryOutput;
    }

    public OutputItemWithPercent getTertiaryOutput() {
        return tertiaryOutput;
    }

    public Ingredient getInput() {
        return input;
    }

    public ItemStack[] getMaxOutputCounts() {
        ItemStack[] generatedOutputs = new ItemStack[3];

        generatedOutputs[0] = output.copyWithCount(output.getCount());
        generatedOutputs[1] = secondaryOutput.output().copyWithCount(secondaryOutput.percentages().length);
        generatedOutputs[2] = tertiaryOutput.output().copyWithCount(tertiaryOutput.percentages().length);

        return generatedOutputs;
    }

    public ItemStack[] generateOutputs(RandomSource randomSource) {
        ItemStack[] generatedOutputs = new ItemStack[3];

        generatedOutputs[0] = output.copyWithCount(output.getCount());

        int secondaryCount = 0;
        for (double percentage : secondaryOutput.percentages())
            if (randomSource.nextDouble() <= percentage)
                secondaryCount++;

        generatedOutputs[1] = secondaryOutput.output().copyWithCount(secondaryCount);

        int tertiaryCount = 0;
        for (double percentage : tertiaryOutput.percentages())
            if (randomSource.nextDouble() <= percentage)
                tertiaryCount++;

        generatedOutputs[2] = tertiaryOutput.output().copyWithCount(tertiaryCount);

        return generatedOutputs;
    }

    @Override
    public boolean matches(RecipeInput container, Level level) {
        if(level.isClientSide())
            return false;

        return input.test(container.getItem(0));
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
        return ExplosiveSeparatorRecipe.Serializer.INSTANCE;
    }

    @Override
    public RecipeType<? extends Recipe<RecipeInput>> getType() {
        return ExplosiveSeparatorRecipe.Type.INSTANCE;
    }

    @Override
    public List<Ingredient> getIngredients() {
        return List.of(input);
    }

    @Override
    public boolean isIngredient(ItemStack itemStack) {
        return input.test(itemStack);
    }

    @Override
    public boolean isResult(ItemStack itemStack) {
        return ItemStack.isSameItemSameComponents(output, itemStack) || (secondaryOutput != null &&
                ItemStack.isSameItemSameComponents(secondaryOutput.output(), itemStack)) || (tertiaryOutput != null &&
                ItemStack.isSameItemSameComponents(tertiaryOutput.output(), itemStack));
    }

    public static final class Type implements RecipeType<ExplosiveSeparatorRecipe> {
        private Type() {
        }

        public static final ExplosiveSeparatorRecipe.Type INSTANCE = new ExplosiveSeparatorRecipe.Type();
        public static final String ID = AtomicRecipes.Types.EXPLOSIVE_SEPARATOR;
    }

    public static final class Serializer implements RecipeSerializer<ExplosiveSeparatorRecipe> {
        private Serializer() {
        }

        public static final ExplosiveSeparatorRecipe.Serializer INSTANCE = new ExplosiveSeparatorRecipe.Serializer();
        public static final Identifier ID = Identifier.fromNamespaceAndPath(AtomicCompression.MOD_ID, AtomicRecipes.Types.EXPLOSIVE_SEPARATOR);

        private final MapCodec<ExplosiveSeparatorRecipe> CODEC = RecordCodecBuilder.mapCodec((instance) -> {
            return instance.group(
                    ItemStack.CODEC.fieldOf("result").forGetter((recipe) -> {
                        return recipe.output;
                    }), OutputItemWithPercent.CODEC_NONEMPTY.optionalFieldOf("secondaryResult").forGetter((recipe) -> {
                        return Optional.ofNullable(recipe.secondaryOutput.isEmpty() ? null : recipe.secondaryOutput);
                    }), OutputItemWithPercent.CODEC_NONEMPTY.optionalFieldOf("tertiaryResult").forGetter((recipe) -> {
                        return Optional.ofNullable(recipe.tertiaryOutput.isEmpty() ? null : recipe.tertiaryOutput);
                    }),  Ingredient.CODEC.fieldOf("ingredient").forGetter((recipe) -> {
                        return recipe.input;
                    })
            ).apply(instance, (output, secondaryOutput, tertiaryOutput, input) -> new ExplosiveSeparatorRecipe(output,
                    secondaryOutput.orElse(OutputItemWithPercent.EMPTY), tertiaryOutput.orElse(OutputItemWithPercent.EMPTY), input));
        });

        private final StreamCodec<RegistryFriendlyByteBuf, ExplosiveSeparatorRecipe> STREAM_CODEC = StreamCodec.of(
                ExplosiveSeparatorRecipe.Serializer::write, ExplosiveSeparatorRecipe.Serializer::read);

        @Override
        public MapCodec<ExplosiveSeparatorRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, ExplosiveSeparatorRecipe> streamCodec() {
            return STREAM_CODEC;
        }

        private static ExplosiveSeparatorRecipe read(RegistryFriendlyByteBuf buffer) {
            Ingredient input = Ingredient.CONTENTS_STREAM_CODEC.decode(buffer);

            ItemStack output = ItemStack.OPTIONAL_STREAM_CODEC.decode(buffer);

            OutputItemWithPercent secondaryOutput = OutputItemWithPercent.OPTIONAL_STREAM_CODEC.decode(buffer);

            OutputItemWithPercent tertiaryOutput = OutputItemWithPercent.OPTIONAL_STREAM_CODEC.decode(buffer);

            return new ExplosiveSeparatorRecipe(output, secondaryOutput, tertiaryOutput, input);
        }

        private static void write(RegistryFriendlyByteBuf buffer, ExplosiveSeparatorRecipe recipe) {
            Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, recipe.input);

            ItemStack.OPTIONAL_STREAM_CODEC.encode(buffer, recipe.output);

            OutputItemWithPercent.OPTIONAL_STREAM_CODEC.encode(buffer, recipe.secondaryOutput);

            OutputItemWithPercent.OPTIONAL_STREAM_CODEC.encode(buffer, recipe.tertiaryOutput);
        }
    }
}