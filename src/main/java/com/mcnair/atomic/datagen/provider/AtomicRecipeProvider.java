package com.mcnair.atomic.datagen.provider;

import com.mcnair.atomic.AtomicCompression;
import com.mcnair.atomic.block.AtomicBlocks;
import com.mcnair.atomic.datagen.extensions.AtomicBlockFamilies;
import com.mcnair.atomic.item.AtomicItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.BlockFamily;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

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

        /* SHAPED RECIPES */
        shaped(RecipeCategory.MISC, Blocks.OBSIDIAN)
                .pattern("CC")
                .pattern("CC")
                .define('C', AtomicItems.OBSIDIAN_CHUNK.get())
                .unlockedBy("has_obsidian", has(Blocks.OBSIDIAN))
                .unlockedBy("has_obsidian_chunk", has(AtomicItems.OBSIDIAN_CHUNK))
                .save(output);
        shaped(RecipeCategory.MISC, AtomicBlocks.ATOMIC_GLASS.get(), 8)
                .pattern("GGG")
                .pattern("GEG")
                .pattern("GGG")
                .define('G', Items.GLASS)
                .define('E', AtomicItems.EMPOWERED_ATOMIC_SHARD.get())
                .unlockedBy("has_empowered_atomic_shard", has(AtomicItems.EMPOWERED_ATOMIC_SHARD))
                .save(output);
        shaped(RecipeCategory.MISC, AtomicBlocks.ATOMIC_GLASS_PANE.get(), 16)
                .pattern("GGG")
                .pattern("GGG")
                .define('G', AtomicBlocks.ATOMIC_GLASS)
                .unlockedBy("has_empowered_atomic_shard", has(AtomicItems.EMPOWERED_ATOMIC_SHARD))
                .save(output);
        shaped(RecipeCategory.MISC, AtomicBlocks.DENSE_BASALT.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', Items.BASALT)
                .unlockedBy("has_basalt", has(Items.BASALT))
                .save(output);
        shaped(RecipeCategory.MISC, AtomicItems.BASALT_TOOL_SHAFT.get())
                .pattern("D")
                .pattern("D")
                .pattern("D")
                .define('D', AtomicBlocks.DENSE_BASALT.get())
                .unlockedBy("has_dense_basalt", has(AtomicBlocks.DENSE_BASALT))
                .save(output);
        shaped(RecipeCategory.MISC, AtomicItems.ATOMIC_STABILIZER.get())
                .pattern("OLO")
                .pattern("L L")
                .pattern("OLO")
                .define('L', AtomicItems.LEAD_INGOT.get())
                .define('O', AtomicItems.OBSIDIAN_CHUNK.get())
                .unlockedBy("has_dense_basalt", has(AtomicBlocks.DENSE_BASALT))
                .unlockedBy("has_obsidian_chunk", has(AtomicItems.OBSIDIAN_CHUNK))
                .unlockedBy("has_lead_ingot", has(AtomicItems.LEAD_INGOT))
                .save(output);
        shaped(RecipeCategory.MISC, AtomicItems.ATOMIC_TOOL_SHAFT.get())
                .pattern(" B ")
                .pattern("AEA")
                .pattern(" B ")
                .define('B', AtomicItems.BASALT_TOOL_SHAFT.get())
                .define('A', AtomicItems.ATOMIC_STABILIZER.get())
                .define('E', AtomicItems.EMPOWERED_ATOMIC_SHARD.get())
                .unlockedBy("has_dense_basalt", has(AtomicBlocks.DENSE_BASALT))
                .unlockedBy("has_lead_ingot", has(AtomicItems.LEAD_INGOT))
                .unlockedBy("has_obsidian_chunk", has(AtomicItems.OBSIDIAN_CHUNK))
                .unlockedBy("has_empowered_atomic_shard", has(AtomicItems.EMPOWERED_ATOMIC_SHARD))
                .unlockedBy("has_atomic_shard", has(AtomicItems.ATOMIC_SHARD))
                .save(output);
        shaped(RecipeCategory.MISC, AtomicItems.EMPOWERED_ATOMIC_SHARD.get())
                .pattern("GGG")
                .pattern("GAG")
                .pattern("GGG")
                .define('G', Items.GUNPOWDER)
                .define('A', AtomicItems.ATOMIC_SHARD.get())
                .unlockedBy("has_atomic_shard", has(AtomicItems.ATOMIC_SHARD))
                .save(output);


        /* SHAPELESS RECIPES */
        oneToManyRecipe(output, AtomicBlocks.DENSE_BASALT, Items.BASALT, 9);
        oneToManyRecipe(output, Items.OBSIDIAN, AtomicItems.OBSIDIAN_CHUNK, 4);

        oneToOneRecipe(output, AtomicItems.RAW_SULFUR, AtomicItems.SULFUR_DUST);
        oneToOneRecipe(output, AtomicItems.RAW_SALTPETER, AtomicItems.SALTPETER_DUST);

        shapeless(RecipeCategory.MISC, Items.GUNPOWDER, 3)
                .requires(AtomicItems.SULFUR_DUST)
                .requires(AtomicItems.SALTPETER_DUST)
                .requires(Ingredient.of(Items.CHARCOAL, Items.COAL))
                .unlockedBy("has_sulfur_dust", has(AtomicItems.SULFUR_DUST))
                .unlockedBy("has_saltpeter_dust", has(AtomicItems.SALTPETER_DUST))
                .save(output);

        shapeless(RecipeCategory.MISC, AtomicItems.BUNGERITE_ALLOY_INGOT, 1)
                .requires(AtomicItems.REFINED_BUNGERITE)
                .requires(Items.NETHERITE_INGOT)
                .unlockedBy("has_refined_bungerite", has(AtomicItems.REFINED_BUNGERITE))
                .unlockedBy("has_netherite_ingot", has(Items.NETHERITE_INGOT))
                .save(output);


        /* NUGGET CONVERSION */
        nuggetIngotRecipe(output, AtomicItems.LEAD_NUGGET, AtomicItems.LEAD_INGOT, RecipeCategory.MISC);
        nuggetIngotRecipe(output, AtomicItems.REFINED_BUNGERITE_NUGGET, AtomicItems.REFINED_BUNGERITE, RecipeCategory.MISC);
        nuggetIngotRecipe(output, AtomicItems.BUNGERITE_ALLOY_NUGGET, AtomicItems.BUNGERITE_ALLOY_INGOT, RecipeCategory.MISC);


        /* SOLID BLOCK CONVERSION */
        ingotBlockRecipe(output, Items.GUNPOWDER, AtomicBlocks.GUNPOWDER_BLOCK, RecipeCategory.MISC);
        ingotBlockRecipe(output, AtomicItems.RAW_SULFUR, AtomicBlocks.RAW_SULFUR_BLOCK, RecipeCategory.MISC);
        ingotBlockRecipe(output, AtomicItems.RAW_SALTPETER, AtomicBlocks.RAW_SALTPETER_BLOCK, RecipeCategory.MISC);
        ingotBlockRecipe(output, AtomicItems.RAW_LEAD, AtomicBlocks.RAW_LEAD_BLOCK, RecipeCategory.MISC);
        ingotBlockRecipe(output, AtomicItems.RAW_BUNGERITE, AtomicBlocks.RAW_BUNGERITE_BLOCK, RecipeCategory.MISC);
        ingotBlockRecipe(output, AtomicItems.SULFUR_DUST, AtomicBlocks.SULFUR_DUST_BLOCK, RecipeCategory.MISC);
        ingotBlockRecipe(output, AtomicItems.SALTPETER_DUST, AtomicBlocks.SALTPETER_DUST_BLOCK, RecipeCategory.MISC);
        ingotBlockRecipe(output, AtomicItems.LEAD_INGOT, AtomicBlocks.LEAD_BLOCK, RecipeCategory.MISC);
        ingotBlockRecipe(output, AtomicItems.REFINED_BUNGERITE, AtomicBlocks.REFINED_BUNGERITE_BLOCK, RecipeCategory.MISC);
        ingotBlockRecipe(output, AtomicItems.BUNGERITE_ALLOY_INGOT, AtomicBlocks.BUNGERITE_ALLOY_BLOCK, RecipeCategory.MISC);
        ingotBlockRecipe(output, AtomicItems.ATOMIC_SHARD, AtomicBlocks.ATOMIC_BLOCK, RecipeCategory.MISC);
        ingotBlockRecipe(output, AtomicItems.EMPOWERED_ATOMIC_SHARD, AtomicBlocks.EMPOWERED_ATOMIC_BLOCK, RecipeCategory.MISC);


        /* SMELTING RECIPES */
        List<ItemLike> leadSmeltables = List.of(AtomicItems.RAW_LEAD, AtomicBlocks.LEAD_ORE, AtomicBlocks.DEEPSLATE_LEAD_ORE);
        oreSmelting(output, leadSmeltables, RecipeCategory.MISC, AtomicItems.LEAD_INGOT.get(), 0.2f, 200, "lead");
        oreBlasting(output, leadSmeltables, RecipeCategory.MISC, AtomicItems.LEAD_INGOT.get(), 0.2f, 100, "lead");

        List<ItemLike> bungeriteSmeltables = List.of(AtomicItems.RAW_BUNGERITE, AtomicBlocks.BUNGERITE_ORE);
        oreSmelting(output, bungeriteSmeltables, RecipeCategory.MISC, AtomicItems.REFINED_BUNGERITE.get(), 0.3f, 200, "bungerite");
        oreBlasting(output, bungeriteSmeltables, RecipeCategory.MISC, AtomicItems.REFINED_BUNGERITE.get(), 0.3f, 100, "bungerite");


        /* TOOLS */
        allTools(output, AtomicItems.BUNGERITE_ALLOY_INGOT, AtomicItems.ATOMIC_TOOL_SHAFT, AtomicItems.BUNGERITE_ALLOY_SWORD, AtomicItems.BUNGERITE_ALLOY_SPEAR, AtomicItems.BUNGERITE_ALLOY_PICKAXE, AtomicItems.BUNGERITE_ALLOY_AXE, AtomicItems.BUNGERITE_ALLOY_SHOVEL, AtomicItems.BUNGERITE_ALLOY_HOE);


        /* WOODEN ITEMS */
        generateRecipesForBlockFamilies(FeatureFlagSet.of(FeatureFlags.VANILLA)); //generates all recipes for wood block families
        woodBlockProcessing(output, AtomicBlocks.ASHENWOOD_PLANKS, AtomicBlocks.ASHENWOOD_LOG, AtomicBlocks.ASHENWOOD_WOOD);

//        addCrystalGrowthChamberRecipe(output, ingredientOf(Tags.Items.GEMS_AMETHYST),
//                new OutputItemStackWithPercentages(new ItemStack(Items.AMETHYST_SHARD), new double[] {
//                        1., 1., .67, .5, .25, .125
//                }), 16000);

//        allWoodenObjects(output, "ashenwood", AtomicBlocks.ASHENWOOD_PLANKS, AtomicBlocks.ASHENWOOD_STAIRS, AtomicBlocks.ASHENWOOD_SLAB, AtomicBlocks.ASHENWOOD_BUTTON, AtomicBlocks.ASHENWOOD_PRESSURE_PLATE, AtomicBlocks.ASHENWOOD_FENCE, AtomicBlocks.ASHENWOOD_FENCE_GATE, AtomicBlocks.ASHENWOOD_WALL, AtomicBlocks.ASHENWOOD_DOOR, AtomicBlocks.ASHENWOOD_TRAPDOOR);


        // Throws error
        // trimSmithing(AtomicItems.KAUPEN_SMITHING_TEMPLATE.get(), ResourceKey.create(Registries.TRIM_PATTERN, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "kaupen")),
        //         ResourceKey.create(Registries.RECIPE, Identifier.fromNamespaceAndPath(TutorialMod.MOD_ID, "kaupen")));
    }

//    private void addCrystalGrowthChamberRecipe(RecipeOutput recipeOutput, Ingredient input, OutputItemStackWithPercentages output,
//                                               int ticks) {
//        addCrystalGrowthChamberRecipe(recipeOutput, new IngredientWithCount(input), output, ticks);
//    }
//    private void addCrystalGrowthChamberRecipe(RecipeOutput recipeOutput, IngredientWithCount input, OutputItemStackWithPercentages output,
//                                               int ticks) {
//        Identifier recipeId = EPAPI.id("crystal_growing/" +
//                getItemName(output.output().getItem()));
//
//        CrystalGrowthChamberRecipe recipe = new CrystalGrowthChamberRecipe(output, input, ticks);
//        recipeOutput.accept(getKey(recipeId), recipe, null);
//    }

    protected void allTools(RecipeOutput recipeOutput, ItemLike ingotItem, ItemLike stickItem, ItemLike swordItem, ItemLike spearItem, ItemLike pickaxeItem, ItemLike axeItem, ItemLike shovelItem, ItemLike hoeItem) {
        shaped(RecipeCategory.COMBAT, swordItem).pattern("I").pattern("I").pattern("S").define('I', ingotItem).define('S', stickItem).unlockedBy("has_" + getItemName(ingotItem), has(ingotItem)).unlockedBy("has_" + getItemName(stickItem), has(stickItem)).save(recipeOutput);
        shaped(RecipeCategory.COMBAT, spearItem).pattern("  I").pattern(" S ").pattern("S  ").define('I', ingotItem).define('S', stickItem).unlockedBy("has_" + getItemName(ingotItem), has(ingotItem)).unlockedBy("has_" + getItemName(stickItem), has(stickItem)).save(recipeOutput);

        shaped(RecipeCategory.TOOLS, pickaxeItem).pattern("III").pattern(" S ").pattern(" S ").define('I', ingotItem).define('S', stickItem).unlockedBy("has_" + getItemName(ingotItem), has(ingotItem)).unlockedBy("has_" + getItemName(stickItem), has(stickItem)).save(recipeOutput);
        shaped(RecipeCategory.TOOLS, axeItem).pattern("I").pattern("S").pattern("S").define('I', ingotItem).define('S', stickItem).unlockedBy("has_" + getItemName(ingotItem), has(ingotItem)).unlockedBy("has_" + getItemName(stickItem), has(stickItem)).save(recipeOutput);
        shaped(RecipeCategory.TOOLS, shovelItem).pattern("II").pattern("IS").pattern(" S").define('I', ingotItem).define('S', stickItem).unlockedBy("has_" + getItemName(ingotItem), has(ingotItem)).unlockedBy("has_" + getItemName(stickItem), has(stickItem)).save(recipeOutput);
        shaped(RecipeCategory.TOOLS, hoeItem).pattern("II").pattern(" S").pattern(" S").define('I', ingotItem).define('S', stickItem).unlockedBy("has_" + getItemName(ingotItem), has(ingotItem)).unlockedBy("has_" + getItemName(stickItem), has(stickItem)).save(recipeOutput);
    }

    protected void oneToOneRecipe(RecipeOutput recipeOutput, ItemLike inputItem, ItemLike outputItem) {
        shapeless(RecipeCategory.MISC, outputItem, 1)
                .requires(inputItem)
                .unlockedBy("has_" + inputItem.asItem().getName(), has(inputItem))
                .unlockedBy("has_" + outputItem.asItem().getName(), has(outputItem))
                .save(recipeOutput);
    }

    protected void oneToManyRecipe(RecipeOutput recipeOutput, ItemLike inputItem, ItemLike outputItem, int resultCount) {
        shapeless(RecipeCategory.MISC, outputItem, resultCount)
                .requires(inputItem)
                .unlockedBy("has_" + inputItem.asItem().getName(), has(inputItem))
                .unlockedBy("has_" + outputItem.asItem().getName(), has(outputItem))
                .save(recipeOutput);
    }

    // Thanks to BiomesOPlenty <3
    protected void generateRecipesForBlockFamilies(FeatureFlagSet flags) {
        AtomicBlockFamilies.getAllFamilies().filter(BlockFamily::shouldGenerateRecipe).forEach((family) -> generateRecipes(family, flags));
    }

    protected void woodBlockProcessing(RecipeOutput recipeOutput, ItemLike plankItem, ItemLike logItem, ItemLike woodItem) {
        shapeless(RecipeCategory.BUILDING_BLOCKS, plankItem, 4)
                .requires(logItem)
                .unlockedBy("has_logs", has(logItem))
                .group("planks")
                .save(recipeOutput);

        woodFromLogs(woodItem, logItem);
    }

    protected void allWoodenObjects(RecipeOutput recipeOutput, String group, ItemLike plankItem, ItemLike stairItem, ItemLike slabItem, ItemLike buttonItem, ItemLike pressurePlateItem, ItemLike fenceItem, ItemLike fenceGateItem, ItemLike wallItem, ItemLike doorItem, ItemLike trapdoorItem) {
        stairBuilder(stairItem, Ingredient.of(plankItem)).group(group).unlockedBy("has_planks", has(plankItem)).save(recipeOutput);
        slab(RecipeCategory.BUILDING_BLOCKS, slabItem, plankItem);
        buttonBuilder(buttonItem, Ingredient.of(plankItem)).group(group).unlockedBy("has_planks", has(plankItem)).save(recipeOutput);
        pressurePlate(pressurePlateItem, plankItem);
        fenceBuilder(fenceItem, Ingredient.of(plankItem)).group(group).unlockedBy("has_planks", has(plankItem)).save(recipeOutput);
        fenceGateBuilder(fenceGateItem, Ingredient.of(plankItem)).group(group).unlockedBy("has_planks", has(plankItem)).save(recipeOutput);
        wall(RecipeCategory.BUILDING_BLOCKS, wallItem, plankItem);
        doorBuilder(doorItem, Ingredient.of(plankItem)).group(group).unlockedBy("has_planks", has(plankItem)).save(recipeOutput);
        trapdoorBuilder(trapdoorItem, Ingredient.of(plankItem)).group(group).unlockedBy("has_planks", has(plankItem)).save(recipeOutput);
    }

    protected void ingotBlockRecipe(RecipeOutput recipeOutput, ItemLike ingotItem, ItemLike blockItem, RecipeCategory pCategory) {
        // Create block > ingot recipe
        shapeless(pCategory, ingotItem, 9)
                .requires(blockItem)
                .unlockedBy("has_" + blockItem.asItem().getName(), has(blockItem))
                .save(recipeOutput, "solidblock_" + getItemName(blockItem) + "_to_" + getItemName(ingotItem));

        // Create ingot > block recipe
        shaped(pCategory, blockItem)
                .pattern("III")
                .pattern("III")
                .pattern("III")
                .define('I', ingotItem)
                .unlockedBy("has_" + ingotItem.asItem().getName(), has(ingotItem))
                .save(recipeOutput, "solidblock_" + getItemName(ingotItem) + "_to_" + getItemName(blockItem));
    }

    protected void nuggetIngotRecipe(RecipeOutput recipeOutput, ItemLike nuggetItem, ItemLike ingotItem, RecipeCategory pCategory) {
        // Create ingot > nugget recipe
        shapeless(pCategory, nuggetItem, 9)
                .requires(ingotItem)
                .unlockedBy("has_" + ingotItem.asItem().getName(), has(ingotItem))
                .save(recipeOutput, "nuggetrecipe_" + getItemName(ingotItem) + "_to_" + getItemName(nuggetItem));

        // Create nugget > ingot recipe
        shaped(pCategory, ingotItem)
                .pattern("NNN")
                .pattern("NNN")
                .pattern("NNN")
                .define('N', nuggetItem)
                .unlockedBy("has_" + nuggetItem.asItem().getName(), has(nuggetItem))
                .save(recipeOutput, "nuggetrecipe_" + getItemName(nuggetItem) + "_to_" + getItemName(ingotItem));
    }

    protected void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, AtomicCompression.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
