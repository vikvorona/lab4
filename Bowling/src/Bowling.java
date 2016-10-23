/**
 * Created by VITTACH on 23.10.2016.
 */
public class Bowling {
    private int rolls[];
    private int currentRoll = 0;

    Bowling() {
        rolls = new int[21];
    }

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int frameIterator = 0;
        int score= 0;

        for (int frame = 0; frame < 10; frame++)  {
            if (rolls[frameIterator] + rolls[frameIterator + 1] == 10) { // spare situation
                score += 10 + rolls[frameIterator + 2];
                frameIterator += 2;
            } else {
                score += rolls[frameIterator] + rolls[frameIterator + 1];
                frameIterator += 2;
            }
        }
        return score;
    }
}
