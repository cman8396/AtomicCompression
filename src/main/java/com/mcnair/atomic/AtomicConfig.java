package com.mcnair.atomic;

import net.neoforged.neoforge.common.ModConfigSpec;

public class AtomicConfig {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    /* ALL MACHINES */
    public static final ModConfigSpec.IntValue machineAll_FuelConversion_Tier1 = BUILDER
            .comment("""
                    Amount of fuel a single Tier 1 machine fuel item is converted to.
                    Eg. Gunpowder, Deepcoal Dust
                    """)
            .defineInRange("machine.fuelConversion_Tier1", 4, 0, Integer.MAX_VALUE);
    public static final ModConfigSpec.IntValue machineAll_FuelConversion_Tier2 = BUILDER
            .comment("""
                    Amount of fuel a single Tier 2 machine fuel item is converted to.
                    Eg. Blaze Powder
                    """)
            .defineInRange("machine.fuelConversion_Tier2", 8, 0, Integer.MAX_VALUE);
    public static final ModConfigSpec.IntValue machineAll_FuelConversion_Tier3 = BUILDER
            .comment("""
                    Amount of fuel a single Tier 3 machine fuel item is converted to.
                    Eg. Unknown
                    """)
            .defineInRange("machine.fuelConversion_Tier3", 24, 0, Integer.MAX_VALUE);
    public static final ModConfigSpec.IntValue machineAll_FuelConversion_Tier4 = BUILDER
            .comment("""
                    Amount of fuel a single Tier 4 machine fuel item is converted to.
                    Eg. Unknown
                    """)
            .defineInRange("machine.fuelConversion_Tier4", 64, 0, Integer.MAX_VALUE);

    public static final ModConfigSpec.IntValue machineAll_CraftingFuelCost_Base = BUILDER
            .comment("""
                    Base amount of fuel to use for each crafting cycle.
                    *Some recipes may force a higher/lower cost.*
                    """)
            .defineInRange("machine.craftingFuelCost_Base", 1, 0, Integer.MAX_VALUE);


    /* EXPLOSIVE MILL */
    public static final ModConfigSpec.IntValue machineExplosiveMill_FuelTankCapacity_Base = BUILDER
            .comment("Capacity of blocks internal fuel tank. When no casing/upgrade is present.")
            .defineInRange("machine.explosive_mill.fuelTankCapacity_base", 256, 0, Integer.MAX_VALUE);

    public static final ModConfigSpec.IntValue machineExplosiveMill_FuelTankCapacity_RefinedBungerite = BUILDER
            .comment("Capacity of blocks internal fuel tank. When Refined Bungerite casing/upgrade is present.")
            .defineInRange("machine.explosive_mill.fuelTankCapacity_RefinedBungerite", 1024, 0, Integer.MAX_VALUE);

    public static final ModConfigSpec.IntValue machineExplosiveMill_CraftingDurationTicks_Base = BUILDER
            .comment("Base number of ticks for crafting recipe to complete.")
            .defineInRange("machine.explosive_mill.craftingDurationTicks_Base", 80, 1, Integer.MAX_VALUE);

    public static final ModConfigSpec.DoubleValue machineExplosiveMill_CraftingDurationModifier_Base = BUILDER
            .comment("""
                    Crafting duration modifier. When no casing/upgrade is present.
                    CraftingDuration = BaseCraftingDuration - (BaseCraftingDuration * THIS_VALUE).
                    """)
            .defineInRange("machine.explosive_mill.craftingDurationModifier_base", 0.0, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveMill_CraftingDurationModifier_RefinedBungerite = BUILDER
            .comment("""
                    Crafting duration modifier. When Refined Bungerite casing/upgrade is present.
                    CraftingDuration = BaseCraftingDuration - (BaseCraftingDuration * THIS_VALUE).
                    """)
            .defineInRange("machine.explosive_mill.craftingDurationModifier_RefinedBungerite", 0.22, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveMill_ChanceToSaveIgnitionSource_Base = BUILDER
            .comment("""
                    Chance for machine to not use ignition source durability. When no casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No durability used.
                    """)
            .defineInRange("machine.explosive_mill.chanceToSaveIgnitionSource_base", 0.0, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveMill_ChanceToSaveIgnitionSource_RefinedBungerite = BUILDER
            .comment("""
                    Chance for machine to not use ignition source durability. When Refined Bungerite casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No durability used.
                    """)
            .defineInRange("machine.explosive_mill.chanceToSaveIgnitionSource_RefinedBungerite", 0.50, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveMill_ChanceToSaveFuel_Base = BUILDER
            .comment("""
                    Chance for machine to not use fuel. When no casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No fuel used.
                    """)
            .defineInRange("machine.explosive_mill.chanceToSaveFuel_base", 0.0, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveMill_ChanceToSaveFuel_RefinedBungerite = BUILDER
            .comment("""
                    Chance for machine to not use fuel. When Refined Bungerite casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No fuel used.
                    """)
            .defineInRange("machine.explosive_mill.chanceToSaveFuel_RefinedBungerite", 0.50, 0.0, 1.0);


    /* EXPLOSIVE COMPACTOR */
    public static final ModConfigSpec.IntValue machineExplosiveCompactor_FuelTankCapacity_Base = BUILDER
            .comment("Capacity of blocks internal fuel tank. When no casing/upgrade is present.")
            .defineInRange("machine.explosive_compactor.fuelTankCapacity_base", 256, 0, Integer.MAX_VALUE);

    public static final ModConfigSpec.IntValue machineExplosiveCompactor_FuelTankCapacity_RefinedBungerite = BUILDER
            .comment("Capacity of blocks internal fuel tank. When Refined Bungerite casing/upgrade is present.")
            .defineInRange("machine.explosive_compactor.fuelTankCapacity_RefinedBungerite", 1024, 0, Integer.MAX_VALUE);

    public static final ModConfigSpec.IntValue machineExplosiveCompactor_CraftingDurationTicks_Base = BUILDER
            .comment("Base number of ticks for crafting recipe to complete.")
            .defineInRange("machine.explosive_compactor.craftingDurationTicks_Base", 80, 1, Integer.MAX_VALUE);

    public static final ModConfigSpec.DoubleValue machineExplosiveCompactor_CraftingDurationModifier_Base = BUILDER
            .comment("""
                    Crafting duration modifier. When no casing/upgrade is present.
                    CraftingDuration = BaseCraftingDuration - (BaseCraftingDuration * THIS_VALUE).
                    """)
            .defineInRange("machine.explosive_compactor.craftingDurationModifier_base", 0.0, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveCompactor_CraftingDurationModifier_RefinedBungerite = BUILDER
            .comment("""
                    Crafting duration modifier. When Refined Bungerite casing/upgrade is present.
                    CraftingDuration = BaseCraftingDuration - (BaseCraftingDuration * THIS_VALUE).
                    """)
            .defineInRange("machine.explosive_compactor.craftingDurationModifier_RefinedBungerite", 0.22, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveCompactor_ChanceToSaveIgnitionSource_Base = BUILDER
            .comment("""
                    Chance for machine to not use ignition source durability. When no casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No durability used.
                    """)
            .defineInRange("machine.explosive_compactor.chanceToSaveIgnitionSource_base", 0.0, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveCompactor_ChanceToSaveIgnitionSource_RefinedBungerite = BUILDER
            .comment("""
                    Chance for machine to not use ignition source durability. When Refined Bungerite casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No durability used.
                    """)
            .defineInRange("machine.explosive_compactor.chanceToSaveIgnitionSource_RefinedBungerite", 0.50, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveCompactor_ChanceToSaveFuel_Base = BUILDER
            .comment("""
                    Chance for machine to not use fuel. When no casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No fuel used.
                    """)
            .defineInRange("machine.explosive_compactor.chanceToSaveFuel_base", 0.0, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveCompactor_ChanceToSaveFuel_RefinedBungerite = BUILDER
            .comment("""
                    Chance for machine to not use fuel. When Refined Bungerite casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No fuel used.
                    """)
            .defineInRange("machine.explosive_compactor.chanceToSaveFuel_RefinedBungerite", 0.50, 0.0, 1.0);


    /* EXPLOSIVE SEPARATOR */
    public static final ModConfigSpec.IntValue machineExplosiveSeparator_FuelTankCapacity_Base = BUILDER
            .comment("Capacity of blocks internal fuel tank. When no casing/upgrade is present.")
            .defineInRange("machine.explosive_separator.fuelTankCapacity_base", 256, 0, Integer.MAX_VALUE);

    public static final ModConfigSpec.IntValue machineExplosiveSeparator_FuelTankCapacity_RefinedBungerite = BUILDER
            .comment("Capacity of blocks internal fuel tank. When Refined Bungerite casing/upgrade is present.")
            .defineInRange("machine.explosive_separator.fuelTankCapacity_RefinedBungerite", 1024, 0, Integer.MAX_VALUE);

    public static final ModConfigSpec.IntValue machineExplosiveSeparator_CraftingDurationTicks_Base = BUILDER
            .comment("Base number of ticks for crafting recipe to complete.")
            .defineInRange("machine.explosive_separator.craftingDurationTicks_Base", 80, 1, Integer.MAX_VALUE);

    public static final ModConfigSpec.DoubleValue machineExplosiveSeparator_CraftingDurationModifier_Base = BUILDER
            .comment("""
                    Crafting duration modifier. When no casing/upgrade is present.
                    CraftingDuration = BaseCraftingDuration - (BaseCraftingDuration * THIS_VALUE).
                    """)
            .defineInRange("machine.explosive_separator.craftingDurationModifier_base", 0.0, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveSeparator_CraftingDurationModifier_RefinedBungerite = BUILDER
            .comment("""
                    Crafting duration modifier. When Refined Bungerite casing/upgrade is present.
                    CraftingDuration = BaseCraftingDuration - (BaseCraftingDuration * THIS_VALUE).
                    """)
            .defineInRange("machine.explosive_separator.craftingDurationModifier_RefinedBungerite", 0.22, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveSeparator_ChanceToSaveIgnitionSource_Base = BUILDER
            .comment("""
                    Chance for machine to not use ignition source durability. When no casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No durability used.
                    """)
            .defineInRange("machine.explosive_separator.chanceToSaveIgnitionSource_base", 0.0, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveSeparator_ChanceToSaveIgnitionSource_RefinedBungerite = BUILDER
            .comment("""
                    Chance for machine to not use ignition source durability. When Refined Bungerite casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No durability used.
                    """)
            .defineInRange("machine.explosive_separator.chanceToSaveIgnitionSource_RefinedBungerite", 0.50, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveSeparator_ChanceToSaveFuel_Base = BUILDER
            .comment("""
                    Chance for machine to not use fuel. When no casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No fuel used.
                    """)
            .defineInRange("machine.explosive_separator.chanceToSaveFuel_base", 0.0, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveSeparator_ChanceToSaveFuel_RefinedBungerite = BUILDER
            .comment("""
                    Chance for machine to not use fuel. When Refined Bungerite casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No fuel used.
                    """)
            .defineInRange("machine.explosive_separator.chanceToSaveFuel_RefinedBungerite", 0.50, 0.0, 1.0);


    /* EXPLOSIVE SMELTER */
    public static final ModConfigSpec.IntValue machineExplosiveSmelter_FuelTankCapacity_Base = BUILDER
            .comment("Capacity of blocks internal fuel tank. When no casing/upgrade is present.")
            .defineInRange("machine.explosive_smelter.fuelTankCapacity_base", 256, 0, Integer.MAX_VALUE);

    public static final ModConfigSpec.IntValue machineExplosiveSmelter_FuelTankCapacity_RefinedBungerite = BUILDER
            .comment("Capacity of blocks internal fuel tank. When Refined Bungerite casing/upgrade is present.")
            .defineInRange("machine.explosive_smelter.fuelTankCapacity_RefinedBungerite", 1024, 0, Integer.MAX_VALUE);

    public static final ModConfigSpec.IntValue machineExplosiveSmelter_CraftingDurationTicks_Base = BUILDER
            .comment("Base number of ticks for crafting recipe to complete.")
            .defineInRange("machine.explosive_smelter.craftingDurationTicks_Base", 80, 1, Integer.MAX_VALUE);

    public static final ModConfigSpec.DoubleValue machineExplosiveSmelter_CraftingDurationModifier_Base = BUILDER
            .comment("""
                    Crafting duration modifier. When no casing/upgrade is present.
                    CraftingDuration = BaseCraftingDuration - (BaseCraftingDuration * THIS_VALUE).
                    """)
            .defineInRange("machine.explosive_smelter.craftingDurationModifier_base", 0.0, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveSmelter_CraftingDurationModifier_RefinedBungerite = BUILDER
            .comment("""
                    Crafting duration modifier. When Refined Bungerite casing/upgrade is present.
                    CraftingDuration = BaseCraftingDuration - (BaseCraftingDuration * THIS_VALUE).
                    """)
            .defineInRange("machine.explosive_smelter.craftingDurationModifier_RefinedBungerite", 0.22, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveSmelter_ChanceToSaveIgnitionSource_Base = BUILDER
            .comment("""
                    Chance for machine to not use ignition source durability. When no casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No durability used.
                    """)
            .defineInRange("machine.explosive_smelter.chanceToSaveIgnitionSource_base", 0.0, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveSmelter_ChanceToSaveIgnitionSource_RefinedBungerite = BUILDER
            .comment("""
                    Chance for machine to not use ignition source durability. When Refined Bungerite casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No durability used.
                    """)
            .defineInRange("machine.explosive_smelter.chanceToSaveIgnitionSource_RefinedBungerite", 0.50, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveSmelter_ChanceToSaveFuel_Base = BUILDER
            .comment("""
                    Chance for machine to not use fuel. When no casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No fuel used.
                    """)
            .defineInRange("machine.explosive_smelter.chanceToSaveFuel_base", 0.0, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveSmelter_ChanceToSaveFuel_RefinedBungerite = BUILDER
            .comment("""
                    Chance for machine to not use fuel. When Refined Bungerite casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No fuel used.
                    """)
            .defineInRange("machine.explosive_smelter.chanceToSaveFuel_RefinedBungerite", 0.50, 0.0, 1.0);


    /* EXPLOSIVE REFINER */
    public static final ModConfigSpec.IntValue machineExplosiveRefiner_FuelTankCapacity_Base = BUILDER
            .comment("Capacity of blocks internal fuel tank. When no casing/upgrade is present.")
            .defineInRange("machine.explosive_refiner.fuelTankCapacity_base", 256, 0, Integer.MAX_VALUE);

    public static final ModConfigSpec.IntValue machineExplosiveRefiner_FuelTankCapacity_RefinedBungerite = BUILDER
            .comment("Capacity of blocks internal fuel tank. When Refined Bungerite casing/upgrade is present.")
            .defineInRange("machine.explosive_refiner.fuelTankCapacity_RefinedBungerite", 1024, 0, Integer.MAX_VALUE);

    public static final ModConfigSpec.IntValue machineExplosiveRefiner_CraftingDurationTicks_Base = BUILDER
            .comment("Base number of ticks for crafting recipe to complete.")
            .defineInRange("machine.explosive_refiner.craftingDurationTicks_Base", 80, 1, Integer.MAX_VALUE);

    public static final ModConfigSpec.DoubleValue machineExplosiveRefiner_CraftingDurationModifier_Base = BUILDER
            .comment("""
                    Crafting duration modifier. When no casing/upgrade is present.
                    CraftingDuration = BaseCraftingDuration - (BaseCraftingDuration * THIS_VALUE).
                    """)
            .defineInRange("machine.explosive_refiner.craftingDurationModifier_base", 0.0, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveRefiner_CraftingDurationModifier_RefinedBungerite = BUILDER
            .comment("""
                    Crafting duration modifier. When Refined Bungerite casing/upgrade is present.
                    CraftingDuration = BaseCraftingDuration - (BaseCraftingDuration * THIS_VALUE).
                    """)
            .defineInRange("machine.explosive_refiner.craftingDurationModifier_RefinedBungerite", 0.22, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveRefiner_ChanceToSaveIgnitionSource_Base = BUILDER
            .comment("""
                    Chance for machine to not use ignition source durability. When no casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No durability used.
                    """)
            .defineInRange("machine.explosive_refiner.chanceToSaveIgnitionSource_base", 0.0, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveRefiner_ChanceToSaveIgnitionSource_RefinedBungerite = BUILDER
            .comment("""
                    Chance for machine to not use ignition source durability. When Refined Bungerite casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No durability used.
                    """)
            .defineInRange("machine.explosive_refiner.chanceToSaveIgnitionSource_RefinedBungerite", 0.50, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveRefiner_ChanceToSaveFuel_Base = BUILDER
            .comment("""
                    Chance for machine to not use fuel. When no casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No fuel used.
                    """)
            .defineInRange("machine.explosive_refiner.chanceToSaveFuel_base", 0.0, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveRefiner_ChanceToSaveFuel_RefinedBungerite = BUILDER
            .comment("""
                    Chance for machine to not use fuel. When Refined Bungerite casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No fuel used.
                    """)
            .defineInRange("machine.explosive_refiner.chanceToSaveFuel_RefinedBungerite", 0.50, 0.0, 1.0);


    /* EXPLOSIVE INFUSER */
    public static final ModConfigSpec.IntValue machineExplosiveInfuser_FuelTankCapacity_Base = BUILDER
            .comment("Capacity of blocks internal fuel tank. When no casing/upgrade is present.")
            .defineInRange("machine.explosive_infuser.fuelTankCapacity_base", 256, 0, Integer.MAX_VALUE);

    public static final ModConfigSpec.IntValue machineExplosiveInfuser_FuelTankCapacity_RefinedBungerite = BUILDER
            .comment("Capacity of blocks internal fuel tank. When Refined Bungerite casing/upgrade is present.")
            .defineInRange("machine.explosive_infuser.fuelTankCapacity_RefinedBungerite", 1024, 0, Integer.MAX_VALUE);

    public static final ModConfigSpec.IntValue machineExplosiveInfuser_CraftingDurationTicks_Base = BUILDER
            .comment("Base number of ticks for crafting recipe to complete.")
            .defineInRange("machine.explosive_infuser.craftingDurationTicks_Base", 80, 1, Integer.MAX_VALUE);

    public static final ModConfigSpec.DoubleValue machineExplosiveInfuser_CraftingDurationModifier_Base = BUILDER
            .comment("""
                    Crafting duration modifier. When no casing/upgrade is present.
                    CraftingDuration = BaseCraftingDuration - (BaseCraftingDuration * THIS_VALUE).
                    """)
            .defineInRange("machine.explosive_infuser.craftingDurationModifier_base", 0.0, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveInfuser_CraftingDurationModifier_RefinedBungerite = BUILDER
            .comment("""
                    Crafting duration modifier. When Refined Bungerite casing/upgrade is present.
                    CraftingDuration = BaseCraftingDuration - (BaseCraftingDuration * THIS_VALUE).
                    """)
            .defineInRange("machine.explosive_infuser.craftingDurationModifier_RefinedBungerite", 0.22, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveInfuser_ChanceToSaveIgnitionSource_Base = BUILDER
            .comment("""
                    Chance for machine to not use ignition source durability. When no casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No durability used.
                    """)
            .defineInRange("machine.explosive_infuser.chanceToSaveIgnitionSource_base", 0.0, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveInfuser_ChanceToSaveIgnitionSource_RefinedBungerite = BUILDER
            .comment("""
                    Chance for machine to not use ignition source durability. When Refined Bungerite casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No durability used.
                    """)
            .defineInRange("machine.explosive_infuser.chanceToSaveIgnitionSource_RefinedBungerite", 0.50, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveInfuser_ChanceToSaveFuel_Base = BUILDER
            .comment("""
                    Chance for machine to not use fuel. When no casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No fuel used.
                    """)
            .defineInRange("machine.explosive_infuser.chanceToSaveFuel_base", 0.0, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveInfuser_ChanceToSaveFuel_RefinedBungerite = BUILDER
            .comment("""
                    Chance for machine to not use fuel. When Refined Bungerite casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No fuel used.
                    """)
            .defineInRange("machine.explosive_infuser.chanceToSaveFuel_RefinedBungerite", 0.50, 0.0, 1.0);




//    public static final ModConfigSpec.BooleanValue LOG_DIRT_BLOCK = BUILDER
//            .comment("Whether to log the dirt block on common setup")
//            .define("logDirtBlock", true);

//    public static final ModConfigSpec.ConfigValue<String> MAGIC_NUMBER_INTRODUCTION = BUILDER
//            .comment("What you want the introduction message to be for the magic number")
//            .define("magicNumberIntroduction", "The magic number is... ");

    // a list of strings that are treated as resource locations for items
//    public static final ModConfigSpec.ConfigValue<List<? extends String>> ITEM_STRINGS = BUILDER
//            .comment("A list of items to log on common setup.")
//            .defineListAllowEmpty("items", List.of("minecraft:iron_ingot"), () -> "", Config::validateItemName);

    static final ModConfigSpec SPEC = BUILDER.build();

//    private static boolean validateItemName(final Object obj) {
//        return obj instanceof String itemName && BuiltInRegistries.ITEM.containsKey(Identifier.parse(itemName));
//    }
}
