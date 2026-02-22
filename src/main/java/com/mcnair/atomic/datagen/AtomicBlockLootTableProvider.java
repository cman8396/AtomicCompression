package com.mcnair.atomic.datagen;

import com.mcnair.atomic.block.AtomicBlocks;
import com.mcnair.atomic.item.AtomicItems;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.Set;

public class AtomicBlockLootTableProvider extends BlockLootSubProvider {
    protected AtomicBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {

        /* OVERWORLD ORES */
        add(AtomicBlocks.SULFUR_ORE.get(),
                block -> createMultipleOreDrops(AtomicBlocks.SULFUR_ORE.get(), AtomicItems.RAW_SULFUR.get(), 3, 5));
        add(AtomicBlocks.DEEPSLATE_SULFUR_ORE.get(),
                block -> createMultipleOreDrops(AtomicBlocks.DEEPSLATE_SULFUR_ORE.get(), AtomicItems.RAW_SULFUR.get(), 3, 5));
        add(AtomicBlocks.SALTPETER_ORE.get(),
                block -> createMultipleOreDrops(AtomicBlocks.SALTPETER_ORE.get(), AtomicItems.RAW_SALTPETER.get(), 3, 5));
        add(AtomicBlocks.DEEPSLATE_SALTPETER_ORE.get(),
                block -> createMultipleOreDrops(AtomicBlocks.DEEPSLATE_SALTPETER_ORE.get(), AtomicItems.RAW_SULFUR.get(), 3, 5));
        add(AtomicBlocks.LEAD_ORE.get(),
                block -> createSingleItemTableWithSilkTouch(AtomicBlocks.LEAD_ORE.get(), AtomicItems.RAW_LEAD.get()));
        add(AtomicBlocks.DEEPSLATE_LEAD_ORE.get(),
                block -> createMultipleOreDrops(AtomicBlocks.DEEPSLATE_LEAD_ORE.get(), AtomicItems.RAW_SULFUR.get(), 3, 5));
        add(AtomicBlocks.ATOMIC_ORE.get(),
                block -> createSingleItemTableWithSilkTouch(AtomicBlocks.ATOMIC_ORE.get(), AtomicItems.ATOMIC_SHARD.get()));
        add(AtomicBlocks.DEEPSLATE_ATOMIC_ORE.get(),
                block -> createMultipleOreDrops(AtomicBlocks.DEEPSLATE_ATOMIC_ORE.get(), AtomicItems.RAW_SULFUR.get(), 3, 5));


        /* NETHER ORES */
        add(AtomicBlocks.BUNGERITE_ORE.get(),
                block -> createSingleItemTableWithSilkTouch(AtomicBlocks.BUNGERITE_ORE.get(), AtomicItems.RAW_BUNGERITE.get()));
        add(AtomicBlocks.NETHER_ATOMIC_ORE.get(),
                block -> createSingleItemTableWithSilkTouch(AtomicBlocks.NETHER_ATOMIC_ORE.get(), AtomicItems.ATOMIC_SHARD.get()));


        /* END ORES */
        add(AtomicBlocks.END_ATOMIC_ORE.get(),
                block -> createSingleItemTableWithSilkTouch(AtomicBlocks.END_ATOMIC_ORE.get(), AtomicItems.ATOMIC_SHARD.get()));


        /* UTILITY BLOCKS */
        dropWhenSilkTouch(AtomicBlocks.ATOMIC_GLASS.get());
        dropWhenSilkTouch(AtomicBlocks.ATOMIC_GLASS_PANE.get());
        dropSelf(AtomicBlocks.DENSE_BASALT.get());
        dropSelf(AtomicBlocks.GUNPOWDER_BLOCK.get());
        dropSelf(AtomicBlocks.RAW_SULFUR_BLOCK.get());
        dropSelf(AtomicBlocks.RAW_SALTPETER_BLOCK.get());
        dropSelf(AtomicBlocks.RAW_LEAD_BLOCK.get());
        dropSelf(AtomicBlocks.RAW_BUNGERITE_BLOCK.get());
        dropSelf(AtomicBlocks.SULFUR_DUST_BLOCK.get());
        dropSelf(AtomicBlocks.SALTPETER_DUST_BLOCK.get());
        dropSelf(AtomicBlocks.LEAD_BLOCK.get());
        dropSelf(AtomicBlocks.REFINED_BUNGERITE_BLOCK.get());
        dropSelf(AtomicBlocks.BUNGERITE_ALLOY_BLOCK.get());
        dropSelf(AtomicBlocks.ATOMIC_BLOCK.get());
        dropSelf(AtomicBlocks.EMPOWERED_ATOMIC_BLOCK.get());


        /* ASHENWOOD BLOCKS */
        dropSelf(AtomicBlocks.ASHENWOOD_LOG.get());
        dropSelf(AtomicBlocks.ASHENWOOD_WOOD.get());
        dropSelf(AtomicBlocks.STRIPPED_ASHENWOOD_LOG.get());
        dropSelf(AtomicBlocks.STRIPPED_ASHENWOOD_WOOD.get());
        dropSelf(AtomicBlocks.ASHENWOOD_PLANKS.get());
        dropSelf(AtomicBlocks.ASHENWOOD_SAPLING.get());
        add(AtomicBlocks.ASHENWOOD_LEAVES.get(), block -> createLeavesDrops(block, AtomicBlocks.ASHENWOOD_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));



//        dropSelf(ModBlocks.BISMUTH_BLOCK.get());
//        // dropSelf(ModBlocks.MAGIC_BLOCK.get());
//        add(ModBlocks.BISMUTH_DEEPSLATE_ORE.get(),
//                block -> createMultipleOreDrops(ModBlocks.BISMUTH_DEEPSLATE_ORE.get(), ModItems.RAW_BISMUTH.get(), 2, 5));
//
//        add(ModBlocks.BISMUTH_END_ORE.get(),
//                block -> createMultipleOreDrops(ModBlocks.BISMUTH_END_ORE.get(), ModItems.RAW_BISMUTH.get(), 3, 6));
//        add(ModBlocks.BISMUTH_NETHER_ORE.get(),
//                block -> createMultipleOreDrops(ModBlocks.BISMUTH_NETHER_ORE.get(), ModItems.RAW_BISMUTH.get(), 4, 8));
//
//        dropSelf(ModBlocks.BISMUTH_STAIRS.get());
//        add(ModBlocks.BISMUTH_SLAB.get(),
//                block -> createSlabItemTable(ModBlocks.BISMUTH_SLAB.get()));
//
//        dropSelf(ModBlocks.BISMUTH_PRESSURE_PLATE.get());
//        dropSelf(ModBlocks.BISMUTH_BUTTON.get());
//
//        dropSelf(ModBlocks.BISMUTH_FENCE.get());
//        dropSelf(ModBlocks.BISMUTH_FENCE_GATE.get());
//        dropSelf(ModBlocks.BISMUTH_WALL.get());
//        dropSelf(ModBlocks.BISMUTH_TRAPDOOR.get());
//
//        add(ModBlocks.BISMUTH_DOOR.get(),
//                block -> createDoorTable(ModBlocks.BISMUTH_DOOR.get()));
//
//        dropSelf(ModBlocks.BISMUTH_LAMP.get());
//
//        LootItemCondition.Builder lootItemConditionBuilder = LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.RADISH_CROP.get())
//                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(RadishCropBlock.AGE, 3));
//
//        this.add(ModBlocks.RADISH_CROP.get(), this.createCropDrops(ModBlocks.RADISH_CROP.get(),
//                ModItems.RADISH.get(), ModItems.RADISH_SEEDS.get(), lootItemConditionBuilder));


//        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

//        this.add(ModBlocks.GOJI_BERRY_BUSH.get(), block -> this.applyExplosionDecay(
//                block,LootTable.lootTable().withPool(LootPool.lootPool().when(
//                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.GOJI_BERRY_BUSH.get())
//                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 3))
//                                ).add(LootItem.lootTableItem(ModItems.GOJI_BERRIES.get()))
//                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 3.0F)))
//                                .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
//                ).withPool(LootPool.lootPool().when(
//                                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(ModBlocks.GOJI_BERRY_BUSH.get())
//                                                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(SweetBerryBushBlock.AGE, 2))
//                                ).add(LootItem.lootTableItem(ModItems.GOJI_BERRIES.get()))
//                                .apply(SetItemCountFunction.setCount(UniformGenerator.between(1.0F, 2.0F)))
//                                .apply(ApplyBonusCount.addUniformBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))
//                )));

//        this.dropSelf(ModBlocks.CHAIR.get());
//        // this.dropSelf(ModBlocks.PEDESTAL.get());
//        this.dropSelf(ModBlocks.GROWTH_CHAMBER.get());
    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        // below before ::
        //.filter(block -> block != AtomicBlocks.PEDESTAL.get())
        return AtomicBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
