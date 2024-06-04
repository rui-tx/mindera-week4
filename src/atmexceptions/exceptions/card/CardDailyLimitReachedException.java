package atmexceptions.exceptions.card;

public class CardDailyLimitReachedException extends CardException {
    public CardDailyLimitReachedException() {
        super("Current daily limit reached.");
    }

    public CardDailyLimitReachedException(String message) {
        super(message);
    }
}
