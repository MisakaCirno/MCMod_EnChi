package com.toolran.mc.enchixiaobinggan;


import net.minecraft.Util;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.PlayerEvent;
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

        player.sendMessage(
                new TextComponent("Hello, " + playerName + "! This Message is send from " + worldName + "!"),
                Util.NIL_UUID);
    }
}
