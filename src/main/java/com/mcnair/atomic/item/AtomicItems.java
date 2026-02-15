package com.mcnair.atomic.item;

import com.mcnair.atomic.AtomicCompression;
import com.mcnair.atomic.block.AtomicBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AtomicItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(AtomicCompression.MOD_ID);


    //region items
    public static final DeferredItem<Item> RAW_BUNGERITE = ITEMS.register(
            "raw_bungerite",
            registryName -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, registryName))
            ));
    public static final DeferredItem<Item> BUNGERITE_INGOT = ITEMS.register(
            "bungerite_ingot",
            registryName -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, registryName))
            ));
    //endregion


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}