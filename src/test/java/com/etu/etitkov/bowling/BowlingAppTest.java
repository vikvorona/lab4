package com.etu.etitkov.bowling;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BowlingAppTest {

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void testConstructor() {
        BowlingApp s = new BowlingApp();
        assertEquals("frame number for new BowlingApp is wrong", 1, s.frameNumber());
        assertEquals("score for new BowlingApp is wrong", 0, s.scoreSoFar());
        assertFalse("game is over for new BowlingApp", s.gameIsOver());
    }

    @Test
    public void testFourBalls() {
        BowlingApp s = new BowlingApp();
        int[] balls = {1, 2, 4, 1};
        int[] lengths = {0, 1, 1, 2};
        int[] frames = {1, 2, 2, 3};
        int[] finalResult = {3, 8};
        testGame(s, balls, lengths, frames, finalResult);
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
            assertFalse("checking if game is over after ball " + k, bowlingApp.gameIsOver());
        }
    }


}