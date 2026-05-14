package com.mcnair.atomic.datagen.provider;

import com.mcnair.atomic.item.AtomicItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DataMapProvider;
import net.neoforged.neoforge.registries.datamaps.builtin.FurnaceFuel;
import net.neoforged.neoforge.registries.datamaps.builtin.NeoForgeDataMaps;

import java.util.concurrent.CompletableFuture;

public class AtomicDataMapProvider extends DataMapProvider {
    public AtomicDataMapProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> lookupProvider) {
        super(packOutput, lookupProvider);
    }

    @Override
    protected void gather(HolderLookup.Provider provider) {
        this.builder(NeoForgeDataMaps.FURNACE_FUELS)
                .add(AtomicItems.DEEPCOAL.getId(), new FurnaceFuel(1600), false);

//        this.builder(NeoForgeDataMaps.COMPOSTABLES)
//                .add(ModItems.RADISH_SEEDS.getId(), new Compostable(0.25f), false)
//                .add(ModItems.RADISH.getId(), new Compostable(0.45f), false);
    }
}
