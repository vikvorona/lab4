import junit.framework.TestCase;

/**
 * Created by VITTACH on 23.10.2016.
 */

public class BowlingTest extends TestCase {
    Bowling bowling = new Bowling();

    public void testAllGame() throws Exception {
        int pinsByRoll = 0;
        int numberOfRolls = 20;

        rollsCycle(numberOfRolls, pinsByRoll);

        assertEquals(0, bowling.score());
    }

    public void testAllOnes() throws Exception {
        rollsCycle(20, 1);

        assertEquals(20,bowling.score());
    }

    private void rollsCycle(int num, int pins) {
        for (int i = 0; i < num; i++)
            bowling.roll(pins);
    }

    public void testOneSpare() throws Exception {

        bowling.roll(5);
        bowling.roll(5); // spare
        bowling.roll(3);

        rollsCycle(7,0);

        assertEquals(16,bowling.score());
    }
}