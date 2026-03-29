package com.mcnair.atomic.plugin.category;

import com.mcnair.atomic.utility.AtomicTags;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.builder.ITooltipBuilder;
import mezz.jei.api.gui.ingredient.IRecipeSlotView;
import mezz.jei.api.recipe.RecipeIngredientRole;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.util.CommonColors;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.stream.StreamSupport;

public class CategoryHelpers {
    private CategoryHelpers() {
    }

    public static void StandardOutputPercentages(double[] outputChances, IRecipeSlotView view, ITooltipBuilder tooltip) {
        if (view.isEmpty())
            return;

        tooltip.add(Component.translatable("tooltip.atomiccompression.jei.output_percentages").withColor(CommonColors.SOFT_YELLOW));

        for (int i = 0; i < outputChances.length; i++)
            tooltip.add(Component.literal(String.format(Locale.ENGLISH, "%2d - %.2f%%", i + 1, 100 * outputChances[i])).withColor(CommonColors.SOFT_YELLOW));
    }

    public static void StandardMachineUtilities(IRecipeLayoutBuilder iRecipeLayoutBuilder) {
        List<ItemStack> MACHINE_FUEL = new ArrayList<>(StreamSupport.stream(BuiltInRegistries.ITEM.getTagOrEmpty(AtomicTags.Items.MACHINE_FUEL).spliterator(), false)
                .map(holder -> holder.value().asItem().getDefaultInstance()).toList());
        List<ItemStack> MACHINE_IGNITION = new ArrayList<>(StreamSupport.stream(BuiltInRegistries.ITEM.getTagOrEmpty(AtomicTags.Items.MACHINE_IGNITION).spliterator(), false)
                .map(holder -> holder.value().asItem().getDefaultInstance()).toList());
        List<ItemStack> MACHINE_CASING = new ArrayList<>(StreamSupport.stream(BuiltInRegistries.ITEM.getTagOrEmpty(AtomicTags.Items.MACHINE_CASING).spliterator(), false)
                .map(holder -> holder.value().asItem().getDefaultInstance()).toList());

        MACHINE_FUEL.add(ItemStack.EMPTY);
        MACHINE_CASING.add(ItemStack.EMPTY);

        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.RENDER_ONLY, 132, 32).addItemStacks(MACHINE_FUEL).addRichTooltipCallback((view, tooltip) -> {
            if (view.isEmpty()) return;
            tooltip.add(Component.translatable("tooltip.atomiccompression.jei.machine_fuel_help").withColor(CommonColors.SOFT_YELLOW));
        });
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.RENDER_ONLY, 4, 28).addItemStacks(MACHINE_IGNITION).addRichTooltipCallback((view, tooltip) -> {
            if (view.isEmpty()) return;
            tooltip.add(Component.translatable("tooltip.atomiccompression.jei.machine_ignition_help").withColor(CommonColors.SOFT_YELLOW));
        });
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.RENDER_ONLY, 4, 8).addItemStacks(MACHINE_CASING).addRichTooltipCallback((view, tooltip) -> {
            if (view.isEmpty()) return;
            tooltip.add(Component.translatable("tooltip.atomiccompression.jei.machine_casing_help").withColor(CommonColors.SOFT_YELLOW));
        });
    }
}
