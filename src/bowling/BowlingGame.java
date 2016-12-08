package bowling;

public class BowlingGame {
	public static final int FRAMES = 10;
	public static final int ROLLS = 20;
	
	private int rollIndex;
	
	private int[] rolls;
	
	BowlingGame() {
		rolls = new int[ROLLS + 1];
		rollIndex = 0;
	}
	
	public void makeRoll(int pins) {
		rolls[rollIndex++] = pins;
	}
	
	public int getResultScore() {
		int result = 0;
		for(int i = 0; i < ROLLS; i += 2) {
			result += (rolls[i] + rolls[i + 1]);
			if(i < ROLLS - 2 && isSpare(i)) {
				result += rolls[i + 2];
			}
		}
		
		return result;
	}
	
	private boolean isSpare(int i) {
		return (rolls[i] + rolls[i + 1]) == 10;
	}
	
}
