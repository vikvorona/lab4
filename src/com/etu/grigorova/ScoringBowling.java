package com.etu.grigorova;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/**
 * Bowling game realization
 *
 * @author AlGrigorova
 */
public class ScoringBowling {
    private ArrayList<Integer> rolls;

    private int currentRoll;

    public ScoringBowling () {
        currentRoll = 0;
        rolls = new ArrayList<>();
    }

    /**
     * Method for score recording
     *
     * @param pins - knocked down pins
     */
    public void roll (int pins) {
        rolls.add(pins);
        currentRoll++;
    }

    /**
     * @return current score
     */
    public int getScore () {
        int score = 0;
        int currentFrame = 0;
        ListIterator<Integer> iter = rolls.listIterator();
        while (iter.hasNext()) {
            int roll = iter.next();
            if (roll == 10) {
                score += 10;
                score += rolls.get(iter.nextIndex()) + rolls.get(iter.nextIndex() + 1);
            } else {
                score += roll;
            }
        }
        return score;
    }

    @Override
    public String toString () {
        String total = "Total score: " + getScore();
        return total + "\nThrows: " + "\n" + rolls;
    }
}
