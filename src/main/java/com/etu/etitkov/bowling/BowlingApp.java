package com.etu.etitkov.bowling;

/**
 * Created by darki on 11/13/16.
 */
public class BowlingApp {

    private int state;
    private int firstBallInFrame;
    private static final int ROLLING_FIRST_BALL = 0;
    private static final int ROLLING_SECOND_BALL = 1;

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


    public int[] roll(int ball) {
        if (state == ROLLING_FIRST_BALL) {
            // handle the first ball;
            firstBallInFrame = ball;
            state = ROLLING_SECOND_BALL;
        } else if (state == ROLLING_SECOND_BALL) {
            // handle the second ball;
            frameScores = new int [1];
            rollingFrame++;
            totalScore = totalScore + firstBallInFrame + ball;
            frameScores[0] = totalScore;
            state = ROLLING_FIRST_BALL;
        } else {
            // signal an error;
        }
        return frameScores;
    }


}
