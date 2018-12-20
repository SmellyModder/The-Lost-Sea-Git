package com.SmellyModder.TheLostSea.core.util.npc;

public interface IDialougeNurm {

	/**
	 * @param verseID - Gets the ID of what conversation the player is in with the NPC.
	 */
	public void subtractVerse(int verseID); 
	public void addVerse(int verseID); 
	public void setVerse(int verseID);
	public int getVerse();
	
	/**
	 * @param stepID - Gets the ID of the step the player is with the NPC.
	 */
	public int subtractProgressStep(int stepID);
	public int addProgressStep(int stepID);
	public int setStep(int stepID);
	public int getStep();
}
