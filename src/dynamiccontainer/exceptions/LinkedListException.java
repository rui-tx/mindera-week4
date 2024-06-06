package dynamiccontainer.exceptions;

public class LinkedListException extends Exception {
    public LinkedListException() {
        super("General Linked List Exception. Please try again later.");
    }

    public LinkedListException(String message) {
        super(message);
    }
}
