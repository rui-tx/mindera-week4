package dynamiccontainer.exceptions;

public class NodeOutOfBoundsException extends LinkedListException{
    public NodeOutOfBoundsException() {
        super("Node is out of bounds.");
    }

    public NodeOutOfBoundsException(String message) {
        super(message);
    }
}
