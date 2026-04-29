package lld.atm;

public class CardInsertedState implements ATMState{

    //Inject ATM
    private final ATM atm;

    public CardInsertedState(ATM atm){
        this.atm = atm;
    }

    //Implement methods
    public void insertCard(Card card) {
        System.out.println("Card already inserted");
    }

    public void enterPin(String pin) {
        if (atm.getCurrentCard().validatePin(pin)) {
            System.out.println("PIN Verified");
            // Mock account lookup
            atm.setCurrentAccount(new Account(atm.getCurrentCard().getAccountNumber(), 25000));
            atm.setState(new PINVerifiedState(atm));
        } else {
            System.out.println("Wrong PIN");
            // In real system, count attempts
        }
    }

    public void selectOperation(TransactionType transactionType) {
        System.out.println("Please enter PIN first");
    }

    public void withdraw(double amount) {
        System.out.println("Please enter PIN first");
    }

    public void deposit(double amount) {
        System.out.println("Please enter PIN first");
    }

    public void checkBalance() {
        System.out.println("Please enter PIN first");
    }

    public void ejectCard() {
        System.out.println("Card Ejected");
        atm.setState(new IdleState(atm));
    }

}
