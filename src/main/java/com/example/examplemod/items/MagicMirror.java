package com.example.examplemod.items;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class MagicMirror extends Item {

    public MagicMirror(Properties properties) {
        super(properties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand useHand) {
        if (level.isClientSide) {
            return super.use(level, player, useHand);
        }

        ServerLevel serverLevel = level.getServer().getLevel(Level.OVERWORLD);
        ServerPlayer serverPlayer = player instanceof ServerPlayer ? (ServerPlayer) player : null;

        BlockPos spawnPos = serverPlayer.getRespawnPosition();
        if (spawnPos != null && serverLevel != null) {
            serverPlayer.teleportTo(spawnPos.getX(), spawnPos.getY(), spawnPos.getZ());
        }

        return super.use(level, player, useHand);
    }
}
