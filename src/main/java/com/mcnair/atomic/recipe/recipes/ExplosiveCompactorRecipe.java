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

public record ExplosiveCompactorRecipe(Ingredient inputItem, ItemStack output) implements Recipe<ExplosiveCompactorRecipeInput> {
    // inputItem & output ==> Read From JSON File!
    // ExplosiveCompactorRecipeInput --> INVENTORY of the Block Entity

    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(inputItem);
        return list;
    }

    @Override
    public boolean matches(ExplosiveCompactorRecipeInput explosiveCompactorRecipeInput, Level level) {
        if (level.isClientSide()) {
            return false;
        }

        return inputItem.test(explosiveCompactorRecipeInput.getItem(0));
    }

    @Override
    public ItemStack assemble(ExplosiveCompactorRecipeInput explosiveCompactorRecipeInput, HolderLookup.Provider provider) {
        return output.copy();
    }

    @Override
    public RecipeSerializer<? extends Recipe<ExplosiveCompactorRecipeInput>> getSerializer() {
        return AtomicRecipes.EXPLOSIVE_COMPACTOR_SERIALIZER.get();
    }

    @Override
    public RecipeType<? extends Recipe<ExplosiveCompactorRecipeInput>> getType() {
        return AtomicRecipes.EXPLOSIVE_COMPACTOR_TYPE.get();
    }

    @Override
    public PlacementInfo placementInfo() {
        return PlacementInfo.create(inputItem);
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    public static class Serializer implements RecipeSerializer<ExplosiveCompactorRecipe> {
        public static final MapCodec<ExplosiveCompactorRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC.fieldOf("ingredient").forGetter(ExplosiveCompactorRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(ExplosiveCompactorRecipe::output)
        ).apply(inst, ExplosiveCompactorRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, ExplosiveCompactorRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC, ExplosiveCompactorRecipe::inputItem,
                        ItemStack.STREAM_CODEC, ExplosiveCompactorRecipe::output,
                        ExplosiveCompactorRecipe::new);

        @Override
        public MapCodec<ExplosiveCompactorRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, ExplosiveCompactorRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
