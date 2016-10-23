/**
 * Created by VITTACH on 23.10.2016.
 */
public class Bowling {
    private int rolls[];
    private int numberFrame =10;
    private int currentRoll = 0;

    Bowling() {
        rolls = new int[2 * numberFrame + 1];
    }

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int finalScore = 0;
        int frameIterator = 0;

        for (int frame = 0; frame < numberFrame; frame++)  {
            // strike situation
            if (rolls[frameIterator] == 10) {
                finalScore += 10+rolls[frameIterator+1]+rolls[frameIterator+2];
                frameIterator++;

            // spare situation
            } else if(rolls[frameIterator] + rolls[frameIterator + 1] == 10) {
                finalScore += 10 + rolls[frameIterator + 2];
                frameIterator += 2;

            } else {
                finalScore += rolls[frameIterator] + rolls[frameIterator + 1];
                frameIterator += 2;
            }
        }

        return finalScore;
    }
}
