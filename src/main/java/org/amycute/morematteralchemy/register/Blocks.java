package org.amycute.morematteralchemy.register;

import net.minecraft.block.Block;
import net.pitan76.itemalchemy.ItemAlchemy;
import net.pitan76.mcpitanlib.api.block.CompatibleBlockSettings;
import net.pitan76.mcpitanlib.api.block.CompatibleMaterial;
import net.pitan76.mcpitanlib.api.block.ExtendBlock;
import net.pitan76.mcpitanlib.api.registry.result.RegistryResult;
import org.amycute.morematteralchemy.MoreMatterAlchemy;

public class Blocks {
    public static RegistryResult<Block> BLUE_MATTER_BLOCK, GREEN_MATTER_BLOCK, YELLOW_MATTER_BLOCK, PURPLE_MATTER_BLOCK, WHITE_MATTER_BLOCK, ORANGE_MATTER_BLOCK;

    public static void init() {
        BLUE_MATTER_BLOCK = MoreMatterAlchemy.registry.registerBlock(MoreMatterAlchemy.id("blue_matter_block"),
                () -> new ExtendBlock(CompatibleBlockSettings.of(CompatibleMaterial.STONE).strength(2.0f, 5.0f)));

        GREEN_MATTER_BLOCK = MoreMatterAlchemy.registry.registerBlock(MoreMatterAlchemy.id("green_matter_block"),
                () -> new ExtendBlock(CompatibleBlockSettings.of(CompatibleMaterial.STONE).strength(2.0f, 5.0f)));

        YELLOW_MATTER_BLOCK = MoreMatterAlchemy.registry.registerBlock(MoreMatterAlchemy.id("yellow_matter_block"),
                () -> new ExtendBlock(CompatibleBlockSettings.of(CompatibleMaterial.STONE).strength(2.0f, 5.0f)));

        PURPLE_MATTER_BLOCK = MoreMatterAlchemy.registry.registerBlock(MoreMatterAlchemy.id("purple_matter_block"),
                () -> new ExtendBlock(CompatibleBlockSettings.of(CompatibleMaterial.STONE).strength(2.0f, 5.0f)));

        WHITE_MATTER_BLOCK = MoreMatterAlchemy.registry.registerBlock(MoreMatterAlchemy.id("white_matter_block"),
                () -> new ExtendBlock(CompatibleBlockSettings.of(CompatibleMaterial.STONE).strength(2.0f, 5.0f)));

        ORANGE_MATTER_BLOCK = MoreMatterAlchemy.registry.registerBlock(MoreMatterAlchemy.id("orange_matter_block"),
                () -> new ExtendBlock(CompatibleBlockSettings.of(CompatibleMaterial.STONE).strength(2.0f, 5.0f)));
    }
}
