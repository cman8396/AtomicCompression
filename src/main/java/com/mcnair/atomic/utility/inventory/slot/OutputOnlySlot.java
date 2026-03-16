package com.mcnair.atomic.utility.inventory.slot;

import com.mcnair.atomic.utility.AtomicTags;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.transfer.IndexModifier;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.item.ResourceHandlerSlot;

import javax.annotation.Nonnull;

public class OutputOnlySlot extends ResourceHandlerSlot {

    public OutputOnlySlot(ResourceHandler<ItemResource> itemHandler, IndexModifier<ItemResource> slotModifier, int index, int xPosition, int yPosition) {
        super(itemHandler, slotModifier, index, xPosition, yPosition);
        this.setChanged();
    }

    @Override
    public boolean mayPlace(@Nonnull ItemStack stack) {
        return false;
    }
}