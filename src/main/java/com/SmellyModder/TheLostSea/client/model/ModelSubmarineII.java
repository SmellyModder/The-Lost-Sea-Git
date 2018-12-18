package com.SmellyModder.TheLostSea.client.model;

import com.SmellyModder.TheLostSea.common.entity.bases.AbstractSubmarine;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.math.MathHelper;

/**
 * SubmarineII - SmellyModder
 * Created using Tabula 7.0.0
 */
public class ModelSubmarineII extends ModelBase {
    public ModelRenderer GLASS;
    public ModelRenderer R_PLATE;
    public ModelRenderer L_PLATE;
    public ModelRenderer T_PLATE;
    public ModelRenderer B_PLATE;
    public ModelRenderer L_T_PLATE;
    public ModelRenderer R_T_PLATE;
    public ModelRenderer T_PLATE_1;
    public ModelRenderer R_T_PLATE_B;
    public ModelRenderer R_T_PLATE_B_1;
    public ModelRenderer T_R_ARM;
    public ModelRenderer L_R_ARM;
    public ModelRenderer HOLDER_R_T;
    public ModelRenderer POLE_T_R;
    public ModelRenderer LIGHT_R_T;
    public ModelRenderer BOOSTER_T_R_1;
    public ModelRenderer BOOSTER_T_R_2;
    public ModelRenderer HOLDER_R_B;
    public ModelRenderer POLE_B_R;
    public ModelRenderer LIGHT_R_B;
    public ModelRenderer BOOSTER_B_R_1;
    public ModelRenderer BOOSTER_B_R_2;
    public ModelRenderer T_L_ARM;
    public ModelRenderer B_L_ARM;
    public ModelRenderer HOLDER_L_T;
    public ModelRenderer POLE_T_L;
    public ModelRenderer LIGHT_L_T;
    public ModelRenderer BOOSTER_T_L_1;
    public ModelRenderer BOOSTER_T_L_2;
    public ModelRenderer HOLDER_L_B;
    public ModelRenderer POLE_B_L;
    public ModelRenderer LIGHT_L_B;
    public ModelRenderer BOOSTER_B_L_1;
    public ModelRenderer BOOSTER_B_L_2;
    public ModelRenderer B_PLATE_1;
    public ModelRenderer CANNON_R;
    public ModelRenderer CANNON_R_1;
    public ModelRenderer R_SEAT_BASE;
    public ModelRenderer R_SEAT_BASE_1;
    public ModelRenderer shape83;
    public ModelRenderer R_SEAT_POLE;
    public ModelRenderer R_SEAT_BASE_2;
    public ModelRenderer R_SEAT_HOLDER_R;
    public ModelRenderer R_SEAT_HOLDER_L;
    public ModelRenderer R_SEAT_BASE_T;
    public ModelRenderer R_SEAT_HOLDER_L_T;
    public ModelRenderer R_SEAT_HOLDER_R_T;
    public ModelRenderer R_SEAT_POLE_1;
    public ModelRenderer R_SEAT_BASE_3;
    public ModelRenderer R_SEAT_HOLDER_R_1;
    public ModelRenderer R_SEAT_HOLDER_L_1;
    public ModelRenderer R_SEAT_BASE_T_1;
    public ModelRenderer R_SEAT_HOLDER_L_T_1;
    public ModelRenderer R_SEAT_HOLDER_R_T_1;
    public ModelRenderer L_BAR;
    public ModelRenderer R_BAR;
    public ModelRenderer FIN_M;
    
    public boolean hasCannons = true;

    public ModelSubmarineII() {
        this.textureWidth = 512;
        this.textureHeight = 512;
        this.R_SEAT_HOLDER_L = new ModelRenderer(this, 250, 75);
        this.R_SEAT_HOLDER_L.setRotationPoint(8.7F, -0.5F, -0.5F);
        this.R_SEAT_HOLDER_L.addBox(0.0F, 0.0F, 0.0F, 2, 2, 10, 0.0F);
        this.setRotateAngle(R_SEAT_HOLDER_L, 0.0F, 0.0F, -0.018527641125432728F);
        this.CANNON_R_1 = new ModelRenderer(this, 0, 100);
        this.CANNON_R_1.setRotationPoint(56.0F, -2.5F, -12.0F);
        this.CANNON_R_1.addBox(0.0F, 0.0F, 0.0F, 10, 10, 25, 0.0F);
        this.setRotateAngle(CANNON_R_1, 0.0F, -0.017453292519943295F, 0.7740535232594852F);
        this.L_T_PLATE = new ModelRenderer(this, 0, 320);
        this.L_T_PLATE.setRotationPoint(35.5F, -13.5F, -5.5F);
        this.L_T_PLATE.addBox(0.0F, 0.0F, 0.0F, 20, 20, 24, 0.0F);
        this.R_T_PLATE_B_1 = new ModelRenderer(this, 0, 320);
        this.R_T_PLATE_B_1.setRotationPoint(35.5F, -13.5F, 56.5F);
        this.R_T_PLATE_B_1.addBox(0.0F, 0.0F, 0.0F, 20, 20, 24, 0.0F);
        this.BOOSTER_B_L_2 = new ModelRenderer(this, 370, 340);
        this.BOOSTER_B_L_2.setRotationPoint(3.0F, -10.5F, 5.5F);
        this.BOOSTER_B_L_2.addBox(0.0F, 0.0F, 0.0F, 22, 6, 5, 0.0F);
        this.setRotateAngle(BOOSTER_B_L_2, 0.0F, 0.0F, 1.5707963267948966F);
        this.GLASS = new ModelRenderer(this, 350, 110);
        this.GLASS.setRotationPoint(-18.0F, -20.5F, -15.0F);
        this.GLASS.addBox(0.0F, 0.0F, 0.0F, 35, 32, 15, 0.0F);
        this.T_PLATE_1 = new ModelRenderer(this, 0, 290);
        this.T_PLATE_1.setRotationPoint(-14.5F, -25.0F, -10.0F);
        this.T_PLATE_1.addBox(0.0F, 0.0F, 0.0F, 63, 20, 95, 0.0F);
        this.R_SEAT_HOLDER_L_T_1 = new ModelRenderer(this, 240, 90);
        this.R_SEAT_HOLDER_L_T_1.setRotationPoint(8.9F, -0.5F, -0.5F);
        this.R_SEAT_HOLDER_L_T_1.addBox(0.0F, 0.0F, 0.0F, 2, 10, 2, 0.0F);
        this.L_PLATE = new ModelRenderer(this, 0, 75);
        this.L_PLATE.setRotationPoint(35.0F, 0.0F, 0.0F);
        this.L_PLATE.addBox(0.0F, 0.0F, 0.0F, 10, 32, 75, 0.0F);
        this.R_SEAT_BASE_1 = new ModelRenderer(this, 250, 0);
        this.R_SEAT_BASE_1.setRotationPoint(31.0F, -1.0F, 8.0F);
        this.R_SEAT_BASE_1.addBox(0.0F, 0.0F, 0.0F, 12, 2, 12, 0.0F);
        this.LIGHT_R_T = new ModelRenderer(this, 450, 0);
        this.LIGHT_R_T.setRotationPoint(2.0F, 2.0F, -1.0F);
        this.LIGHT_R_T.addBox(0.0F, 0.0F, 0.0F, 11, 16, 2, 0.0F);
        this.HOLDER_R_B = new ModelRenderer(this, 200, 420);
        this.HOLDER_R_B.mirror = true;
        this.HOLDER_R_B.setRotationPoint(-10.0F, -2.5F, -1.6F);
        this.HOLDER_R_B.addBox(0.0F, 0.0F, 0.0F, 15, 20, 24, 0.0F);
        this.R_SEAT_HOLDER_L_1 = new ModelRenderer(this, 250, 75);
        this.R_SEAT_HOLDER_L_1.setRotationPoint(8.7F, -0.5F, -0.5F);
        this.R_SEAT_HOLDER_L_1.addBox(0.0F, 0.0F, 0.0F, 2, 2, 10, 0.0F);
        this.R_PLATE = new ModelRenderer(this, 0, 75);
        this.R_PLATE.mirror = true;
        this.R_PLATE.setRotationPoint(-10.0F, 0.0F, 0.0F);
        this.R_PLATE.addBox(0.0F, 0.0F, 0.0F, 10, 32, 75, 0.0F);
        this.POLE_B_L = new ModelRenderer(this, 300, 300);
        this.POLE_B_L.setRotationPoint(7.0F, 10.0F, 23.5F);
        this.POLE_B_L.addBox(-3.5F, -3.5F, 0.0F, 7, 7, 16, 0.0F);
        this.LIGHT_R_B = new ModelRenderer(this, 450, 0);
        this.LIGHT_R_B.setRotationPoint(2.0F, 2.0F, -1.0F);
        this.LIGHT_R_B.addBox(0.0F, 0.0F, 0.0F, 11, 16, 2, 0.0F);
        this.BOOSTER_T_L_1 = new ModelRenderer(this, 370, 340);
        this.BOOSTER_T_L_1.setRotationPoint(-11.0F, -3.0F, 5.5F);
        this.BOOSTER_T_L_1.addBox(0.0F, 0.0F, 0.0F, 22, 6, 5, 0.0F);
        this.HOLDER_L_B = new ModelRenderer(this, 200, 420);
        this.HOLDER_L_B.setRotationPoint(35.0F, -2.5F, -1.6F);
        this.HOLDER_L_B.addBox(0.0F, 0.0F, 0.0F, 15, 20, 24, 0.0F);
        this.R_SEAT_HOLDER_R_T_1 = new ModelRenderer(this, 240, 90);
        this.R_SEAT_HOLDER_R_T_1.setRotationPoint(-0.9F, -0.5F, -0.5F);
        this.R_SEAT_HOLDER_R_T_1.addBox(0.0F, 0.0F, 0.0F, 2, 10, 2, 0.0F);
        this.R_SEAT_BASE = new ModelRenderer(this, 250, 0);
        this.R_SEAT_BASE.setRotationPoint(12.0F, -1.0F, 8.0F);
        this.R_SEAT_BASE.addBox(0.0F, 0.0F, 0.0F, 12, 2, 12, 0.0F);
        this.R_SEAT_BASE_T_1 = new ModelRenderer(this, 250, 125);
        this.R_SEAT_BASE_T_1.setRotationPoint(0.0F, -8.1F, 10.6F);
        this.R_SEAT_BASE_T_1.addBox(0.0F, 0.0F, 0.0F, 10, 10, 2, 0.0F);
        this.setRotateAngle(R_SEAT_BASE_T_1, -0.3490658503988659F, 0.0F, 0.0F);
        this.LIGHT_L_T = new ModelRenderer(this, 450, 0);
        this.LIGHT_L_T.setRotationPoint(2.0F, 2.0F, -1.0F);
        this.LIGHT_L_T.addBox(0.0F, 0.0F, 0.0F, 11, 16, 2, 0.0F);
        this.LIGHT_L_B = new ModelRenderer(this, 450, 0);
        this.LIGHT_L_B.setRotationPoint(2.0F, 2.0F, -1.0F);
        this.LIGHT_L_B.addBox(0.0F, 0.0F, 0.0F, 11, 16, 2, 0.0F);
        this.R_SEAT_POLE_1 = new ModelRenderer(this, 250, 25);
        this.R_SEAT_POLE_1.setRotationPoint(3.0F, -7.5F, 3.0F);
        this.R_SEAT_POLE_1.addBox(0.0F, 0.0F, 0.0F, 6, 8, 6, 0.0F);
        this.HOLDER_L_T = new ModelRenderer(this, 200, 420);
        this.HOLDER_L_T.setRotationPoint(35.0F, -2.5F, -1.6F);
        this.HOLDER_L_T.addBox(0.0F, 0.0F, 0.0F, 15, 20, 24, 0.0F);
        this.BOOSTER_B_L_1 = new ModelRenderer(this, 370, 340);
        this.BOOSTER_B_L_1.setRotationPoint(-11.0F, -3.0F, 5.5F);
        this.BOOSTER_B_L_1.addBox(0.0F, 0.0F, 0.0F, 22, 6, 5, 0.0F);
        this.T_R_ARM = new ModelRenderer(this, 300, 420);
        this.T_R_ARM.setRotationPoint(-23.8F, -20.0F, 30.0F);
        this.T_R_ARM.addBox(0.0F, 0.0F, 0.0F, 40, 15, 15, 0.0F);
        this.setRotateAngle(T_R_ARM, 0.0F, 0.08726646259971647F, 0.6108652381980153F);
        this.R_SEAT_BASE_T = new ModelRenderer(this, 250, 125);
        this.R_SEAT_BASE_T.setRotationPoint(0.0F, -8.1F, 10.6F);
        this.R_SEAT_BASE_T.addBox(0.0F, 0.0F, 0.0F, 10, 10, 2, 0.0F);
        this.setRotateAngle(R_SEAT_BASE_T, -0.3490658503988659F, 0.0F, 0.0F);
        this.R_T_PLATE_B = new ModelRenderer(this, 0, 320);
        this.R_T_PLATE_B.setRotationPoint(-21.5F, -13.5F, 56.5F);
        this.R_T_PLATE_B.addBox(0.0F, 0.0F, 0.0F, 20, 20, 24, 0.0F);
        this.HOLDER_R_T = new ModelRenderer(this, 200, 420);
        this.HOLDER_R_T.mirror = true;
        this.HOLDER_R_T.setRotationPoint(-10.0F, -2.5F, -1.6F);
        this.HOLDER_R_T.addBox(0.0F, 0.0F, 0.0F, 15, 20, 24, 0.0F);
        this.R_SEAT_POLE = new ModelRenderer(this, 250, 25);
        this.R_SEAT_POLE.setRotationPoint(3.0F, -7.5F, 3.0F);
        this.R_SEAT_POLE.addBox(0.0F, 0.0F, 0.0F, 6, 8, 6, 0.0F);
        this.BOOSTER_T_L_2 = new ModelRenderer(this, 300, 340);
        this.BOOSTER_T_L_2.setRotationPoint(3.0F, -10.5F, 5.5F);
        this.BOOSTER_T_L_2.addBox(0.0F, 0.0F, 0.0F, 22, 6, 5, 0.0F);
        this.setRotateAngle(BOOSTER_T_L_2, 0.0F, 0.0F, 1.5707963267948966F);
        this.T_L_ARM = new ModelRenderer(this, 300, 420);
        this.T_L_ARM.setRotationPoint(1.5F, 2.0F, 30.0F);
        this.T_L_ARM.addBox(0.0F, 0.0F, 0.0F, 40, 15, 15, 0.0F);
        this.setRotateAngle(T_L_ARM, 0.0F, -0.08726646259971647F, -0.6108652381980153F);
        this.R_T_PLATE = new ModelRenderer(this, 0, 320);
        this.R_T_PLATE.mirror = true;
        this.R_T_PLATE.setRotationPoint(-21.5F, -13.5F, -5.5F);
        this.R_T_PLATE.addBox(0.0F, 0.0F, 0.0F, 20, 20, 24, 0.0F);
        this.L_BAR = new ModelRenderer(this, 0, 410);
        this.L_BAR.setRotationPoint(13.0F, 1.0F, 23.5F);
        this.L_BAR.addBox(0.0F, 0.0F, 0.0F, 6, 18, 39, 0.0F);
        this.R_SEAT_HOLDER_L_T = new ModelRenderer(this, 240, 90);
        this.R_SEAT_HOLDER_L_T.setRotationPoint(8.9F, -0.5F, -0.5F);
        this.R_SEAT_HOLDER_L_T.addBox(0.0F, 0.0F, 0.0F, 2, 10, 2, 0.0F);
        this.L_R_ARM = new ModelRenderer(this, 300, 420);
        this.L_R_ARM.setRotationPoint(-33.2F, 30.0F, 30.0F);
        this.L_R_ARM.addBox(0.0F, 0.0F, 0.0F, 40, 15, 15, 0.0F);
        this.setRotateAngle(L_R_ARM, 0.0F, 0.08726646259971647F, -0.5235987755982988F);
        this.R_BAR = new ModelRenderer(this, 0, 410);
        this.R_BAR.setRotationPoint(1.0F, 1.0F, 23.5F);
        this.R_BAR.addBox(0.0F, 0.0F, 0.0F, 6, 18, 39, 0.0F);
        this.T_PLATE = new ModelRenderer(this, 0, 200);
        this.T_PLATE.setRotationPoint(-10.0F, -10.0F, 0.0F);
        this.T_PLATE.addBox(0.0F, 0.0F, 0.0F, 55, 10, 75, 0.0F);
        this.B_PLATE = new ModelRenderer(this, 0, 200);
        this.B_PLATE.setRotationPoint(-10.0F, 32.0F, 0.0F);
        this.B_PLATE.addBox(0.0F, 0.0F, 0.0F, 55, 10, 75, 0.0F);
        this.R_SEAT_BASE_2 = new ModelRenderer(this, 250, 55);
        this.R_SEAT_BASE_2.setRotationPoint(-2.0F, -1.5F, -2.0F);
        this.R_SEAT_BASE_2.addBox(0.0F, 0.0F, 0.0F, 10, 2, 10, 0.0F);
        this.BOOSTER_T_R_1 = new ModelRenderer(this, 300, 340);
        this.BOOSTER_T_R_1.setRotationPoint(-11.0F, -3.0F, 5.5F);
        this.BOOSTER_T_R_1.addBox(0.0F, 0.0F, 0.0F, 22, 6, 5, 0.0F);
        this.R_SEAT_HOLDER_R = new ModelRenderer(this, 250, 75);
        this.R_SEAT_HOLDER_R.setRotationPoint(-0.7F, -0.5F, -0.5F);
        this.R_SEAT_HOLDER_R.addBox(0.0F, 0.0F, 0.0F, 2, 2, 10, 0.0F);
        this.POLE_B_R = new ModelRenderer(this, 300, 300);
        this.POLE_B_R.setRotationPoint(7.0F, 10.0F, 23.5F);
        this.POLE_B_R.addBox(-3.5F, -3.5F, 0.0F, 7, 7, 16, 0.0F);
        this.R_SEAT_HOLDER_R_1 = new ModelRenderer(this, 250, 75);
        this.R_SEAT_HOLDER_R_1.setRotationPoint(-0.7F, -0.5F, -0.5F);
        this.R_SEAT_HOLDER_R_1.addBox(0.0F, 0.0F, 0.0F, 2, 2, 10, 0.0F);
        this.BOOSTER_T_R_2 = new ModelRenderer(this, 370, 340);
        this.BOOSTER_T_R_2.setRotationPoint(3.0F, -10.5F, 5.5F);
        this.BOOSTER_T_R_2.addBox(0.0F, 0.0F, 0.0F, 22, 6, 5, 0.0F);
        this.setRotateAngle(BOOSTER_T_R_2, 0.0F, 0.0F, 1.5707963267948966F);
        this.R_SEAT_BASE_3 = new ModelRenderer(this, 250, 55);
        this.R_SEAT_BASE_3.setRotationPoint(-2.0F, -1.5F, -2.0F);
        this.R_SEAT_BASE_3.addBox(0.0F, 0.0F, 0.0F, 10, 2, 10, 0.0F);
        this.R_SEAT_HOLDER_R_T = new ModelRenderer(this, 240, 90);
        this.R_SEAT_HOLDER_R_T.setRotationPoint(-0.9F, -0.5F, -0.5F);
        this.R_SEAT_HOLDER_R_T.addBox(0.0F, 0.0F, 0.0F, 2, 10, 2, 0.0F);
        this.B_PLATE_1 = new ModelRenderer(this, 0, 0);
        this.B_PLATE_1.setRotationPoint(0.0F, 8.3F, 68.0F);
        this.B_PLATE_1.addBox(0.0F, 0.0F, 0.0F, 55, 10, 56, 0.0F);
        this.setRotateAngle(B_PLATE_1, 1.4922565104551517F, 0.0F, 0.0F);
        this.BOOSTER_B_R_2 = new ModelRenderer(this, 370, 340);
        this.BOOSTER_B_R_2.setRotationPoint(3.0F, -10.5F, 5.5F);
        this.BOOSTER_B_R_2.addBox(0.0F, 0.0F, 0.0F, 22, 6, 5, 0.0F);
        this.setRotateAngle(BOOSTER_B_R_2, 0.0F, 0.0F, 1.5707963267948966F);
        this.CANNON_R = new ModelRenderer(this, 0, 100);
        this.CANNON_R.setRotationPoint(-1.0F, -2.5F, -12.0F);
        this.CANNON_R.addBox(0.0F, 0.0F, 0.0F, 10, 10, 25, 0.0F);
        this.setRotateAngle(CANNON_R, 0.0F, 0.017453292519943295F, 0.7740535232594852F);
        this.FIN_M = new ModelRenderer(this, 200, 190);
        this.FIN_M.setRotationPoint(23.0F, 4.0F, 62.0F);
        this.FIN_M.addBox(0.0F, 0.0F, 0.0F, 16, 20, 60, 0.0F);
        this.setRotateAngle(FIN_M, 0.7853981633974483F, 0.0F, 0.0F);
        this.POLE_T_R = new ModelRenderer(this, 300, 300);
        this.POLE_T_R.setRotationPoint(7.0F, 10.0F, 23.5F);
        this.POLE_T_R.addBox(-3.5F, -3.5F, 0.0F, 7, 7, 16, 0.0F);
        this.POLE_T_L = new ModelRenderer(this, 300, 300);
        this.POLE_T_L.setRotationPoint(7.0F, 10.0F, 23.5F);
        this.POLE_T_L.addBox(-3.5F, -3.5F, 0.0F, 7, 7, 16, 0.0F);
        this.B_L_ARM = new ModelRenderer(this, 300, 420);
        this.B_L_ARM.setRotationPoint(9.5F, 10.0F, 30.0F);
        this.B_L_ARM.addBox(0.0F, 0.0F, 0.0F, 40, 15, 15, 0.0F);
        this.setRotateAngle(B_L_ARM, 0.0F, -0.08726646259971647F, 0.5235987755982988F);
        this.shape83 = new ModelRenderer(this, 330, 3);
        this.shape83.setRotationPoint(10.0F, -12.0F, 0.5F);
        this.shape83.addBox(0.0F, 0.0F, 0.0F, 35, 13, 3, 0.0F);
        this.setRotateAngle(shape83, 0.2617993877991494F, 0.0F, 0.0F);
        this.BOOSTER_B_R_1 = new ModelRenderer(this, 300, 340);
        this.BOOSTER_B_R_1.setRotationPoint(-11.0F, -3.0F, 5.5F);
        this.BOOSTER_B_R_1.addBox(0.0F, 0.0F, 0.0F, 22, 6, 5, 0.0F);
        this.R_SEAT_BASE_2.addChild(this.R_SEAT_HOLDER_L);
        this.B_PLATE.addChild(this.CANNON_R_1);
        this.GLASS.addChild(this.L_T_PLATE);
        this.GLASS.addChild(this.R_T_PLATE_B_1);
        this.POLE_B_L.addChild(this.BOOSTER_B_L_2);
        this.GLASS.addChild(this.T_PLATE_1);
        this.R_SEAT_BASE_T_1.addChild(this.R_SEAT_HOLDER_L_T_1);
        this.GLASS.addChild(this.L_PLATE);
        this.B_PLATE.addChild(this.R_SEAT_BASE_1);
        this.HOLDER_R_T.addChild(this.LIGHT_R_T);
        this.L_R_ARM.addChild(this.HOLDER_R_B);
        this.R_SEAT_BASE_3.addChild(this.R_SEAT_HOLDER_L_1);
        this.GLASS.addChild(this.R_PLATE);
        this.HOLDER_L_B.addChild(this.POLE_B_L);
        this.HOLDER_R_B.addChild(this.LIGHT_R_B);
        this.POLE_T_L.addChild(this.BOOSTER_T_L_1);
        this.B_L_ARM.addChild(this.HOLDER_L_B);
        this.R_SEAT_BASE_T_1.addChild(this.R_SEAT_HOLDER_R_T_1);
        this.B_PLATE.addChild(this.R_SEAT_BASE);
        this.R_SEAT_BASE_3.addChild(this.R_SEAT_BASE_T_1);
        this.HOLDER_L_T.addChild(this.LIGHT_L_T);
        this.HOLDER_L_B.addChild(this.LIGHT_L_B);
        this.R_SEAT_BASE_1.addChild(this.R_SEAT_POLE_1);
        this.T_L_ARM.addChild(this.HOLDER_L_T);
        this.POLE_B_L.addChild(this.BOOSTER_B_L_1);
        this.R_PLATE.addChild(this.T_R_ARM);
        this.R_SEAT_BASE_2.addChild(this.R_SEAT_BASE_T);
        this.GLASS.addChild(this.R_T_PLATE_B);
        this.T_R_ARM.addChild(this.HOLDER_R_T);
        this.R_SEAT_BASE.addChild(this.R_SEAT_POLE);
        this.POLE_T_L.addChild(this.BOOSTER_T_L_2);
        this.L_PLATE.addChild(this.T_L_ARM);
        this.GLASS.addChild(this.R_T_PLATE);
        this.L_T_PLATE.addChild(this.L_BAR);
        this.R_SEAT_BASE_T.addChild(this.R_SEAT_HOLDER_L_T);
        this.R_PLATE.addChild(this.L_R_ARM);
        this.R_T_PLATE.addChild(this.R_BAR);
        this.GLASS.addChild(this.T_PLATE);
        this.GLASS.addChild(this.B_PLATE);
        this.R_SEAT_POLE.addChild(this.R_SEAT_BASE_2);
        this.POLE_T_R.addChild(this.BOOSTER_T_R_1);
        this.R_SEAT_BASE_2.addChild(this.R_SEAT_HOLDER_R);
        this.HOLDER_R_B.addChild(this.POLE_B_R);
        this.R_SEAT_BASE_3.addChild(this.R_SEAT_HOLDER_R_1);
        this.POLE_T_R.addChild(this.BOOSTER_T_R_2);
        this.R_SEAT_POLE_1.addChild(this.R_SEAT_BASE_3);
        this.R_SEAT_BASE_T.addChild(this.R_SEAT_HOLDER_R_T);
        this.B_PLATE.addChild(this.B_PLATE_1);
        this.POLE_B_R.addChild(this.BOOSTER_B_R_2);
        this.B_PLATE.addChild(this.CANNON_R);
        this.T_PLATE_1.addChild(this.FIN_M);
        this.HOLDER_R_T.addChild(this.POLE_T_R);
        this.HOLDER_L_T.addChild(this.POLE_T_L);
        this.L_PLATE.addChild(this.B_L_ARM);
        this.B_PLATE.addChild(this.shape83);
        this.POLE_B_R.addChild(this.BOOSTER_B_R_1);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.GLASS.render(f5);
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
    	this.B_PLATE.rotateAngleX = netHeadYaw * 0.017453292F;
    }
    
    private float updateRotations(float p_110683_1_, float p_110683_2_, float p_110683_3_)
    {
        float f;

        for (f = p_110683_2_ - p_110683_1_; f < -180.0F; f += 360.0F)
        {
            ;
        }

        while (f >= 180.0F)
        {
            f -= 360.0F;
        }

        return p_110683_1_ + p_110683_3_ * f;
    }
    
    public void setLivingAnimations(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTickTime)
    {
        super.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTickTime);
        float f = this.updateRotations(entitylivingbaseIn.prevRenderYawOffset, entitylivingbaseIn.renderYawOffset, partialTickTime);
        float f1 = this.updateRotations(entitylivingbaseIn.prevRotationYawHead, entitylivingbaseIn.rotationYawHead, partialTickTime);
        float f2 = entitylivingbaseIn.prevRotationPitch + (entitylivingbaseIn.rotationPitch - entitylivingbaseIn.prevRotationPitch) * partialTickTime;
        float f3 = f1 - f;
        float f4 = f2 * 0.017453292F;
        
        if (f3 > 20.0F)
        {
            f3 = 20.0F;
        }

        if (f3 < -20.0F)
        {
            f3 = -20.0F;
        }

        if (limbSwingAmount > 0.2F)
        {
            f4 += MathHelper.cos(limbSwing * 0.4F) * 0.15F * limbSwingAmount;
        }

        AbstractSubmarine sub = (AbstractSubmarine)entitylivingbaseIn;
        float f7 = 1.0F;
        boolean flag2 = sub.isBeingRidden();
        float f9 = (float)entitylivingbaseIn.ticksExisted + partialTickTime;
        float f9_2 = (float)entitylivingbaseIn.ticksExisted + partialTickTime - 0.4F;
        float f9_3 = (float)entitylivingbaseIn.ticksExisted + partialTickTime - 2.6F;
        float f10 = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI);
        float f11 = f10 * 0.8F * limbSwingAmount;
        float f666 = sub.getBoosterAnimation(f);
       
        
        if(!sub.isMoving()) {
            this.POLE_T_L.rotateAngleZ = 0;
            this.POLE_B_L.rotateAngleZ = 0;
            this.POLE_T_R.rotateAngleZ = 0;
            this.POLE_B_R.rotateAngleZ = 0;
        }
        if(sub.isMoving() && sub.isInWater()) {
        	this.POLE_T_L.rotateAngleZ = f9_2;
        	this.POLE_B_L.rotateAngleZ = f9_2;
        	this.POLE_T_R.rotateAngleZ = f9_2;
        	this.POLE_B_R.rotateAngleZ = f9_2;
        	if(sub.isBeingRidden()) {
        		this.POLE_T_L.rotateAngleZ = f9;
        		this.POLE_B_L.rotateAngleZ = f9;
        		this.POLE_T_R.rotateAngleZ = f9;
        		this.POLE_B_R.rotateAngleZ = f9;
        	}
        }
        
        if(this.hasCannons == true) {
        	this.CANNON_R.showModel = false;
        	this.CANNON_R_1.showModel = false;
        }
    }
}
