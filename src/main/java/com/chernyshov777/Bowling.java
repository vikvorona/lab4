package com.chernyshov777;

/**
 * @author Chernyshov Daniil
 */
public class Bowling {
    private int currentFrame;
    private int totalScore;
    private boolean strike;
    private boolean spare;

    public Bowling() {
        currentFrame = 1;
        totalScore = 0;
        strike = false;
        spare = false;
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public void setCurrentFrame(int currentFrame) {
        this.currentFrame = currentFrame;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public boolean isStrike() {
        return strike;
    }

    public void setStrike(boolean strike) {
        this.strike = strike;
    }

    public boolean isSpare() {
        return spare;
    }

    public void setSpare(boolean spare) {
        this.spare = spare;
    }
}
