package atmexceptions.exceptions.card;

public class CardPinToManyAttemptsException extends CardException {

    public CardPinToManyAttemptsException() {
        super("Too many failed attempts of card pin. This card is now blocked.");
    }

    public CardPinToManyAttemptsException(String message) {
        super(message);
    }
}
