package org.amycute.morematteralchemy.block.entity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.pitan76.mcpitanlib.api.event.block.TileCreateEvent;
import net.pitan76.mcpitanlib.api.event.tile.TileTickEvent;
import net.pitan76.mcpitanlib.api.tile.ExtendBlockEntity;
import net.pitan76.mcpitanlib.api.tile.ExtendBlockEntityTicker;
import org.amycute.morematteralchemy.register.BlocksEntity;
import org.amycute.morematteralchemy.register.Items;

import static org.amycute.morematteralchemy.register.Blocks.PEDESTAL_BLOCK;

public class PedestalBlockEntity extends ExtendBlockEntity implements ExtendBlockEntityTicker<PedestalBlockEntity> {
    private boolean hasWatchOfFlowingTime = false;
    private DefaultedList<ItemStack> inventory = DefaultedList.ofSize(1, ItemStack.EMPTY);

    private static final int TICK_INCREASE_PERCENT = 400;

    public PedestalBlockEntity(BlockEntityType<?> type, TileCreateEvent event) {
        super(type, event);
    }

    public PedestalBlockEntity(TileCreateEvent event) {
        this(BlocksEntity.PEDESTAL_BLOCK_ENTITY.getOrNull(), event);
    }

    @Override
    public void readNbtOverride(NbtCompound tag) {
        super.readNbtOverride(tag);
        Inventories.readNbt(tag, inventory);
        hasWatchOfFlowingTime = tag.getBoolean("hasWatchOfFlowingTime");
    }

    @Override
    public void writeNbtOverride(NbtCompound tag) {
        super.writeNbtOverride(tag);
        Inventories.writeNbt(tag, inventory);

        ItemStack itemStack = inventory.get(0);
        if(itemStack.isEmpty() || itemStack.getItem() != Items.WATCH_OF_FLOWING_TIME.getOrNull()) return;
        tag.putBoolean("hasWatchOfFlowingTime", hasWatchOfFlowingTime);
    }

    public DefaultedList<ItemStack> getInventory() {
        return inventory;
    }

    public void putItemInInventory(ItemStack stack) {
        inventory.set(0, stack);

        hasWatchOfFlowingTime = stack.getItem() == Items.WATCH_OF_FLOWING_TIME.getOrNull();
    }

    @Override
    public void tick(TileTickEvent<PedestalBlockEntity> e) {
        if (!e.blockEntity.hasWatchOfFlowingTime) return;
        BlockPos pos = e.pos;
        BlockPos minPos = pos.add(-4, -1, -4);
        BlockPos maxPos = pos.add(4, 1, 4);
        World world = e.world;
        int additionalTicks = (int) (TICK_INCREASE_PERCENT / 100.0 * 20);

        speedUpRandomTickNew(world, minPos, maxPos, additionalTicks);
        speedUpBlockEntities(world, minPos, maxPos, additionalTicks);
    }

    public static void speedUpRandomTickNew(World world, BlockPos minPos, BlockPos maxPos, int tickIncrease) {
        if (!(world instanceof ServerWorld worldServer) || !worldServer.isRegionLoaded(minPos, maxPos)) return;

        for(BlockPos blockPos : BlockPos.iterate(minPos, maxPos))
        {
            BlockState blockState = worldServer.getBlockState(blockPos);
            Block block = blockState.getBlock();

            if(!blockState.hasRandomTicks() || block == PEDESTAL_BLOCK.getOrNull()) continue;
            blockPos = blockPos.toImmutable();

            for(int i = 0; i < tickIncrease; ++i)
                blockState.randomTick(worldServer, blockPos, world.random);
        }
    }

    private static void speedUpBlockEntities(World world, BlockPos minPos, BlockPos maxPos, int tickIncrease) {
        if(!(world instanceof ServerWorld worldServer) || !worldServer.isRegionLoaded(minPos, maxPos)) return;

        for (BlockPos blockPos : BlockPos.iterate(minPos, maxPos)) {
            BlockEntity blockEntity = (BlockEntity) worldServer.getBlockEntity(blockPos);
            if (blockEntity == null) continue;

            Block block = worldServer.getBlockState(blockPos).getBlock();
            if(block == PEDESTAL_BLOCK.getOrNull()) continue;

            BlockEntityTicker<BlockEntity> ticker = (BlockEntityTicker<BlockEntity>) ((BlockEntityProvider) block).getTicker(world, world.getBlockState(blockPos), blockEntity.getType());
            if (ticker == null) continue;

            for (int i = 0; i < tickIncrease; i++)
                ticker.tick(worldServer, blockPos, worldServer.getBlockState(blockPos), blockEntity);
        }
    }




}
