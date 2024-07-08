package org.amycute.morematteralchemy;

import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.block.entity.BlockEntityType;
import org.amycute.morematteralchemy.block.entity.PedestalBlockEntity;
import org.amycute.morematteralchemy.block.renderer.PedestalRenderer;
import org.amycute.morematteralchemy.register.BlocksEntity;

public class MoreMatterAlchemyClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRendererRegistry.register((BlockEntityType<PedestalBlockEntity>) BlocksEntity.PEDESTAL_BLOCK_ENTITY.getOrNull(), PedestalRenderer::new);
    }
}
