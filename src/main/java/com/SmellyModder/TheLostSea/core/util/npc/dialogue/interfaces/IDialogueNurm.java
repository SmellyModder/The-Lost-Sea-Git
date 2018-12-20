package com.SmellyModder.TheLostSea.core.util.npc.dialogue.interfaces;

public interface IDialogueNurm {

	/**
	 * @param verseID - Gets the ID of what conversation the player is in with the NPC.
	 */
	public void subtractVerse(int verseID); 
	public void addVerse(int verseID); 
	public void setVerse(int verseID);
	public int getVerse();
	
	
}
