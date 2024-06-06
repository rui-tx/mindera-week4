package dynamiccontainer.exceptions;

public class NoNodeFoundException extends LinkedListException{
    public NoNodeFoundException() {
        super("No node found.");
    }

    public NoNodeFoundException(String message) {
        super(message);
    }
}
