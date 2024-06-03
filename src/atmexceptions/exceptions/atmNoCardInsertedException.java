package atmexceptions.exceptions;

public class atmNoCardInsertedException extends Exception{
    public atmNoCardInsertedException() {
        super("No card inserted on the ATM.");
    }

    public atmNoCardInsertedException(String message) {
        super(message);
    }
}
