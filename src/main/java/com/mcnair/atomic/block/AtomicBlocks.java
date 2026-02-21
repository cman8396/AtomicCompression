package com.mcnair.atomic.block;

import com.mcnair.atomic.AtomicCompression;
import com.mcnair.atomic.item.AtomicItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import java.util.function.Function;

public class AtomicBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(AtomicCompression.MOD_ID);

    /* ORE BLOCKS */
    public static final DeferredBlock<Block> SULFUR_ORE = registerBlock("sulfur_ore",
            (properties) -> new DropExperienceBlock(UniformInt.of(1, 3),
                    properties.strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DEEPSLATE_SULFUR_ORE = registerBlock("deepslate_sulfur_ore",
            (properties) -> new DropExperienceBlock(UniformInt.of(1, 3),
                    properties.strength(2f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> SALTPETER_ORE = registerBlock("saltpeter_ore",
            (properties) -> new DropExperienceBlock(UniformInt.of(1, 3),
                    properties.strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DEEPSLATE_SALTPETER_ORE = registerBlock("deepslate_saltpeter_ore",
            (properties) -> new DropExperienceBlock(UniformInt.of(1, 3),
                    properties.strength(2f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> LEAD_ORE = registerBlock("lead_ore",
            (properties) -> new DropExperienceBlock(UniformInt.of(1, 3),
                    properties.strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DEEPSLATE_LEAD_ORE = registerBlock("deepslate_lead_ore",
            (properties) -> new DropExperienceBlock(UniformInt.of(1, 3),
                    properties.strength(2f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> ATOMIC_ORE = registerBlock("atomic_ore",
            (properties) -> new DropExperienceBlock(UniformInt.of(5, 7),
                    properties.strength(9f, 1000f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> DEEPSLATE_ATOMIC_ORE = registerBlock("deepslate_atomic_ore",
            (properties) -> new DropExperienceBlock(UniformInt.of(5, 7),
                    properties.strength(10f, 1000f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> BUNGERITE_ORE = registerBlock("bungerite_ore",
            (properties) -> new DropExperienceBlock(UniformInt.of(3, 6),
                    properties.strength(9f, 1000f).requiresCorrectToolForDrops().ignitedByLava().sound(SoundType.NETHER_GOLD_ORE)));
    public static final DeferredBlock<Block> NETHER_ATOMIC_ORE = registerBlock("nether_atomic_ore",
            (properties) -> new DropExperienceBlock(UniformInt.of(5, 7),
                    properties.strength(9f, 1000f).requiresCorrectToolForDrops().sound(SoundType.NETHER_GOLD_ORE)));
    public static final DeferredBlock<Block> END_ATOMIC_ORE = registerBlock("end_atomic_ore",
            (properties) -> new DropExperienceBlock(UniformInt.of(5, 7),
                    properties.strength(9f, 1000f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    /* UTILITY BLOCKS */
    public static final DeferredBlock<Block> ATOMIC_GLASS = registerBlock("atomic_glass",
            (properties) -> new Block(
                    properties.strength(0.3f).noOcclusion().sound(SoundType.GLASS)));
    public static final DeferredBlock<Block> DENSE_BASALT = registerBlock("dense_basalt",
            (properties) -> new RotatedPillarBlock(
                    properties.strength(2.5f, 5f).requiresCorrectToolForDrops().sound(SoundType.BASALT)));




    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Function<BlockBehaviour.Properties, T> function) {
        DeferredBlock<T> toReturn = BLOCKS.registerBlock(name, function);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        AtomicItems.ITEMS.registerItem(name, (properties) -> new BlockItem(block.get(), properties.useBlockDescriptionPrefix()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}