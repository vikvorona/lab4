package com.vorona.strike;

public class Bowling {
	
	private int[] rolls = new int[21];
	private int curRoll = 0;
	
	public void roll(int pin) {
		rolls[curRoll++] = pin;
	}
	
	public int getScore() {
		int score = 0;
		int rollIndex = 0;
		for (int frame = 0; frame < 10; frame++) {
			if(rolls[rollIndex] + rolls[rollIndex +1] == 10) {
				score += rolls[rollIndex] + rolls[rollIndex + 1] + rolls[rollIndex + 2];
			} else {
				score += rolls[rollIndex] + rolls[rollIndex + 1];
			}
			rollIndex += 2;	
		}
		return score;
	}
}
