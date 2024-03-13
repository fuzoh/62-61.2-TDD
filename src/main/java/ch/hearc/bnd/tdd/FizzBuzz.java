package ch.hearc.bnd.tdd;

import java.util.List;
import java.util.stream.IntStream;

public class FizzBuzz {
    public static String fizzBuzz(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Number must be greater than 0");
        }
        if (String.valueOf(number).contains("66")) {
            return "FizzBuzz";
        }
        if (number % 5 == 0 && number % 7 == 0) {
            return "FizzBuzz";
        }
        if (number % 5 == 0) {
            return "Fizz";
        }
        if (number % 7 == 0) {
            return "Buzz";
        }
        return String.valueOf(number);
    }

    public static List<String> fizzBuzzList(int start, int quantity) {
        return IntStream.range(start, start + quantity)
                .mapToObj(FizzBuzz::fizzBuzz)
                .toList();
    }
}
