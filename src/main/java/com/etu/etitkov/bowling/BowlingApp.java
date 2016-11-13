package com.etu.etitkov.bowling;

public class BowlingApp {

    private int rollingFrame;
    private int totalScore;
    private int[] frameScores;
    private int state;
    private static final int ROLLING_FIRST_BALL = 0;
    private static final int ROLLING_SECOND_BALL = 1;

    private int firstBallInFrame;
    private int lastFrameNumber;

    public BowlingApp() {
        this(10);
    }

    public BowlingApp(int frameCount) {
        lastFrameNumber = frameCount;
        rollingFrame = 1;
        totalScore = 0;
        frameScores = new int[0];
        state = ROLLING_FIRST_BALL;
    }

    public int frameNumber() {
        return rollingFrame;
    }

    public int scoreSoFar() {
        return totalScore;
    }

    public boolean gameIsOver() {
        return rollingFrame > lastFrameNumber;
    }

    public int[] roll(int ball) {
        if (state == ROLLING_FIRST_BALL) {
            firstBallInFrame = ball;
            state = ROLLING_SECOND_BALL;
        } else if (state == ROLLING_SECOND_BALL) {
            totalScore = totalScore + firstBallInFrame + ball;
            rollingFrame++;
            int[] temp = new int[frameScores.length + 1];
            System.arraycopy(frameScores, 0, temp, 0, frameScores.length);
            temp[frameScores.length] = totalScore;
            frameScores = temp;
            state = ROLLING_FIRST_BALL;
        } else {
            System.out.println("Invalid state: " + state);
            System.exit(1);
        }
        return frameScores;
    }
}

