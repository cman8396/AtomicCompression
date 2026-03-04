package com.mcnair.atomic.datagen.provider;

import com.mcnair.atomic.AtomicCompression;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;

import java.util.concurrent.CompletableFuture;

public class AtomicGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public AtomicGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, AtomicCompression.MOD_ID);
    }

    @Override
    protected void start() {
//        this.add("radish_seeds_to_short_grass",
//                new AddItemModifier(new LootItemCondition[] {
//                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.SHORT_GRASS).build(),
//                        LootItemRandomChanceCondition.randomChance(0.25f).build() }, ModItems.RADISH_SEEDS.get()));
//        this.add("radish_seeds_to_tall_grass",
//                new AddItemModifier(new LootItemCondition[] {
//                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.TALL_GRASS).build(),
//                        LootItemRandomChanceCondition.randomChance(0.25f).build() }, ModItems.RADISH_SEEDS.get()));
//
//        this.add("chisel_from_jungle_temple",
//                new AddItemModifier(new LootItemCondition[] {
//                        new LootTableIdCondition.Builder(Identifier.withDefaultNamespace("chests/jungle_temple")).build()
//                }, ModItems.CHISEL.get()));
//
//        this.add("berry_from_creeper",
//                new AddItemModifier(new LootItemCondition[] {
//                        new LootTableIdCondition.Builder(Identifier.withDefaultNamespace("entities/creeper")).build()
//                }, ModItems.GOJI_BERRIES.get()));


    }
}
