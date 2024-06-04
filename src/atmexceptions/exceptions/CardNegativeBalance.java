package atmexceptions.exceptions;

public class CardNegativeBalance extends Exception {
    public CardNegativeBalance() {
        super("Card has negative balance.");
    }

    public CardNegativeBalance(String message) {
        super(message);
    }
}
