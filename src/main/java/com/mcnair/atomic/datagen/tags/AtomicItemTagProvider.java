package com.mcnair.atomic.datagen.tags;

import com.mcnair.atomic.AtomicCompression;
import com.mcnair.atomic.block.AtomicBlocks;
import com.mcnair.atomic.item.AtomicItems;
import com.mcnair.atomic.utility.AtomicTags;
import com.mcnair.atomic.utility.common.CommonItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
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


        // Machine
        tag(AtomicTags.Items.MACHINE)
                .add(AtomicBlocks.EXPLOSIVE_MILL.asItem())
                .add(AtomicBlocks.EXPLOSIVE_COMPACTOR.asItem())
                .add(AtomicBlocks.EXPLOSIVE_SEPARATOR.asItem())
                .add(AtomicBlocks.EXPLOSIVE_SMELTER.asItem())
                .add(AtomicBlocks.EXPLOSIVE_REFINER.asItem())
                .add(AtomicBlocks.EXPLOSIVE_INFUSER.asItem());

//        tag(AtomicTags.Items.MACHINE_FUEL)
//                .add(Items.GUNPOWDER)
//                .add(Items.BLAZE_POWDER);

        tag(AtomicTags.Items.MACHINE_FUEL_T1)
                .add(Items.GUNPOWDER);
        tag(AtomicTags.Items.MACHINE_FUEL_T2)
                .add(Items.BLAZE_POWDER);
//        tag(AtomicTags.Items.MACHINE_FUEL_T3);
//        tag(AtomicTags.Items.MACHINE_FUEL_T4);

        tag(AtomicTags.Items.MACHINE_CASING)
                .addTag(AtomicTags.Items.MACHINE_CASING_REFINED_BUNGERITE);
//                .add(AtomicItems.REFINED_BUNGERITE_MACHINE_CASING.asItem());
        tag(AtomicTags.Items.MACHINE_CASING_REFINED_BUNGERITE)
                .add(AtomicItems.REFINED_BUNGERITE_MACHINE_CASING.asItem());

        tag(AtomicTags.Items.MACHINE_IGNITION)
                .add(Items.FLINT_AND_STEEL);

        // Storage Blocks
        tag(Tags.Items.STORAGE_BLOCKS)
                .addTag(CommonItemTags.STORAGE_BLOCKS_RAW_SULFUR)
                .addTag(CommonItemTags.STORAGE_BLOCKS_RAW_SALTPETER)
                .addTag(CommonItemTags.STORAGE_BLOCKS_RAW_LEAD)
                .addTag(CommonItemTags.STORAGE_BLOCKS_RAW_BUNGERITE)
                .addTag(CommonItemTags.STORAGE_BLOCKS_GUNPOWDER)
                .addTag(CommonItemTags.STORAGE_BLOCKS_SULFUR_DUST)
                .addTag(CommonItemTags.STORAGE_BLOCKS_SALTPETER_DUST)
                .addTag(CommonItemTags.STORAGE_BLOCKS_LEAD)
                .addTag(CommonItemTags.STORAGE_BLOCKS_REFINED_BUNGERITE)
                .addTag(CommonItemTags.STORAGE_BLOCKS_BUNGERITE_ALLOY)
                .addTag(CommonItemTags.STORAGE_BLOCKS_ATOMIC)
                .addTag(CommonItemTags.STORAGE_BLOCKS_EMPOWERED_ATOMIC);
        tag(CommonItemTags.STORAGE_BLOCKS_RAW_SULFUR)
                .add(AtomicBlocks.RAW_SULFUR_BLOCK.asItem());
        tag(CommonItemTags.STORAGE_BLOCKS_RAW_SALTPETER)
                .add(AtomicBlocks.RAW_SALTPETER_BLOCK.asItem());
        tag(CommonItemTags.STORAGE_BLOCKS_RAW_LEAD)
                .add(AtomicBlocks.RAW_LEAD_BLOCK.asItem());
        tag(CommonItemTags.STORAGE_BLOCKS_RAW_BUNGERITE)
                .add(AtomicBlocks.RAW_BUNGERITE_BLOCK.asItem());
        tag(CommonItemTags.STORAGE_BLOCKS_GUNPOWDER)
                .add(AtomicBlocks.GUNPOWDER_BLOCK.asItem());
        tag(CommonItemTags.STORAGE_BLOCKS_SULFUR_DUST)
                .add(AtomicBlocks.SULFUR_DUST_BLOCK.asItem());
        tag(CommonItemTags.STORAGE_BLOCKS_SALTPETER_DUST)
                .add(AtomicBlocks.SALTPETER_DUST_BLOCK.asItem());
        tag(CommonItemTags.STORAGE_BLOCKS_LEAD)
                .add(AtomicBlocks.LEAD_BLOCK.asItem());
        tag(CommonItemTags.STORAGE_BLOCKS_REFINED_BUNGERITE)
                .add(AtomicBlocks.REFINED_BUNGERITE_BLOCK.asItem());
        tag(CommonItemTags.STORAGE_BLOCKS_BUNGERITE_ALLOY)
                .add(AtomicBlocks.BUNGERITE_ALLOY_BLOCK.asItem());
        tag(CommonItemTags.STORAGE_BLOCKS_ATOMIC)
                .add(AtomicBlocks.ATOMIC_BLOCK.asItem());
        tag(CommonItemTags.STORAGE_BLOCKS_EMPOWERED_ATOMIC)
                .add(AtomicBlocks.EMPOWERED_ATOMIC_BLOCK.asItem());

        // Ores
        tag(Tags.Items.ORES)
                .addTag(CommonItemTags.ORES_SULFUR)
                .addTag(CommonItemTags.ORES_SALTPETER)
                .addTag(CommonItemTags.ORES_LEAD)
                .addTag(CommonItemTags.ORES_BUNGERITE)
                .addTag(CommonItemTags.ORES_ATOMIC);
        tag(CommonItemTags.ORES_SULFUR)
                .add(AtomicBlocks.SULFUR_ORE.asItem(), AtomicBlocks.DEEPSLATE_SULFUR_ORE.asItem());
        tag(CommonItemTags.ORES_SALTPETER)
                .add(AtomicBlocks.SALTPETER_ORE.asItem(), AtomicBlocks.DEEPSLATE_SALTPETER_ORE.asItem());
        tag(CommonItemTags.ORES_LEAD)
                .add(AtomicBlocks.LEAD_ORE.asItem(), AtomicBlocks.DEEPSLATE_LEAD_ORE.asItem());
        tag(CommonItemTags.ORES_BUNGERITE)
                .add(AtomicBlocks.BUNGERITE_ORE.asItem());
        tag(CommonItemTags.ORES_ATOMIC)
                .add(AtomicBlocks.ATOMIC_ORE.asItem(),
                        AtomicBlocks.DEEPSLATE_ATOMIC_ORE.asItem(),
                        AtomicBlocks.NETHER_ATOMIC_ORE.asItem(),
                        AtomicBlocks.END_ATOMIC_ORE.asItem());

        // Raw Materials
        tag(Tags.Items.RAW_MATERIALS)
                .addTag(CommonItemTags.RAW_MATERIALS_SULFUR)
                .addTag(CommonItemTags.RAW_MATERIALS_SALTPETER)
                .addTag(CommonItemTags.RAW_MATERIALS_LEAD)
                .addTag(CommonItemTags.RAW_MATERIALS_BUNGERITE);
        tag(CommonItemTags.RAW_MATERIALS_SULFUR).
                add(AtomicItems.RAW_SULFUR.get());
        tag(CommonItemTags.RAW_MATERIALS_SALTPETER).
                add(AtomicItems.RAW_SALTPETER.get());
        tag(CommonItemTags.RAW_MATERIALS_LEAD).
                add(AtomicItems.RAW_LEAD.get());
        tag(CommonItemTags.RAW_MATERIALS_BUNGERITE).
                add(AtomicItems.RAW_BUNGERITE.get());

        // Dusts
        tag(Tags.Items.DUSTS)
                .addTag(CommonItemTags.DUSTS_SULFUR)
                .addTag(CommonItemTags.DUSTS_SALTPETER);
        tag(CommonItemTags.DUSTS_SULFUR)
                .add(AtomicItems.SULFUR_DUST.get());
        tag(CommonItemTags.DUSTS_SALTPETER)
                .add(AtomicItems.SALTPETER_DUST.get());

        //Nuggets
        tag(Tags.Items.NUGGETS)
                .addTag(CommonItemTags.NUGGETS_LEAD)
                .addTag(CommonItemTags.NUGGETS_REFINED_BUNGERITE)
                .addTag(CommonItemTags.NUGGETS_BUNGERITE_ALLOY);
        tag(CommonItemTags.NUGGETS_LEAD)
                .add(AtomicItems.LEAD_NUGGET.get());
        tag(CommonItemTags.NUGGETS_REFINED_BUNGERITE)
                .add(AtomicItems.REFINED_BUNGERITE_NUGGET.get());
        tag(CommonItemTags.NUGGETS_BUNGERITE_ALLOY)
                .add(AtomicItems.BUNGERITE_ALLOY_NUGGET.get());

        // Chunks
        tag(CommonItemTags.CHUNKS)
                .addTag(CommonItemTags.CHUNKS_OBSIDIAN);
        tag(CommonItemTags.CHUNKS_OBSIDIAN)
                .add(AtomicItems.OBSIDIAN_CHUNK.get());

        // Shards
        tag(CommonItemTags.SHARDS)
                .addTag(CommonItemTags.SHARDS_ATOMIC);
        tag(CommonItemTags.SHARDS_ATOMIC)
                .add(AtomicItems.ATOMIC_SHARD.get())
                .add(AtomicItems.EMPOWERED_ATOMIC_SHARD.get());

        // Gems
        tag(Tags.Items.GEMS)
                .addTag(CommonItemTags.GEMS_ATOMIC);
        tag(CommonItemTags.GEMS_ATOMIC)
                .add(AtomicItems.ATOMIC_SHARD.get())
                .add(AtomicItems.EMPOWERED_ATOMIC_SHARD.get());

        // Ingots
        tag(Tags.Items.INGOTS)
                .addTag(CommonItemTags.INGOTS_LEAD)
                .addTag(CommonItemTags.INGOTS_REFINED_BUNGERITE)
                .addTag(CommonItemTags.INGOTS_BUNGERITE_ALLOY);
        tag(CommonItemTags.INGOTS_LEAD)
                .add(AtomicItems.LEAD_INGOT.get());
        tag(CommonItemTags.INGOTS_REFINED_BUNGERITE)
                .add(AtomicItems.REFINED_BUNGERITE.get());
        tag(CommonItemTags.INGOTS_BUNGERITE_ALLOY)
                .add(AtomicItems.BUNGERITE_ALLOY_INGOT.get());

        // Plates
        tag(CommonItemTags.PLATES)
                .addTag(CommonItemTags.PLATES_LEAD)
                .addTag(CommonItemTags.PLATES_REFINED_BUNGERITE)
                .addTag(CommonItemTags.PLATES_BUNGERITE_ALLOY);
//        tag(CommonItemTags.PLATES_LEAD)
//                .add(AtomicItems.LEAD_PLATE.get());
//        tag(CommonItemTags.PLATES_REFINED_BUNGERITE)
//                .add(AtomicItems.REFINED_BUNGERITE_PLATE.get());
//        tag(CommonItemTags.PLATES_BUNGERITE_ALLOY)
//                .add(AtomicItems.BUNGERITE_ALLOY_PLATE.get());

        // Rods
        tag(CommonItemTags.RODS)
                .addTag(CommonItemTags.RODS_LEAD)
                .addTag(CommonItemTags.RODS_REFINED_BUNGERITE)
                .addTag(CommonItemTags.RODS_BUNGERITE_ALLOY);

    }
}
