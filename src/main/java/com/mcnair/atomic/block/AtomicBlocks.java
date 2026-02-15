package com.mcnair.atomic.block;

import com.mcnair.atomic.AtomicCompression;
import com.mcnair.atomic.item.AtomicItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import java.util.function.Function;

public class AtomicBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(AtomicCompression.MOD_ID);


    //region blocks
    public static final DeferredBlock<Block> BUNGERITE_ORE = registerBlock("bungerite_ore",
            (properties) -> new DropExperienceBlock(UniformInt.of(3, 6),
                    properties.strength(12f, 1000f).requiresCorrectToolForDrops().ignitedByLava().sound(SoundType.NETHER_GOLD_ORE)));
    public static final DeferredBlock<Block> ATOMIC_ORE = registerBlock("atomic_ore",
            (properties) -> new DropExperienceBlock(UniformInt.of(1, 7),
                    properties.strength(12f, 1000f).requiresCorrectToolForDrops().sound(SoundType.BASALT)));

    public static final DeferredBlock<Block> DENSE_BASALT = registerBlock("dense_basalt",
            (properties) -> new Block(
                    properties.strength(2.5f, 5f).requiresCorrectToolForDrops().sound(SoundType.BASALT)));
    //endregion


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