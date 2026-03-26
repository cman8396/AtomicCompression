package com.mcnair.atomic.recipe;

import com.mcnair.atomic.AtomicCompression;
import com.mcnair.atomic.recipe.recipes.ExplosiveCompactorRecipe;
import com.mcnair.atomic.recipe.recipes.ExplosiveMillRecipe;
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


    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<ExplosiveMillRecipe>> EXPLOSIVE_MILL_SERIALIZER =
            SERIALIZERS.register(Types.EXPLOSIVE_MILL, () -> ExplosiveMillRecipe.Serializer.INSTANCE);
    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<ExplosiveCompactorRecipe>> EXPLOSIVE_COMPACTOR_SERIALIZER =
            SERIALIZERS.register(Types.EXPLOSIVE_COMPACTOR, () -> ExplosiveCompactorRecipe.Serializer.INSTANCE);
    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<ExplosiveSeparatorRecipe>> EXPLOSIVE_SEPARATOR_SERIALIZER =
            SERIALIZERS.register(Types.EXPLOSIVE_SEPARATOR, () -> ExplosiveSeparatorRecipe.Serializer.INSTANCE);
    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<ExplosiveRefinerRecipe>> EXPLOSIVE_REFINER_SERIALIZER =
            SERIALIZERS.register(Types.EXPLOSIVE_REFINER, () -> ExplosiveRefinerRecipe.Serializer.INSTANCE);


    public static final DeferredHolder<RecipeType<?>, RecipeType<ExplosiveMillRecipe>> EXPLOSIVE_MILL_TYPE =
            TYPES.register(Types.EXPLOSIVE_MILL, () -> ExplosiveMillRecipe.Type.INSTANCE);
    public static final DeferredHolder<RecipeType<?>, RecipeType<ExplosiveCompactorRecipe>> EXPLOSIVE_COMPACTOR_TYPE =
            TYPES.register(Types.EXPLOSIVE_COMPACTOR, () -> ExplosiveCompactorRecipe.Type.INSTANCE);
    public static final DeferredHolder<RecipeType<?>, RecipeType<ExplosiveSeparatorRecipe>> EXPLOSIVE_SEPARATOR_TYPE =
            TYPES.register(Types.EXPLOSIVE_SEPARATOR, () -> ExplosiveSeparatorRecipe.Type.INSTANCE);
    public static final DeferredHolder<RecipeType<?>, RecipeType<ExplosiveRefinerRecipe>> EXPLOSIVE_REFINER_TYPE =
            TYPES.register(Types.EXPLOSIVE_REFINER, () -> ExplosiveRefinerRecipe.Type.INSTANCE);


    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }

    public class Types {
        public static String EXPLOSIVE_MILL = "explosive_mill";
        public static String EXPLOSIVE_COMPACTOR = "explosive_compactor";
        public static String EXPLOSIVE_SEPARATOR = "explosive_separator";
        public static String EXPLOSIVE_REFINER = "explosive_refiner";
    }
}
