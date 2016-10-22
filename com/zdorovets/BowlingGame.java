package com.zdorovets;
/*
 * BowlingGame class
 * @author Evgeny Zdorovets
 * created on 21/10/16
 */
public class BowlingGame {
	private int rolls[] = new int[21];
	private int currentRoll = 0;
	/*
	 * @param pins - количество кеглей
	 */
	public void roll(int pins) {
		rolls[currentRoll++] = pins;
	}
	/* 
	 * @return количество очков
	 */
	public int score(){
		int score = 0;
		int i = 0;
		for(int frame = 0; frame < 10; frame++){
			score += rolls[i] + rolls[i+1];
			i += 2;
		}
		return score;
	}
}
