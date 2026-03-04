package com.mcnair.atomic.datagen;

import com.mcnair.atomic.AtomicCompression;
import com.mcnair.atomic.datagen.extensions.AtomicModelProvider;
import com.mcnair.atomic.datagen.provider.*;
import com.mcnair.atomic.datagen.tags.AtomicBlockTagProvider;
import com.mcnair.atomic.datagen.tags.AtomicItemTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = AtomicCompression.MOD_ID)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherClientData(GatherDataEvent.Client event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(true , new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(AtomicBlockLootTableProvider::new, LootContextParamSets.BLOCK)), lookupProvider));
        generator.addProvider(true, new AtomicRecipeProvider.Runner(packOutput, lookupProvider));

        generator.addProvider(true, new AtomicBlockTagProvider(packOutput, lookupProvider));
        generator.addProvider(true, new AtomicItemTagProvider(packOutput, lookupProvider));

        generator.addProvider(true, new AtomicDataMapProvider(packOutput, lookupProvider));

        generator.addProvider(true, new AtomicModelProvider(packOutput));

        generator.addProvider(true, new AtomicDatapackProvider(packOutput, lookupProvider));
        generator.addProvider(true, new AtomicGlobalLootModifierProvider(packOutput, lookupProvider));
    }

    @SubscribeEvent
    public static void gatherServerData(GatherDataEvent.Server event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(true, new LootTableProvider(packOutput, Collections.emptySet(),
                List.of(new LootTableProvider.SubProviderEntry(AtomicBlockLootTableProvider::new, LootContextParamSets.BLOCK)), lookupProvider));
        generator.addProvider(true, new AtomicRecipeProvider.Runner(packOutput, lookupProvider));

        generator.addProvider(true, new AtomicBlockTagProvider(packOutput, lookupProvider));
        generator.addProvider(true, new AtomicItemTagProvider(packOutput, lookupProvider));

        generator.addProvider(true, new AtomicDataMapProvider(packOutput, lookupProvider));

        generator.addProvider(true, new AtomicModelProvider(packOutput));

        generator.addProvider(true, new AtomicDatapackProvider(packOutput, lookupProvider));
        generator.addProvider(true, new AtomicGlobalLootModifierProvider(packOutput, lookupProvider));
    }
}
