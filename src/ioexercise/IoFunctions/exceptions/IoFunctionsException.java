package ioexercise.IoFunctions.exceptions;

public abstract class IoFunctionsException extends Exception {
    public IoFunctionsException() {
        super("General IO Exception. Please try again later.");
    }

    public IoFunctionsException(String message) {
        super(message);
    }
}
