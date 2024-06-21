package org.amycute.morematteralchemy.block.entity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.pitan76.mcpitanlib.api.block.ExtendBlock;
import net.pitan76.mcpitanlib.api.event.block.TileCreateEvent;
import net.pitan76.mcpitanlib.api.event.tile.TileTickEvent;
import net.pitan76.mcpitanlib.api.tile.ExtendBlockEntity;
import net.pitan76.mcpitanlib.api.tile.ExtendBlockEntityTicker;
import org.amycute.morematteralchemy.register.BlocksEntity;

import static org.amycute.morematteralchemy.register.Blocks.PEDESTAL_BLOCK;

public class PedestalBlockEntity extends ExtendBlockEntity implements ExtendBlockEntityTicker<PedestalBlockEntity> {
    private boolean hasWatchOfFlowingTime = false;
    private static final int TICK_INCREASE_PERCENT = 400;

    public PedestalBlockEntity(BlockEntityType<?> type, TileCreateEvent event) {
        super(type, event);
    }

    public PedestalBlockEntity(TileCreateEvent event) {
        this(BlocksEntity.PEDESTAL_BLOCK_ENTITY.getOrNull(), event);
    }

    public boolean hasWatchOfFlowingTime() {
        return hasWatchOfFlowingTime;
    }

    public void setWatchOfFlowingTime(boolean hasWatchOfFlowingTime) {
        this.hasWatchOfFlowingTime = hasWatchOfFlowingTime;
        markDirty();
    }

    @Override
    public void readNbtOverride(NbtCompound tag) {
        super.readNbtOverride(tag);
        hasWatchOfFlowingTime = tag.getBoolean("HasWatchOfFlowingTime");
    }

    @Override
    public void writeNbtOverride(NbtCompound tag) {
        super.writeNbtOverride(tag);
        tag.putBoolean("HasWatchOfFlowingTime", hasWatchOfFlowingTime);
    }

    @Override
    public void tick(TileTickEvent<PedestalBlockEntity> e) {
        if (!e.blockEntity.hasWatchOfFlowingTime) return;
        BlockPos pos = e.pos;
        BlockPos minPos = pos.add(-4, -1, -4);
        BlockPos maxPos = pos.add(4, 1, 4);
        World world = e.world;
        int additionalTicks = (int) (TICK_INCREASE_PERCENT / 100.0 * 20);

        // disable for now because the game crash on 1.18.2+ versions
        //speedUpRandomTick(world, minPos, maxPos, additionalTicks);
        speedUpBlockEntities(world, minPos, maxPos, additionalTicks);
    }

    private static void speedUpRandomTick(World world, BlockPos minPos, BlockPos maxPos, int tickIncrease) {
        for (BlockPos blockPos : BlockPos.iterate(minPos, maxPos)) {
            if (!world.isChunkLoaded(blockPos.getX() >> 4, blockPos.getZ() >> 4)) continue;
            BlockState blockState = world.getBlockState(blockPos);

            Block block = blockState.getBlock();
            if (block == Blocks.AIR || block == PEDESTAL_BLOCK.getOrNull() || !blockState.hasRandomTicks()) continue;

            for (int i = 0; i < tickIncrease; i++) {
                blockState.randomTick((ServerWorld) world, blockPos, world.random);
            }
        }
    }

    private static void speedUpBlockEntities(World world, BlockPos minPos, BlockPos maxPos, int tickIncrease) {
        if (world.isClient()) return;

        for (BlockPos blockPos : BlockPos.iterate(minPos, maxPos)) {
            if (!world.isChunkLoaded(blockPos)) continue;

            BlockEntity blockEntity = world.getBlockEntity(blockPos);
            if (blockEntity == null) continue;

            Block block = world.getBlockState(blockPos).getBlock();
            if(block == PEDESTAL_BLOCK.getOrNull()) continue;

            BlockEntityTicker<BlockEntity> ticker = (BlockEntityTicker<BlockEntity>) ((BlockEntityProvider) block).getTicker(world, world.getBlockState(blockPos), blockEntity.getType());
            if (ticker == null) continue;

            for (int i = 0; i < tickIncrease; i++) {
                ticker.tick(world, blockPos, world.getBlockState(blockPos), blockEntity);
            }
        }
    }

}
