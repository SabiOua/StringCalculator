package io.takima.stringcalculator.exceptions;

public class EmptyElementException extends IllegalArgumentException{

    public EmptyElementException() {
        super("The given element is empty");
    }
}