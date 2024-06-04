package atmexceptions.exceptions.atm;

public class ATMNoCardInsertedException extends ATMException {
    public ATMNoCardInsertedException() {
        super("No card inserted on the ATM.");
    }

    public ATMNoCardInsertedException(String message) {
        super(message);
    }
}
