package io.takima.stringcalculator;

import io.takima.stringcalculator.exceptions.EmptyElementException;
import io.takima.stringcalculator.parser.StringCalculatorUtils;
import io.takima.stringcalculator.parser.StringParser;

public class StringCalculator {
    /**
     *
     * @param numbers, a string with a specific format
     * @return, the sum of the numbers in the string
     */

    public int add(String numbers) {

        if (numbers == null) throw new EmptyElementException();

        if (numbers.isEmpty()) return 0;
        if (numbers.matches("[0-9]+")) return Integer.parseInt(numbers);

        return StringParser.parseNumbers(numbers)
                .stream()
                .reduce(0, Integer::sum);
    }
}
