package net.donkad.fossil.entity.model;

import net.donkad.fossil.entity.BrachiosaurusEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class BrachiosaurusModel<S extends BrachiosaurusEntity> extends EntityModel<BrachiosaurusEntity> {
    private final ModelPart cube;

    public BrachiosaurusModel (ModelPart root){
        this.cube = root.getChild("cube");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        modelPartData.addChild("cube", new ModelPartBuilder().uv(0,0).cuboid(0,0,0,16,16,16), ModelTransform.pivot(0,0,0));
        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(BrachiosaurusEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {

    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        this.cube.render(matrices, vertices, light, overlay);
    }
}
