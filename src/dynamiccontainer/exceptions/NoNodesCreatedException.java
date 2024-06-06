package dynamiccontainer.exceptions;

public class NoNodesCreatedException extends LinkedListException{
    public NoNodesCreatedException() {
        super("No nodes created.");
    }

    public NoNodesCreatedException(String message) {
        super(message);
    }
}
