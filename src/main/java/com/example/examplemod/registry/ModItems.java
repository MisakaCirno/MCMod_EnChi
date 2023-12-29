package com.example.examplemod.registry;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    // 物品的注册表
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "examplemod");

    // 向注册表中注册物品
    public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item",
            () -> new Item(new Item.Properties().tab(CreativeModeTab.TAB_MISC)));

    // 向注册表中注册方块物品
    public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = ITEMS.register("example_block_item",
            () -> new BlockItem(ModBlocks.EXAMPLE_BLOCK.get(), new Item.Properties().tab(CreativeModeTab.TAB_MISC)));
}