package atmexceptions.exceptions;

public class CardWithdrawLimit extends Exception{
    public CardWithdrawLimit() {
        super("Withdraw value is higher then the limit allowed.");
    }

    public CardWithdrawLimit(String message) {
        super(message);
    }
}
