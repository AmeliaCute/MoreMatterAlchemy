package org.amycute.morematteralchemy.register;

import net.minecraft.block.Block;
import net.pitan76.mcpitanlib.api.block.CompatibleBlockSettings;
import net.pitan76.mcpitanlib.api.block.CompatibleMaterial;
import net.pitan76.mcpitanlib.api.block.ExtendBlock;
import net.pitan76.mcpitanlib.api.registry.result.RegistryResult;
import org.amycute.morematteralchemy.block.PedestalBlock;

import static org.amycute.morematteralchemy.MoreMatterAlchemy.id;
import static org.amycute.morematteralchemy.MoreMatterAlchemy.registry;

public class Blocks {
    public static RegistryResult<Block> BLUE_MATTER_BLOCK, GREEN_MATTER_BLOCK, YELLOW_MATTER_BLOCK, PURPLE_MATTER_BLOCK, WHITE_MATTER_BLOCK, ORANGE_MATTER_BLOCK;
    public static RegistryResult<Block> PEDESTAL_BLOCK;

    public static void init() {
        BLUE_MATTER_BLOCK = registry.registerBlock(id("blue_matter_block"),
                () -> new ExtendBlock(CompatibleBlockSettings.of(CompatibleMaterial.STONE).strength(2.0f, 5.0f)));

        GREEN_MATTER_BLOCK = registry.registerBlock(id("green_matter_block"),
                () -> new ExtendBlock(CompatibleBlockSettings.of(CompatibleMaterial.STONE).strength(2.0f, 5.0f)));

        YELLOW_MATTER_BLOCK = registry.registerBlock(id("yellow_matter_block"),
                () -> new ExtendBlock(CompatibleBlockSettings.of(CompatibleMaterial.STONE).strength(2.0f, 5.0f)));

        PURPLE_MATTER_BLOCK = registry.registerBlock(id("purple_matter_block"),
                () -> new ExtendBlock(CompatibleBlockSettings.of(CompatibleMaterial.STONE).strength(2.0f, 5.0f)));

        WHITE_MATTER_BLOCK = registry.registerBlock(id("white_matter_block"),
                () -> new ExtendBlock(CompatibleBlockSettings.of(CompatibleMaterial.STONE).strength(2.0f, 5.0f)));

        ORANGE_MATTER_BLOCK = registry.registerBlock(id("orange_matter_block"),
                () -> new ExtendBlock(CompatibleBlockSettings.of(CompatibleMaterial.STONE).strength(2.0f, 5.0f)));
        
        PEDESTAL_BLOCK = registry.registerBlock(id("pedestal_block"),
                () -> new PedestalBlock(CompatibleBlockSettings.of(CompatibleMaterial.WOOD).strength(2.0f, 5.0f)));
    }
}
