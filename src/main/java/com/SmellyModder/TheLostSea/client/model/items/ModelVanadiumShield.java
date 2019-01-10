package com.SmellyModder.TheLostSea.client.model.items;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelVShield - SmellyModder
 * Created using Tabula 7.0.0
 */
public class ModelVanadiumShield extends ModelLSShield {
    public ModelRenderer handle;
    public ModelRenderer plate;
    public ModelRenderer shape4;
    public ModelRenderer shape4_1;
    public ModelRenderer shape8;
    public ModelRenderer shape6;
    public ModelRenderer shape6_1;

    public ModelVanadiumShield() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.shape6 = new ModelRenderer(this, 0, 20);
        this.shape6.setRotationPoint(-0.5F, -5.5F, -0.5F);
        this.shape6.addBox(0.0F, 0.0F, 0.0F, 13, 2, 3, 0.0F);
        this.plate = new ModelRenderer(this, 16, 0);
        this.plate.setRotationPoint(-5.0F, -3.0F, -2.0F);
        this.plate.addBox(0.0F, 0.0F, 0.0F, 12, 11, 2, 0.0F);
        this.handle = new ModelRenderer(this, 0, 0);
        this.handle.setRotationPoint(-1.0F, -3.0F, -1.0F);
        this.handle.addBox(0.0F, 0.0F, 0.0F, 2, 6, 6, 0.0F);
        this.shape4_1 = new ModelRenderer(this, 28, 13);
        this.shape4_1.setRotationPoint(0.0F, 11.0F, 0.0F);
        this.shape4_1.addBox(0.0F, 0.0F, 0.0F, 12, 5, 2, 0.0F);
        this.setRotateAngle(shape4_1, 0.06283185307179587F, 0.0F, 0.0F);
        this.shape8 = new ModelRenderer(this, 44, 0);
        this.shape8.setRotationPoint(6.0F, 5.5F, -0.8F);
        this.shape8.addBox(-2.0F, -2.0F, 0.0F, 4, 4, 1, 0.0F);
        this.setRotateAngle(shape8, 0.0F, 0.0F, 0.7853981633974483F);
        this.shape6_1 = new ModelRenderer(this, 29, 22);
        this.shape6_1.setRotationPoint(-0.5F, 4.0F, -0.5F);
        this.shape6_1.addBox(0.0F, 0.0F, 0.0F, 13, 2, 3, 0.0F);
        this.shape4 = new ModelRenderer(this, 0, 13);
        this.shape4.setRotationPoint(0.0F, -0.5F, 0.0F);
        this.shape4.addBox(0.0F, -4.5F, 0.0F, 12, 5, 2, 0.0F);
        this.setRotateAngle(shape4, -0.06283185307179587F, 0.0F, 0.0F);
        this.shape4.addChild(this.shape6);
        this.handle.addChild(this.plate);
        this.plate.addChild(this.shape4_1);
        this.plate.addChild(this.shape8);
        this.shape4_1.addChild(this.shape6_1);
        this.plate.addChild(this.shape4);
    }

    @Override
    public void render() { 
        this.handle.render(0.0625F);
    }
    
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
