package com.SmellyModder.TheLostSea.core.api.relics;

public enum ElementType {
	LIGHT("Light", "Light"),
	DARK("Dark", "Dark"),
	NORMAL("Normal", "Normal", "Light", "Dark"),
	FIRE("Fire", "Light", "Water"),
	WATER("Water", "Dark", "Life", "Electric"),
	EARTH("Earth", "Dark", "Water", "Air"),
	LIFE("Life", "Dark", "Fire"),
	ELECTRIC("Electric", "Light", "Earth"),
	WIND("Wind", "Light", "Electric"),
	RIFT("Rift", "Rift");
	
	
	private String elementID;
	private String weakness;
	private String riftStance;
	
	/**
	 * 
	 * @param ID - Get's the name of the Element
	 * @param elementRiftPull - Important for magic stuff later; Determines if it's closer to Dark or Light
	 * @param weaknesses - Get's the Items Strengths/Weaknesses
	 */
	private ElementType(String ID, String elementRiftPull, String... weaknesses) {
		this.elementID = ID;
		this.riftStance = elementRiftPull;
	}
	
	public String getWeaknesses() {
		return this.elementID;
	}
	
	public String getRiftStance() {
		return this.riftStance;
	}
}
