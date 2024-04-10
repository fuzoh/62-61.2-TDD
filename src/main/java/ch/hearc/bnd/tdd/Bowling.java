package ch.hearc.bnd.tdd;

import ch.hearc.bnd.tdd.bowling.Frame;

import java.util.*;

public class Bowling {

    private List<Frame> frames = new ArrayList<>();

    private TableauAffichage display;

    public Bowling(TableauAffichage display) {
        this.display = display;
        this.display.seConnecter();
    }

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

    private int getStrikesCount() {
        return (int) frames.stream().filter(Frame::isStrike).count();
    }

    public int score() {
        var score = 0;
        for (var frame : frames) {
            if (frames.indexOf(frame) == 10) {
                break;
            }
            if (frame.isSpare()) {
                score += frame.score() + getFrameFirstRollFromIndex(frames.indexOf(frame) + 1);
                display.showSpare();
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

        // Strikes display
        if (getStrikesCount() == 1) {
            display.showStrike(TableauAffichage.StrikeSerie.PREMIER);
        }

        return score;
    }
}
