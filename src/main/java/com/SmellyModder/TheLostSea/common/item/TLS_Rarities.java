package com.SmellyModder.TheLostSea.common.item;

import net.minecraft.util.text.TextFormatting;

public enum TLS_Rarities 
{
	NONE(TextFormatting.WHITE, "none"),
	ENCHANTED(TextFormatting.BLUE, "none"),
	COMMON(TextFormatting.GREEN, "Common"),
    UNCOMMON(TextFormatting.YELLOW, "Uncommon"),
    RARE(TextFormatting.AQUA, "Rare"),
    LEGENDARY(TextFormatting.GOLD, "Legendary"),
	MYTHICAL(TextFormatting.LIGHT_PURPLE, "Mythical");

    /** The color assigned to this rarity type. */
    public final TextFormatting color;
    /** Rarity name. */
    public final String rarityName;

    private TLS_Rarities(TextFormatting color, String name)
    {
        this.color = color;
        this.rarityName = name;
    }
}
