package com.mcnair.atomic.plugin.category;

import com.mcnair.atomic.AtomicCompression;
import com.mcnair.atomic.AtomicConfig;
import com.mcnair.atomic.block.AtomicBlocks;
import com.mcnair.atomic.recipe.base.input.InputItemWithCount;
import com.mcnair.atomic.recipe.recipes.ExplosiveSmelterRecipe;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.recipe.types.IRecipeHolderType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static com.mcnair.atomic.plugin.category.CategoryHelpers.StandardMachineUtilities;
import static com.mcnair.atomic.plugin.category.CategoryHelpers.StandardOutputPercentages;

public class ExplosiveSmelterCategory implements IRecipeCategory<RecipeHolder<ExplosiveSmelterRecipe>> {
    public static final IRecipeHolderType<ExplosiveSmelterRecipe> TYPE = IRecipeHolderType.create(ExplosiveSmelterRecipe.Type.INSTANCE);

    private final IDrawable background;
    private final IDrawable icon;

    public ExplosiveSmelterCategory(IGuiHelper helper) {
        Identifier texture = Identifier.fromNamespaceAndPath(AtomicCompression.MOD_ID, "textures/gui/jei.png");
        background = helper.createDrawable(texture, 0, 0, 152, 52);

        icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(AtomicBlocks.EXPLOSIVE_SMELTER.get()));
    }

    @Override
    public IRecipeHolderType<ExplosiveSmelterRecipe> getRecipeType() {
        return TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.atomiccompression.explosive_smelter");
    }

    @Override
    public int getWidth() {
        return background.getWidth();
    }

    @Override
    public int getHeight() {
        return background.getHeight();
    }

    @Override
    public IDrawable getIcon() {
        return icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, RecipeHolder<ExplosiveSmelterRecipe> recipe, IFocusGroup iFocusGroup) {
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 41, 8).add(recipe.value().getInput());

        ItemStack[] outputEntries = recipe.value().getMaxOutputCounts();

        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 91, 8).add(outputEntries[0]);
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 91, 32).
                addItemStacks(outputEntries[1].isEmpty() ? List.of() : List.of(outputEntries[1])).
                addRichTooltipCallback((view, tooltip) ->
                        StandardOutputPercentages(recipe.value().getSecondaryOutput().percentages(), view, tooltip));

        StandardMachineUtilities(iRecipeLayoutBuilder);
    }

    @Override
    public void draw(RecipeHolder<ExplosiveSmelterRecipe> recipe, IRecipeSlotsView iRecipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        background.draw(guiGraphics);
    }
}