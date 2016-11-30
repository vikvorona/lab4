package com.chernyshov777;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Unit test for simple Bowling.
 * @author Chernyshov Daniil
 */
public class BowlingTest {
    private Bowling bowling;

    @Before
    public void init() {
        bowling = new Bowling();
    }

    @Test
    public void testConstructor() {
        Assert.assertEquals("wrong current frame", 1, bowling.getCurrentFrame());
        Assert.assertEquals("wrong total score", 0, bowling.getTotalScore());
        Assert.assertEquals("frames creation error", 10, bowling.getFrames().size());
        Assert.assertEquals("frame number error", 2, bowling.getFrames().get(1).getFrameNumber());
    }

    /**
     * Simple game test.
     * Check totalScore for game.
     */
    @Test
    public void testSimplePlayGame() {
        for (Frame frame : bowling.getFrames()) {
            frame.nextRoll(4);
            frame.nextRoll(3);
        }
        Assert.assertEquals("total score error", 70, bowling.getTotalScore());
    }

    /**
     * Simple game with spare test.
     * Check totalScore if there was spare in game
     */
    @Test
    public void testPlayGameWithSpare() {
        int currentFrame = 0;
        for (Frame frame : bowling.getFrames()) {
            if (currentFrame == 2) {
                frame.nextRoll(5);
                frame.nextRoll(5);
            }
            frame.nextRoll(4);
            frame.nextRoll(3);
            currentFrame++;
        }
        Assert.assertEquals("total score error", 77, bowling.getTotalScore());
    }
}
