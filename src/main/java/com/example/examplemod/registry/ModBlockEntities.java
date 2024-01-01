package com.example.examplemod.registry;

import com.example.examplemod.block.entity.IronBucketBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, "examplemod");

    public static final RegistryObject<BlockEntityType<?>> IRON_BUCKET_BLOCK_ENTITY =
            BLOCK_ENTITIES.register("iron_bucket",
                    () -> BlockEntityType.Builder
                            .of(IronBucketBlockEntity::new, ModBlocks.IRON_BUCKET_BLOCK.get())
                            .build(null));
}
