package com.mcnair.atomic;

import net.neoforged.neoforge.common.ModConfigSpec;

public class AtomicConfig {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    /* TOOLTIPS */
    public static final ModConfigSpec.BooleanValue general_ShowMachineFuelTierTooltips = BUILDER
            .comment("Should 'Machine Fuel Tier x' tooltips be visible for items.")
            .define("general.show_machine_fuel_tier_tooltips",true);

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
            .defineInRange("machine.fuelConversion_Tier3", 16, 0, Integer.MAX_VALUE);
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
    public static final ModConfigSpec.IntValue machineExplosiveMill_CraftingDurationTicks = BUILDER
            .comment("Base number of ticks for crafting recipe to complete.")
            .defineInRange("machine.explosive_mill.craftingDurationTicks", 82, 1, Integer.MAX_VALUE);

    public static final ModConfigSpec.IntValue machineExplosiveMill_FuelTankCapacity_Base = BUILDER
            .comment("Capacity of blocks internal fuel tank. When no casing/upgrade is present.")
            .defineInRange("machine.explosive_mill.fuelTankCapacity_base", 256, 0, Integer.MAX_VALUE);
    public static final ModConfigSpec.IntValue machineExplosiveMill_FuelTankCapacity_Brightsilver = BUILDER
            .comment("Capacity of blocks internal fuel tank. When Brightsilver casing/upgrade is present.")
            .defineInRange("machine.explosive_mill.fuelTankCapacity_Brightsilver", 1024, 0, Integer.MAX_VALUE);
    public static final ModConfigSpec.IntValue machineExplosiveMill_FuelTankCapacity_Bungerite = BUILDER
            .comment("Capacity of blocks internal fuel tank. When Bungerite casing/upgrade is present.")
            .defineInRange("machine.explosive_mill.fuelTankCapacity_Bungerite", 2048, 0, Integer.MAX_VALUE);
    public static final ModConfigSpec.IntValue machineExplosiveMill_FuelTankCapacity_Soulsteel = BUILDER
            .comment("Capacity of blocks internal fuel tank. When Soulsteel casing/upgrade is present.")
            .defineInRange("machine.explosive_mill.fuelTankCapacity_Soulsteel", 8192, 0, Integer.MAX_VALUE);

    public static final ModConfigSpec.DoubleValue machineExplosiveMill_CraftingDurationModifier_Base = BUILDER
            .comment("""
                    Crafting duration modifier. When no casing/upgrade is present.
                    CraftingDuration = BaseCraftingDuration - (BaseCraftingDuration * THIS_VALUE).
                    """)
            .defineInRange("machine.explosive_mill.craftingDurationModifier_base", 0.0, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveMill_CraftingDurationModifier_Brightsilver = BUILDER
            .comment("""
                    Crafting duration modifier. When Brightsilver casing/upgrade is present.
                    CraftingDuration = BaseCraftingDuration - (BaseCraftingDuration * THIS_VALUE).
                    """)
            .defineInRange("machine.explosive_mill.craftingDurationModifier_Brightsilver", 0.15, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveMill_CraftingDurationModifier_Bungerite = BUILDER
            .comment("""
                    Crafting duration modifier. When Bungerite casing/upgrade is present.
                    CraftingDuration = BaseCraftingDuration - (BaseCraftingDuration * THIS_VALUE).
                    """)
            .defineInRange("machine.explosive_mill.craftingDurationModifier_Bungerite", 0.25, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveMill_CraftingDurationModifier_Soulsteel = BUILDER
            .comment("""
                    Crafting duration modifier. When Soulsteel casing/upgrade is present.
                    CraftingDuration = BaseCraftingDuration - (BaseCraftingDuration * THIS_VALUE).
                    """)
            .defineInRange("machine.explosive_mill.craftingDurationModifier_Soulsteel", 0.55, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveMill_ChanceToSaveIgnitionSource_Base = BUILDER
            .comment("""
                    Chance for machine to not use ignition source durability. When no casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No durability used.
                    """)
            .defineInRange("machine.explosive_mill.chanceToSaveIgnitionSource_base", 0.0, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveMill_ChanceToSaveIgnitionSource_Brightsilver = BUILDER
            .comment("""
                    Chance for machine to not use ignition source durability. When Brightsilver casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No durability used.
                    """)
            .defineInRange("machine.explosive_mill.chanceToSaveIgnitionSource_Brightsilver", 0.1, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveMill_ChanceToSaveIgnitionSource_Bungerite = BUILDER
            .comment("""
                    Chance for machine to not use ignition source durability. When Bungerite casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No durability used.
                    """)
            .defineInRange("machine.explosive_mill.chanceToSaveIgnitionSource_Bungerite", 0.2, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveMill_ChanceToSaveIgnitionSource_Soulsteel = BUILDER
            .comment("""
                    Chance for machine to not use ignition source durability. When Soulsteel casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No durability used.
                    """)
            .defineInRange("machine.explosive_mill.chanceToSaveIgnitionSource_Soulsteel", 0.3, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveMill_ChanceToSaveFuel_Base = BUILDER
            .comment("""
                    Chance for machine to not use fuel. When no casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No fuel used.
                    """)
            .defineInRange("machine.explosive_mill.chanceToSaveFuel_base", 0.0, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveMill_ChanceToSaveFuel_Brightsilver = BUILDER
            .comment("""
                    Chance for machine to not use fuel. When Brightsilver casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No fuel used.
                    """)
            .defineInRange("machine.explosive_mill.chanceToSaveFuel_Brightsilver", 0.1, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveMill_ChanceToSaveFuel_Bungerite = BUILDER
            .comment("""
                    Chance for machine to not use fuel. When Bungerite casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No fuel used.
                    """)
            .defineInRange("machine.explosive_mill.chanceToSaveFuel_Bungerite", 0.2, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveMill_ChanceToSaveFuel_Soulsteel = BUILDER
            .comment("""
                    Chance for machine to not use fuel. When Soulsteel casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No fuel used.
                    """)
            .defineInRange("machine.explosive_mill.chanceToSaveFuel_Soulsteel", 0.3, 0.0, 1.0);


    /* EXPLOSIVE COMPACTOR */
    public static final ModConfigSpec.IntValue machineExplosiveCompactor_CraftingDurationTicks = BUILDER
            .comment("Base number of ticks for crafting recipe to complete.")
            .defineInRange("machine.explosive_compactor.craftingDurationTicks", 82, 1, Integer.MAX_VALUE);

    public static final ModConfigSpec.IntValue machineExplosiveCompactor_FuelTankCapacity_Base = BUILDER
            .comment("Capacity of blocks internal fuel tank. When no casing/upgrade is present.")
            .defineInRange("machine.explosive_compactor.fuelTankCapacity_base", 256, 0, Integer.MAX_VALUE);
    public static final ModConfigSpec.IntValue machineExplosiveCompactor_FuelTankCapacity_Brightsilver = BUILDER
            .comment("Capacity of blocks internal fuel tank. When Brightsilver casing/upgrade is present.")
            .defineInRange("machine.explosive_compactor.fuelTankCapacity_Brightsilver", 1024, 0, Integer.MAX_VALUE);
    public static final ModConfigSpec.IntValue machineExplosiveCompactor_FuelTankCapacity_Bungerite = BUILDER
            .comment("Capacity of blocks internal fuel tank. When Bungerite casing/upgrade is present.")
            .defineInRange("machine.explosive_compactor.fuelTankCapacity_Bungerite", 2048, 0, Integer.MAX_VALUE);
    public static final ModConfigSpec.IntValue machineExplosiveCompactor_FuelTankCapacity_Soulsteel = BUILDER
            .comment("Capacity of blocks internal fuel tank. When Soulsteel casing/upgrade is present.")
            .defineInRange("machine.explosive_compactor.fuelTankCapacity_Soulsteel", 8192, 0, Integer.MAX_VALUE);

    public static final ModConfigSpec.DoubleValue machineExplosiveCompactor_CraftingDurationModifier_Base = BUILDER
            .comment("""
                    Crafting duration modifier. When no casing/upgrade is present.
                    CraftingDuration = BaseCraftingDuration - (BaseCraftingDuration * THIS_VALUE).
                    """)
            .defineInRange("machine.explosive_compactor.craftingDurationModifier_base", 0.0, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveCompactor_CraftingDurationModifier_Brightsilver = BUILDER
            .comment("""
                    Crafting duration modifier. When Brightsilver casing/upgrade is present.
                    CraftingDuration = BaseCraftingDuration - (BaseCraftingDuration * THIS_VALUE).
                    """)
            .defineInRange("machine.explosive_compactor.craftingDurationModifier_Brightsilver", 0.15, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveCompactor_CraftingDurationModifier_Bungerite = BUILDER
            .comment("""
                    Crafting duration modifier. When Bungerite casing/upgrade is present.
                    CraftingDuration = BaseCraftingDuration - (BaseCraftingDuration * THIS_VALUE).
                    """)
            .defineInRange("machine.explosive_compactor.craftingDurationModifier_Bungerite", 0.25, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveCompactor_CraftingDurationModifier_Soulsteel = BUILDER
            .comment("""
                    Crafting duration modifier. When Soulsteel casing/upgrade is present.
                    CraftingDuration = BaseCraftingDuration - (BaseCraftingDuration * THIS_VALUE).
                    """)
            .defineInRange("machine.explosive_compactor.craftingDurationModifier_Soulsteel", 0.55, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveCompactor_ChanceToSaveIgnitionSource_Base = BUILDER
            .comment("""
                    Chance for machine to not use ignition source durability. When no casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No durability used.
                    """)
            .defineInRange("machine.explosive_compactor.chanceToSaveIgnitionSource_base", 0.0, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveCompactor_ChanceToSaveIgnitionSource_Brightsilver = BUILDER
            .comment("""
                    Chance for machine to not use ignition source durability. When Brightsilver casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No durability used.
                    """)
            .defineInRange("machine.explosive_compactor.chanceToSaveIgnitionSource_Brightsilver", 0.1, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveCompactor_ChanceToSaveIgnitionSource_Bungerite = BUILDER
            .comment("""
                    Chance for machine to not use ignition source durability. When Bungerite casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No durability used.
                    """)
            .defineInRange("machine.explosive_compactor.chanceToSaveIgnitionSource_Bungerite", 0.2, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveCompactor_ChanceToSaveIgnitionSource_Soulsteel = BUILDER
            .comment("""
                    Chance for machine to not use ignition source durability. When Soulsteel casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No durability used.
                    """)
            .defineInRange("machine.explosive_compactor.chanceToSaveIgnitionSource_Soulsteel", 0.3, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveCompactor_ChanceToSaveFuel_Base = BUILDER
            .comment("""
                    Chance for machine to not use fuel. When no casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No fuel used.
                    """)
            .defineInRange("machine.explosive_compactor.chanceToSaveFuel_base", 0.0, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveCompactor_ChanceToSaveFuel_Brightsilver = BUILDER
            .comment("""
                    Chance for machine to not use fuel. When Brightsilver casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No fuel used.
                    """)
            .defineInRange("machine.explosive_compactor.chanceToSaveFuel_Brightsilver", 0.1, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveCompactor_ChanceToSaveFuel_Bungerite = BUILDER
            .comment("""
                    Chance for machine to not use fuel. When Bungerite casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No fuel used.
                    """)
            .defineInRange("machine.explosive_compactor.chanceToSaveFuel_Bungerite", 0.2, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveCompactor_ChanceToSaveFuel_Soulsteel = BUILDER
            .comment("""
                    Chance for machine to not use fuel. When Soulsteel casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No fuel used.
                    """)
            .defineInRange("machine.explosive_compactor.chanceToSaveFuel_Soulsteel", 0.3, 0.0, 1.0);


    /* EXPLOSIVE SEPARATOR */
    public static final ModConfigSpec.IntValue machineExplosiveSeparator_CraftingDurationTicks = BUILDER
            .comment("Base number of ticks for crafting recipe to complete.")
            .defineInRange("machine.explosive_separator.craftingDurationTicks", 82, 1, Integer.MAX_VALUE);

    public static final ModConfigSpec.IntValue machineExplosiveSeparator_FuelTankCapacity_Base = BUILDER
            .comment("Capacity of blocks internal fuel tank. When no casing/upgrade is present.")
            .defineInRange("machine.explosive_separator.fuelTankCapacity_base", 256, 0, Integer.MAX_VALUE);
    public static final ModConfigSpec.IntValue machineExplosiveSeparator_FuelTankCapacity_Brightsilver = BUILDER
            .comment("Capacity of blocks internal fuel tank. When Brightsilver casing/upgrade is present.")
            .defineInRange("machine.explosive_separator.fuelTankCapacity_Brightsilver", 1024, 0, Integer.MAX_VALUE);
    public static final ModConfigSpec.IntValue machineExplosiveSeparator_FuelTankCapacity_Bungerite = BUILDER
            .comment("Capacity of blocks internal fuel tank. When Bungerite casing/upgrade is present.")
            .defineInRange("machine.explosive_separator.fuelTankCapacity_Bungerite", 2048, 0, Integer.MAX_VALUE);
    public static final ModConfigSpec.IntValue machineExplosiveSeparator_FuelTankCapacity_Soulsteel = BUILDER
            .comment("Capacity of blocks internal fuel tank. When Soulsteel casing/upgrade is present.")
            .defineInRange("machine.explosive_separator.fuelTankCapacity_Soulsteel", 8192, 0, Integer.MAX_VALUE);

    public static final ModConfigSpec.DoubleValue machineExplosiveSeparator_CraftingDurationModifier_Base = BUILDER
            .comment("""
                    Crafting duration modifier. When no casing/upgrade is present.
                    CraftingDuration = BaseCraftingDuration - (BaseCraftingDuration * THIS_VALUE).
                    """)
            .defineInRange("machine.explosive_separator.craftingDurationModifier_base", 0.0, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveSeparator_CraftingDurationModifier_Brightsilver = BUILDER
            .comment("""
                    Crafting duration modifier. When Brightsilver casing/upgrade is present.
                    CraftingDuration = BaseCraftingDuration - (BaseCraftingDuration * THIS_VALUE).
                    """)
            .defineInRange("machine.explosive_separator.craftingDurationModifier_Brightsilver", 0.15, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveSeparator_CraftingDurationModifier_Bungerite = BUILDER
            .comment("""
                    Crafting duration modifier. When Bungerite casing/upgrade is present.
                    CraftingDuration = BaseCraftingDuration - (BaseCraftingDuration * THIS_VALUE).
                    """)
            .defineInRange("machine.explosive_separator.craftingDurationModifier_Bungerite", 0.25, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveSeparator_CraftingDurationModifier_Soulsteel = BUILDER
            .comment("""
                    Crafting duration modifier. When Soulsteel casing/upgrade is present.
                    CraftingDuration = BaseCraftingDuration - (BaseCraftingDuration * THIS_VALUE).
                    """)
            .defineInRange("machine.explosive_separator.craftingDurationModifier_Soulsteel", 0.55, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveSeparator_ChanceToSaveIgnitionSource_Base = BUILDER
            .comment("""
                    Chance for machine to not use ignition source durability. When no casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No durability used.
                    """)
            .defineInRange("machine.explosive_separator.chanceToSaveIgnitionSource_base", 0.0, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveSeparator_ChanceToSaveIgnitionSource_Brightsilver = BUILDER
            .comment("""
                    Chance for machine to not use ignition source durability. When Brightsilver casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No durability used.
                    """)
            .defineInRange("machine.explosive_separator.chanceToSaveIgnitionSource_Brightsilver", 0.1, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveSeparator_ChanceToSaveIgnitionSource_Bungerite = BUILDER
            .comment("""
                    Chance for machine to not use ignition source durability. When Bungerite casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No durability used.
                    """)
            .defineInRange("machine.explosive_separator.chanceToSaveIgnitionSource_Bungerite", 0.2, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveSeparator_ChanceToSaveIgnitionSource_Soulsteel = BUILDER
            .comment("""
                    Chance for machine to not use ignition source durability. When Soulsteel casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No durability used.
                    """)
            .defineInRange("machine.explosive_separator.chanceToSaveIgnitionSource_Soulsteel", 0.3, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveSeparator_ChanceToSaveFuel_Base = BUILDER
            .comment("""
                    Chance for machine to not use fuel. When no casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No fuel used.
                    """)
            .defineInRange("machine.explosive_separator.chanceToSaveFuel_base", 0.0, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveSeparator_ChanceToSaveFuel_Brightsilver = BUILDER
            .comment("""
                    Chance for machine to not use fuel. When Brightsilver casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No fuel used.
                    """)
            .defineInRange("machine.explosive_separator.chanceToSaveFuel_Brightsilver", 0.1, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveSeparator_ChanceToSaveFuel_Bungerite = BUILDER
            .comment("""
                    Chance for machine to not use fuel. When Bungerite casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No fuel used.
                    """)
            .defineInRange("machine.explosive_separator.chanceToSaveFuel_Bungerite", 0.2, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveSeparator_ChanceToSaveFuel_Soulsteel = BUILDER
            .comment("""
                    Chance for machine to not use fuel. When Soulsteel casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No fuel used.
                    """)
            .defineInRange("machine.explosive_separator.chanceToSaveFuel_Soulsteel", 0.3, 0.0, 1.0);


    /* EXPLOSIVE SMELTER */
    public static final ModConfigSpec.IntValue machineExplosiveSmelter_CraftingDurationTicks = BUILDER
            .comment("Base number of ticks for crafting recipe to complete.")
            .defineInRange("machine.explosive_smelter.craftingDurationTicks", 82, 1, Integer.MAX_VALUE);

    public static final ModConfigSpec.IntValue machineExplosiveSmelter_FuelTankCapacity_Base = BUILDER
            .comment("Capacity of blocks internal fuel tank. When no casing/upgrade is present.")
            .defineInRange("machine.explosive_smelter.fuelTankCapacity_base", 256, 0, Integer.MAX_VALUE);
    public static final ModConfigSpec.IntValue machineExplosiveSmelter_FuelTankCapacity_Brightsilver = BUILDER
            .comment("Capacity of blocks internal fuel tank. When Brightsilver casing/upgrade is present.")
            .defineInRange("machine.explosive_smelter.fuelTankCapacity_Brightsilver", 1024, 0, Integer.MAX_VALUE);
    public static final ModConfigSpec.IntValue machineExplosiveSmelter_FuelTankCapacity_Bungerite = BUILDER
            .comment("Capacity of blocks internal fuel tank. When Bungerite casing/upgrade is present.")
            .defineInRange("machine.explosive_smelter.fuelTankCapacity_Bungerite", 2048, 0, Integer.MAX_VALUE);
    public static final ModConfigSpec.IntValue machineExplosiveSmelter_FuelTankCapacity_Soulsteel = BUILDER
            .comment("Capacity of blocks internal fuel tank. When Soulsteel casing/upgrade is present.")
            .defineInRange("machine.explosive_smelter.fuelTankCapacity_Soulsteel", 8192, 0, Integer.MAX_VALUE);

    public static final ModConfigSpec.DoubleValue machineExplosiveSmelter_CraftingDurationModifier_Base = BUILDER
            .comment("""
                    Crafting duration modifier. When no casing/upgrade is present.
                    CraftingDuration = BaseCraftingDuration - (BaseCraftingDuration * THIS_VALUE).
                    """)
            .defineInRange("machine.explosive_smelter.craftingDurationModifier_base", 0.0, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveSmelter_CraftingDurationModifier_Brightsilver = BUILDER
            .comment("""
                    Crafting duration modifier. When Brightsilver casing/upgrade is present.
                    CraftingDuration = BaseCraftingDuration - (BaseCraftingDuration * THIS_VALUE).
                    """)
            .defineInRange("machine.explosive_smelter.craftingDurationModifier_Brightsilver", 0.15, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveSmelter_CraftingDurationModifier_Bungerite = BUILDER
            .comment("""
                    Crafting duration modifier. When Bungerite casing/upgrade is present.
                    CraftingDuration = BaseCraftingDuration - (BaseCraftingDuration * THIS_VALUE).
                    """)
            .defineInRange("machine.explosive_smelter.craftingDurationModifier_Bungerite", 0.25, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveSmelter_CraftingDurationModifier_Soulsteel = BUILDER
            .comment("""
                    Crafting duration modifier. When Soulsteel casing/upgrade is present.
                    CraftingDuration = BaseCraftingDuration - (BaseCraftingDuration * THIS_VALUE).
                    """)
            .defineInRange("machine.explosive_smelter.craftingDurationModifier_Soulsteel", 0.55, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveSmelter_ChanceToSaveIgnitionSource_Base = BUILDER
            .comment("""
                    Chance for machine to not use ignition source durability. When no casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No durability used.
                    """)
            .defineInRange("machine.explosive_smelter.chanceToSaveIgnitionSource_base", 0.0, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveSmelter_ChanceToSaveIgnitionSource_Brightsilver = BUILDER
            .comment("""
                    Chance for machine to not use ignition source durability. When Brightsilver casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No durability used.
                    """)
            .defineInRange("machine.explosive_smelter.chanceToSaveIgnitionSource_Brightsilver", 0.1, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveSmelter_ChanceToSaveIgnitionSource_Bungerite = BUILDER
            .comment("""
                    Chance for machine to not use ignition source durability. When Bungerite casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No durability used.
                    """)
            .defineInRange("machine.explosive_smelter.chanceToSaveIgnitionSource_Bungerite", 0.2, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveSmelter_ChanceToSaveIgnitionSource_Soulsteel = BUILDER
            .comment("""
                    Chance for machine to not use ignition source durability. When Soulsteel casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No durability used.
                    """)
            .defineInRange("machine.explosive_smelter.chanceToSaveIgnitionSource_Soulsteel", 0.3, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveSmelter_ChanceToSaveFuel_Base = BUILDER
            .comment("""
                    Chance for machine to not use fuel. When no casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No fuel used.
                    """)
            .defineInRange("machine.explosive_smelter.chanceToSaveFuel_base", 0.0, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveSmelter_ChanceToSaveFuel_Brightsilver = BUILDER
            .comment("""
                    Chance for machine to not use fuel. When Brightsilver casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No fuel used.
                    """)
            .defineInRange("machine.explosive_smelter.chanceToSaveFuel_Brightsilver", 0.1, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveSmelter_ChanceToSaveFuel_Bungerite = BUILDER
            .comment("""
                    Chance for machine to not use fuel. When Bungerite casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No fuel used.
                    """)
            .defineInRange("machine.explosive_smelter.chanceToSaveFuel_Bungerite", 0.2, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveSmelter_ChanceToSaveFuel_Soulsteel = BUILDER
            .comment("""
                    Chance for machine to not use fuel. When Soulsteel casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No fuel used.
                    """)
            .defineInRange("machine.explosive_smelter.chanceToSaveFuel_Soulsteel", 0.3, 0.0, 1.0);


    /* EXPLOSIVE REFINER */
    public static final ModConfigSpec.IntValue machineExplosiveRefiner_CraftingDurationTicks = BUILDER
            .comment("Base number of ticks for crafting recipe to complete.")
            .defineInRange("machine.explosive_refiner.craftingDurationTicks", 82, 1, Integer.MAX_VALUE);

    public static final ModConfigSpec.IntValue machineExplosiveRefiner_FuelTankCapacity_Base = BUILDER
            .comment("Capacity of blocks internal fuel tank. When no casing/upgrade is present.")
            .defineInRange("machine.explosive_refiner.fuelTankCapacity_base", 256, 0, Integer.MAX_VALUE);
    public static final ModConfigSpec.IntValue machineExplosiveRefiner_FuelTankCapacity_Brightsilver = BUILDER
            .comment("Capacity of blocks internal fuel tank. When Brightsilver casing/upgrade is present.")
            .defineInRange("machine.explosive_refiner.fuelTankCapacity_Brightsilver", 1024, 0, Integer.MAX_VALUE);
    public static final ModConfigSpec.IntValue machineExplosiveRefiner_FuelTankCapacity_Bungerite = BUILDER
            .comment("Capacity of blocks internal fuel tank. When Bungerite casing/upgrade is present.")
            .defineInRange("machine.explosive_refiner.fuelTankCapacity_Bungerite", 2048, 0, Integer.MAX_VALUE);
    public static final ModConfigSpec.IntValue machineExplosiveRefiner_FuelTankCapacity_Soulsteel = BUILDER
            .comment("Capacity of blocks internal fuel tank. When Soulsteel casing/upgrade is present.")
            .defineInRange("machine.explosive_refiner.fuelTankCapacity_Soulsteel", 8192, 0, Integer.MAX_VALUE);

    public static final ModConfigSpec.DoubleValue machineExplosiveRefiner_CraftingDurationModifier_Base = BUILDER
            .comment("""
                    Crafting duration modifier. When no casing/upgrade is present.
                    CraftingDuration = BaseCraftingDuration - (BaseCraftingDuration * THIS_VALUE).
                    """)
            .defineInRange("machine.explosive_refiner.craftingDurationModifier_base", 0.0, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveRefiner_CraftingDurationModifier_Brightsilver = BUILDER
            .comment("""
                    Crafting duration modifier. When Brightsilver casing/upgrade is present.
                    CraftingDuration = BaseCraftingDuration - (BaseCraftingDuration * THIS_VALUE).
                    """)
            .defineInRange("machine.explosive_refiner.craftingDurationModifier_Brightsilver", 0.15, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveRefiner_CraftingDurationModifier_Bungerite = BUILDER
            .comment("""
                    Crafting duration modifier. When Bungerite casing/upgrade is present.
                    CraftingDuration = BaseCraftingDuration - (BaseCraftingDuration * THIS_VALUE).
                    """)
            .defineInRange("machine.explosive_refiner.craftingDurationModifier_Bungerite", 0.25, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveRefiner_CraftingDurationModifier_Soulsteel = BUILDER
            .comment("""
                    Crafting duration modifier. When Soulsteel casing/upgrade is present.
                    CraftingDuration = BaseCraftingDuration - (BaseCraftingDuration * THIS_VALUE).
                    """)
            .defineInRange("machine.explosive_refiner.craftingDurationModifier_Soulsteel", 0.55, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveRefiner_ChanceToSaveIgnitionSource_Base = BUILDER
            .comment("""
                    Chance for machine to not use ignition source durability. When no casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No durability used.
                    """)
            .defineInRange("machine.explosive_refiner.chanceToSaveIgnitionSource_base", 0.0, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveRefiner_ChanceToSaveIgnitionSource_Brightsilver = BUILDER
            .comment("""
                    Chance for machine to not use ignition source durability. When Brightsilver casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No durability used.
                    """)
            .defineInRange("machine.explosive_refiner.chanceToSaveIgnitionSource_Brightsilver", 0.1, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveRefiner_ChanceToSaveIgnitionSource_Bungerite = BUILDER
            .comment("""
                    Chance for machine to not use ignition source durability. When Bungerite casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No durability used.
                    """)
            .defineInRange("machine.explosive_refiner.chanceToSaveIgnitionSource_Bungerite", 0.2, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveRefiner_ChanceToSaveIgnitionSource_Soulsteel = BUILDER
            .comment("""
                    Chance for machine to not use ignition source durability. When Soulsteel casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No durability used.
                    """)
            .defineInRange("machine.explosive_refiner.chanceToSaveIgnitionSource_Soulsteel", 0.3, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveRefiner_ChanceToSaveFuel_Base = BUILDER
            .comment("""
                    Chance for machine to not use fuel. When no casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No fuel used.
                    """)
            .defineInRange("machine.explosive_refiner.chanceToSaveFuel_base", 0.0, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveRefiner_ChanceToSaveFuel_Brightsilver = BUILDER
            .comment("""
                    Chance for machine to not use fuel. When Brightsilver casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No fuel used.
                    """)
            .defineInRange("machine.explosive_refiner.chanceToSaveFuel_Brightsilver", 0.1, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveRefiner_ChanceToSaveFuel_Bungerite = BUILDER
            .comment("""
                    Chance for machine to not use fuel. When Bungerite casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No fuel used.
                    """)
            .defineInRange("machine.explosive_refiner.chanceToSaveFuel_Bungerite", 0.2, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveRefiner_ChanceToSaveFuel_Soulsteel = BUILDER
            .comment("""
                    Chance for machine to not use fuel. When Soulsteel casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No fuel used.
                    """)
            .defineInRange("machine.explosive_refiner.chanceToSaveFuel_Soulsteel", 0.3, 0.0, 1.0);


    /* EXPLOSIVE INFUSER */
    public static final ModConfigSpec.IntValue machineExplosiveInfuser_CraftingDurationTicks = BUILDER
            .comment("Base number of ticks for crafting recipe to complete.")
            .defineInRange("machine.explosive_infuser.craftingDurationTicks", 82, 1, Integer.MAX_VALUE);

    public static final ModConfigSpec.IntValue machineExplosiveInfuser_FuelTankCapacity_Base = BUILDER
            .comment("Capacity of blocks internal fuel tank. When no casing/upgrade is present.")
            .defineInRange("machine.explosive_infuser.fuelTankCapacity_base", 256, 0, Integer.MAX_VALUE);
    public static final ModConfigSpec.IntValue machineExplosiveInfuser_FuelTankCapacity_Brightsilver = BUILDER
            .comment("Capacity of blocks internal fuel tank. When Brightsilver casing/upgrade is present.")
            .defineInRange("machine.explosive_infuser.fuelTankCapacity_Brightsilver", 1024, 0, Integer.MAX_VALUE);
    public static final ModConfigSpec.IntValue machineExplosiveInfuser_FuelTankCapacity_Bungerite = BUILDER
            .comment("Capacity of blocks internal fuel tank. When Bungerite casing/upgrade is present.")
            .defineInRange("machine.explosive_infuser.fuelTankCapacity_Bungerite", 2048, 0, Integer.MAX_VALUE);
    public static final ModConfigSpec.IntValue machineExplosiveInfuser_FuelTankCapacity_Soulsteel = BUILDER
            .comment("Capacity of blocks internal fuel tank. When Soulsteel casing/upgrade is present.")
            .defineInRange("machine.explosive_infuser.fuelTankCapacity_Soulsteel", 8192, 0, Integer.MAX_VALUE);

    public static final ModConfigSpec.DoubleValue machineExplosiveInfuser_CraftingDurationModifier_Base = BUILDER
            .comment("""
                    Crafting duration modifier. When no casing/upgrade is present.
                    CraftingDuration = BaseCraftingDuration - (BaseCraftingDuration * THIS_VALUE).
                    """)
            .defineInRange("machine.explosive_infuser.craftingDurationModifier_base", 0.0, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveInfuser_CraftingDurationModifier_Brightsilver = BUILDER
            .comment("""
                    Crafting duration modifier. When Brightsilver casing/upgrade is present.
                    CraftingDuration = BaseCraftingDuration - (BaseCraftingDuration * THIS_VALUE).
                    """)
            .defineInRange("machine.explosive_infuser.craftingDurationModifier_Brightsilver", 0.15, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveInfuser_CraftingDurationModifier_Bungerite = BUILDER
            .comment("""
                    Crafting duration modifier. When Bungerite casing/upgrade is present.
                    CraftingDuration = BaseCraftingDuration - (BaseCraftingDuration * THIS_VALUE).
                    """)
            .defineInRange("machine.explosive_infuser.craftingDurationModifier_Bungerite", 0.25, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveInfuser_CraftingDurationModifier_Soulsteel = BUILDER
            .comment("""
                    Crafting duration modifier. When Soulsteel casing/upgrade is present.
                    CraftingDuration = BaseCraftingDuration - (BaseCraftingDuration * THIS_VALUE).
                    """)
            .defineInRange("machine.explosive_infuser.craftingDurationModifier_Soulsteel", 0.55, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveInfuser_ChanceToSaveIgnitionSource_Base = BUILDER
            .comment("""
                    Chance for machine to not use ignition source durability. When no casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No durability used.
                    """)
            .defineInRange("machine.explosive_infuser.chanceToSaveIgnitionSource_base", 0.0, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveInfuser_ChanceToSaveIgnitionSource_Brightsilver = BUILDER
            .comment("""
                    Chance for machine to not use ignition source durability. When Brightsilver casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No durability used.
                    """)
            .defineInRange("machine.explosive_infuser.chanceToSaveIgnitionSource_Brightsilver", 0.1, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveInfuser_ChanceToSaveIgnitionSource_Bungerite = BUILDER
            .comment("""
                    Chance for machine to not use ignition source durability. When Bungerite casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No durability used.
                    """)
            .defineInRange("machine.explosive_infuser.chanceToSaveIgnitionSource_Bungerite", 0.2, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveInfuser_ChanceToSaveIgnitionSource_Soulsteel = BUILDER
            .comment("""
                    Chance for machine to not use ignition source durability. When Soulsteel casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No durability used.
                    """)
            .defineInRange("machine.explosive_infuser.chanceToSaveIgnitionSource_Soulsteel", 0.3, 0.0, 1.0);

    public static final ModConfigSpec.DoubleValue machineExplosiveInfuser_ChanceToSaveFuel_Base = BUILDER
            .comment("""
                    Chance for machine to not use fuel. When no casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No fuel used.
                    """)
            .defineInRange("machine.explosive_infuser.chanceToSaveFuel_base", 0.0, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveInfuser_ChanceToSaveFuel_Brightsilver = BUILDER
            .comment("""
                    Chance for machine to not use fuel. When Brightsilver casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No fuel used.
                    """)
            .defineInRange("machine.explosive_infuser.chanceToSaveFuel_Brightsilver", 0.1, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveInfuser_ChanceToSaveFuel_Bungerite = BUILDER
            .comment("""
                    Chance for machine to not use fuel. When Bungerite casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No fuel used.
                    """)
            .defineInRange("machine.explosive_infuser.chanceToSaveFuel_Bungerite", 0.2, 0.0, 1.0);
    public static final ModConfigSpec.DoubleValue machineExplosiveInfuser_ChanceToSaveFuel_Soulsteel = BUILDER
            .comment("""
                    Chance for machine to not use fuel. When Soulsteel casing/upgrade is present.
                    0.0 = No chance to save. 1.0 = No fuel used.
                    """)
            .defineInRange("machine.explosive_infuser.chanceToSaveFuel_Soulsteel", 0.3, 0.0, 1.0);




    public static final ModConfigSpec SPEC = BUILDER.build();

}
