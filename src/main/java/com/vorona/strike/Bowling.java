package com.vorona.strike;

public class Bowling {
	
	private int score = 0;
	
	public void roll(int pin) {
		score += pin;
	}
	
	public int getScore() {
		return score;
	}
}
