package com.SmellyModder.TheLostSea.client.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;

import java.util.Timer;
import java.util.TimerTask;

import org.lwjgl.opengl.GL11;

import com.SmellyModder.TheLostSea.common.entity.coins.EntityAtlantisCoin;
import com.SmellyModder.TheLostSea.core.util.LSMathHelper;

/**
 * ModelACoin - SmellyModder
 * Created using Tabula 7.0.0
 */
public class ModelACoin extends ModelBase {
    public ModelRenderer base;
    public ModelRenderer shape_ba;
    public ModelRenderer shape_bb;
    public ModelRenderer shape_bc;
    public ModelRenderer shape_aa;
    public ModelRenderer shape_c;
    public ModelRenderer shape_c_1;
    public ModelRenderer shape_c_2;
    public ModelRenderer shape_c_3;
    public ModelRenderer shape_x;
    public ModelRenderer shape_x_1;
    public ModelRenderer shape_x_2;
    public ModelRenderer shape_x_3;
    public ModelRenderer shape_x_a;
    public ModelRenderer shape_x_o;
    public ModelRenderer shape_x_c;
    public ModelRenderer shape_x_4;
    public ModelRenderer shape_x_b;
    public ModelRenderer shape_x_5;
    public ModelRenderer shape_e;
    public ModelRenderer shape_e_1;

    public ModelACoin() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.shape_ba = new ModelRenderer(this, 20, 20);
        this.shape_ba.setRotationPoint(-3.0F, 10.0F, -1.5F);
        this.shape_ba.addBox(0.0F, 0.0F, 0.0F, 6, 2, 3, 0.0F);
        this.shape_x_4 = new ModelRenderer(this, 4, 22);
        this.shape_x_4.setRotationPoint(-3.0F, 12.0F, -0.5F);
        this.shape_x_4.addBox(0.0F, 0.0F, 0.0F, 6, 1, 1, 0.0F);
        this.shape_x_5 = new ModelRenderer(this, 27, 4);
        this.shape_x_5.setRotationPoint(-7.0F, 8.0F, -1.5F);
        this.shape_x_5.addBox(0.0F, 0.0F, 0.0F, 2, 2, 3, 0.0F);
        this.shape_c_3 = new ModelRenderer(this, 37, 4);
        this.shape_c_3.setRotationPoint(5.0F, 8.0F, -1.5F);
        this.shape_c_3.addBox(0.0F, 0.0F, 0.0F, 2, 2, 3, 0.0F);
        this.shape_x_3 = new ModelRenderer(this, 27, 9);
        this.shape_x_3.setRotationPoint(-7.0F, 0.0F, -1.5F);
        this.shape_x_3.addBox(0.0F, 0.0F, 0.0F, 2, 2, 3, 0.0F);
        this.shape_x_b = new ModelRenderer(this, 35, 2);
        this.shape_x_b.setRotationPoint(-6.0F, 10.0F, -0.5F);
        this.shape_x_b.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.shape_c_2 = new ModelRenderer(this, 37, 9);
        this.shape_c_2.setRotationPoint(5.0F, 0.0F, -1.5F);
        this.shape_c_2.addBox(0.0F, 0.0F, 0.0F, 2, 2, 3, 0.0F);
        this.shape_x_c = new ModelRenderer(this, 40, 2);
        this.shape_x_c.setRotationPoint(5.0F, 10.0F, -0.5F);
        this.shape_x_c.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.shape_x = new ModelRenderer(this, 4, 22);
        this.shape_x.setRotationPoint(-3.0F, -3.0F, -0.5F);
        this.shape_x.addBox(0.0F, 0.0F, 0.0F, 6, 1, 1, 0.0F);
        this.shape_x_1 = new ModelRenderer(this, 50, 20);
        this.shape_x_1.setRotationPoint(3.0F, -2.0F, -1.5F);
        this.shape_x_1.addBox(0.0F, 0.0F, 0.0F, 2, 2, 3, 0.0F);
        this.shape_bb = new ModelRenderer(this, 10, 13);
        this.shape_bb.setRotationPoint(5.0F, 2.0F, -1.5F);
        this.shape_bb.addBox(0.0F, 0.0F, 0.0F, 2, 6, 3, 0.0F);
        this.shape_x_a = new ModelRenderer(this, 24, 0);
        this.shape_x_a.setRotationPoint(-6.0F, -1.0F, -0.5F);
        this.shape_x_a.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.shape_e = new ModelRenderer(this, 0, 22);
        this.shape_e.setRotationPoint(7.0F, 2.0F, -0.5F);
        this.shape_e.addBox(0.0F, 0.0F, 0.0F, 1, 6, 1, 0.0F);
        this.shape_x_2 = new ModelRenderer(this, 40, 20);
        this.shape_x_2.setRotationPoint(-5.0F, -2.0F, -1.5F);
        this.shape_x_2.addBox(0.0F, 0.0F, 0.0F, 2, 2, 3, 0.0F);
        this.setRotateAngle(shape_x_2, -0.008028514559173916F, 0.0F, 0.0F);
        this.shape_aa = new ModelRenderer(this, 20, 25);
        this.shape_aa.setRotationPoint(-3.0F, -2.0F, -1.5F);
        this.shape_aa.addBox(0.0F, 0.0F, 0.0F, 6, 2, 3, 0.0F);
        this.base = new ModelRenderer(this, 0, 0);
        this.base.setRotationPoint(0.0F, 19.0F, 0.0F);
        this.base.addBox(-5.0F, 0.0F, -1.5F, 10, 10, 3, 0.0F);
        this.shape_bc = new ModelRenderer(this, 0, 13);
        this.shape_bc.setRotationPoint(-7.0F, 2.0F, -1.5F);
        this.shape_bc.addBox(0.0F, 0.0F, 0.0F, 2, 6, 3, 0.0F);
        this.shape_e_1 = new ModelRenderer(this, 0, 22);
        this.shape_e_1.setRotationPoint(-8.0F, 2.0F, -0.5F);
        this.shape_e_1.addBox(0.0F, 0.0F, 0.0F, 1, 6, 1, 0.0F);
        this.shape_x_o = new ModelRenderer(this, 28, 0);
        this.shape_x_o.setRotationPoint(5.0F, -1.0F, -0.5F);
        this.shape_x_o.addBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
        this.shape_c_1 = new ModelRenderer(this, 40, 15);
        this.shape_c_1.setRotationPoint(-5.0F, 10.0F, -1.5F);
        this.shape_c_1.addBox(0.0F, 0.0F, 0.0F, 2, 2, 3, 0.0F);
        this.shape_c = new ModelRenderer(this, 50, 15);
        this.shape_c.setRotationPoint(3.0F, 10.0F, -1.5F);
        this.shape_c.addBox(0.0F, 0.0F, 0.0F, 2, 2, 3, 0.0F);
        this.base.addChild(this.shape_ba);
        this.base.addChild(this.shape_x_4);
        this.base.addChild(this.shape_x_5);
        this.base.addChild(this.shape_c_3);
        this.base.addChild(this.shape_x_3);
        this.base.addChild(this.shape_x_b);
        this.base.addChild(this.shape_c_2);
        this.base.addChild(this.shape_x_c);
        this.base.addChild(this.shape_x);
        this.base.addChild(this.shape_x_1);
        this.base.addChild(this.shape_bb);
        this.base.addChild(this.shape_x_a);
        this.base.addChild(this.shape_e);
        this.base.addChild(this.shape_x_2);
        this.base.addChild(this.shape_aa);
        this.base.addChild(this.shape_bc);
        this.base.addChild(this.shape_e_1);
        this.base.addChild(this.shape_x_o);
        this.base.addChild(this.shape_c_1);
        this.base.addChild(this.shape_c);
    }
    
    

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	EntityAtlantisCoin sub = (EntityAtlantisCoin)entity;
    	
    	double scaleR = 0;
    	int scale = sub.score();
    	if(sub.getCoinType() == EntityAtlantisCoin.Size.SMALL) {
    		scaleR = 0.35D;
    	}else if(sub.getCoinType() == EntityAtlantisCoin.Size.NORMAL) {
    		scaleR = 0.50D;
    	}else if(sub.getCoinType() == EntityAtlantisCoin.Size.LARGE) {
    		scaleR = 0.75D;
    	}else if(sub.getCoinType() == EntityAtlantisCoin.Size.BIG) {
    		scaleR = 1.00D;
    	}else if(sub.getCoinType() == EntityAtlantisCoin.Size.GIANT) {
    		scaleR = 1.25D;
    	}
    	
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.base.offsetX, this.base.offsetY, this.base.offsetZ);
        GlStateManager.translate(this.base.rotationPointX * f5, this.base.rotationPointY * f5, this.base.rotationPointZ * f5);
        GlStateManager.scale(scaleR, scaleR, scaleR);
        GlStateManager.translate(-this.base.offsetX, -this.base.offsetY, -this.base.offsetZ);
        GlStateManager.translate(-this.base.rotationPointX * f5, -this.base.rotationPointY * f5, -this.base.rotationPointZ * f5);
        GlStateManager.translate(0, -0.7, 0);
        GL11.glTranslatef(0, MathHelper.sin(f2 * 0.08f + 0.55F)/8, 0);
        this.base.render(f5);
        GlStateManager.popMatrix();
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    int secondsPassed;
    private Timer counter = new Timer();
    private TimerTask task = new TimerTask() {
		@Override
		public void run() {
			secondsPassed++;
		}
    };
    public void Start() {
    	counter.scheduleAtFixedRate(task, 1000, 1000);
    	System.out.println("oof" + secondsPassed);
    }
    
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,float headPitch, float scaleFactor, Entity entityIn) {
    	super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
    	EntityAtlantisCoin sub = (EntityAtlantisCoin)entityIn;
    	float f9_3 = (float) (90*ageInTicks*0.003);
    	this.base.rotateAngleY = f9_3;
    	if(sub.getBlinkSpeed() == 0) {
    		this.base.isHidden = false;
    	}else {
    		if(sub.getBlinkSpeed() == 3) {
    			this.base.isHidden = true;
    		}
    	}
    }
}
