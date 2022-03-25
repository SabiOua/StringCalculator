package io.takima.stringcalculator.exceptions;

public class InvalidDelimiterException  extends IllegalArgumentException{

    public InvalidDelimiterException() {
        super("The delimiter format is not allowed");
    }
}