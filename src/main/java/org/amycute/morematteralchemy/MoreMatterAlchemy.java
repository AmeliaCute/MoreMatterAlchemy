package org.amycute.morematteralchemy;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.block.Material;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.RegistryEntry;
import net.pitan76.mcpitanlib.api.item.CreativeTabBuilder;
import net.pitan76.mcpitanlib.api.registry.CompatRegistry;
import org.amycute.morematteralchemy.register.Blocks;
import org.amycute.morematteralchemy.register.Groups;
import org.amycute.morematteralchemy.register.Items;

public class MoreMatterAlchemy implements ModInitializer {

    public static final String MOD_ID = "morematteralchemy";
    public static CompatRegistry registry = CompatRegistry.createRegistry(MOD_ID);

    // Btw just wtf?? why pitan76?
    public static Identifier id(String id) {
        return new Identifier(MOD_ID, id);
    }

    public static ItemGroup MORE_MATTER_ALCHEMY_GROUP = CreativeTabBuilder.create(id("items")).setIcon(() -> new ItemStack(Items.ORANGE_MATTER.getOrNull(), 1)).build();

    @Override
    public void onInitialize() {
        Groups.init();
        Blocks.init();
        Items.init();

        registry.allRegister();
    }
}
