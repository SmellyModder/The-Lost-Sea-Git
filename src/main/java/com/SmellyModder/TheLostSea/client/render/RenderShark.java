package com.SmellyModder.TheLostSea.client.render;

import org.lwjgl.opengl.GL11;

import com.SmellyModder.TheLostSea.client.layer.LayerGlow;
import com.SmellyModder.TheLostSea.client.model.ModelAnglerfish;
import com.SmellyModder.TheLostSea.client.model.ModelWhiteShark;
import com.SmellyModder.TheLostSea.common.entity.EntityAnglerfish;
import com.SmellyModder.TheLostSea.common.entity.passive.EntityShark;
import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderShark extends RenderLiving<EntityShark> {

	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/shark/great_white.png");

    public RenderShark(RenderManager manager) {
        super(manager, new ModelWhiteShark(), 1.2F);
    }

	@Override
	protected ResourceLocation getEntityTexture(EntityShark entity) {
		return TEXTURES;
	}
	
}
