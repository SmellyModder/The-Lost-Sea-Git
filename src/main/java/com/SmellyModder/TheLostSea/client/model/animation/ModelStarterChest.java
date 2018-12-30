package com.SmellyModder.TheLostSea.client.model.animation;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelRewardChest - SmellyModder
 * Created using Tabula 7.0.0
 */

public class ModelStarterChest extends ModelBase {
    public ModelRenderer base;
    public ModelRenderer shape1;
    public ModelRenderer shape2;
    public ModelRenderer shape3;
    public ModelRenderer shape4;
    public ModelRenderer shape5;
    public ModelRenderer shape6;
    public ModelRenderer shape7;
    public ModelRenderer shape8;
    public ModelRenderer shape9;
    public ModelRenderer shape10;
    public ModelRenderer shape11;
    public ModelRenderer shape12;
    public ModelRenderer handle;
    public ModelRenderer shape17;
    public ModelRenderer shape21;
    public ModelRenderer shape21_1;
    public ModelRenderer shape21_2;
    public ModelRenderer shape21_3;
    public ModelRenderer lock;
    public ModelRenderer shape19;
    public ModelRenderer shape19_1;
    public ModelRenderer shape21_4;
    public ModelRenderer shape21_5;
    public ModelRenderer shape21_6;
    public ModelRenderer shape21_7;
    public ModelRenderer shape21_8;
    public ModelRenderer shapeN;
    public ModelRenderer shape21_9;
    public ModelRenderer shape21_10;
    public ModelRenderer shape21_11;

    public ModelStarterChest() {
        this.textureWidth = 100;
        this.textureHeight = 100;
        this.shape21_2 = new ModelRenderer(this, 26, 50);
        this.shape21_2.setRotationPoint(14.0F, -9.7F, -14.15F);
        this.shape21_2.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
        this.setRotateAngle(shape21_2, -0.22759093446006054F, 0.0F, 0.0F);
        this.shape21_10 = new ModelRenderer(this, 18, 80);
        this.shape21_10.setRotationPoint(2.0F, 0.0F, 0.3F);
        this.shape21_10.addBox(0.0F, 0.0F, 0.0F, 12, 12, 1, 0.0F);
        this.shape8 = new ModelRenderer(this, 0, 44);
        this.shape8.setRotationPoint(1.0F, 7.0F, -0.8F);
        this.shape8.addBox(0.0F, 0.0F, 0.0F, 12, 2, 1, 0.0F);
        this.shape21_7 = new ModelRenderer(this, 0, 23);
        this.shape21_7.setRotationPoint(-12.1F, 0.4F, 10.7F);
        this.shape21_7.addBox(0.0F, 0.0F, 0.0F, 12, 6, 1, 0.0F);
        this.setRotateAngle(shape21_7, 0.22759093446006054F, 0.0F, 0.0F);
        this.shape21_3 = new ModelRenderer(this, 18, 50);
        this.shape21_3.setRotationPoint(0.0F, -9.7F, -14.15F);
        this.shape21_3.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
        this.setRotateAngle(shape21_3, -0.22759093446006054F, 0.0F, 0.0F);
        this.shape1 = new ModelRenderer(this, 55, 46);
        this.shape1.setRotationPoint(-0.8F, 0.0F, 0.5F);
        this.shape1.addBox(0.0F, 0.0F, 0.5F, 1, 2, 12, 0.0F);
        this.base = new ModelRenderer(this, 0, 0);
        this.base.setRotationPoint(1.0F, 7.0F, 1.0F);
        this.base.addBox(0.0F, 1.0F, 0.0F, 14, 8, 14, 0.0F);
        this.shape12 = new ModelRenderer(this, 0, 32);
        this.shape12.setRotationPoint(1.0F, 7.0F, 13.7F);
        this.shape12.addBox(0.0F, 0.0F, 0.0F, 12, 2, 1, 0.0F);
        this.shape2 = new ModelRenderer(this, 42, 62);
        this.shape2.setRotationPoint(-0.9F, 7.0F, -0.5F);
        this.shape2.addBox(0.0F, 0.0F, 0.5F, 1, 2, 14, 0.0F);
        this.shape9 = new ModelRenderer(this, 36, 55);
        this.shape9.mirror = true;
        this.shape9.setRotationPoint(1.0F, 0.0F, 13.7F);
        this.shape9.addBox(0.0F, 0.0F, 0.0F, 12, 2, 1, 0.0F);
        this.shape19_1 = new ModelRenderer(this, 56, 15);
        this.shape19_1.setRotationPoint(14.0F, 0.0F, 2.0F);
        this.shape19_1.addBox(0.0F, 0.0F, 0.0F, 2, 2, 12, 0.0F);
        this.shape21_6 = new ModelRenderer(this, 27, 22);
        this.shape21_6.setRotationPoint(0.1F, -0.9F, -10.2F);
        this.shape21_6.addBox(0.0F, 0.0F, 0.0F, 1, 7, 12, 0.0F);
        this.setRotateAngle(shape21_6, -0.22759093446006054F, 0.0F, 0.0F);
        this.shape21_9 = new ModelRenderer(this, 0, 23);
        this.shape21_9.setRotationPoint(-12.0F, 1.9F, 1.0F);
        this.shape21_9.addBox(0.0F, 0.0F, 0.0F, 12, 6, 1, 0.0F);
        this.shape5 = new ModelRenderer(this, 0, 40);
        this.shape5.mirror = true;
        this.shape5.setRotationPoint(1.0F, 0.0F, -0.8F);
        this.shape5.addBox(0.0F, 0.0F, 0.0F, 12, 2, 1, 0.0F);
        this.shape21_5 = new ModelRenderer(this, 27, 22);
        this.shape21_5.setRotationPoint(-1.1F, -0.9F, -10.2F);
        this.shape21_5.addBox(0.0F, 0.0F, 0.0F, 1, 7, 12, 0.0F);
        this.setRotateAngle(shape21_5, -0.22759093446006054F, 0.0F, 0.0F);
        this.shape21_8 = new ModelRenderer(this, 8, 68);
        this.shape21_8.setRotationPoint(-0.05F, -2.7F, 11.7F);
        this.shape21_8.addBox(0.0F, 0.0F, 0.0F, 2, 12, 2, 0.0F);
        this.setRotateAngle(shape21_8, -1.3519320385948075F, 0.0F, 0.0F);
        this.shape7 = new ModelRenderer(this, 0, 47);
        this.shape7.setRotationPoint(-1.0F, 0.0F, -1.0F);
        this.shape7.addBox(0.0F, 0.0F, 0.0F, 2, 9, 2, 0.0F);
        this.shape11 = new ModelRenderer(this, 0, 82);
        this.shape11.setRotationPoint(-1.0F, 0.0F, 13.0F);
        this.shape11.addBox(0.0F, 0.0F, 0.0F, 2, 9, 2, 0.0F);
        this.shape21 = new ModelRenderer(this, 8, 58);
        this.shape21.setRotationPoint(0.0F, -9.3F, -3.75F);
        this.shape21.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
        this.setRotateAngle(shape21, 0.22759093446006054F, 0.0F, 0.0F);
        this.shape3 = new ModelRenderer(this, 16, 60);
        this.shape3.mirror = true;
        this.shape3.setRotationPoint(13.8F, 0.0F, 1.0F);
        this.shape3.addBox(0.0F, 0.0F, 0.0F, 1, 2, 12, 0.0F);
        this.shape10 = new ModelRenderer(this, 8, 82);
        this.shape10.setRotationPoint(13.0F, 0.0F, 13.0F);
        this.shape10.addBox(0.0F, 0.0F, 0.0F, 2, 9, 2, 0.0F);
        this.setRotateAngle(shape10, 0.0F, 0.01884955592153876F, 0.0F);
        this.shape6 = new ModelRenderer(this, 8, 47);
        this.shape6.setRotationPoint(13.0F, 0.0F, -1.0F);
        this.shape6.addBox(0.0F, 0.0F, 0.0F, 2, 9, 2, 0.0F);
        this.shape4 = new ModelRenderer(this, 56, 0);
        this.shape4.setRotationPoint(13.8F, 7.0F, 1.0F);
        this.shape4.addBox(0.0F, 0.0F, 0.0F, 1, 2, 13, 0.0F);
        this.shape19 = new ModelRenderer(this, 72, 34);
        this.shape19.setRotationPoint(0.0F, 0.0F, 2.0F);
        this.shape19.addBox(0.0F, 0.0F, 0.0F, 2, 2, 12, 0.0F);
        this.handle = new ModelRenderer(this, 55, 30);
        this.handle.setRotationPoint(-1.0F, 0.1F, 14.9F);
        this.handle.addBox(0.0F, -2.0F, -2.0F, 16, 2, 2, 0.0F);
        this.shape17 = new ModelRenderer(this, 28, 41);
        this.shape17.setRotationPoint(0.0F, -2.0F, -16.0F);
        this.shape17.addBox(0.0F, 0.0F, 0.0F, 16, 2, 2, 0.0F);
        this.shape21_11 = new ModelRenderer(this, 28, 45);
        this.shape21_11.setRotationPoint(2.0F, -0.1F, 0.0F);
        this.shape21_11.addBox(0.0F, 0.0F, 0.0F, 12, 2, 2, 0.0F);
        this.shapeN = new ModelRenderer(this, 0, 68);
        this.shapeN.setRotationPoint(-13.95F, -2.7F, 11.8F);
        this.shapeN.addBox(0.0F, 0.0F, 0.0F, 2, 12, 2, 0.0F);
        this.setRotateAngle(shapeN, -1.3519320385948075F, 0.0F, 0.0F);
        this.shape21_1 = new ModelRenderer(this, 0, 58);
        this.shape21_1.setRotationPoint(14.0F, -9.3F, -3.75F);
        this.shape21_1.addBox(0.0F, 0.0F, 0.0F, 2, 8, 2, 0.0F);
        this.setRotateAngle(shape21_1, 0.22759093446006054F, 0.0F, 0.0F);
        this.lock = new ModelRenderer(this, 43, 3);
        this.lock.setRotationPoint(6.5F, 0.2F, -0.5F);
        this.lock.addBox(0.0F, -0.4F, 0.0F, 3, 4, 2, 0.0F);
        this.shape21_4 = new ModelRenderer(this, 28, 45);
        this.shape21_4.mirror = true;
        this.shape21_4.setRotationPoint(2.0F, 0.0F, 0.0F);
        this.shape21_4.addBox(0.0F, 0.0F, 0.0F, 12, 2, 2, 0.0F);
        this.handle.addChild(this.shape21_2);
        this.shapeN.addChild(this.shape21_10);
        this.base.addChild(this.shape8);
        this.shape21_6.addChild(this.shape21_7);
        this.handle.addChild(this.shape21_3);
        this.base.addChild(this.shape1);
        this.base.addChild(this.shape12);
        this.base.addChild(this.shape2);
        this.base.addChild(this.shape9);
        this.shape17.addChild(this.shape19_1);
        this.shape21_1.addChild(this.shape21_6);
        this.shape21_2.addChild(this.shape21_9);
        this.base.addChild(this.shape5);
        this.shape21_4.addChild(this.shape21_5);
        this.shape21_2.addChild(this.shape21_8);
        this.base.addChild(this.shape7);
        this.base.addChild(this.shape11);
        this.handle.addChild(this.shape21);
        this.base.addChild(this.shape3);
        this.base.addChild(this.shape10);
        this.base.addChild(this.shape6);
        this.base.addChild(this.shape4);
        this.shape17.addChild(this.shape19);
        this.base.addChild(this.handle);
        this.handle.addChild(this.shape17);
        this.shape21_3.addChild(this.shape21_11);
        this.shape21_2.addChild(this.shapeN);
        this.handle.addChild(this.shape21_1);
        this.shape17.addChild(this.lock);
        this.shape21.addChild(this.shape21_4);
    }

    //@Override
    //public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        //this.base.render(f5);
    //}
    public void renderAll()
    {
    	this.base.render(0.0625F);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
