package com.SmellyModder.TheLostSea.client.model;

import com.SmellyModder.TheLostSea.common.entity.EntityTriGuardian;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.monster.EntityGuardian;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

/**
 * 
 * @author SmellyModder
 *
 */
public class ModelTriGuardian extends ModelBase {
    public ModelRenderer HEAD_MIDDLE;
    public ModelRenderer SPINE;
    public ModelRenderer SPINE_1;
    public ModelRenderer SPINE_2;
    public ModelRenderer SPINE_3;
    public ModelRenderer SPINE_4;
    public ModelRenderer SPINE_5;
    public ModelRenderer SPINE_6;
    public ModelRenderer SPINE_7;
    public ModelRenderer SPINE_8;
    public ModelRenderer SPINE_9;
    public ModelRenderer SPINE_10;
    public ModelRenderer SPINE_11;
    public ModelRenderer MID_RIGHT;
    public ModelRenderer MID_BOTTOM;
    public ModelRenderer MID_TOP;
    public ModelRenderer MID_LEFT;
    public ModelRenderer MAIN_EYE;
    public ModelRenderer HEAD_RIGHT;
    public ModelRenderer HEAD_LEFT;
    public ModelRenderer MIDDLE_TAIL;
    public ModelRenderer SPINE_12;
    public ModelRenderer SPINE_13;
    public ModelRenderer SPINE_14;
    public ModelRenderer SPINE_15;
    public ModelRenderer SPINE_16;
    public ModelRenderer SPINE_17;
    public ModelRenderer SPINE_18;
    public ModelRenderer SPINE_19;
    public ModelRenderer SPINE_20;
    public ModelRenderer SPINE_21;
    public ModelRenderer SPINE_22;
    public ModelRenderer SPINE_23;
    public ModelRenderer RIGHT_RIGHT;
    public ModelRenderer RIGHT_BOTTOM;
    public ModelRenderer RIGHT_TOP;
    public ModelRenderer RIGHT_LEFT;
    public ModelRenderer MAIN_EYE_1;
    public ModelRenderer RIGHT_TAIL;
    public ModelRenderer RIGHT_TAIL_CHILD;
    public ModelRenderer RIGHT_TAIL_CHILDB;
    public ModelRenderer RIGHT_FIN;
    public ModelRenderer SPINE_24;
    public ModelRenderer SPINE_25;
    public ModelRenderer SPINE_26;
    public ModelRenderer SPINE_27;
    public ModelRenderer SPINE_28;
    public ModelRenderer SPINE_29;
    public ModelRenderer SPINE_30;
    public ModelRenderer SPINE_31;
    public ModelRenderer SPINE_32;
    public ModelRenderer SPINE_33;
    public ModelRenderer SPINE_34;
    public ModelRenderer SPINE_35;
    public ModelRenderer LEFT_RIGHT;
    public ModelRenderer LEFT_BOTTOM;
    public ModelRenderer LEFT_TOP;
    public ModelRenderer LEFT_LEFT;
    public ModelRenderer MAIN_EYE_2;
    public ModelRenderer LEFT_TAIL;
    public ModelRenderer LEFT_TAIL_CHILD;
    public ModelRenderer LEFT_TAIL_CHILDB;
    public ModelRenderer LEFT_FIN;
    public ModelRenderer MIDDLE_TAIL_CHILD;
    public ModelRenderer MIDDLE_TAIL_CHILDB;
    public ModelRenderer MIDDLE_FIN;
    
    public ModelTriGuardian() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.SPINE_1 = new ModelRenderer(this, 0, 0);
        this.SPINE_1.setRotationPoint(0.0F, 12.36F, -3.64F);
        this.SPINE_1.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(SPINE_1, 0.7853981633974483F, 0.0F, 0.0F);
        this.SPINE_15 = new ModelRenderer(this, 0, 0);
        this.SPINE_15.setRotationPoint(-3.52F, 12.48F, 0.0F);
        this.SPINE_15.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(SPINE_15, 0.0F, 0.0F, 5.497787143782138F);
        this.LEFT_RIGHT = new ModelRenderer(this, 0, 28);
        this.LEFT_RIGHT.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.LEFT_RIGHT.addBox(-8.0F, 10.0F, -6.0F, 2, 12, 12, 0.0F);
        this.SPINE_20 = new ModelRenderer(this, 0, 0);
        this.SPINE_20.setRotationPoint(0.0F, 19.59F, 3.59F);
        this.SPINE_20.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(SPINE_20, 3.9269908169872414F, 0.0F, 0.0F);
        this.LEFT_TAIL_CHILDB = new ModelRenderer(this, 25, 19);
        this.LEFT_TAIL_CHILDB.setRotationPoint(-0.5F, 0.5F, 6.0F);
        this.LEFT_TAIL_CHILDB.addBox(-1.0F, 14.0F, -0.5F, 2, 2, 6, 0.0F);
        this.RIGHT_TOP = new ModelRenderer(this, 16, 40);
        this.RIGHT_TOP.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.RIGHT_TOP.addBox(-6.0F, 8.0F, -6.0F, 12, 2, 12, 0.0F);
        this.SPINE_22 = new ModelRenderer(this, 0, 0);
        this.SPINE_22.setRotationPoint(3.53F, 19.53F, 0.0F);
        this.SPINE_22.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(SPINE_22, 0.0F, 0.0F, 2.356194490192345F);
        this.SPINE_24 = new ModelRenderer(this, 0, 0);
        this.SPINE_24.setRotationPoint(0.0F, 12.32F, 3.68F);
        this.SPINE_24.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(SPINE_24, 5.497787143782138F, 0.0F, 0.0F);
        this.MIDDLE_FIN = new ModelRenderer(this, 25, 19);
        this.MIDDLE_FIN.setRotationPoint(-1.0F, 0.2F, 3.5F);
        this.MIDDLE_FIN.addBox(1.0F, 10.5F, -1.0F, 1, 9, 9, 0.0F);
        this.MID_TOP = new ModelRenderer(this, 16, 40);
        this.MID_TOP.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.MID_TOP.addBox(-6.0F, 8.0F, -6.0F, 12, 2, 12, 0.0F);
        this.SPINE_8 = new ModelRenderer(this, 0, 0);
        this.SPINE_8.setRotationPoint(0.0F, 19.59F, 3.59F);
        this.SPINE_8.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(SPINE_8, 3.9269908169872414F, 0.0F, 0.0F);
        this.SPINE_25 = new ModelRenderer(this, 0, 0);
        this.SPINE_25.setRotationPoint(0.0F, 12.36F, -3.64F);
        this.SPINE_25.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(SPINE_25, 0.7853981633974483F, 0.0F, 0.0F);
        this.SPINE_10 = new ModelRenderer(this, 0, 0);
        this.SPINE_10.setRotationPoint(3.53F, 19.53F, 0.0F);
        this.SPINE_10.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(SPINE_10, 0.0F, 0.0F, 2.356194490192345F);
        this.SPINE_16 = new ModelRenderer(this, 0, 0);
        this.SPINE_16.setRotationPoint(-3.55F, 16.0F, -3.55F);
        this.SPINE_16.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(SPINE_16, 1.5707963267948966F, 0.7853981633974483F, 0.0F);
        this.RIGHT_FIN = new ModelRenderer(this, 25, 19);
        this.RIGHT_FIN.setRotationPoint(-1.0F, 0.2F, 3.5F);
        this.RIGHT_FIN.addBox(1.0F, 10.5F, -1.0F, 1, 9, 9, 0.0F);
        this.SPINE_29 = new ModelRenderer(this, 0, 0);
        this.SPINE_29.setRotationPoint(3.62F, 16.0F, -3.62F);
        this.SPINE_29.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(SPINE_29, 1.5707963267948966F, 5.497787143782138F, 0.0F);
        this.SPINE_13 = new ModelRenderer(this, 0, 0);
        this.SPINE_13.setRotationPoint(0.0F, 12.36F, -3.64F);
        this.SPINE_13.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(SPINE_13, 0.7853981633974483F, 0.0F, 0.0F);
        this.RIGHT_LEFT = new ModelRenderer(this, 0, 28);
        this.RIGHT_LEFT.mirror = true;
        this.RIGHT_LEFT.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.RIGHT_LEFT.addBox(6.0F, 10.0F, -6.0F, 2, 12, 12, 0.0F);
        this.SPINE_35 = new ModelRenderer(this, 0, 0);
        this.SPINE_35.setRotationPoint(-3.6F, 19.6F, 0.0F);
        this.SPINE_35.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(SPINE_35, 0.0F, 0.0F, 3.9269908169872414F);
        this.RIGHT_BOTTOM = new ModelRenderer(this, 16, 40);
        this.RIGHT_BOTTOM.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.RIGHT_BOTTOM.addBox(-6.0F, 22.0F, -6.0F, 12, 2, 12, 0.0F);
        this.MAIN_EYE_1 = new ModelRenderer(this, 8, 0);
        this.MAIN_EYE_1.setRotationPoint(0.0F, 0.0F, -8.5F);
        this.MAIN_EYE_1.addBox(-1.0F, 15.0F, 0.0F, 2, 2, 1, 0.0F);
        
        this.MAIN_EYE = new ModelRenderer(this, 8, 0);
        this.MAIN_EYE.setRotationPoint(0.0F, 0F, -8.5F);
        this.MAIN_EYE.addBox(-1.0F, 15.0F, 0.0F, 2, 2, 1, 0.0F);
        this.SPINE_30 = new ModelRenderer(this, 0, 0);
        this.SPINE_30.setRotationPoint(3.68F, 16.0F, 3.68F);
        this.SPINE_30.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(SPINE_30, 1.5707963267948966F, 3.9269908169872414F, 0.0F);
        this.SPINE_17 = new ModelRenderer(this, 0, 0);
        this.SPINE_17.setRotationPoint(3.62F, 16.0F, -3.62F);
        this.SPINE_17.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(SPINE_17, 1.5707963267948966F, 5.497787143782138F, 0.0F);
        this.SPINE_33 = new ModelRenderer(this, 0, 0);
        this.SPINE_33.setRotationPoint(0.0F, 19.53F, -3.53F);
        this.SPINE_33.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(SPINE_33, 2.356194490192345F, 0.0F, 0.0F);
        this.SPINE_3 = new ModelRenderer(this, 0, 0);
        this.SPINE_3.setRotationPoint(-3.52F, 12.48F, 0.0F);
        this.SPINE_3.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(SPINE_3, 0.0F, 0.0F, 5.497787143782138F);
        this.SPINE_6 = new ModelRenderer(this, 0, 0);
        this.SPINE_6.setRotationPoint(3.68F, 16.0F, 3.68F);
        this.SPINE_6.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(SPINE_6, 1.5707963267948966F, 3.9269908169872414F, 0.0F);
        this.SPINE_4 = new ModelRenderer(this, 0, 0);
        this.SPINE_4.setRotationPoint(-3.55F, 16.0F, -3.55F);
        this.SPINE_4.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(SPINE_4, 1.5707963267948966F, 0.7853981633974483F, 0.0F);
        this.SPINE_7 = new ModelRenderer(this, 0, 0);
        this.SPINE_7.setRotationPoint(-3.66F, 16.0F, 3.66F);
        this.SPINE_7.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(SPINE_7, 1.5707963267948966F, 2.356194490192345F, 0.0F);
        this.SPINE_28 = new ModelRenderer(this, 0, 0);
        this.SPINE_28.setRotationPoint(-3.55F, 16.0F, -3.55F);
        this.SPINE_28.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(SPINE_28, 1.5707963267948966F, 0.7853981633974483F, 0.0F);
        this.SPINE_11 = new ModelRenderer(this, 0, 0);
        this.SPINE_11.setRotationPoint(-3.6F, 19.6F, 0.0F);
        this.SPINE_11.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(SPINE_11, 0.0F, 0.0F, 3.9269908169872414F);
        this.RIGHT_TAIL_CHILDB = new ModelRenderer(this, 25, 19);
        this.RIGHT_TAIL_CHILDB.setRotationPoint(-0.5F, 0.5F, 6.0F);
        this.RIGHT_TAIL_CHILDB.addBox(-1.0F, 14.0F, -0.5F, 2, 2, 6, 0.0F);
        this.LEFT_TOP = new ModelRenderer(this, 16, 40);
        this.LEFT_TOP.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.LEFT_TOP.addBox(-6.0F, 8.0F, -6.0F, 12, 2, 12, 0.0F);
        this.SPINE_19 = new ModelRenderer(this, 0, 0);
        this.SPINE_19.setRotationPoint(-3.66F, 16.0F, 3.66F);
        this.SPINE_19.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(SPINE_19, 1.5707963267948966F, 2.356194490192345F, 0.0F);
        this.MIDDLE_TAIL_CHILDB = new ModelRenderer(this, 25, 19);
        this.MIDDLE_TAIL_CHILDB.setRotationPoint(-0.5F, 0.5F, 6.0F);
        this.MIDDLE_TAIL_CHILDB.addBox(-1.0F, 14.0F, -0.5F, 2, 2, 6, 0.0F);
        this.HEAD_RIGHT = new ModelRenderer(this, 0, 0);
        this.HEAD_RIGHT.setRotationPoint(-15.0F, 0.0F, 0.0F);
        this.HEAD_RIGHT.addBox(-6.0F, 10.0F, -8.0F, 12, 12, 16, 0.0F);
        this.setRotateAngle(HEAD_RIGHT, 0.0F, 0.22689280275926282F, 0.0F);
        this.LEFT_TAIL = new ModelRenderer(this, 40, 0);
        this.LEFT_TAIL.mirror = true;
        this.LEFT_TAIL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.LEFT_TAIL.addBox(-2.0F, 14.0F, 7.0F, 4, 4, 8, 0.0F);
        this.HEAD_LEFT = new ModelRenderer(this, 0, 0);
        this.HEAD_LEFT.mirror = true;
        this.HEAD_LEFT.setRotationPoint(15.0F, 0.0F, 0.0F);
        this.HEAD_LEFT.addBox(-6.0F, 10.0F, -8.0F, 12, 12, 16, 0.0F);
        this.setRotateAngle(HEAD_LEFT, 0.0F, -0.22689280275926282F, 0.0F);
        this.SPINE_32 = new ModelRenderer(this, 0, 0);
        this.SPINE_32.setRotationPoint(0.0F, 19.59F, 3.59F);
        this.SPINE_32.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(SPINE_32, 3.9269908169872414F, 0.0F, 0.0F);
        this.SPINE = new ModelRenderer(this, 0, 0);
        this.SPINE.setRotationPoint(0.0F, 12.32F, 3.68F);
        this.SPINE.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(SPINE, 5.497787143782138F, 0.0F, 0.0F);
        this.RIGHT_TAIL = new ModelRenderer(this, 40, 0);
        this.RIGHT_TAIL.mirror = true;
        this.RIGHT_TAIL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.RIGHT_TAIL.addBox(-2.0F, 14.0F, 7.0F, 4, 4, 8, 0.0F);
        this.MID_LEFT = new ModelRenderer(this, 0, 28);
        this.MID_LEFT.mirror = true;
        this.MID_LEFT.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.MID_LEFT.addBox(6.0F, 10.0F, -6.0F, 2, 12, 12, 0.0F);
        this.MID_BOTTOM = new ModelRenderer(this, 16, 40);
        this.MID_BOTTOM.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.MID_BOTTOM.addBox(-6.0F, 22.0F, -6.0F, 12, 2, 12, 0.0F);
        this.LEFT_LEFT = new ModelRenderer(this, 0, 28);
        this.LEFT_LEFT.mirror = true;
        this.LEFT_LEFT.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.LEFT_LEFT.addBox(6.0F, 10.0F, -6.0F, 2, 12, 12, 0.0F);
        this.SPINE_31 = new ModelRenderer(this, 0, 0);
        this.SPINE_31.setRotationPoint(-3.66F, 16.0F, 3.66F);
        this.SPINE_31.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(SPINE_31, 1.5707963267948966F, 2.356194490192345F, 0.0F);
        this.SPINE_12 = new ModelRenderer(this, 0, 0);
        this.SPINE_12.setRotationPoint(0.0F, 12.32F, 3.68F);
        this.SPINE_12.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(SPINE_12, 5.497787143782138F, 0.0F, 0.0F);
        this.SPINE_26 = new ModelRenderer(this, 0, 0);
        this.SPINE_26.setRotationPoint(3.57F, 12.43F, 0.0F);
        this.SPINE_26.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(SPINE_26, 0.0F, 0.0F, 0.7853981633974483F);
        this.HEAD_MIDDLE = new ModelRenderer(this, 0, 0);
        this.HEAD_MIDDLE.setRotationPoint(0.0F, -2.0F, 0.0F);
        this.HEAD_MIDDLE.addBox(-6.0F, 10.0F, -8.0F, 12, 12, 16, 0.0F);
        this.RIGHT_TAIL_CHILD = new ModelRenderer(this, 0, 54);
        this.RIGHT_TAIL_CHILD.setRotationPoint(0.5F, 0.5F, 14.2F);
        this.RIGHT_TAIL_CHILD.addBox(-2.0F, 14.0F, 0.0F, 3, 3, 7, 0.0F);
        this.LEFT_TAIL_CHILD = new ModelRenderer(this, 0, 54);
        this.LEFT_TAIL_CHILD.setRotationPoint(0.5F, 0.5F, 14.2F);
        this.LEFT_TAIL_CHILD.addBox(-2.0F, 14.0F, 0.0F, 3, 3, 7, 0.0F);
        this.SPINE_27 = new ModelRenderer(this, 0, 0);
        this.SPINE_27.setRotationPoint(-3.52F, 12.48F, 0.0F);
        this.SPINE_27.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(SPINE_27, 0.0F, 0.0F, 5.497787143782138F);
        this.SPINE_2 = new ModelRenderer(this, 0, 0);
        this.SPINE_2.setRotationPoint(3.57F, 12.43F, 0.0F);
        this.SPINE_2.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(SPINE_2, 0.0F, 0.0F, 0.7853981633974483F);
        this.SPINE_18 = new ModelRenderer(this, 0, 0);
        this.SPINE_18.setRotationPoint(3.68F, 16.0F, 3.68F);
        this.SPINE_18.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(SPINE_18, 1.5707963267948966F, 3.9269908169872414F, 0.0F);
        this.MID_RIGHT = new ModelRenderer(this, 0, 28);
        this.MID_RIGHT.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.MID_RIGHT.addBox(-8.0F, 10.0F, -6.0F, 2, 12, 12, 0.0F);
        this.RIGHT_RIGHT = new ModelRenderer(this, 0, 28);
        this.RIGHT_RIGHT.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.RIGHT_RIGHT.addBox(-8.0F, 10.0F, -6.0F, 2, 12, 12, 0.0F);
        this.LEFT_FIN = new ModelRenderer(this, 25, 19);
        this.LEFT_FIN.setRotationPoint(-1.0F, 0.2F, 3.5F);
        this.LEFT_FIN.addBox(1.0F, 10.5F, -1.0F, 1, 9, 9, 0.0F);
        
        this.SPINE_14 = new ModelRenderer(this, 0, 0);
        this.SPINE_14.setRotationPoint(3.57F, 12.43F, 0.0F);
        this.SPINE_14.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(SPINE_14, 0.0F, 0.0F, 0.7853981633974483F);
        this.SPINE_23 = new ModelRenderer(this, 0, 0);
        this.SPINE_23.setRotationPoint(-3.6F, 19.6F, 0.0F);
        this.SPINE_23.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(SPINE_23, 0.0F, 0.0F, 3.9269908169872414F);
        this.MAIN_EYE_2 = new ModelRenderer(this, 8, 0);
        this.MAIN_EYE_2.setRotationPoint(0.0F, 0.0F, -8.5F);
        this.MAIN_EYE_2.addBox(-1.0F, 15.0F, 0.0F, 2, 2, 1, 0.0F);
        this.MIDDLE_TAIL_CHILD = new ModelRenderer(this, 0, 54);
        this.MIDDLE_TAIL_CHILD.setRotationPoint(0.5F, 0.5F, 14.2F);
        this.MIDDLE_TAIL_CHILD.addBox(-2.0F, 14.0F, 0.0F, 3, 3, 7, 0.0F);
        this.MIDDLE_TAIL = new ModelRenderer(this, 40, 0);
        this.MIDDLE_TAIL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.MIDDLE_TAIL.addBox(-2.0F, 14.0F, 7.0F, 4, 4, 8, 0.0F);
        this.SPINE_9 = new ModelRenderer(this, 0, 0);
        this.SPINE_9.setRotationPoint(0.0F, 19.53F, -3.53F);
        this.SPINE_9.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(SPINE_9, 2.356194490192345F, 0.0F, 0.0F);
        this.SPINE_21 = new ModelRenderer(this, 0, 0);
        this.SPINE_21.setRotationPoint(0.0F, 19.53F, -3.53F);
        this.SPINE_21.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(SPINE_21, 2.356194490192345F, 0.0F, 0.0F);
        this.SPINE_5 = new ModelRenderer(this, 0, 0);
        this.SPINE_5.setRotationPoint(3.62F, 16.0F, -3.62F);
        this.SPINE_5.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(SPINE_5, 1.5707963267948966F, 5.497787143782138F, 0.0F);
        this.LEFT_BOTTOM = new ModelRenderer(this, 16, 40);
        this.LEFT_BOTTOM.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.LEFT_BOTTOM.addBox(-6.0F, 22.0F, -6.0F, 12, 2, 12, 0.0F);
        this.SPINE_34 = new ModelRenderer(this, 0, 0);
        this.SPINE_34.setRotationPoint(3.53F, 19.53F, 0.0F);
        this.SPINE_34.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(SPINE_34, 0.0F, 0.0F, 2.356194490192345F);
        this.HEAD_MIDDLE.addChild(this.SPINE_1);
        this.HEAD_RIGHT.addChild(this.SPINE_15);
        this.HEAD_LEFT.addChild(this.LEFT_RIGHT);
        this.HEAD_RIGHT.addChild(this.SPINE_20);
        this.LEFT_TAIL_CHILD.addChild(this.LEFT_TAIL_CHILDB);
        this.HEAD_RIGHT.addChild(this.RIGHT_TOP);
        this.HEAD_RIGHT.addChild(this.SPINE_22);
        this.HEAD_LEFT.addChild(this.SPINE_24);
        this.MIDDLE_TAIL_CHILDB.addChild(this.MIDDLE_FIN);
        this.HEAD_MIDDLE.addChild(this.MID_TOP);
        this.HEAD_MIDDLE.addChild(this.SPINE_8);
        this.HEAD_LEFT.addChild(this.SPINE_25);
        this.HEAD_MIDDLE.addChild(this.SPINE_10);
        this.HEAD_RIGHT.addChild(this.SPINE_16);
        this.RIGHT_TAIL_CHILDB.addChild(this.RIGHT_FIN);
        this.HEAD_LEFT.addChild(this.SPINE_29);
        this.HEAD_RIGHT.addChild(this.SPINE_13);
        this.HEAD_RIGHT.addChild(this.RIGHT_LEFT);
        this.HEAD_LEFT.addChild(this.SPINE_35);
        this.HEAD_RIGHT.addChild(this.RIGHT_BOTTOM);
        this.HEAD_RIGHT.addChild(this.MAIN_EYE_1);
        this.HEAD_LEFT.addChild(this.SPINE_30);
        this.HEAD_RIGHT.addChild(this.SPINE_17);
        this.HEAD_LEFT.addChild(this.SPINE_33);
        this.HEAD_MIDDLE.addChild(this.SPINE_3);
        this.HEAD_MIDDLE.addChild(this.SPINE_6);
        this.HEAD_MIDDLE.addChild(this.SPINE_4);
        this.HEAD_MIDDLE.addChild(this.SPINE_7);
        this.HEAD_LEFT.addChild(this.SPINE_28);
        this.HEAD_MIDDLE.addChild(this.SPINE_11);
        this.RIGHT_TAIL_CHILD.addChild(this.RIGHT_TAIL_CHILDB);
        this.HEAD_LEFT.addChild(this.LEFT_TOP);
        this.HEAD_RIGHT.addChild(this.SPINE_19);
        this.MIDDLE_TAIL_CHILD.addChild(this.MIDDLE_TAIL_CHILDB);
        this.HEAD_MIDDLE.addChild(this.HEAD_RIGHT);
        this.HEAD_LEFT.addChild(this.LEFT_TAIL);
        this.HEAD_MIDDLE.addChild(this.HEAD_LEFT);
        this.HEAD_LEFT.addChild(this.SPINE_32);
        this.HEAD_MIDDLE.addChild(this.SPINE);
        this.HEAD_RIGHT.addChild(this.RIGHT_TAIL);
        this.HEAD_MIDDLE.addChild(this.MID_LEFT);
        this.HEAD_MIDDLE.addChild(this.MID_BOTTOM);
        this.HEAD_LEFT.addChild(this.LEFT_LEFT);
        this.HEAD_LEFT.addChild(this.SPINE_31);
        this.HEAD_RIGHT.addChild(this.SPINE_12);
        this.HEAD_LEFT.addChild(this.SPINE_26);
        this.RIGHT_TAIL.addChild(this.RIGHT_TAIL_CHILD);
        this.LEFT_TAIL.addChild(this.LEFT_TAIL_CHILD);
        this.HEAD_LEFT.addChild(this.SPINE_27);
        this.HEAD_MIDDLE.addChild(this.SPINE_2);
        this.HEAD_RIGHT.addChild(this.SPINE_18);
        this.HEAD_MIDDLE.addChild(this.MID_RIGHT);
        this.HEAD_RIGHT.addChild(this.RIGHT_RIGHT);
        this.LEFT_TAIL_CHILDB.addChild(this.LEFT_FIN);
        this.HEAD_MIDDLE.addChild(this.MAIN_EYE);
        this.HEAD_RIGHT.addChild(this.SPINE_14);
        this.HEAD_RIGHT.addChild(this.SPINE_23);
        this.HEAD_LEFT.addChild(this.MAIN_EYE_2);
        this.MIDDLE_TAIL.addChild(this.MIDDLE_TAIL_CHILD);
        this.HEAD_MIDDLE.addChild(this.MIDDLE_TAIL);
        this.HEAD_MIDDLE.addChild(this.SPINE_9);
        this.HEAD_RIGHT.addChild(this.SPINE_21);
        this.HEAD_MIDDLE.addChild(this.SPINE_5);
        this.HEAD_LEFT.addChild(this.LEFT_BOTTOM);
        this.HEAD_LEFT.addChild(this.SPINE_34);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.HEAD_MIDDLE.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
    	EntityTriGuardian entityguardian = (EntityTriGuardian)entityIn;
        float f = ageInTicks - (float)entityguardian.ticksExisted;
        this.HEAD_MIDDLE.rotateAngleY = netHeadYaw * 0.017453292F;
        this.HEAD_MIDDLE.rotateAngleX = headPitch * 0.017453292F;
        float[] afloat = new float[] {1.75F, 0.25F, 0.0F, 0.0F, 0.5F, 0.5F, 0.5F, 0.5F, 1.25F, 0.75F, 0.0F, 0.0F};
        float[] afloat1 = new float[] {0.0F, 0.0F, 0.0F, 0.0F, 0.25F, 1.75F, 1.25F, 0.75F, 0.0F, 0.0F, 0.0F, 0.0F};
        float[] afloat2 = new float[] {0.0F, 0.0F, 0.25F, 1.75F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.75F, 1.25F};
        float[] afloat3 = new float[] {0.0F, 0.0F, 8.0F, -8.0F, -8.0F, 8.0F, 8.0F, -8.0F, 0.0F, 0.0F, 8.0F, -8.0F};
        float[] afloat4 = new float[] { -8.0F, -8.0F, -8.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 8.0F, 8.0F, 8.0F, 8.0F};
        float[] afloat5 = new float[] {8.0F, -8.0F, 0.0F, 0.0F, -8.0F, -8.0F, 8.0F, 8.0F, 8.0F, -8.0F, 0.0F, 0.0F};
        float f1 = (1.0F - entityguardian.getSpikesAnimation(f)) * 0.55F;
        
        for (int i = 0; i < 12; ++i)
        {
        	/*this.SPINE_1.rotateAngleX = (float)Math.PI * afloat[i];
            this.SPINE_1.rotateAngleY = (float)Math.PI * afloat1[i];
            this.SPINE_1.rotateAngleZ = (float)Math.PI * afloat2[i];
            this.SPINE_1.rotationPointX = afloat3[i] * (1.0F + MathHelper.cos(ageInTicks * 1.5F + (float)i) * 0.01F - f1);
            this.SPINE_1.rotationPointY = 16.0F + afloat4[i] * (1.0F + MathHelper.cos(ageInTicks * 1.5F + (float)i) * 0.01F - f1);
            this.SPINE_1.rotationPointZ = afloat5[i] * (1.0F + MathHelper.cos(ageInTicks * 1.5F + (float)i) * 0.01F - f1);
           
            this.SPINE_13.rotateAngleX = (float)Math.PI * afloat[i];
            this.SPINE_13.rotateAngleY = (float)Math.PI * afloat1[i];
            this.SPINE_13.rotateAngleZ = (float)Math.PI * afloat2[i];
            this.SPINE_13.rotationPointX = afloat3[i] * (1.0F + MathHelper.cos(ageInTicks * 1.5F + (float)i) * 0.01F - f1);
            this.SPINE_13.rotationPointY = 16.0F + afloat4[i] * (1.0F + MathHelper.cos(ageInTicks * 1.5F + (float)i) * 0.01F - f1);
            this.SPINE_13.rotationPointZ = afloat5[i] * (1.0F + MathHelper.cos(ageInTicks * 1.5F + (float)i) * 0.01F - f1);
            
            this.SPINE_24.rotateAngleX = (float)Math.PI * afloat[i];
            this.SPINE_24.rotateAngleY = (float)Math.PI * afloat1[i];
            this.SPINE_24.rotateAngleZ = (float)Math.PI * afloat2[i];
            this.SPINE_24.rotationPointX = afloat3[i] * (1.0F + MathHelper.cos(ageInTicks * 1.5F + (float)i) * 0.01F - f1);
            this.SPINE_24.rotationPointY = 16.0F + afloat4[i] * (1.0F + MathHelper.cos(ageInTicks * 1.5F + (float)i) * 0.01F - f1);
            this.SPINE_24.rotationPointZ = afloat5[i] * (1.0F + MathHelper.cos(ageInTicks * 1.5F + (float)i) * 0.01F - f1);*/
        }
        
        this.MAIN_EYE.rotationPointZ = -8.25F;
        Entity entity = Minecraft.getMinecraft().getRenderViewEntity();

        if (entityguardian.hasTargetedEntity())
        {
            entity = entityguardian.getTargetedEntity();
        }

        if (entity != null)
        {
            Vec3d vec3d = entity.getPositionEyes(0.0F);
            Vec3d vec3d1 = entityIn.getPositionEyes(0.0F);
            double d0 = vec3d.y - vec3d1.y;

            if (d0 > 0.0D)
            {
                this.MAIN_EYE.rotationPointY = 0.0F;
            }
            else
            {
                this.MAIN_EYE.rotationPointY = 1.0F;
            }

            Vec3d vec3d2 = entityIn.getLook(0.0F);
            vec3d2 = new Vec3d(vec3d2.x, 0.0D, vec3d2.z);
            Vec3d vec3d3 = (new Vec3d(vec3d1.x - vec3d.x, 0.0D, vec3d1.z - vec3d.z)).normalize().rotateYaw(((float)Math.PI / 2F));
            double d1 = vec3d2.dotProduct(vec3d3);
            this.MAIN_EYE.rotationPointX = MathHelper.sqrt((float)Math.abs(d1)) * 2.0F * (float)Math.signum(d1);
        }

        this.MAIN_EYE.showModel = true;
       
        
        this.MAIN_EYE_1.rotationPointZ = -8.25F;
        Entity entity2 = Minecraft.getMinecraft().getRenderViewEntity();

        if (entityguardian.hasTargetedEntity())
        {
            entity2 = entityguardian.getTargetedEntity();
        }

        if (entity2 != null)
        {
            Vec3d vec3d = entity2.getPositionEyes(0.0F);
            Vec3d vec3d1 = entityIn.getPositionEyes(0.0F);
            double d0 = vec3d.y - vec3d1.y;

            if (d0 > 0.0D)
            {
                this.MAIN_EYE_1.rotationPointY = 0.0F;
            }
            else
            {
                this.MAIN_EYE_1.rotationPointY = 1.0F;
            }

            Vec3d vec3d2 = entityIn.getLook(0.0F);
            vec3d2 = new Vec3d(vec3d2.x, 0.0D, vec3d2.z);
            Vec3d vec3d3 = (new Vec3d(vec3d1.x - vec3d.x, 0.0D, vec3d1.z - vec3d.z)).normalize().rotateYaw(((float)Math.PI / 2F));
            double d1 = vec3d2.dotProduct(vec3d3);
            this.MAIN_EYE_1.rotationPointX = MathHelper.sqrt((float)Math.abs(d1)) * 2.0F * (float)Math.signum(d1);
        }

        this.MAIN_EYE_1.showModel = true;
        
        this.MAIN_EYE_2.rotationPointZ = -8.25F;
        Entity entity3 = Minecraft.getMinecraft().getRenderViewEntity();

        if (entityguardian.hasTargetedEntity())
        {
            entity3 = entityguardian.getTargetedEntity();
        }

        if (entity3 != null)
        {
            Vec3d vec3d = entity3.getPositionEyes(0.0F);
            Vec3d vec3d1 = entityIn.getPositionEyes(0.0F);
            double d0 = vec3d.y - vec3d1.y;

            if (d0 > 0.0D)
            {
                this.MAIN_EYE_2.rotationPointY = 0.0F;
            }
            else
            {
                this.MAIN_EYE_2.rotationPointY = 1.0F;
            }

            Vec3d vec3d2 = entityIn.getLook(0.0F);
            vec3d2 = new Vec3d(vec3d2.x, 0.0D, vec3d2.z);
            Vec3d vec3d3 = (new Vec3d(vec3d1.x - vec3d.x, 0.0D, vec3d1.z - vec3d.z)).normalize().rotateYaw(((float)Math.PI / 2F));
            double d1 = vec3d2.dotProduct(vec3d3);
            this.MAIN_EYE_2.rotationPointX = MathHelper.sqrt((float)Math.abs(d1)) * 2.0F * (float)Math.signum(d1);
        }

        this.MAIN_EYE_2.showModel = true;
        
        float f2 = entityguardian.getTailAnimation(f);
        
        this.MIDDLE_TAIL.rotateAngleY = MathHelper.sin(f2) * (float)Math.PI * 0.05F;
        this.MIDDLE_TAIL.rotateAngleY = MathHelper.sin(f2) * (float)Math.PI * 0.1F;
        this.MIDDLE_TAIL.rotationPointX = -1.5F;
        this.MIDDLE_TAIL.rotationPointY = 0.5F;
        this.MIDDLE_TAIL.rotationPointZ = 10.0F;
        this.MIDDLE_TAIL.rotateAngleY = MathHelper.sin(f2) * (float)Math.PI * 0.15F;
        this.MIDDLE_TAIL.rotationPointX = 0.5F;
        this.MIDDLE_TAIL.rotationPointY = 0.5F;
        this.MIDDLE_TAIL.rotationPointZ = 0.5F;
        
        this.RIGHT_TAIL.rotateAngleY = MathHelper.sin(f2) * (float)Math.PI * 0.05F;
        this.RIGHT_TAIL.rotateAngleY = MathHelper.sin(f2) * (float)Math.PI * 0.1F;
        this.RIGHT_TAIL.rotationPointX = -1.5F;
        this.RIGHT_TAIL.rotationPointY = 0.5F;
        this.RIGHT_TAIL.rotationPointZ = 10.0F;
        this.RIGHT_TAIL.rotateAngleY = MathHelper.sin(f2) * (float)Math.PI * 0.15F;
        this.RIGHT_TAIL.rotationPointX = 0.5F;
        this.RIGHT_TAIL.rotationPointY = 0.5F;
        this.RIGHT_TAIL.rotationPointZ = 0.5F;
        
        this.LEFT_TAIL.rotateAngleY = MathHelper.sin(f2) * (float)Math.PI * 0.05F;
        this.LEFT_TAIL.rotateAngleY = MathHelper.sin(f2) * (float)Math.PI * 0.1F;
        this.LEFT_TAIL.rotationPointX = -1.5F;
        this.LEFT_TAIL.rotationPointY = 0.5F;
        this.LEFT_TAIL.rotationPointZ = 10.0F;
        this.LEFT_TAIL.rotateAngleY = MathHelper.sin(f2) * (float)Math.PI * 0.15F;
        this.LEFT_TAIL.rotationPointX = 0.5F;
        this.LEFT_TAIL.rotationPointY = 0.5F;
        this.LEFT_TAIL.rotationPointZ = 0.5F;
    }
}
