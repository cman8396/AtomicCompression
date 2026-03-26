package com.mcnair.atomic.recipe.recipes;

import com.mcnair.atomic.AtomicCompression;
import com.mcnair.atomic.recipe.AtomicRecipes;
import com.mcnair.atomic.recipe.base.MachineBasicRecipe;
import com.mcnair.atomic.recipe.base.output.OutputItemWithPercent;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.Identifier;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Optional;


public class ExplosiveInfuserRecipe implements MachineBasicRecipe<RecipeInput> {
    private final ItemStack output;
    private final OutputItemWithPercent secondaryOutput;
    private final Ingredient input;

    public ExplosiveInfuserRecipe(ItemStack output, OutputItemWithPercent secondaryOutput, Ingredient input) {
        this.output = output;
        this.secondaryOutput = secondaryOutput;
        this.input = input;
    }

    public ItemStack getOutput() {
        return output;
    }

    public OutputItemWithPercent getSecondaryOutput() {
        return secondaryOutput;
    }

    public Ingredient getInput() {
        return input;
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

        int secondaryCount = 0;
        for (double percentage : secondaryOutput.percentages())
            if (randomSource.nextDouble() <= percentage)
                secondaryCount++;

        generatedOutputs[1] = secondaryOutput.output().copyWithCount(secondaryCount);
        
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
        return ExplosiveInfuserRecipe.Serializer.INSTANCE;
    }

    @Override
    public RecipeType<? extends Recipe<RecipeInput>> getType() {
        return ExplosiveInfuserRecipe.Type.INSTANCE;
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
                ItemStack.isSameItemSameComponents(secondaryOutput.output(), itemStack));
    }

    public static final class Type implements RecipeType<ExplosiveInfuserRecipe> {
        private Type() {
        }

        public static final ExplosiveInfuserRecipe.Type INSTANCE = new ExplosiveInfuserRecipe.Type();
        public static final String ID = AtomicRecipes.Types.EXPLOSIVE_INFUSER;
    }

    public static final class Serializer implements RecipeSerializer<ExplosiveInfuserRecipe> {
        private Serializer() {
        }

        public static final ExplosiveInfuserRecipe.Serializer INSTANCE = new ExplosiveInfuserRecipe.Serializer();
        public static final Identifier ID = Identifier.fromNamespaceAndPath(AtomicCompression.MOD_ID, AtomicRecipes.Types.EXPLOSIVE_INFUSER);

        private final MapCodec<ExplosiveInfuserRecipe> CODEC = RecordCodecBuilder.mapCodec((instance) -> {
            return instance.group(
                    ItemStack.CODEC.fieldOf("result").forGetter((recipe) -> {
                        return recipe.output;
                    }), OutputItemWithPercent.CODEC_NONEMPTY.optionalFieldOf("secondaryResult").forGetter((recipe) -> {
                        return Optional.ofNullable(recipe.secondaryOutput.isEmpty() ? null : recipe.secondaryOutput);
                    }),   Ingredient.CODEC.fieldOf("ingredient").forGetter((recipe) -> {
                        return recipe.input;
                    })
            ).apply(instance, (output, secondaryOutput, input) -> new ExplosiveInfuserRecipe(output,
                    secondaryOutput.orElse(OutputItemWithPercent.EMPTY), input));
        });

        private final StreamCodec<RegistryFriendlyByteBuf, ExplosiveInfuserRecipe> STREAM_CODEC = StreamCodec.of(
                ExplosiveInfuserRecipe.Serializer::write, ExplosiveInfuserRecipe.Serializer::read);

        @Override
        public MapCodec<ExplosiveInfuserRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, ExplosiveInfuserRecipe> streamCodec() {
            return STREAM_CODEC;
        }

        private static ExplosiveInfuserRecipe read(RegistryFriendlyByteBuf buffer) {
            Ingredient input = Ingredient.CONTENTS_STREAM_CODEC.decode(buffer);

            ItemStack output = ItemStack.OPTIONAL_STREAM_CODEC.decode(buffer);

            OutputItemWithPercent secondaryOutput = OutputItemWithPercent.OPTIONAL_STREAM_CODEC.decode(buffer);

            return new ExplosiveInfuserRecipe(output, secondaryOutput, input);
        }

        private static void write(RegistryFriendlyByteBuf buffer, ExplosiveInfuserRecipe recipe) {
            Ingredient.CONTENTS_STREAM_CODEC.encode(buffer, recipe.input);

            ItemStack.OPTIONAL_STREAM_CODEC.encode(buffer, recipe.output);

            OutputItemWithPercent.OPTIONAL_STREAM_CODEC.encode(buffer, recipe.secondaryOutput);
        }
    }
}