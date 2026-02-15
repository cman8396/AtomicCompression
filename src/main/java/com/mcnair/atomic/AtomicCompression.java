package com.mcnair.atomic;

import com.mcnair.atomic.utility.AtomicCreativeTabs;
import com.mcnair.atomic.block.AtomicBlocks;
import com.mcnair.atomic.item.AtomicItems;
import com.mcnair.atomic.villager.AtomicVillagers;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(AtomicCompression.MOD_ID)
public class AtomicCompression {

    public static final String MOD_ID = "atomiccompression";
    public static final Logger LOGGER = LogUtils.getLogger();

    public AtomicCompression(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);

        // Register configs.
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        // NOTE: Remove this if there are no @SubscribeEvent-annotated functions in this class.
        NeoForge.EVENT_BUS.register(this);

        // Register registry classes.
        AtomicBlocks.register(modEventBus);
        AtomicItems.register(modEventBus);
        AtomicCreativeTabs.register(modEventBus);

        AtomicVillagers.register(modEventBus);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("Atomic Compression > Started");

        Config.ITEM_STRINGS.get().forEach((item) -> LOGGER.info("ITEM >> {}", item));
    }

    // Add the example block item to the building blocks tab
    //    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    //        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
    //            event.accept(EXAMPLE_BLOCK_ITEM);
    //        }
    //    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Atomic Compression > Server Started");
    }
}
