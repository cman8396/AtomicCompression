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


    /* BLOCK DROPS */
    public static final DeferredItem<Item> ATOMIC_SHARD = ITEMS.register(
            "atomic_shard",
            registryName -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, registryName))
            ));
    public static final DeferredItem<Item> RAW_SULFUR = ITEMS.register(
            "raw_sulfur",
            registryName -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, registryName))
            ));
    public static final DeferredItem<Item> RAW_SALTPETER = ITEMS.register(
            "raw_saltpeter",
            registryName -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, registryName))
            ));
    public static final DeferredItem<Item> RAW_BUNGERITE = ITEMS.register(
            "raw_bungerite",
            registryName -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, registryName))
            ));


    /* INTERMEDIATE ITEMS */
    public static final DeferredItem<Item> SULFUR_DUST = ITEMS.register(
            "sulfur_dust",
            registryName -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, registryName))
            ));
    public static final DeferredItem<Item> SALTPETER_DUST = ITEMS.register(
            "saltpeter_dust",
            registryName -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, registryName))
            ));
    public static final DeferredItem<Item> REFINED_BUNGERITE = ITEMS.register(
            "refined_bungerite",
            registryName -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, registryName))
            ));
    //endregion


    /* FINISHED ITEMS */
    public static final DeferredItem<Item> EMPOWERED_ATOMIC_SHARD = ITEMS.register(
            "empowered_atomic_shard",
            registryName -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, registryName))
            ));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}