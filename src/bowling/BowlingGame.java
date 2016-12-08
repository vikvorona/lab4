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
		if(pins == 10 && (rollIndex - 1) % 2 == 0) {
			rolls[rollIndex++] = 0;
		}
	}
	
	public int getResultScore() {
		int result = 0;
		for(int i = 0; i < ROLLS; i += 2) {
			result += (rolls[i] + rolls[i + 1]);
			if(isStrike(i)) {
				result += strikeWrapper(i + 2);
			}
			else if(i < ROLLS - 2 && isSpare(i)) {
				result += rolls[i + 2];
			}
		}
		
		return result;
	}
	
	private boolean isSpare(int i) {
		return (rolls[i] + rolls[i + 1]) == 10;
	}
	
	private boolean isStrike(int i) {
		return rolls[i] == 10 || rolls[i + 1] == 10;
	}
	
	private int strikeWrapper(int index) {
		int res = 0;
		if(index == 18 && isStrike(index))
			res += rolls[index] + rolls[index + 1] + rolls[index + 2];
		else {
			if(isStrike(index)) {
				if(isStrike(index + 2)) {
					for(int i = index; i < index + 4; i++)
						res += rolls[i];
				}
				else
					res += rolls[index] + rolls[index + 1] + rolls[index + 2];
			}
			else
				res += rolls[index] + rolls[index + 1];
		}
		
		return res;
	}

	
}
