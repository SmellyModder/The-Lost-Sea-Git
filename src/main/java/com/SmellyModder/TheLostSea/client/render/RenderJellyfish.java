package com.SmellyModder.TheLostSea.client.render;

import com.SmellyModder.TheLostSea.client.model.ModelJellyfish;
import com.SmellyModder.TheLostSea.common.entity.passive.EntityJellyfish;
import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.passive.EntityParrot;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.fml.relauncher.Side;

@SideOnly(Side.CLIENT)
public class RenderJellyfish extends RenderLiving<EntityJellyfish>{

	
	public static final ResourceLocation[] JELLY_COLORS = new ResourceLocation[] {new ResourceLocation(Reference.MOD_ID + ":textures/entity/jelly/jellyfish_1.png"), new ResourceLocation(Reference.MOD_ID + ":textures/entity/jelly/jellyfish_2.png"), new ResourceLocation(Reference.MOD_ID + ":textures/entity/jelly/jellyfish_3.png"), new ResourceLocation(Reference.MOD_ID + ":textures/entity/jelly/jellyfish_4.png"), new ResourceLocation(Reference.MOD_ID + ":textures/entity/jelly/jellyfish_5.png")};
	
	
	public RenderJellyfish(RenderManager manager) {
		super(manager, new ModelJellyfish(), 0.5F);
	}
	
	protected void applyRotations(EntityJellyfish entityLiving, float p_77043_2_, float rotationYaw, float PartialTicks ) {
		
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, PartialTicks);
		
	}

	protected ResourceLocation getEntityTexture(EntityJellyfish entity)
    {
        return JELLY_COLORS[entity.getVariant()];
    }
}