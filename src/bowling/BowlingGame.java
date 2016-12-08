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
		for(int i = 0; i < rollIndex; i++)
			result += rolls[i];
		
		return result;
	}
}
