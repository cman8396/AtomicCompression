package com.mcnair.atomic.datagen.tags;

import com.mcnair.atomic.AtomicCompression;
import com.mcnair.atomic.block.AtomicBlocks;
import com.mcnair.atomic.item.AtomicItems;
import com.mcnair.atomic.utility.AtomicTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class AtomicItemTagProvider extends ItemTagsProvider {
    public AtomicItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, AtomicCompression.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(AtomicTags.Items.BUNGERITE_ALLOY_REPAIRABLE)
                .add(AtomicItems.BUNGERITE_ALLOY_INGOT.get());

        tag(ItemTags.SWORDS)
                .add(AtomicItems.BUNGERITE_ALLOY_SWORD.get());
        tag(ItemTags.SPEARS)
                .add(AtomicItems.BUNGERITE_ALLOY_SPEAR.get());
        tag(ItemTags.PICKAXES)
                .add(AtomicItems.BUNGERITE_ALLOY_PICKAXE.get());
        tag(ItemTags.SHOVELS)
                .add(AtomicItems.BUNGERITE_ALLOY_SHOVEL.get());
        tag(ItemTags.AXES)
                .add(AtomicItems.BUNGERITE_ALLOY_AXE.get());
        tag(ItemTags.HOES)
                .add(AtomicItems.BUNGERITE_ALLOY_HOE.get());

//        tag(ItemTags.TRIMMABLE_ARMOR)
//                .add(AtomicItems.BISMUTH_HELMET.get())
//                .add(AtomicItems.BISMUTH_CHESTPLATE.get())
//                .add(AtomicItems.BISMUTH_LEGGINGS.get())
//                .add(AtomicItems.BISMUTH_BOOTS.get());

        tag(ItemTags.TRIM_MATERIALS)
                .add(AtomicItems.BUNGERITE_ALLOY_INGOT.get());

        tag(ItemTags.LOGS_THAT_BURN)
                .add(AtomicBlocks.ASHENWOOD_LOG.get().asItem())
                .add(AtomicBlocks.ASHENWOOD_WOOD.get().asItem())
                .add(AtomicBlocks.STRIPPED_ASHENWOOD_LOG.get().asItem())
                .add(AtomicBlocks.STRIPPED_ASHENWOOD_WOOD.get().asItem());

        tag(ItemTags.PLANKS)
                .add(AtomicBlocks.ASHENWOOD_PLANKS.asItem());

        tag(ItemTags.WOODEN_DOORS)
                .add(AtomicBlocks.ASHENWOOD_DOOR.asItem());

        tag(AtomicTags.Items.MACHINE_IGNITION)
                .add(Items.FLINT_AND_STEEL);

        tag(AtomicTags.Items.MACHINE_CASING)
                .add(AtomicItems.REFINED_BUNGERITE_MACHINE_CASING.asItem());

        tag(AtomicTags.Items.MACHINE_CASING_REFINED_BUNGERITE)
                .add(AtomicItems.REFINED_BUNGERITE_MACHINE_CASING.asItem());

    }
}
