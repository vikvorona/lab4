package com.etu.etitkov.bowling;

import org.junit.Test;

import static org.junit.Assert.*;

public class BowlingAppTest {

    @Test
    public void testConstructor() {
        BowlingApp bowlingApp = new BowlingApp();
        assertEquals("frame number for new BowlingApp is wrong", 1, bowlingApp.frameNumber());
        assertEquals("score for new BowlingApp is wrong", 0, bowlingApp.scoreSoFar());
        assertFalse("game is over for new BowlingApp", bowlingApp.gameIsOver());
    }

    @Test
    public void testFourBalls() {
        BowlingApp bowlingApp = new BowlingApp(2);
        int[] balls = {1, 2, 4, 1};
        int[] lengths = {0, 1, 1, 2};
        int[] frames = {1, 2, 2, 3};
        int[] finalResult = {3, 8};
        testGame(bowlingApp, balls, lengths, frames, finalResult);
    }

    @Test
    public void testSpareMissMiss() {
        BowlingApp bowlingApp = new BowlingApp(3);
        int[] balls = {6, 4, 3, 4, 5, 2};
        int[] lengths = {0, 0, 1, 2, 2, 3};
        int[] frames = {1, 2, 2, 3, 3, 4};
        int[] finalResult = {13, 20, 27};
        testGame(bowlingApp, balls, lengths, frames, finalResult);
    }

    @Test
    public void testMissSpareMiss() {
        BowlingApp bowlingApp = new BowlingApp(3);
        int[] balls = {6, 3, 4, 6, 5, 2};
        int[] lengths = {0, 1, 1, 1, 2, 3};
        int[] frames = {1, 2, 2, 3, 3, 4};
        int[] finalResult = {9, 24, 31};
        testGame(bowlingApp, balls, lengths, frames, finalResult);
    }

    @Test
    public void testMissMissSpare() {
        BowlingApp bowlingApp = new BowlingApp(3);
        int[] balls = {6, 3, 3, 4, 8, 2, 4};
        int[] lengths = {0, 1, 1, 2, 2, 2, 3};
        int[] frames = {1, 2, 2, 3, 3, 3, 4};
        int[] finalResult = {9, 16, 30};
        testGame(bowlingApp, balls, lengths, frames, finalResult);
    }

    @Test
    public void testSpareSpareMiss() {
        BowlingApp bowlingApp = new BowlingApp(3);
        int[] balls = {6, 4, 3, 7, 5, 2};
        int[] lengths = {0, 0, 1, 1, 2, 3};
        int[] frames = {1, 2, 2, 3, 3, 4};
        int[] finalResult = {13, 28, 35};
        testGame(bowlingApp, balls, lengths, frames, finalResult);
    }

    @Test
    public void testMissSpareSpare() {
        BowlingApp bowlingApp = new BowlingApp(3);
        int[] balls = {6, 3, 3, 7, 8, 2, 4};
        int[] lengths = {0, 1, 1, 1, 2, 2, 3};
        int[] frames = {1, 2, 2, 3, 3, 3, 4};
        int[] finalResult = {9, 27, 41};
        testGame(bowlingApp, balls, lengths, frames, finalResult);
    }

    @Test
    public void testSpareZeroSpareMiss() {
        BowlingApp bowlingApp = new BowlingApp(3);
        int[] balls = {6, 4, 0, 10, 5, 2};
        int[] lengths = {0, 0, 1, 1, 2, 3};
        int[] frames = {1, 2, 2, 3, 3, 4};
        int[] finalResult = {10, 25, 32};
        testGame(bowlingApp, balls, lengths, frames, finalResult);
    }

    @Test
    public void testMissStrikeMiss() {
        BowlingApp bowlingApp = new BowlingApp(3);
        int[] balls = {6, 2, 10, 5, 4};
        int[] lengths = {0, 1, 1, 1, 3};
        int[] frames = {1, 2, 3, 3, 4};
        int[] finalResult = {8, 27, 36};
        testGame(bowlingApp, balls, lengths, frames, finalResult);
    }

    @Test
    public void testSpareStrikeMiss() {
        BowlingApp bowlingApp = new BowlingApp(3);
        int[] balls = {7, 3, 10, 5, 4};
        int[] lengths = {0, 0, 1, 1, 3};
        int[] frames = {1, 2, 3, 3, 4};
        int[] finalResult = {20, 39, 48};
        testGame(bowlingApp, balls, lengths, frames, finalResult);
    }

    @Test
    public void testStrikeSpareSpareStrike() {
        BowlingApp bowlingApp = new BowlingApp(3);
        int[] balls = {10, 7, 3, 8, 2, 10};
        int[] lengths = {0, 0, 1, 2, 2, 3};
        int[] frames = {2, 2, 3, 3, 3, 4};
        int[] finalResult = {20, 38, 58};
        testGame(bowlingApp, balls, lengths, frames, finalResult);
    }

    @Test
    public void testStrikeMissStrikeSpare() {
        BowlingApp bowlingApp = new BowlingApp(3);
        int[] balls = {10, 7, 2, 10, 6, 4};
        int[] lengths = {0, 0, 2, 2, 2, 3};
        int[] frames = {2, 2, 3, 3, 3, 4};
        int[] finalResult = {19, 28, 48};
        testGame(bowlingApp, balls, lengths, frames, finalResult);
    }

    @Test
    public void testStrikeMissStrikeMiss() {
        BowlingApp bowlingApp = new BowlingApp(3);
        int[] balls = {10, 7, 2, 10, 6, 3};
        int[] lengths = {0, 0, 2, 2, 2, 3};
        int[] frames = {2, 2, 3, 3, 3, 4};
        int[] finalResult = {19, 28, 47};
        testGame(bowlingApp, balls, lengths, frames, finalResult);
    }

    @Test
    public void testStrikeZeroZeroMiss() {
        BowlingApp bowlingApp = new BowlingApp(3);
        int[] balls = {10, 0, 0, 4, 3};
        int[] lengths = {0, 0, 2, 2, 3};
        int[] frames = {2, 2, 3, 3, 4};
        int[] finalResult = {10, 10, 17};
        testGame(bowlingApp, balls, lengths, frames, finalResult);
    }

    @Test
    public void testStrikeSixZeroMiss() {
        BowlingApp bowlingApp = new BowlingApp(3);
        int[] balls = {10, 6, 0, 4, 3};
        int[] lengths = {0, 0, 2, 2, 3};
        int[] frames = {2, 2, 3, 3, 4};
        int[] finalResult = {16, 22, 29};
        testGame(bowlingApp, balls, lengths, frames, finalResult);
    }

    @Test
    public void testStrikeZeroSixMiss() {
        BowlingApp bowlingApp = new BowlingApp(3);
        int[] balls = {10, 0, 6, 4, 3};
        int[] lengths = {0, 0, 2, 2, 3};
        int[] frames = {2, 2, 3, 3, 4};
        int[] finalResult = {16, 22, 29};
        testGame(bowlingApp, balls, lengths, frames, finalResult);
    }

    @Test
    public void testAllFiveStrikes() {
        BowlingApp bowlingApp = new BowlingApp(3);
        int[] balls = {10, 10, 10, 10, 10};
        int[] lengths = {0, 0, 1, 2, 3};
        int[] frames = {2, 3, 3, 3, 4};
        int[] finalResult = {30, 60, 90};
        testGame(bowlingApp, balls, lengths, frames, finalResult);
    }

    @Test
    public void testStrikeStrikeMiss() {
        BowlingApp bowlingApp = new BowlingApp(3);
        int[] balls = {10, 10, 3, 4};
        int[] lengths = {0, 0, 1, 3};
        int[] frames = {2, 3, 3, 4};
        int[] finalResult = {23, 40, 47};
        testGame(bowlingApp, balls, lengths, frames, finalResult);
    }

    @Test
    public void testMissStrikeStrikeSpare() {
        BowlingApp bowlingApp = new BowlingApp(3);
        int[] balls = {6, 4, 10, 10, 3, 7};
        int[] lengths = {0, 0, 1, 1, 2, 3};
        int[] frames = {1, 2, 3, 3, 3, 4};
        int[] finalResult = {20, 43, 63};
        testGame(bowlingApp, balls, lengths, frames, finalResult);
    }

    @Test
    public void testMissStrikeStrikeMiss() {
        BowlingApp bowlingApp = new BowlingApp(3);
        int[] balls = {6, 4, 10, 10, 3, 4};
        int[] lengths = {0, 0, 1, 1, 2, 3};
        int[] frames = {1, 2, 3, 3, 3, 4};
        int[] finalResult = {20, 43, 60};
        testGame(bowlingApp, balls, lengths, frames, finalResult);
    }


    private void testGame(BowlingApp bowlingApp, int[] balls, int[] lengths, int[] frames,
                          int[] finalResult) {
        int[] result;
        for (int k = 0; k < balls.length; k++) {
            result = bowlingApp.roll(balls[k]);
            assertEquals("checking length of result of ball " + k,
                    lengths[k], result.length);
            for (int j = 0; j < result.length; j++) {
                assertEquals("checking frame " + j + " in result of ball " + k,
                        finalResult[j], result[j]);
            }
            assertEquals("checking frame number after ball " + k,
                    frames[k], bowlingApp.frameNumber());
            if (lengths[k] == 0) {
                assertEquals("checking score after ball " + k, 0, bowlingApp.scoreSoFar());
            } else {
                assertEquals("checking score after ball " + k,
                        result[result.length - 1], bowlingApp.scoreSoFar());
            }
            assertEquals("checking if game is over after ball " + k,
                    k == balls.length - 1, bowlingApp.gameIsOver());
        }
    }


}