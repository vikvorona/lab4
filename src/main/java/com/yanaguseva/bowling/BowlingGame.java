package com.yanaguseva.bowling;

public class BowlingGame {
    private int score = 0;
    private int index = 0;
    private int[] pins = new int[21];
    private int pinIndex = 0;
    private int FRAME_COUNT = 10;

    public void roll(int pin) {
        pins[index++] = pin;
    }

    public int getScore() {
        for (int i = 0; i < FRAME_COUNT; i++) {
            if (isStrike(pinIndex)) {
                score += getSpareScore(pinIndex);
                pinIndex++;
            } else {
                score += isSpare(pinIndex) ? getSpareScore(pinIndex) : getDefaultScore(pinIndex);
                pinIndex += 2;
            }
        }
        return score;
    }

    private int getSpareScore(int i) {
        return getDefaultScore(i) + pins[i + 2];
    }

    private int getDefaultScore(int i) {
        return pins[i] + pins[i + 1];
    }

    private boolean isStrike(int i) {
        return pins[i] == 10;
    }

    private boolean isSpare(int i) {
        return pins[i] + pins[i + 1] == 10;
    }
}
