package com.etu.grigorova;

/**
 * Bowling game realization
 *
 * @author AlGrigorova
 */
public class ScoringBowling {
    private int score = 0;

    /**
     * Method for score recording
     *
      * @param pins - knocked down pins
     */
    public void roll (int pins){
        score+=pins;
    }

    /**
     *
     * @return current score
     */
    public int getScore () {
        return score;
    }

}
