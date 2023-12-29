package com.example.examplemod.registry;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeTabs {
    public static final CreativeModeTab EXAMPLE_TAB = new CreativeModeTab("examplemod_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.EXAMPLE_ITEM.get());
        }
    };
}
