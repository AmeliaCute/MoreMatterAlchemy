package org.amycute.morematteralchemy;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import net.pitan76.mcpitanlib.api.registry.CompatRegistry;
import org.amycute.morematteralchemy.register.Blocks;
import org.amycute.morematteralchemy.register.BlocksEntity;
import org.amycute.morematteralchemy.register.Groups;
import org.amycute.morematteralchemy.register.Items;

public class MoreMatterAlchemy implements ModInitializer {

    public static final String MOD_ID = "morematteralchemy";
    public static CompatRegistry registry = CompatRegistry.createRegistry(MOD_ID);

    // Btw just wtf?? why pitan76?
    public static Identifier id(String id) { return new Identifier(MOD_ID, id); }

    @Override
    public void onInitialize() {
        Groups.init();
        Blocks.init();
        Items.init();
        BlocksEntity.init();

        registry.allRegister();
    }
}
