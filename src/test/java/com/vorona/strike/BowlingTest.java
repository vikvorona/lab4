package com.vorona.strike;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BowlingTest {

	@Test
	public void RollGame() {
		Bowling game = new Bowling();
		for (int i=0; i<20; i++) {
			game.roll(1);
		}
		assertEquals(20, game.getScore());
	}
}
