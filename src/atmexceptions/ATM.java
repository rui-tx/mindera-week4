package atmexceptions;

import atmexceptions.exceptions.*;

import static atmexceptions.ErrorCodesEnum.*;

public class ATM {

    private String atmName;
    private Card card;

    public ATM(String name) {
        this.atmName = name;
    }

    public ErrorCodesEnum enterCard(Card card, int pin) {
        if (this.card != null) {
            //throw new atmNoCardInsertedException();
            return CARD_ALREADY_IN;
        }

        try {
            card.checkPin(pin);
        } catch (CardBlocked e) {
            System.out.println(e.getMessage());
            return CARD_BLOCKED;

        } catch (CardPinToManyAttempts e) {
            System.out.println(e.getMessage());
            return PIN_MAX_ATTEMPTS_REACHED;

        } catch (CardPinError e) {
            System.out.println(e.getMessage());
            return PIN_ERROR;

        } catch (Exception e) {
            System.out.println("Generic Error: " + e.getMessage());
            return GENERIC_ERROR;
        }

        this.card = card;
        System.out.println(">>> Welcome to " + this.atmName + " ATM <<<");

        return SUCCESS;
    }

    public ErrorCodesEnum withdraw(int withdrawValue) {

        try {
            card.withdraw(withdrawValue);

        } catch (CardNegativeBalance e) {
            System.out.println("Can't withdraw: " + e.getMessage());
            return NO_BALANCE;

        } catch (CardWithdrawLimit e) {
            System.out.println("Can't withdraw: " + e.getMessage());
            return WITHDRAW_HIGHER_THEN_ALLOWED;

        } catch (CardDailyLimitReached e) {
            System.out.println("Can't withdraw: " + e.getMessage());
            return DAILY_LIMIT_REACHED;

        } catch (Exception e) {
            System.out.println("Can't withdraw: " + e.getMessage());
            return GENERIC_ERROR;
        }

        System.out.println("Successfully withdraw: " + withdrawValue + "€");
        return SUCCESS;
    }

    public ErrorCodesEnum ejectCard() {
        if (card == null) {
            return NO_CARD;
        }

        System.out.println(">>> See you next time! <<<");
        this.card = null;
        return SUCCESS;
    }

    public ErrorCodesEnum checkBalance() {
        if (card == null) {
            return NO_CARD;
        }

        System.out.println("Current card balance: " + card.getBalance() + "€");
        return SUCCESS;
    }
}