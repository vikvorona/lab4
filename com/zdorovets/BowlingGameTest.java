package com.zdorovets;
import org.junit.Assert;
import org.junit.Test;
/*
 * Unit tests for BowlingGame
 * @author Evgeny Zdorovets
 * created on 21/10/16
 */
public class BowlingGameTest {
	@Test
	public void testGutterGame() throws Exception {
		BowlingGame g = new BowlingGame();
	    for (int i=0; i<20; i++)
	      g.roll(0);
	    Assert.assertEquals(0, g.score());
	}
}
