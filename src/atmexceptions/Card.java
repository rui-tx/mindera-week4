package atmexceptions;

import atmexceptions.exceptions.cardBlockedException;
import atmexceptions.exceptions.cardNegativeBalanceException;
import atmexceptions.exceptions.pinErrorException;
import atmexceptions.exceptions.pinToManyAttemptsException;

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
            throw new cardBlockedException();
        }

        this.numberOfPinAttempts++;
        if(this.numberOfPinAttempts == 3) {
            this.cardBlocked = true;
            throw new pinToManyAttemptsException();
        }

        if (this.pin != pin) {
            throw new pinErrorException();
        }

        this.numberOfPinAttempts = 0;
        return true;
    }

    protected int getBalance() {
        return this.balance;
    }

    protected int withdraw(int withdrawValue) throws Exception {

        if (this.dailyWithdrawMaxReached) {
            // throw new cardDailyLimitReached
            throw new Exception("Current daily limit reached.");
        }

        if (withdrawValue > this.withdrawLimit) {
            // throw new cardWithdrawLimit
            throw new Exception("Max withdraw is: " + this.withdrawLimit);
        }

        if((this.balance - withdrawValue) < 0) {
            throw new cardNegativeBalanceException();
        }

        this.currentWithdraw += withdrawValue;
        if (currentWithdraw > this.withdrawLimit) {
            this.dailyWithdrawMaxReached = true;
            // throw new cardWithdrawLimitReached
            throw new Exception("Withdraw limit reached.");
        }

        this.balance -= withdrawValue;
        return withdrawValue;
    }
}
