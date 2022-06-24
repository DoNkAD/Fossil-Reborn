package net.donkad.fossil.entity.render;

import net.donkad.fossil.FossilClient;
import net.donkad.fossil.entity.StrulusEntity;
import net.donkad.fossil.entity.model.StrulusModel;
import net.donkad.fossil.entity.render.layer.StrulusSaddleRender;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

import static net.donkad.fossil.FossilReborn.*;

@Environment(EnvType.CLIENT)
public class StrulusRender extends MobEntityRenderer<StrulusEntity, StrulusModel<StrulusEntity>> {
    private static final Identifier[] TEXTURES = new Identifier[]{
            new Identifier(MODID, "textures/entity/strulus/strulus.png"),
            new Identifier(MODID, "textures/entity/strulus/black_strulus.png"),
            new Identifier(MODID, "textures/entity/strulus/golden_strulus.png")};

    public StrulusRender(EntityRendererFactory.Context context) {
        super(context, new StrulusModel<>(context.getPart(FossilClient.STRULUS_LAYER)), 0.5F);
        this.addFeature(new StrulusSaddleRender(this));
    }

    @Override
    public Identifier getTexture(StrulusEntity entity) {
        return TEXTURES[entity.getVariant()];
    }

    @Override
    protected float getAnimationProgress(StrulusEntity entity, float tickDelta) {
        float g = MathHelper.lerp(tickDelta, entity.prevFlapProgress , entity.flapProgress);
        float h = MathHelper.lerp(tickDelta, entity.prevMaxWingDeviation, entity.maxWingDeviation);
        return (MathHelper.sin(g) + 1.0F) * h;
    }
}
