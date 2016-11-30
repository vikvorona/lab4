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
        Assert.assertFalse("strike parameter is wrong", frame.isStrike());
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

    /**
     * Test for nextRoll() with strike and spare opportunity
     */
    @Test
    public void testNextRollWithStrikeAndSpare() {
        Frame strikeFrame = new Frame(2);
        Assert.assertEquals("current roll is wrong", 1, strikeFrame.getCurrentRoll());
        strikeFrame.nextRoll(10);
        Assert.assertTrue("not a strike", strikeFrame.isStrike());

        Frame spareFrame = new Frame(3);
        spareFrame.nextRoll(6);
        spareFrame.nextRoll(4);
        Assert.assertEquals("current roll is wrong", 3, spareFrame.getCurrentRoll());
        Assert.assertTrue("not a spare", spareFrame.isSpare());
        Assert.assertFalse("strike", spareFrame.isStrike());
    }
}
