package com.SmellyModder.TheLostSea.core.api.relics;

public enum EquippableType {
	
	RELIC(-1, 0,          1,2,3,4),
	ELEMENT_STONE(-1, 0,  6,7),
	GAUNTLET(-1, 0,       8);
	
	int[] validSlots;
	private int durability, defense;
	
	private EquippableType(int durability, int defense, int... validSlots) {
		this.validSlots = validSlots;
		this.durability = durability;
		this.defense = defense;
	}

	public boolean hasSlot(int slot) {
		for (int s : validSlots) {
			if (s == slot) 
				return true;
		}
		
		return false; 
	}

	public int[] getValidSlots() {
		return validSlots;
	}
	
	public int getDurability()
	{
		return this.durability;
	}
	

	public int getDefense()
	{
		return this.defense;
	}
}
