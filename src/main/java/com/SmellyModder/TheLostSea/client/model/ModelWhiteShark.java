package com.SmellyModder.TheLostSea.client.model;

import java.util.Random;

import org.lwjgl.opengl.GL11;

import com.SmellyModder.TheLostSea.client.model.animation.AnimatorHelper;
import com.SmellyModder.TheLostSea.common.entity.EntityAnglerfish;
import com.SmellyModder.TheLostSea.common.entity.passive.EntityShark;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;

/**
 * Shark - Bizarre
 * Created using Tabula 7.0.0
 */
public class ModelWhiteShark extends ModelBase {
    public ModelRenderer Chest;
    public ModelRenderer Neck;
    public ModelRenderer Tail1;
    public ModelRenderer UpperFlipper;
    public ModelRenderer Head;
    public ModelRenderer RightFlipper;
    public ModelRenderer LeftFlipper;
    public ModelRenderer LowerJaw;
    public ModelRenderer Nose1;
    public ModelRenderer UpperTeeth;
    public ModelRenderer LowerTeeth;
    public ModelRenderer Nose2;
    public ModelRenderer Tail2;
    public ModelRenderer TailFlipperLeft;
    public ModelRenderer TailFlipperRight;
    public ModelRenderer Tail3;
    public ModelRenderer TailFlipperBack;
    public ModelRenderer UpperFlipper_2;
    public ModelRenderer TailFlipperUpper;
    public ModelRenderer TailFlipperLower;
    AnimatorHelper animatorhelper = new AnimatorHelper();
    Random rand = new Random();

    public ModelWhiteShark() {
        this.textureWidth = 100;
        this.textureHeight = 100;
        this.Tail2 = new ModelRenderer(this, 57, 43);
        this.Tail2.setRotationPoint(0.0F, 0.0F, 9.0F);
        this.Tail2.addBox(-3.0F, -3.0F, 0.0F, 6, 6, 10, 0.0F);
        this.TailFlipperRight = new ModelRenderer(this, 1, 26);
        this.TailFlipperRight.mirror = true;
        this.TailFlipperRight.setRotationPoint(-3.0F, 3.0F, 4.0F);
        this.TailFlipperRight.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 2, 0.0F);
        this.setRotateAngle(TailFlipperRight, -1.0471975511965976F, 0.0F, 0.6373942428283291F);
        this.UpperFlipper_2 = new ModelRenderer(this, 37, 40);
        this.UpperFlipper_2.setRotationPoint(0.0F, -2.3F, 5.0F);
        this.UpperFlipper_2.addBox(-0.5F, 0.0F, 0.0F, 1, 3, 4, 0.0F);
        this.setRotateAngle(UpperFlipper_2, 0.9105382707654417F, 0.0F, 0.0F);
        this.TailFlipperLower = new ModelRenderer(this, 0, 0);
        this.TailFlipperLower.setRotationPoint(-0.5F, 1.0F, 7.0F);
        this.TailFlipperLower.addBox(0.0F, -4.0F, -1.0F, 1, 5, 11, 0.0F);
        this.setRotateAngle(TailFlipperLower, -0.9105382707654417F, 0.0F, 0.0F);
        this.TailFlipperBack = new ModelRenderer(this, 1, 21);
        this.TailFlipperBack.setRotationPoint(0.0F, 3.0F, 4.0F);
        this.TailFlipperBack.addBox(-0.5F, -1.0F, -1.0F, 1, 2, 2, 0.0F);
        this.setRotateAngle(TailFlipperBack, 0.8377580409572781F, 0.0F, 0.0F);
        this.LowerTeeth = new ModelRenderer(this, 0, 82);
        this.LowerTeeth.setRotationPoint(0.0F, 0.0F, -5.5F);
        this.LowerTeeth.addBox(-3.0F, -1.0F, 0.0F, 6, 1, 4, 0.0F);
        this.RightFlipper = new ModelRenderer(this, 32, 0);
        this.RightFlipper.mirror = true;
        this.RightFlipper.setRotationPoint(-4.0F, 4.0F, -2.0F);
        this.RightFlipper.addBox(-2.0F, -0.5F, 0.0F, 4, 1, 8, 0.0F);
        this.setRotateAngle(RightFlipper, -0.5009094953223726F, -1.5707963267948966F, 0.045553093477052F);
        this.UpperFlipper = new ModelRenderer(this, 37, 24);
        this.UpperFlipper.setRotationPoint(0.0F, -4.5F, 0.5F);
        this.UpperFlipper.addBox(-0.5F, 0.0F, 0.0F, 1, 6, 7, 0.0F);
        this.setRotateAngle(UpperFlipper, 0.9105382707654417F, 0.0F, 0.0F);
        this.LowerJaw = new ModelRenderer(this, 0, 71);
        this.LowerJaw.setRotationPoint(0.0F, 5.0F, 0.0F);
        this.LowerJaw.addBox(-3.5F, 0.0F, -6.0F, 7, 3, 7, 0.0F);
        this.setRotateAngle(LowerJaw, -0.31869712141416456F, 0.0F, 0.0F);
        this.Tail3 = new ModelRenderer(this, 60, 60);
        this.Tail3.setRotationPoint(0.0F, 0.0F, 9.0F);
        this.Tail3.addBox(-2.0F, -2.0F, 0.0F, 4, 4, 10, 0.0F);
        this.Head = new ModelRenderer(this, 0, 41);
        this.Head.setRotationPoint(0.0F, -4.0F, -8.0F);
        this.Head.addBox(-4.0F, 0.0F, -7.0F, 8, 5, 7, 0.0F);
        this.setRotateAngle(Head, 0.045553093477052F, 0.0F, 0.0F);
        this.Chest = new ModelRenderer(this, 44, 0);
        this.Chest.setRotationPoint(0.0F, 16.0F, -2.7F);
        this.Chest.addBox(-5.0F, -5.0F, 0.0F, 10, 10, 13, 0.0F);
        this.setRotateAngle(Chest, 0.0F, -0.0F, 0.005235987755982988F);
        this.Tail1 = new ModelRenderer(this, 54, 24);
        this.Tail1.setRotationPoint(0.0F, 0.0F, 12.0F);
        this.Tail1.addBox(-4.0F, -4.0F, 0.0F, 8, 8, 10, 0.0F);
        this.UpperTeeth = new ModelRenderer(this, 0, 88);
        this.UpperTeeth.setRotationPoint(0.0F, 5.0F, -5.5F);
        this.UpperTeeth.addBox(-3.0F, 0.0F, 0.0F, 6, 1, 4, 0.0F);
        this.Neck = new ModelRenderer(this, 0, 23);
        this.Neck.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.Neck.addBox(-4.5F, -4.5F, -8.0F, 9, 9, 8, 0.0F);
        this.Nose1 = new ModelRenderer(this, 0, 54);
        this.Nose1.setRotationPoint(0.0F, 0.0F, -7.0F);
        this.Nose1.addBox(-3.0F, 0.0F, -4.0F, 6, 3, 4, 0.0F);
        this.TailFlipperLeft = new ModelRenderer(this, 1, 26);
        this.TailFlipperLeft.setRotationPoint(3.0F, 3.0F, 4.0F);
        this.TailFlipperLeft.addBox(-0.5F, 0.0F, -0.5F, 1, 2, 2, 0.0F);
        this.setRotateAngle(TailFlipperLeft, -1.0471975511965976F, 0.0F, -0.6373942428283291F);
        this.LeftFlipper = new ModelRenderer(this, 32, 0);
        this.LeftFlipper.setRotationPoint(4.0F, 4.0F, -2.0F);
        this.LeftFlipper.addBox(-2.0F, -0.5F, 0.0F, 4, 1, 8, 0.0F);
        this.setRotateAngle(LeftFlipper, -0.5009094953223726F, -1.5707963267948966F, -2.1855012893472994F);
        this.TailFlipperUpper = new ModelRenderer(this, 0, 0);
        this.TailFlipperUpper.setRotationPoint(-0.5F, 0.0F, 10.0F);
        this.TailFlipperUpper.addBox(0.0F, -4.0F, -1.0F, 1, 5, 11, 0.0F);
        this.setRotateAngle(TailFlipperUpper, 0.9105382707654417F, 0.0F, 0.0F);
        this.Nose2 = new ModelRenderer(this, 0, 62);
        this.Nose2.setRotationPoint(0.0F, 4.7F, 0.0F);
        this.Nose2.addBox(-3.0F, -3.0F, -4.4F, 6, 3, 5, 0.0F);
        this.setRotateAngle(Nose2, -0.4143411644234538F, 0.0F, 0.0F);
        this.Tail1.addChild(this.Tail2);
        this.Tail1.addChild(this.TailFlipperRight);
        this.Tail2.addChild(this.UpperFlipper_2);
        this.Tail3.addChild(this.TailFlipperLower);
        this.Tail2.addChild(this.TailFlipperBack);
        this.LowerJaw.addChild(this.LowerTeeth);
        this.Neck.addChild(this.RightFlipper);
        this.Chest.addChild(this.UpperFlipper);
        this.Head.addChild(this.LowerJaw);
        this.Tail2.addChild(this.Tail3);
        this.Neck.addChild(this.Head);
        this.Chest.addChild(this.Tail1);
        this.Head.addChild(this.UpperTeeth);
        this.Chest.addChild(this.Neck);
        this.Head.addChild(this.Nose1);
        this.Tail1.addChild(this.TailFlipperLeft);
        this.Neck.addChild(this.LeftFlipper);
        this.Tail3.addChild(this.TailFlipperUpper);
        this.Nose1.addChild(this.Nose2);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	
    	EntityShark shark = (EntityShark) entity;
    	Chest.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn)
    {
    	EntityShark shark = (EntityShark) entityIn;
    	
        this.Neck.rotateAngleX = headPitch * 0.015453292F;
    }
    
    @Override
    public void setLivingAnimations(EntityLivingBase entity, float swing, float speed, float partialRenderTicks) {
    	EntityShark shark = (EntityShark) entity;

        float flap = MathHelper.sin((shark.ticksExisted + partialRenderTicks) * 0.5F) * 0.6F;
        int i = shark.getAttackTimer();
        if(shark.isInWater()) {
        	this.Tail1.rotateAngleY = MathHelper.sin(flap) * (float)Math.PI * 0.1F;
        	this.Tail2.rotateAngleY = MathHelper.sin(flap) * (float)Math.PI * 0.1F;
        	this.Tail3.rotateAngleY = MathHelper.sin(flap) * (float)Math.PI * 0.05F;
        }
        if(!shark.isInWater()) {
        	this.Tail1.rotateAngleY = MathHelper.sin(flap) * (float)Math.PI * 0.01F;
        	this.Tail2.rotateAngleY = MathHelper.sin(flap) * (float)Math.PI * 0.01F;
        	this.Tail3.rotateAngleY = MathHelper.sin(flap) * (float)Math.PI * 0.005F;
        }
        if(shark.isMoving()) {
        	this.Tail1.rotateAngleY = MathHelper.sin(flap) * (float)Math.PI * 0.2F;
        	this.Tail2.rotateAngleY = MathHelper.sin(flap) * (float)Math.PI * 0.2F;
        	this.Tail3.rotateAngleY = MathHelper.sin(flap) * (float)Math.PI * 0.1F;
        	
        	this.Chest.rotateAngleX = MathHelper.sin(flap) * (float)Math.PI * 0.065F;
        }
        if (i > 0)
        {
          this.LowerJaw.rotateAngleX = MathHelper.sin(flap) * (float)Math.PI * 0.33F;
        }else if(i < 0) {
        this.LowerJaw.rotateAngleX = -0.31869712141416456F;
    }
    }
    
    private float triangleWave(float p_78172_1_, float p_78172_2_) {
       return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / (p_78172_2_ * 0.25F);
    }
    
}
