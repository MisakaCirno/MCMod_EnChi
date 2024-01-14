package com.toolran.mc.enchixiaobinggan.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class ModCreativeModeTab {
    public static final CreativeModeTab ENCHIXIAOBINGGAN_TAB = new CreativeModeTab("enchixiaobinggan_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.CITRINE.get());
        }
    };
}
