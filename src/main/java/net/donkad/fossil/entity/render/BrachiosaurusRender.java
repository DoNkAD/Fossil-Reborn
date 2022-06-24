package net.donkad.fossil.entity.render;

import net.donkad.fossil.FossilClient;
import net.donkad.fossil.FossilReborn;
import net.donkad.fossil.entity.BrachiosaurusEntity;
import net.donkad.fossil.entity.model.BrachiosaurusModel;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class BrachiosaurusRender extends MobEntityRenderer<BrachiosaurusEntity, BrachiosaurusModel<BrachiosaurusEntity>> {
    public static final Identifier TEXTURE = new Identifier(FossilReborn.MODID, "textures/entity/brachiosaurus/light.png");

    public BrachiosaurusRender(EntityRendererFactory.Context context) {
        super(context, new BrachiosaurusModel<>(context.getPart(FossilClient.BRACHIOSAURUS_LAYER)), 0.5F);
    }

    @Override
    public Identifier getTexture(BrachiosaurusEntity entity) {
        return TEXTURE;
    }
}
