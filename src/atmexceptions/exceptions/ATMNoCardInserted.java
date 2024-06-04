package atmexceptions.exceptions;

public class ATMNoCardInserted extends Exception{
    public ATMNoCardInserted() {
        super("No card inserted on the ATM.");
    }

    public ATMNoCardInserted(String message) {
        super(message);
    }
}
