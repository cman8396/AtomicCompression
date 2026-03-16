package com.mcnair.atomic.recipe.base;

import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

public class MachineBaseRecipeInputHelper implements RecipeInput {
    private final Container inventory;

    public MachineBaseRecipeInputHelper(Container inventory) {
        this.inventory = inventory;
    }

    @Override
    public ItemStack getItem(int slot) {
        return inventory.getItem(slot);
    }

    @Override
    public int size() {
        return inventory.getContainerSize();
    }
}