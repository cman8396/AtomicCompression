package com.mcnair.atomic.blockentity.custom;

import com.mcnair.atomic.AtomicConfig;
import com.mcnair.atomic.blockentity.AtomicBlockEntities;
import com.mcnair.atomic.blockentity.helpers.AtomicBlockEntityHelpers;
import com.mcnair.atomic.recipe.AtomicRecipes;
import com.mcnair.atomic.recipe.base.MachineBaseRecipeInputHelper;
import com.mcnair.atomic.recipe.base.input.InputItemWithCount;
import com.mcnair.atomic.recipe.recipes.ExplosiveInfuserRecipe;
import com.mcnair.atomic.screen.custom.ExplosiveInfuserMenu;
import com.mcnair.atomic.utility.AtomicTags;
import com.mcnair.atomic.utility.inventory.AtomicItemStackProvider;
import com.mcnair.atomic.utility.inventory.InventoryUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Container;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class ExplosiveInfuserBlockEntity extends BlockEntity implements MenuProvider {
    public final AtomicItemStackProvider itemHandler = new AtomicItemStackProvider(8) {
    };

    public static final float RECIPE_DURATION_MULTIPLIER = 1;

    private static final int[] UTILITY_SLOTS = new int[]{0, 1, 2};
    private static final int[] INPUT_SLOTS = new int[]{3, 4};
    private static final int[] OUTPUT_SLOTS = new int[]{5, 6};

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 0;
    private int fuel = 0;
    private int fuelCapacity = 256;

    public ExplosiveInfuserBlockEntity(BlockPos pos, BlockState blockState) {
        super(AtomicBlockEntities.EXPLOSIVE_INFUSER.get(), pos, blockState);

        data = new ContainerData() {
            @Override
            public int get(int i) {
                return switch (i) {
                    case 0 -> ExplosiveInfuserBlockEntity.this.progress;
                    case 1 -> ExplosiveInfuserBlockEntity.this.maxProgress;
                    case 2 -> ExplosiveInfuserBlockEntity.this.fuel;
                    case 3 -> ExplosiveInfuserBlockEntity.this.fuelCapacity;
                    default -> 0;
                };
            }

            @Override
            public void set(int i, int value) {
                switch (i) {
                    case 0:
                        ExplosiveInfuserBlockEntity.this.progress = value;
                    case 1:
                        ExplosiveInfuserBlockEntity.this.maxProgress = value;
                    case 2:
                        ExplosiveInfuserBlockEntity.this.fuel = value;
                    case 3:
                        ExplosiveInfuserBlockEntity.this.fuelCapacity = value;
                }
            }

            @Override
            public int getCount() {
                return 5;
            }
        };
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        itemHandler.serialize(output);

        output.putInt("entity.progress", progress);
        output.putInt("entity.max_progress", maxProgress);
        output.putInt("entity.fuel", fuel);
        output.putInt("entity.fuel_capacity", fuelCapacity);

        super.saveAdditional(output);
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);

        itemHandler.deserialize(input);
        progress = input.getIntOr("entity.progress", 0);
        maxProgress = input.getIntOr("entity.max_progress", 0);
        fuel = input.getIntOr("entity.fuel", 0);
        fuelCapacity = input.getIntOr("entity.fuel_capacity", 0);
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.atomiccompression.explosive_infuser");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new ExplosiveInfuserMenu(i, inventory, this, this.data);
    }

    @Override
    public void preRemoveSideEffects(BlockPos pos, BlockState state) {
        drops();
        super.preRemoveSideEffects(pos, state);
    }


    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.slotCount);
        for (int i = 0; i < itemHandler.slotCount; i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    private void resetProgress() {
        // Reset the crafting progress to the default.
        progress = 0;
        maxProgress = 0;
    }


    /* MACHINE CONFIG */

    private void loadMachineConfigData() {
        fuelCapacity = getCasingDataFuelTankCapacity();

        int ticks = AtomicConfig.machineExplosiveInfuser_CraftingDurationTicks_Base.getAsInt();
        double modifier = getCasingDataCraftingDurationModifier();
        int tickDeduction = (int) Math.abs(ticks * modifier);

        maxProgress = Math.max(1, ticks - tickDeduction);
    }

    private int getCasingDataFuelTankCapacity() {
        if (InventoryUtils.getCasingType(UTILITY_SLOTS[2], itemHandler) == "refined_bungerite") {
            return AtomicConfig.machineExplosiveInfuser_FuelTankCapacity_RefinedBungerite.getAsInt();
        } else {
            return AtomicConfig.machineExplosiveInfuser_FuelTankCapacity_Base.getAsInt();
        }
    }

    public double getCasingDataCraftingDurationModifier() {
        if (InventoryUtils.getCasingType(UTILITY_SLOTS[2], itemHandler) == "refined_bungerite") {
            return AtomicConfig.machineExplosiveInfuser_CraftingDurationModifier_RefinedBungerite.getAsDouble();
        } else {
            return AtomicConfig.machineExplosiveInfuser_CraftingDurationModifier_Base.getAsDouble();
        }
    }

    public double getCasingDataChanceToSaveIgnitionSource() {
        if (InventoryUtils.getCasingType(UTILITY_SLOTS[2], itemHandler) == "refined_bungerite") {
            return AtomicConfig.machineExplosiveInfuser_ChanceToSaveIgnitionSource_RefinedBungerite.getAsDouble();
        } else {
            return AtomicConfig.machineExplosiveInfuser_ChanceToSaveIgnitionSource_Base.getAsDouble();
        }
    }

    public double getCasingDataChanceToSaveFuel() {
        if (InventoryUtils.getCasingType(UTILITY_SLOTS[2], itemHandler) == "refined_bungerite") {
            return AtomicConfig.machineExplosiveInfuser_ChanceToSaveFuel_RefinedBungerite.getAsDouble();
        } else {
            return AtomicConfig.machineExplosiveInfuser_ChanceToSaveFuel_Base.getAsDouble();
        }
    }


    /* TICKS AND CRAFTING */

    public static void tick(Level level, BlockPos blockPos, BlockState state, ExplosiveInfuserBlockEntity blockEntity) {
        if (level.isClientSide())
            return;

        blockEntity.fuelSlotToInternalTank();
        blockEntity.loadMachineConfigData();

        // Ensure the block has an actual recipe before attempting anything else.
        if (blockEntity.validRecipe()) {
            Optional<RecipeHolder<ExplosiveInfuserRecipe>> recipe = blockEntity.getCurrentRecipe();
            if (recipe.isEmpty())
                return;

            // Check if there is enough fuel for the recipe to complete.
            if (blockEntity.hasIgnitionSource(false) && blockEntity.hasEnoughFuel(blockEntity.fuel)) {

                //Reset progress for invalid values
                if (blockEntity.progress < 0 || blockEntity.maxProgress < 0) {
                    blockEntity.resetProgress();
                    setChanged(level, blockPos, state);
                    return;
                }

                // If current progress is at limit, craft the item, if not increase progress.
                if (blockEntity.progress >= blockEntity.maxProgress) {
                    blockEntity.hasIgnitionSource(true);
                    blockEntity.reduceFuelForCraft(blockEntity);

                    setChanged(level, blockPos, state);

                    blockEntity.craftItem(recipe.get());
                } else
                    blockEntity.progress++;

                blockEntity.onBlockActive();

                setChanged(level, blockPos, state);
            } else {
                // Undo progress if not enough fuel.
                blockEntity.resetProgress();
                blockEntity.onBlockInactive();

                setChanged(level, blockPos, state);
            }
        } else {
            // Undo progress if no valid recipe.
            blockEntity.resetProgress();
            blockEntity.onBlockInactive();

            setChanged(level, blockPos, state);
        }
    }

    /*
     * Note: Might refactor to use the INPUT_SLOTS array instead of standard loop for, as this isn't very readable.
     */
    protected void craftItem(RecipeHolder<ExplosiveInfuserRecipe> recipe) {
        if (level == null || !validRecipe())
            return;

        // Slot offset because utility slots could be before input slots.
        int slotOffset = INPUT_SLOTS[0];

        // Get the allowed inputs for the recipe.
        InputItemWithCount[] inputs = recipe.value().getInputs();

        // Check if the output slots can accept the recipe result
        if (!InventoryUtils.canOutputSlotsAcceptRecipeOutput(recipe.value().getMaxOutputCounts(), itemHandler, OUTPUT_SLOTS))
            return;

        // Get the number of ingredients for the recipe, as they could be different. Might be redundant?
        int ingredientCount = 0;
        for (InputItemWithCount inputItem : inputs)
            ingredientCount += inputItem.input().getValues().size();


        boolean[] slotHasItem = new boolean[ingredientCount];
        // Array to indicate whether an input slot has items in.
        for (int i = 0; i < ingredientCount; i++)
            slotHasItem[i] = itemHandler.getStackInSlot(slotOffset + i).isEmpty();


        int len = Math.min(inputs.length, ingredientCount);
        // Loop through each recipe input item...
        for (int i = 0; i < len; i++) {

            // Get this input item.
            InputItemWithCount input = inputs[i];

            int slotCheckIndex = -1;
            int countToRemove = Integer.MAX_VALUE;

            // Loop through each ingredient...
            for (int j = 0; j < ingredientCount; j++) {

                // If the slot is empty, skip the slot.
                if (slotHasItem[j])
                    continue;

                // Get item in slot.
                ItemStack item = itemHandler.getStackInSlot(slotOffset + j);

                // Check and set the slot to remove from, and the count to remove.
                if (
                        (slotCheckIndex == -1 || item.getCount() < countToRemove) &&
                                input.input().test(item) &&
                                item.getCount() >= input.count()
                ) {
                    slotCheckIndex = j;
                    countToRemove = item.getCount();
                }
            }

            // The ingredient didn't match the item in the slot.
            // This should never be true!
            if (slotCheckIndex == -1)
                return;

            // Set the slot has an item in.
            slotHasItem[slotCheckIndex] = true;

            // Extract the number of items in the recipe from the correct slot.
            itemHandler.extractItem(slotOffset + slotCheckIndex, input.count());
        }

        // Get the output items from the recipe.
        ItemStack[] recipeOutputItems = recipe.value().generateOutputs(level.random);

        // Get the slot index for the primary and secondary slots.
        int primarySlotIndex = OUTPUT_SLOTS[0];
        int secondarySlotIndex = OUTPUT_SLOTS[1];

        // Update the primary slot with thew
        itemHandler.setStackInSlot(
                primarySlotIndex,
                recipeOutputItems[0].copyWithCount(itemHandler.getStackInSlot(primarySlotIndex).getCount() + recipeOutputItems[0].getCount())
        );

        // Do the same for the secondary slot only if the recipe output allows.
        if (!recipeOutputItems[1].isEmpty())
            itemHandler.setStackInSlot(
                    secondarySlotIndex,
                    recipeOutputItems[1].copyWithCount(itemHandler.getStackInSlot(secondarySlotIndex).getCount() + recipeOutputItems[1].getCount())
            );

        // Reset the progress, ready for the next crafting cycle.
        resetProgress();
    }


    /* MODEL STATE CHANGE */

    private void onBlockActive() {
        if (level.getBlockState(getBlockPos()).hasProperty(BlockStateProperties.LIT) &&
                !level.getBlockState(getBlockPos()).getValue(BlockStateProperties.LIT)) {
            level.setBlock(getBlockPos(), getBlockState().setValue(BlockStateProperties.LIT, true), 3);
        }
    }

    private void onBlockInactive() {
        if (level.getBlockState(getBlockPos()).hasProperty(BlockStateProperties.LIT) &&
                level.getBlockState(getBlockPos()).getValue(BlockStateProperties.LIT)) {
            level.setBlock(getBlockPos(), getBlockState().setValue(BlockStateProperties.LIT, false), 3);
        }
    }


    /* RECIPE HANDLING */

    private boolean validRecipe() {
        if (level == null)
            return false;

        SimpleContainer inventory = InventoryUtils.parseInventory(INPUT_SLOTS, itemHandler);
        Optional<RecipeHolder<ExplosiveInfuserRecipe>> recipe = getRecipeFor(inventory);

        return recipe.isPresent() && InventoryUtils.canOutputSlotsAcceptRecipeOutput(recipe.get().value().getMaxOutputCounts(), itemHandler, OUTPUT_SLOTS);
    }

    private RecipeInput getRecipeInput(Container inventory) {
        return new MachineBaseRecipeInputHelper(inventory);
    }

    private Optional<RecipeHolder<ExplosiveInfuserRecipe>> getRecipeFor(Container inventory) {
        if (!(level instanceof ServerLevel serverLevel))
            return Optional.empty();

        return serverLevel.recipeAccess().getRecipeFor(AtomicRecipes.EXPLOSIVE_INFUSER_TYPE.get(), getRecipeInput(inventory), level);
    }

    private Optional<RecipeHolder<ExplosiveInfuserRecipe>> getCurrentRecipe() {
        return getRecipeFor(InventoryUtils.parseInventory(INPUT_SLOTS, itemHandler));
    }


    /* FUEL HANDLING */

    private void reduceFuelForCraft(ExplosiveInfuserBlockEntity blockEntity) {
        if (!InventoryUtils.rollForChance(level, getCasingDataChanceToSaveFuel())) {
            blockEntity.fuel = blockEntity.fuel - AtomicConfig.machineAll_CraftingFuelCost_Base.getAsInt();
        }
    }

    private void fuelSlotToInternalTank() {
        // Get item stack in the fuel slot.
        ItemStack itemStack = itemHandler.getStackInSlot(UTILITY_SLOTS[0]);
        if (!itemStack.isEmpty() && AtomicTags.Helpers.doesItemStackTagMatch(AtomicTags.Values.MACHINE_FUEL, itemStack)) {

            int fuelPerItem = AtomicBlockEntityHelpers.MachineFuel.getFuelValue(itemStack);
            int remainingCapacity = (fuelCapacity - fuel) / fuelPerItem;
            int countToRemove = Math.min(remainingCapacity, itemStack.getCount());

            if (countToRemove <= 0) return;

            // Remove the items from the slot and add to the powder count.
            itemHandler.extractItem(UTILITY_SLOTS[0], countToRemove);
            fuel += countToRemove * fuelPerItem;
        }
    }

    private boolean hasEnoughFuel(int currentFuel) {
        return (currentFuel >= AtomicConfig.machineAll_CraftingFuelCost_Base.getAsInt());
    }

    private boolean hasIgnitionSource(boolean applyDamage) {
        // Get item stack in the ignition slot.
        ItemStack itemStack = itemHandler.getStackInSlot(UTILITY_SLOTS[1]);
        if (!itemStack.isEmpty() && AtomicTags.Helpers.doesItemStackTagMatch(AtomicTags.Values.MACHINE_IGNITION, itemStack)) {
            // If the item in the slot is damageable, damage it.
            if (applyDamage && itemStack.isDamageableItem()) {
                if (!InventoryUtils.rollForChance(level, getCasingDataChanceToSaveIgnitionSource())) {
                    int newDamageValue = itemStack.getDamageValue() + 1;

                    if (newDamageValue >= itemStack.getMaxDamage()) {
                        itemHandler.setStackInSlot(UTILITY_SLOTS[1], ItemStack.EMPTY);
                    } else {
                        itemStack.setDamageValue(newDamageValue);
                        itemHandler.setStackInSlot(1, itemStack);
                    }
                }
            }

            return true;
        } else {
            return false;
        }
    }


    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider pRegistries) {
        return saveWithoutMetadata(pRegistries);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }
}
