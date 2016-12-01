package com.etu.grigorova;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

/**
 * Test cases for bowling game
 *
 * (for i=0; i<20) - this is 20 throws of our ball (10 frames, 2 throws for every frame)
 *
 * @author AlGrigorova
 */
public class ScoringBowlingTest{
    private ScoringBowling bowling;

    @Before
    public void before(){
        bowling = new ScoringBowling();
    }

    private void throwsInARow (int throwNums, int pins){
        for (int i = 0; i < throwNums; i++) {
            bowling.roll(pins);
        }
        System.out.println(bowling);
    }

    private void throwStrike (){
        bowling.roll(10);
    }

    private void throwSpare(){
        bowling.roll(9);
        bowling.roll(1);
    }

    @Test
    public void testAllFailGame() throws BowlingGameException{
        throwsInARow(20,0);
        Assert.assertEquals(0,bowling.getScore());
    }
    @Test
    public void testAllOnesGame() throws BowlingGameException{
        throwsInARow(20,1);
        Assert.assertEquals(20,bowling.getScore());
    }
    @Test
    public void testOneStrike() throws BowlingGameException{
        throwStrike();
        throwsInARow(18,1);
        Assert.assertEquals(10+2+18,bowling.getScore());
    }
    @Test
    public void testOneSpare() throws BowlingGameException{
        throwSpare();
        throwsInARow(18,1);
        Assert.assertEquals(29,bowling.getScore());
    }
}
