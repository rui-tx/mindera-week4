package atmexceptions;

public class Main {
    public static void main(String[] args) {

        ErrorCodesEnum check;
        Card card1 = new Card("Rui", 20);
        ATM atm = new ATM("CGD");
        ATM atm2 = new ATM("Novo Banco");

        // user tries pin
        /*
        boolean stop = false;
        while(!stop) {
            check = atm.enterCard(card1, Random.getRandomNumber(1,20));
            switch (check) {
                case CARD_BLOCKED:
                    return;
                case PIN_ERROR:
                    break;
                case PIN_MAX_ATTEMPTS_REACHED:
                    return;
                case SUCCESS:
                    stop = true;
            }
        }

         */

        atm.enterCard(card1, 21);
        atm.enterCard(card1, 21);
        atm.enterCard(card1, 21);
        atm2.enterCard(card1, 20);

        atm.checkBalance();
        atm.withdraw(500);
        atm.withdraw(400);
        atm.checkBalance();
        atm.enterCard(card1, 20);
        atm.ejectCard();

        /*
        atm.enterCard(card1, Random.getRandomNumber(1,20));
        atm.enterCard(card1, Random.getRandomNumber(1,20));
        atm.enterCard(card1, Random.getRandomNumber(1,20));


        atm.checkBalance();
        atm.withdraw(2000);
        atm.withdraw(2000);
        atm.ejectCard();
         */

    }
}