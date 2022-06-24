package net.donkad.fossil.entity.render.layer;

import net.donkad.fossil.entity.StrulusEntity;
import net.donkad.fossil.entity.model.StrulusModel;
import net.donkad.fossil.entity.render.StrulusRender;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

import static net.donkad.fossil.FossilReborn.MODID;

public class StrulusSaddleRender extends FeatureRenderer<StrulusEntity, StrulusModel<StrulusEntity>> {
    private static final Identifier TEXTURE = new Identifier(MODID, "textures/entity/strulus/saddle.png");


    public StrulusSaddleRender(FeatureRendererContext<StrulusEntity, StrulusModel<StrulusEntity>> context) {
        super(context);
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, StrulusEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
    if (entity.isSaddled()) {
        VertexConsumer vertexConsumer = vertexConsumers.getBuffer(RenderLayer.getEntityCutout(TEXTURE));
        this.getContextModel().render(matrices, vertexConsumer, light, StrulusRender.getOverlay(entity, 0.0F), 1.0F, 1.0F, 1.0F, 1.0F);
        }
    }
}
