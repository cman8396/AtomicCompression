package com.mcnair.atomic;

import com.mcnair.atomic.block.entity.AtomicBlockEntities;
import com.mcnair.atomic.particle.particles.ShardParticles;
import com.mcnair.atomic.particle.AtomicParticles;
import com.mcnair.atomic.recipe.AtomicRecipes;
import com.mcnair.atomic.screen.AtomicMenuTypes;
import com.mcnair.atomic.utility.AtomicCreativeTabs;
import com.mcnair.atomic.block.AtomicBlocks;
import com.mcnair.atomic.item.AtomicItems;
import com.mcnair.atomic.villager.AtomicVillagers;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
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

        AtomicParticles.register(modEventBus);

        AtomicCreativeTabs.register(modEventBus);

        AtomicVillagers.register(modEventBus);

        AtomicBlockEntities.register(modEventBus);

        AtomicMenuTypes.register(modEventBus);

        AtomicRecipes.register(modEventBus);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        LOGGER.info("Atomic Compression > Started");

        Config.ITEM_STRINGS.get().forEach((item) -> LOGGER.info("ITEM >> {}", item));
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        LOGGER.info("Atomic Compression > Server Started");
    }


    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

            ItemBlockRenderTypes.setRenderLayer(AtomicBlocks.ATOMIC_GLASS.get(),ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(AtomicBlocks.ATOMIC_GLASS_PANE.get(),ChunkSectionLayer.CUTOUT);

            ItemBlockRenderTypes.setRenderLayer(AtomicBlocks.ASHENWOOD_SAPLING.get(), ChunkSectionLayer.CUTOUT);

            ItemBlockRenderTypes.setRenderLayer(AtomicBlocks.ASHENWOOD_DOOR.get(), ChunkSectionLayer.CUTOUT);
            ItemBlockRenderTypes.setRenderLayer(AtomicBlocks.ASHENWOOD_TRAPDOOR.get(), ChunkSectionLayer.CUTOUT);

//            EntityRenderers.register(ModEntities.GECKO.get(), GeckoRenderer::new);
//            EntityRenderers.register(ModEntities.TOMAHAWK.get(), TomahawkProjectileRenderer::new);
//
//            EntityRenderers.register(ModEntities.CHAIR_ENTITY.get(), ChairRenderer::new);

//            ItemBlockRenderTypes.setRenderLayer(ModBlocks.GOJI_BERRY_BUSH.get(), ChunkSectionLayer.CUTOUT);
//            ItemBlockRenderTypes.setRenderLayer(ModBlocks.RADISH_CROP.get(), ChunkSectionLayer.CUTOUT);
        }

        @SubscribeEvent
        public static void registerParticleFactories(RegisterParticleProvidersEvent event) {
            event.registerSpriteSet(AtomicParticles.SHARD_PARTICLES.get(), ShardParticles.Provider::new);
        }

//        @SubscribeEvent
//        public static void registerBER(EntityRenderersEvent.RegisterRenderers event) {
//            event.registerBlockEntityRenderer(ModBlockEntities.PEDESTAL_BE.get(), PedestalBlockEntityRenderer::new);
//        }

        @SubscribeEvent
        public static void registerScreens(RegisterMenuScreensEvent event) {
//            event.register(AtomicMenuTypes.EXPLOSIVE_COMPACTOR_MENU.get(), ExplosiveCompactorScreen::new);
        }
    }

}
