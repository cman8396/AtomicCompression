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

public record ExplosiveRefinerRecipe(Ingredient inputItem, ItemStack output) implements Recipe<ExplosiveRefinerRecipeInput> {
    // inputItem & output ==> Read From JSON File!
    // ExplosiveRefinerRecipeInput --> INVENTORY of the Block Entity

    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(inputItem);
        return list;
    }

    @Override
    public boolean matches(ExplosiveRefinerRecipeInput explosiveRefinerRecipeInput, Level level) {
        if (level.isClientSide()) {
            return false;
        }

        return inputItem.test(explosiveRefinerRecipeInput.getItem(0));
    }

    @Override
    public ItemStack assemble(ExplosiveRefinerRecipeInput explosiveRefinerRecipeInput, HolderLookup.Provider provider) {
        return output.copy();
    }

    @Override
    public RecipeSerializer<? extends Recipe<ExplosiveRefinerRecipeInput>> getSerializer() {
        return AtomicRecipes.EXPLOSIVE_REFINER_SERIALIZER.get();
    }

    @Override
    public RecipeType<? extends Recipe<ExplosiveRefinerRecipeInput>> getType() {
        return AtomicRecipes.EXPLOSIVE_REFINER_TYPE.get();
    }

    @Override
    public PlacementInfo placementInfo() {
        return PlacementInfo.create(inputItem);
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    public static class Serializer implements RecipeSerializer<ExplosiveRefinerRecipe> {
        public static final MapCodec<ExplosiveRefinerRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC.fieldOf("ingredient").forGetter(ExplosiveRefinerRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(ExplosiveRefinerRecipe::output)
        ).apply(inst, ExplosiveRefinerRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, ExplosiveRefinerRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC, ExplosiveRefinerRecipe::inputItem,
                        ItemStack.STREAM_CODEC, ExplosiveRefinerRecipe::output,
                        ExplosiveRefinerRecipe::new);

        @Override
        public MapCodec<ExplosiveRefinerRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, ExplosiveRefinerRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
