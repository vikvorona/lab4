package com.etu.etitkov.bowling;

/**
 * Created by darki on 11/13/16.
 */
public class BowlingApp {

    private int[] frameScores;


    private int rollingFrame;
    private int totalScore;

    public BowlingApp() {
        rollingFrame = 1;
        totalScore = 0;
        frameScores = new int[0];

    }

    public int frameNumber() {
        return rollingFrame;
    }

    public int scoreSoFar() {
        return totalScore;
    }

    public boolean gameIsOver() {
        return false;
    }

    public int [ ] roll (int ball) {
        return frameScores;
    }


}
