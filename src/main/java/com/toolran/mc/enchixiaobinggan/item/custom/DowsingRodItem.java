package com.toolran.mc.enchixiaobinggan.item.custom;

import com.toolran.mc.enchixiaobinggan.item.ModItems;
import com.toolran.mc.enchixiaobinggan.sound.ModSounds;
import com.toolran.mc.enchixiaobinggan.util.InventoryUtil;
import com.toolran.mc.enchixiaobinggan.util.ModTags;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundSource;
import net.minecraft.tags.TagKey;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.Nullable;

import java.awt.*;
import java.util.List;

public class DowsingRodItem extends Item {
    public DowsingRodItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(pContext.getLevel().isClientSide()){
            BlockPos positionClicked = pContext.getClickedPos();
            Player player = pContext.getPlayer();
            boolean foundBlock = false;

            for (int i = 0; i <= positionClicked.getY() + 64; i++) {
                Block blockBelow = pContext.getLevel().getBlockState(positionClicked.below(i)).getBlock();

                if(isValuableBlock(blockBelow)){
                    outputValuableCoordinates(positionClicked.below(i), player, blockBelow);
                    foundBlock = true;

                    if (InventoryUtil.hasPlayerStackInInventory(player, ModItems.DATA_TABLET.get())) {
                        addNbtToDataTablet(player, positionClicked.below(i), blockBelow);
                    }

                    pContext.getLevel().playSound(player, positionClicked, ModSounds.DOWSING_ROD_FOUND_ORE.get(),
                            SoundSource.BLOCKS, 1.0F, 1.0F);

                    break;
                }
            }

            if (!foundBlock) {
                player.sendMessage(
                        new TranslatableComponent("item.enchixiaobinggan.dowsing_rod.no_valuables"),
                        player.getUUID());
            }
        }

        pContext.getItemInHand().hurtAndBreak(
                1,
                pContext.getPlayer(),
                (player) -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return super.useOn(pContext);
    }

    private void addNbtToDataTablet(Player player, BlockPos pos, Block blockBelow) {
        ItemStack dataTablet =
                player.getInventory().getItem(InventoryUtil.getFirstInventoryIndex(player, ModItems.DATA_TABLET.get()));

        CompoundTag nbtData = new CompoundTag();
        nbtData.putString(
                "enchixiaobinggan.last_ore",
                "Found " + blockBelow.asItem().getRegistryName().toString() + " at (" +
                pos.getX() + ", "+ pos.getY() + ", "+ pos.getZ() + ")");

        dataTablet.setTag(nbtData);
    }

    @Override
    public void appendHoverText(
            ItemStack pStack,
            @Nullable Level pLevel,
            List<Component> pTooltipComponents,
            TooltipFlag pIsAdvanced) {
        if (Screen.hasShiftDown()){
            pTooltipComponents.add(new TranslatableComponent(
                    "tooltip.enchixiaobinggan.dowsing_rod.tooltip.shift"));
        }
        else{
            pTooltipComponents.add(new TranslatableComponent(
                    "tooltip.enchixiaobinggan.dowsing_rod.tooltip"));
        }
    }

    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block blockBelow){
        String text = "Found " + blockBelow.asItem().getRegistryName().toString()
                + " at (" + blockPos.getX() + ", " + blockPos.getY() + ", " + blockPos.getZ() + ")";
        player.sendMessage(new TextComponent(text), player.getUUID());
    }

    private boolean isValuableBlock(Block block){
//        ResourceKey<Block> s1 = Registry.BLOCK.getResourceKey(block).get();
//        Holder<Block> s2 = Registry.BLOCK.getHolderOrThrow(s1);
//        TagKey<Block> s3 = ModTags.Blocks.DOWSING_ROD_VALUABLES;
//        boolean s4 = s2.is(s3);
//        return s4;

        return Registry.BLOCK.getHolderOrThrow(Registry.BLOCK.getResourceKey(block).get())
                .is(ModTags.Blocks.DOWSING_ROD_VALUABLES);
    }
}
