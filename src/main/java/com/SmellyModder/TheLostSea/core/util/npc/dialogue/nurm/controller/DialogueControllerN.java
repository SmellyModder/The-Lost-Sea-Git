package com.SmellyModder.TheLostSea.core.util.npc.dialogue.nurm.controller;

import com.SmellyModder.TheLostSea.core.util.npc.dialogue.interfaces.IDialogueNurm;

public class DialogueControllerN implements IDialogueNurm{

	private int verse = 0;
	
	public void subtractVerse(int verseID) {
		this.verse -= verseID;
	}

	public void addVerse(int verseID) {
		this.verse += verseID;
	}

	public void setVerse(int verseID) {
		this.verse = verseID;
	}

	public int getVerse() {
		return this.verse;
	}

	

}
