package com.SmellyModder.TheLostSea.client.overlay.stats;

import org.lwjgl.Sys;
import org.lwjgl.opengl.GL11;

import com.SmellyModder.TheLostSea.common.entity.coins.EntityAtlantisCoin;
import com.SmellyModder.TheLostSea.core.config.Config;
import com.SmellyModder.TheLostSea.core.util.Reference;
import com.SmellyModder.TheLostSea.core.util.player.CoinProvider;
import com.SmellyModder.TheLostSea.core.util.player.shoputil.ICurrency;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class OverlayCoins extends Gui{
	
	int width = 74;
	int height = 23;
	int heightForRes = 0;
	int heightForResText = 0;
	int heightForResIcon = 0;
	private double nextAnim, prevTime;

	@SubscribeEvent
	public void renderCoinTracker(RenderGameOverlayEvent event) {
		if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT){
			int posX = (event.getResolution().getScaledWidth()) / 2;
			final int posY = (event.getResolution().getScaledHeight()) / 2;
			int offsetFromScreenLeft = (event.getResolution().getScaledWidth() - width) / 2;
			int offsetFromScreenTop = offsetFromScreenLeft * 2;

			Minecraft mc = Minecraft.getMinecraft();
			EntityPlayer entitySP = Minecraft.getMinecraft().player;
			int i2 = Minecraft.getMinecraft().gameSettings.guiScale;
			if(i2 == 0) {
				heightForRes = 233;
				heightForResIcon = 260;
				heightForResText = 241;
			} else if(i2 == 1){
				heightForRes = 995;
				heightForResIcon = 1022;
				heightForResText = 1003;
			}else if(i2 == 2){
				heightForRes = 486;
				heightForResIcon = 513;
				heightForResText = 494;
			}
			else if(i2 == 3){
				heightForRes = 317;
				heightForResIcon = 344;
				heightForResText = 325;
			}
			
			World world1 = mc.world;
			FontRenderer fontrenderer = Minecraft.getMinecraft().ingameGUI.getFontRenderer();
			EntityAtlantisCoin coin = new EntityAtlantisCoin(world1);
			
			final double time = (Sys.getTime() * 1000) / Sys.getTimerResolution();
			final double timePassed = time - this.prevTime;

			this.prevTime = time;

			if (this.nextAnim < 1200)
			{
				this.nextAnim += timePassed;
			}
			else
			{
				this.nextAnim = 0.0;
			}

			final double anim = this.nextAnim;

			
			
			GlStateManager.pushMatrix();
			if (true) {
				
//				if(this.nextAnim == 0) {
//					GlStateManager.translate(0, anim / 40000.0, 0);
//				}
//				else if (this.nextAnim < 500.0)
//				{
//					GlStateManager.translate(0, anim / 500.0, 0);
//				}
//				else if (this.nextAnim >= 500.0)
//				{
//					GlStateManager.translate(0, -((anim - 500.0) / 500.0), 0);
//				}
//				else if(this.nextAnim >= 1000) {
//					GlStateManager.translate(0, -((anim - 1000.0) / 500.0), 0);
//				}
				
				if(Config.isCoinOverlayTop == false) {
					Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID + ":textures/gui/overlay/player/coin_overlay.png"));
				} else {
					Minecraft.getMinecraft().renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID + ":textures/gui/overlay/player/coin_overlay_top.png"));
				}
				
				
				Minecraft.getMinecraft().ingameGUI.drawModalRectWithCustomSizedTexture(offsetFromScreenLeft + 129, heightForRes, 0, 0, 74, 22, 74, 22);
				
				EntityPlayer player = Minecraft.getMinecraft().player;
				
				ICurrency coins = player.getCapability(CoinProvider.COIN_CAP, null); 
				
				String message = String.format("%d", (int) coins.getCoins()); 
				
				Minecraft.getMinecraft().ingameGUI.drawString(mc.fontRenderer, "x", offsetFromScreenLeft + 149, heightForResText, 16777215);
				Minecraft.getMinecraft().ingameGUI.drawString(fontrenderer, String.valueOf(coins.getCoins()), offsetFromScreenLeft + 156, heightForResText, 16777215);
				
				GL11.glColor4f(1, 1, 1, 1);
				drawEntityOnScreen(offsetFromScreenLeft + 141, heightForResIcon, 35, coin);
				
				GlStateManager.popMatrix();
			}
		}	
	}
	public static void drawEntityOnScreen(int posX, int posY, int scale, EntityLivingBase ent)
    {
		Minecraft mc = Minecraft.getMinecraft();
        GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)posX, (float)posY, 50.0F);
        GlStateManager.scale((float)(-scale), (float)scale, (float)scale);
        GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
        float f = ent.renderYawOffset;
        float f1 = ent.rotationYaw;
        float f2 = ent.rotationPitch;
        float f3 = ent.prevRotationYawHead;
        float f4 = ent.rotationYawHead;
        GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        float f9_3 = (float) (90*mc.player.ticksExisted*0.024);
        GlStateManager.rotate(f9_3, 0.0F, 1.0F, 0.0F);
        ent.rotationYawHead = ent.rotationYaw;
        ent.prevRotationYawHead = ent.rotationYaw;
        GlStateManager.translate(0.0F, 0.0F, 0.0F);
        RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
        rendermanager.setPlayerViewY(180.0F);
        rendermanager.setRenderShadow(false);
        rendermanager.renderEntity(ent, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F, false);
        rendermanager.setRenderShadow(true);
        ent.renderYawOffset = f;
        ent.rotationYaw = f1;
        ent.rotationPitch = f2;
        ent.prevRotationYawHead = f3;
        ent.rotationYawHead = f4;
        GlStateManager.popMatrix();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }
}
