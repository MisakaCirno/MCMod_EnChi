package com.toolran.mc.enchixiaobinggan.block;

import com.toolran.mc.enchixiaobinggan.EnChiXiaoBingGan;
import com.toolran.mc.enchixiaobinggan.item.ModCreativeModeTab;
import com.toolran.mc.enchixiaobinggan.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    // 注册方块的包装方法
    private static <T extends Block> RegistryObject<T> registerBlock(
            String name,
            Supplier<T> block,
            CreativeModeTab tab) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItems(name, toReturn, tab);
        return toReturn;
    }

    // 注册方块的时候，同时给它注册一个方块物品
    private static <T extends Block> RegistryObject<Item> registerBlockItems(
            String name,
            RegistryObject<T> block,
            CreativeModeTab tab) {

        return ModItems.ITEMS.register(
                name,
                () -> new BlockItem(
                        block.get(),
                        new Item.Properties().tab(tab)));
    }

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, EnChiXiaoBingGan.MOD_ID);

    public static final RegistryObject<Block> CITRINE_BLOCK = registerBlock(
            "citrine_block",
            ()-> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(9f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.ENCHIXIAOBINGGAN_TAB);
}
