package atmexceptions.exceptions.card;

public class CardWithdrawLimitException extends CardException{
    public CardWithdrawLimitException() {
        super("Withdraw value is higher then the limit allowed.");
    }

    public CardWithdrawLimitException(String message) {
        super(message);
    }
}
