package dynamiccontainer.exceptions;

public class NodeOutOfBandsException extends LinkedListException{
    public NodeOutOfBandsException() {
        super("Node is out of bounds.");
    }

    public NodeOutOfBandsException(String message) {
        super(message);
    }
}
