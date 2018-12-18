package com.SmellyModder.TheLostSea.client.render;

import com.SmellyModder.TheLostSea.client.layer.LayerGlow;
import com.SmellyModder.TheLostSea.client.model.ModelSubmarine;
import com.SmellyModder.TheLostSea.client.model.ModelSubmarineII;
import com.SmellyModder.TheLostSea.common.entity.submarine.EntitySubmarineI;
import com.SmellyModder.TheLostSea.common.entity.submarine.EntitySubmarineII;
import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSubmarineII extends RenderLiving<EntitySubmarineII> {

	private static final ResourceLocation[] TEXTURES = new ResourceLocation[] {new ResourceLocation(Reference.MOD_ID + ":textures/entity/vehicle/submarine_red2.png"), new ResourceLocation(Reference.MOD_ID + ":textures/entity/vehicle/submarine_orange2.png"), new ResourceLocation(Reference.MOD_ID + ":textures/entity/vehicle/submarine_yellow2.png"), new ResourceLocation(Reference.MOD_ID + ":textures/entity/vehicle/submarine_lime2.png"), new ResourceLocation(Reference.MOD_ID + ":textures/entity/vehicle/submarine_green2.png"), 
			new ResourceLocation(Reference.MOD_ID + ":textures/entity/vehicle/submarine_blue2.png"), new ResourceLocation(Reference.MOD_ID + ":textures/entity/vehicle/submarine_lightblue2.png"), new ResourceLocation(Reference.MOD_ID + ":textures/entity/vehicle/submarine_cyan2.png"), new ResourceLocation(Reference.MOD_ID + ":textures/entity/vehicle/submarine_purple2.png"), new ResourceLocation(Reference.MOD_ID + ":textures/entity/vehicle/submarine_magenta2.png"), new ResourceLocation(Reference.MOD_ID + ":textures/entity/vehicle/submarine_pink2.png"),
			new ResourceLocation(Reference.MOD_ID + ":textures/entity/vehicle/submarine_brown2.png"), new ResourceLocation(Reference.MOD_ID + ":textures/entity/vehicle/submarine_black2.png"), new ResourceLocation(Reference.MOD_ID + ":textures/entity/vehicle/submarine_gray2.png"), new ResourceLocation(Reference.MOD_ID + ":textures/entity/vehicle/submarine_lightgray2.png"), new ResourceLocation(Reference.MOD_ID + ":textures/entity/vehicle/submarine_black2.png")};

   //new ResourceLocation[] {new ResourceLocation("textures/entity/boat/boat_oak.png"), new ResourceLocation("textures/entity/boat/boat_spruce.png"), new ResourceLocation("textures/entity/boat/boat_birch.png"), new ResourceLocation("textures/entity/boat/boat_jungle.png"), new ResourceLocation("textures/entity/boat/boat_acacia.png"), new ResourceLocation("textures/entity/boat/boat_darkoak.png")}; 
    
    public RenderSubmarineII(RenderManager manager) {
        super(manager, new ModelSubmarineII(), 0.4F);
        this.addLayer(new LayerGlow<EntitySubmarineII>(this, new ResourceLocation("thelostsea:textures/entity/layer/submarine_overlay_2.png")));
    }

    protected ResourceLocation getEntityTexture(EntitySubmarineII entity)
    {
        return TEXTURES[entity.getBoatType().ordinal()];
    }
}