package com.mcnair.atomic.recipe;

import com.mcnair.atomic.AtomicCompression;
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


//    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<ExplosiveCompactorRecipe>> EXPLOSIVE_COMPACTOR_SERIALIZER =
//            SERIALIZERS.register("explosive_compactor", ExplosiveCompactorRecipe.Serializer::new);
//    public static final DeferredHolder<RecipeType<?>, RecipeType<ExplosiveCompactorRecipe>> EXPLOSIVE_COMPACTOR_TYPE =
//            TYPES.register("explosive_compactor", () -> new RecipeType<ExplosiveCompactorRecipe>() {
//                @Override
//                public String toString() {
//                    return "explosive_compactor";
//                }
//            });


    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }
}
