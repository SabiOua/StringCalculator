package io.takima.stringcalculator;

import io.takima.stringcalculator.exceptions.EmptyElementException;
import io.takima.stringcalculator.exceptions.InvalidDelimiterException;
import io.takima.stringcalculator.exceptions.NegativeNumberException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StringCalculatorTests {

    StringCalculator stringCalculator = new StringCalculator();

    private final String TWO_NUMBERS_SEPARATED_BY_COMA = "1,2";
    private final String EMPTY_STRING = "";
    private final String ONE_NUMBER = "1";
    private final String MORE_THAN_TWO_NUMBERS = "1,2,3,4,5";
    private final String BACKLINE_DELIMITER = "1\n2,3";
    private final String NEW_DELIMITER = "//;\n1;2";
    private final String NEGATIVE_NUMBERS = "-1,3,7,-2";
    private final String BIGGER_NUMBERS = "1,2,1002";
    private final String MULTIPLE_LENGTH_DELIMITER = "//[***]\n1***2***3";
    private final String MULTIPLE_DELIMITER = "//[*][%]\n1*2%3";
    private final String MULTIPLE_LENGTH_DELIMITER_WITH_MULTIPLE_DELIMITERS = "//[***][%%%%][!!]\n1***2***3%%%%5!!4";
    private final String INVALID_DELIMITER = "1%2%3";




    @Test
    void should_return_the_sum_of_two_string_numbers_separated_by_coma() {
        assertEquals(3, stringCalculator.add(TWO_NUMBERS_SEPARATED_BY_COMA));
    }

    @Test
    void should_return_0_empty_string(){
        assertEquals(0, stringCalculator.add(EMPTY_STRING));
    }

    @Test
    void should_return_same_number_as_given(){
        assertEquals(1, stringCalculator.add(ONE_NUMBER));
    }

    @Test
    void should_return_sum_of_unknown_amount_of_numbers(){
        assertEquals(15, stringCalculator.add(MORE_THAN_TWO_NUMBERS));
    }

    @Test
    void should_return_sum_numbers_with_two_delimiters(){
        assertEquals(6, stringCalculator.add(BACKLINE_DELIMITER));
    }

    @Test
    void should_return_sum_of_numbers_with_new_delimiter(){
        assertEquals(3, stringCalculator.add(NEW_DELIMITER));
    }

    @Test
    void should_throw_exception_with_negative_numbers(){
        Assertions.assertThrows(NegativeNumberException.class, () -> {
            stringCalculator.add(NEGATIVE_NUMBERS);
        });

    }

    @Test
    void should_not_include_number_bigger_than_1000(){
        assertEquals(3, stringCalculator.add(BIGGER_NUMBERS));
    }

    @Test
    void should_return_sum_with_dilimeters_with_multiple_length(){
        assertEquals(6, stringCalculator.add(MULTIPLE_LENGTH_DELIMITER));
    }

    @Test
    void should_return_sum_with_multiple_delimeters(){
        assertEquals(6, stringCalculator.add(MULTIPLE_DELIMITER));
    }

    @Test
    void should_return_sum_with_multiple_delimeters_with_multiple_lengths(){
        assertEquals(15, stringCalculator.add(MULTIPLE_LENGTH_DELIMITER_WITH_MULTIPLE_DELIMITERS));
    }
    @Test
    void should_throw_error_invalid_delimiter_exception(){
        Assertions.assertThrows(InvalidDelimiterException.class, () -> {
            stringCalculator.add(INVALID_DELIMITER);
        });
    }

    @Test
    void should_throw_error_empty_element_exception(){
        Assertions.assertThrows(EmptyElementException.class, () -> {
            stringCalculator.add(null);
        });
    }


}
