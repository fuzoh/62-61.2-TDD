package ch.hearc.bnd.tdd;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    @ParameterizedTest
    @ValueSource(ints = {5,10,20,25,45,50,100,125})
    void FizzForMultipleOfFive(int number) {
        assertEquals("Fizz", FizzBuzz.fizzBuzz(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {7,14,28,56,77,91})
    void BuzzForMultipleOfSeven(int number) {
        assertEquals("Buzz", FizzBuzz.fizzBuzz(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {35,70,140})
    void FizzBuzzForMultipleOfFiveAndSeven(int number) {
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,4,8,11,13,16,17,19,22,23,26,29,31,32,34,37,38,41,43,46,47,52,53,58,59,61,62,64,67,68,71,73,74,76,79,82,83,86,89,92,94,97})
    void NumberForOtherCases(int number) {
        assertEquals(String.valueOf(number), FizzBuzz.fizzBuzz(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2, -5, -7, -10, -14, -35, -70, -140})
    void ExceptionForNegativeOrZero(int number) {
        assertThrows(IllegalArgumentException.class, () -> FizzBuzz.fizzBuzz(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {66,666,6666})
    void FizzBuzzFor66Number(int number) {
        assertEquals("FizzBuzz", FizzBuzz.fizzBuzz(number));
    }

    @Test
    void FizzBuzzList() {
        assertEquals(List.of("Fizz", "11", "12", "13", "Buzz"), FizzBuzz.fizzBuzzList(10, 5));
    }
}
