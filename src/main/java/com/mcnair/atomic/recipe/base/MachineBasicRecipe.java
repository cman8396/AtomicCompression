package com.mcnair.atomic.recipe.base;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeInput;

import java.util.List;

public interface MachineBasicRecipe<T extends RecipeInput> extends Recipe<T> {
    List<Ingredient> getIngredients();
    boolean isResult(ItemStack itemStack);
    boolean isIngredient(ItemStack itemStack);
}