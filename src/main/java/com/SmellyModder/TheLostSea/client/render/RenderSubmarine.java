package com.SmellyModder.TheLostSea.client.render;

import com.SmellyModder.TheLostSea.client.layer.LayerGlow;
import com.SmellyModder.TheLostSea.client.model.ModelSubmarine;
import com.SmellyModder.TheLostSea.client.model.ModelVampireSquid;
import com.SmellyModder.TheLostSea.common.entity.EntityVampireSquid;
import com.SmellyModder.TheLostSea.common.entity.submarine.EntitySubmarineI;
import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSubmarine extends RenderLiving<EntitySubmarineI> {

	private static final ResourceLocation[] TEXTURES = new ResourceLocation[] {new ResourceLocation(Reference.MOD_ID + ":textures/entity/vehicle/submarine_red.png"), new ResourceLocation(Reference.MOD_ID + ":textures/entity/vehicle/submarine_orange.png"), new ResourceLocation(Reference.MOD_ID + ":textures/entity/vehicle/submarine_yellow.png"), new ResourceLocation(Reference.MOD_ID + ":textures/entity/vehicle/submarine_lime.png"), new ResourceLocation(Reference.MOD_ID + ":textures/entity/vehicle/submarine_green.png"), 
			new ResourceLocation(Reference.MOD_ID + ":textures/entity/vehicle/submarine_blue.png"), new ResourceLocation(Reference.MOD_ID + ":textures/entity/vehicle/submarine_lightblue.png"), new ResourceLocation(Reference.MOD_ID + ":textures/entity/vehicle/submarine_cyan.png"), new ResourceLocation(Reference.MOD_ID + ":textures/entity/vehicle/submarine_purple.png"), new ResourceLocation(Reference.MOD_ID + ":textures/entity/vehicle/submarine_magenta.png"), new ResourceLocation(Reference.MOD_ID + ":textures/entity/vehicle/submarine_pink.png"),
			new ResourceLocation(Reference.MOD_ID + ":textures/entity/vehicle/submarine_brown.png"), new ResourceLocation(Reference.MOD_ID + ":textures/entity/vehicle/submarine_black.png"), new ResourceLocation(Reference.MOD_ID + ":textures/entity/vehicle/submarine_gray.png"), new ResourceLocation(Reference.MOD_ID + ":textures/entity/vehicle/submarine_lightgray.png"), new ResourceLocation(Reference.MOD_ID + ":textures/entity/vehicle/submarine_white.png")};

   //new ResourceLocation[] {new ResourceLocation("textures/entity/boat/boat_oak.png"), new ResourceLocation("textures/entity/boat/boat_spruce.png"), new ResourceLocation("textures/entity/boat/boat_birch.png"), new ResourceLocation("textures/entity/boat/boat_jungle.png"), new ResourceLocation("textures/entity/boat/boat_acacia.png"), new ResourceLocation("textures/entity/boat/boat_darkoak.png")}; 
    
    public RenderSubmarine(RenderManager manager) {
        super(manager, new ModelSubmarine(), 0.4F);
        this.addLayer(new LayerGlow<EntitySubmarineI>(this, new ResourceLocation("thelostsea:textures/entity/layer/submarine_layer.png")));
    }

    protected ResourceLocation getEntityTexture(EntitySubmarineI entity)
    {
        return TEXTURES[entity.getBoatType().ordinal()];
    }
}