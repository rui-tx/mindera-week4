package atmexceptions.exceptions;

public class CardDailyLimitReached extends Exception {
    public CardDailyLimitReached() {
        super("Current daily limit reached.");
    }

    public CardDailyLimitReached(String message) {
        super(message);
    }
}
