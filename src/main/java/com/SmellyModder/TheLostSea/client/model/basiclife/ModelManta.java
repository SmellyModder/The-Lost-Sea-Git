package com.SmellyModder.TheLostSea.client.model.basiclife;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelManta extends ModelBase
{
	  ModelRenderer mainbody;
	  ModelRenderer wing_5R;
	  ModelRenderer wing1R;
	  ModelRenderer wing2R;
	  ModelRenderer tail5;
	  ModelRenderer tail1;
	  ModelRenderer tail2;
	  ModelRenderer tail4;
	  ModelRenderer tail3;
	  ModelRenderer fin;
	  ModelRenderer eye3R;
	  ModelRenderer eyeR;
	  ModelRenderer eye2R;
	  ModelRenderer mouth;
	  ModelRenderer eyeL;
	  ModelRenderer eye2L;
	  ModelRenderer eye3L;
	  ModelRenderer wing3R;
	  ModelRenderer wing4R;
	  ModelRenderer wing1L;
	  ModelRenderer wing2L;
	  ModelRenderer wing3L;
	  ModelRenderer wing4l;
	  ModelRenderer wing_5L;
	  
	public ModelManta()
	{
		textureWidth = 128;
		textureHeight = 128;
	    
	    mainbody = new ModelRenderer(this, 0, 26);
	    mainbody.addBox(-8.0F, -2.0F, -5.0F, 16, 5, 20);
	    mainbody.setRotationPoint(0.0F, 0.0F, 0.0F);
	    mainbody.mirror = true;
	    setRotation(mainbody, 0.0F, 0.0F, 0.0F);
	    wing_5R = new ModelRenderer(this, 85, 58);
	    wing_5R.addBox(-6.0F, -0.5F, 0.0F, 2, 1, 4);
	    wing_5R.setRotationPoint(0.0F, 0.0F, 0.0F);
	    wing_5R.mirror = true;
	    setRotation(wing_5R, 0.0F, 0.0F, 0.0F);
	    wing1R = new ModelRenderer(this, 61, 0);
	    wing1R.addBox(-10.0F, -1.0F, -4.0F, 11, 3, 22);
	    wing1R.setRotationPoint(-8.0F, 0.0F, 0.0F);
	    wing1R.mirror = true;
	    setRotation(wing1R, 0.0F, 0.1745329F, 0.0F);
	    wing2R = new ModelRenderer(this, 61, 25);
	    wing2R.addBox(-5.0F, -1.5F, -2.0F, 8, 2, 18);
	    wing2R.setRotationPoint(-12.0F, 1.0F, 0.0F);
	    wing2R.mirror = true;
	    setRotation(wing2R, 0.0F, 0.0F, 0.0F);
	    tail5 = new ModelRenderer(this, 0, 86);
	    tail5.addBox(-0.5F, -0.5F, 0.0F, 1, 1, 25);
	    tail5.setRotationPoint(0.0F, 0.0F, 4.0F);
	    tail5.mirror = true;
	    setRotation(tail5, 0.0F, 0.0F, 0.0F);
	    tail1 = new ModelRenderer(this, 0, 52);
	    tail1.addBox(-9.0F, -2.5F, 0.0F, 18, 4, 6);
	    tail1.setRotationPoint(0.0F, 1.0F, 14.0F);
	    tail1.mirror = true;
	    setRotation(tail1, 0.0F, 0.0F, 0.0F);
	    tail2 = new ModelRenderer(this, 0, 63);
	    tail2.addBox(-5.0F, -1.5F, 0.0F, 10, 3, 4);
	    tail2.setRotationPoint(0.0F, -0.5F, 6.0F);
	    tail2.mirror = true;
	    setRotation(tail2, 0.0F, 0.0F, 0.0F);
	    tail4 = new ModelRenderer(this, 0, 90);
	    tail4.addBox(-1.5F, -0.5F, 0.0F, 3, 1, 4);
	    tail4.setRotationPoint(0.0F, 0.0F, 4.0F);
	    tail4.mirror = true;
	    setRotation(tail4, 0.0F, 0.0F, 0.0F);
	    tail3 = new ModelRenderer(this, 0, 72);
	    tail3.addBox(-3.0F, -1.0F, 0.0F, 6, 2, 4);
	    tail3.setRotationPoint(0.0F, 0.0F, 4.0F);
	    tail3.mirror = true;
	    setRotation(tail3, 0.0F, 0.0F, 0.0F);
	    fin = new ModelRenderer(this, 0, 81);
	    fin.addBox(-0.5F, -4.5F, -1.0F, 1, 4, 3);
	    fin.setRotationPoint(0.0F, 0.0F, 0.0F);
	    fin.mirror = true;
	    setRotation(fin, -0.9773844F, 0.0F, 0.0F);
	    eye3R = new ModelRenderer(this, 0, 40);
	    eye3R.addBox(-2.5F, 5.0F, -10.0F, 4, 1, 3);
	    eye3R.setRotationPoint(0.0F, 0.0F, 0.0F);
	    eye3R.mirror = true;
	    setRotation(eye3R, 0.0F, 0.0F, 0.5235988F);
	    eyeR = new ModelRenderer(this, 0, 25);
	    eyeR.addBox(-8.0F, -2.5F, -6.0F, 3, 4, 4);
	    eyeR.setRotationPoint(0.0F, 0.0F, 0.0F);
	    eyeR.mirror = true;
	    setRotation(eyeR, 0.4014257F, -0.2617994F, 0.0F);
	    eye2R = new ModelRenderer(this, 0, 33);
	    eye2R.addBox(-8.5F, -2.5F, -7.0F, 2, 3, 3);
	    eye2R.setRotationPoint(0.0F, 0.0F, 0.0F);
	    eye2R.mirror = true;
	    setRotation(eye2R, 0.6283185F, -0.418879F, 0.0F);
	    mouth = new ModelRenderer(this, 0, 0);
	    mouth.addBox(-5.0F, -3.0F, -5.5F, 10, 7, 17);
	    mouth.setRotationPoint(0.0F, 0.0F, 0.0F);
	    mouth.mirror = true;
	    setRotation(mouth, 0.0F, 0.0F, 0.0F);
	    eyeL = new ModelRenderer(this, 0, 25);
	    eyeL.mirror = true;
	    eyeL.addBox(5.0F, -2.5F, -6.0F, 3, 4, 4);
	    eyeL.setRotationPoint(0.0F, 0.0F, 0.0F);
	    eyeL.mirror = true;
	    setRotation(eyeL, 0.4014257F, 0.2617994F, 0.0F);
	    eyeL.mirror = false;
	    eye2L = new ModelRenderer(this, 0, 33);
	    eye2L.mirror = true;
	    eye2L.addBox(6.5F, -2.5F, -7.0F, 2, 3, 3);
	    eye2L.setRotationPoint(0.0F, 0.0F, 0.0F);
	    eye2L.mirror = true;
	    setRotation(eye2L, 0.6283185F, 0.418879F, 0.0F);
	    eye2L.mirror = false;
	    eye3L = new ModelRenderer(this, 0, 40);
	    eye3L.mirror = true;
	    eye3L.addBox(-1.5F, 5.0F, -10.0F, 4, 1, 3);
	    eye3L.setRotationPoint(0.0F, 0.0F, 0.0F);
	    eye3L.mirror = true;
	    setRotation(eye3L, 0.0F, 0.0F, -0.5235988F);
	    eye3L.mirror = false;
	    wing3R = new ModelRenderer(this, 61, 45);
	    wing3R.addBox(-5.0F, -0.5F, -5.0F, 6, 1, 12);
	    wing3R.setRotationPoint(-4.0F, -0.5F, 7.333333F);
	    wing3R.mirror = true;
	    setRotation(wing3R, 0.0F, 0.0F, 0.0F);
	    wing4R = new ModelRenderer(this, 61, 58);
	    wing4R.addBox(-4.0F, -0.5F, -2.0F, 4, 1, 8);
	    wing4R.setRotationPoint(-5.0F, 0.0F, 0.0F);
	    wing4R.mirror = true;
	    setRotation(wing4R, 0.0F, 0.0F, 0.0F);
	    wing1L = new ModelRenderer(this, 61, 0);
	    wing1L.mirror = true;
	    wing1L.addBox(-1.0F, -1.0F, -4.0F, 11, 3, 22);
	    wing1L.setRotationPoint(8.0F, 0.0F, 0.0F);
	    wing1L.mirror = true;
	    setRotation(wing1L, 0.0F, -0.1745329F, 0.0F);
	    wing1L.mirror = false;
	    wing2L = new ModelRenderer(this, 61, 25);
	    wing2L.mirror = true;
	    wing2L.addBox(-3.0F, -1.5F, -2.0F, 8, 2, 18);
	    wing2L.setRotationPoint(12.0F, 1.0F, 0.0F);
	    wing2L.mirror = true;
	    setRotation(wing2L, 0.0F, 0.0F, 0.0F);
	    wing2L.mirror = false;
	    wing3L = new ModelRenderer(this, 61, 45);
	    wing3L.mirror = true;
	    wing3L.addBox(-1.0F, -0.5F, -5.0F, 6, 1, 12);
	    wing3L.setRotationPoint(4.0F, -0.5F, 7.333333F);
	    wing3L.mirror = true;
	    setRotation(wing3L, 0.0F, 0.0F, 0.0F);
	    wing3L.mirror = false;
	    wing4l = new ModelRenderer(this, 61, 58);
	    wing4l.mirror = true;
	    wing4l.addBox(0.0F, -0.5F, -2.0F, 4, 1, 8);
	    wing4l.setRotationPoint(5.0F, 0.0F, 0.0F);
	    wing4l.mirror = true;
	    setRotation(wing4l, 0.0F, 0.0F, 0.0F);
	    wing4l.mirror = false;
	    wing_5L = new ModelRenderer(this, 85, 58);
	    wing_5L.mirror = true;
	    wing_5L.addBox(4.0F, -0.5F, 0.0F, 2, 1, 4);
	    wing_5L.setRotationPoint(0.0F, 0.0F, 0.0F);
	    wing_5L.mirror = true;
	    setRotation(wing_5L, 0.0F, 0.0F, 0.0F);
	    wing_5L.mirror = false;
	    
	    mainbody.addChild(wing1L);
	    wing1L.addChild(wing2L);
	    wing2L.addChild(wing3L);
	    wing3L.addChild(wing4l);
	    wing4l.addChild(wing_5L);
	    
	    mainbody.addChild(wing1R);
	    wing1R.addChild(wing2R);
	    wing2R.addChild(wing3R);
	    wing3R.addChild(wing4R);
	    wing4R.addChild(wing_5R);
	    
	    mainbody.addChild(tail1);
	    tail1.addChild(tail2);
	    tail2.addChild(tail3);
	    tail3.addChild(tail4);
	    tail3.addChild(fin);
	    tail4.addChild(tail5);
	 }
	  
	 public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
	 {
	    mainbody.render(f5);
	    eye3R.render(f5);
	    eyeR.render(f5);
	    eye2R.render(f5);
	    mouth.render(f5);
	    eyeL.render(f5);
	    eye2L.render(f5);
	    eye3L.render(f5);
	    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
	 }
	  
	 private void setRotation(ModelRenderer modelRenderer, float x, float y, float z)
	 {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	 }
}