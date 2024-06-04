package atmexceptions.exceptions;

public class CardPinError extends Exception {

    public CardPinError() {
        super("Incorrect card pin.");
    }

    public CardPinError(String message) {
        super(message);
    }
}
