package atmexceptions;

import atmexceptions.exceptions.*;

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

    protected boolean checkPin(int pin) throws Exception {

        if (this.cardBlocked) {
            throw new CardBlocked();
        }

        this.numberOfPinAttempts++;
        if(this.numberOfPinAttempts == 3) {
            this.cardBlocked = true;
            throw new CardPinToManyAttempts();
        }

        if (this.pin != pin) {
            throw new CardPinError();
        }

        this.numberOfPinAttempts = 0;
        return true;
    }

    protected int getBalance() {
        return this.balance;
    }

    protected int withdraw(int withdrawValue) throws Exception {

        if (this.dailyWithdrawMaxReached) {
            throw new CardDailyLimitReached();
        }

        if (withdrawValue > this.withdrawLimit) {
            throw new CardWithdrawLimit();
        }

        if((this.balance - withdrawValue) < 0) {
            throw new CardNegativeBalance("No enough balance to withdraw that value.");
        }

        this.currentWithdraw += withdrawValue;
        if (currentWithdraw > this.withdrawLimit) {
            this.dailyWithdrawMaxReached = true;
            throw new CardDailyLimitReached();
        }

        this.balance -= withdrawValue;
        return withdrawValue;
    }
}
