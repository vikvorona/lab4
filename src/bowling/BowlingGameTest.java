package bowling;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class BowlingGameTest {
	
	BowlingGame bObj = new BowlingGame();
	
	@Test
	public void testZeroScore() {
		for(int i = 0; i < BowlingGame.ROLLS; i++)
			bObj.makeRoll(0);
		
		Assert.assertEquals(0, bObj.getResultScore());
	}
	
	@Test
	public void testSpareScore() {
		bObj.makeRoll(3);
		bObj.makeRoll(7);
		bObj.makeRoll(3);
		bObj.makeRoll(3);
		
		for(int i = 0; i < BowlingGame.ROLLS - 4; i++)
			bObj.makeRoll(0);
		
		Assert.assertEquals(19, bObj.getResultScore());
	}
	
	@Test
	public void testStrikeScore() {
		bObj.makeRoll(10);
		//
		bObj.makeRoll(3);
		bObj.makeRoll(3);
		for(int i = 0; i < BowlingGame.ROLLS - 6; i++)
			bObj.makeRoll(0);
		
		bObj.makeRoll(4);
		bObj.makeRoll(0);
		Assert.assertEquals(26, bObj.getResultScore());
	}

}
