package com.mcnair.atomic.screen.helpers;

import com.mcnair.atomic.AtomicCompression;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;

import java.util.ArrayList;
import java.util.List;

public final class ScreenHelpers {
    private ScreenHelpers() {
    }

    public static List<Component> slotHoverBasicTooltip(String translatableKey) {
        List<Component> components = new ArrayList<>(1);
        components.add(Component.translatable(translatableKey).withStyle(ChatFormatting.GRAY));
        return components;
    }

    public static List<Component> slotHoverQuantityOfMaxTooltip(String translatableKey, int value, int maxValue) {
        List<Component> components = new ArrayList<>(2);
        components.add(Component.translatable(translatableKey).withStyle(ChatFormatting.GRAY));
        components.add(Component.literal(value + "/" + maxValue).withStyle(ChatFormatting.GRAY));
        return components;
    }

    public static List<Component> slotHoverMachineInfoTooltip(String casingType, int fuelCapacity, double[] modifierValues) {
        AtomicCompression.LOGGER.info(casingType + ", " + fuelCapacity + ", " + modifierValues[0] + ", " + modifierValues[1] + ", " + modifierValues[2]);
        List<Component> components = new ArrayList<>(1);
        components.add(Component.translatable("tooltip.atomiccompression.machines.info"));
        components.add(Component.translatable("tooltip.atomiccompression.machines.info.casing").append(casingTypeToReadable(casingType)));
        components.add(Component.translatable("tooltip.atomiccompression.machines.info.fuel_tank_capacity").append(String.valueOf(fuelCapacity)));
        components.add(Component.translatable("tooltip.atomiccompression.machines.info.crafting_duration_modifier").append(doubleToPercentage(modifierValues[0], "-")));
        components.add(Component.translatable("tooltip.atomiccompression.machines.info.chance_save_ignition").append(doubleToPercentage(modifierValues[1], "")));
        components.add(Component.translatable("tooltip.atomiccompression.machines.info.chance_save_fuel").append(doubleToPercentage(modifierValues[2], "")));
        return components;
    }

    private static String doubleToPercentage(double input, String leadingChar) {
        return leadingChar + (int) (input * 100) + "%";
    }

    private static String casingTypeToReadable(String type) {
        switch (type) {
            case "bungerite":
                return Component.translatable("general.atomiccompression.bungerite").getString();
            default:
                return Component.translatable("tooltip.atomiccompression.machines.info.casing.none").getString();
        }
    }


}
