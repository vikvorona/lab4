package com.chernyshov777;

/**
 * Class for Frame
 * @author Chernyshov Daniil
 */
public class Frame {
    private int frameNumber;
    private int currentRoll;
    private int firstRollScore;
    private int secondRollScore;
    private int thirdRollScore;
    private int totalFrameScore;
    private boolean strike;
    private boolean spare;

    public Frame(int frameNumber) {
        this.frameNumber = frameNumber;
        currentRoll = 1;
        firstRollScore = 0;
        secondRollScore = 0;
        thirdRollScore = 0;
        strike = false;
        spare = false;
    }

    /**
     * Next roll in frame
     * @param pins how much pins player knocked down in roll
     */
    public void nextRoll(int pins) {
        if (currentRoll == 1) {
            firstRollScore = pins;
            totalFrameScore += firstRollScore;
            currentRoll++;
            if (getTotalFrameScore() == 10) {
                strike = true;
            }
        } else if (currentRoll == 2) {
            secondRollScore = pins;
            totalFrameScore += secondRollScore;
            currentRoll++;
            if (getTotalFrameScore() == 10) {
                spare = true;
            }
        }
    }

    public void addBonus(int bonus) {
        totalFrameScore += bonus;
    }

    /**
     * Total frame score
     * @return total frame score
     */
    public int getTotalFrameScore() {
        return totalFrameScore;
    }

    public int getFrameNumber() {
        return frameNumber;
    }

    public int getCurrentRoll() {
        return currentRoll;
    }

    public int getFirstRollScore() {
        return firstRollScore;
    }

    public int getSecondRollScore() {
        return secondRollScore;
    }

    public int getThirdRollScore() {
        return thirdRollScore;
    }

    public boolean isStrike() {
        return strike;
    }

    public boolean isSpare() {
        return spare;
    }
}
