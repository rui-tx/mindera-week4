package atmexceptions.exceptions.card;

public class CardNegativeBalanceException extends CardException {
    public CardNegativeBalanceException() {
        super("Card has negative balance.");
    }

    public CardNegativeBalanceException(String message) {
        super(message);
    }
}
