package bowling;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class BowlingGameTest {
	
	BowlingGame bObj = new BowlingGame();
	
	//Test for all for rolls is zero
	@Test
	public void testZeroScore() {
		for(int i = 0; i < BowlingGame.ROLLS; i++)
			bObj.makeRoll(0);
		
		Assert.assertEquals(0, bObj.getResultScore());
	}

}
