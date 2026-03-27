package com.mcnair.atomic.datagen.tags;

import com.mcnair.atomic.AtomicCompression;
import com.mcnair.atomic.block.AtomicBlocks;
import com.mcnair.atomic.utility.AtomicTags;
import com.mcnair.atomic.utility.common.CommonBlockTags;
import com.mcnair.atomic.utility.common.CommonBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
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


        tag(BlockTags.LOGS_THAT_BURN)
                .add(AtomicBlocks.ASHENWOOD_LOG.get())
                .add(AtomicBlocks.ASHENWOOD_WOOD.get())
                .add(AtomicBlocks.STRIPPED_ASHENWOOD_LOG.get())
                .add(AtomicBlocks.STRIPPED_ASHENWOOD_WOOD.get());

        tag(BlockTags.WOODEN_DOORS)
                .add(AtomicBlocks.ASHENWOOD_DOOR.get());

        tag(AtomicTags.Blocks.MACHINE)
                .add(AtomicBlocks.EXPLOSIVE_MILL.get())
                .add(AtomicBlocks.EXPLOSIVE_COMPACTOR.get())
                .add(AtomicBlocks.EXPLOSIVE_SEPARATOR.get())
                .add(AtomicBlocks.EXPLOSIVE_SMELTER.get())
                .add(AtomicBlocks.EXPLOSIVE_REFINER.get())
                .add(AtomicBlocks.EXPLOSIVE_INFUSER.get());

//        tag(AtomicTags.Blocks.NEEDS_BISMUTH_TOOL)
//                .add(AtomicBlocks.BISMUTH_LAMP.get())
//                .addTag(BlockTags.NEEDS_IRON_TOOL);
//
//        tag(AtomicTags.Blocks.INCORRECT_FOR_BISMUTH_TOOL)
//                .addTag(BlockTags.INCORRECT_FOR_IRON_TOOL)
//                .remove(AtomicTags.Blocks.NEEDS_BISMUTH_TOOL);

        // Storage Blocks
        tag(Tags.Blocks.STORAGE_BLOCKS)
                .addTag(CommonBlockTags.STORAGE_BLOCKS_RAW_SULFUR)
                .addTag(CommonBlockTags.STORAGE_BLOCKS_RAW_SALTPETER)
                .addTag(CommonBlockTags.STORAGE_BLOCKS_RAW_LEAD)
                .addTag(CommonBlockTags.STORAGE_BLOCKS_RAW_BUNGERITE)
                .addTag(CommonBlockTags.STORAGE_BLOCKS_GUNPOWDER)
                .addTag(CommonBlockTags.STORAGE_BLOCKS_SULFUR_DUST)
                .addTag(CommonBlockTags.STORAGE_BLOCKS_SALTPETER_DUST)
                .addTag(CommonBlockTags.STORAGE_BLOCKS_LEAD)
                .addTag(CommonBlockTags.STORAGE_BLOCKS_REFINED_BUNGERITE)
                .addTag(CommonBlockTags.STORAGE_BLOCKS_BUNGERITE_ALLOY)
                .addTag(CommonBlockTags.STORAGE_BLOCKS_ATOMIC)
                .addTag(CommonBlockTags.STORAGE_BLOCKS_EMPOWERED_ATOMIC);
        tag(CommonBlockTags.STORAGE_BLOCKS_RAW_SULFUR)
                .add(AtomicBlocks.RAW_SULFUR_BLOCK.get());
        tag(CommonBlockTags.STORAGE_BLOCKS_RAW_SALTPETER)
                .add(AtomicBlocks.RAW_SALTPETER_BLOCK.get());
        tag(CommonBlockTags.STORAGE_BLOCKS_RAW_LEAD)
                .add(AtomicBlocks.RAW_LEAD_BLOCK.get());
        tag(CommonBlockTags.STORAGE_BLOCKS_RAW_BUNGERITE)
                .add(AtomicBlocks.RAW_BUNGERITE_BLOCK.get());
        tag(CommonBlockTags.STORAGE_BLOCKS_GUNPOWDER)
                .add(AtomicBlocks.GUNPOWDER_BLOCK.get());
        tag(CommonBlockTags.STORAGE_BLOCKS_SULFUR_DUST)
                .add(AtomicBlocks.SULFUR_DUST_BLOCK.get());
        tag(CommonBlockTags.STORAGE_BLOCKS_SALTPETER_DUST)
                .add(AtomicBlocks.SALTPETER_DUST_BLOCK.get());
        tag(CommonBlockTags.STORAGE_BLOCKS_LEAD)
                .add(AtomicBlocks.LEAD_BLOCK.get());
        tag(CommonBlockTags.STORAGE_BLOCKS_REFINED_BUNGERITE)
                .add(AtomicBlocks.REFINED_BUNGERITE_BLOCK.get());
        tag(CommonBlockTags.STORAGE_BLOCKS_BUNGERITE_ALLOY)
                .add(AtomicBlocks.BUNGERITE_ALLOY_BLOCK.get());
        tag(CommonBlockTags.STORAGE_BLOCKS_ATOMIC)
                .add(AtomicBlocks.ATOMIC_BLOCK.get());
        tag(CommonBlockTags.STORAGE_BLOCKS_EMPOWERED_ATOMIC)
                .add(AtomicBlocks.EMPOWERED_ATOMIC_BLOCK.get());

        // Ores
        tag(Tags.Blocks.ORES)
                .addTag(CommonBlockTags.ORES_SULFUR)
                .addTag(CommonBlockTags.ORES_SALTPETER)
                .addTag(CommonBlockTags.ORES_LEAD)
                .addTag(CommonBlockTags.ORES_BUNGERITE)
                .addTag(CommonBlockTags.ORES_ATOMIC);
        tag(CommonBlockTags.ORES_SULFUR)
                .add(AtomicBlocks.SULFUR_ORE.get(), AtomicBlocks.DEEPSLATE_SULFUR_ORE.get());
        tag(CommonBlockTags.ORES_SALTPETER)
                .add(AtomicBlocks.SALTPETER_ORE.get(), AtomicBlocks.DEEPSLATE_SALTPETER_ORE.get());
        tag(CommonBlockTags.ORES_LEAD)
                .add(AtomicBlocks.LEAD_ORE.get(), AtomicBlocks.DEEPSLATE_LEAD_ORE.get());
        tag(CommonBlockTags.ORES_BUNGERITE)
                .add(AtomicBlocks.BUNGERITE_ORE.get());
        tag(CommonBlockTags.ORES_ATOMIC)
                .add(AtomicBlocks.ATOMIC_ORE.get(),
                        AtomicBlocks.DEEPSLATE_ATOMIC_ORE.get(),
                        AtomicBlocks.NETHER_ATOMIC_ORE.get(),
                        AtomicBlocks.END_ATOMIC_ORE.get());

    }
}
