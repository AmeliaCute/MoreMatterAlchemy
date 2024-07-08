package org.amycute.morematteralchemy.block;

import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.annotation.Nullable;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.World;
import net.pitan76.mcpitanlib.api.block.CompatibleBlockSettings;
import net.pitan76.mcpitanlib.api.block.ExtendBlock;
import net.pitan76.mcpitanlib.api.block.ExtendBlockEntityProvider;
import net.pitan76.mcpitanlib.api.entity.Player;
import net.pitan76.mcpitanlib.api.event.block.BlockUseEvent;
import net.pitan76.mcpitanlib.api.event.block.OutlineShapeEvent;
import net.pitan76.mcpitanlib.api.event.block.TileCreateEvent;
import org.amycute.morematteralchemy.block.entity.PedestalBlockEntity;

public class PedestalBlock extends ExtendBlock implements ExtendBlockEntityProvider
{
    public PedestalBlock(CompatibleBlockSettings settings) {
        super(settings);
    }

    @Override
    public @Nullable BlockEntity createBlockEntity(TileCreateEvent event) {
        return new PedestalBlockEntity(event);
    }

    @Override
    public VoxelShape getOutlineShape(OutlineShapeEvent event) {
        return VoxelShapes.union(
            VoxelShapes.cuboid(0.125, 0, 0.125, 0.875, 0.1875, 0.875),
            VoxelShapes.cuboid(0.25, 0.6875, 0.25, 0.75, 0.75, 0.75),
            VoxelShapes.cuboid(0.375, 0.1875, 0.375, 0.625, 0.6875, 0.625)
        );
    }

    @Override
    public ActionResult onRightClick(BlockUseEvent e) {
        Player player = e.getPlayer();
        ItemStack itemStack = player.getStackInHand(Hand.MAIN_HAND);

        World world = e.getWorld();
        BlockEntity blockEntity = world.getBlockEntity(e.pos);
        if(!(blockEntity instanceof PedestalBlockEntity pedestalBlockEntity)) return ActionResult.PASS;

        if (!pedestalBlockEntity.getInventory().get(0).isEmpty())
        {
            if (!world.isClient)
            {
                player.getInventory().insertStack(pedestalBlockEntity.getInventory().get(0).getItem().getDefaultStack());
                pedestalBlockEntity.putItemInInventory(ItemStack.EMPTY);
            }
        } else {
            if (!world.isClient)
            {
                pedestalBlockEntity.putItemInInventory(itemStack);
                if (!player.isCreative())
                    itemStack.decrement(1);
            }
        }

        return ActionResult.SUCCESS;
    }

    @Override
    public @org.jetbrains.annotations.Nullable <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
        return ((world1, pos, state1, blockEntity) -> {
            if (blockEntity instanceof PedestalBlockEntity pedestalBlockEntity)
                pedestalBlockEntity.tick(world1, pos, state1, pedestalBlockEntity);
        });
    }
}
