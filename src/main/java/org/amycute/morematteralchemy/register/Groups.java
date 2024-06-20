package org.amycute.morematteralchemy.register;

import net.minecraft.item.ItemStack;
import net.pitan76.mcpitanlib.api.item.CreativeTabBuilder;

import static org.amycute.morematteralchemy.MoreMatterAlchemy.id;
import static org.amycute.morematteralchemy.MoreMatterAlchemy.registry;


public class Groups
{
    public static CreativeTabBuilder ITEMS = CreativeTabBuilder.create(id("items")).setIcon(() -> new ItemStack(Items.ORANGE_MATTER.getOrNull(), 1));

    public static void init() {
        registry.registerItemGroup(ITEMS);
    }
}
