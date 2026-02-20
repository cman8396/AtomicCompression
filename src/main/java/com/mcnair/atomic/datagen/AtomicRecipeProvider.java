package com.mcnair.atomic.datagen;

import com.mcnair.atomic.AtomicCompression;
import com.mcnair.atomic.block.AtomicBlocks;
import com.mcnair.atomic.item.AtomicItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.Items;
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

        /* SHAPELESS RECIPES */
        shapeless(RecipeCategory.MISC, Items.BASALT, 9)
                .requires(AtomicBlocks.DENSE_BASALT)
                .unlockedBy("has_dense_basalt", has(AtomicBlocks.DENSE_BASALT))
                .save(output);
        shapeless(RecipeCategory.MISC, Items.GUNPOWDER, 3)
                .requires(AtomicItems.SULFUR_DUST)
                .requires(AtomicItems.SALTPETER_DUST)
                .requires(Ingredient.of(Items.CHARCOAL, Items.COAL))
                .unlockedBy("has_sulfur_dust", has(AtomicItems.SULFUR_DUST))
                .unlockedBy("has_saltpeter_dust", has(AtomicItems.SALTPETER_DUST))
                .save(output);

        shapeless(RecipeCategory.MISC, AtomicItems.SULFUR_DUST, 1)
                .requires(AtomicItems.RAW_SULFUR)
                .unlockedBy("has_raw_sulfur", has(AtomicItems.RAW_SULFUR))
                .save(output);
        shapeless(RecipeCategory.MISC, AtomicItems.SALTPETER_DUST, 1)
                .requires(AtomicItems.RAW_SALTPETER)
                .unlockedBy("has_raw_saltpeter", has(AtomicItems.RAW_SALTPETER))
                .save(output);

        /* SHAPED RECIPES */
        shaped(RecipeCategory.MISC, AtomicBlocks.ATOMIC_GLASS.get())
                .pattern("GGG")
                .pattern("GEG")
                .pattern("GGG")
                .define('G', Items.GLASS)
                .define('E', AtomicItems.EMPOWERED_ATOMIC_SHARD.get())
                .unlockedBy("has_empowered_atomic_shard", has(AtomicItems.EMPOWERED_ATOMIC_SHARD))
                .save(output);
        shaped(RecipeCategory.MISC, AtomicBlocks.DENSE_BASALT.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', Items.BASALT)
                .unlockedBy("has_basalt", has(Items.BASALT))
                .save(output);

        shaped(RecipeCategory.MISC, AtomicItems.EMPOWERED_ATOMIC_SHARD.get())
                .pattern("GGG")
                .pattern("GAG")
                .pattern("GGG")
                .define('G', Items.GUNPOWDER)
                .define('A', AtomicItems.ATOMIC_SHARD.get())
                .unlockedBy("has_atomic_shard", has(AtomicItems.ATOMIC_SHARD))
                .save(output);

        /* SMELTING RECIPES */
        List<ItemLike> BUNGERITE_SMELTABLES = List.of(AtomicItems.RAW_BUNGERITE, AtomicBlocks.BUNGERITE_ORE);
        oreSmelting(output, BUNGERITE_SMELTABLES, RecipeCategory.MISC, AtomicItems.REFINED_BUNGERITE.get(), 0.3f, 200, "bungerite");
        oreBlasting(output, BUNGERITE_SMELTABLES, RecipeCategory.MISC, AtomicItems.REFINED_BUNGERITE.get(), 0.3f, 100, "bungerite");




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
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, AtomicCompression.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
