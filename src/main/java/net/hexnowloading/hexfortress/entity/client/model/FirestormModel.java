package net.hexnowloading.hexfortress.entity.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.hexnowloading.hexfortress.HexFortress;
import net.hexnowloading.hexfortress.entity.FirestormEntity;
import net.hexnowloading.hexfortress.entity.client.animation.FirestormAnimation;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class FirestormModel<T extends FirestormEntity> extends HierarchicalModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(HexFortress.MODID, "firestorm"), "main");
	private final ModelPart root;
	private final ModelPart head;
	private final ModelPart rods;
	private final ModelPart rod1;
	private final ModelPart rod2;
	private final ModelPart rod3;
	private final ModelPart rod4;
	private final ModelPart lower_rods;
	private final ModelPart lower_rod1;
	private final ModelPart lower_rod2;
	private final ModelPart lower_rod3;
	private final ModelPart lower_rod4;

	public FirestormModel(ModelPart root) {
		this.root = root;
		this.head = root.getChild("head");
		this.rods = root.getChild("rods");
		this.rod1 = this.rods.getChild("rod1");
		this.rod2 = this.rods.getChild("rod2");
		this.rod3 = this.rods.getChild("rod3");
		this.rod4 = this.rods.getChild("rod4");
		this.lower_rods = root.getChild("lower_rods");
		this.lower_rod1 = this.lower_rods.getChild("lower_rod1");
		this.lower_rod2 = this.lower_rods.getChild("lower_rod2");
		this.lower_rod3 = this.lower_rods.getChild("lower_rod3");
		this.lower_rod4 = this.lower_rods.getChild("lower_rod4");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(32, 19).addBox(-4.0F, -9.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(0, 27).addBox(-4.5F, -16.5F, -4.5F, 9.0F, 18.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(-5.0F, -17.0F, -5.0F, 10.0F, 17.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.0F, 0.0F));

		PartDefinition rods = partdefinition.addOrReplaceChild("rods", CubeListBuilder.create(), PartPose.offset(0.0F, 26.0F, 0.0F));

		PartDefinition rod1 = rods.addOrReplaceChild("rod1", CubeListBuilder.create().texOffs(30, 0).addBox(-8.3694F, -3.9134F, -2.0F, 11.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.75F, -14.0F, 0.0F, 0.0F, 0.0F, 1.1781F));

		PartDefinition cube_r1 = rod1.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 0).addBox(8.0F, -5.9134F, -6.6194F, 0.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(6.0F, -5.9134F, -6.6194F, 0.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(28, 8).addBox(3.0F, -0.9134F, -6.6194F, 8.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(28, 8).addBox(3.0F, -2.9134F, -6.6194F, 8.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(36, 35).addBox(4.0F, -4.9134F, -6.6194F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, 0.0F, 7.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition rod2 = rods.addOrReplaceChild("rod2", CubeListBuilder.create().texOffs(30, 0).addBox(-8.3694F, -3.9134F, -2.0F, 11.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, -14.0F, -8.0F, 1.5708F, 0.3927F, 1.5708F));

		PartDefinition cube_r2 = rod2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 25).addBox(6.0F, -5.9134F, -6.6194F, 0.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 25).addBox(8.0F, -5.9134F, -6.6194F, 0.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(28, 8).addBox(3.0F, -0.9134F, -6.6194F, 8.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(28, 8).addBox(3.0F, -2.9134F, -6.6194F, 8.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(36, 35).addBox(4.0F, -4.9134F, -6.6194F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, 0.0F, 7.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition rod3 = rods.addOrReplaceChild("rod3", CubeListBuilder.create().texOffs(30, 0).addBox(-8.3694F, -3.9134F, -2.0F, 11.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.25F, -14.0F, 0.0F, 3.1416F, 0.0F, 1.9635F));

		PartDefinition cube_r3 = rod3.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(0, 0).addBox(6.0F, -5.9134F, -6.6194F, 0.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(8.0F, -5.9134F, -6.6194F, 0.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(28, 8).addBox(3.0F, -0.9134F, -6.6194F, 8.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(28, 8).addBox(3.0F, -2.9134F, -6.6194F, 8.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(36, 35).addBox(4.0F, -4.9134F, -6.6194F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, 0.0F, 7.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition rod4 = rods.addOrReplaceChild("rod4", CubeListBuilder.create().texOffs(30, 0).addBox(-8.3694F, -3.9134F, -2.0F, 11.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, -14.0F, 8.0F, -1.5708F, -0.3927F, 1.5708F));

		PartDefinition cube_r4 = rod4.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(0, 0).addBox(8.0F, -5.9134F, -6.6194F, 0.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(0, 0).addBox(6.0F, -5.9134F, -6.6194F, 0.0F, 8.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(28, 8).addBox(3.0F, -0.9134F, -6.6194F, 8.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(28, 8).addBox(3.0F, -2.9134F, -6.6194F, 8.0F, 0.0F, 2.0F, new CubeDeformation(0.0F))
				.texOffs(36, 35).addBox(4.0F, -4.9134F, -6.6194F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, 0.0F, 7.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition lower_rods = partdefinition.addOrReplaceChild("lower_rods", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition lower_rod1 = lower_rods.addOrReplaceChild("lower_rod1", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition lower_rod_r1 = lower_rod1.addOrReplaceChild("lower_rod_r1", CubeListBuilder.create().texOffs(36, 43).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, -8.0F, 0.0F, 0.0F, -1.5708F, 0.0F));

		PartDefinition lower_rod2 = lower_rods.addOrReplaceChild("lower_rod2", CubeListBuilder.create().texOffs(36, 43).addBox(-1.0F, -13.0F, -5.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition lower_rod3 = lower_rods.addOrReplaceChild("lower_rod3", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition lower_rod_r2 = lower_rod3.addOrReplaceChild("lower_rod_r2", CubeListBuilder.create().texOffs(36, 43).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, -8.0F, 0.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition lower_rod4 = lower_rods.addOrReplaceChild("lower_rod4", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition lower_rod_r3 = lower_rod4.addOrReplaceChild("lower_rod_r3", CubeListBuilder.create().texOffs(36, 43).addBox(-1.0F, -5.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, -8.0F, 4.0F, 0.0F, 3.1416F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateHeadLookTarget(netHeadYaw, headPitch);
		this.animateIdlePose(ageInTicks);
		this.animateRodSpin(entity, ageInTicks);
		this.animateLowerRodSpin(ageInTicks);
		this.animate(entity.attackAnimationState, FirestormAnimation.FIRESTORM_ATTACK, ageInTicks);
		this.animate(entity.attackRevertAnimationState, FirestormAnimation.FIRESTORM_ATTACK_REVERT, ageInTicks);
	}

	private void animateHeadLookTarget(float netHeadYaw, float headPitch) {
		this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);
		this.head.xRot = headPitch * ((float)Math.PI / 180F);
	}

	private void animateRodSpin(T entity, float ageInTicks) {
		float ROD_Y = 24.0F;
		float VERTICAL_OSCILLATION = 2.0F;
		float spinPerSecond;

		if (entity.isCharged()) {
			spinPerSecond = 0.75F;
		} else {
			spinPerSecond = 2.0F;
		}

		float e = (ageInTicks / (20.0F * spinPerSecond))*2*(float) Math.PI;
		float f = (ageInTicks / (20.0F * VERTICAL_OSCILLATION))*2*(float) Math.PI;
		float f1 = Mth.sin(f)*3F + ROD_Y;
		float r1 = Mth.sin(f)*0.2F;
		float r2 = -Mth.sin(f)*0.2F;
		float r3 = -Mth.sin(f)*0.2F;
		float r4 = Mth.sin(f)*0.2F;

		this.rods.yRot = e;
		this.rods.y = f1;

		this.rod1.zRot += r1;
		this.rod2.yRot += r2;
		this.rod3.zRot += r3;
		this.rod4.yRot += r4;
	}

	private void animateAttackStart(float ageInTicks) {
		float f = ageInTicks * 0.125F; // 3 seconds

	}

	private void animateLowerRodSpin(float ageInTicks) {
		float SPIN_PER_SECOND = 3.0F;
		float ROD_Y = 4.0F;
		float f = (ageInTicks / (20.0F * SPIN_PER_SECOND))*2*(float) Math.PI;
		float f1 = ROD_Y;
		float r = (ageInTicks / (20.0F * 2.0F))*2*(float) Math.PI;
		float r1 = Mth.sin(r)*1.5F;
		float r2 = -Mth.sin(r)*1.5F;

		this.lower_rods.yRot = f;
		this.lower_rods.y = f1;
		this.lower_rod1.y = r1 + 20.0F;
		this.lower_rod2.y = r2 + 20.0F;
		this.lower_rod3.y = r1 + 20.0F;
		this.lower_rod4.y = r2 + 20.0F;
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
		poseStack.scale(1.5F, 1.5F, 1.5F);
		poseStack.translate(0.0F, -0.5F, 0.0F);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rods.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		lower_rods.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}