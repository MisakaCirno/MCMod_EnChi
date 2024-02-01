package com.toolran.mc.enchixiaobinggan.item;

import com.toolran.mc.enchixiaobinggan.EnChiXiaoBingGan;
import com.toolran.mc.enchixiaobinggan.block.ModBlocks;
import com.toolran.mc.enchixiaobinggan.item.custom.*;
import com.toolran.mc.enchixiaobinggan.sound.ModSounds;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
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

    public static final RegistryObject<Item> CUCUMBER = ITEMS.register(
            "cucumber",
            () -> new Item(new Item.Properties()
                    .tab(ModCreativeModeTab.ENCHIXIAOBINGGAN_TAB)
                    .food(ModFoods.CUCUMBER)));

    public static final RegistryObject<Item> COAL_COKE = ITEMS.register(
            "coal_coke",
            () -> new CoalCokeItem(new Item.Properties()
                    .tab(ModCreativeModeTab.ENCHIXIAOBINGGAN_TAB)));
    // # 16自定义工具
    public static final RegistryObject<Item> CITRINE_SWORD = ITEMS.register(
            "citrine_sword",
            () -> new LevitationSwordItem(ModTiers.CITRINE, 2, 3f,
                    new Item.Properties().tab(ModCreativeModeTab.ENCHIXIAOBINGGAN_TAB)));
    public static final RegistryObject<Item> CITRINE_PICKAXE = ITEMS.register(
            "citrine_pickaxe",
            () -> new PickaxeItem(ModTiers.CITRINE, 1, 1f,
                    new Item.Properties().tab(ModCreativeModeTab.ENCHIXIAOBINGGAN_TAB)));
    public static final RegistryObject<Item> CITRINE_SHOVEL = ITEMS.register(
            "citrine_shovel",
            () -> new ShovelItem(ModTiers.CITRINE, 0, 1f,
                    new Item.Properties().tab(ModCreativeModeTab.ENCHIXIAOBINGGAN_TAB)));
    public static final RegistryObject<Item> CITRINE_AXE = ITEMS.register(
            "citrine_axe",
            () -> new AxeItem(ModTiers.CITRINE, 4, 0f,
                    new Item.Properties().tab(ModCreativeModeTab.ENCHIXIAOBINGGAN_TAB)));
    public static final RegistryObject<Item> CITRINE_HOE = ITEMS.register(
            "citrine_hoe",
            () -> new HoeItem(ModTiers.CITRINE, 0, 0f,
                    new Item.Properties().tab(ModCreativeModeTab.ENCHIXIAOBINGGAN_TAB)));
    // #17 自定义防具
    public static final RegistryObject<Item> CITRINE_HELMET = ITEMS.register(
            "citrine_helmet",
            () -> new ModArmorItem(ModArmorMaterials.CITRINE, EquipmentSlot.HEAD,
                    new Item.Properties().tab(ModCreativeModeTab.ENCHIXIAOBINGGAN_TAB)));
    public static final RegistryObject<Item> CITRINE_CHESTPLATE = ITEMS.register(
            "citrine_chestplate",
            () -> new ArmorItem(ModArmorMaterials.CITRINE, EquipmentSlot.CHEST,
                    new Item.Properties().tab(ModCreativeModeTab.ENCHIXIAOBINGGAN_TAB)));
    public static final RegistryObject<Item> CITRINE_LEGGING = ITEMS.register(
            "citrine_legging",
            () -> new ArmorItem(ModArmorMaterials.CITRINE, EquipmentSlot.LEGS,
                    new Item.Properties().tab(ModCreativeModeTab.ENCHIXIAOBINGGAN_TAB)));
    public static final RegistryObject<Item> CITRINE_BOOTS = ITEMS.register(
            "citrine_boots",
            () -> new ArmorItem(ModArmorMaterials.CITRINE, EquipmentSlot.FEET,
                    new Item.Properties().tab(ModCreativeModeTab.ENCHIXIAOBINGGAN_TAB)));

    // #22 动画贴图
    public static final RegistryObject<Item> MAGIC_DUST = ITEMS.register(
            "magic_dust",
            () -> new Item(new Item.Properties().tab(ModCreativeModeTab.ENCHIXIAOBINGGAN_TAB)));

    // #25 NBT标签
    public static final RegistryObject<Item> DATA_TABLET = ITEMS.register(
            "data_tablet",
            () -> new DataTabletItem(new Item.Properties()
                    .tab(ModCreativeModeTab.ENCHIXIAOBINGGAN_TAB)
                    .stacksTo(1)));

    // #26 自定义弓
    public static final RegistryObject<Item> KAUPENBOW = ITEMS.register(
            "kaupenbow",
            () -> new BowItem(new Item.Properties().tab(ModCreativeModeTab.ENCHIXIAOBINGGAN_TAB)
                    .durability(500)));

    // #27 自定义农作物
    public static final RegistryObject<Item> CUCUMBER_SEEDS = ITEMS.register(
            "cucumber_seeds",
            () -> new ItemNameBlockItem(ModBlocks.CUCUMBER_PLANT.get(),
                    new Item.Properties().tab(ModCreativeModeTab.ENCHIXIAOBINGGAN_TAB)));

    // #29 自定义唱片
    public static final RegistryObject<Item> BAR_BRAWL_MUSIC_DISC = ITEMS.register(
            "bar_brawl_music_disc",
            () -> new RecordItem(4, ModSounds.BAR_BRAWL,
                    new Item.Properties().tab(ModCreativeModeTab.ENCHIXIAOBINGGAN_TAB).stacksTo(1)));
}
