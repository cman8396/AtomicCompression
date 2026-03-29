package com.mcnair.atomic.plugin;

import com.mcnair.atomic.AtomicCompression;
import com.mcnair.atomic.block.AtomicBlocks;
import com.mcnair.atomic.plugin.category.*;
import com.mcnair.atomic.recipe.AtomicRecipes;
import com.mcnair.atomic.recipe.recipes.*;
import com.mcnair.atomic.screen.custom.*;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.constants.RecipeTypes;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeMap;

import java.util.ArrayList;
import java.util.List;


@JeiPlugin
public class JEIAtomicPlugin implements IModPlugin {
    public static RecipeMap recipeMap = null;

    @Override
    public Identifier getPluginUid() {
        return Identifier.fromNamespaceAndPath(AtomicCompression.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(
                new ExplosiveMillCategory(registration.getJeiHelpers().getGuiHelper()),
                new ExplosiveCompactorCategory(registration.getJeiHelpers().getGuiHelper()),
                new ExplosiveSeparatorCategory(registration.getJeiHelpers().getGuiHelper()),
                new ExplosiveSmelterCategory(registration.getJeiHelpers().getGuiHelper()),
                new ExplosiveRefinerCategory(registration.getJeiHelpers().getGuiHelper()),
                new ExplosiveInfuserCategory(registration.getJeiHelpers().getGuiHelper())
        );
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        if (recipeMap != null) {
            registration.addRecipes(ExplosiveMillCategory.TYPE, new ArrayList<>(recipeMap.byType(ExplosiveMillRecipe.Type.INSTANCE)));
            registration.addRecipes(ExplosiveCompactorCategory.TYPE, new ArrayList<>(recipeMap.byType(ExplosiveCompactorRecipe.Type.INSTANCE)));
            registration.addRecipes(ExplosiveSeparatorCategory.TYPE, new ArrayList<>(recipeMap.byType(ExplosiveSeparatorRecipe.Type.INSTANCE)));
            registration.addRecipes(ExplosiveSmelterCategory.TYPE, new ArrayList<>(recipeMap.byType(ExplosiveSmelterRecipe.Type.INSTANCE)));
            registration.addRecipes(ExplosiveRefinerCategory.TYPE, new ArrayList<>(recipeMap.byType(ExplosiveRefinerRecipe.Type.INSTANCE)));
            registration.addRecipes(ExplosiveInfuserCategory.TYPE, new ArrayList<>(recipeMap.byType(ExplosiveInfuserRecipe.Type.INSTANCE)));
        }
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
//        registration.addCraftingStation(RecipeTypes.SMELTING, new ItemStack(AtomicBlocks.EXPLOSIVE_SMELTER.get()));

        registration.addCraftingStation(ExplosiveMillCategory.TYPE, new ItemStack(AtomicBlocks.EXPLOSIVE_MILL.get()));
        registration.addCraftingStation(ExplosiveCompactorCategory.TYPE, new ItemStack(AtomicBlocks.EXPLOSIVE_COMPACTOR.get()));
        registration.addCraftingStation(ExplosiveSeparatorCategory.TYPE, new ItemStack(AtomicBlocks.EXPLOSIVE_SEPARATOR.get()));
        registration.addCraftingStation(ExplosiveSmelterCategory.TYPE, new ItemStack(AtomicBlocks.EXPLOSIVE_SMELTER.get()));
        registration.addCraftingStation(ExplosiveRefinerCategory.TYPE, new ItemStack(AtomicBlocks.EXPLOSIVE_REFINER.get()));
        registration.addCraftingStation(ExplosiveInfuserCategory.TYPE, new ItemStack(AtomicBlocks.EXPLOSIVE_INFUSER.get()));
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(ExplosiveMillScreen.class, 70, 37, 24, 16, ExplosiveMillCategory.TYPE);
        registration.addRecipeClickArea(ExplosiveCompactorScreen.class, 82, 37, 24, 16, ExplosiveCompactorCategory.TYPE);
        registration.addRecipeClickArea(ExplosiveSeparatorScreen.class, 70, 37, 24, 16, ExplosiveSeparatorCategory.TYPE);
        registration.addRecipeClickArea(ExplosiveSmelterScreen.class, 70, 37, 24, 16, ExplosiveSmelterCategory.TYPE);
        registration.addRecipeClickArea(ExplosiveRefinerScreen.class, 82, 37, 24, 16, ExplosiveRefinerCategory.TYPE);
        registration.addRecipeClickArea(ExplosiveInfuserScreen.class, 82, 37, 24, 16, ExplosiveInfuserCategory.TYPE);
    }

}