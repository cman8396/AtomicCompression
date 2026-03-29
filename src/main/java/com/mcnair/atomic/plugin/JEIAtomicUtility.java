package com.mcnair.atomic.plugin;

public class JEIAtomicUtility {
    private JEIAtomicUtility() {
    }

    public static boolean isJEIInstalled() {
        try {
            Class.forName("mezz.jei.api.IModPlugin");

            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
