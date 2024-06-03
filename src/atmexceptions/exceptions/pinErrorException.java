package atmexceptions.exceptions;

public class pinErrorException extends Exception {

    public pinErrorException() {
        super("Incorrect card pin.");
    }

    public pinErrorException(String message) {
        super(message);
    }
}
