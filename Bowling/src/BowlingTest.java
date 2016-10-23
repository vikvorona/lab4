import junit.framework.TestCase;

/**
 * Created by VITTACH on 23.10.2016.
 */

public class BowlingTest extends TestCase {
    Bowling bowling = new Bowling();

    public void testAllZero() throws Exception {
        for (int i = 0; i < 20;i++)
            bowling.roll(0);

        assertEquals(0, bowling.score());
    }

    public void testAllOnes() throws Exception {
        for (int i = 0; i < 20; i++)
            bowling.roll(1);

        assertEquals(20,bowling.score());
    }
}