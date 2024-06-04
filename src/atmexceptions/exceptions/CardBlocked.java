package atmexceptions.exceptions;

public class CardBlocked extends Exception{
    public CardBlocked() {
        super("Card is blocked. Please go to your local bank to fix the issue.");
    }

    public CardBlocked(String message) {
        super(message);
    }
}
