package net.hexnowloading.hexfortress.entity.client.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.hexnowloading.hexfortress.HexFortress;
import net.hexnowloading.hexfortress.entity.FortressWalkerEntity;
import net.hexnowloading.hexfortress.entity.client.animation.FortressWalkerAnimation;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;

public class FortressWalkerModel<T extends FortressWalkerEntity> extends HierarchicalModel<T> {
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(HexFortress.MODID, "fortress_walker"), "main");
	private final ModelPart root;
	private final ModelPart Body;
	private final ModelPart LegFL;
	private final ModelPart LegFR;
	private final ModelPart LegBL;
	private final ModelPart LegBR;

	public FortressWalkerModel(ModelPart root) {
		this.root = root;
		this.Body = root.getChild("Body");
		this.LegFL = root.getChild("LegFL");
		this.LegFR = root.getChild("LegFR");
		this.LegBL = root.getChild("LegBL");
		this.LegBR = root.getChild("LegBR");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition Body = partdefinition.addOrReplaceChild("Body", CubeListBuilder.create().texOffs(0, 0).addBox(-27.0F, -73.0F, -33.0F, 54.0F, 34.0F, 64.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition BodyLeft = Body.addOrReplaceChild("BodyLeft", CubeListBuilder.create().texOffs(0, 98).addBox(0.0F, -34.0F, -38.0F, 30.0F, 2.0F, 76.0F, new CubeDeformation(0.0F))
		.texOffs(212, 166).addBox(0.0F, -56.0F, 38.0F, 30.0F, 24.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition BodyLeftTop = BodyLeft.addOrReplaceChild("BodyLeftTop", CubeListBuilder.create().texOffs(172, 0).addBox(-30.0F, 0.0F, 24.0F, 30.0F, 2.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(0, 124).addBox(-14.0F, 0.0F, 0.0F, 14.0F, 2.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(0, 98).addBox(-14.0F, 0.0F, -24.0F, 14.0F, 2.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(136, 150).addBox(-30.0F, 0.0F, -38.0F, 30.0F, 2.0F, 14.0F, new CubeDeformation(0.0F))
		.texOffs(204, 192).addBox(-14.0F, -16.0F, -40.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(200, 108).addBox(-14.0F, -16.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(156, 176).addBox(-14.0F, -16.0F, 24.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F))
		.texOffs(0, 98).addBox(-13.0F, 1.0F, 12.0F, 10.0F, 19.0F, 0.0F, new CubeDeformation(0.0F))
		.texOffs(11, 0).addBox(-21.0F, 11.0F, 21.0F, 10.0F, 0.0F, 17.0F, new CubeDeformation(0.0F))
		.texOffs(11, 0).addBox(-19.0F, 8.0F, -38.0F, 10.0F, 0.0F, 17.0F, new CubeDeformation(0.0F))
		.texOffs(0, 98).addBox(-13.0F, 1.0F, -12.0F, 10.0F, 19.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(30.0F, -80.0F, 0.0F));

		PartDefinition SlotLeftTopBack = BodyLeftTop.addOrReplaceChild("SlotLeftTopBack", CubeListBuilder.create().texOffs(136, 124).addBox(-16.0F, 0.0F, -24.0F, 16.0F, 2.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(-14.0F, 0.0F, 24.0F));

		PartDefinition SlotLeftTopFront = BodyLeftTop.addOrReplaceChild("SlotLeftTopFront", CubeListBuilder.create().texOffs(136, 98).addBox(-16.0F, 0.0F, 0.0F, 16.0F, 2.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(-14.0F, 0.0F, -24.0F));

		PartDefinition SlotLeftFront = BodyLeftTop.addOrReplaceChild("SlotLeftFront", CubeListBuilder.create().texOffs(216, 140).addBox(-30.0F, 0.0F, 0.0F, 30.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, -40.0F));

		PartDefinition SlotLeftBack = BodyLeftTop.addOrReplaceChild("SlotLeftBack", CubeListBuilder.create().texOffs(0, 224).addBox(-15.0F, 0.0F, 0.0F, 30.0F, 24.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(-15.0F, 0.0F, 38.0F));

		PartDefinition BodyLeftFront = BodyLeft.addOrReplaceChild("BodyLeftFront", CubeListBuilder.create().texOffs(0, 150).addBox(-30.0F, 0.25F, 0.0F, 30.0F, 16.0F, 2.0F, new CubeDeformation(0.0F))
		.texOffs(11, 0).addBox(-19.0F, 5.25F, 2.0F, 10.0F, 0.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(30.0F, -48.25F, -40.0F));

		PartDefinition BodyLeftFrotFont = BodyLeftFront.addOrReplaceChild("BodyLeftFrotFont", CubeListBuilder.create().texOffs(11, 0).addBox(-19.0F, -2.5F, 2.0F, 10.0F, 0.0F, 17.0F, new CubeDeformation(0.0F))
		.texOffs(64, 247).addBox(-20.0F, -8.5F, 0.0F, 20.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -8.25F, 0.0F));

		PartDefinition SlotLeftBackBottom = BodyLeft.addOrReplaceChild("SlotLeftBackBottom", CubeListBuilder.create().texOffs(218, 224).addBox(0.0F, -12.0F, -16.0F, 2.0F, 24.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(30.0F, -44.0F, 40.0F));

		PartDefinition SlotLeftBackBottoparttwo = SlotLeftBackBottom.addOrReplaceChild("SlotLeftBackBottoparttwo", CubeListBuilder.create().texOffs(52, 176).addBox(-2.0F, -12.0F, -24.0F, 2.0F, 24.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(0, 48).addBox(-22.0F, -5.0F, -14.0F, 20.0F, 0.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, -16.0F));

		PartDefinition SlotLeftBackTop = BodyLeft.addOrReplaceChild("SlotLeftBackTop", CubeListBuilder.create().texOffs(236, 34).addBox(0.0F, -12.0F, -16.0F, 2.0F, 24.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(30.0F, -68.0F, 40.0F));

		PartDefinition SlotLeftBackTopparttwo = SlotLeftBackTop.addOrReplaceChild("SlotLeftBackTopparttwo", CubeListBuilder.create().texOffs(104, 176).addBox(-2.0F, -12.0F, -24.0F, 2.0F, 24.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, -16.0F));

		PartDefinition SlotLeftFrontLow2 = BodyLeft.addOrReplaceChild("SlotLeftFrontLow2", CubeListBuilder.create().texOffs(118, 224).addBox(0.0F, -12.0F, 0.0F, 2.0F, 24.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(30.0F, -44.0F, -40.0F));

		PartDefinition SlotLeftMiddleLow2 = SlotLeftFrontLow2.addOrReplaceChild("SlotLeftMiddleLow2", CubeListBuilder.create().texOffs(0, 176).addBox(-2.0F, -12.0F, 0.0F, 2.0F, 24.0F, 24.0F, new CubeDeformation(0.0F))
		.texOffs(0, 48).addBox(-22.0F, -5.0F, 4.0F, 20.0F, 0.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, 16.0F));

		PartDefinition SlotLeftFrontTop = BodyLeft.addOrReplaceChild("SlotLeftFrontTop", CubeListBuilder.create().texOffs(182, 219).addBox(0.0F, -12.0F, 0.0F, 2.0F, 24.0F, 16.0F, new CubeDeformation(0.0F)), PartPose.offset(30.0F, -68.0F, -40.0F));

		PartDefinition SlotLeftMiddleTop = SlotLeftFrontTop.addOrReplaceChild("SlotLeftMiddleTop", CubeListBuilder.create().texOffs(0, 0).addBox(-2.0F, -12.0F, 0.0F, 2.0F, 24.0F, 24.0F, new CubeDeformation(0.0F)), PartPose.offset(2.0F, 0.0F, 16.0F));

		PartDefinition BodyRight = Body.addOrReplaceChild("BodyRight", CubeListBuilder.create().texOffs(0, 98).mirror().addBox(-30.0F, -34.0F, -38.0F, 30.0F, 2.0F, 76.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(212, 166).mirror().addBox(-30.0F, -56.0F, 38.0F, 30.0F, 24.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition BodyRightTop = BodyRight.addOrReplaceChild("BodyRightTop", CubeListBuilder.create().texOffs(172, 0).mirror().addBox(0.0F, 0.0F, 24.0F, 30.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 124).mirror().addBox(0.0F, 0.0F, 0.0F, 14.0F, 2.0F, 24.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 98).mirror().addBox(0.0F, 0.0F, -24.0F, 14.0F, 2.0F, 24.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(136, 150).mirror().addBox(0.0F, 0.0F, -38.0F, 30.0F, 2.0F, 14.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(204, 192).mirror().addBox(-2.0F, -16.0F, -40.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(200, 108).mirror().addBox(-2.0F, -16.0F, -8.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(156, 176).mirror().addBox(-2.0F, -16.0F, 24.0F, 16.0F, 16.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 98).mirror().addBox(3.0F, 1.0F, 12.0F, 10.0F, 19.0F, 0.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(11, 0).mirror().addBox(11.0F, 11.0F, 21.0F, 10.0F, 0.0F, 17.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(119, 98).addBox(9.0F, 8.0F, -38.0F, 10.0F, 0.0F, 17.0F, new CubeDeformation(0.0F))
		.texOffs(0, 0).addBox(3.0F, 1.0F, -12.0F, 10.0F, 19.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(-30.0F, -80.0F, 0.0F));

		PartDefinition SlotRightTopBack = BodyRightTop.addOrReplaceChild("SlotRightTopBack", CubeListBuilder.create().texOffs(136, 124).mirror().addBox(0.0F, 0.0F, -24.0F, 16.0F, 2.0F, 24.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(14.0F, 0.0F, 24.0F));

		PartDefinition SlotRightTopFront = BodyRightTop.addOrReplaceChild("SlotRightTopFront", CubeListBuilder.create().texOffs(136, 98).mirror().addBox(0.0F, 0.0F, 0.0F, 16.0F, 2.0F, 24.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(14.0F, 0.0F, -24.0F));

		PartDefinition SlotRightFront = BodyRightTop.addOrReplaceChild("SlotRightFront", CubeListBuilder.create().texOffs(216, 140).mirror().addBox(0.0F, 0.0F, 0.0F, 30.0F, 15.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 0.0F, -40.0F));

		PartDefinition SlotRightBack = BodyRightTop.addOrReplaceChild("SlotRightBack", CubeListBuilder.create().texOffs(0, 224).mirror().addBox(-15.0F, 0.0F, 0.0F, 30.0F, 24.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(15.0F, 0.0F, 38.0F));

		PartDefinition BodyRightFront = BodyRight.addOrReplaceChild("BodyRightFront", CubeListBuilder.create().texOffs(0, 150).mirror().addBox(0.0F, 0.25F, 0.0F, 30.0F, 16.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(35, 98).addBox(9.0F, 5.25F, 2.0F, 10.0F, 0.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(-30.0F, -48.25F, -40.0F));

		PartDefinition BodyRightFrotFont = BodyRightFront.addOrReplaceChild("BodyRightFrotFont", CubeListBuilder.create().texOffs(11, 0).mirror().addBox(9.0F, -2.5F, 2.0F, 10.0F, 0.0F, 17.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(64, 247).mirror().addBox(0.0F, -8.5F, 0.0F, 20.0F, 17.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, -8.25F, 0.0F));

		PartDefinition SlotRightBackBottom = BodyRight.addOrReplaceChild("SlotRightBackBottom", CubeListBuilder.create().texOffs(218, 224).mirror().addBox(-2.0F, -12.0F, -16.0F, 2.0F, 24.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-30.0F, -44.0F, 40.0F));

		PartDefinition SlotRightBackBottoparttwo = SlotRightBackBottom.addOrReplaceChild("SlotRightBackBottoparttwo", CubeListBuilder.create().texOffs(52, 176).mirror().addBox(0.0F, -12.0F, -24.0F, 2.0F, 24.0F, 24.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 48).mirror().addBox(2.0F, -5.0F, -14.0F, 20.0F, 0.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 0.0F, -16.0F));

		PartDefinition SlotRightBackTop = BodyRight.addOrReplaceChild("SlotRightBackTop", CubeListBuilder.create().texOffs(236, 34).mirror().addBox(-2.0F, -12.0F, -16.0F, 2.0F, 24.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-30.0F, -68.0F, 40.0F));

		PartDefinition SlotRightBackTopparttwo = SlotRightBackTop.addOrReplaceChild("SlotRightBackTopparttwo", CubeListBuilder.create().texOffs(104, 176).mirror().addBox(0.0F, -12.0F, -24.0F, 2.0F, 24.0F, 24.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 0.0F, -16.0F));

		PartDefinition SlotRightFrontLow2 = BodyRight.addOrReplaceChild("SlotRightFrontLow2", CubeListBuilder.create().texOffs(118, 224).mirror().addBox(-2.0F, -12.0F, 0.0F, 2.0F, 24.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-30.0F, -44.0F, -40.0F));

		PartDefinition SlotRightMiddleLow2 = SlotRightFrontLow2.addOrReplaceChild("SlotRightMiddleLow2", CubeListBuilder.create().texOffs(0, 176).mirror().addBox(0.0F, -12.0F, 0.0F, 2.0F, 24.0F, 24.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 48).mirror().addBox(2.0F, -5.0F, 4.0F, 20.0F, 0.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 0.0F, 16.0F));

		PartDefinition SlotRightFrontTop = BodyRight.addOrReplaceChild("SlotRightFrontTop", CubeListBuilder.create().texOffs(182, 219).mirror().addBox(-2.0F, -12.0F, 0.0F, 2.0F, 24.0F, 16.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-30.0F, -68.0F, -40.0F));

		PartDefinition SlotRightMiddleTop = SlotRightFrontTop.addOrReplaceChild("SlotRightMiddleTop", CubeListBuilder.create().texOffs(0, 0).mirror().addBox(0.0F, -12.0F, 0.0F, 2.0F, 24.0F, 24.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.0F, 0.0F, 16.0F));

		PartDefinition Eyelid = Body.addOrReplaceChild("Eyelid", CubeListBuilder.create(), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Top = Eyelid.addOrReplaceChild("Top", CubeListBuilder.create().texOffs(172, 50).addBox(-10.0F, -65.0F, -40.0F, 20.0F, 9.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Bottom = Eyelid.addOrReplaceChild("Bottom", CubeListBuilder.create().texOffs(236, 74).addBox(-10.0F, -56.0F, -40.0F, 20.0F, 8.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition Eye = Body.addOrReplaceChild("Eye", CubeListBuilder.create().texOffs(172, 16).addBox(-8.5F, -8.5F, -8.5F, 17.0F, 17.0F, 17.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -56.5F, -29.5F));

		PartDefinition LegFL = partdefinition.addOrReplaceChild("LegFL", CubeListBuilder.create(), PartPose.offset(19.4615F, 12.6781F, -16.6869F));

		PartDefinition KneeFL1 = LegFL.addOrReplaceChild("KneeFL1", CubeListBuilder.create().texOffs(64, 224).addBox(-8.0F, -5.0F, -5.5F, 16.0F, 12.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5385F, -20.6781F, -11.8131F));

		PartDefinition KneeFL2 = KneeFL1.addOrReplaceChild("KneeFL2", CubeListBuilder.create(), PartPose.offset(1.4167F, 3.0525F, 2.9248F));

		PartDefinition cube_r1 = KneeFL2.addOrReplaceChild("cube_r1", CubeListBuilder.create().texOffs(138, 208).addBox(-6.0F, -7.5F, -7.0F, 12.0F, 9.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(236, 246).mirror().addBox(-9.0F, -7.5F, -7.0F, 1.0F, 9.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(236, 246).addBox(8.0F, -7.5F, -7.0F, 1.0F, 9.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4167F, 3.4475F, 2.5752F, -0.3054F, 0.0F, 0.0F));

		PartDefinition KneeFl3 = KneeFL2.addOrReplaceChild("KneeFl3", CubeListBuilder.create().texOffs(238, 224).addBox(-6.0F, 5.185F, -2.5479F, 12.0F, 5.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(225, 87).addBox(-8.0F, -3.815F, -2.5479F, 16.0F, 9.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.4167F, 2.7625F, 11.1231F));

		PartDefinition bone2 = KneeFl3.addOrReplaceChild("bone2", CubeListBuilder.create().texOffs(0, 124).addBox(-4.0F, -7.0F, -1.5869F, 8.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.71F, 10.039F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cube_r2 = bone2.addOrReplaceChild("cube_r2", CubeListBuilder.create().texOffs(52, 124).addBox(0.0F, -7.0F, 0.0F, 6.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 0.0F, -1.5869F, 0.0F, -0.6109F, 0.0F));

		PartDefinition cube_r3 = bone2.addOrReplaceChild("cube_r3", CubeListBuilder.create().texOffs(136, 124).addBox(-6.0F, -7.0F, 0.0F, 6.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, -1.5869F, 0.0F, 0.6109F, 0.0F));

		PartDefinition FootFL = KneeFl3.addOrReplaceChild("FootFL", CubeListBuilder.create().texOffs(80, 176).addBox(-8.0F, 1.3806F, -7.6401F, 16.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(154, 246).addBox(-3.0F, -1.6194F, -9.6401F, 6.0F, 14.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(41, 10).addBox(4.0F, 11.3806F, -0.6401F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(41, 10).mirror().addBox(-8.0F, 11.3806F, -0.6401F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 124).addBox(-4.0F, -2.0944F, -13.6401F, 8.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(223, 16).addBox(-9.0F, 12.3806F, -16.6401F, 18.0F, 5.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(28, 176).addBox(-7.0F, 8.3806F, -10.6401F, 14.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.8044F, 2.0922F));

		PartDefinition cube_r4 = FootFL.addOrReplaceChild("cube_r4", CubeListBuilder.create().texOffs(52, 124).addBox(0.0F, -7.0F, 0.0F, 6.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 4.9056F, -13.6401F, 0.0F, -0.6109F, 0.0F));

		PartDefinition cube_r5 = FootFL.addOrReplaceChild("cube_r5", CubeListBuilder.create().texOffs(136, 124).addBox(-6.0F, -7.0F, 0.0F, 6.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 4.9056F, -13.6401F, 0.0F, 0.6109F, 0.0F));

		PartDefinition LegFR = partdefinition.addOrReplaceChild("LegFR", CubeListBuilder.create(), PartPose.offset(-19.4615F, 12.6781F, -16.6869F));

		PartDefinition KneeFR = LegFR.addOrReplaceChild("KneeFR", CubeListBuilder.create().texOffs(64, 224).mirror().addBox(-8.0F, -5.0F, -5.5F, 16.0F, 12.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5385F, -20.6781F, -11.8131F));

		PartDefinition KneeFR2 = KneeFR.addOrReplaceChild("KneeFR2", CubeListBuilder.create(), PartPose.offset(-1.4167F, 3.0525F, 2.9248F));

		PartDefinition cube_r6 = KneeFR2.addOrReplaceChild("cube_r6", CubeListBuilder.create().texOffs(138, 208).mirror().addBox(-6.0F, -7.5F, -7.0F, 12.0F, 9.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(236, 246).addBox(8.0F, -7.5F, -7.0F, 1.0F, 9.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(236, 246).mirror().addBox(-9.0F, -7.5F, -7.0F, 1.0F, 9.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.4167F, 3.4475F, 2.5752F, -0.3054F, 0.0F, 0.0F));

		PartDefinition KneeFR3 = KneeFR2.addOrReplaceChild("KneeFR3", CubeListBuilder.create().texOffs(238, 224).mirror().addBox(-6.0F, 5.185F, -2.5479F, 12.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(225, 87).mirror().addBox(-8.0F, -3.815F, -2.5479F, 16.0F, 9.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.4167F, 2.7625F, 11.1231F));

		PartDefinition bone3 = KneeFR3.addOrReplaceChild("bone3", CubeListBuilder.create().texOffs(0, 124).mirror().addBox(-4.0F, -7.0F, -1.5869F, 8.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 2.71F, 10.039F, 0.0F, -3.1416F, 0.0F));

		PartDefinition cube_r7 = bone3.addOrReplaceChild("cube_r7", CubeListBuilder.create().texOffs(52, 124).mirror().addBox(-6.0F, -7.0F, 0.0F, 6.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 0.0F, -1.5869F, 0.0F, 0.6109F, 0.0F));

		PartDefinition cube_r8 = bone3.addOrReplaceChild("cube_r8", CubeListBuilder.create().texOffs(136, 124).mirror().addBox(0.0F, -7.0F, 0.0F, 6.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 0.0F, -1.5869F, 0.0F, -0.6109F, 0.0F));

		PartDefinition FootFR = KneeFR3.addOrReplaceChild("FootFR", CubeListBuilder.create().texOffs(80, 176).mirror().addBox(-8.0F, 1.3806F, -7.6401F, 16.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(154, 246).mirror().addBox(-3.0F, -1.6194F, -9.6401F, 6.0F, 14.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(41, 10).mirror().addBox(-8.0F, 11.3806F, -0.6401F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(41, 10).addBox(4.0F, 11.3806F, -0.6401F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 124).mirror().addBox(-4.0F, -2.0944F, -13.6401F, 8.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(223, 16).mirror().addBox(-9.0F, 12.3806F, -16.6401F, 18.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(28, 176).mirror().addBox(-7.0F, 8.3806F, -10.6401F, 14.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 8.8044F, 2.0922F));

		PartDefinition cube_r9 = FootFR.addOrReplaceChild("cube_r9", CubeListBuilder.create().texOffs(52, 124).mirror().addBox(-6.0F, -7.0F, 0.0F, 6.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 4.9056F, -13.6401F, 0.0F, 0.6109F, 0.0F));

		PartDefinition cube_r10 = FootFR.addOrReplaceChild("cube_r10", CubeListBuilder.create().texOffs(136, 124).mirror().addBox(0.0F, -7.0F, 0.0F, 6.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 4.9056F, -13.6401F, 0.0F, -0.6109F, 0.0F));

		PartDefinition LegBL = partdefinition.addOrReplaceChild("LegBL", CubeListBuilder.create(), PartPose.offset(19.4615F, 12.6781F, 25.3131F));

		PartDefinition KneeBL = LegBL.addOrReplaceChild("KneeBL", CubeListBuilder.create().texOffs(64, 224).addBox(-8.0F, -5.0F, -5.5F, 16.0F, 12.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5385F, -20.6781F, -11.8131F));

		PartDefinition KneeBL2 = KneeBL.addOrReplaceChild("KneeBL2", CubeListBuilder.create(), PartPose.offset(1.4167F, 3.0525F, 2.9248F));

		PartDefinition cube_r11 = KneeBL2.addOrReplaceChild("cube_r11", CubeListBuilder.create().texOffs(138, 208).addBox(-6.0F, -7.5F, -7.0F, 12.0F, 9.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(236, 246).mirror().addBox(-9.0F, -7.5F, -7.0F, 1.0F, 9.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(236, 246).addBox(8.0F, -7.5F, -7.0F, 1.0F, 9.0F, 18.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-1.4167F, 3.4475F, 2.5752F, -0.3054F, 0.0F, 0.0F));

		PartDefinition KneeBl3 = KneeBL2.addOrReplaceChild("KneeBl3", CubeListBuilder.create().texOffs(238, 224).addBox(-6.0F, 5.185F, -2.5479F, 12.0F, 5.0F, 10.0F, new CubeDeformation(0.0F))
		.texOffs(225, 87).addBox(-8.0F, -3.815F, -2.5479F, 16.0F, 9.0F, 11.0F, new CubeDeformation(0.0F)), PartPose.offset(-1.4167F, 2.7625F, 11.1231F));

		PartDefinition bone4 = KneeBl3.addOrReplaceChild("bone4", CubeListBuilder.create().texOffs(0, 124).addBox(-4.0F, -7.0F, -1.5869F, 8.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(0.0F, 2.71F, 10.039F, 0.0F, 3.1416F, 0.0F));

		PartDefinition cube_r12 = bone4.addOrReplaceChild("cube_r12", CubeListBuilder.create().texOffs(52, 124).addBox(0.0F, -7.0F, 0.0F, 6.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 0.0F, -1.5869F, 0.0F, -0.6109F, 0.0F));

		PartDefinition cube_r13 = bone4.addOrReplaceChild("cube_r13", CubeListBuilder.create().texOffs(136, 124).addBox(-6.0F, -7.0F, 0.0F, 6.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 0.0F, -1.5869F, 0.0F, 0.6109F, 0.0F));

		PartDefinition FootBL = KneeBl3.addOrReplaceChild("FootBL", CubeListBuilder.create().texOffs(80, 176).addBox(-8.0F, 1.3806F, -7.6401F, 16.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(154, 246).addBox(-3.0F, -1.6194F, -9.6401F, 6.0F, 14.0F, 13.0F, new CubeDeformation(0.0F))
		.texOffs(41, 10).addBox(4.0F, 11.3806F, -0.6401F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(41, 10).mirror().addBox(-8.0F, 11.3806F, -0.6401F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(0, 124).addBox(-4.0F, -2.0944F, -13.6401F, 8.0F, 14.0F, 1.0F, new CubeDeformation(0.0F))
		.texOffs(223, 16).addBox(-9.0F, 12.3806F, -16.6401F, 18.0F, 5.0F, 11.0F, new CubeDeformation(0.0F))
		.texOffs(28, 176).addBox(-7.0F, 8.3806F, -10.6401F, 14.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 8.8044F, 2.0922F));

		PartDefinition cube_r14 = FootBL.addOrReplaceChild("cube_r14", CubeListBuilder.create().texOffs(52, 124).addBox(0.0F, -7.0F, 0.0F, 6.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(4.0F, 4.9056F, -13.6401F, 0.0F, -0.6109F, 0.0F));

		PartDefinition cube_r15 = FootBL.addOrReplaceChild("cube_r15", CubeListBuilder.create().texOffs(136, 124).addBox(-6.0F, -7.0F, 0.0F, 6.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-4.0F, 4.9056F, -13.6401F, 0.0F, 0.6109F, 0.0F));

		PartDefinition LegBR = partdefinition.addOrReplaceChild("LegBR", CubeListBuilder.create(), PartPose.offset(-19.4615F, 12.6781F, 25.3131F));

		PartDefinition KneeBR = LegBR.addOrReplaceChild("KneeBR", CubeListBuilder.create().texOffs(64, 224).mirror().addBox(-8.0F, -5.0F, -5.5F, 16.0F, 12.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(-2.5385F, -20.6781F, -11.8131F));

		PartDefinition KneeBR2 = KneeBR.addOrReplaceChild("KneeBR2", CubeListBuilder.create(), PartPose.offset(-1.4167F, 3.0525F, 2.9248F));

		PartDefinition cube_r16 = KneeBR2.addOrReplaceChild("cube_r16", CubeListBuilder.create().texOffs(138, 208).mirror().addBox(-6.0F, -7.5F, -7.0F, 12.0F, 9.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(236, 246).addBox(8.0F, -7.5F, -7.0F, 1.0F, 9.0F, 18.0F, new CubeDeformation(0.0F))
		.texOffs(236, 246).mirror().addBox(-9.0F, -7.5F, -7.0F, 1.0F, 9.0F, 18.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(1.4167F, 3.4475F, 2.5752F, -0.3054F, 0.0F, 0.0F));

		PartDefinition KneeBR3 = KneeBR2.addOrReplaceChild("KneeBR3", CubeListBuilder.create().texOffs(238, 224).mirror().addBox(-6.0F, 5.185F, -2.5479F, 12.0F, 5.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(225, 87).mirror().addBox(-8.0F, -3.815F, -2.5479F, 16.0F, 9.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(1.4167F, 2.7625F, 11.1231F));

		PartDefinition bone5 = KneeBR3.addOrReplaceChild("bone5", CubeListBuilder.create().texOffs(0, 124).mirror().addBox(-4.0F, -7.0F, -1.5869F, 8.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(0.0F, 2.71F, 10.039F, 0.0F, -3.1416F, 0.0F));

		PartDefinition cube_r17 = bone5.addOrReplaceChild("cube_r17", CubeListBuilder.create().texOffs(52, 124).mirror().addBox(-6.0F, -7.0F, 0.0F, 6.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 0.0F, -1.5869F, 0.0F, 0.6109F, 0.0F));

		PartDefinition cube_r18 = bone5.addOrReplaceChild("cube_r18", CubeListBuilder.create().texOffs(136, 124).mirror().addBox(0.0F, -7.0F, 0.0F, 6.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 0.0F, -1.5869F, 0.0F, -0.6109F, 0.0F));

		PartDefinition FootBR = KneeBR3.addOrReplaceChild("FootBR", CubeListBuilder.create().texOffs(80, 176).mirror().addBox(-8.0F, 1.3806F, -7.6401F, 16.0F, 8.0F, 8.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(154, 246).mirror().addBox(-3.0F, -1.6194F, -9.6401F, 6.0F, 14.0F, 13.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(41, 10).mirror().addBox(-8.0F, 11.3806F, -0.6401F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(41, 10).addBox(4.0F, 11.3806F, -0.6401F, 4.0F, 6.0F, 7.0F, new CubeDeformation(0.0F))
		.texOffs(0, 124).mirror().addBox(-4.0F, -2.0944F, -13.6401F, 8.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(223, 16).mirror().addBox(-9.0F, 12.3806F, -16.6401F, 18.0F, 5.0F, 11.0F, new CubeDeformation(0.0F)).mirror(false)
		.texOffs(28, 176).mirror().addBox(-7.0F, 8.3806F, -10.6401F, 14.0F, 7.0F, 10.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offset(0.0F, 8.8044F, 2.0922F));

		PartDefinition cube_r19 = FootBR.addOrReplaceChild("cube_r19", CubeListBuilder.create().texOffs(52, 124).mirror().addBox(-6.0F, -7.0F, 0.0F, 6.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-4.0F, 4.9056F, -13.6401F, 0.0F, 0.6109F, 0.0F));

		PartDefinition cube_r20 = FootBR.addOrReplaceChild("cube_r20", CubeListBuilder.create().texOffs(136, 124).mirror().addBox(0.0F, -7.0F, 0.0F, 6.0F, 14.0F, 1.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(4.0F, 4.9056F, -13.6401F, 0.0F, -0.6109F, 0.0F));

		return LayerDefinition.create(meshdefinition, 512, 512);
	}

	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		float f = Math.min((float)entity.getDeltaMovement().lengthSqr() * 200.0F, 8.0F);
		this.animate(entity.compactAnimationState, FortressWalkerAnimation.FORTRESS_WALKER_COMPACT, ageInTicks);
		this.animate(entity.wakeUpAnimationState, FortressWalkerAnimation.FORTRESS_WALKER_WAKEUP, ageInTicks);
		this.animate(entity.idleAnimationState, FortressWalkerAnimation.FORTRESS_WALKER_IDLE, ageInTicks);
		this.animate(entity.runAnimationState, FortressWalkerAnimation.FORTRESS_WALKER_RUNNING, ageInTicks, f);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		Body.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LegFL.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LegFR.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LegBL.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		LegBR.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart root() { return this.root; }
}