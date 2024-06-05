package ioexercise.IoFunctions.exceptions;

public class PathIsNotAbsoluteException extends IoFunctionsException{
    public PathIsNotAbsoluteException() {
        super("Path is not absolute.");
    }

    public PathIsNotAbsoluteException(String message) {
        super(message);
    }
}
