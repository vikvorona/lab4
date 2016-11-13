package com.etu.etitkov.bowling;

/**
 * @author Evgenii Ray
 */
public class BowlingApp {

    /* the number of the frame in which the next ball
     * will be rolled; ranges from 1 to 11 */
    private int rollingFrame;
    //total game score
    private int totalScore;
    //scores of the frames
    private int[] frameScores;

    private int state;
    private static final int ROLLING_FIRST_BALL = 0;
    private static final int ROLLING_SECOND_BALL = 1;
    private static final int STRIKE_LAST_BALL = 2;
    private static final int TWO_CONSEC_STRIKES = 3;
    private static final int STRIKE_2_BALLS_AGO = 4;
    private static final int SPARE_LAST_BALL = 5;

    // the number of pins knocked down by the first ball
    // in frame number rollingFrame
    private int firstBallInFrame;
    // indicates which frame is the last in the game
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
        if (state == SPARE_LAST_BALL && rollingFrame > lastFrameNumber) {
            return rollingFrame - 1;
        } else if (state == STRIKE_LAST_BALL && rollingFrame > lastFrameNumber) {
            return rollingFrame - 1;
        } else if (state == STRIKE_2_BALLS_AGO && rollingFrame > lastFrameNumber) {
            return rollingFrame - 1;
        } else if (state == ROLLING_FIRST_BALL && rollingFrame > lastFrameNumber + 1) {
            return rollingFrame - 1;
        } else if (state == TWO_CONSEC_STRIKES && rollingFrame == lastFrameNumber + 1) {
            return rollingFrame - 1;
        } else if (state == TWO_CONSEC_STRIKES && rollingFrame > lastFrameNumber + 1) {
            return rollingFrame - 2;
        } else {
            return rollingFrame;
        }
    }

    public int scoreSoFar() {
        if (frameScores.length == lastFrameNumber) {
            return frameScores[lastFrameNumber - 1];
        } else {
            return totalScore;
        }
    }

    public boolean gameIsOver() {
        return frameNumber() > lastFrameNumber;
    }

    public int[] roll(int ball) {
        switch (state) {
            case ROLLING_FIRST_BALL:
                if (ball == 10) {
                    rollingFrame++;
                    state = STRIKE_LAST_BALL;
                } else {
                    firstBallInFrame = ball;
                    state = ROLLING_SECOND_BALL;
                }
                break;
            case ROLLING_SECOND_BALL:
                if (firstBallInFrame + ball == 10) {
                    rollingFrame++;
                    state = SPARE_LAST_BALL;
                } else {
                    rollingFrame++;
                    addFrame(firstBallInFrame + ball);
                    state = ROLLING_FIRST_BALL;
                }
                break;

            case SPARE_LAST_BALL:
                addFrame(10 + ball);
                if (ball == 10) {
                    rollingFrame++;
                    state = STRIKE_LAST_BALL;
                } else {
                    firstBallInFrame = ball;
                    state = ROLLING_SECOND_BALL;
                }
                break;
            case STRIKE_LAST_BALL:
                if (ball == 10) {
                    rollingFrame++;
                    state = TWO_CONSEC_STRIKES;
                } else {
                    firstBallInFrame = ball;
                    state = STRIKE_2_BALLS_AGO;
                }
                break;
            case TWO_CONSEC_STRIKES:
                addFrame(20 + ball);
                if (ball == 10) {
                    rollingFrame++;
                } else {
                    firstBallInFrame = ball;
                    state = STRIKE_2_BALLS_AGO;
                }
                break;

            case STRIKE_2_BALLS_AGO:
                addFrame(10 + firstBallInFrame + ball);
                if (firstBallInFrame + ball == 10) {
                    rollingFrame++;
                    state = SPARE_LAST_BALL;
                } else {
                    rollingFrame++;
                    addFrame(firstBallInFrame + ball);
                    state = ROLLING_FIRST_BALL;
                }
                break;
            default:
                System.out.println("Invalid state: " + state);
                break;
        }

        return frameScores;
    }


    private void addFrame(int toAdd) {
        totalScore = totalScore + toAdd;
        if (frameScores.length < lastFrameNumber) {
            int[] temp = new int[frameScores.length + 1];
            System.arraycopy(frameScores, 0, temp, 0, frameScores.length);
            temp[frameScores.length] = totalScore;
            frameScores = temp;
        }
    }

}


