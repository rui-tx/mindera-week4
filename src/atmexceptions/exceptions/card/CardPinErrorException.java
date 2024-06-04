package atmexceptions.exceptions.card;

public class CardPinErrorException extends CardException {

    public CardPinErrorException() {
        super("Incorrect card pin.");
    }

    public CardPinErrorException(String message) {
        super(message);
    }
}
