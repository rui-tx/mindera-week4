package atmexceptions;

import atmexceptions.exceptions.card.*;

public class Card {

    private String name;
    private int pin;
    private int numberOfPinAttempts;
    private int balance;
    private int withdrawLimit;
    private int currentWithdraw;
    private boolean dailyWithdrawMaxReached;
    private boolean cardBlocked;

    public Card(String name, int pin) {
        this.name = name;
        this.pin = pin;
        this.balance = Random.getRandomNumber(1, 5000);
        this.withdrawLimit = 400;
    }

    protected boolean checkPin(int pin) throws CardException {

        if (this.cardBlocked) {
            throw new CardBlockedException();
        }


        if(this.numberOfPinAttempts == 2) {
            this.cardBlocked = true;
            throw new CardPinToManyAttemptsException();
        }

        if (this.pin != pin) {
            this.numberOfPinAttempts++;
            throw new CardPinErrorException();
        }

        this.numberOfPinAttempts = 0;
        return true;
    }

    protected int getBalance() {
        return this.balance;
    }

    protected int withdraw(int withdrawValue) throws CardException {

        if (this.dailyWithdrawMaxReached) {
            throw new CardDailyLimitReachedException();
        }

        if (withdrawValue > this.withdrawLimit) {
            throw new CardWithdrawLimitException();
        }

        if((this.balance - withdrawValue) < 0) {
            throw new CardNegativeBalanceException("No enough balance to withdraw that value.");
        }

        this.currentWithdraw += withdrawValue;
        if (currentWithdraw > this.withdrawLimit) {
            this.dailyWithdrawMaxReached = true;
            throw new CardDailyLimitReachedException();
        }

        this.balance -= withdrawValue;
        return withdrawValue;
    }
}
