package com.toolran.mc.enchixiaobinggan.item;

import com.toolran.mc.enchixiaobinggan.EnChiXiaoBingGan;
import com.toolran.mc.enchixiaobinggan.item.custom.DowsingRodItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EnChiXiaoBingGan.MOD_ID);

    public static final RegistryObject<Item> CITRINE = ITEMS.register(
            "citrine",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ENCHIXIAOBINGGAN_TAB)));

    public static final RegistryObject<Item> DOWSING_ROD = ITEMS.register(
            "dowsing_rod",
            () -> new DowsingRodItem(
                    new Item.Properties()
                            .tab(ModCreativeModeTab.ENCHIXIAOBINGGAN_TAB)
                            .durability(16)));
}
