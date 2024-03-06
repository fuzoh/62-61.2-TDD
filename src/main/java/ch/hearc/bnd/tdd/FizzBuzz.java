package ch.hearc.bnd.tdd;

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
}
