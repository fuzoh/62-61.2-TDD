package ch.hearc.bnd.tdd;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    @ParameterizedTest
    @ValueSource(ints = {5,10,20,25,45,50,100,125})
    void FizzForMultipleOfFive(int number) {
        assertEquals("Fizz", FizzBuzz.fizzBuzz(number));
    }
}
