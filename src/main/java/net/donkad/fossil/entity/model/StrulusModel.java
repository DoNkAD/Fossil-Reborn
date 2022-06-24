package net.donkad.fossil.entity.model;

import net.donkad.fossil.entity.StrulusEntity;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;

public class StrulusModel<S extends StrulusEntity> extends EntityModel<StrulusEntity> {
    private final ModelPart head;
    private final ModelPart body;
    private final ModelPart rightLeg;
    private final ModelPart leftLeg;
    private final ModelPart rightWing;
    private final ModelPart leftWing;
    private final ModelPart chest;

    public StrulusModel (ModelPart root){
        this.head = root.getChild("head");
        this.body = root.getChild("body");
        this.rightLeg = root.getChild("right_leg");
        this.leftLeg = root.getChild("left_leg");
        this.rightWing = root.getChild("right_wing");
        this.leftWing = root.getChild("left_wing");
        this.chest = root.getChild("chest");
    }

    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData modelPartData1 = modelPartData.addChild("head", ModelPartBuilder.create().uv(0,21).cuboid(-3.0F, -13.0F, -3.0F, 6.0F, 5.0F, 6.0F)
                .uv(14,39).cuboid(-2.0F, -12.0F, -8.0F, 4.0F, 4.0F, 5.0F), ModelTransform.pivot(0.0F, 11.0F, -8.0F));
        modelPartData1.addChild("neck", ModelPartBuilder.create().uv(0,32).cuboid(-2.0F, -10.6187F, -2.723F, 4.0F, 11.0F, 3.0F), ModelTransform.of(0.0F, -1.0F, -1.0F, -0.5672F, 0.0F, 0.0F));

        modelPartData.addChild("body", ModelPartBuilder.create().uv(0,0).cuboid(-5.0F, -9.0F, -7.0F, 10.0F, 9.0F, 12.0F)
                .uv(32,0).cuboid(-3.0F, -10.0F, 5.0F, 6.0F, 5.0F, 4.0F)
                .uv(34,31).cuboid(-4.0F, -8.0F, 5.0F, 8.0F, 6.0F, 2.0F)
                .uv(26,21).cuboid(-4.0F, -9.0F, -9.0F, 8.0F, 8.0F, 2.0F), ModelTransform.pivot(0.0F, 15.0F, 0.0F));
        modelPartData.addChild("chest", ModelPartBuilder.create().uv(32,39).cuboid(-4.0F, -20.0F, 5.0F, 8.0F, 6.0F, 4.0F), ModelTransform.pivot(0.0F, 21.0F, -3.0F));

        modelPartData.addChild("right_wing", ModelPartBuilder.create().uv(16, 24).cuboid(-0.50F, 0.0F, -5.0F, 1.0F, 7.0F, 8.0F), ModelTransform.pivot(-5.25F, 6.0F, -1.0F));
        modelPartData.addChild("left_wing", ModelPartBuilder.create().uv(16,24).cuboid(-0.25F, 0.0F, -5.0F, 1.0F, 7.0F, 8.0F), ModelTransform.pivot(5.25F, 6.0F, -1.0F));

        modelPartData.addChild("right_leg", ModelPartBuilder.create().uv(0,0).cuboid(-1.0F, 0.0F, -2.0F, 3.0F, 9.0F, 3.0F), ModelTransform.pivot(2.0F, 15.0F, 0.0F));
        modelPartData.addChild("left_leg", ModelPartBuilder.create().uv(0,0).cuboid(-1.0F, 0.0F, -2.0F, 3.0F, 9.0F, 3.0F), ModelTransform.pivot(-3.0F, 15.0F, 0.0F));

        return TexturedModelData.of(modelData, 64, 64);
    }

    @Override
    public void setAngles(StrulusEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
        this.head.yaw = headYaw * 0.017453292F;
        this.head.pitch = MathHelper.cos(limbAngle * 0.3871F ) * 0.4F * 0.2F * limbDistance;
        this.rightLeg.pitch = MathHelper.cos(limbAngle * 0.6662F) * 1.4F * limbDistance;
        this.leftLeg.pitch = MathHelper.cos(limbAngle * 0.6662F + 3.1415927F) * 1.4F * limbDistance;
        this.rightWing.roll = animationProgress;
        this.leftWing.roll = -animationProgress;

        if (entity.hasChest()) {
            this.chest.visible = true;
        }else {
            this.chest.visible = false;
        }
    }

    @Override
    public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        this.head.render(matrices, vertices, light, overlay);
        this.body.render(matrices, vertices, light, overlay);
        this.rightWing.render(matrices, vertices, light, overlay);
        this.leftWing.render(matrices, vertices, light, overlay);
        this.rightLeg.render(matrices, vertices, light, overlay);
        this.leftLeg.render(matrices, vertices, light, overlay);
        this.chest.render(matrices, vertices, light, overlay);
    }
}
