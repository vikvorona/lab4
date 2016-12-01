package com.etu.grigorova;

import java.util.ArrayList;

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
        for (int i = 0; i < 20; i++) {
            rolls.add(0);
        }
        rolls.add(0);
    }

    /**
     * Method for score recording
     *
     * @param pins - knocked down pins
     */
    public void roll (int pins) {
        rolls.set(currentRoll,pins);
        currentRoll++;
        if (pins == 10){
            rolls.set(currentRoll,0);
            currentRoll++;
        }
    }

    /**
     * @return current score
     */
    public int getScore () {
        int score = 0;
        for (int roll :
                rolls) {
            score += roll;
        }
        return score;
    }

    @Override
    public String toString () {
        String total = "Total score: " + getScore();
        StringBuilder detail = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            if (((i % 2) == 0) && (i != 20)) {
                detail.append("[").append(rolls.get(i)).append(";");
            } else if (((i % 2) != 0) && (i != 19)) {
                detail.append(rolls.get(i)).append("] ");
            }
        }
        detail.append(rolls.get(19)).append(";").append(rolls.get(20)).append("]");
        return total + "\nThrows: " + "\n" + detail;
    }
}
