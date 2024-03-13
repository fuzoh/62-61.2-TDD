package ch.hearc.bnd.tdd;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class BowlingTest {

    @Test
    void Roll_GivenZeroPins_ShouldBeZero() {
        Bowling bowling = new Bowling();
        IntStream
                .range(0, 20)
                .forEach(i -> bowling.roll(0));
        assertEquals(0, bowling.score());
    }

    @Test
    void Roll_GivenOnePin_ShouldBeTwenty() {
        Bowling bowling = new Bowling();
        IntStream
                .range(0, 20)
                .forEach(i -> bowling.roll(1));
        assertEquals(20, bowling.score());
    }

    @Test
    void Roll_GivenSpareOfFivePlusFive_ShouldBeSixteen() {
        Bowling bowling = new Bowling();
        bowling.roll(5);
        bowling.roll(5); // Spare
        bowling.roll(3);
        assertEquals(16, bowling.score());
    }

    @Test
    void Roll_GivenStrikePlusThreePlusFour_ShouldBeTwentyFour() {
        Bowling bowling = new Bowling();
        bowling.roll(10); // Strike
        bowling.roll(3);
        bowling.roll(4);
        assertEquals(24, bowling.score());
    }

    @Test
    void Roll_GivenPerfectGame_ShouldBeThreeHundred() {
        Bowling bowling = new Bowling();
        IntStream
                .range(0, 12)
                .forEach(i -> bowling.roll(10));
        assertEquals(300, bowling.score());
    }
}
