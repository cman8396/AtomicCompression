package com.mcnair.atomic.recipe.recipes;

import com.mcnair.atomic.AtomicCompression;
import com.mcnair.atomic.recipe.AtomicRecipes;
import com.mcnair.atomic.recipe.base.MachineBasicRecipe;
import com.mcnair.atomic.recipe.base.input.InputItemWithCount;
import com.mcnair.atomic.recipe.base.output.OutputItemWithPercent;
import com.mcnair.atomic.utility.external.ArrayCodec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.Identifier;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;


public class ExplosiveInfuserRecipe implements MachineBasicRecipe<RecipeInput> {
    private final ItemStack output;
    private final OutputItemWithPercent secondaryOutput;
    private final InputItemWithCount[] inputs;

    public ExplosiveInfuserRecipe(ItemStack output, OutputItemWithPercent secondaryOutput, InputItemWithCount[] inputs) {
        this.output = output;
        this.secondaryOutput = secondaryOutput;
        this.inputs = inputs;
    }

    public ItemStack getOutput() {
        return output;
    }

    public OutputItemWithPercent getSecondaryOutput() {
        return secondaryOutput;
    }

    public InputItemWithCount[] getInputs() {
        return inputs;
    }

    public ItemStack[] getMaxOutputCounts() {
        ItemStack[] generatedOutputs = new ItemStack[2];

        generatedOutputs[0] = output.copyWithCount(output.getCount());
        generatedOutputs[1] = secondaryOutput.output().copyWithCount(secondaryOutput.percentages().length);

        return generatedOutputs;
    }

    public ItemStack[] generateOutputs(RandomSource randomSource) {
        ItemStack[] generatedOutputs = new ItemStack[2];

        generatedOutputs[0] = output.copyWithCount(output.getCount());

        int secondaryCount = 0;
        for (double percentage : secondaryOutput.percentages())
            if (randomSource.nextDouble() <= percentage)
                secondaryCount++;

        generatedOutputs[1] = secondaryOutput.output().copyWithCount(secondaryCount);
        
        return generatedOutputs;
    }

    @Override
    public boolean matches(RecipeInput container, Level level) {
        if (level.isClientSide())
            return false;

        boolean[] usedIndices = new boolean[3];
        for (int i = 0; i < 3; i++)
            usedIndices[i] = container.getItem(i).isEmpty();

        int len = Math.min(inputs.length, 3);
        for (int i = 0; i < len; i++) {
            InputItemWithCount input = inputs[i];

            int indexMinCount = -1;
            int minCount = Integer.MAX_VALUE;

            for (int j = 0; j < 3; j++) {
                if (usedIndices[j])
                    continue;

                ItemStack item = container.getItem(j);

                if ((indexMinCount == -1 || item.getCount() < minCount) && input.input().test(item) &&
                        item.getCount() >= input.count()) {
                    indexMinCount = j;
                    minCount = item.getCount();
                }
            }

            if (indexMinCount == -1)
                return false; //Ingredient did not match any item

            usedIndices[indexMinCount] = true;
        }

        for (boolean usedIndex : usedIndices)
            if (!usedIndex) //Unused items present
                return false;

        return true;
    }

    @Override
    public ItemStack assemble(RecipeInput container, HolderLookup.Provider registries) {
        return ItemStack.EMPTY;
    }

    @Override
    public PlacementInfo placementInfo() {
        return PlacementInfo.NOT_PLACEABLE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

    @Override
    public RecipeBookCategory recipeBookCategory() {
        return RecipeBookCategories.CRAFTING_MISC;
    }

    @Override
    public RecipeSerializer<? extends Recipe<RecipeInput>> getSerializer() {
        return ExplosiveInfuserRecipe.Serializer.INSTANCE;
    }

    @Override
    public RecipeType<? extends Recipe<RecipeInput>> getType() {
        return ExplosiveInfuserRecipe.Type.INSTANCE;
    }

    @Override
    public List<Ingredient> getIngredients() {
        return Arrays.stream(inputs).map(InputItemWithCount::input).toList();
    }

    @Override
    public boolean isIngredient(ItemStack itemStack) {
        return Arrays.stream(inputs).map(InputItemWithCount::input).anyMatch(ingredient -> ingredient.test(itemStack));
    }


    @Override
    public boolean isResult(ItemStack itemStack) {
        return ItemStack.isSameItemSameComponents(output, itemStack) || (secondaryOutput != null &&
                ItemStack.isSameItemSameComponents(secondaryOutput.output(), itemStack));
    }

    public static final class Type implements RecipeType<ExplosiveInfuserRecipe> {
        private Type() {
        }

        public static final ExplosiveInfuserRecipe.Type INSTANCE = new ExplosiveInfuserRecipe.Type();
        public static final String ID = AtomicRecipes.Types.EXPLOSIVE_INFUSER;
    }

    public static final class Serializer implements RecipeSerializer<ExplosiveInfuserRecipe> {
        private Serializer() {
        }

        public static final ExplosiveInfuserRecipe.Serializer INSTANCE = new ExplosiveInfuserRecipe.Serializer();
        public static final Identifier ID = Identifier.fromNamespaceAndPath(AtomicCompression.MOD_ID, AtomicRecipes.Types.EXPLOSIVE_INFUSER);

        private final MapCodec<ExplosiveInfuserRecipe> CODEC = RecordCodecBuilder.mapCodec((instance) -> {
            return instance.group(
                    ItemStack.CODEC.fieldOf("result").forGetter((recipe) -> {
                        return recipe.output;
                    }), OutputItemWithPercent.CODEC_NONEMPTY.optionalFieldOf("secondaryResult").forGetter((recipe) -> {
                        return Optional.ofNullable(recipe.secondaryOutput.isEmpty() ? null : recipe.secondaryOutput);
                    }), new ArrayCodec<>(InputItemWithCount.CODEC, InputItemWithCount[]::new).fieldOf("ingredients").forGetter((recipe) -> {
                        return recipe.inputs;
                    })
            ).apply(instance, (output, secondaryOutput, input) -> new ExplosiveInfuserRecipe(output,
                    secondaryOutput.orElse(OutputItemWithPercent.EMPTY), input));
        });

        private final StreamCodec<RegistryFriendlyByteBuf, ExplosiveInfuserRecipe> STREAM_CODEC = StreamCodec.of(
                ExplosiveInfuserRecipe.Serializer::write, ExplosiveInfuserRecipe.Serializer::read);

        @Override
        public MapCodec<ExplosiveInfuserRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, ExplosiveInfuserRecipe> streamCodec() {
            return STREAM_CODEC;
        }

        private static ExplosiveInfuserRecipe read(RegistryFriendlyByteBuf buffer) {
            int len = buffer.readInt();
            InputItemWithCount[] inputs = new InputItemWithCount[len];
            for (int i = 0; i < len; i++)
                inputs[i] = InputItemWithCount.STREAM_CODEC.decode(buffer);

            ItemStack output = ItemStack.OPTIONAL_STREAM_CODEC.decode(buffer);

            OutputItemWithPercent secondaryOutput = OutputItemWithPercent.OPTIONAL_STREAM_CODEC.decode(buffer);

            return new ExplosiveInfuserRecipe(output, secondaryOutput, inputs);
        }

        private static void write(RegistryFriendlyByteBuf buffer, ExplosiveInfuserRecipe recipe) {
            buffer.writeInt(recipe.inputs.length);
            for (int i = 0; i < recipe.inputs.length; i++)
                InputItemWithCount.STREAM_CODEC.encode(buffer, recipe.inputs[i]);

            ItemStack.OPTIONAL_STREAM_CODEC.encode(buffer, recipe.output);

            OutputItemWithPercent.OPTIONAL_STREAM_CODEC.encode(buffer, recipe.secondaryOutput);
        }
    }
}