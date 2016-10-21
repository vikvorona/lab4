package com.zdorovets;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;
/*
 * MyException class
 * @author Evgeny Zdorovets
 * created on 21/10/16
 */
class MyException extends Exception {
    private static final long serialVersionUID = 1L;
    public MyException(String message) {
        super(message);
    }
}
/*
 * Unit tests for BowlingGame
 * @author Evgeny Zdorovets
 * created on 21/10/16
 */
public class BowlingGameTest extends TestCase {
	private BowlingGame g;
	/*
	 * создает игру
	 */
	protected void setUp() throws Exception {
		g = new BowlingGame();
	}
	
	private void rollMany(int n, int pins){
		for (int i=0; i<n; i++)
	    	g.roll(pins);
	}
	
	@Test
	public void testGutterGame() throws Exception {
		rollMany(20, 0);
	    Assert.assertEquals(0, g.score());
	}
	
	@Test
	public void testAllOnes() throws Exception {
		rollMany(20, 1);
	    Assert.assertEquals(20, g.score());
	}
}
