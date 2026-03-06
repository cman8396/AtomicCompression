package com.mcnair.atomic.datagen.extensions;

import net.minecraft.client.data.models.model.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.resources.Identifier;
import net.neoforged.neoforge.client.model.generators.template.ExtendedModelTemplateBuilder;

import static net.minecraft.client.data.models.model.TexturedModel.createDefault;

public class AtomicBlockModelGeneratorsTemplates {
    public static final ModelTemplate CUBE_ORIENTABLE_WITH_SIDES = ExtendedModelTemplateBuilder.builder()
            .parent(Identifier.withDefaultNamespace("block/orientable"))
            .requiredTextureSlot(TextureSlot.TOP)
            .requiredTextureSlot(TextureSlot.BOTTOM)
            .requiredTextureSlot(TextureSlot.FRONT)
            .requiredTextureSlot(TextureSlot.BACK)
            .requiredTextureSlot(TextureSlot.SIDE)
            .build();

    // Base machine texture handling
    public static class MACHINE {
        public static final TexturedModel.Provider TEXTURED_MODEL = createDefault(MACHINE::baseMapping, CUBE_ORIENTABLE_WITH_SIDES);

        public static TextureMapping baseMapping(Block block) {
            return (new TextureMapping())
                    .put(TextureSlot.TOP, getSideTextureInDirectory(block, "top"))
                    .put(TextureSlot.BOTTOM, getSideTextureInDirectory(block, "bottom"))
                    .put(TextureSlot.FRONT, getSideTextureInDirectory(block, "front"))
                    .put(TextureSlot.BACK, getSideTextureInDirectory(block, "back"))
                    .put(TextureSlot.SIDE, getSideTextureInDirectory(block, "side"))
                    .put(TextureSlot.PARTICLE, getSideTextureInDirectory(block, "top"));
        }
    }

    public static Identifier getSideTextureInDirectory(Block block, String sideName) {
        Identifier identifier = BuiltInRegistries.BLOCK.getKey(block);
        return identifier.withPath((blockName) -> "block/" + blockName + "/" + sideName);
    }
}
