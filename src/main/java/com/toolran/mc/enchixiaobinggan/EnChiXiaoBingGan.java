package com.toolran.mc.enchixiaobinggan;


import com.mojang.logging.LogUtils;
import com.toolran.mc.enchixiaobinggan.block.ModBlocks;
import com.toolran.mc.enchixiaobinggan.item.ModItems;
import net.minecraft.Util;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(EnChiXiaoBingGan.MOD_ID)
@Mod.EventBusSubscriber
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

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        // 一些preinit代码
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    // 一些测试用的代码
    @SubscribeEvent
    public static void playJoinWorld(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getPlayer();
        Level level = player.level;

        String playerName = player.getDisplayName().getString();
        String worldName = level.isClientSide() ? "Client" : "Server";
        String message = String.format("Hello, %s! This Message send from %s!", playerName, worldName);

        player.sendMessage(new TextComponent(message), Util.NIL_UUID);
    }

    @SubscribeEvent
    public static void leftClickBlock(PlayerInteractEvent.LeftClickBlock event) {
        Player player = event.getPlayer();

        String message = String.format("You left click a block at %s, %s, %s",
                event.getPos().getX(),
                event.getPos().getY(),
                event.getPos().getZ());

        player.sendMessage(new TextComponent(message), Util.NIL_UUID);
    }

    @SubscribeEvent
    public static void rightClickBlock(PlayerInteractEvent.RightClickBlock event) {
        Player player = event.getPlayer();

        String message = String.format(
                "You right click a block at %s, %s, %s",
                event.getPos().getX(),
                event.getPos().getY(),
                event.getPos().getZ());

        player.sendMessage(new TextComponent(message), Util.NIL_UUID);
    }

    @SubscribeEvent
    public static void rightClickItem(PlayerInteractEvent.RightClickItem event) {
        Player player = event.getPlayer();
        Level level = player.level;
        if (!level.isClientSide()) {
            ItemStack itemStack = event.getItemStack();
            Item item = itemStack.getItem();
            if (item == Items.DIAMOND_SWORD) {
                HitResult hitResult = player.pick(20, 0, false);
                Vec3 location = hitResult.getLocation();
                player.teleportTo(location.x, location.y, location.z);
            }
        }
    }
}
