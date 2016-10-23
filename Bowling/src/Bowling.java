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
        int score= 0;
        for(int i = 0; i < rolls.length; i++)
            score += rolls[i];
        return score;
    }
}
