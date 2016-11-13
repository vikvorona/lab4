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
        assertEquals("bad frame # for new Scorer",
                1, s.frameNumber());
        assertEquals("bad score for new Scorer",
                0, s.scoreSoFar());
        assertFalse("game is over for new Scorer",
                s.gameIsOver());
    }

    @Test
    public void testFirstRoll() {
        BowlingApp s = new BowlingApp();
        int[] result = s.roll(1);
        assertEquals("result of 1st roll is wrong",
                0, result.length);
        assertEquals("frame # after 1st ball is wrong",
                1, s.frameNumber());
        assertEquals("score after 1st ball is wrong",
                0, s.scoreSoFar());
        assertFalse("game is over after 1st ball",
                s.gameIsOver());
    }

    @Test
    public void testFrameOneMiss ( ) {
        BowlingApp s = new BowlingApp ( );
        int[] result = s.roll (2);
        assertEquals ("bad result after frame 1",
                1, result.length);
        assertEquals ("bad result[0] after frame 1",
                3, result[0]);
        assertEquals ("frame # after frame 1 is wrong",
                2, s.frameNumber ( ));
        assertEquals ("score after frame 1 is wrong",
                3, s.scoreSoFar ( ));
        assertFalse ("game is over after 1st frame",
                s.gameIsOver ( ));
    }



}