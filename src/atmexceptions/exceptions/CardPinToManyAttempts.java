package atmexceptions.exceptions;

public class CardPinToManyAttempts extends Exception {

    public CardPinToManyAttempts() {
        super("Too many attempts of card pin.");
    }

    public CardPinToManyAttempts(String message) {
        super(message);
    }
}
