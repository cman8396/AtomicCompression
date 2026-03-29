package com.mcnair.atomic.plugin.category;

import com.mcnair.atomic.AtomicCompression;
import com.mcnair.atomic.AtomicConfig;
import com.mcnair.atomic.block.AtomicBlocks;
import com.mcnair.atomic.recipe.base.input.InputItemWithCount;
import com.mcnair.atomic.recipe.recipes.ExplosiveInfuserRecipe;
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
import net.minecraft.util.CommonColors;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeHolder;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static com.mcnair.atomic.plugin.category.CategoryHelpers.StandardMachineUtilities;
import static com.mcnair.atomic.plugin.category.CategoryHelpers.StandardOutputPercentages;

public class ExplosiveInfuserCategory implements IRecipeCategory<RecipeHolder<ExplosiveInfuserRecipe>> {
    public static final IRecipeHolderType<ExplosiveInfuserRecipe> TYPE = IRecipeHolderType.create(ExplosiveInfuserRecipe.Type.INSTANCE);

    private final IDrawable background;
    private final IDrawable icon;

    public ExplosiveInfuserCategory(IGuiHelper helper) {
        Identifier texture = Identifier.fromNamespaceAndPath(AtomicCompression.MOD_ID, "textures/gui/jei.png");
        background = helper.createDrawable(texture, 0, 52, 152, 52);

        icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(AtomicBlocks.EXPLOSIVE_INFUSER.get()));
    }

    @Override
    public IRecipeHolderType<ExplosiveInfuserRecipe> getRecipeType() {
        return TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.atomiccompression.explosive_infuser");
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
    public void setRecipe(IRecipeLayoutBuilder iRecipeLayoutBuilder, RecipeHolder<ExplosiveInfuserRecipe> recipe, IFocusGroup iFocusGroup) {
        int len = Math.min(recipe.value().getInputs().length, 2);
        for (int i = 0; i < len; i++) {
            InputItemWithCount input = recipe.value().getInputs()[i];

            iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.INPUT, 31 + (20 * i), 8).
                    addItemStacks(input.input().items().
                            map(Holder::unwrap).
                            map(registryKeyItemEither -> registryKeyItemEither.map(
                                    l -> new ItemStack(Minecraft.getInstance().level.registryAccess().lookupOrThrow(Registries.ITEM).getOrThrow(l)),
                                    ItemStack::new
                            )).
                            map(itemStack -> itemStack.copyWithCount(input.count())).
                            collect(Collectors.toList()));
        }

        ItemStack[] outputEntries = recipe.value().getMaxOutputCounts();

        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 101, 8).add(outputEntries[0]);
        iRecipeLayoutBuilder.addSlot(RecipeIngredientRole.OUTPUT, 101, 32).
                addItemStacks(outputEntries[1].isEmpty() ? List.of() : List.of(outputEntries[1])).
                addRichTooltipCallback((view, tooltip) ->
                        StandardOutputPercentages(recipe.value().getSecondaryOutput().percentages(), view, tooltip));

        StandardMachineUtilities(iRecipeLayoutBuilder);
    }

    @Override
    public void draw(RecipeHolder<ExplosiveInfuserRecipe> recipe, IRecipeSlotsView iRecipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        background.draw(guiGraphics);
    }
}