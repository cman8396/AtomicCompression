package com.mcnair.atomic.screen.helpers;

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

}
