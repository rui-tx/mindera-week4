package atmexceptions.exceptions.card;

public abstract class CardException extends Exception {
    public CardException() {
        super("General Card Exception. Please try again later.");
    }

    public CardException(String message) {
        super(message);
    }
}
