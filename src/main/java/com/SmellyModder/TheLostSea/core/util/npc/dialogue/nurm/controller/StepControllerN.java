package com.SmellyModder.TheLostSea.core.util.npc.dialogue.nurm.controller;

import com.SmellyModder.TheLostSea.core.util.npc.dialogue.I.IDialogueNurm;
import com.SmellyModder.TheLostSea.core.util.npc.dialogue.I.IStepGetterN;

public class StepControllerN implements IStepGetterN{

	int step = 0;
	public void subtractProgressStep(int stepID) {
		step -= stepID;
	}

	public void addStep(int stepID) {
		step += stepID;
	}

	public void setStep(int stepID) {
		step = stepID;
	}

	@Override
	public int getStep() {
		return this.step;
	}

	
}
