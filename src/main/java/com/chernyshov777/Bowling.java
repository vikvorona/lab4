package com.chernyshov777;

import java.util.ArrayList;
import java.util.List;

/**
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

    private void calculateScore() {
        for (Frame frame : frames) {
            totalScore += frame.getTotalFrameScore();
        }
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public void setCurrentFrame(int currentFrame) {
        this.currentFrame = currentFrame;
    }

    public int getTotalScore() {
        calculateScore();
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public List<Frame> getFrames() {
        return frames;
    }
}
