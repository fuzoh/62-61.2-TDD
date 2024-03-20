package ch.hearc.bnd.tdd;

import ch.hearc.bnd.tdd.bowling.Frame;

import java.util.*;

public class Bowling {

    private List<Frame> frames = new ArrayList<>();

    public void roll(int pin) {
        try {
            frames.getLast().roll(pin);
        } catch (NoSuchElementException | IllegalStateException e) {
            frames.add(new Frame(pin));
        }
    }

    private Optional<Frame> getFrameFromIndex(int index) {
        try {
            return Optional.of(frames.get(index));
        } catch (IndexOutOfBoundsException e) {
            return Optional.empty();
        }
    }

    private int getFrameScoreFromIndex(int index) {
        return getFrameFromIndex(index).map(Frame::score).orElse(0);
    }

    private int getFrameFirstRollFromIndex(int index) {
        return getFrameFromIndex(index).map(Frame::firstRoll).orElse(0);
    }

    public int score() {
        var score = 0;
        for (var frame : frames) {
            if (frames.indexOf(frame) == 10) {
                break;
            }
            if (frame.isSpare()) {
                score += frame.score() + getFrameFirstRollFromIndex(frames.indexOf(frame) + 1);
            } else if (frame.isStrike()) {
                if (getFrameFromIndex(frames.indexOf(frame) + 1).map(Frame::isStrike).orElse(false)) {
                    score += frame.score() + getFrameScoreFromIndex(frames.indexOf(frame) + 1) + getFrameFirstRollFromIndex(frames.indexOf(frame) + 2);
                } else {
                    score += frame.score() + getFrameScoreFromIndex(frames.indexOf(frame) + 1);
                }
            } else {
                score += frame.score();
            }
        }
        return score;
    }
}
