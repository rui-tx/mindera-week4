package atmexceptions.exceptions.atm;

public abstract class ATMException extends Exception {
    public ATMException() {
        super("General ATM Exception. Please try again later.");
    }

    public ATMException(String message) {
        super(message);
    }
}
