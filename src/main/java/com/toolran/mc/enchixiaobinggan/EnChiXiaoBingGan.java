package com.toolran.mc.enchixiaobinggan;


import com.mojang.logging.LogUtils;
import com.toolran.mc.enchixiaobinggan.block.ModBlocks;
import com.toolran.mc.enchixiaobinggan.item.ModItems;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(EnChiXiaoBingGan.MOD_ID)
public class EnChiXiaoBingGan {
    public static final String MOD_ID = "enchixiaobinggan";

    // Directly reference a slf4j logger
    // 直接引用slf4j记录器
    private static final Logger LOGGER = LogUtils.getLogger();

    public EnChiXiaoBingGan() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        // Register the setup method for modloading
        // 注册modloading的setup方法
        eventBus.addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        // 注册我们自己感兴趣的服务器和其他游戏事件
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        // 一些preinit代码
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }
}
