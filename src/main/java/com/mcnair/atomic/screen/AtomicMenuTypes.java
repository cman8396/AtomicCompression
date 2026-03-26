package com.mcnair.atomic.screen;

import com.mcnair.atomic.AtomicCompression;
import com.mcnair.atomic.recipe.recipes.ExplosiveInfuserRecipe;
import com.mcnair.atomic.screen.custom.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class AtomicMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(Registries.MENU, AtomicCompression.MOD_ID);


    public static final DeferredHolder<MenuType<?>, MenuType<ExplosiveMillMenu>> EXPLOSIVE_MILL_MENU =
            registerMenuType("explosive_mill_menu", ExplosiveMillMenu::new);
    public static final DeferredHolder<MenuType<?>, MenuType<ExplosiveCompactorMenu>> EXPLOSIVE_COMPACTOR_MENU =
            registerMenuType("explosive_compactor_menu", ExplosiveCompactorMenu::new);
    public static final DeferredHolder<MenuType<?>, MenuType<ExplosiveSeparatorMenu>> EXPLOSIVE_SEPARATOR_MENU =
            registerMenuType("explosive_separator_menu", ExplosiveSeparatorMenu::new);
    public static final DeferredHolder<MenuType<?>, MenuType<ExplosiveSmelterMenu>> EXPLOSIVE_SMELTER_MENU =
            registerMenuType("explosive_smelter_menu", ExplosiveSmelterMenu::new);
    public static final DeferredHolder<MenuType<?>, MenuType<ExplosiveRefinerMenu>> EXPLOSIVE_REFINER_MENU =
            registerMenuType("explosive_refiner_menu", ExplosiveRefinerMenu::new);
    public static final DeferredHolder<MenuType<?>, MenuType<ExplosiveInfuserMenu>> EXPLOSIVE_INFUSER_MENU =
            registerMenuType("explosive_infuser_menu", ExplosiveInfuserMenu::new);




    private static <T extends AbstractContainerMenu>DeferredHolder<MenuType<?>, MenuType<T>> registerMenuType(String name, IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IMenuTypeExtension.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}

