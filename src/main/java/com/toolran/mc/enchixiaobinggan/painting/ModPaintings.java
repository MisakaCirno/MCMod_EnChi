package com.toolran.mc.enchixiaobinggan.painting;

import com.toolran.mc.enchixiaobinggan.EnChiXiaoBingGan;
import net.minecraft.world.entity.decoration.Motive;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPaintings {
    public static final DeferredRegister<Motive> PAINTINGS_MOTIVES =
            DeferredRegister.create(ForgeRegistries.PAINTING_TYPES, EnChiXiaoBingGan.MOD_ID);

    public static void register(IEventBus eventBus) {
        PAINTINGS_MOTIVES.register(eventBus);
    }

    // 一个方块是16*16像素
    public static final RegistryObject<Motive> MARATHON = PAINTINGS_MOTIVES.register(
            "marathon", () -> new Motive(32, 32));
    public static final RegistryObject<Motive> FAMILY = PAINTINGS_MOTIVES.register(
            "family", () -> new Motive(32, 32));

}
