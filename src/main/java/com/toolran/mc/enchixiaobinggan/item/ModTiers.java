package com.toolran.mc.enchixiaobinggan.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;

public class ModTiers {
    public static final ForgeTier CITRINE = new ForgeTier(
            2,
            1400,
            10f,
            2f,
            22,
            BlockTags.NEEDS_IRON_TOOL,
            () -> Ingredient.of(ModItems.CITRINE.get()));
}