package com.mcnair.atomic.datagen;

import com.mcnair.atomic.AtomicCompression;
import com.mcnair.atomic.block.AtomicBlocks;
import com.mcnair.atomic.item.AtomicItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.*;
import net.minecraft.client.renderer.block.model.Variant;
import net.minecraft.client.renderer.block.model.VariantMutator;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.EnumProperty;

import java.util.stream.Stream;

import static net.minecraft.client.data.models.BlockModelGenerators.*;
import static net.minecraft.client.data.models.model.TextureMapping.getBlockTexture;

public class AtomicModelProvider extends ModelProvider {
    public AtomicModelProvider(PackOutput output) {
        super(output, AtomicCompression.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {


        /* RAW ITEMS */
        itemModels.generateFlatItem(AtomicItems.ATOMIC_SHARD.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(AtomicItems.RAW_SULFUR.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(AtomicItems.RAW_SALTPETER.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(AtomicItems.RAW_LEAD.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(AtomicItems.RAW_BUNGERITE.get(), ModelTemplates.FLAT_ITEM);

        /* PROCESSED ITEMS */
        itemModels.generateFlatItem(AtomicItems.EMPOWERED_ATOMIC_SHARD.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(AtomicItems.SULFUR_DUST.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(AtomicItems.SALTPETER_DUST.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(AtomicItems.LEAD_INGOT.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(AtomicItems.REFINED_BUNGERITE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(AtomicItems.BUNGERITE_ALLOY_INGOT.get(), ModelTemplates.FLAT_ITEM);

        /* NUGGETS */
        itemModels.generateFlatItem(AtomicItems.LEAD_NUGGET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(AtomicItems.REFINED_BUNGERITE_NUGGET.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(AtomicItems.BUNGERITE_ALLOY_NUGGET.get(), ModelTemplates.FLAT_ITEM);

        /* BUNGERITE TOOLS */
        itemModels.generateFlatItem(AtomicItems.BUNGERITE_ALLOY_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(AtomicItems.BUNGERITE_ALLOY_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(AtomicItems.BUNGERITE_ALLOY_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(AtomicItems.BUNGERITE_ALLOY_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        itemModels.generateFlatItem(AtomicItems.BUNGERITE_ALLOY_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);


//        itemModels.generateTrimmableItem(AtomicItems.BISMUTH_HELMET.get(), ModArmorMaterials.BISMUTH, ItemModelGenerators.TRIM_PREFIX_HELMET, false);
//        itemModels.generateTrimmableItem(AtomicItems.BISMUTH_CHESTPLATE.get(), ModArmorMaterials.BISMUTH, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false);
//        itemModels.generateTrimmableItem(AtomicItems.BISMUTH_LEGGINGS.get(), ModArmorMaterials.BISMUTH, ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false);
//        itemModels.generateTrimmableItem(AtomicItems.BISMUTH_BOOTS.get(), ModArmorMaterials.BISMUTH, ItemModelGenerators.TRIM_PREFIX_BOOTS,  false);

//        itemModels.createFlatItemModel(AtomicItems.KAUPEN_BOW.get(), ModelTemplates.BOW);
//        itemModels.generateBow(AtomicItems.KAUPEN_BOW.get());

//        ItemModel.Unbaked unbakedChisel = ItemModelUtils.plainModel(itemModels.createFlatItemModel(AtomicItems.CHISEL.get(), ModelTemplates.FLAT_ITEM));
//        ItemModel.Unbaked unbakedUsedChisel = ItemModelUtils.plainModel(itemModels.createFlatItemModel(AtomicItems.CHISEL.get(), "_used", ModelTemplates.FLAT_ITEM));
//        itemModels.itemModelOutput.register(AtomicItems.CHISEL.get(),
//                new ClientItem(new ConditionalItemModel.Unbaked(new HasComponent(ModDataComponents.COORDINATES.get(), false),
//                        unbakedUsedChisel, unbakedChisel),
//                        new ClientItem.Properties(false, false, 1f)));



        /* ORE BLOCKS */
        blockModels.createTrivialCube(AtomicBlocks.SULFUR_ORE.get());
        blockModels.createTrivialCube(AtomicBlocks.DEEPSLATE_SULFUR_ORE.get());
        blockModels.createTrivialCube(AtomicBlocks.SALTPETER_ORE.get());
        blockModels.createTrivialCube(AtomicBlocks.DEEPSLATE_SALTPETER_ORE.get());
        blockModels.createTrivialCube(AtomicBlocks.LEAD_ORE.get());
        blockModels.createTrivialCube(AtomicBlocks.DEEPSLATE_LEAD_ORE.get());
        blockModels.createTrivialCube(AtomicBlocks.ATOMIC_ORE.get());
        blockModels.createTrivialCube(AtomicBlocks.DEEPSLATE_ATOMIC_ORE.get());
        blockModels.createTrivialCube(AtomicBlocks.BUNGERITE_ORE.get());
        blockModels.createTrivialCube(AtomicBlocks.NETHER_ATOMIC_ORE.get());
        blockModels.createTrivialCube(AtomicBlocks.END_ATOMIC_ORE.get());

        /* UTILITY BLOCKS */
        blockModels.createGlassBlocks(AtomicBlocks.ATOMIC_GLASS.get(), AtomicBlocks.ATOMIC_GLASS_PANE.get());
        blockModels.createAxisAlignedPillarBlock(AtomicBlocks.DENSE_BASALT.get(), TexturedModel.COLUMN);
        blockModels.createTrivialCube(AtomicBlocks.GUNPOWDER_BLOCK.get());
        blockModels.createTrivialCube(AtomicBlocks.RAW_SULFUR_BLOCK.get());
        blockModels.createTrivialCube(AtomicBlocks.RAW_SALTPETER_BLOCK.get());
        blockModels.createTrivialCube(AtomicBlocks.RAW_LEAD_BLOCK.get());
        blockModels.createTrivialCube(AtomicBlocks.RAW_BUNGERITE_BLOCK.get());
        blockModels.createTrivialCube(AtomicBlocks.SULFUR_DUST_BLOCK.get());
        blockModels.createTrivialCube(AtomicBlocks.SALTPETER_DUST_BLOCK.get());
        blockModels.createTrivialCube(AtomicBlocks.LEAD_BLOCK.get());
        blockModels.createTrivialCube(AtomicBlocks.REFINED_BUNGERITE_BLOCK.get());
        blockModels.createTrivialCube(AtomicBlocks.BUNGERITE_ALLOY_BLOCK.get());
        blockModels.createTrivialCube(AtomicBlocks.ATOMIC_BLOCK.get());
        blockModels.createTrivialCube(AtomicBlocks.EMPOWERED_ATOMIC_BLOCK.get());

        /* ASHENWOOD BLOCKS */
        blockModels.woodProvider(AtomicBlocks.ASHENWOOD_LOG.get()).logWithHorizontal(AtomicBlocks.ASHENWOOD_LOG.get()).wood(AtomicBlocks.ASHENWOOD_WOOD.get());
        blockModels.woodProvider(AtomicBlocks.STRIPPED_ASHENWOOD_LOG.get()).logWithHorizontal(AtomicBlocks.STRIPPED_ASHENWOOD_LOG.get()).wood(AtomicBlocks.STRIPPED_ASHENWOOD_WOOD.get());
        blockModels.createCrossBlock(AtomicBlocks.ASHENWOOD_SAPLING.get(), BlockModelGenerators.PlantType.TINTED);
        blockModels.createTintedLeaves(AtomicBlocks.ASHENWOOD_LEAVES.get(), TexturedModel.LEAVES, -12012264);
        blockModels.createTintedLeaves(AtomicBlocks.ASHENWOOD_LEAVES_FLOWERING.get(), TexturedModel.LEAVES, -12012264);
        blockModels.family(AtomicBlocks.ASHENWOOD_PLANKS.get())
                .stairs(AtomicBlocks.ASHENWOOD_STAIRS.get())
                .slab(AtomicBlocks.ASHENWOOD_SLAB.get())
                .pressurePlate(AtomicBlocks.ASHENWOOD_PRESSURE_PLATE.get())
                .button(AtomicBlocks.ASHENWOOD_BUTTON.get())
                .fence(AtomicBlocks.ASHENWOOD_FENCE.get())
                .fenceGate(AtomicBlocks.ASHENWOOD_FENCE_GATE.get())
                .wall(AtomicBlocks.ASHENWOOD_WALL.get())
                .door(AtomicBlocks.ASHENWOOD_DOOR.get())
                .trapdoor(AtomicBlocks.ASHENWOOD_TRAPDOOR.get());

        /* ENTITIES */


//
//        blockModels.createCropBlock(AtomicBlocks.RADISH_CROP.get(), RadishCropBlock.AGE,  0, 1, 2, 3);
//        blockModels.createCropBlock(AtomicBlocks.GOJI_BERRY_BUSH.get(), GojiBerryBushBlock.AGE,  0, 1, 2, 3);
//
//        blockModels.createTrivialCube(AtomicBlocks.GROWTH_CHAMBER.get());
//
//        blockModels.blockStateOutput.accept(
//                MultiVariantGenerator.dispatch(AtomicBlocks.BISMUTH_LAMP.get())
//                        .with(BlockModelGenerators.createBooleanModelDispatch(BismuthLampBlock.CLICKED,
//                                BlockModelGenerators.plainVariant(blockModels.createSuffixedVariant(AtomicBlocks.BISMUTH_LAMP.get(), "_on", ModelTemplates.CUBE_ALL, TextureMapping::cube)),
//                                BlockModelGenerators.plainVariant(TexturedModel.CUBE.create(AtomicBlocks.BISMUTH_LAMP.get(), blockModels.modelOutput)))));
    }

    @Override
    protected Stream<? extends Holder<Block>> getKnownBlocks() {
        return AtomicBlocks.BLOCKS.getEntries().stream();
        //.filter(x -> !x.is(AtomicBlocks.PEDESTAL) && !x.is(AtomicBlocks.CHAIR));
    }

    @Override
    protected Stream<? extends Holder<Item>> getKnownItems() {
        return AtomicItems.ITEMS.getEntries().stream();
        //.filter(x -> x.get() != AtomicBlocks.PEDESTAL.asItem() && x.get() != AtomicBlocks.CHAIR.asItem() && !x.is(AtomicItems.TOMAHAWK));
    }
}
