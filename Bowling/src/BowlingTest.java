import junit.framework.TestCase;

import java.util.Random;

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

        rollSpare(); // spare

        bowling.roll(3);

        rollsCycle(7,0);

        // (x=rand(10))+(10-x)+2*3+7*0=16
        assertEquals(16,bowling.score());
    }

    public void testOneStrike() throws Exception {

        rollStrike(); // strike
        bowling.roll(3);
        bowling.roll(4);

        //10+2*3+2*4=24
        assertEquals(24,bowling.score());
    }

    public void testIdealGame() throws Exception {
        rollsCycle(12,10);
        assertEquals(300,bowling.score());
    }

    private void rollStrike() {
        bowling.roll(10);
    }

    private void rollSpare() {
        Random r = new Random();
        int number=r.nextInt(10);
        bowling.roll(number);
        bowling.roll(10-number);
    }
}