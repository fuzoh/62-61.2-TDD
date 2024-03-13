package ch.hearc.bnd.tdd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    @ParameterizedTest
    @ValueSource(ints = {5,10,20,25,45,50,100,125})
    void FizzBuzz_GivenMultipleOfFive_ShouldBeFizz(int number) {
        assertEquals("Fizz", FizzBuzz.fizzBuzz(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {7,14,28,56,77,91})
    void FizzBuzz_GivenMultipleOfSeven_ShouldBeBuzz(int number) {
        assertEquals("Buzz", FizzBuzz.fizzBuzz(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {35,70,140})
    void FizzBuzz_GivenMultipleOfFiveAndSeven_ShouldBeFizzBuzz(int number) {
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,4,8,11,13,16,17,19,22,23,26,29,31,32,34,37,38,41,43,46,47,52,53,58,59,61,62,64,67,68,71,73,74,76,79,82,83,86,89,92,94,97})
    void FizzBuzz_GivenNumberNotMultipleOfFiveAndOrSeven_ShouldBeNumber(int number) {
        assertEquals(String.valueOf(number), FizzBuzz.fizzBuzz(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2, -5, -7, -10, -14, -35, -70, -140})
    void FizzBuzz_GivenNegativeNumber_ShouldThrowAnException(int number) {
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {66,666,6666})
    void FizzBuzz_GivenNumberContainsSix_ShouldBeFizzBuzz(int number) {
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(number));
    }

    @Test
    void FizzBuzzList_GivenRangeOfNumbers_ShouldBeCorrectFizzBuzz() {
        assertEquals(List.of("Fizz", "11", "12", "13", "Buzz"), FizzBuzz.fizzBuzzList(10, 5));
    }

}
