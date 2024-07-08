package org.amycute.morematteralchemy.block.renderer;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3f;
import org.amycute.morematteralchemy.block.entity.PedestalBlockEntity;

public class PedestalRenderer implements BlockEntityRenderer<PedestalBlockEntity>
{
    public PedestalRenderer(BlockEntityRendererFactory.Context context) { }
    @Override
    public void render(PedestalBlockEntity pedestal, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        if(!pedestal.isRemoved() || pedestal.getWorld() == null) return;

        ItemStack stack = pedestal.getInventory().get(0);
        if(stack.isEmpty()) return;

        matrices.push();
        matrices.translate(.5,.7,.5);
        long gameTime = pedestal.world.getMinecraftWorld().getTime();

        matrices.translate(0, Math.sin((gameTime / 10.0f)) * 0.2, 0);
        matrices.scale(.75f,.75f,.75f);
        float angle = gameTime / 20.0f * (180f / (float) Math.PI);
        matrices.multiply(Vec3f.POSITIVE_Y.getDegreesQuaternion(angle));

        MinecraftClient.getInstance().getItemRenderer().renderItem(
                stack,
                ModelTransformation.Mode.GROUND,
                light,
                overlay,
                matrices,
                vertexConsumers,
                (int) pedestal.getPos().asLong()
        );
        matrices.pop();

        System.out.println("SEXE SEXE SEXE "+matrices);
    }
}
