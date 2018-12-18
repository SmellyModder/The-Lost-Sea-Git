package com.SmellyModder.TheLostSea.client.model.atlantis;

import com.SmellyModder.TheLostSea.common.entity.raid.EntityTitanGuardian;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

/**
 * ModelTitan - SmellyModder
 * Created using Tabula 7.0.0
 */
public class ModelTitan extends ModelBase {
    public ModelRenderer L_BASE;
    public ModelRenderer BASE;
    public ModelRenderer B_BASE;
    public ModelRenderer HeadBase;
    public ModelRenderer L_CHESTPLATE;
    public ModelRenderer R_CHESTPLATE;
    public ModelRenderer front_piece;
    public ModelRenderer BACK_PLATE;
    public ModelRenderer spike_1;
    public ModelRenderer spike_2;
    public ModelRenderer spike_3;
    public ModelRenderer spike_4;
    public ModelRenderer spike_5;
    public ModelRenderer spike_6;
    public ModelRenderer spike_7;
    public ModelRenderer spike_8;
    public ModelRenderer spike_9;
    public ModelRenderer spike_10;
    public ModelRenderer spike_11;
    public ModelRenderer spike_12;
    public ModelRenderer eye;
    public ModelRenderer t_head;
    public ModelRenderer b_head;
    public ModelRenderer r_head;
    public ModelRenderer l_head;
    public ModelRenderer spike_t;
    public ModelRenderer spike_tb;
    public ModelRenderer L_HANDLE;
    public ModelRenderer R_HANDLE;
    public ModelRenderer r_arm_base;
    public ModelRenderer l_arm_base;
    public ModelRenderer m_holder;
    public ModelRenderer r_shoulder;
    public ModelRenderer r_arm_m;
    public ModelRenderer left_holder;
    public ModelRenderer ls_spike;
    public ModelRenderer r_hand;
    public ModelRenderer r_finger_x;
    public ModelRenderer r_finger_y;
    public ModelRenderer r_finger_z;
    public ModelRenderer r_finger_t;
    public ModelRenderer r_hand_spike;
    public ModelRenderer r_fingertop_x;
    public ModelRenderer r_fingertop_y;
    public ModelRenderer r_fingertop_z;
    public ModelRenderer r_fingertop_t;
    public ModelRenderer leftbanner;
    public ModelRenderer leftbanner_w;
    public ModelRenderer l_shoulder;
    public ModelRenderer l_arm_m;
    public ModelRenderer left_holder_1;
    public ModelRenderer ls_spike_1;
    public ModelRenderer l_hand;
    public ModelRenderer l_finger_t;
    public ModelRenderer l_finger_x;
    public ModelRenderer l_finger_y;
    public ModelRenderer l_finger_z;
    public ModelRenderer l_hand_spike;
    public ModelRenderer l_fingertop_t;
    public ModelRenderer l_fingertop_x;
    public ModelRenderer l_fingertop_y;
    public ModelRenderer l_fingertop_z;
    public ModelRenderer leftbanner_1;
    public ModelRenderer leftbanner_w_1;
    public ModelRenderer leftbanner_2;
    public ModelRenderer leftbanner_w_2;
    public ModelRenderer L_BASE_1;
    public ModelRenderer pelvis;
    public ModelRenderer r_leg_base;
    public ModelRenderer l_leg_base;
    public ModelRenderer r_leg_m;
    public ModelRenderer r_foot;
    public ModelRenderer right_foot;
    public ModelRenderer r_spike_f;
    public ModelRenderer l_leg_m;
    public ModelRenderer l_foot;
    public ModelRenderer left_foot;
    public ModelRenderer l_spike_f;

    public ModelTitan() {
        this.textureWidth = 256;
        this.textureHeight = 256;
        this.leftbanner = new ModelRenderer(this, 200, 200);
        this.leftbanner.setRotationPoint(0.5F, 1.0F, 1.4F);
        this.leftbanner.addBox(0.0F, 0.0F, 0.0F, 7, 15, 0, 0.0F);
        this.setRotateAngle(leftbanner, 0.31869712141416456F, 0.0F, 0.0F);
        this.r_finger_x = new ModelRenderer(this, 10, 185);
        this.r_finger_x.mirror = true;
        this.r_finger_x.setRotationPoint(-3.8F, 15.0F, -4.4F);
        this.r_finger_x.addBox(-0.8F, 0.0F, 0.0F, 3, 5, 3, 0.0F);
        this.setRotateAngle(r_finger_x, 0.0F, 0.0F, -0.22759093446006054F);
        this.b_head = new ModelRenderer(this, 16, 40);
        this.b_head.setRotationPoint(-6.0F, 22.0F, -6.0F);
        this.b_head.addBox(0.0F, 0.0F, 0.0F, 12, 2, 12, 0.0F);
        this.l_hand_spike = new ModelRenderer(this, 155, 0);
        this.l_hand_spike.setRotationPoint(5.0F, 4.1F, -2.0F);
        this.l_hand_spike.addBox(0.0F, 0.0F, 0.0F, 5, 9, 5, 0.0F);
        this.setRotateAngle(l_hand_spike, 0.0F, 0.0F, 0.5009094953223726F);
        this.spike_tb = new ModelRenderer(this, 0, 100);
        this.spike_tb.mirror = true;
        this.spike_tb.setRotationPoint(4.0F, 0.0F, 6.3F);
        this.spike_tb.addBox(0.0F, 0.0F, 0.0F, 4, 4, 6, 0.0F);
        this.setRotateAngle(spike_tb, 0.9560913642424937F, 0.0F, 0.0F);
        this.ls_spike_1 = new ModelRenderer(this, 115, 0);
        this.ls_spike_1.mirror = true;
        this.ls_spike_1.setRotationPoint(9.0F, -2.5F, 6.0F);
        this.ls_spike_1.addBox(-2.0F, -1.5F, -2.0F, 4, 6, 4, 0.0F);
        this.setRotateAngle(ls_spike_1, 0.0F, 0.0F, 0.4553564018453205F);
        this.l_finger_t = new ModelRenderer(this, 10, 185);
        this.l_finger_t.mirror = true;
        this.l_finger_t.setRotationPoint(-3.4F, 14.5F, -4.0F);
        this.l_finger_t.addBox(-0.8F, 0.0F, 0.0F, 3, 5, 3, 0.0F);
        this.setRotateAngle(l_finger_t, 0.0F, 0.0F, 0.091106186954104F);
        this.L_CHESTPLATE = new ModelRenderer(this, 65, 0);
        this.L_CHESTPLATE.mirror = true;
        this.L_CHESTPLATE.setRotationPoint(18.8F, 3.0F, -2.4F);
        this.L_CHESTPLATE.addBox(0.0F, 0.0F, 0.0F, 2, 15, 18, 0.0F);
        this.setRotateAngle(L_CHESTPLATE, 0.22689280275926282F, 0.0F, 0.0F);
        this.spike_2 = new ModelRenderer(this, 0, 0);
        this.spike_2.setRotationPoint(0.0F, 10.46F, -5.94F);
        this.spike_2.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(spike_2, 0.7853981633974483F, 0.0F, 0.0F);
        this.spike_10 = new ModelRenderer(this, 0, 0);
        this.spike_10.setRotationPoint(0.0F, 19.53F, -3.53F);
        this.spike_10.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(spike_10, 2.356194490192345F, 0.0F, 0.0F);
        this.L_BASE = new ModelRenderer(this, 85, 60);
        this.L_BASE.setRotationPoint(1.0F, -35.0F, -1.0F);
        this.L_BASE.addBox(-8.0F, -1.0F, -7.5F, 15, 15, 15, 0.2F);
        this.setRotateAngle(L_BASE, 0.0F, 0.94137F, 0.0F);
        this.L_BASE_1 = new ModelRenderer(this, 125, 130);
        this.L_BASE_1.setRotationPoint(2.1F, 3.1F, -2.7F);
        this.L_BASE_1.addBox(0.0F, 0.0F, 0.0F, 18, 5, 6, 0.0F);
        this.setRotateAngle(L_BASE_1, 0.0F, -0.7853981633974483F, 0.0F);
        this.HeadBase = new ModelRenderer(this, 0, 0);
        this.HeadBase.setRotationPoint(9.5F, -22.0F, 8.5F);
        this.HeadBase.addBox(-6.0F, 10.0F, -8.0F, 12, 12, 16, 0.0F);
        this.setRotateAngle(HeadBase, 0.0F, -0.7853981633974483F, 0.0F);
        this.left_holder_1 = new ModelRenderer(this, 175, 105);
        this.left_holder_1.setRotationPoint(-2.0F, -1.5F, 4.3F);
        this.left_holder_1.addBox(0.0F, 0.0F, 0.0F, 8, 2, 2, 0.0F);
        this.l_hand = new ModelRenderer(this, 35, 155);
        this.l_hand.mirror = true;
        this.l_hand.setRotationPoint(-1.1F, 7.7F, -0.5F);
        this.l_hand.addBox(-4.5F, 0.0F, -4.5F, 10, 16, 10, 0.0F);
        this.setRotateAngle(l_hand, -0.22759093446006054F, 0.0F, 0.0F);
        this.l_arm_m = new ModelRenderer(this, 3, 200);
        this.l_arm_m.mirror = true;
        this.l_arm_m.setRotationPoint(3.5F, 4.0F, -0.5F);
        this.l_arm_m.addBox(-3.0F, 0.0F, -3.5F, 6, 9, 7, 0.0F);
        this.setRotateAngle(l_arm_m, -0.22759093446006054F, 0.0F, 0.006283185307179587F);
        this.spike_3 = new ModelRenderer(this, 0, 0);
        this.spike_3.setRotationPoint(5.07F, 10.43F, 0.0F);
        this.spike_3.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(spike_3, 0.0F, 0.0F, 0.7853981633974483F);
        this.t_head = new ModelRenderer(this, 16, 40);
        this.t_head.setRotationPoint(-6.0F, 8.0F, -6.0F);
        this.t_head.addBox(0.0F, 0.0F, 0.0F, 12, 2, 12, 0.0F);
        this.l_fingertop_y = new ModelRenderer(this, 10, 175);
        this.l_fingertop_y.mirror = true;
        this.l_fingertop_y.setRotationPoint(-0.7F, 3.6F, 0.0F);
        this.l_fingertop_y.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
        this.setRotateAngle(l_fingertop_y, 0.0F, 0.0F, 0.27314402793711257F);
        this.leftbanner_1 = new ModelRenderer(this, 200, 200);
        this.leftbanner_1.setRotationPoint(0.5F, 1.0F, 1.0F);
        this.leftbanner_1.addBox(0.0F, 0.0F, 0.0F, 7, 15, 0, 0.0F);
        this.setRotateAngle(leftbanner_1, 0.31869712141416456F, 0.0F, 0.0F);
        this.spike_4 = new ModelRenderer(this, 0, 0);
        this.spike_4.setRotationPoint(-5.02F, 10.48F, 0.0F);
        this.spike_4.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(spike_4, 0.0F, 0.0F, 5.497787143782138F);
        this.r_finger_z = new ModelRenderer(this, 10, 185);
        this.r_finger_z.mirror = true;
        this.r_finger_z.setRotationPoint(-3.8F, 15.0F, 2.4F);
        this.r_finger_z.addBox(-0.8F, 0.0F, 0.0F, 3, 5, 3, 0.0F);
        this.setRotateAngle(r_finger_z, 0.0F, 0.0F, -0.22759093446006054F);
        this.spike_9 = new ModelRenderer(this, 0, 0);
        this.spike_9.setRotationPoint(0.0F, 19.59F, 3.59F);
        this.spike_9.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(spike_9, 3.9269908169872414F, 0.0F, 0.0F);
        this.r_arm_m = new ModelRenderer(this, 3, 200);
        this.r_arm_m.setRotationPoint(-5.5F, 4.0F, -0.5F);
        this.r_arm_m.addBox(-3.0F, 0.0F, -3.5F, 6, 9, 7, 0.0F);
        this.setRotateAngle(r_arm_m, -0.22759093446006054F, 0.0F, 0.0F);
        this.spike_7 = new ModelRenderer(this, 0, 0);
        this.spike_7.setRotationPoint(6.08F, 16.0F, 6.08F);
        this.spike_7.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(spike_7, 1.5707963267948966F, 3.9269908169872414F, 0.0F);
        this.spike_8 = new ModelRenderer(this, 0, 0);
        this.spike_8.setRotationPoint(-6.06F, 16.0F, 6.06F);
        this.spike_8.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(spike_8, 1.5707963267948966F, 2.356194490192345F, 0.0F);
        this.L_HANDLE = new ModelRenderer(this, 125, 100);
        this.L_HANDLE.mirror = true;
        this.L_HANDLE.setRotationPoint(1.5F, 14.5F, -2.4F);
        this.L_HANDLE.addBox(0.0F, 0.0F, 0.0F, 1, 4, 19, 0.0F);
        this.setRotateAngle(L_HANDLE, 0.0F, 0.0F, 0.5089380098815465F);
        this.r_fingertop_x = new ModelRenderer(this, 10, 175);
        this.r_fingertop_x.mirror = true;
        this.r_fingertop_x.setRotationPoint(-0.8F, 4.5F, 0.0F);
        this.r_fingertop_x.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
        this.setRotateAngle(r_fingertop_x, 0.0F, 0.0F, -0.27314402793711257F);
        this.l_finger_x = new ModelRenderer(this, 10, 185);
        this.l_finger_x.setRotationPoint(3.4F, 15.0F, -4.4F);
        this.l_finger_x.addBox(-0.8F, 0.0F, 0.0F, 3, 5, 3, 0.0F);
        this.setRotateAngle(l_finger_x, 0.0F, 0.0F, 0.21362830044410594F);
        this.r_hand = new ModelRenderer(this, 35, 155);
        this.r_hand.setRotationPoint(0.1F, 7.7F, -0.5F);
        this.r_hand.addBox(-4.5F, 0.0F, -4.5F, 10, 16, 10, 0.0F);
        this.setRotateAngle(r_hand, -0.22759093446006054F, 0.0F, 0.0F);
        this.ls_spike = new ModelRenderer(this, 115, 0);
        this.ls_spike.setRotationPoint(6.0F, -2.5F, 6.0F);
        this.ls_spike.addBox(-2.0F, -1.5F, -2.0F, 4, 6, 4, 0.0F);
        this.setRotateAngle(ls_spike, 0.0F, 0.0F, -0.4553564018453205F);
        this.r_head = new ModelRenderer(this, 0, 28);
        this.r_head.setRotationPoint(-8.0F, 10.0F, -6.0F);
        this.r_head.addBox(0.0F, 0.0F, 0.0F, 2, 12, 12, 0.0F);
        this.B_BASE = new ModelRenderer(this, 85, 95);
        this.B_BASE.setRotationPoint(-6.2F, 13.4F, -6.5F);
        this.B_BASE.addBox(0.0F, 0.0F, 0.0F, 12, 8, 12, 0.0F);
        this.r_finger_t = new ModelRenderer(this, 10, 185);
        this.r_finger_t.setRotationPoint(3.0F, 14.5F, -4.0F);
        this.r_finger_t.addBox(-0.8F, 0.0F, 0.0F, 3, 5, 3, 0.0F);
        this.setRotateAngle(r_finger_t, 0.0F, 0.0F, -0.091106186954104F);
        this.eye = new ModelRenderer(this, 8, 0);
        this.eye.setRotationPoint(0.0F, 0.0F, -8.25F);
        this.eye.addBox(-1.0F, 15.0F, 0.0F, 2, 2, 1, 0.0F);
        this.r_fingertop_t = new ModelRenderer(this, 10, 175);
        this.r_fingertop_t.setRotationPoint(-0.6F, 3.4F, 0.01F);
        this.r_fingertop_t.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
        this.setRotateAngle(r_fingertop_t, 0.0F, 0.0F, 0.27314402793711257F);
        this.r_arm_base = new ModelRenderer(this, 30, 200);
        this.r_arm_base.mirror = true;
        this.r_arm_base.setRotationPoint(0.5F, 5.0F, 5.5F);
        this.r_arm_base.addBox(-9.0F, -4.0F, -5.0F, 12, 9, 9, 0.0F);
        this.l_fingertop_x = new ModelRenderer(this, 10, 175);
        this.l_fingertop_x.setRotationPoint(-0.7F, 3.6F, 0.0F);
        this.l_fingertop_x.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
        this.setRotateAngle(l_fingertop_x, 0.0F, 0.0F, 0.27314402793711257F);
        this.l_finger_y = new ModelRenderer(this, 10, 185);
        this.l_finger_y.mirror = true;
        this.l_finger_y.setRotationPoint(3.4F, 15.0F, -1.1F);
        this.l_finger_y.addBox(-0.8F, 0.0F, 0.0F, 3, 5, 3, 0.0F);
        this.setRotateAngle(l_finger_y, 0.015184364492350668F, 0.0F, 0.22759093446006054F);
        this.m_holder = new ModelRenderer(this, 200, 105);
        this.m_holder.setRotationPoint(5.3F, 2.0F, 10.0F);
        this.m_holder.addBox(0.0F, 0.0F, 0.0F, 18, 3, 4, 0.0F);
        this.r_leg_m = new ModelRenderer(this, 125, 200);
        this.r_leg_m.setRotationPoint(-5.0F, 5.0F, 0.5F);
        this.r_leg_m.addBox(-3.0F, 0.0F, -4.5F, 6, 13, 9, 0.0F);
        this.setRotateAngle(r_leg_m, -0.22759093446006054F, 0.0F, 0.0F);
        this.spike_12 = new ModelRenderer(this, 0, 0);
        this.spike_12.setRotationPoint(-3.6F, 19.6F, 0.0F);
        this.spike_12.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(spike_12, 0.0F, 0.0F, 3.9269908169872414F);
        this.leftbanner_2 = new ModelRenderer(this, 200, 120);
        this.leftbanner_2.setRotationPoint(1.0F, 1.0F, 1.0F);
        this.leftbanner_2.addBox(0.0F, 0.0F, 0.0F, 16, 23, 0, 0.0F);
        this.setRotateAngle(leftbanner_2, 0.3464478565208744F, 0.0F, 0.0F);
        this.spike_11 = new ModelRenderer(this, 0, 0);
        this.spike_11.setRotationPoint(3.53F, 19.53F, 0.0F);
        this.spike_11.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(spike_11, 0.0F, 0.0F, 2.356194490192345F);
        this.l_arm_base = new ModelRenderer(this, 30, 200);
        this.l_arm_base.setRotationPoint(30.5F, 5.0F, 5.5F);
        this.l_arm_base.addBox(-5.0F, -4.0F, -5.0F, 12, 9, 9, 0.0F);
        this.left_foot = new ModelRenderer(this, 80, 155);
        this.left_foot.mirror = true;
        this.left_foot.setRotationPoint(0.0F, 14.5F, 0.3F);
        this.left_foot.addBox(-4.5F, 0.0F, -10.0F, 9, 5, 16, 0.0F);
        this.setRotateAngle(left_foot, 0.03490658503988659F, 0.017453292519943295F, 0.0F);
        this.l_head = new ModelRenderer(this, 0, 28);
        this.l_head.mirror = true;
        this.l_head.setRotationPoint(6.0F, 10.0F, -6.0F);
        this.l_head.addBox(0.0F, 0.0F, 0.0F, 2, 12, 12, 0.0F);
        this.left_holder = new ModelRenderer(this, 175, 105);
        this.left_holder.mirror = true;
        this.left_holder.setRotationPoint(-8.0F, -1.5F, 4.3F);
        this.left_holder.addBox(0.0F, 0.0F, 0.0F, 8, 2, 2, 0.0F);
        this.r_fingertop_y = new ModelRenderer(this, 10, 175);
        this.r_fingertop_y.setRotationPoint(-0.8F, 4.5F, 0.0F);
        this.r_fingertop_y.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
        this.setRotateAngle(r_fingertop_y, 0.0F, 0.0F, -0.27314402793711257F);
        this.r_fingertop_z = new ModelRenderer(this, 10, 175);
        this.r_fingertop_z.mirror = true;
        this.r_fingertop_z.setRotationPoint(-0.8F, 4.5F, 0.0F);
        this.r_fingertop_z.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
        this.setRotateAngle(r_fingertop_z, 0.0F, 0.0F, -0.27314402793711257F);
        this.l_spike_f = new ModelRenderer(this, 80, 180);
        this.l_spike_f.setRotationPoint(0.0F, 4.0F, -8.1F);
        this.l_spike_f.addBox(-4.0F, 0.0F, 0.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(l_spike_f, 0.17453292519943295F, 0.7853981633974483F, 0.10471975511965977F);
        this.spike_6 = new ModelRenderer(this, 0, 0);
        this.spike_6.setRotationPoint(6.02F, 16.0F, -6.02F);
        this.spike_6.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(spike_6, 1.5707963267948966F, 5.497787143782138F, 0.0F);
        this.spike_t = new ModelRenderer(this, 0, 120);
        this.spike_t.setRotationPoint(4.0F, 0.6F, 0.0F);
        this.spike_t.addBox(0.0F, 0.0F, 0.0F, 4, 4, 5, 0.0F);
        this.setRotateAngle(spike_t, 0.9560913642424937F, 0.0F, 0.0F);
        this.right_foot = new ModelRenderer(this, 80, 155);
        this.right_foot.setRotationPoint(0.0F, 14.5F, 0.3F);
        this.right_foot.addBox(-4.5F, 0.0F, -10.0F, 9, 5, 16, 0.0F);
        this.setRotateAngle(right_foot, 0.03490658503988659F, -0.017453292519943295F, 0.0F);
        this.front_piece = new ModelRenderer(this, 155, 65);
        this.front_piece.setRotationPoint(20.2F, 2.7F, 0.7F);
        this.front_piece.addBox(0.0F, 0.0F, 0.0F, 4, 15, 1, 0.0F);
        this.setRotateAngle(front_piece, 0.04363323129985824F, 2.356194490192345F, 0.0F);
        this.leftbanner_w = new ModelRenderer(this, 200, 220);
        this.leftbanner_w.setRotationPoint(0.0F, 14.7F, -0.1F);
        this.leftbanner_w.addBox(0.0F, 0.0F, 0.0F, 7, 15, 0, 0.0F);
        this.setRotateAngle(leftbanner_w, 0.19303341527057286F, 0.0F, 0.0F);
        this.leftbanner_w_1 = new ModelRenderer(this, 200, 220);
        this.leftbanner_w_1.setRotationPoint(0.0F, 14.7F, -0.1F);
        this.leftbanner_w_1.addBox(0.0F, 0.0F, 0.0F, 7, 15, 0, 0.0F);
        this.setRotateAngle(leftbanner_w_1, 0.19303341527057286F, 0.0F, 0.0F);
        this.BASE = new ModelRenderer(this, 170, 60);
        this.BASE.setRotationPoint(-8.0F, -8.4F, -10.5F);
        this.BASE.addBox(0.0F, 0.0F, -2.0F, 20, 16, 20, 0.0F);
        this.setRotateAngle(BASE, 0.13962634015954636F, 0.0F, 0.13962634015954636F);
        this.l_finger_z = new ModelRenderer(this, 10, 185);
        this.l_finger_z.setRotationPoint(3.4F, 15.0F, 2.3F);
        this.l_finger_z.addBox(-0.8F, 0.0F, 0.0F, 3, 5, 3, 0.0F);
        this.setRotateAngle(l_finger_z, 0.015184364492350668F, 0.0F, 0.22759093446006054F);
        this.l_leg_base = new ModelRenderer(this, 125, 180);
        this.l_leg_base.setRotationPoint(3.2F, 3.5F, 0.5F);
        this.l_leg_base.addBox(0.0F, 0.0F, 0.0F, 9, 7, 10, 0.0F);
        this.setRotateAngle(l_leg_base, -0.017453292519943295F, 0.0F, -0.03490658503988659F);
        this.r_finger_y = new ModelRenderer(this, 10, 185);
        this.r_finger_y.setRotationPoint(-3.8F, 15.0F, -1.0F);
        this.r_finger_y.addBox(-0.8F, 0.0F, 0.0F, 3, 5, 3, 0.0F);
        this.setRotateAngle(r_finger_y, 0.0F, 0.0F, -0.22759093446006054F);
        this.l_fingertop_z = new ModelRenderer(this, 10, 175);
        this.l_fingertop_z.setRotationPoint(-0.7F, 3.6F, 0.0F);
        this.l_fingertop_z.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
        this.setRotateAngle(l_fingertop_z, 0.0F, 0.0F, 0.27314402793711257F);
        this.R_HANDLE = new ModelRenderer(this, 125, 100);
        this.R_HANDLE.setRotationPoint(0.0F, 15.0F, -2.5F);
        this.R_HANDLE.addBox(0.0F, 0.0F, 0.0F, 1, 4, 19, 0.0F);
        this.setRotateAngle(R_HANDLE, 0.0F, 0.0F, -0.5089380098815465F);
        this.leftbanner_w_2 = new ModelRenderer(this, 200, 150);
        this.leftbanner_w_2.setRotationPoint(0.0F, 22.8F, -0.1F);
        this.leftbanner_w_2.addBox(0.0F, 0.0F, 0.0F, 16, 30, 0, 0.0F);
        this.setRotateAngle(leftbanner_w_2, 0.19303341527057286F, 0.0F, 0.0F);
        this.spike_1 = new ModelRenderer(this, 0, 0);
        this.spike_1.setRotationPoint(0.0F, 10.92F, 5.98F);
        this.spike_1.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(spike_1, 5.497787143782138F, 0.0F, 0.0F);
        this.r_hand_spike = new ModelRenderer(this, 155, 0);
        this.r_hand_spike.setRotationPoint(-8.9F, 5.9F, -2.0F);
        this.r_hand_spike.addBox(0.0F, 0.0F, 0.0F, 5, 9, 5, 0.0F);
        this.setRotateAngle(r_hand_spike, 0.0F, 0.0F, -0.5009094953223726F);
        this.pelvis = new ModelRenderer(this, 125, 151);
        this.pelvis.mirror = true;
        this.pelvis.setRotationPoint(5.8F, 4.0F, -2.0F);
        this.pelvis.addBox(0.0F, 0.0F, 0.0F, 6, 7, 11, 0.0F);
        this.l_foot = new ModelRenderer(this, 80, 200);
        this.l_foot.mirror = true;
        this.l_foot.setRotationPoint(-0.3F, 11.0F, 0.0F);
        this.l_foot.addBox(-4.0F, -1.0F, -5.0F, 8, 17, 10, 0.0F);
        this.setRotateAngle(l_foot, 0.22759093446006054F, 0.0F, 0.017453292519943295F);
        this.R_CHESTPLATE = new ModelRenderer(this, 65, 0);
        this.R_CHESTPLATE.setRotationPoint(20.4F, 3.0F, -2.8F);
        this.R_CHESTPLATE.addBox(0.0F, 0.0F, 0.0F, 2, 15, 18, 0.0F);
        this.setRotateAngle(R_CHESTPLATE, 0.22689280275926282F, -1.5707963267948966F, 0.0F);
        this.r_foot = new ModelRenderer(this, 80, 200);
        this.r_foot.setRotationPoint(0.3F, 11.0F, 0.0F);
        this.r_foot.addBox(-4.0F, -1.0F, -5.0F, 8, 17, 10, 0.0F);
        this.setRotateAngle(r_foot, 0.22759093446006054F, 0.0F, -0.017453292519943295F);
        this.l_leg_m = new ModelRenderer(this, 125, 200);
        this.l_leg_m.mirror = true;
        this.l_leg_m.setRotationPoint(5.0F, 5.0F, 5.0F);
        this.l_leg_m.addBox(-3.0F, 0.0F, -4.5F, 6, 13, 9, 0.0F);
        this.setRotateAngle(l_leg_m, -0.22759093446006054F, 0.0F, 0.0F);
        this.r_shoulder = new ModelRenderer(this, 115, 15);
        this.r_shoulder.mirror = true;
        this.r_shoulder.setRotationPoint(-14.5F, -2.0F, -6.0F);
        this.r_shoulder.addBox(0.0F, 0.0F, 0.0F, 15, 5, 11, 0.0F);
        this.setRotateAngle(r_shoulder, 0.0F, 0.0F, -0.47822021504644624F);
        this.spike_5 = new ModelRenderer(this, 0, 0);
        this.spike_5.setRotationPoint(-6.05F, 16.0F, -6.05F);
        this.spike_5.addBox(-1.0F, -4.5F, -1.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(spike_5, 1.5707963267948966F, 0.7853981633974483F, 0.0F);
        this.l_fingertop_t = new ModelRenderer(this, 10, 175);
        this.l_fingertop_t.mirror = true;
        this.l_fingertop_t.setRotationPoint(-0.9F, 4.4F, 0.01F);
        this.l_fingertop_t.addBox(0.0F, 0.0F, 0.0F, 3, 4, 3, 0.0F);
        this.setRotateAngle(l_fingertop_t, 0.0F, 0.0F, -0.27314402793711257F);
        this.BACK_PLATE = new ModelRenderer(this, 170, 25);
        this.BACK_PLATE.setRotationPoint(-0.5F, 0.2F, -2.0F);
        this.BACK_PLATE.addBox(0.0F, 0.0F, 0.0F, 29, 13, 10, 0.0F);
        this.setRotateAngle(BACK_PLATE, 0.0F, -0.7853981633974483F, 0.0F);
        this.r_leg_base = new ModelRenderer(this, 125, 180);
        this.r_leg_base.setRotationPoint(2.8F, 3.6F, 4.7F);
        this.r_leg_base.addBox(-9.0F, 0.0F, -4.5F, 9, 7, 10, 0.0F);
        this.setRotateAngle(r_leg_base, -0.017453292519943295F, 0.0F, 0.03490658503988659F);
        this.r_spike_f = new ModelRenderer(this, 80, 180);
        this.r_spike_f.setRotationPoint(0.0F, 4.0F, -8.1F);
        this.r_spike_f.addBox(-4.0F, 0.0F, 0.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(r_spike_f, 0.17453292519943295F, 0.7853981633974483F, 0.10471975511965977F);
        this.l_shoulder = new ModelRenderer(this, 115, 15);
        this.l_shoulder.setRotationPoint(-1.5F, -9.0F, -6.0F);
        this.l_shoulder.addBox(0.0F, 0.0F, 0.0F, 15, 5, 11, 0.0F);
        this.setRotateAngle(l_shoulder, 0.0F, 0.0F, 0.47822021504644624F);
        this.left_holder.addChild(this.leftbanner);
        this.r_hand.addChild(this.r_finger_x);
        this.HeadBase.addChild(this.b_head);
        this.l_hand.addChild(this.l_hand_spike);
        this.t_head.addChild(this.spike_tb);
        this.l_shoulder.addChild(this.ls_spike_1);
        this.l_hand.addChild(this.l_finger_t);
        this.BASE.addChild(this.L_CHESTPLATE);
        this.HeadBase.addChild(this.spike_2);
        this.HeadBase.addChild(this.spike_10);
        this.B_BASE.addChild(this.L_BASE_1);
        this.BASE.addChild(this.HeadBase);
        this.l_arm_base.addChild(this.left_holder_1);
        this.l_arm_m.addChild(this.l_hand);
        this.l_arm_base.addChild(this.l_arm_m);
        this.HeadBase.addChild(this.spike_3);
        this.HeadBase.addChild(this.t_head);
        this.l_finger_y.addChild(this.l_fingertop_y);
        this.left_holder_1.addChild(this.leftbanner_1);
        this.HeadBase.addChild(this.spike_4);
        this.r_hand.addChild(this.r_finger_z);
        this.HeadBase.addChild(this.spike_9);
        this.r_arm_base.addChild(this.r_arm_m);
        this.HeadBase.addChild(this.spike_7);
        this.HeadBase.addChild(this.spike_8);
        this.L_CHESTPLATE.addChild(this.L_HANDLE);
        this.r_finger_x.addChild(this.r_fingertop_x);
        this.l_hand.addChild(this.l_finger_x);
        this.r_arm_m.addChild(this.r_hand);
        this.r_shoulder.addChild(this.ls_spike);
        this.HeadBase.addChild(this.r_head);
        this.L_BASE.addChild(this.B_BASE);
        this.r_hand.addChild(this.r_finger_t);
        this.HeadBase.addChild(this.eye);
        this.r_finger_t.addChild(this.r_fingertop_t);
        this.BACK_PLATE.addChild(this.r_arm_base);
        this.l_finger_x.addChild(this.l_fingertop_x);
        this.l_hand.addChild(this.l_finger_y);
        this.BACK_PLATE.addChild(this.m_holder);
        this.r_leg_base.addChild(this.r_leg_m);
        this.HeadBase.addChild(this.spike_12);
        this.m_holder.addChild(this.leftbanner_2);
        this.HeadBase.addChild(this.spike_11);
        this.BACK_PLATE.addChild(this.l_arm_base);
        this.l_foot.addChild(this.left_foot);
        this.HeadBase.addChild(this.l_head);
        this.r_arm_base.addChild(this.left_holder);
        this.r_finger_y.addChild(this.r_fingertop_y);
        this.r_finger_z.addChild(this.r_fingertop_z);
        this.l_foot.addChild(this.l_spike_f);
        this.HeadBase.addChild(this.spike_6);
        this.t_head.addChild(this.spike_t);
        this.r_foot.addChild(this.right_foot);
        this.BASE.addChild(this.front_piece);
        this.leftbanner.addChild(this.leftbanner_w);
        this.leftbanner_1.addChild(this.leftbanner_w_1);
        this.L_BASE.addChild(this.BASE);
        this.l_hand.addChild(this.l_finger_z);
        this.pelvis.addChild(this.l_leg_base);
        this.r_hand.addChild(this.r_finger_y);
        this.l_finger_z.addChild(this.l_fingertop_z);
        this.R_CHESTPLATE.addChild(this.R_HANDLE);
        this.leftbanner_2.addChild(this.leftbanner_w_2);
        this.HeadBase.addChild(this.spike_1);
        this.r_hand.addChild(this.r_hand_spike);
        this.L_BASE_1.addChild(this.pelvis);
        this.l_leg_m.addChild(this.l_foot);
        this.BASE.addChild(this.R_CHESTPLATE);
        this.r_leg_m.addChild(this.r_foot);
        this.l_leg_base.addChild(this.l_leg_m);
        this.r_arm_base.addChild(this.r_shoulder);
        this.HeadBase.addChild(this.spike_5);
        this.l_finger_t.addChild(this.l_fingertop_t);
        this.BASE.addChild(this.BACK_PLATE);
        this.pelvis.addChild(this.r_leg_base);
        this.r_foot.addChild(this.r_spike_f);
        this.l_arm_base.addChild(this.l_shoulder);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.L_BASE.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    protected boolean hasSwung = false;
    
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
    		float headPitch, float scaleFactor, Entity entityIn) {
    	EntityTitanGuardian titan = (EntityTitanGuardian) entityIn;
    	float f = 1.0F;
    	float globalSpeed = 0.6F;
        float globalDegree = 1.4F;
        
        float[] afloat = new float[] {1.75F, 0.25F, 0.0F, 0.0F, 0.5F, 0.5F, 0.5F, 0.5F, 1.25F, 0.75F, 0.0F, 0.0F};
        float[] afloat1 = new float[] {0.0F, 0.0F, 0.0F, 0.0F, 0.25F, 1.75F, 1.25F, 0.75F, 0.0F, 0.0F, 0.0F, 0.0F};
        
        float[] afloat2 = new float[] {1.75F, 0.25F, 0.0F, 0.0F, 0.5F, 0.5F, 0.5F, 0.5F, 1.25F, 0.75F, 0.0F, 0.0F};
        float[] afloat3 = new float[] {0.0F, 0.0F, 0.0F, 0.0F, 0.25F, 1.75F, 1.25F, 0.75F, 0.0F, 0.0F, 0.0F, 0.0F};

    	if (f < 1.0F)
    	{
    		f = 1.0F;
    	}
    	for (int i = 0; i < 12; ++i)
        {
    		this.ls_spike.rotationPointY = -(1.0F + MathHelper.cos(ageInTicks * 1.2F + (float)i) +  MathHelper.cos(afloat[i]));
    		this.ls_spike_1.rotationPointY = -(1.0F + MathHelper.cos(ageInTicks * 1.2F + (float)i) +  MathHelper.cos(afloat[i]));
        
    		this.r_hand_spike.rotationPointX = (-9.0F + MathHelper.cos(ageInTicks * 1.1F + (float)i) +  MathHelper.cos(afloat1[i]));
    		this.r_hand_spike.rotationPointY = (4.1F + MathHelper.cos(ageInTicks * 1.1F + (float)i) +  MathHelper.cos(afloat1[i]));
        
    		this.l_hand_spike.rotationPointX = (4.10F + MathHelper.cos(ageInTicks * 1.1F + (float)i) +  MathHelper.cos(afloat1[i]));
    		this.l_hand_spike.rotationPointY = (2.75F + MathHelper.cos(ageInTicks * 1.1F + (float)i) +  MathHelper.cos(afloat1[i]));
        }
    	
    	
    	this.l_leg_m.rotateAngleX = MathHelper.cos(limbSwing * 0.6682F) * 1.4F * limbSwingAmount;
    	this.r_leg_m.rotateAngleX = MathHelper.cos(limbSwing * 0.6682F + (float)Math.PI) * 1.4F * limbSwingAmount;
    	
    	if(limbSwingAmount > 0) {
    		this.l_arm_m.rotateAngleX = (-0.2F + 1.5F * this.triangleWave(limbSwing, 13.0F)) * limbSwingAmount;
    		this.r_arm_m.rotateAngleX = (-0.2F - 1.5F * this.triangleWave(limbSwing, 13.0F)) * limbSwingAmount;
    		
    		
    		this.hasSwung = true;
    	}else if(limbSwingAmount < 0) {
    		this.hasSwung = false;
    		
    	}
    	
    	 Entity entity = Minecraft.getMinecraft().getRenderViewEntity();

         if (titan.hasTargetedEntity())
         {
             entity = titan.getTargetedEntity();
         }

         if (entity != null)
         {
             Vec3d vec3d = entity.getPositionEyes(0.0F);
             Vec3d vec3d1 = entityIn.getPositionEyes(0.0F);
             double d0 = vec3d.y - vec3d1.y;

             if (d0 > 0.0D)
             {
                 this.eye.rotationPointY = 0.0F;
             }
             else
             {
                 this.eye.rotationPointY = 1.0F;
             }

             Vec3d vec3d2 = entityIn.getLook(0.0F);
             vec3d2 = new Vec3d(vec3d2.x, 0.0D, vec3d2.z);
             Vec3d vec3d3 = (new Vec3d(vec3d1.x - vec3d.x, 0.0D, vec3d1.z - vec3d.z)).normalize().rotateYaw(((float)Math.PI / 2F));
             double d1 = vec3d2.dotProduct(vec3d3);
             this.eye.rotationPointX = MathHelper.sqrt((float)Math.abs(d1)) * 2.0F * (float)Math.signum(d1);
         }
    	
    	this.l_foot.rotateAngleX = MathHelper.sin(limbSwingAmount);
    	this.left_foot.rotateAngleX = MathHelper.sin(limbSwingAmount) * (Math.abs(this.l_foot.rotateAngleX));
    	
    	this.r_foot.rotateAngleX = MathHelper.sin(limbSwingAmount);
    	this.right_foot.rotateAngleX = MathHelper.sin(limbSwingAmount) * (Math.abs(this.r_foot.rotateAngleX));
        
        
    	super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
    }
    
//    private float computeAnimation(float speed, float degree, boolean invert, float offset, float weight, float limbSwing, float limbSwingAmount) {
//        float theta = limbSwing * speed + offset;
//        float scaledWeight = weight * limbSwingAmount;
//        float rotation = (MathHelper.cos(theta) * degree * limbSwingAmount) + scaledWeight;
//        return invert ? -rotation : rotation;
//    }
    
    @Override
    public void setLivingAnimations(EntityLivingBase entity, float swing, float speed, float partialRenderTicks) {
    		EntityTitanGuardian titan = (EntityTitanGuardian) entity;
    		boolean flag = titan.getEntityWorld() != null;
            boolean flag1 = !flag;
            long j = flag ? titan.getEntityWorld().getTotalWorldTime() : 0L;
            float f99 = titan.limbSwingAmount;
            
            BlockPos blockpos = titan.getPosition();
            float f3 = (float)(2 * 7 + 2 * 9 + 2 * 13) + (float)j + partialRenderTicks;
            float f4 = f3 + j;

            float flap = MathHelper.sin((titan.ticksExisted + partialRenderTicks) * 0.5F) * 0.6F;
            flap = MathHelper.cos((titan.ticksExisted + partialRenderTicks) * 1.5F) * 0.6F;
            
            this.leftbanner_2.rotationPointZ = 2.4F;
            this.leftbanner_1.rotationPointZ = 1.2F;
            this.leftbanner.rotationPointZ = 1.2F;
            if(!this.hasSwung) {
            	this.leftbanner.rotateAngleX = (-0.0125F + 0.01F * MathHelper.cos(f3 * (float)Math.PI * 0.02F)) * (2.6F*(float)Math.PI);
            	this.leftbanner_1.rotateAngleX = (-0.0125F + 0.01F * MathHelper.cos(f3 * (float)Math.PI * 0.02F)) * (2.2F*(float)Math.PI);
            	this.leftbanner_2.rotateAngleX = (-0.0125F + 0.01F * MathHelper.cos(f3 * (float)Math.PI * 0.02F)) * (2.6F*(float)Math.PI);
            }else if(this.hasSwung) {
            	this.leftbanner.rotateAngleX = (-0.0125F + 0.01F * -MathHelper.cos(f4 * (float)Math.PI * 0.02F)) * (2.6F*(float)Math.PI);
            	this.leftbanner_1.rotateAngleX = (-0.0125F + 0.01F * -MathHelper.cos(f4 * (float)Math.PI * 0.02F)) * (2.2F*(float)Math.PI);
            	this.leftbanner_2.rotateAngleX = (-0.0125F + 0.01F * -MathHelper.cos(f4 * (float)Math.PI * 0.02F)) * (2.6F*(float)Math.PI);
            }
            
            this.l_arm_m.rotateAngleX = (-0.0325F + 0.01F * MathHelper.sin(f4 * (float)Math.PI * 0.02F)) * (1.4F*(float)Math.PI);
            this.l_hand.rotateAngleX = (-0.0325F + 0.01F * MathHelper.sin(f4 * (float)Math.PI * 0.02F)) * (1.5F*(float)Math.PI);
            this.r_arm_m.rotateAngleX = (-0.0325F + 0.01F * MathHelper.sin(f4 * (float)Math.PI * 0.02F)) * (1.4F*(float)Math.PI);
            this.r_hand.rotateAngleX = (-0.0325F + 0.01F * MathHelper.sin(f4 * (float)Math.PI * 0.02F)) * (1.5F*(float)Math.PI);
    }
    
    private float triangleWave(float p_78172_1_, float p_78172_2_)
    {
        return (Math.abs(p_78172_1_ % p_78172_2_ - p_78172_2_ * 0.5F) - p_78172_2_ * 0.25F) / (p_78172_2_ * 0.25F);
    }
}
