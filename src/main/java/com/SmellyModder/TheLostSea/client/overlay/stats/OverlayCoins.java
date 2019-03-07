package com.SmellyModder.TheLostSea.client.overlay.stats;

import com.SmellyModder.TheLostSea.common.entity.coins.EntityAtlantisCoin;
import com.SmellyModder.TheLostSea.core.TheLostSea;
import com.SmellyModder.TheLostSea.core.config.Config;
import com.SmellyModder.TheLostSea.core.packets.MessageCoins;
import com.SmellyModder.TheLostSea.core.util.Reference;
import com.SmellyModder.TheLostSea.core.util.player.CoinProvider;
import com.SmellyModder.TheLostSea.core.util.player.shoputil.ICurrency;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = Side.CLIENT)
public class OverlayCoins extends Gui {

    private static final Minecraft MC = Minecraft.getMinecraft();
    private static final int ANIMATION_LENGTH = 120;

    private static final int WIDTH = 74;

    private static int lastCoinCount;

    private static int coinTimer;
    private static int prevCoinTimer;

    @SubscribeEvent
    public static void onClientTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.START && MC.player != null && !MC.isGamePaused()) {
            prevCoinTimer = coinTimer;
            if (coinTimer > 0) {
                coinTimer--;
            }
            ICurrency coins = MC.player.getCapability(CoinProvider.COIN_CAP, null);
            int coinCount = coins != null ? coins.getCoins() : 0;
            if (lastCoinCount != coinCount) {
                coinTimer = ANIMATION_LENGTH;
                lastCoinCount = coinCount;
            }
        }
    }

    @SubscribeEvent
    public static void renderCoinTracker(RenderGameOverlayEvent event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.TEXT) {
            ICurrency coins = MC.player.getCapability(CoinProvider.COIN_CAP, null);
            if (coins == null) {
                return;
            }
            
            ScaledResolution resolution = event.getResolution();
            int offsetFromScreenLeft = (resolution.getScaledWidth() - WIDTH) / 2;

            if (coinTimer > 0) {
                float partialTicks = event.getPartialTicks();
                double coinAnimation = ANIMATION_LENGTH - (prevCoinTimer + (coinTimer - prevCoinTimer) * partialTicks);

                EntityAtlantisCoin coin = new EntityAtlantisCoin(MC.world);

                GlStateManager.pushMatrix();

                if (!Config.isCoinOverlayTop) {
                    MC.renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/gui/overlay/player/coin_overlay.png"));
                } else {
                    MC.renderEngine.bindTexture(new ResourceLocation(Reference.MOD_ID, "textures/gui/overlay/player/coin_overlay_top.png"));
                }

                double intermediate = coinAnimation / ANIMATION_LENGTH;
                double slide = 2.0 * (intermediate < 0.5 ? intermediate : 1.0 - intermediate);
                slide = Math.min(slide * 5, 1);

                double screenHeight = resolution.getScaledHeight_double();

                int y = MathHelper.ceil(screenHeight - slide * 22);

                drawModalRectWithCustomSizedTexture(offsetFromScreenLeft + 129, y, 0, 0, 74, 22, 74, 22);

                MC.fontRenderer.drawString("x", offsetFromScreenLeft + 149, y + 8, 0xFFFFFF, true);
                MC.fontRenderer.drawString(String.valueOf(coins.getCoins()), offsetFromScreenLeft + 156.5F, y + 8.6F, 0xFFFFFF, true);
                GlStateManager.color(1, 1, 1, 1);
                drawEntityOnScreen(offsetFromScreenLeft + 141, y + 27, 35, coin);

                GlStateManager.popMatrix();
            }
        }
    }

    private static void drawEntityOnScreen(int posX, int posY, int scale, EntityLivingBase ent) {
        Minecraft mc = Minecraft.getMinecraft();
        GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();
        GlStateManager.translate((float) posX, (float) posY, 50.0F);
        GlStateManager.scale((float) (-scale), (float) scale, (float) scale);
        GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
        float f = ent.renderYawOffset;
        float f1 = ent.rotationYaw;
        float f2 = ent.rotationPitch;
        float f3 = ent.prevRotationYawHead;
        float f4 = ent.rotationYawHead;
        GlStateManager.rotate(135.0F, 0.0F, 1.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        float f9_3 = (float) (90 * mc.player.ticksExisted * 0.024);
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
