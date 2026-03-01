package com.mcnair.atomic.plugin;

import com.mcnair.atomic.AtomicCompression;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import net.minecraft.resources.Identifier;

@JeiPlugin
    public class JEIAtomicPlugin implements IModPlugin {
        @Override
        public Identifier getPluginUid() {
            return Identifier.fromNamespaceAndPath(AtomicCompression.MOD_ID, "jei_plugin");
        }

//        @Override
//        public void registerCategories(IRecipeCategoryRegistration registration) {
//            registration.addRecipeCategories(new GrowthChamberRecipeCategory(
//                    registration.getJeiHelpers().getGuiHelper()));
//        }

//        @Override
//        public void registerRecipes(IRecipeRegistration registration) {
//            RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();
//
//            List<GrowthChamberRecipe> growthChamberRecipes = recipeManager
//                    .getAllRecipesFor(ModRecipes.GROWTH_CHAMBER_TYPE.get()).stream().map(RecipeHolder::value).toList();
//            registration.addRecipes(GrowthChamberRecipeCategory.GROWTH_CHAMBER_RECIPE_RECIPE_TYPE, growthChamberRecipes);
//        }
//
//        @Override
//        public void registerGuiHandlers(IGuiHandlerRegistration registration) {
//            registration.addRecipeClickArea(GrowthChamberScreen.class, 74, 30, 22, 20,
//                    GrowthChamberRecipeCategory.GROWTH_CHAMBER_RECIPE_RECIPE_TYPE);
//        }
    }