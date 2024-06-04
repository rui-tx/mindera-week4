package atmexceptions.exceptions.card;

public class CardBlockedException extends CardException{
    public CardBlockedException() {
        super("Card is blocked. Please go to your local bank to fix the issue.");
    }

    public CardBlockedException(String message) {
        super(message);
    }
}
