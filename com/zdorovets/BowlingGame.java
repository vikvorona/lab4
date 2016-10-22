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
		for(int i = 0; i < rolls.length; i++)
			score += rolls[i];
		return score;
	}
}
