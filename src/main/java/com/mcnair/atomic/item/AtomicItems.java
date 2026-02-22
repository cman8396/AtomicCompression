package com.mcnair.atomic.item;

import com.mcnair.atomic.AtomicCompression;
import com.mcnair.atomic.item.custom.PickaxeItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ShovelItem;
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
    public static final DeferredItem<Item> RAW_LEAD = ITEMS.register(
            "raw_lead",
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
    public static final DeferredItem<Item> REFINED_BUNGERITE_NUGGET = ITEMS.register(
            "refined_bungerite_nugget",
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
    public static final DeferredItem<Item> LEAD_INGOT = ITEMS.register(
            "lead_ingot",
            registryName -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, registryName))
            ));
    public static final DeferredItem<Item> LEAD_NUGGET = ITEMS.register(
            "lead_nugget",
            registryName -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, registryName))
            ));
    public static final DeferredItem<Item> BUNGERITE_ALLOY_INGOT = ITEMS.register(
            "bungerite_alloy_ingot",
            registryName -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, registryName))
            ));
    public static final DeferredItem<Item> BUNGERITE_ALLOY_NUGGET = ITEMS.register(
            "bungerite_alloy_nugget",
            registryName -> new Item(new Item.Properties()
                    .setId(ResourceKey.create(Registries.ITEM, registryName))
            ));


    /* BUNGERITE TOOLS */
    public static final DeferredItem<Item> BUNGERITE_ALLOY_SWORD = ITEMS.register(
            "bungerite_alloy_sword",
            registryName -> new Item(new Item.Properties()
                    .sword(AtomicToolTiers.BUNGERITE_ALLOY, 4f, -2.6f)
                    .setId(ResourceKey.create(Registries.ITEM, registryName))
            ));
    public static final DeferredItem<ShovelItem> BUNGERITE_ALLOY_SHOVEL = ITEMS.register(
            "bungerite_alloy_shovel",
            registryName -> new ShovelItem(
                    AtomicToolTiers.BUNGERITE_ALLOY, 1.5f, -3.2f,
                    new ShovelItem.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))
            ));
    public static final DeferredItem<PickaxeItem> BUNGERITE_ALLOY_PICKAXE = ITEMS.register(
            "bungerite_alloy_pickaxe",
            registryName -> new PickaxeItem(
                    AtomicToolTiers.BUNGERITE_ALLOY, 1.0f, -3f,
                    new PickaxeItem.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))
            ));
    public static final DeferredItem<AxeItem> BUNGERITE_ALLOY_AXE = ITEMS.register(
            "bungerite_alloy_axe",
            registryName -> new AxeItem(
                    AtomicToolTiers.BUNGERITE_ALLOY, 5.2f, -3.0f,
                    new ShovelItem.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))
            ));
    public static final DeferredItem<HoeItem> BUNGERITE_ALLOY_HOE = ITEMS.register(
            "bungerite_alloy_hoe",
            registryName -> new HoeItem(
                    AtomicToolTiers.BUNGERITE_ALLOY, -4.0f, 0.0f,
                    new ShovelItem.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))
            ));


//    public static final DeferredItem<HammerItem> BISMUTH_HAMMER = ITEMS.registerItem("bungerite_alloy_hammer",
//            (properties) -> new HammerItem(properties.pickaxe(AtomicToolTiers.BISMUTH, 7F, -3.5f)));




    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}