package com.mcnair.atomic.item;

import com.mcnair.atomic.AtomicCompression;
import com.mcnair.atomic.item.extensions.PickaxeItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AtomicItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(AtomicCompression.MOD_ID);


    /* ORE DROPS */
    public static final DeferredItem<Item> ATOMIC_SHARD = ITEMS.register("atomic_shard", registryName -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))));
    public static final DeferredItem<Item> RAW_SULFUR = ITEMS.register("raw_sulfur", registryName -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))));
    public static final DeferredItem<Item> RAW_SALTPETER = ITEMS.register("raw_saltpeter", registryName -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))));
    public static final DeferredItem<Item> RAW_LEAD = ITEMS.register("raw_lead", registryName -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))));
    public static final DeferredItem<Item> RAW_BRIGHTSILVER = ITEMS.register("raw_brightsilver", registryName -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))));
    public static final DeferredItem<Item> RAW_BUNGERITE = ITEMS.register("raw_bungerite", registryName -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))));
    public static final DeferredItem<Item> RAW_SOULSTEEL = ITEMS.register("raw_soulsteel", registryName -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))));

    /* DUSTS */
    public static final DeferredItem<Item> SAWDUST = ITEMS.register("sawdust", registryName -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))));
    public static final DeferredItem<Item> ATOMIC_DUST = ITEMS.register("atomic_dust", registryName -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))));
    public static final DeferredItem<Item> SULFUR_DUST = ITEMS.register("sulfur_dust", registryName -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))));
    public static final DeferredItem<Item> SALTPETER_DUST = ITEMS.register("saltpeter_dust", registryName -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))));
    public static final DeferredItem<Item> LEAD_DUST = ITEMS.register("lead_dust", registryName -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))));
    public static final DeferredItem<Item> BRIGHTSILVER_DUST = ITEMS.register("brightsilver_dust", registryName -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))));
    public static final DeferredItem<Item> BUNGERITE_DUST = ITEMS.register("bungerite_dust", registryName -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))));
    public static final DeferredItem<Item> SOULSTEEL_DUST = ITEMS.register("soulsteel_dust", registryName -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))));
    public static final DeferredItem<Item> ENDER_DUST = ITEMS.register("ender_dust", registryName -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))));
    public static final DeferredItem<Item> DIAMOND_DUST = ITEMS.register("diamond_dust", registryName -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))));
    public static final DeferredItem<Item> EMERALD_DUST = ITEMS.register("emerald_dust", registryName -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))));
    public static final DeferredItem<Item> ECHO_DUST = ITEMS.register("echo_dust", registryName -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))));

    /* PROCESSED ITEMS */
    public static final DeferredItem<Item> EMPOWERED_ATOMIC_SHARD = ITEMS.register("empowered_atomic_shard", registryName -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))));
    public static final DeferredItem<Item> LEAD_INGOT = ITEMS.register("lead_ingot", registryName -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))));
    public static final DeferredItem<Item> LEAD_NUGGET = ITEMS.register("lead_nugget", registryName -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))));
    public static final DeferredItem<Item> BRIGHTSILVER_INGOT = ITEMS.register("brightsilver_ingot", registryName -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))));
    public static final DeferredItem<Item> BRIGHTSILVER_NUGGET = ITEMS.register("brightsilver_nugget", registryName -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))));
    public static final DeferredItem<Item> BUNGERITE_INGOT = ITEMS.register("bungerite_ingot", registryName -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))));
    public static final DeferredItem<Item> BUNGERITE_NUGGET = ITEMS.register("bungerite_nugget", registryName -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))));
    public static final DeferredItem<Item> BUNGERITE_ALLOY_INGOT = ITEMS.register("bungerite_alloy_ingot", registryName -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))));
    public static final DeferredItem<Item> BUNGERITE_ALLOY_NUGGET = ITEMS.register("bungerite_alloy_nugget", registryName -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))));
    public static final DeferredItem<Item> SOULSTEEL_INGOT = ITEMS.register("soulsteel_ingot", registryName -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))));
    public static final DeferredItem<Item> SOULSTEEL_NUGGET = ITEMS.register("soulsteel_nugget", registryName -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))));

    /* CRAFTING INGREDIENTS */
    public static final DeferredItem<Item> OBSIDIAN_CHUNK = ITEMS.register("obsidian_chunk", registryName -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))));
    public static final DeferredItem<Item> BASALT_TOOL_SHAFT = ITEMS.register("basalt_tool_shaft", registryName -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))));
    public static final DeferredItem<Item> ATOMIC_TOOL_SHAFT = ITEMS.register("atomic_tool_shaft", registryName -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))));
    public static final DeferredItem<Item> ATOMIC_STABILIZER = ITEMS.register("atomic_stabilizer", registryName -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))));

    /* TOOLS */
    public static final DeferredItem<Item> BUNGERITE_ALLOY_SWORD = ITEMS.register("bungerite_alloy_sword", registryName -> new Item(new Item.Properties().sword(AtomicToolTiers.BUNGERITE_ALLOY, 4f, -2.6f).rarity(Rarity.RARE).setId(ResourceKey.create(Registries.ITEM, registryName))));
    public static final DeferredItem<Item> BUNGERITE_ALLOY_SPEAR = ITEMS.register("bungerite_alloy_spear", registryName -> new Item(new Item.Properties().spear(AtomicToolTiers.BUNGERITE_ALLOY, 1.25f, 1.5f, 0.35f, 2.2f, 6.75f, 5.25f, 5.1f, 8f, 4.6f).rarity(Rarity.RARE).setId(ResourceKey.create(Registries.ITEM, registryName))));
    public static final DeferredItem<ShovelItem> BUNGERITE_ALLOY_SHOVEL = ITEMS.register("bungerite_alloy_shovel", registryName -> new ShovelItem(AtomicToolTiers.BUNGERITE_ALLOY, 1.5f, -3.2f, new ShovelItem.Properties().rarity(Rarity.RARE).setId(ResourceKey.create(Registries.ITEM, registryName))));
    public static final DeferredItem<PickaxeItem> BUNGERITE_ALLOY_PICKAXE = ITEMS.register("bungerite_alloy_pickaxe", registryName -> new PickaxeItem(AtomicToolTiers.BUNGERITE_ALLOY, 1.0f, -3f, new PickaxeItem.Properties().rarity(Rarity.RARE).setId(ResourceKey.create(Registries.ITEM, registryName))));
    public static final DeferredItem<AxeItem> BUNGERITE_ALLOY_AXE = ITEMS.register("bungerite_alloy_axe", registryName -> new AxeItem(AtomicToolTiers.BUNGERITE_ALLOY, 5.2f, -3.0f, new ShovelItem.Properties().rarity(Rarity.RARE).setId(ResourceKey.create(Registries.ITEM, registryName))));
    public static final DeferredItem<HoeItem> BUNGERITE_ALLOY_HOE = ITEMS.register("bungerite_alloy_hoe", registryName -> new HoeItem(AtomicToolTiers.BUNGERITE_ALLOY, -4.0f, 0.0f, new ShovelItem.Properties().rarity(Rarity.RARE).setId(ResourceKey.create(Registries.ITEM, registryName))));

    /* MACHINE CASINGS */
    public static final DeferredItem<Item> BRIGHTSILVER_MACHINE_CASING = ITEMS.register("brightsilver_machine_casing", registryName -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))));
    public static final DeferredItem<Item> BUNGERITE_MACHINE_CASING = ITEMS.register("bungerite_machine_casing", registryName -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))));
    public static final DeferredItem<Item> SOULSTEEL_MACHINE_CASING = ITEMS.register("soulsteel_machine_casing", registryName -> new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, registryName))));


//    public static final DeferredItem<HammerItem> BISMUTH_HAMMER = ITEMS.registerItem("bungerite_alloy_hammer",
//            (properties) -> new HammerItem(properties.pickaxe(AtomicToolTiers.BISMUTH, 7F, -3.5f)));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}