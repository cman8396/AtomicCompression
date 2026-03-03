package com.mcnair.atomic.datagen;

import com.mcnair.atomic.AtomicCompression;
import com.mcnair.atomic.block.AtomicBlocks;
import com.mcnair.atomic.utility.AtomicTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;

import java.util.concurrent.CompletableFuture;

public class AtomicBlockTagProvider extends BlockTagsProvider {
    public AtomicBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(output, lookupProvider, AtomicCompression.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        tag(BlockTags.MINEABLE_WITH_SHOVEL)
                .add(AtomicBlocks.GUNPOWDER_BLOCK.get())
                .add(AtomicBlocks.SULFUR_DUST_BLOCK.get())
                .add(AtomicBlocks.SALTPETER_DUST_BLOCK.get());

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(AtomicBlocks.SULFUR_ORE.get())
                .add(AtomicBlocks.DEEPSLATE_SULFUR_ORE.get())
                .add(AtomicBlocks.SALTPETER_ORE.get())
                .add(AtomicBlocks.DEEPSLATE_SALTPETER_ORE.get())
                .add(AtomicBlocks.LEAD_ORE.get())
                .add(AtomicBlocks.DEEPSLATE_LEAD_ORE.get())
                .add(AtomicBlocks.ATOMIC_ORE.get())
                .add(AtomicBlocks.DEEPSLATE_ATOMIC_ORE.get())
                .add(AtomicBlocks.BUNGERITE_ORE.get())
                .add(AtomicBlocks.NETHER_ATOMIC_ORE.get())
                .add(AtomicBlocks.END_ATOMIC_ORE.get())
                .add(AtomicBlocks.DENSE_BASALT.get())
                .add(AtomicBlocks.RAW_SULFUR_BLOCK.get())
                .add(AtomicBlocks.RAW_SALTPETER_BLOCK.get())
                .add(AtomicBlocks.RAW_LEAD_BLOCK.get())
                .add(AtomicBlocks.RAW_BUNGERITE_BLOCK.get())
                .add(AtomicBlocks.LEAD_BLOCK.get())
                .add(AtomicBlocks.REFINED_BUNGERITE_BLOCK.get())
                .add(AtomicBlocks.BUNGERITE_ALLOY_BLOCK.get())
                .add(AtomicBlocks.ATOMIC_BLOCK.get())
                .add(AtomicBlocks.EMPOWERED_ATOMIC_BLOCK.get());

        tag(BlockTags.NEEDS_STONE_TOOL)
                .add(AtomicBlocks.SULFUR_ORE.get())
                .add(AtomicBlocks.DEEPSLATE_SULFUR_ORE.get())
                .add(AtomicBlocks.RAW_SULFUR_BLOCK.get())
                .add(AtomicBlocks.SALTPETER_ORE.get())
                .add(AtomicBlocks.DEEPSLATE_SALTPETER_ORE.get())
                .add(AtomicBlocks.RAW_SALTPETER_BLOCK.get())
                .add(AtomicBlocks.LEAD_ORE.get())
                .add(AtomicBlocks.DEEPSLATE_LEAD_ORE.get())
                .add(AtomicBlocks.LEAD_BLOCK.get())
                .add(AtomicBlocks.RAW_LEAD_BLOCK.get());

        tag(BlockTags.NEEDS_IRON_TOOL)
                .add(AtomicBlocks.ATOMIC_ORE.get())
                .add(AtomicBlocks.DEEPSLATE_ATOMIC_ORE.get())
                .add(AtomicBlocks.NETHER_ATOMIC_ORE.get())
                .add(AtomicBlocks.END_ATOMIC_ORE.get())
                .add(AtomicBlocks.ATOMIC_BLOCK.get())
                .add(AtomicBlocks.EMPOWERED_ATOMIC_BLOCK.get());

        tag(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(AtomicBlocks.BUNGERITE_ORE.get())
                .add(AtomicBlocks.RAW_BUNGERITE_BLOCK.get())
                .add(AtomicBlocks.REFINED_BUNGERITE_BLOCK.get())
                .add(AtomicBlocks.BUNGERITE_ALLOY_BLOCK.get());

        tag(BlockTags.FENCES).
                add(AtomicBlocks.ASHENWOOD_FENCE.get());

        tag(BlockTags.FENCE_GATES)
                .add(AtomicBlocks.ASHENWOOD_FENCE_GATE.get());

        tag(BlockTags.WALLS)
                .add(AtomicBlocks.ASHENWOOD_WALL.get());

        tag(AtomicTags.Blocks.MACHINE)
                .add(AtomicBlocks.EXPLOSIVE_COMPACTOR.get());

        tag(BlockTags.LOGS_THAT_BURN)
                .add(AtomicBlocks.ASHENWOOD_LOG.get())
                .add(AtomicBlocks.ASHENWOOD_WOOD.get())
                .add(AtomicBlocks.STRIPPED_ASHENWOOD_LOG.get())
                .add(AtomicBlocks.STRIPPED_ASHENWOOD_WOOD.get());

//        tag(AtomicTags.Blocks.NEEDS_BISMUTH_TOOL)
//                .add(AtomicBlocks.BISMUTH_LAMP.get())
//                .addTag(BlockTags.NEEDS_IRON_TOOL);
//
//        tag(AtomicTags.Blocks.INCORRECT_FOR_BISMUTH_TOOL)
//                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
//                .remove(AtomicTags.Blocks.NEEDS_BISMUTH_TOOL);

    }
}
