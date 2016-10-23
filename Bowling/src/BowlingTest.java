import junit.framework.TestCase;

/**
 * Created by VITTACH on 23.10.2016.
 */

public class BowlingTest extends TestCase {
    public void testGame() throws Exception {
        Bowling g = new Bowling();
        for (int i = 0; i < 20;i++)
            g.roll(0);
        assertEquals(0, g.score());
    }
}