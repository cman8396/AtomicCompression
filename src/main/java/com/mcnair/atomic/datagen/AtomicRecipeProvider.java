package com.mcnair.atomic.datagen;

import com.mcnair.atomic.AtomicCompression;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class AtomicRecipeProvider extends RecipeProvider {
    public AtomicRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
        super(provider, recipeOutput);
    }

    public static class Runner extends RecipeProvider.Runner {
        public Runner(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> provider) {
            super(packOutput, provider);
        }

        @Override
        protected RecipeProvider createRecipeProvider(HolderLookup.Provider provider, RecipeOutput recipeOutput) {
            return new AtomicRecipeProvider(provider, recipeOutput);
        }

        @Override
        public String getName() {
            return "My Recipes";
        }
    }


    @Override
    protected void buildRecipes() {
//        List<ItemLike> BISMUTH_SMELTABLES = List.of(AtomicItems.RAW_BISMUTH,
//                AtomicBlocks.BISMUTH_ORE, AtomicBlocks.BISMUTH_DEEPSLATE_ORE);
//
//        shaped(RecipeCategory.MISC, AtomicBlocks.BISMUTH_BLOCK.get())
//                .pattern("BBB")
//                .pattern("BBB")
//                .pattern("BBB")
//                .define('B', AtomicItems.BISMUTH.get())
//                .unlockedBy("has_bismuth", has(AtomicItems.BISMUTH)).save(output);
//
//        shapeless(RecipeCategory.MISC, AtomicItems.BISMUTH.get(), 9)
//                .requires(AtomicBlocks.BISMUTH_BLOCK)
//                .unlockedBy("has_bismuth_block", has(AtomicBlocks.BISMUTH_BLOCK)).save(output);
//
//        shapeless(RecipeCategory.MISC, AtomicItems.BISMUTH.get(), 18)
//                .requires(AtomicBlocks.MAGIC_BLOCK)
//                .unlockedBy("has_magic_block", has(AtomicBlocks.MAGIC_BLOCK))
//                .save(output, "tutorialmod:bismuth_from_magic_block");
//
//        oreSmelting(output, BISMUTH_SMELTABLES, RecipeCategory.MISC, AtomicItems.BISMUTH.get(), 0.25f, 200, "bismuth");
//        oreBlasting(output, BISMUTH_SMELTABLES, RecipeCategory.MISC, AtomicItems.BISMUTH.get(), 0.25f, 100, "bismuth");
//
//        stairBuilder(AtomicBlocks.BISMUTH_STAIRS.get(), Ingredient.of(AtomicItems.BISMUTH)).group("bismuth")
//                .unlockedBy("has_bismuth", has(AtomicItems.BISMUTH)).save(output);
//        slab(RecipeCategory.BUILDING_BLOCKS, AtomicBlocks.BISMUTH_SLAB.get(), AtomicItems.BISMUTH.get());
//
//        buttonBuilder(AtomicBlocks.BISMUTH_BUTTON.get(), Ingredient.of(AtomicItems.BISMUTH.get())).group("bismuth")
//                .unlockedBy("has_bismuth", has(AtomicItems.BISMUTH.get())).save(output);
//        pressurePlate(AtomicBlocks.BISMUTH_PRESSURE_PLATE.get(), AtomicItems.BISMUTH.get());
//
//        fenceBuilder(AtomicBlocks.BISMUTH_FENCE.get(), Ingredient.of(AtomicItems.BISMUTH.get())).group("bismuth")
//                .unlockedBy("has_bismuth", has(AtomicItems.BISMUTH.get())).save(output);
//        fenceGateBuilder(AtomicBlocks.BISMUTH_FENCE_GATE.get(), Ingredient.of(AtomicItems.BISMUTH.get())).group("bismuth")
//                .unlockedBy("has_bismuth", has(AtomicItems.BISMUTH.get())).save(output);
//        wall(RecipeCategory.BUILDING_BLOCKS, AtomicBlocks.BISMUTH_WALL.get(), AtomicItems.BISMUTH.get());
//
//        doorBuilder(AtomicBlocks.BISMUTH_DOOR.get(), Ingredient.of(AtomicItems.BISMUTH.get())).group("bismuth")
//                .unlockedBy("has_bismuth", has(AtomicItems.BISMUTH.get())).save(output);
//        trapdoorBuilder(AtomicBlocks.BISMUTH_TRAPDOOR.get(), Ingredient.of(AtomicItems.BISMUTH.get())).group("bismuth")
//                .unlockedBy("has_bismuth", has(AtomicItems.BISMUTH.get())).save(output);

        // Throws error
        // trimSmithing(AtomicItems.KAUPEN_SMITHING_TEMPLATE.get(), ResourceKey.create(Registries.TRIM_PATTERN, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "kaupen")),
        //         ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "kaupen")));
    }

    protected void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, AtomicCompression.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
