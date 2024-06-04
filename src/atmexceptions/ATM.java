package atmexceptions;

import atmexceptions.exceptions.card.*;

import static atmexceptions.ErrorCodesEnum.*;

public class ATM {

    private String atmName;
    private Card card;

    public ATM(String name) {
        this.atmName = name;
    }

    public ErrorCodesEnum enterCard(Card card, int pin) {
        if (this.card != null) {
            return CARD_ALREADY_IN;
        }

        try {
            card.checkPin(pin);
        } catch (CardBlockedException e) {
            System.out.println(e.getMessage());
            return CARD_BLOCKED;

        } catch (CardPinToManyAttemptsException e) {
            System.out.println(e.getMessage());
            return PIN_MAX_ATTEMPTS_REACHED;

        } catch (CardPinErrorException e) {
            System.out.println(e.getMessage());
            return PIN_ERROR;

        } catch (CardException e) {
            System.out.println("Error: " + e.getMessage());
            return GENERIC_ERROR;
        }

        this.card = card;
        System.out.println(">>> Welcome to " + this.atmName + " ATM <<<");

        return SUCCESS;
    }

    public ErrorCodesEnum withdraw(int withdrawValue) {
        if (card == null) {
            return NO_CARD;
        }

        try {
            card.withdraw(withdrawValue);

        } catch (CardNegativeBalanceException e) {
            System.out.println("Can't withdraw: " + e.getMessage());
            return NO_BALANCE;

        } catch (CardWithdrawLimitException e) {
            System.out.println("Can't withdraw: " + e.getMessage());
            return WITHDRAW_HIGHER_THEN_ALLOWED;

        } catch (CardDailyLimitReachedException e) {
            System.out.println("Can't withdraw: " + e.getMessage());
            return DAILY_LIMIT_REACHED;

        } catch (CardException e) {
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