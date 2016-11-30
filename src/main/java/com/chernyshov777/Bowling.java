package com.chernyshov777;

import java.util.ArrayList;
import java.util.List;

/**
 * Bowling scoring
 * @author Chernyshov Daniil
 */
public class Bowling {
    private int currentFrame;
    private int totalScore;
    private List<Frame> frames;

    public Bowling() {
        currentFrame = 1;
        totalScore = 0;
        //frames initialisation
        frames = new ArrayList<>(10);
        for (int i = 1; i <= 10; i++) {
            Frame frame = new Frame(i);
            frames.add(frame);
        }
    }

    /**
     * Calculate current game score
     */
    public void calculateScore() {
        totalScore = 0;
        int currentFrame = 0;
        for (Frame frame : frames) {
            if (currentFrame > 0 && currentFrame != 9) {
                if (frames.get(currentFrame-1).isSpare()) {
                    frames.get(currentFrame-1).addBonus(frame.getFirstRollScore());
                }
                if (frames.get(currentFrame-1).isStrike()) {
                    frames.get(currentFrame-1).addBonus(frame.getFirstRollScore()+frame.getSecondRollScore());
                }
            }
            if (currentFrame == 9) {
                if (frames.get(currentFrame).isSpare()) {
                    frames.get(currentFrame).addBonus(frame.getThirdRollScore());
                }
                if (frames.get(currentFrame).isStrike()) {
                    frames.get(currentFrame).addBonus(frame.getSecondRollScore()+frame.getThirdRollScore());
                }
            }
            currentFrame++;
        }

        for (Frame frame : frames) {
            totalScore += frame.getTotalFrameScore();
        }
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public int getTotalScore() {
        return totalScore;
    }
    public List<Frame> getFrames() {
        return frames;
    }
}
