package com.mcnair.atomic.datagen;

import com.mcnair.atomic.AtomicCompression;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ItemTagsProvider;

import java.util.concurrent.CompletableFuture;

public class AtomicItemTagProvider extends ItemTagsProvider {
    public AtomicItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, AtomicCompression.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
//        tag(AtomicTags.Items.TRANSFORMABLE_ITEMS)
//                .add(AtomicItems.BISMUTH.get())
//                .add(AtomicItems.RAW_BISMUTH.get())
//                .add(Items.COAL)
//                .add(Items.STICK)
//                .add(Items.COMPASS);
//
//        tag(AtomicTags.Items.BISMUTH_REPAIRABLE)
//                .add(AtomicItems.BISMUTH.get());
//
//        tag(ItemTags.SWORDS)
//                .add(AtomicItems.BISMUTH_SWORD.get());
//        tag(ItemTags.PICKAXES)
//                .add(AtomicItems.BISMUTH_PICKAXE.get());
//        tag(ItemTags.SHOVELS)
//                .add(AtomicItems.BISMUTH_SHOVEL.get());
//        tag(ItemTags.AXES)
//                .add(AtomicItems.BISMUTH_AXE.get());
//        tag(ItemTags.HOES)
//                .add(AtomicItems.BISMUTH_HOE.get());
//
//        this.tag(ItemTags.TRIMMABLE_ARMOR)
//                .add(AtomicItems.BISMUTH_HELMET.get())
//                .add(AtomicItems.BISMUTH_CHESTPLATE.get())
//                .add(AtomicItems.BISMUTH_LEGGINGS.get())
//                .add(AtomicItems.BISMUTH_BOOTS.get());
//
//        this.tag(ItemTags.TRIM_MATERIALS)
//                .add(AtomicItems.BISMUTH.get());
//
//        this.tag(ItemTags.LOGS_THAT_BURN)
//                .add(AtomicBlocks.BLOODWOOD_LOG.get().asItem())
//                .add(AtomicBlocks.BLOODWOOD_WOOD.get().asItem())
//                .add(AtomicBlocks.STRIPPED_BLOODWOOD_LOG.get().asItem())
//                .add(AtomicBlocks.STRIPPED_BLOODWOOD_WOOD.get().asItem());
//
//        this.tag(ItemTags.PLANKS)
//                .add(AtomicBlocks.BLOODWOOD_PLANKS.asItem());
    }
}
