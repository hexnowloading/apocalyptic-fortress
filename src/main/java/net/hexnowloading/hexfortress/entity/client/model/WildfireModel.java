package net.hexnowloading.hexfortress.entity.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.hexnowloading.hexfortress.HexFortress;
import net.hexnowloading.hexfortress.entity.WildfireEntity;
import net.hexnowloading.hexfortress.entity.client.animation.WildfireAnimation;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;

public class WildfireModel<T extends WildfireEntity> extends HierarchicalModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(HexFortress.MODID, "furious_blaze"), "main");
	private final ModelPart root;
	private final ModelPart head;
	private final ModelPart rods;
	private final ModelPart rod1;
	private final ModelPart rod2;
	private final ModelPart rod3;
	private final ModelPart rod4;
	private final ModelPart core;
	private final ModelPart lower_rods;
	private final ModelPart lower_rod1;
	private final ModelPart lower_rod2;
	private final ModelPart lower_rod3;
	private final ModelPart lower_rod4;

	public WildfireModel(ModelPart root) {
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

		this.core = root.getChild("core");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -10.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
				.texOffs(28, 24).mirror().addBox(-4.5F, -22.0F, -4.5F, 9.0F, 22.0F, 9.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 1.0F, 0.0F));

		PartDefinition rods = partdefinition.addOrReplaceChild("rods", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition rod1 = rods.addOrReplaceChild("rod1", CubeListBuilder.create().texOffs(16, 16).addBox(-9.2933F, -4.2961F, -2.0F, 11.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(7.75F, -14.0F, 0.0F, 0.0F, 0.0F, 1.1781F));

		PartDefinition ring_r1 = rod1.addOrReplaceChild("ring_r1", CubeListBuilder.create().texOffs(0, 16).addBox(4.0F, -5.2961F, -7.5433F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, 0.0F, 7.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition rod2 = rods.addOrReplaceChild("rod2", CubeListBuilder.create().texOffs(16, 16).addBox(-9.2933F, -4.2961F, -2.0F, 11.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, -14.0F, -8.0F, 1.5708F, 0.3927F, 1.5708F));

		PartDefinition ring_r2 = rod2.addOrReplaceChild("ring_r2", CubeListBuilder.create().texOffs(0, 16).addBox(4.0F, -5.2961F, -7.5433F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, 0.0F, 7.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition rod3 = rods.addOrReplaceChild("rod3", CubeListBuilder.create().texOffs(16, 16).addBox(-9.2933F, -4.2961F, -2.0F, 11.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.25F, -14.0F, 0.0F, 3.1416F, 0.0F, 1.9635F));

		PartDefinition cube_r1 = rod3.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(0, 16).addBox(4.0F, -5.2961F, -7.5433F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, 0.0F, 7.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition rod4 = rods.addOrReplaceChild("rod4", CubeListBuilder.create().texOffs(16, 16).addBox(-9.2933F, -4.2961F, -2.0F, 11.0F, 4.0F, 4.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.25F, -14.0F, 8.0F, -1.5708F, -0.3927F, 1.5708F));

		PartDefinition cube_r2 = rod4.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(0, 16).addBox(4.0F, -5.2961F, -7.5433F, 6.0F, 6.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.75F, 0.0F, 7.0F, 0.0F, 1.5708F, 0.0F));

		PartDefinition core = partdefinition.addOrReplaceChild("core", CubeListBuilder.create().texOffs(0, 24).addBox(-3.0F, -1.0F, 1.0F, 2.0F, 18.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 4.0F, -2.0F));

		PartDefinition lower_rods = partdefinition.addOrReplaceChild("lower_rods", CubeListBuilder.create(), PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition lower_rod1 = lower_rods.addOrReplaceChild("lower_rod1", CubeListBuilder.create().texOffs(8, 24).addBox(3.0F, 5.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition lower_rod2 = lower_rods.addOrReplaceChild("lower_rod2", CubeListBuilder.create().texOffs(8, 24).addBox(-1.0F, -15.0F, -5.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition lower_rod3 = lower_rods.addOrReplaceChild("lower_rod3", CubeListBuilder.create().texOffs(8, 24).addBox(-5.0F, 5.0F, -1.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition lower_rod4 = lower_rods.addOrReplaceChild("lower_rod4", CubeListBuilder.create().texOffs(8, 24).addBox(-1.0F, -15.0F, 3.0F, 2.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.animateHeadLookTarget(netHeadYaw, headPitch);
		this.animateIdlePose(ageInTicks);
		this.animateRodSpin(entity, ageInTicks);
		this.animateLowerRodSpin(ageInTicks);
		this.animate(entity.attackAnimationState, WildfireAnimation.WILDFIRE_ATTACK, ageInTicks);
		this.animate(entity.attackRevertAnimationState, WildfireAnimation.WILDFIRE_ATTACK_REVERT, ageInTicks);
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
		this.lower_rod1.y = r1;
		this.lower_rod2.y = r2 + 20.0F;
		this.lower_rod3.y = r1;
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
		poseStack.translate(0.0F, -0.25F, 0.0F);
		head.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		rods.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		//core.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		lower_rods.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() {
		return this.root;
	}
}