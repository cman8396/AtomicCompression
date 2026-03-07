package com.mcnair.atomic.recipe;

import com.mcnair.atomic.AtomicCompression;
import com.mcnair.atomic.recipe.recipes.ExplosiveCompactorRecipe;
import com.mcnair.atomic.recipe.recipes.ExplosiveRefinerRecipe;
import com.mcnair.atomic.recipe.recipes.ExplosiveSeparatorRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AtomicRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, AtomicCompression.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, AtomicCompression.MOD_ID);


    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<ExplosiveCompactorRecipe>> EXPLOSIVE_COMPACTOR_SERIALIZER =
            SERIALIZERS.register("explosive_compactor", ExplosiveCompactorRecipe.Serializer::new);
    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<ExplosiveSeparatorRecipe>> EXPLOSIVE_SEPARATOR_SERIALIZER =
            SERIALIZERS.register("explosive_separator", ExplosiveSeparatorRecipe.Serializer::new);
    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<ExplosiveRefinerRecipe>> EXPLOSIVE_REFINER_SERIALIZER =
            SERIALIZERS.register("explosive_refiner", ExplosiveRefinerRecipe.Serializer::new);


    public static final DeferredHolder<RecipeType<?>, RecipeType<ExplosiveCompactorRecipe>> EXPLOSIVE_COMPACTOR_TYPE =
            TYPES.register("explosive_compactor", () -> new RecipeType<ExplosiveCompactorRecipe>() {
                @Override
                public String toString() {
                    return "explosive_compactor";
                }
            });
    public static final DeferredHolder<RecipeType<?>, RecipeType<ExplosiveSeparatorRecipe>> EXPLOSIVE_SEPARATOR_TYPE =
            TYPES.register("explosive_separator", () -> new RecipeType<ExplosiveSeparatorRecipe>() {
                @Override
                public String toString() {
                    return "explosive_separator";
                }
            });
    public static final DeferredHolder<RecipeType<?>, RecipeType<ExplosiveRefinerRecipe>> EXPLOSIVE_REFINER_TYPE =
            TYPES.register("explosive_refiner", () -> new RecipeType<ExplosiveRefinerRecipe>() {
                @Override
                public String toString() {
                    return "explosive_refiner";
                }
            });



    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }
}
