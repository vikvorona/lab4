package com.yanaguseva.bowling;

public class BowlingGame {
    private int score = 0;
    private int index = 0;
    private int[] pins = new int[21];

    public void roll(int pin) {
        pins[index++] = pin;
    }

    public int getScore() {
        for (int i = 0; i < 20; i++) {
            score += pins[i];
            if (isSpray(i)) {
                score += pins[i + 1] + pins[i + 2];
                i += 1;
            }
        }
        return score;
    }

    private boolean isSpray(int i) {
        return pins[i] + pins[i + 1] == 10;
    }
}
