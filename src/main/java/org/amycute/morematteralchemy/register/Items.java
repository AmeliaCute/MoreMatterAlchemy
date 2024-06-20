package org.amycute.morematteralchemy.register;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.pitan76.mcpitanlib.api.item.CompatibleItemSettings;
import net.pitan76.mcpitanlib.api.item.ExtendItem;
import net.pitan76.mcpitanlib.api.registry.result.RegistryResult;
import net.pitan76.mcpitanlib.api.util.ItemUtil;

import static org.amycute.morematteralchemy.MoreMatterAlchemy.id;
import static org.amycute.morematteralchemy.MoreMatterAlchemy.registry;

public class Items {
    public static RegistryResult<Item> ORANGE_MATTER, YELLOW_MATTER, GREEN_MATTER, BLUE_MATTER, PURPLE_MATTER, WHITE_MATTER;
    public static RegistryResult<Item> ORANGE_MATTER_BLOCK, YELLOW_MATTER_BLOCK, GREEN_MATTER_BLOCK, BLUE_MATTER_BLOCK, PURPLE_MATTER_BLOCK, WHITE_MATTER_BLOCK;

    public static void init() {
        ORANGE_MATTER = registry.registerItem(id("orange_matter"), () -> new ExtendItem(CompatibleItemSettings.of().addGroup(Groups.ITEMS)));
        YELLOW_MATTER = registry.registerItem(id("yellow_matter"), () -> new ExtendItem(CompatibleItemSettings.of().addGroup(Groups.ITEMS)));
        GREEN_MATTER = registry.registerItem(id("green_matter"), () -> new ExtendItem(CompatibleItemSettings.of().addGroup(Groups.ITEMS)));
        BLUE_MATTER = registry.registerItem(id("blue_matter"), () -> new ExtendItem(CompatibleItemSettings.of().addGroup(Groups.ITEMS)));
        PURPLE_MATTER = registry.registerItem(id("purple_matter"), () -> new ExtendItem(CompatibleItemSettings.of().addGroup(Groups.ITEMS)));
        WHITE_MATTER = registry.registerItem(id("white_matter"), () -> new ExtendItem(CompatibleItemSettings.of().addGroup(Groups.ITEMS)));

        ORANGE_MATTER_BLOCK = registry.registerItem(id("orange_matter_block"), () -> ItemUtil.ofBlock(Blocks.ORANGE_MATTER_BLOCK.getOrNull(), CompatibleItemSettings.of().addGroup(Groups.ITEMS)));
        YELLOW_MATTER_BLOCK = registry.registerItem(id("yellow_matter_block"), () -> ItemUtil.ofBlock(Blocks.YELLOW_MATTER_BLOCK.getOrNull(), CompatibleItemSettings.of().addGroup(Groups.ITEMS)));
        GREEN_MATTER_BLOCK = registry.registerItem(id("green_matter_block"), () -> ItemUtil.ofBlock(Blocks.GREEN_MATTER_BLOCK.getOrNull(), CompatibleItemSettings.of().addGroup(Groups.ITEMS)));
        BLUE_MATTER_BLOCK = registry.registerItem(id("blue_matter_block"), () -> ItemUtil.ofBlock(Blocks.BLUE_MATTER_BLOCK.getOrNull(), CompatibleItemSettings.of().addGroup(Groups.ITEMS)));
        PURPLE_MATTER_BLOCK = registry.registerItem(id("purple_matter_block"), () -> ItemUtil.ofBlock(Blocks.PURPLE_MATTER_BLOCK.getOrNull(), CompatibleItemSettings.of().addGroup(Groups.ITEMS)));
        WHITE_MATTER_BLOCK = registry.registerItem(id("white_matter_block"), () -> ItemUtil.ofBlock(Blocks.WHITE_MATTER_BLOCK.getOrNull(), CompatibleItemSettings.of().addGroup(Groups.ITEMS)));
    }
}
