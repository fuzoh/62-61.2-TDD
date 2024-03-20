package ch.hearc.bnd.tdd.bowling;

import java.util.Optional;

public class Frame {

    private Integer firstRoll;

    private Integer secondRoll;

    public Frame(Integer firstRoll) {
        this.firstRoll = firstRoll;
    }

    public void roll(int pins) {
        if (secondRoll != null || this.isStrike()) {
            throw new IllegalStateException("Frame is already full");
        } else {
            secondRoll = pins;
        }
    }

    public int score() {
        return firstRoll() + secondRoll();
    }

    public boolean isSpare() {
        if (isStrike()) {
            return false;
        }
        return firstRoll() + secondRoll() == 10;
    }

    public boolean isStrike() {
        return firstRoll() == 10;
    }

    public Integer firstRoll() {
        return Optional.ofNullable(firstRoll).orElse(0);
    }

    public Integer secondRoll() {
        return Optional.ofNullable(secondRoll).orElse(0);
    }
}
