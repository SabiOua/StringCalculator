package io.takima.stringcalculator.parser;

import io.takima.stringcalculator.exceptions.EmptyElementException;
import io.takima.stringcalculator.exceptions.InvalidDelimiterException;
import io.takima.stringcalculator.exceptions.NegativeNumberException;

import java.util.List;
import java.util.stream.Collectors;


public class StringCalculatorUtils {

    private final static String STANDARD_DELIMITER = "[,\\n]";
    private final static String CUSTOM_DELIMITER_STARTING_PATTERN = "//";
    private final static String CUSTOM_DELIMITER_ENDING_PATTERN = "\n";


    /**
     * check if there is negative numbers a list of numbers it throws an exception
     * @param numbers, a list of numbers
     */
    public static void assertOnlyPositiveNumbers(List<Integer> numbers) {

        var negativeNumbers = numbers.stream()
                .filter(number -> number < 0)
                .collect(Collectors.toList());

        if (!negativeNumbers.isEmpty()) throw new NegativeNumberException(negativeNumbers);
    }

    /**
     * checks if the given string has a custom delimiter
     * @param numbers, a list of string numbers in a specific format
     * @return boolean if ot has a custom delimiter or not
     */
    public static boolean hasCustomDelimiter(String numbers) {
        if (numbers == null) throw new EmptyElementException();
        return numbers.trim().startsWith(CUSTOM_DELIMITER_STARTING_PATTERN);
    }

    /**
     * checks if the given string has a custom delimiter, throws exception if format not valid
     * @param numbers, a list of string numbers in a specific format
     * @return a list of splitted string numbers
     */
    public static String[] splitNumbers (String numbers) {
        if (hasCustomDelimiter(numbers)) {
            var delimiters = numbers.substring(2).split(CUSTOM_DELIMITER_ENDING_PATTERN);
            return delimiters[1].split(delimiters[0].replace("][", ""));  // for the type [*][%]
        }

        var splittedNumbers = numbers.split(STANDARD_DELIMITER);

        if(splittedNumbers[0].equals(numbers)) throw new InvalidDelimiterException();
        return splittedNumbers;
    }


}
