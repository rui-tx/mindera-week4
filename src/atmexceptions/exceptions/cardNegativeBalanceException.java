package atmexceptions.exceptions;

public class cardNegativeBalanceException extends Exception {
    public cardNegativeBalanceException() {
        super("Card has negative balance.");
    }

    public cardNegativeBalanceException(String message) {
        super(message);
    }
}
