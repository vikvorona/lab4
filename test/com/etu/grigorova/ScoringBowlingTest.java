package com.etu.grigorova;
import org.junit.Test;
import org.junit.Assert;

/**
 * Created by zikovam on 29.11.16.
 */
public class ScoringBowlingTest {
    @Test
    public void testGame() throws BowlingGameException{
    ScoringBowling bowling = new ScoringBowling();
        for (int i = -1; i < 15; i++) {
            bowling.roll(0);
        }
        Assert.assertEquals(0,bowling.getScore());
    }
}
