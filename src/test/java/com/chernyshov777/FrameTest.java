package com.chernyshov777;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for Frame.
 * @author Chernyshov Daniil
 */
public class FrameTest {
    private Frame frame;

    @Before
    public void init() {
        frame = new Frame(1);
    }

    @Test
    public void testConstructor() {
        Assert.assertEquals("wrong current roll", 1, frame.getCurrentRoll());
        Assert.assertEquals("wrong first Roll score", 0, frame.getFirstRollScore());
        Assert.assertEquals("wrong second Roll score", 0, frame.getSecondRollScore());
        Assert.assertEquals("wrong third Roll score", 0, frame.getThirdRollScore());
    }

    /**
     * Test for simple roll without strike and spare,
     * just test currentRoll parameter, first and second roll score parameters,
     * and total Frame Score
     */
    @Test
    public void testNextRoll() {
        Assert.assertEquals(1, frame.getCurrentRoll());
        frame.nextRoll(5);
        Assert.assertEquals("first roll is wrong", 5, frame.getFirstRollScore());
        Assert.assertEquals("current roll is wrong", 2, frame.getCurrentRoll());
        frame.nextRoll(4);
        Assert.assertEquals("second roll score is wrong" , 4, frame.getSecondRollScore());
        Assert.assertEquals("frame total score is wrong", 9, frame.getTotalFrameScore());
        Assert.assertFalse("total frame score is bigger than 10", frame.getTotalFrameScore() > 10);
    }
}
