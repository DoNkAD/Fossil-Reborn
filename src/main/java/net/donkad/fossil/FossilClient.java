package net.donkad.fossil;

import net.donkad.fossil.entity.EntityInit;
import net.donkad.fossil.entity.model.BrachiosaurusModel;
import net.donkad.fossil.entity.model.StrulusModel;
import net.donkad.fossil.entity.render.BrachiosaurusRender;
import net.donkad.fossil.entity.render.StrulusRender;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class FossilClient implements ClientModInitializer {

    //Entity Render
    public static final EntityModelLayer STRULUS_LAYER =
            new EntityModelLayer(new Identifier("fossil:strulus_render_layer"), "strulus_render_layer");

    public static final EntityModelLayer BRACHIOSAURUS_LAYER =
            new EntityModelLayer(new Identifier("fossil:brachiosaurus_render_layer"), "brachiosaurus_render_layer");

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(EntityInit.STRULUS, StrulusRender::new);
        EntityModelLayerRegistry.registerModelLayer(STRULUS_LAYER, StrulusModel::getTexturedModelData);

        EntityRendererRegistry.register(EntityInit.BRACHIOSAURUS, BrachiosaurusRender::new);
        EntityModelLayerRegistry.registerModelLayer(BRACHIOSAURUS_LAYER, BrachiosaurusModel::getTexturedModelData);
    }
}
