package com.mcnair.atomic.utility;

import com.mcnair.atomic.AtomicCompression;

import com.mcnair.atomic.block.AtomicBlocks;
import com.mcnair.atomic.item.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AtomicCreativeTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AtomicCompression.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> ITEMS_TAB = CREATIVE_MODE_TABS.register("atomiccompression",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.atomiccompression.title"))
                    .withTabsBefore(CreativeModeTabs.BUILDING_BLOCKS)
                    .icon(() -> AtomicItems.RAW_BUNGERITE.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {

                        // blocks
                        output.accept(AtomicBlocks.SULFUR_ORE.get());
                        output.accept(AtomicBlocks.SALTPETER_ORE.get());
                        output.accept(AtomicBlocks.ATOMIC_ORE.get());
                        output.accept(AtomicBlocks.BUNGERITE_ORE.get());
                        output.accept(AtomicBlocks.ATOMIC_ORE_NETHER.get());
                        output.accept(AtomicBlocks.ATOMIC_ORE_END.get());
                        output.accept(AtomicBlocks.DENSE_BASALT.get());

                        // items
                        output.accept(AtomicItems.ATOMIC_SHARD.get());
                        output.accept(AtomicItems.EMPOWERED_ATOMIC_SHARD.get());
                        output.accept(AtomicItems.RAW_BUNGERITE.get());
                        output.accept(AtomicItems.REFINED_BUNGERITE.get());

                    }).build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}