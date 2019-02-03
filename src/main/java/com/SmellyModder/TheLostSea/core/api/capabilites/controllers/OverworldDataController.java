package com.SmellyModder.TheLostSea.core.api.capabilites.controllers;

import com.SmellyModder.TheLostSea.core.api.capabilites.IOverworldData;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.interfaces.IDialogueNurm;

public class OverworldDataController implements IOverworldData{

	private int nurm_shops = 0;

	@Override
	public void setNurmShopGenerated(int shops) {
		nurm_shops = shops;
	}

	@Override
	public int getNurmShopGenerated() {
		return this.nurm_shops;
	}
	
}
