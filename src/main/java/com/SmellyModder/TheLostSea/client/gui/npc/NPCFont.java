package com.SmellyModder.TheLostSea.client.gui.npc;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.ResourceLocation;

public class NPCFont extends FontRenderer {

	public NPCFont(GameSettings gameSettingsIn, ResourceLocation location, TextureManager textureManagerIn, boolean unicode) {
		super(gameSettingsIn, location, textureManagerIn, unicode);
	}
	@Override
	protected float renderUnicodeChar(char ch, boolean italic)
	{
		int i = glyphWidth[ch] & 255;

		if (i == 0)
			return 0.0F;
		else
		{
			bindTexture(locationFontTexture);
			int k = i >>> 4;
			int l = i & 15;
			float f = k;
			float f1 = l + 1;
			float f2 = ch % 16 * 16 + f;
			float f3 = (ch & 255) / 16 * 16;
			float f4 = f1 - f - 0.02F;
			float f5 = italic ? 1.0F : 0.0F;
			GlStateManager.glBegin(5);
			GlStateManager.glTexCoord2f(f2 / 256.0F, f3 / 256.0F);
			GlStateManager.glVertex3f(posX + f5, posY, 0.0F);
			GlStateManager.glTexCoord2f(f2 / 256.0F, (f3 + 15.98F) / 256.0F);
			GlStateManager.glVertex3f(posX - f5, posY + 7.99F, 0.0F);
			GlStateManager.glTexCoord2f((f2 + f4) / 256.0F, f3 / 256.0F);
			GlStateManager.glVertex3f(posX + f4 / 2.0F + f5, posY, 0.0F);
			GlStateManager.glTexCoord2f((f2 + f4) / 256.0F, (f3 + 15.98F) / 256.0F);
			GlStateManager.glVertex3f(posX + f4 / 2.0F - f5, posY + 7.99F, 0.0F);
			GlStateManager.glEnd();
			return (f1 - f) / 2.0F + 1.0F;
		}
	}

}
