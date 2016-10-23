package com.vittach;

import java.util.Random;

import junit.framework.TestCase;

/**
 * Created by VITTACH on 23.10.2016.
 */

public class BowlingTest extends TestCase {
    Bowling bowling;

    /**
     * инициализация игрового процесса
     * @throws GameException
     */
    protected void setUp() throws GameException {
        bowling = new Bowling();
    }

    /**
     * тестирование стандратного игрового случая
     * @throws Exception
     */
    public void testAllGame() throws Exception {
        int pinsByRoll = 0;
        int numberOfRolls = 20;

        rollsCycle(numberOfRolls, pinsByRoll);

        assertEquals(0, bowling.score());
    }

    /**
     * тестирование случая сбития всегда 1 кегли
     * @throws Exception
     */
    public void testAllOnes() throws Exception {
        rollsCycle(20, 1);

        assertEquals(20,bowling.score());
    }

    /**
     * @param num количество бросков
     * @param pins количество сбитых кеглей
     */
    private void rollsCycle(int num, int pins) {
        for (int i = 0; i < num; i++)
            bowling.roll(pins);
    }

    /**
     * тестирование идеального сбития за 2 попытки
     * @throws Exception
     */
    public void testOneSpare() throws Exception {

        rollSpare(); // spare

        bowling.roll(3);

        rollsCycle(7,0);

        // (x=rand(10))+(10-x)+2*3+7*0=16
        assertEquals(16,bowling.score());
    }

    /**
     * тестирование случая страйка
     * @throws Exception
     */
    public void testOneStrike() throws Exception {

        rollStrike(); // strike
        bowling.roll(3);
        bowling.roll(4);

        //10+2*3+2*4=24
        assertEquals(24,bowling.score());
    }

    /**
     * тестирование идеального случая игры
     * @throws Exception
     */
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