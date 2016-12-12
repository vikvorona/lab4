package com.vorona.strike;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BowlingTest {

	private Bowling game = new Bowling();
	
	private void rollIt(int pin, int rolls) {
		for (int i=0; i<rolls; i++) {
			game.roll(pin);
		}
	}
	
	@Test
	public void rollGame() {
		rollIt(1,20);
		assertEquals(20, game.getScore());
	}
	
	@Test
	public void rollSpare() {
		game.roll(8);
		game.roll(2);
		game.roll(4);
		rollIt(0,17);
		assertEquals(18, game.getScore());
	}
	
	@Test
	public void rollStrike() {
		game.roll(10);
		game.roll(2);
		game.roll(6);
		rollIt(0,17);
		assertEquals(26, game.getScore());
	}
	
	@Test
	public void rollAllPinsTen() {
		rollIt(10,12);
		assertEquals(300, game.getScore());
	}
}
