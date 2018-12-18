package com.SmellyModder.TheLostSea.client.model.npc;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;

/**
 * ModelNpc - SmellyModder
 * Created using Tabula 7.0.0
 */

public class ModelLunete extends ModelBase {
    public ModelRenderer base;
    public ModelRenderer overlay;
    public ModelRenderer left_hand_o;
    public ModelRenderer right_hand_o;
    public ModelRenderer r_foot_o;
    public ModelRenderer l_foot_o;
    public ModelRenderer base_1;
    public ModelRenderer left_arm;
    public ModelRenderer right_leg;
    public ModelRenderer right_arm;
    public ModelRenderer boobies;
    public ModelRenderer left_leg;
    public ModelRenderer collar;
    public ModelRenderer head;
    public ModelRenderer left_hand;
    public ModelRenderer right_foot;
    public ModelRenderer right_arm_1;
    public ModelRenderer left_foot;
    public ModelRenderer hair_back;
    public ModelRenderer hair;
    public ModelRenderer hair3;
    public ModelRenderer hair3_1;
    public ModelRenderer hair2;

    public ModelLunete() {
        this.textureWidth = 128;
        this.textureHeight = 64;
        this.base = new ModelRenderer(this, 0, 28);
        this.base.setRotationPoint(0.0F, 6.0F, 0.0F);
        this.base.addBox(-4.0F, -6.0F, -2.0F, 8, 12, 4, 0.0F);
        this.left_hand_o = new ModelRenderer(this, 28, 54);
        this.left_hand_o.setRotationPoint(5.3F, 0.4F, 1.0F);
        this.left_hand_o.addBox(-1.5F, 0.0F, -3.0F, 3, 6, 4, 0.2F);
        this.setRotateAngle(left_hand_o, 0.0F, 0.0F, -0.0825540736193318F);
        this.r_foot_o = new ModelRenderer(this, 64, 41);
        this.r_foot_o.setRotationPoint(-2.0F, 17.8F, -2.0F);
        this.r_foot_o.addBox(-2.01F, 0.0F, 0.0F, 4, 6, 4, 0.2F);
        this.hair3 = new ModelRenderer(this, 8, 2);
        this.hair3.mirror = true;
        this.hair3.setRotationPoint(3.1F, -1.1F, -4.02F);
        this.hair3.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(hair3, 0.0F, 0.0F, 0.091106186954104F);
        this.hair3_1 = new ModelRenderer(this, 8, 2);
        this.hair3_1.mirror = true;
        this.hair3_1.setRotationPoint(-4.1F, -1.1F, -4.02F);
        this.hair3_1.addBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
        this.setRotateAngle(hair3_1, 0.0F, 0.0F, -0.091106186954104F);
        this.left_leg = new ModelRenderer(this, 48, 31);
        this.left_leg.setRotationPoint(2.0F, 5.0F, 0.0F);
        this.left_leg.addBox(-2.0F, 1.0F, -2.0F, 4, 6, 4, 0.0F);
        this.right_hand_o = new ModelRenderer(this, 28, 54);
        this.right_hand_o.mirror = true;
        this.right_hand_o.setRotationPoint(-5.3F, 0.4F, 1.0F);
        this.right_hand_o.addBox(-1.5F, 0.0F, -3.0F, 3, 6, 4, 0.2F);
        this.setRotateAngle(right_hand_o, 0.0F, 0.0F, 0.0825540736193318F);
        this.base_1 = new ModelRenderer(this, 76, 29);
        this.base_1.setRotationPoint(0.0F, 16.8F, 0.0F);
        this.base_1.addBox(-4.0F, -6.0F, -2.0F, 8, 7, 4, 0.3F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(0.0F, -5.9F, 0.0F);
        this.head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        this.hair = new ModelRenderer(this, 9, 4);
        this.hair.setRotationPoint(-2.1F, -8.5F, -1.7F);
        this.hair.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(hair, 0.0F, 0.0F, -0.36425021489121656F);
        this.right_leg = new ModelRenderer(this, 48, 31);
        this.right_leg.setRotationPoint(-2.0F, 5.0F, 0.0F);
        this.right_leg.addBox(-2.0F, 1.0F, -2.0F, 4, 6, 4, 0.0F);
        this.hair_back = new ModelRenderer(this, 25, 35);
        this.hair_back.setRotationPoint(-4.0F, -1.0F, 3.1F);
        this.hair_back.addBox(0.0F, 0.0F, 0.0F, 8, 2, 1, 0.0F);
        this.setRotateAngle(hair_back, 0.40980330836826856F, 0.0F, 0.0F);
        this.left_arm = new ModelRenderer(this, 14, 44);
        this.left_arm.setRotationPoint(4.0F, -3.5F, 0.0F);
        this.left_arm.addBox(0.0F, -2.0F, -2.0F, 3, 6, 4, 0.0F);
        this.setRotateAngle(left_arm, 0.0F, 0.0F, -0.0825540736193318F);
        this.right_arm_1 = new ModelRenderer(this, 14, 54);
        this.right_arm_1.setRotationPoint(-1.5F, 4.0F, 1.0F);
        this.right_arm_1.addBox(-1.51F, 0.0F, -3.0F, 3, 6, 4, 0.0F);
        this.setRotateAngle(right_arm_1, -0.12740903539558604F, 0.0F, 0.0F);
        this.overlay = new ModelRenderer(this, 32, 0);
        this.overlay.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.overlay.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F);
        this.left_foot = new ModelRenderer(this, 48, 41);
        this.left_foot.setRotationPoint(0.0F, 7.0F, -2.0F);
        this.left_foot.addBox(-1.99F, 0.0F, 0.0F, 4, 6, 4, 0.0F);
        this.right_foot = new ModelRenderer(this, 48, 41);
        this.right_foot.setRotationPoint(0.0F, 7.0F, -2.0F);
        this.right_foot.addBox(-2.01F, 0.0F, 0.0F, 4, 6, 4, 0.0F);
        this.boobies = new ModelRenderer(this, 60, 17);
        this.boobies.setRotationPoint(0.0F, -4.0F, -2.0F);
        this.boobies.addBox(-4.0F, 0.0F, 0.0F, 8, 4, 2, 0.0F);
        this.setRotateAngle(boobies, -0.2617993877991494F, 0.0F, 0.0F);
        this.left_hand = new ModelRenderer(this, 14, 54);
        this.left_hand.mirror = true;
        this.left_hand.setRotationPoint(1.5F, 4.0F, 1.0F);
        this.left_hand.addBox(-1.5F, 0.0F, -3.0F, 3, 6, 4, 0.0F);
        this.setRotateAngle(left_hand, -0.136659280431156F, 0.0F, 0.0F);
        this.hair2 = new ModelRenderer(this, 9, 0);
        this.hair2.setRotationPoint(0.0F, 0.5F, 0.0F);
        this.hair2.addBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
        this.setRotateAngle(hair2, 0.0F, 0.0F, -1.6390387005478748F);
        this.right_arm = new ModelRenderer(this, 14, 44);
        this.right_arm.setRotationPoint(-4.0F, -3.5F, 0.0F);
        this.right_arm.addBox(-3.0F, -2.0F, -2.0F, 3, 6, 4, 0.0F);
        this.setRotateAngle(right_arm, 0.0F, 0.0F, 0.0825540736193318F);
        this.l_foot_o = new ModelRenderer(this, 64, 41);
        this.l_foot_o.mirror = true;
        this.l_foot_o.setRotationPoint(2.0F, 17.8F, -2.0F);
        this.l_foot_o.addBox(-2.01F, 0.0F, 0.0F, 4, 6, 4, 0.2F);
        this.collar = new ModelRenderer(this, 0, 20);
        this.collar.setRotationPoint(0.0F, -4.3F, 1.7F);
        this.collar.addBox(-3.0F, -2.0F, -4.0F, 6, 2, 5, 0.0F);
        this.setRotateAngle(collar, 0.08726646259971647F, 0.0F, 0.0F);
        this.head.addChild(this.hair3);
        this.head.addChild(this.hair3_1);
        this.base.addChild(this.left_leg);
        this.base.addChild(this.head);
        this.head.addChild(this.hair);
        this.base.addChild(this.right_leg);
        this.head.addChild(this.hair_back);
        this.base.addChild(this.left_arm);
        this.right_arm.addChild(this.right_arm_1);
        this.left_leg.addChild(this.left_foot);
        this.right_leg.addChild(this.right_foot);
        this.base.addChild(this.boobies);
        this.left_arm.addChild(this.left_hand);
        this.hair.addChild(this.hair2);
        this.base.addChild(this.right_arm);
        this.base.addChild(this.collar);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.base.render(f5);
        this.left_hand_o.render(f5);
        this.r_foot_o.render(f5);
        this.right_hand_o.render(f5);
        this.base_1.render(f5);
        this.overlay.render(f5);
        this.l_foot_o.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
    	this.head.rotateAngleX = headPitch * 0.017453292F;
    	this.head.rotateAngleY = netHeadYaw * 0.017453292F;
    	this.overlay.rotateAngleX = headPitch * 0.017453292F;
    	this.overlay.rotateAngleY = netHeadYaw * 0.017453292F;
    	
    	this.right_arm.rotateAngleZ = 0.0F;
        this.left_arm.rotateAngleZ = 0.0F;
    	this.right_arm.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.left_arm.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        
        this.right_hand_o.rotateAngleZ = 0.0F;
        this.left_hand_o.rotateAngleZ = 0.0F;
    	this.right_hand_o.rotateAngleZ += MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
        this.left_hand_o.rotateAngleZ -= MathHelper.cos(ageInTicks * 0.09F) * 0.05F + 0.05F;
    }
}
