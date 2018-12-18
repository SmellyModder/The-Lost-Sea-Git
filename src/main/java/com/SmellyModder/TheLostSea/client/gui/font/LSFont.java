package com.SmellyModder.TheLostSea.client.gui.font;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.ResourceLocation;

public class LSFont extends FontRenderer{

		public LSFont(GameSettings gameSettingsIn, ResourceLocation location, TextureManager textureManagerIn, boolean unicode) {
			super(gameSettingsIn, location, textureManagerIn, unicode);
			this.FONT_HEIGHT = 8;
		}
}
