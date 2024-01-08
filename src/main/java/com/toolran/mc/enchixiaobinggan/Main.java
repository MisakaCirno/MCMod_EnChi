package com.toolran.mc.enchixiaobinggan;


import net.minecraft.Util;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(Main.MOD_ID)
@Mod.EventBusSubscriber
public class Main {
    public static final String MOD_ID = "enchixiaobinggan";

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
        if (!level.isClientSide()){
            ItemStack itemStack = event.getItemStack();
            Item item = itemStack.getItem();
            if (item == Items.DIAMOND_SWORD){
                HitResult hitResult = player.pick(20, 0, false);
                Vec3 location = hitResult.getLocation();
                player.teleportTo(location.x, location.y, location.z);
            }
        }
    }
}
