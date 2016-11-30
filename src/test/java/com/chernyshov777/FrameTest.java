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
        frame = new Frame();
    }

    @Test
    public void testConstructor() {
        Assert.assertEquals("wrong total score", 0, frame.getTotalScore());
        Assert.assertEquals("wrong current roll", 0, frame.getCurrentRoll());
        Assert.assertEquals("wrong first Roll score", 0, frame.getFirstRollScore());
        Assert.assertEquals("wrong second Roll score", 0, frame.getSecondRollScore());
        Assert.assertEquals("wrong third Roll score", 0, frame.getThirdRollScore());
    }
}
