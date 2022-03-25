package io.takima.stringcalculator.parser;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static io.takima.stringcalculator.parser.StringCalculatorUtils.assertOnlyPositiveNumbers;

public class StringParser {

    private final static Integer BIG_NUMBER = 1000;

    /**
     * checks if the given string has a custom delimiter, throws exception if there is a negative number
     * @param numbers, a list of string numbers in a specific format
     * @return a list or numbers
     */
    public static List<Integer> parseNumbers(String numbers) {

        var stringNumbers = StringCalculatorUtils.splitNumbers(numbers);

        var integerNumbers = Arrays.stream(stringNumbers)
                .filter(number -> !number.isEmpty())
                .map(Integer::parseInt)
                .filter(number -> number <= BIG_NUMBER)
                .collect(Collectors.toList());

        assertOnlyPositiveNumbers(integerNumbers);
        return integerNumbers;
    }
}
