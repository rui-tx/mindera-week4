package atmexceptions.exceptions;

public class pinToManyAttemptsException extends Exception {

    public pinToManyAttemptsException() {
        super("Too many attempts of card pin.");
    }

    public pinToManyAttemptsException(String message) {
        super(message);
    }
}
