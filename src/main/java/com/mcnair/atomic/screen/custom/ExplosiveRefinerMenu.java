package com.mcnair.atomic.screen.custom;

import com.mcnair.atomic.block.AtomicBlocks;
import com.mcnair.atomic.blockentity.custom.ExplosiveRefinerBlockEntity;
import com.mcnair.atomic.screen.AtomicMenuTypes;
import com.mcnair.atomic.screen.helpers.MenuHelpers;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.neoforged.neoforge.items.SlotItemHandler;

public class ExplosiveRefinerMenu extends AbstractContainerMenu {
    public final ExplosiveRefinerBlockEntity blockEntity;
    private final Level level;
    private final ContainerData data;

    public ExplosiveRefinerMenu(int pContainerId, Inventory inv, FriendlyByteBuf extraData) {
        this(pContainerId, inv, inv.player.level().getBlockEntity(extraData.readBlockPos()), new SimpleContainerData(7));
    }

    public ExplosiveRefinerMenu(int pContainerId, Inventory inv, BlockEntity entity, ContainerData data) {
        super(AtomicMenuTypes.EXPLOSIVE_REFINER_MENU.get(), pContainerId);
        checkContainerSize(inv, 7);
        this.blockEntity = ((ExplosiveRefinerBlockEntity) entity);
        this.level = inv.player.level();
        this.data = data;

        addPlayerInventory(inv);
        addPlayerHotbar(inv);

        /* UTILITY SLOTS */
        // Powder
        this.addSlot(new SlotItemHandler(blockEntity.itemHandler, 0, 152, 55));
        // Ignition
        this.addSlot(new SlotItemHandler(blockEntity.itemHandler, 1, 152, 35));
        // Casing
        this.addSlot(new SlotItemHandler(blockEntity.itemHandler, 2, 152, 15));

        /* PROCESSING SLOTS */
        // Input Left
        this.addSlot(new SlotItemHandler(blockEntity.itemHandler, 3, 54, 34));
        // Input Right
        this.addSlot(new SlotItemHandler(blockEntity.itemHandler, 4, 34, 34));
        // Output Primary
        this.addSlot(new SlotItemHandler(blockEntity.itemHandler, 5, 104, 34));
        // Output Secondary
        this.addSlot(new SlotItemHandler(blockEntity.itemHandler, 6, 104, 58));

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

    // THIS YOU HAVE TO DEFINE!
    private static final int THIS_INVENTORY_SLOT_COUNT = 7;  // must be the number of slots you have!
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
                pPlayer, AtomicBlocks.EXPLOSIVE_REFINER.get());
    }

    private void addPlayerInventory(Inventory playerInventory) {
        for (int i = 0; i < 3; ++i) {
            for (int l = 0; l < 9; ++l) {
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(Inventory playerInventory) {
        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }
    }
}
