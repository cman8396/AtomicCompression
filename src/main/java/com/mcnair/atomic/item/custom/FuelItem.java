package com.mcnair.atomic.item.custom;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.entity.FuelValues;
import org.jspecify.annotations.NonNull;

import javax.annotation.Nullable;

public class FuelItem extends Item {
    private int burnTime = 0;

    public FuelItem(Properties properties, int burnTime) {
        super(properties);
        this.burnTime = burnTime;
    }

    @Override
    public int getBurnTime(@NonNull ItemStack itemStack, @Nullable RecipeType<?> recipeType, @NonNull FuelValues fuelValues) {
        return this.burnTime;
    }
}