package com.example.examplemod.item;

import com.example.examplemod.registry.ModItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ItemZongZi extends Item {

    public ItemZongZi(Properties p_41383_) {
        super(p_41383_);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        ItemStack itemStack = super.finishUsingItem(stack, level, entity);

        if (entity instanceof Player && ((Player) entity).getAbilities().instabuild) {
            return itemStack;
        }
        else{
            return new ItemStack(ModItems.EXAMPLE_ITEM.get());
        }
    }
}
