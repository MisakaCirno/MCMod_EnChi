package com.example.examplemod.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import org.jetbrains.annotations.Nullable;

public class IronBucketBlock extends Block {
    private static final DirectionProperty FACING = BlockStateProperties.FACING;
    private static final BooleanProperty OPEN = BlockStateProperties.OPEN;

    public IronBucketBlock(Properties properties) {
        super(properties);

        // 设置默认的朝向和是否开启
        this.registerDefaultState(this.getStateDefinition().any()
                .setValue(FACING, Direction.NORTH)
                .setValue(OPEN, false));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        //super.createBlockStateDefinition(builder);
        builder.add(FACING,OPEN);
    }

    @Nullable
    @Override
    // 放下的时候是什么样的
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        //return super.getStateForPlacement(context);
        return this.defaultBlockState().setValue(FACING, context.getNearestLookingDirection().getOpposite());
    }

    @Override
    public BlockState mirror(BlockState state, Mirror mirror) {
        //return super.mirror(state, mirror);
        return state.rotate(mirror.getRotation(state.getValue(FACING)));
    }

    @Override
    public BlockState rotate(BlockState state, LevelAccessor level, BlockPos pos, Rotation direction) {
        //return super.rotate(state, level, pos, direction);
        return state.setValue(FACING, direction.rotate(state.getValue(FACING)));
    }
}
