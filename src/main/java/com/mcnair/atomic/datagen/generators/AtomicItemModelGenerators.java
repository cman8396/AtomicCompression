package com.mcnair.atomic.datagen.generators;

import com.mcnair.atomic.item.AtomicItems;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ItemModelOutput;
import net.minecraft.client.data.models.model.ModelInstance;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.resources.Identifier;

import java.util.function.BiConsumer;

public class AtomicItemModelGenerators extends ItemModelGenerators {
    private final ItemModelOutput itemModelOutput;
    private final BiConsumer<Identifier, ModelInstance> modelOutput;

    public AtomicItemModelGenerators(ItemModelOutput itemModelOutput, BiConsumer<Identifier, ModelInstance> modelOutput) {
        super(itemModelOutput, modelOutput);
        this.itemModelOutput = itemModelOutput;
        this.modelOutput = modelOutput;
    }

    @Override
    public void run() {
        /* ORE DROPS */
        this.generateFlatItem(AtomicItems.ATOMIC_SHARD.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AtomicItems.RAW_SULFUR.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AtomicItems.RAW_SALTPETER.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AtomicItems.RAW_LEAD.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AtomicItems.RAW_BRIGHTSILVER.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AtomicItems.RAW_BUNGERITE.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AtomicItems.RAW_SOULSTEEL.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AtomicItems.DEEPCOAL.get(), ModelTemplates.FLAT_ITEM);

        /* DUSTS */
        this.generateFlatItem(AtomicItems.SAWDUST.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AtomicItems.ATOMIC_DUST.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AtomicItems.SULFUR_DUST.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AtomicItems.SALTPETER_DUST.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AtomicItems.LEAD_DUST.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AtomicItems.BRIGHTSILVER_DUST.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AtomicItems.BUNGERITE_DUST.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AtomicItems.SOULSTEEL_DUST.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AtomicItems.DEEPCOAL_DUST.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AtomicItems.ENDER_DUST.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AtomicItems.DIAMOND_DUST.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AtomicItems.EMERALD_DUST.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AtomicItems.ECHO_DUST.get(), ModelTemplates.FLAT_ITEM);

        /* PROCESSED ITEMS */
        this.generateFlatItem(AtomicItems.EMPOWERED_ATOMIC_SHARD.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AtomicItems.LEAD_INGOT.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AtomicItems.LEAD_NUGGET.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AtomicItems.BRIGHTSILVER_INGOT.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AtomicItems.BRIGHTSILVER_NUGGET.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AtomicItems.BUNGERITE_INGOT.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AtomicItems.BUNGERITE_NUGGET.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AtomicItems.BUNGERITE_ALLOY_INGOT.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AtomicItems.BUNGERITE_ALLOY_NUGGET.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AtomicItems.SOULSTEEL_INGOT.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AtomicItems.SOULSTEEL_NUGGET.get(), ModelTemplates.FLAT_ITEM);

        /* CRAFTING INGREDIENTS */
        this.generateFlatItem(AtomicItems.OBSIDIAN_CHUNK.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AtomicItems.ATOMIC_STABILIZER.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AtomicItems.ASHENWOOD_TOOL_SHAFT.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AtomicItems.BASALT_TOOL_SHAFT.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AtomicItems.OBSIDIAN_TOOL_SHAFT.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AtomicItems.INFUSED_ASHENWOOD_TOOL_SHAFT.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AtomicItems.INFUSED_BASALT_TOOL_SHAFT.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AtomicItems.INFUSED_OBSIDIAN_TOOL_SHAFT.get(), ModelTemplates.FLAT_ITEM);

        /* TOOLS */
        this.generateFlatItem(AtomicItems.BUNGERITE_ALLOY_SWORD.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateSpear(AtomicItems.BUNGERITE_ALLOY_SPEAR.get());
        this.generateFlatItem(AtomicItems.BUNGERITE_ALLOY_SHOVEL.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(AtomicItems.BUNGERITE_ALLOY_PICKAXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(AtomicItems.BUNGERITE_ALLOY_AXE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);
        this.generateFlatItem(AtomicItems.BUNGERITE_ALLOY_HOE.get(), ModelTemplates.FLAT_HANDHELD_ITEM);

        /* MACHINE CASINGS */
        this.generateFlatItem(AtomicItems.BRIGHTSILVER_MACHINE_CASING.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AtomicItems.BUNGERITE_MACHINE_CASING.get(), ModelTemplates.FLAT_ITEM);
        this.generateFlatItem(AtomicItems.SOULSTEEL_MACHINE_CASING.get(), ModelTemplates.FLAT_ITEM);


//        itemModels.generateTrimmableItem(AtomicItems.BISMUTH_HELMET.get(), ModArmorMaterials.BISMUTH, ItemModelGenerators.TRIM_PREFIX_HELMET, false);
//        itemModels.generateTrimmableItem(AtomicItems.BISMUTH_CHESTPLATE.get(), ModArmorMaterials.BISMUTH, ItemModelGenerators.TRIM_PREFIX_CHESTPLATE, false);
//        itemModels.generateTrimmableItem(AtomicItems.BISMUTH_LEGGINGS.get(), ModArmorMaterials.BISMUTH, ItemModelGenerators.TRIM_PREFIX_LEGGINGS, false);
//        itemModels.generateTrimmableItem(AtomicItems.BISMUTH_BOOTS.get(), ModArmorMaterials.BISMUTH, ItemModelGenerators.TRIM_PREFIX_BOOTS,  false);

//        itemModels.createFlatItemModel(AtomicItems.KAUPEN_BOW.get(), ModelTemplates.BOW);
//        itemModels.generateBow(AtomicItems.KAUPEN_BOW.get());

//        ItemModel.Unbaked unbakedChisel = ItemModelUtils.plainModel(itemModels.createFlatItemModel(AtomicItems.CHISEL.get()));
//        ItemModel.Unbaked unbakedUsedChisel = ItemModelUtils.plainModel(itemModels.createFlatItemModel(AtomicItems.CHISEL.get(), "_used"));
//        itemModels.itemModelOutput.register(AtomicItems.CHISEL.get(),
//                new ClientItem(new ConditionalItemModel.Unbaked(new HasComponent(ModDataComponents.COORDINATES.get(), false),
//                        unbakedUsedChisel, unbakedChisel),
//                        new ClientItem.Properties(false, false, 1f)));

    }
}