package com.SmellyModder.TheLostSea.client.render.tile;

import com.SmellyModder.TheLostSea.client.model.animation.ModelStarterChest;
import com.SmellyModder.TheLostSea.client.model.animation.ModelStarterChestFull;
import com.SmellyModder.TheLostSea.common.blocks.rewards.BlockStarterChest;
import com.SmellyModder.TheLostSea.common.tileentity.rewards.TileEntityStarterChest;
import com.SmellyModder.TheLostSea.core.util.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.client.model.ModelChest;
import net.minecraft.client.model.ModelLargeChest;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class TileEntityStarterChestRenderer extends TileEntitySpecialRenderer<TileEntityStarterChest> {
	
	private static final ResourceLocation TEXTURE_NORMAL = new ResourceLocation("thelostsea:textures/blocks/rewards/starter_full.png");
    private final ModelStarterChest simpleChest = new ModelStarterChest();

    public TileEntityStarterChestRenderer() {
    }

    @Override
    public void render(TileEntityStarterChest te, double x, double y, double z, float partialTicks, int destroyStage, float alpha) {
        {
            GlStateManager.enableDepth();
            GlStateManager.depthFunc(515);
            GlStateManager.depthMask(true);
            int i;

            if (te.hasWorld()) {
                Block block = te.getBlockType();
                i = te.getBlockMetadata();

                //te.checkForAdjacentChests();
            } else {
                i = 0;
            }

            if (te.adjacentChestZNeg == null && te.adjacentChestXNeg == null) {
            	ModelStarterChest modelchest;

                if (te.adjacentChestXPos == null && te.adjacentChestZPos == null) {
                    modelchest = this.simpleChest;

                    if (destroyStage >= 0) {
                        this.bindTexture(DESTROY_STAGES[destroyStage]);
                        GlStateManager.matrixMode(5890);
                        GlStateManager.pushMatrix();
                        GlStateManager.scale(4.0F, 4.0F, 1.0F);
                        GlStateManager.translate(0.0625F, 0.0625F, 0.0625F);
                        GlStateManager.matrixMode(5888);
                    } else {
                        this.bindTexture(TEXTURE_NORMAL);
                    }
                } else {
                	modelchest = this.simpleChest;

                    if (destroyStage >= 0) {
                        this.bindTexture(DESTROY_STAGES[destroyStage]);
                        GlStateManager.matrixMode(5890);
                        GlStateManager.pushMatrix();
                        GlStateManager.scale(4.0F, 4.0F, 1.0F);
                        GlStateManager.translate(0.0625F, 0.0625F, 0.0625F);
                        GlStateManager.matrixMode(5888);
                    } else {
                        this.bindTexture(TEXTURE_NORMAL);
                    }
                }

                GlStateManager.pushMatrix();
                GlStateManager.enableRescaleNormal();

                if (destroyStage < 0) {
                    GlStateManager.color(1.0F, 1.0F, 1.0F, alpha);
                }

                GlStateManager.translate((float) x, (float) y + 1.0F, (float) z + 1.0F);
                GlStateManager.scale(1.0F, -1.0F, -1.0F);
                GlStateManager.translate(0.5F, 0.5F, 0.5F);
                int j = 0;

                if (i == 2) {
                    j = 180;
                }

                if (i == 3) {
                    j = 0;
                }

                if (i == 4) {
                    j = 90;
                }

                if (i == 5) {
                    j = -90;
                }

                if (i == 2 && te.adjacentChestXPos != null) {
                    GlStateManager.translate(1.0F, 0.0F, 0.0F);
                }

                if (i == 5 && te.adjacentChestZPos != null) {
                    GlStateManager.translate(0.0F, 0.0F, -1.0F);
                }

                GlStateManager.rotate((float) j, 0.0F, 1.0F, 0.0F);
                GlStateManager.translate(-0.5F, -0.5F, -0.5F);
                float f = te.prevLidAngle + (te.lidAngle - te.prevLidAngle) * partialTicks;

                if (te.adjacentChestZNeg != null) {
                    float f1 = te.adjacentChestZNeg.prevLidAngle + (te.adjacentChestZNeg.lidAngle - te.adjacentChestZNeg.prevLidAngle) * partialTicks;

                    if (f1 > f) {
                        f = f1;
                    }
                }

                if (te.adjacentChestXNeg != null) {
                    float f2 = te.adjacentChestXNeg.prevLidAngle + (te.adjacentChestXNeg.lidAngle - te.adjacentChestXNeg.prevLidAngle) * partialTicks;

                    if (f2 > f) {
                        f = f2;
                    }
                }

                f = 1.0F - f;
                f = 1.0F - f * f * f;
                modelchest.handle.rotateAngleX = -(f * ((float) Math.PI / 2F));
                modelchest.renderAll();
                GlStateManager.disableRescaleNormal();
                GlStateManager.popMatrix();
                GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

                if (destroyStage >= 0) {
                    GlStateManager.matrixMode(5890);
                    GlStateManager.popMatrix();
                    GlStateManager.matrixMode(5888);
                }
            }
        }
    }

}
