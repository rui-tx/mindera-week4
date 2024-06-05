package ioexercise.IoFunctions.exceptions;

public class InvalidPathException extends IoFunctionsException {
    public InvalidPathException() {
        super("Path does not exist / Path is invalid.");
    }

    public InvalidPathException(String message) {
        super(message);
    }
}
