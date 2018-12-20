package com.SmellyModder.TheLostSea.core.util.npc.dialogue.interfaces;

public interface IStepGetterN {

	/**
	 * @param stepID - Gets the ID of the step the player is with the NPC.
	 */
	public void subtractProgressStep(int stepID);
	public void addStep(int stepID);
	public void setStep(int stepID);
	public int getStep();
}
