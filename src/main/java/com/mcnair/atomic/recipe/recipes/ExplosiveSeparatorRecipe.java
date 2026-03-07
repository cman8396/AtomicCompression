package com.mcnair.atomic.recipe.recipes;

import com.mcnair.atomic.recipe.AtomicRecipes;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

public record ExplosiveSeparatorRecipe(Ingredient inputItem, ItemStack output) implements Recipe<ExplosiveSeparatorRecipeInput> {
    // inputItem & output ==> Read From JSON File!
    // ExplosiveSeparatorRecipeInput --> INVENTORY of the Block Entity

    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(inputItem);
        return list;
    }

    @Override
    public boolean matches(ExplosiveSeparatorRecipeInput explosiveSeparatorRecipeInput, Level level) {
        if (level.isClientSide()) {
            return false;
        }

        return inputItem.test(explosiveSeparatorRecipeInput.getItem(0));
    }

    @Override
    public ItemStack assemble(ExplosiveSeparatorRecipeInput explosiveSeparatorRecipeInput, HolderLookup.Provider provider) {
        return output.copy();
    }

    @Override
    public RecipeSerializer<? extends Recipe<ExplosiveSeparatorRecipeInput>> getSerializer() {
        return AtomicRecipes.EXPLOSIVE_SEPARATOR_SERIALIZER.get();
    }

    @Override
    public RecipeType<? extends Recipe<ExplosiveSeparatorRecipeInput>> getType() {
        return AtomicRecipes.EXPLOSIVE_SEPARATOR_TYPE.get();
    }

    @Override
    public PlacementInfo placementInfo() {
        return PlacementInfo.create(inputItem);
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    public static class Serializer implements RecipeSerializer<ExplosiveSeparatorRecipe> {
        public static final MapCodec<ExplosiveSeparatorRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC.fieldOf("ingredient").forGetter(ExplosiveSeparatorRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(ExplosiveSeparatorRecipe::output)
        ).apply(inst, ExplosiveSeparatorRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, ExplosiveSeparatorRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC, ExplosiveSeparatorRecipe::inputItem,
                        ItemStack.STREAM_CODEC, ExplosiveSeparatorRecipe::output,
                        ExplosiveSeparatorRecipe::new);

        @Override
        public MapCodec<ExplosiveSeparatorRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, ExplosiveSeparatorRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
