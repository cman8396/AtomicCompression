package com.mcnair.atomic.utility.inventory.slot;

import com.mcnair.atomic.utility.AtomicTags;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.transfer.IndexModifier;
import net.neoforged.neoforge.transfer.ResourceHandler;
import net.neoforged.neoforge.transfer.item.ItemResource;
import net.neoforged.neoforge.transfer.item.ResourceHandlerSlot;

import javax.annotation.Nonnull;

public class TagLimitedSlot extends ResourceHandlerSlot {

    public String tag;

    public TagLimitedSlot(ResourceHandler<ItemResource> itemHandler, IndexModifier<ItemResource> slotModifier, int index, int xPosition, int yPosition, String tagToMatch) {
        super(itemHandler, slotModifier, index, xPosition, yPosition);
        this.tag = tagToMatch;
        this.setChanged();
    }

    @Override
    public boolean mayPlace(@Nonnull ItemStack stack) {
        return AtomicTags.Helpers.doesItemStackTagMatch(tag,  stack);
    }
}