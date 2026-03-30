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
                    .icon(() -> AtomicItems.BUNGERITE_ALLOY_INGOT.get().getDefaultInstance())
                    .displayItems((parameters, output) -> {

                        /* ADD BLOCKS */
                        output.accept(AtomicBlocks.ATOMIC_GLASS.get());
                        output.accept(AtomicBlocks.ATOMIC_GLASS_PANE.get());
                        output.accept(AtomicBlocks.DENSE_BASALT.get());

                        output.accept(AtomicBlocks.SULFUR_ORE.get());
                        output.accept(AtomicBlocks.DEEPSLATE_SULFUR_ORE.get());
                        output.accept(AtomicBlocks.SALTPETER_ORE.get());
                        output.accept(AtomicBlocks.DEEPSLATE_SALTPETER_ORE.get());
                        output.accept(AtomicBlocks.LEAD_ORE.get());
                        output.accept(AtomicBlocks.DEEPSLATE_LEAD_ORE.get());
                        output.accept(AtomicBlocks.BRIGHTSILVER_ORE.get());
                        output.accept(AtomicBlocks.DEEPSLATE_BRIGHTSILVER_ORE.get());
                        output.accept(AtomicBlocks.BUNGERITE_ORE.get());
                        output.accept(AtomicBlocks.ATOMIC_ORE.get());
                        output.accept(AtomicBlocks.DEEPSLATE_ATOMIC_ORE.get());
                        output.accept(AtomicBlocks.NETHER_ATOMIC_ORE.get());
                        output.accept(AtomicBlocks.END_ATOMIC_ORE.get());

                        output.accept(AtomicBlocks.GUNPOWDER_BLOCK.get());
                        output.accept(AtomicBlocks.RAW_SULFUR_BLOCK.get());
                        output.accept(AtomicBlocks.RAW_SALTPETER_BLOCK.get());
                        output.accept(AtomicBlocks.RAW_LEAD_BLOCK.get());
                        output.accept(AtomicBlocks.RAW_BRIGHTSILVER_BLOCK.get());
                        output.accept(AtomicBlocks.RAW_BUNGERITE_BLOCK.get());
                        output.accept(AtomicBlocks.SULFUR_DUST_BLOCK.get());
                        output.accept(AtomicBlocks.SALTPETER_DUST_BLOCK.get());
                        output.accept(AtomicBlocks.LEAD_BLOCK.get());
                        output.accept(AtomicBlocks.BRIGHTSILVER_BLOCK.get());
                        output.accept(AtomicBlocks.REFINED_BUNGERITE_BLOCK.get());
                        output.accept(AtomicBlocks.BUNGERITE_ALLOY_BLOCK.get());
                        output.accept(AtomicBlocks.ATOMIC_BLOCK.get());
                        output.accept(AtomicBlocks.EMPOWERED_ATOMIC_BLOCK.get());

                        output.accept(AtomicBlocks.ASHENWOOD_LOG.get());
                        output.accept(AtomicBlocks.ASHENWOOD_WOOD.get());
                        output.accept(AtomicBlocks.STRIPPED_ASHENWOOD_LOG.get());
                        output.accept(AtomicBlocks.STRIPPED_ASHENWOOD_WOOD.get());
                        output.accept(AtomicBlocks.ASHENWOOD_SAPLING.get());
                        output.accept(AtomicBlocks.ASHENWOOD_LEAVES.get());
                        output.accept(AtomicBlocks.ASHENWOOD_LEAVES_FLOWERING.get());
                        output.accept(AtomicBlocks.ASHENWOOD_PLANKS.get());
                        output.accept(AtomicBlocks.ASHENWOOD_STAIRS.get());
                        output.accept(AtomicBlocks.ASHENWOOD_SLAB.get());
                        output.accept(AtomicBlocks.ASHENWOOD_PRESSURE_PLATE.get());
                        output.accept(AtomicBlocks.ASHENWOOD_BUTTON.get());
                        output.accept(AtomicBlocks.ASHENWOOD_FENCE.get());
                        output.accept(AtomicBlocks.ASHENWOOD_FENCE_GATE.get());
                        output.accept(AtomicBlocks.ASHENWOOD_WALL.get());
                        output.accept(AtomicBlocks.ASHENWOOD_DOOR.get());
                        output.accept(AtomicBlocks.ASHENWOOD_TRAPDOOR.get());

                        /* ADD ITEMS */
                        output.accept(AtomicItems.RAW_SULFUR.get());
                        output.accept(AtomicItems.RAW_SALTPETER.get());
                        output.accept(AtomicItems.RAW_LEAD.get());
                        output.accept(AtomicItems.RAW_BUNGERITE.get());

                        output.accept(AtomicItems.SULFUR_DUST.get());
                        output.accept(AtomicItems.SALTPETER_DUST.get());

                        output.accept(AtomicItems.LEAD_INGOT.get());
                        output.accept(AtomicItems.REFINED_BUNGERITE.get());
                        output.accept(AtomicItems.BUNGERITE_ALLOY_INGOT.get());

                        output.accept(AtomicItems.LEAD_NUGGET.get());
                        output.accept(AtomicItems.REFINED_BUNGERITE_NUGGET.get());
                        output.accept(AtomicItems.BUNGERITE_ALLOY_NUGGET.get());

                        output.accept(AtomicItems.ATOMIC_SHARD.get());
                        output.accept(AtomicItems.EMPOWERED_ATOMIC_SHARD.get());

                        output.accept(AtomicItems.OBSIDIAN_CHUNK.get());
                        output.accept(AtomicItems.BASALT_TOOL_SHAFT.get());
                        output.accept(AtomicItems.ATOMIC_TOOL_SHAFT.get());
                        output.accept(AtomicItems.ATOMIC_STABILIZER.get());

                        output.accept(AtomicItems.BUNGERITE_ALLOY_SWORD.get());
                        output.accept(AtomicItems.BUNGERITE_ALLOY_SPEAR.get());
                        output.accept(AtomicItems.BUNGERITE_ALLOY_SHOVEL.get());
                        output.accept(AtomicItems.BUNGERITE_ALLOY_PICKAXE.get());
                        output.accept(AtomicItems.BUNGERITE_ALLOY_AXE.get());
                        output.accept(AtomicItems.BUNGERITE_ALLOY_HOE.get());

                        output.accept(AtomicItems.REFINED_BUNGERITE_MACHINE_CASING.get());

                        output.accept(AtomicBlocks.EXPLOSIVE_MILL.get());
                        output.accept(AtomicBlocks.EXPLOSIVE_COMPACTOR.get());
                        output.accept(AtomicBlocks.EXPLOSIVE_SEPARATOR.get());
                        output.accept(AtomicBlocks.EXPLOSIVE_SMELTER.get());
                        output.accept(AtomicBlocks.EXPLOSIVE_REFINER.get());
                        output.accept(AtomicBlocks.EXPLOSIVE_INFUSER.get());


                    }).build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}