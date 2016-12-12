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
			if(isStrike(rollIndex)) {
				score+= 10 + rolls[rollIndex + 1] + rolls[rollIndex + 2];
				rollIndex++;	
			} else if(isSpare(rollIndex)) {
				score += 10 + rolls[rollIndex + 2];
				rollIndex += 2;	
			} else {
				score += rolls[rollIndex] + rolls[rollIndex + 1];
				rollIndex += 2;	
			}
		}
		return score;
	}

	private boolean isSpare(int rollIndex) {
		return rolls[rollIndex] + rolls[rollIndex + 1] == 10;
	}

	private boolean isStrike(int rollIndex) {
		return rolls[rollIndex] == 10;
	}
}
