package com.mcnair.atomic.utility.inventory;

import com.mcnair.atomic.utility.AtomicTags;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

import javax.annotation.Nullable;

public final class InventoryUtils {
    private InventoryUtils() {}

    public static boolean canOutputSlotsAcceptRecipeOutput(ItemStack[] recipeOutputItems, AtomicItemStackProvider itemHandler, int[] availableOutputSlots) {
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

    public static String getCasingType(int casingSlot, AtomicItemStackProvider itemHandler) {
        ItemStack stackInCasingSlot = itemHandler.getStackInSlot(casingSlot);
        if (AtomicTags.Helpers.doesItemStackTagMatch(AtomicTags.Values.MACHINE_CASING_REFINED_BUNGERITE, stackInCasingSlot))
            return "refined_bungerite";
        else
            return "none";
    }

    public static boolean rollForChance(@Nullable Level level, double percentage) {
        assert level != null;
        return (level.random.nextDouble() <= percentage);
    }

    public static SimpleContainer parseInventory(int[] inputSlots, AtomicItemStackProvider itemHandler) {
        /*
         * Converts the actual block entity inventory to a new inventory that only contains the input slots.
         * This is used to find the recipe we're working with.
         */
        SimpleContainer inventory = new SimpleContainer(inputSlots.length);
        for (int i = 0; i < inputSlots.length; i++)
            inventory.setItem(i, itemHandler.getStackInSlot(inputSlots[i]));

        return inventory;
    }
}