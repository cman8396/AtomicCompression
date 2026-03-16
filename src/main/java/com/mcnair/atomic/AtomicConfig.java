package com.mcnair.atomic;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

public class AtomicConfig {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    /* ALL MACHINES */
    public static final ModConfigSpec.IntValue machineAll_FuelConversion_Gunpowders = BUILDER
            .comment("""
                    Amount of fuel a single item of Gunpowder is converted to.
                    Applies to item tag/s: "c:gunpowders".
                    """)
            .defineInRange("machine.fuelConversion_Gunpowders", 4, 0, Integer.MAX_VALUE);

    public static final ModConfigSpec.IntValue machineAll_CraftingFuelCost_Base = BUILDER
            .comment("""
                    Base amount of fuel to use for each crafting cycle.
                    *Some recipes may force a higher/lower cost.*
                    """)
            .defineInRange("machine.craftingFuelCost_Base", 1, 0, Integer.MAX_VALUE);


    /* EXPLOSIVE COMPACTOR */
    public static final ModConfigSpec.IntValue machineExplosiveCompactor_CraftingDurationTicks_Base = BUILDER
            .comment("Base number of ticks for crafting recipe to complete.")
            .defineInRange("machine.explosive_compactor.craftingDurationTicks_Base", 80, 1, Integer.MAX_VALUE);

    public static final ModConfigSpec.DoubleValue machineExplosiveCompactor_CraftingDurationModifier_Base = BUILDER
            .comment("""
                    Base crafting duration modifier. Used when no casing/upgrade is present.
                    CraftingDuration = BaseCraftingDuration - (BaseCraftingDuration * THIS_VALUE).
                    """)
            .defineInRange("machine.explosive_compactor.craftingDurationModifier_base", 0.0, 0.0, Integer.MAX_VALUE);


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
