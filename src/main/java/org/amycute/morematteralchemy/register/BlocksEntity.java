package org.amycute.morematteralchemy.register;

import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.pitan76.itemalchemy.ItemAlchemy;
import net.pitan76.itemalchemy.tile.Tiles;
import net.pitan76.mcpitanlib.api.registry.result.RegistryResult;
import net.pitan76.mcpitanlib.api.tile.BlockEntityTypeBuilder;
import org.amycute.morematteralchemy.block.entity.PedestalBlockEntity;

import static org.amycute.morematteralchemy.MoreMatterAlchemy.id;
import static org.amycute.morematteralchemy.MoreMatterAlchemy.registry;

public class BlocksEntity {
    public static RegistryResult<BlockEntityType<?>> PEDESTAL_BLOCK_ENTITY;

    public static void init() {
        PEDESTAL_BLOCK_ENTITY = registry.registerBlockEntityType(id("pedestal_block_entity"),() -> Tiles.create(PedestalBlockEntity::new, Blocks.PEDESTAL_BLOCK.getOrNull()));
    }

}

