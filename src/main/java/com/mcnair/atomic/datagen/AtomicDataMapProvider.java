package com.mcnair.atomic.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;

import java.util.concurrent.CompletableFuture;

public class AtomicDataMapProvider extends DataMapProvider {
    protected AtomicDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather(HolderLookup.Provider provider) {
//        this.builder(NeoForgeDataMaps.FURNACE_FUELS)
//                .add(AtomicItems.STARLIGHT_ASHES.getId(), new FurnaceFuel(1200), false)
//                .add(AtomicItems.FROSTFIRE_ICE.getId(), new FurnaceFuel(2400), false);
//
//        this.builder(NeoForgeDataMaps.COMPOSTABLES)
//                .add(AtomicItems.RADISH_SEEDS.getId(), new Compostable(0.25f), false)
//                .add(AtomicItems.RADISH.getId(), new Compostable(0.45f), false);
    }
}
