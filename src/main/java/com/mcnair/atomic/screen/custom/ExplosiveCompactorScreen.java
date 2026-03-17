package com.mcnair.atomic.screen.custom;

import com.mcnair.atomic.AtomicCompression;
import com.mcnair.atomic.screen.helpers.ScreenHelpers;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;

import java.util.Optional;

public class ExplosiveCompactorScreen extends AbstractContainerScreen<ExplosiveCompactorMenu> {
    private static final Identifier GUI_TEXTURE =
            Identifier.fromNamespaceAndPath(AtomicCompression.MOD_ID, "textures/gui/explosive_compactor.png");
    private static final Identifier ARROW_TEXTURE =
            Identifier.fromNamespaceAndPath(AtomicCompression.MOD_ID, "textures/gui/arrow_progress.png");
    private static final Identifier PROCESS_ICON =
            Identifier.fromNamespaceAndPath(AtomicCompression.MOD_ID, "textures/gui/active_icons/active_compactor.png");
    private static final Identifier FUEL_TANK_TEXTURE =
            Identifier.fromNamespaceAndPath(AtomicCompression.MOD_ID, "textures/gui/tanks/tank_fuel.png");

    private static final Identifier BUTTONS =
            Identifier.fromNamespaceAndPath(AtomicCompression.MOD_ID, "textures/gui/buttons.png");

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
        renderInformation(guiGraphics, x, y);
    }

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y) {
        if (menu.isCrafting()) {
            guiGraphics.blit(RenderPipelines.GUI_TEXTURED, ARROW_TEXTURE, x + 82, y + 37, 0, 0, menu.getScaledArrowProgress(), 16, 24, 16);
            guiGraphics.blit(RenderPipelines.GUI_TEXTURED, PROCESS_ICON, x + 54, y + 55, 0, 0, 16, 16, 16, 16);
        }
    }

    private void renderStoragePowder(GuiGraphics guiGraphics, int x, int y) {
        guiGraphics.blit(RenderPipelines.GUI_TEXTURED, FUEL_TANK_TEXTURE, x + 152, y + 10, 16, 0, 16, 48, 32, 64);
        guiGraphics.blit(RenderPipelines.GUI_TEXTURED, FUEL_TANK_TEXTURE, x + 152, y + 10, 0, 0, 16, menu.getScaledStoragePowder(), 32, 64);
    }

    protected void renderInformation(GuiGraphics guiGraphics, int x, int y) {
        guiGraphics.blit(RenderPipelines.GUI_TEXTURED, BUTTONS, x + 7, y + 55, 15, 0, 5, 7, 64, 64);
    }

    protected void renderVariousTooltips(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        if (isHovering(152, 60, 16, 16, mouseX, mouseY)) {
            guiGraphics.setTooltipForNextFrame(font, ScreenHelpers.slotHoverBasicTooltip("tooltip.atomiccompression.machines.fuel"), Optional.empty(), mouseX, mouseY);
        } else if (isHovering(8, 36, 16, 16, mouseX, mouseY)) {
            guiGraphics.setTooltipForNextFrame(font, ScreenHelpers.slotHoverBasicTooltip("tooltip.atomiccompression.machines.ignition_source"), Optional.empty(), mouseX, mouseY);
        } else if (isHovering(8, 16, 16, 16, mouseX, mouseY)) {
            guiGraphics.setTooltipForNextFrame(font, ScreenHelpers.slotHoverBasicTooltip("tooltip.atomiccompression.machines.casing_upgrade"), Optional.empty(), mouseX, mouseY);
        } else if (isHovering(152, 9, 16, 48, mouseX, mouseY)) {
            // Fuel tank
            guiGraphics.setTooltipForNextFrame(font, ScreenHelpers.slotHoverQuantityOfMaxTooltip("tooltip.atomiccompression.machines.fuel", menu.getCurrentFuel(), menu.getCurrentFuelCapacity()), Optional.empty(), mouseX, mouseY);
        } else if (isHovering(7, 55, 5, 7, mouseX, mouseY)) {
            // Info icon
            guiGraphics.setTooltipForNextFrame(font, ScreenHelpers.slotHoverMachineInfoTooltip(menu.getCasingType(), menu.getCurrentFuelCapacity(), menu.getModifierValues()), Optional.empty(), mouseX, mouseY);
        }
    }

//    public boolean isPointInRect(int rectX, int rectY, int rectWidth, int rectHeight, double pointX, double pointY) {
//        return super.isHovering(rectX, rectY, rectWidth, rectHeight, pointX, pointY);
//    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        this.renderTooltip(pGuiGraphics, pMouseX, pMouseY);
    }

    @Override
    protected final void renderTooltip(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        super.renderTooltip(guiGraphics, mouseX, mouseY);
        renderVariousTooltips(guiGraphics, mouseX, mouseY);
    }
}
