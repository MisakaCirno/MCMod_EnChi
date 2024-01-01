package com.example.examplemod.registry;

import com.example.examplemod.item.MagicMirror;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    // 物品的注册表
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, "examplemod");

    // 向注册表中注册物品
    public static final RegistryObject<Item> EXAMPLE_ITEM = ITEMS.register("example_item",
            () -> new Item(new Item.Properties().tab(ModCreativeTabs.EXAMPLE_TAB)));

    public static final RegistryObject<Item> MAGIC_MIRROR_ITEM = ITEMS.register("magic_mirror_item",
            () -> new MagicMirror(new Item.Properties().tab(ModCreativeTabs.EXAMPLE_TAB)));

    // 向注册表中注册方块物品
    public static final RegistryObject<Item> EXAMPLE_BLOCK_ITEM = ITEMS.register("example_block_item",
            () -> new BlockItem(ModBlocks.EXAMPLE_BLOCK.get(), new Item.Properties().tab(ModCreativeTabs.EXAMPLE_TAB)));

    public static final RegistryObject<Item> IRON_BUCKET_BLOCK_ITEM = ITEMS.register("iron_bucket_block_item",
            () -> new BlockItem(ModBlocks.IRON_BUCKET_BLOCK.get(), new Item.Properties().tab(ModCreativeTabs.EXAMPLE_TAB)));
}
