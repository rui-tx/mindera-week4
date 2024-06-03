package atmexceptions;

public enum ErrorCodesEnum {
    // Generic errors
    SUCCESS(0, "Operation concluded with success."),
    GENERIC_ERROR(-1, "Something went wrong, please try again later."),

    // ATM related errors
    NO_CARD(100, "No card on the ATM."),
    CARD_ALREADY_IN(101, "Card is already in the ATM. Please eject first."),

    // Card related errors
    PIN_ERROR(200, "Pin error."),
    PIN_MAX_ATTEMPTS_REACHED(201, "Card pin max attempts reached"),
    NO_BALANCE(202, "No balance."),
    CARD_BLOCKED(203, "Card is blocked.");

    private int id;
    private String errorString;

    ErrorCodesEnum(int id, String errorString) {
        this.id = id;
        this.errorString = errorString;
    }

    public String getErrorString() {
        return this.errorString;
    }
}
