package io.takima.stringcalculator.exceptions;

import java.util.List;
import java.util.stream.Collectors;

public class NegativeNumberException extends IllegalArgumentException{

    public NegativeNumberException(List<Integer> negatives) {
        super("Negative numbers are not allowed :" +  negatives.stream()
                .map(Object::toString)
                .collect(Collectors.joining(",")));
    }

}