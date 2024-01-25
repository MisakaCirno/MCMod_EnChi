package com.toolran.mc.enchixiaobinggan.block;

import com.toolran.mc.enchixiaobinggan.EnChiXiaoBingGan;
import com.toolran.mc.enchixiaobinggan.block.custom.CitrineLampBlock;
import com.toolran.mc.enchixiaobinggan.block.custom.SpeedyBlock;
import com.toolran.mc.enchixiaobinggan.item.ModCreativeModeTab;
import com.toolran.mc.enchixiaobinggan.item.ModItems;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.function.Supplier;

public class ModBlocks {
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    // 注册方块的包装方法，不注册方块物品
    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(
            String name,
            Supplier<T> block) {
        return BLOCKS.register(name, block);
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

    // 注册方块的包装方法
    private static <T extends Block> RegistryObject<T> registerBlock(
            String name,
            Supplier<T> block,
            CreativeModeTab tab,
            String tooltipkey) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItems(name, toReturn, tab, tooltipkey);
        return toReturn;
    }

    // 注册方块的时候，同时给它注册一个方块物品
    private static <T extends Block> RegistryObject<Item> registerBlockItems(
            String name,
            RegistryObject<T> block,
            CreativeModeTab tab,
            String tooltipkey) {

        return ModItems.ITEMS.register(
                name,
                () -> new BlockItem(
                        block.get(),
                        new Item.Properties().tab(tab)) {
                    @Override
                    public void appendHoverText(
                            ItemStack pStack,
                            @Nullable Level pLevel,
                            List<Component> pTooltip,
                            TooltipFlag pFlag) {
                        pTooltip.add(new TranslatableComponent(tooltipkey));
                    }
                });
    }

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, EnChiXiaoBingGan.MOD_ID);

    // #9 高级方块
    public static final RegistryObject<Block> SPEEDY_BLOCK = registerBlock(
            "speedy_block",
            () -> new SpeedyBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(3f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.ENCHIXIAOBINGGAN_TAB,
            "tooltip.enchixiaobinggan.speedy_block.tooltip");

    // #4 自定义方块
    public static final RegistryObject<Block> CITRINE_BLOCK = registerBlock(
            "citrine_block",
            () -> new Block(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(9f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.ENCHIXIAOBINGGAN_TAB);

    // #14 楼梯，台阶，栅栏，栅栏门，墙
    public static final RegistryObject<Block> CITRINE_STARIS = registerBlock(
            "citrine_stairs",
            () -> new StairBlock(
                    ()->ModBlocks.CITRINE_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.METAL).strength(9f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.ENCHIXIAOBINGGAN_TAB);
    public static final RegistryObject<Block> CITRINE_SLAB = registerBlock(
            "citrine_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(9f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.ENCHIXIAOBINGGAN_TAB);
    public static final RegistryObject<Block> CITRINE_FENCE = registerBlock(
            "citrine_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(9f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.ENCHIXIAOBINGGAN_TAB);
    public static final RegistryObject<Block> CITRINE_FENCE_GATE = registerBlock(
            "citrine_fence_gate",
            () -> new FenceGateBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(9f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.ENCHIXIAOBINGGAN_TAB);
    public static final RegistryObject<Block> CITRINE_WALL = registerBlock(
            "citrine_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(9f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.ENCHIXIAOBINGGAN_TAB);

    // #15 门，活板门，按钮和压力板
    public static final RegistryObject<Block> CITRINE_BUTTON = registerBlock(
            "citrine_button",
            () -> new StoneButtonBlock(BlockBehaviour.Properties.of(Material.METAL)
                    .strength(5f).requiresCorrectToolForDrops().noCollission()),
            ModCreativeModeTab.ENCHIXIAOBINGGAN_TAB);
    public static final RegistryObject<Block> CITRINE_PRESSURE_PLATE = registerBlock(
            "citrine_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    BlockBehaviour.Properties.of(Material.METAL)
                            .strength(5f).requiresCorrectToolForDrops()),
            ModCreativeModeTab.ENCHIXIAOBINGGAN_TAB);
    public static final RegistryObject<Block> EBONY_DOOR = registerBlock(
            "ebony_door",
            () -> new DoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(5f).requiresCorrectToolForDrops().noOcclusion()),
            ModCreativeModeTab.ENCHIXIAOBINGGAN_TAB);
    public static final RegistryObject<Block> EBONY_TRAPDOOR = registerBlock(
            "ebony_trapdoor",
            () -> new TrapDoorBlock(BlockBehaviour.Properties.of(Material.WOOD)
                    .strength(5f).requiresCorrectToolForDrops().noOcclusion()),
            ModCreativeModeTab.ENCHIXIAOBINGGAN_TAB);

    // #20 花和盆栽花
    public static final RegistryObject<Block> PINK_ROSE = registerBlock(
            "pink_rose",
            () -> new FlowerBlock(MobEffects.LEVITATION,8,
                    BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()),
            ModCreativeModeTab.ENCHIXIAOBINGGAN_TAB);

    public static final RegistryObject<Block> POTTED_PINK_ROSE = registerBlockWithoutBlockItem(
            "potted_pink_rose",
            () -> new FlowerPotBlock(null, ModBlocks.PINK_ROSE,
                    BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION).noOcclusion()));

    // #22 透明方块
    public static final RegistryObject<Block> WINTER_WINDOW = registerBlock(
            "winter_window",
            () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).noOcclusion()),
            ModCreativeModeTab.ENCHIXIAOBINGGAN_TAB);

    // #23 方块状态
    public static final RegistryObject<Block> CITRINE_LAMP = registerBlock(
            "citrine_lamp",
            () -> new CitrineLampBlock(BlockBehaviour.Properties.of(Material.METAL).strength(2f)
                    .requiresCorrectToolForDrops()
                    .lightLevel((state) -> state.getValue(CitrineLampBlock.CLICKED) ? 15 : 0)),
            ModCreativeModeTab.ENCHIXIAOBINGGAN_TAB);
}
