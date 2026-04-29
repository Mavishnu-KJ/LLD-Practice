package lld.atm;

public class IdleState implements ATMState{

    //Inject ATM
    private final ATM atm;

    public IdleState(ATM atm){
        this.atm = atm;
    }

    //Implement methods
    public void insertCard(Card card) {
        System.out.println("Card Inserted");
        atm.setCurrentCard(card);
        atm.setState(new CardInsertedState(atm));
    }

    public void enterPin(String pin) {
        System.out.println("Please insert card first");
    }

    public void selectOperation(TransactionType transactionType) {
        System.out.println("Please insert card first");
    }

    public void withdraw(double amount) {
        System.out.println("Please insert card first");
    }

    public void deposit(double amount) {
        System.out.println("Please insert card first");
    }

    public void checkBalance() {
        System.out.println("Please insert card first");
    }

    public void ejectCard() {
        System.out.println("No card to eject");
    }

}
