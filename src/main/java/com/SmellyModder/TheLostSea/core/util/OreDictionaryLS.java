package com.SmellyModder.TheLostSea.core.util;

import com.SmellyModder.TheLostSea.common.init.TLSBlocks;

import net.minecraftforge.oredict.OreDictionary;

public class OreDictionaryLS {

	public static void register(){
		OreDictionary.registerOre("sea_stone", TLSBlocks.DEEP_SEA_ROCK);
		OreDictionary.registerOre("sea_stone", TLSBlocks.SEA_ROCK);
	}
}
