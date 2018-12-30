package com.SmellyModder.TheLostSea.core.math;

public class ColorRBGHexIndex {

	
	public float calcMutl(float x, float y){
		float num = 0;
		boolean neg = x <= 0 || y <= 0;
		for(int x2 = 0; x2 <= y - 1; x2++) {
			num += x;
		}
		return num;
	}
}
