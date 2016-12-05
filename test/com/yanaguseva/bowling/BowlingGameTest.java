package com.yanaguseva.bowling;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest {
    BowlingGame game = new BowlingGame();

    @Test
    public void zeroPins() {
        for (int i = 0; i < 20; i++) {
            game.roll(0);
        }
        assertEquals(0, game.getScore());
    }

    @Test
    public void onePins() {
        for (int i = 0; i < 20; i++) {
            game.roll(1);
        }
        assertEquals(20, game.getScore());
    }

    @Test
    public void checkSpare() {
        game.roll(5);
        game.roll(5);
        game.roll(7);
        game.roll(3);
        game.roll(1);
        for (int i = 0; i < 15; i++) {
            game.roll(0);
        }
        assertEquals(29, game.getScore());
    }
}
