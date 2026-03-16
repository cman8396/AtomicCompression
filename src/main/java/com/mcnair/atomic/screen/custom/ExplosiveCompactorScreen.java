package com.mcnair.atomic.screen.custom;

import com.mcnair.atomic.AtomicCompression;
import com.mcnair.atomic.screen.helpers.ScreenHelpers;
import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ExplosiveCompactorScreen extends AbstractContainerScreen<ExplosiveCompactorMenu> {
    private static final Identifier GUI_TEXTURE =
            Identifier.fromNamespaceAndPath(AtomicCompression.MOD_ID, "textures/gui/explosive_compactor.png");
    private static final Identifier ARROW_TEXTURE =
            Identifier.fromNamespaceAndPath(AtomicCompression.MOD_ID, "textures/gui/arrow_progress.png");
    private static final Identifier PROCESS_ICON =
            Identifier.fromNamespaceAndPath(AtomicCompression.MOD_ID, "textures/gui/active_compactor.png");
    private static final Identifier POWDER_STORAGE_TEXTURE =
            Identifier.fromNamespaceAndPath(AtomicCompression.MOD_ID, "textures/gui/storage_powder.png");

    public ExplosiveCompactorScreen(ExplosiveCompactorMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float v, int i, int i1) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(RenderPipelines.GUI_TEXTURED, GUI_TEXTURE, x, y, 0, 0, imageWidth, imageHeight, 256, 256);

        renderProgressArrow(guiGraphics, x, y);
        renderStoragePowder(guiGraphics, x, y);
    }

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y) {
        if (menu.isCrafting()) {
            guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ARROW_TEXTURE, x + 73, y + 35, 0, 0, menu.getScaledArrowProgress(), 16, 24, 16);
            guiGraphics.blit(RenderPipelines.GUI_TEXTURED, PROCESS_ICON, x + 45, y + 53, 0, 0, 16, 16, 16, 16);
        }
    }

    private void renderStoragePowder(GuiGraphics guiGraphics, int x, int y) {
        guiGraphics.blit(RenderPipelines.GUI_TEXTURED, POWDER_STORAGE_TEXTURE, x + 7, y + 19, 16, 0, 16, 48, 32, 64);
        guiGraphics.blit(RenderPipelines.GUI_TEXTURED, POWDER_STORAGE_TEXTURE, x + 7, y + 19, 0, 0, 16, menu.getScaledStoragePowder(), 32, 64);
    }

    protected void renderTooltipUtilitySlots(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        if (isHovering(152, 55, 16, 16, mouseX, mouseY)) {
            guiGraphics.setTooltipForNextFrame(font, ScreenHelpers.slotHoverBasicTooltip("tooltip.atomiccompression.machines.fuel"), Optional.empty(), mouseX, mouseY);
        } else if (isHovering(152, 35, 16, 16, mouseX, mouseY)) {
            guiGraphics.setTooltipForNextFrame(font, ScreenHelpers.slotHoverBasicTooltip("tooltip.atomiccompression.machines.ignition_source"), Optional.empty(), mouseX, mouseY);
        } else if (isHovering(152, 15, 16, 16, mouseX, mouseY)) {
            guiGraphics.setTooltipForNextFrame(font, ScreenHelpers.slotHoverBasicTooltip("tooltip.atomiccompression.machines.casing_upgrade"), Optional.empty(), mouseX, mouseY);
        } else if (isHovering(8, 19, 16, 48, mouseX, mouseY)) {
            guiGraphics.setTooltipForNextFrame(font, ScreenHelpers.slotHoverQuantityOfMaxTooltip("tooltip.atomiccompression.machines.fuel", menu.getDataPowder(), menu.getDataMaxPowder()), Optional.empty(), mouseX, mouseY);
        }
    }

    protected void renderButtons(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        // 141,64
    }

    protected void renderInformation(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        // 141,14
    }


    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        this.renderTooltip(pGuiGraphics, pMouseX, pMouseY);
    }

    @Override
    protected final void renderTooltip(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        super.renderTooltip(guiGraphics, mouseX, mouseY);
        renderTooltipUtilitySlots(guiGraphics, mouseX, mouseY);
    }
}
