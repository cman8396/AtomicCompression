package com.mcnair.atomic.datagen.extensions;

import com.mcnair.atomic.AtomicCompression;
import com.mcnair.atomic.datagen.generators.AtomicBlockModelGenerators;
import com.mcnair.atomic.datagen.generators.AtomicItemModelGenerators;
import com.mcnair.atomic.utility.external.ModelProviderBase;
import net.minecraft.client.data.models.*;
import net.minecraft.client.data.models.blockstates.BlockModelDefinitionGenerator;
import net.minecraft.client.data.models.model.*;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.Identifier;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

import static net.minecraft.client.data.models.model.TextureMapping.getBlockTexture;


public class AtomicModelProvider extends ModelProviderBase {
    public AtomicModelProvider(PackOutput output) {
        super(output, AtomicCompression.MOD_ID);
    }

    @Override
    protected BlockModelGenerators createBlockModelGenerators(Consumer<BlockModelDefinitionGenerator> blockStateOutput, ItemModelOutput itemModelOutput, BiConsumer<Identifier, ModelInstance> modelOutput) {
        return new AtomicBlockModelGenerators(blockStateOutput, itemModelOutput, modelOutput);
    }

    @Override
    protected ItemModelGenerators createItemModelGenerators(ItemModelOutput itemModelOutput, BiConsumer<Identifier, ModelInstance> biConsumer) {
        return new AtomicItemModelGenerators(itemModelOutput, biConsumer);
    }
}
