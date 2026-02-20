package com.mcnair.atomic.datagen;

import com.mcnair.atomic.AtomicCompression;
import com.mcnair.atomic.block.AtomicBlocks;
import com.mcnair.atomic.item.AtomicItems;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.data.models.model.TexturedModel;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.stream.Stream;

public class AtomicModelProvider extends ModelProvider {
    public AtomicModelProvider(PackOutput output) {
        super(output, AtomicCompression.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {

        // items
        itemModels.generateFlatItem(AtomicItems.RAW_BUNGERITE.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(AtomicItems.BUNGERITE_INGOT.get(), ModelTemplates.FLAT_ITEM);

//        itemModels.generateFlatItem(AtomicItems.RADISH.get(), ModelTemplates.FLAT_ITEM);
//        itemModels.generateFlatItem(AtomicItems.FROSTFIRE_ICE.get(), ModelTemplates.FLAT_ITEM);
//        itemModels.generateFlatItem(AtomicItems.STARLIGHT_ASHES.get(), ModelTemplates.FLAT_ITEM);
//
//        itemModels.generateFlatItem(AtomicItems.BISMUTH_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
//        itemModels.generateFlatItem(AtomicItems.BISMUTH_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
//        itemModels.generateFlatItem(AtomicItems.BISMUTH_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
//        itemModels.generateFlatItem(AtomicItems.BISMUTH_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
//        itemModels.generateFlatItem(AtomicItems.BISMUTH_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
//        itemModels.generateFlatItem(AtomicItems.BISMUTH_HAMMER.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
//
//        itemModels.generateTrimmableItem(AtomicItems.BISMUTH_HELMET.get(), ModArmorMaterials.BISMUTH, ItemModelGenerators.TRIM_PREFIX_HELMET, false);
//        itemModels.generateTrimmableItem(AtomicItems.BISMUTH_CHESTPLATE.get(), ModArmorMaterials.BISMUTH, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false);
//        itemModels.generateTrimmableItem(AtomicItems.BISMUTH_LEGGINGS.get(), ModArmorMaterials.BISMUTH, ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false);
//        itemModels.generateTrimmableItem(AtomicItems.BISMUTH_BOOTS.get(), ModArmorMaterials.BISMUTH, ItemModelGenerators.TRIM_PREFIX_BOOTS,  false);
//
//        itemModels.generateFlatItem(AtomicItems.KAUPEN_SMITHING_TEMPLATE.get(), ModelTemplates.FLAT_ITEM);
//        itemModels.generateFlatItem(AtomicItems.BISMUTH_HORSE_ARMOR.get(), ModelTemplates.FLAT_ITEM);
//
//        itemModels.generateFlatItem(AtomicItems.BAR_BRAWL_MUSIC_DISC.get(), ModelTemplates.FLAT_ITEM);
//
//        itemModels.generateFlatItem(AtomicItems.GECKO_SPAWN_EGG.get(), ModelTemplates.FLAT_ITEM);
//
//        itemModels.createFlatItemModel(AtomicItems.KAUPEN_BOW.get(), ModelTemplates.BOW);
//        itemModels.generateBow(AtomicItems.KAUPEN_BOW.get());
//
//        ItemModel.Unbaked unbakedChisel = ItemModelUtils.plainModel(itemModels.createFlatItemModel(AtomicItems.CHISEL.get(), ModelTemplates.FLAT_ITEM));
//        ItemModel.Unbaked unbakedUsedChisel = ItemModelUtils.plainModel(itemModels.createFlatItemModel(AtomicItems.CHISEL.get(), "_used", ModelTemplates.FLAT_ITEM));
//        itemModels.itemModelOutput.register(AtomicItems.CHISEL.get(),
//                new ClientItem(new ConditionalItemModel.Unbaked(new HasComponent(ModDataComponents.COORDINATES.get(), false),
//                        unbakedUsedChisel, unbakedChisel),
//                        new ClientItem.Properties(false, false, 1f)));
//
//        itemModels.generateFlatItem(AtomicItems.RADIATION_STAFF.get(), ModelTemplates.FLAT_ITEM);
//
//        /* BLOCKS */
        blockModels.createTrivialCube(AtomicBlocks.SULFUR_ORE.get());
        blockModels.createTrivialCube(AtomicBlocks.SALTPETER_ORE.get());
        blockModels.createTrivialCube(AtomicBlocks.ATOMIC_ORE.get());
        blockModels.createTrivialCube(AtomicBlocks.BUNGERITE_ORE.get());
        blockModels.createTrivialCube(AtomicBlocks.ATOMIC_ORE_NETHER.get());
        blockModels.createTrivialCube(AtomicBlocks.ATOMIC_ORE_END.get());
        blockModels.createGenericCube(AtomicBlocks.DENSE_BASALT.get());


//        blockModels.createRotatableColumn(AtomicBlocks.DENSE_BASALT.get());
//        blockModels.createRotatableColumn(AtomicBlocks.ATOMIC_ORE.get());

//        blockModels.createTrivialCube(AtomicBlocks.BISMUTH_DEEPSLATE_ORE.get());
//        blockModels.createTrivialCube(AtomicBlocks.BISMUTH_END_ORE.get());
//        blockModels.createTrivialCube(AtomicBlocks.BISMUTH_NETHER_ORE.get());
//
//        blockModels.createTrivialCube(AtomicBlocks.MAGIC_BLOCK.get());
//
//        blockModels.family(AtomicBlocks.BISMUTH_BLOCK.get())
//                .fence(AtomicBlocks.BISMUTH_FENCE.get())
//                .fenceGate(AtomicBlocks.BISMUTH_FENCE_GATE.get())
//                .wall(AtomicBlocks.BISMUTH_WALL.get())
//                .stairs(AtomicBlocks.BISMUTH_STAIRS.get())
//                .slab(AtomicBlocks.BISMUTH_SLAB.get())
//                .button(AtomicBlocks.BISMUTH_BUTTON.get())
//                .pressurePlate(AtomicBlocks.BISMUTH_PRESSURE_PLATE.get())
//                .door(AtomicBlocks.BISMUTH_DOOR.get())
//                .trapdoor(AtomicBlocks.BISMUTH_TRAPDOOR.get());
//
//        blockModels.woodProvider(AtomicBlocks.BLOODWOOD_LOG.get()).logWithHorizontal(AtomicBlocks.BLOODWOOD_LOG.get()).wood(AtomicBlocks.BLOODWOOD_WOOD.get());
//        blockModels.woodProvider(AtomicBlocks.STRIPPED_BLOODWOOD_LOG.get()).logWithHorizontal(AtomicBlocks.STRIPPED_BLOODWOOD_LOG.get()).wood(AtomicBlocks.STRIPPED_BLOODWOOD_WOOD.get());
//
//        blockModels.createTrivialCube(AtomicBlocks.BLOODWOOD_PLANKS.get());
//
//        blockModels.createTintedLeaves(AtomicBlocks.BLOODWOOD_LEAVES.get(), TexturedModel.LEAVES, -12012264);
//
//        blockModels.createCropBlock(AtomicBlocks.RADISH_CROP.get(), RadishCropBlock.AGE,  0, 1, 2, 3);
//        blockModels.createCropBlock(AtomicBlocks.GOJI_BERRY_BUSH.get(), GojiBerryBushBlock.AGE,  0, 1, 2, 3);
//
//        blockModels.createCrossBlock(AtomicBlocks.BLOODWOOD_SAPLING.get(), BlockModelGenerators.PlantType.TINTED);
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
