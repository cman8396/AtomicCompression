package com.mcnair.atomic.datagen.generators;

import com.google.common.collect.ImmutableMap;
import com.mcnair.atomic.block.AtomicBlocks;
import com.mcnair.atomic.datagen.extensions.AtomicBlockFamilies;
import com.mcnair.atomic.datagen.extensions.AtomicBlockModelGeneratorsTemplates;
import net.minecraft.client.color.item.ItemTintSource;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.*;
import net.minecraft.client.data.models.model.*;
import net.minecraft.data.BlockFamily;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static net.minecraft.client.data.models.model.TextureMapping.getBlockTexture;

public class AtomicBlockModelGenerators extends BlockModelGenerators {
    final Map<Block, TexturedModel> texturedModels = ImmutableMap.<Block, TexturedModel>builder()
//                .put(BOPBlocks.WHITE_SANDSTONE, TexturedModel.TOP_BOTTOM_WITH_WALL.get(BOPBlocks.WHITE_SANDSTONE))
//                .put(BOPBlocks.SMOOTH_WHITE_SANDSTONE, TexturedModel.createAllSame(TextureMapping.getBlockTexture(BOPBlocks.WHITE_SANDSTONE, "_top")))
//                .put(BOPBlocks.CHISELED_WHITE_SANDSTONE, TexturedModel.COLUMN.get(BOPBlocks.CHISELED_WHITE_SANDSTONE).updateTextures(p_386968_ -> {
//                    p_386968_.put(TextureSlot.END, TextureMapping.getBlockTexture(BOPBlocks.WHITE_SANDSTONE, "_top"));
//                    p_386968_.put(TextureSlot.SIDE, TextureMapping.getBlockTexture(BOPBlocks.CHISELED_WHITE_SANDSTONE));
//                }))
            .build();

    final Consumer<BlockModelDefinitionGenerator> blockStateOutput;
    final BiConsumer<Identifier, ModelInstance> modelOutput;

    public AtomicBlockModelGenerators(Consumer<BlockModelDefinitionGenerator> blockStateOutput, ItemModelOutput itemModelOutput, BiConsumer<Identifier, ModelInstance> modelOutput) {
        super(blockStateOutput, itemModelOutput, modelOutput);
        this.blockStateOutput = blockStateOutput;
        this.modelOutput = modelOutput;
    }

    @Override
    public void run() {

        /* ORE BLOCKS */
        this.createTrivialCube(AtomicBlocks.SULFUR_ORE.get());
        this.createTrivialCube(AtomicBlocks.DEEPSLATE_SULFUR_ORE.get());
        this.createTrivialCube(AtomicBlocks.SALTPETER_ORE.get());
        this.createTrivialCube(AtomicBlocks.DEEPSLATE_SALTPETER_ORE.get());
        this.createTrivialCube(AtomicBlocks.LEAD_ORE.get());
        this.createTrivialCube(AtomicBlocks.DEEPSLATE_LEAD_ORE.get());
        this.createTrivialCube(AtomicBlocks.BRIGHTSILVER_ORE.get());
        this.createTrivialCube(AtomicBlocks.DEEPSLATE_BRIGHTSILVER_ORE.get());
        this.createTrivialCube(AtomicBlocks.BUNGERITE_ORE.get());
        this.createTrivialCube(AtomicBlocks.SOULSTEEL_ORE.get());
        this.createTrivialCube(AtomicBlocks.ATOMIC_ORE.get());
        this.createTrivialCube(AtomicBlocks.DEEPSLATE_ATOMIC_ORE.get());
        this.createTrivialCube(AtomicBlocks.NETHER_ATOMIC_ORE.get());
        this.createTrivialCube(AtomicBlocks.END_ATOMIC_ORE.get());

        /* UTILITY BLOCKS */
        this.createGlassBlocks(AtomicBlocks.ATOMIC_GLASS.get(), AtomicBlocks.ATOMIC_GLASS_PANE.get());
        this.createAxisAlignedPillarBlock(AtomicBlocks.DENSE_BASALT.get(), TexturedModel.COLUMN);
        this.createTrivialCube(AtomicBlocks.GUNPOWDER_BLOCK.get());
        this.createTrivialCube(AtomicBlocks.RAW_SULFUR_BLOCK.get());
        this.createTrivialCube(AtomicBlocks.RAW_SALTPETER_BLOCK.get());
        this.createTrivialCube(AtomicBlocks.RAW_LEAD_BLOCK.get());
        this.createTrivialCube(AtomicBlocks.RAW_BRIGHTSILVER_BLOCK.get());
        this.createTrivialCube(AtomicBlocks.RAW_BUNGERITE_BLOCK.get());
        this.createTrivialCube(AtomicBlocks.RAW_SOULSTEEL_BLOCK.get());
        this.createTrivialCube(AtomicBlocks.SULFUR_DUST_BLOCK.get());
        this.createTrivialCube(AtomicBlocks.SALTPETER_DUST_BLOCK.get());
        this.createTrivialCube(AtomicBlocks.LEAD_BLOCK.get());
        this.createTrivialCube(AtomicBlocks.BRIGHTSILVER_BLOCK.get());
        this.createTrivialCube(AtomicBlocks.REFINED_BUNGERITE_BLOCK.get());
        this.createTrivialCube(AtomicBlocks.SOULSTEEL_BLOCK.get());
        this.createTrivialCube(AtomicBlocks.BUNGERITE_ALLOY_BLOCK.get());
        this.createTrivialCube(AtomicBlocks.ATOMIC_BLOCK.get());
        this.createTrivialCube(AtomicBlocks.EMPOWERED_ATOMIC_BLOCK.get());

        /* ASHENWOOD BLOCKS */
        this.woodProvider(AtomicBlocks.ASHENWOOD_LOG.get()).logWithHorizontal(AtomicBlocks.ASHENWOOD_LOG.get()).wood(AtomicBlocks.ASHENWOOD_WOOD.get());
        this.woodProvider(AtomicBlocks.STRIPPED_ASHENWOOD_LOG.get()).logWithHorizontal(AtomicBlocks.STRIPPED_ASHENWOOD_LOG.get()).wood(AtomicBlocks.STRIPPED_ASHENWOOD_WOOD.get());
        this.createCrossBlock(AtomicBlocks.ASHENWOOD_SAPLING.get(), BlockModelGenerators.PlantType.TINTED);
        this.createTintedLeaves(AtomicBlocks.ASHENWOOD_LEAVES.get(), TexturedModel.LEAVES, -12012264);
        this.createTintedLeaves(AtomicBlocks.ASHENWOOD_LEAVES_FLOWERING.get(), TexturedModel.LEAVES, -12012264);

        /* BLOCK FAMILIES */
        AtomicBlockFamilies.getAllFamilies()
                .filter(BlockFamily::shouldGenerateModel)
                .forEach(blockFamily -> this.family(blockFamily.getBaseBlock()).generateFor(blockFamily));

        /* ENTITIES */
        createMachine(AtomicBlocks.EXPLOSIVE_MILL.get(), AtomicBlockModelGeneratorsTemplates.MACHINE.TEXTURED_MODEL);
        createMachine(AtomicBlocks.EXPLOSIVE_COMPACTOR.get(), AtomicBlockModelGeneratorsTemplates.MACHINE.TEXTURED_MODEL);
        createMachine(AtomicBlocks.EXPLOSIVE_SEPARATOR.get(), AtomicBlockModelGeneratorsTemplates.MACHINE.TEXTURED_MODEL);
        createMachine(AtomicBlocks.EXPLOSIVE_SMELTER.get(), AtomicBlockModelGeneratorsTemplates.MACHINE.TEXTURED_MODEL);
        createMachine(AtomicBlocks.EXPLOSIVE_REFINER.get(), AtomicBlockModelGeneratorsTemplates.MACHINE.TEXTURED_MODEL);
        createMachine(AtomicBlocks.EXPLOSIVE_INFUSER.get(), AtomicBlockModelGeneratorsTemplates.MACHINE.TEXTURED_MODEL);


//        this.createCropBlock(AtomicBlocks.RADISH_CROP.get(), RadishCropBlock.AGE,  0, 1, 2, 3);
//        this.createCropBlock(AtomicBlocks.GOJI_BERRY_BUSH.get(), GojiBerryBushBlock.AGE,  0, 1, 2, 3);
//
//        this.createTrivialCube(AtomicBlocks.GROWTH_CHAMBER.get());
//
//        this.blockStateOutput.accept(
//                MultiVariantGenerator.dispatch(AtomicBlocks.BISMUTH_LAMP.get())
//                        .with(BlockModelGenerators.createBooleanModelDispatch(BismuthLampBlock.CLICKED,
//                                BlockModelGenerators.plainVariant(this.createSuffixedVariant(AtomicBlocks.BISMUTH_LAMP.get(), "_on", ModelTemplates.CUBE_ALL, TextureMapping::cube)),
//                                BlockModelGenerators.plainVariant(TexturedModel.CUBE.create(AtomicBlocks.BISMUTH_LAMP.get(), this.modelOutput)))));

        // Items that use a separate item texture from their block
//            this.createBlockItemModel(AtomicBlocks.GRASS);
    }


    public void createMachine(Block block, TexturedModel.Provider modelProvider) {
        MultiVariant multivariant = plainVariant(modelProvider.create(block, this.modelOutput));
        Identifier on_identifier = AtomicBlockModelGeneratorsTemplates.getSideTextureInDirectory(block, "front_on");
        MultiVariant multivariant1 = plainVariant(
                modelProvider.get(block)
                        .updateTextures(mapping -> mapping.put(TextureSlot.FRONT, on_identifier))
                        .createWithSuffix(block, "_on", this.modelOutput)
        );
        this.blockStateOutput
                .accept(
                        MultiVariantGenerator.dispatch(block)
                                .with(createBooleanModelDispatch(BlockStateProperties.LIT, multivariant1, multivariant))
                                .with(ROTATION_HORIZONTAL_FACING)
                );
    }

    // Thanks to BiomesOPlenty <3
    @Override
    public BlockModelGenerators.BlockFamilyProvider family(Block block) {
        TexturedModel texturedmodel = this.texturedModels.getOrDefault(block, TexturedModel.CUBE.get(block));
        return new AtomicBlockFamilyProvider(texturedmodel.getMapping()).fullBlock(block, texturedmodel.getTemplate());
    }


    // Thanks to BiomesOPlenty <3
    public void createBlockItemModel(Block block) {
        Identifier Identifier = this.createFlatItemModel(block.asItem());
        this.registerSimpleItemModel(block, Identifier);
    }

    // Thanks to BiomesOPlenty <3
    public void createTintedBlockItemModel(Block block, ItemTintSource tint) {
        Identifier Identifier = this.createFlatItemModel(block.asItem());
        this.registerSimpleTintedItemModel(block, Identifier, tint);
    }

    // Thanks to BiomesOPlenty <3
    public void createTintedItemModel(Block block, ItemTintSource tint) {
        Identifier Identifier = this.createFlatItemModelWithBlockTexture(block.asItem(), block);
        this.registerSimpleTintedItemModel(block, Identifier, tint);
    }

    // Thanks to BiomesOPlenty <3
    public class AtomicBlockFamilyProvider extends BlockFamilyProvider {
        public AtomicBlockFamilyProvider(TextureMapping mapping) {
            super(mapping);
        }

        @Override
        public BlockModelGenerators.BlockFamilyProvider fullBlockVariant(Block block) {
            TexturedModel texturedmodel = AtomicBlockModelGenerators.this.texturedModels.getOrDefault(block, TexturedModel.CUBE.get(block));
            Identifier Identifier = texturedmodel.create(block, AtomicBlockModelGenerators.this.modelOutput);
            AtomicBlockModelGenerators.this.blockStateOutput.accept(BlockModelGenerators.createSimpleBlock(block, plainVariant(Identifier)));
            return this;
        }
    }
}