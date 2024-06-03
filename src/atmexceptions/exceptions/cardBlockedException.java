package atmexceptions.exceptions;

public class cardBlockedException extends Exception{
    public cardBlockedException() {
        super("Card is blocked. Please go to your local bank to fix the issue.");
    }

    public cardBlockedException(String message) {
        super(message);
    }
}
