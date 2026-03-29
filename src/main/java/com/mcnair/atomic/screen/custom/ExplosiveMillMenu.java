package com.mcnair.atomic.screen.custom;

import com.mcnair.atomic.block.AtomicBlocks;
import com.mcnair.atomic.blockentity.custom.ExplosiveMillBlockEntity;
import com.mcnair.atomic.screen.AtomicMenuTypes;
import com.mcnair.atomic.screen.helpers.MenuHelpers;
import com.mcnair.atomic.utility.AtomicTags;
import com.mcnair.atomic.utility.inventory.InventoryUtils;
import com.mcnair.atomic.utility.inventory.slot.OutputOnlySlot;
import com.mcnair.atomic.utility.inventory.slot.TagLimitedSlot;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.transfer.item.ResourceHandlerSlot;

public class ExplosiveMillMenu extends AbstractContainerMenu {
    public final ExplosiveMillBlockEntity blockEntity;
    private final Level level;
    private final ContainerData data;

    public ExplosiveMillMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData) {
        this(pContainerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(7));
    }

    public ExplosiveMillMenu(int pContainerId, Inventory inv, BlockEntity entity, ContainerData data) {
        super(AtomicMenuTypes.EXPLOSIVE_MILL_MENU.get(), pContainerId);
        checkContainerSize(inv, 6);
        this.blockEntity = ((ExplosiveMillBlockEntity) entity);
        this.level = inv.player.level();
        this.data = data;

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        /* UTILITY SLOTS */
        this.addSlot(new TagLimitedSlot(blockEntity.itemHandler, blockEntity.itemHandler::set, 0, 152, 60, AtomicTags.Values.MACHINE_FUEL));
        this.addSlot(new TagLimitedSlot(blockEntity.itemHandler, blockEntity.itemHandler::set, 1, 8, 36, AtomicTags.Values.MACHINE_IGNITION));
        this.addSlot(new TagLimitedSlot(blockEntity.itemHandler, blockEntity.itemHandler::set, 2, 8, 16, AtomicTags.Values.MACHINE_CASING));

        /* PROCESSING SLOTS */
        // Input
        this.addSlot(new ResourceHandlerSlot(blockEntity.itemHandler, blockEntity.itemHandler::set, 3, 51, 36));
        // Output Primary
        this.addSlot(new OutputOnlySlot(blockEntity.itemHandler, blockEntity.itemHandler::set, 4, 101, 36));
        // Output Secondary
        this.addSlot(new OutputOnlySlot(blockEntity.itemHandler, blockEntity.itemHandler::set, 5, 101, 60));

        addDataSlots(data);
    }

    public boolean isCrafting() {
        return data.get(0) > 0;
    }

    public int getScaledArrowProgress() {
        int progress = this.data.get(0);
        int maxProgress = this.data.get(1);
        int arrowPixelSize = 24;

        return maxProgress != 0 && progress != 0 ? progress * arrowPixelSize / maxProgress : 0;
    }

    public int getScaledStoragePowder() {
        int powder = this.data.get(2);
        int maxPowder = this.data.get(3);
        int texturePixelSize = 48;

        return texturePixelSize - (maxPowder != 0 && powder != 0 ? powder * texturePixelSize / maxPowder : 0);
    }

    public int getCurrentFuel() {
        return this.data.get(2);
    }

    public int getCurrentFuelCapacity() {
        return this.data.get(3);
    }

    public String getCasingType(){
        return InventoryUtils.getCasingType(2, blockEntity.itemHandler);
    }

    public double[] getModifierValues() {
        return new double[]{blockEntity.getCasingDataCraftingDurationModifier(), blockEntity.getCasingDataChanceToSaveIgnitionSource(), blockEntity.getCasingDataChanceToSaveFuel()};
    }

    private static final int THIS_INVENTORY_SLOT_COUNT = 6;  // must be the number of slots you have!

    @Override
    public ItemStack quickMoveStack(Player playerIn, int pIndex) {
        Slot sourceSlot = slots.get(pIndex);
        if (sourceSlot == null || !sourceSlot.hasItem()) return ItemStack.EMPTY;  //EMPTY_ITEM
        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack copyOfSourceStack = sourceStack.copy();

        // Check if the slot clicked is one of the vanilla container slots
        if (pIndex < MenuHelpers.VANILLA_FIRST_SLOT_INDEX + MenuHelpers.VANILLA_SLOT_COUNT) {
            // This is a vanilla container slot so merge the stack into the tile inventory
            if (!moveItemStackTo(sourceStack, MenuHelpers.ATOMIC_FIRST_SLOT_INDEX, MenuHelpers.ATOMIC_FIRST_SLOT_INDEX
                    + THIS_INVENTORY_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;  // EMPTY_ITEM
            }
        } else if (pIndex < MenuHelpers.ATOMIC_FIRST_SLOT_INDEX + THIS_INVENTORY_SLOT_COUNT) {
            // This is a TE slot so merge the stack into the players inventory
            if (!moveItemStackTo(sourceStack, MenuHelpers.VANILLA_FIRST_SLOT_INDEX, MenuHelpers.VANILLA_FIRST_SLOT_INDEX + MenuHelpers.VANILLA_SLOT_COUNT, false)) {
                return ItemStack.EMPTY;
            }
        } else {
            System.out.println("Invalid slotIndex:" + pIndex);
            return ItemStack.EMPTY;
        }
        // If stack size == 0 (the entire stack was moved) set slot contents to null
        if (sourceStack.getCount() == 0) {
            sourceSlot.set(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }
        sourceSlot.onTake(playerIn, sourceStack);
        return copyOfSourceStack;
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(level, blockEntity.getBlockPos()),
                pPlayer, AtomicBlocks.EXPLOSIVE_MILL.get());
    }

    public void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    public void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }
}
