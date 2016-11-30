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

    public Frame(int frameNumber) {
        this.frameNumber = frameNumber;
        currentRoll = 0;
        firstRollScore = 0;
        secondRollScore = 0;
        thirdRollScore = 0;
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
}
