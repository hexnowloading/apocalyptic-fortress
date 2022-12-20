package net.hexnowloading.hexfortress.entity.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.hexnowloading.hexfortress.HexFortress;
import net.hexnowloading.hexfortress.entity.TestEntity;
import net.hexnowloading.hexfortress.entity.client.animation.TestAnimation;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class TestModel<T extends TestEntity> extends HierarchicalModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(HexFortress.MODID, "testentity"), "main");
	private final ModelPart root;
    private final ModelPart right_leg;
	private final ModelPart left_leg;
	private final ModelPart head;

	public TestModel(ModelPart root) {
        this.root = root;
		this.right_leg = root.getChild("right_leg");
		this.head = root.getChild("head");
		this.left_leg = root.getChild("left_leg");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		partdefinition.addOrReplaceChild("right_leg", CubeListBuilder.create()
				.texOffs(0, 8)
				.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(-1.0F, 22.0F, 0.0F));

		partdefinition.addOrReplaceChild("head", CubeListBuilder.create()
				.texOffs(0, 0)
				.addBox(-2.0F, -4.0F, -2.0F, 4.0F, 4.0F, 4.0F, new CubeDeformation(0.5F)),
				PartPose.offset(0.0F, 22.0F, 0.0F));

		partdefinition.addOrReplaceChild("left_leg", CubeListBuilder.create()
				.texOffs(0, 8)
				.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)),
				PartPose.offset(1.0F, 22.0F, 0.0F));


		return LayerDefinition.create(meshdefinition, 16, 16);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateHeadLookTarget(netHeadYaw, headPitch);
		this.animateIdlePose(ageInTicks);
		float f = Math.min((float)entity.getDeltaMovement().lengthSqr() * 200.0F, 8.0F);
		this.animate(entity.walkAnimationState, TestAnimation.TESTENTITY_WALK, ageInTicks, f);
		this.animate(entity.extendAnimationState, TestAnimation.TESTENTITY_HURT_FLIP, ageInTicks);
		//this.animate(entity.idleAnimationState, TestAnimation.TESTENTITY_IDLE, ageInTicks);
	}

	private void animateHeadLookTarget(float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = headPitch * ((float)Math.PI / 180F);
	}

	private void animateIdlePose(float ageInTicks) {
		float f = ageInTicks * 0.1F;
		float f1 = Mth.cos(f);
		float f2 = Mth.sin(f);
		this.head.zRot += 0.06F * f1;
		this.head.xRot += 0.06F * f2;
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		right_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		left_leg.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

    @Override
    public ModelPart root() {
        return this.root;
    }
}