package bowling;

public class BowlingGame {
	public static final int ROLLS = 20; //всего 10 попыток, в каждой попытке 2 броска
	public static final int MAXROLLS = 23;//максимальное число бросков с учетом дополнительных
	private final int MAXPINS = 10; // максимальное число выбитых кегель 
	private final int LASTFRAME = 18; // последняя попытка
	
	
	private int rollIndex;
	
	private int[] rolls;
	
	BowlingGame() {
		rolls = new int[MAXROLLS];
		rollIndex = 0;
	}
	
	public void makeRoll(int pins) {
		rolls[rollIndex++] = pins;
		
		//если первым броском выбили страйк
		//то переходим сразу к следующей попытке
		if(pins == MAXPINS && (rollIndex - 1) % 2 == 0) {
			rolls[rollIndex++] = 0;
		}
	}
	
	//сумма бросков попытки
	private int attemptSum(int i) {
		return rolls[i] + rolls[i + 1];
	}
	
	public int getResultScore() {
		int result = 0;
		for(int i = 0; i < ROLLS; i += 2) {
			result += attemptSum(i);
			//если последним броском выбили страйк
			//то считаем сумму дополнительных бросков
			if(i + 2 == ROLLS && isStrike(i)) {
				for(int j = ROLLS; j < rollIndex; j++)
					result += rolls[j];
			}
			else if(isStrike(i)) {
				//удваиваем два следующих броска
				result += strikeWrapper(i + 2);
			}
			else if(isSpare(i)) {
				result += rolls[i + 2];
			}
		}
		
		return result;
	}
	
	private boolean isSpare(int i) {
		return (rolls[i] + rolls[i + 1]) == MAXPINS;
	}
	
	private boolean isStrike(int i) {
		return rolls[i] == MAXPINS || rolls[i + 1] == MAXPINS;
	}
	
	/*
	 * Удвоение двух следующих бросков после выбитого страйка 
	 * 
	 * @param индекс следующей попытки после страйка
	 * 
	 * @res результат сложения двух следующих бросков
	 *
	 */
	private int strikeWrapper(int index) {
		int res = 0;
		//если в следующей попытке выбит страйк и она последняя
		//то результат равен сумма этой попытки и дополнительного броска
		if(index == LASTFRAME && isStrike(index))
			res += attemptSum(index) + rolls[index + 2];
		else {
			if(isStrike(index)) {
				//если  в двух следующих попытках страйк, то складываем 
				//эти попытки ( в каждой попытке по 2 броска)
				if(isStrike(index + 2)) {
					for(int i = index; i < index + 4; i++)
						res += rolls[i];
				}
				//иначе если с двух следующих попытках в первой страйк
				//а во второй нет, то складывается страйк первой попытки 
				//и первый бросок из следующей попытки за страйком
				else
					res += attemptSum(index) + rolls[index + 2];
			}
			//иначе складывается два следующих броска
			else
				res += attemptSum(index);
		}
		
		return res;
	}

	
}
