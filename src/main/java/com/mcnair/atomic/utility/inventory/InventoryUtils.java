package com.mcnair.atomic.utility.inventory;

import com.mcnair.atomic.recipe.recipes.ExplosiveCompactorRecipe;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;

public final class InventoryUtils {
    private InventoryUtils() {}

    public static boolean canOutputSlotsAcceptRecipeOutput(RecipeHolder<ExplosiveCompactorRecipe> recipe, AtomicItemStackProvider itemHandler, int[] availableOutputSlots) {
        ItemStack[] recipeOutputItems = recipe.value().getMaxOutputCounts();

        // Loop through the outputs of the recipe and check if the output slots can take them.
        for (int i = 0; i < recipeOutputItems.length; i++) {
            ItemStack output = recipeOutputItems[i];

            // Check if the slot is empty, or the item in the slot is the same as the output item.
            if (itemHandler.getStackInSlot(availableOutputSlots[i]).isEmpty() || itemHandler.getStackInSlot(availableOutputSlots[i]).getItem() == output.getItem()) {

                // If the slot is empty, assume the maximum item count is 64, otherwise get the item stack size.
                int maxCountForItem = itemHandler.getStackInSlot(availableOutputSlots[i]).isEmpty() ? 64 : itemHandler.getStackInSlot(availableOutputSlots[i]).getMaxStackSize();
                // Get the current count in the slot.
                int currentSlotCount = itemHandler.getStackInSlot(availableOutputSlots[i]).getCount();

                // If the current slot count + recipe output count would be greater than the max stack size, fail.
                if (currentSlotCount + output.getCount() > maxCountForItem) {
                    return false;
                }
            }
        }

        return true;
    }
}