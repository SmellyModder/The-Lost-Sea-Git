package com.SmellyModder.TheLostSea.client.render;

import org.lwjgl.opengl.GL11;

import com.SmellyModder.TheLostSea.client.layer.LayerGlow;
import com.SmellyModder.TheLostSea.client.model.ModelACoin;
import com.SmellyModder.TheLostSea.client.model.npc.ModelLunete;
import com.SmellyModder.TheLostSea.common.entity.bases.ThrowableOrb;
import com.SmellyModder.TheLostSea.common.entity.coins.EntityAtlantisCoin;
import com.SmellyModder.TheLostSea.common.entity.npc.EntityLunete;
import com.SmellyModder.TheLostSea.common.entity.submarine.EntitySubmarineI;
import com.SmellyModder.TheLostSea.common.init.TLSItems;
import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraft.client.model.ModelBook;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderCoin extends RenderLiving<EntityAtlantisCoin>{
	
	private static final ResourceLocation COIN = new ResourceLocation(Reference.MOD_ID + ":textures/entity/coin/coin_a.png");
	public RenderCoin(RenderManager rendermanagerIn) {
		super(rendermanagerIn, new ModelACoin(), 0.05F);
		//this.addLayer(new LayerGlow<EntityAtlantisCoin>(this, new ResourceLocation("thelostsea:textures/entity/coin/coin_a.png")));
	}
	@Override
	protected ResourceLocation getEntityTexture(EntityAtlantisCoin entity) {
		return COIN;
	}
}
