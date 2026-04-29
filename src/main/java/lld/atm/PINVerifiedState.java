package lld.atm;

public class PINVerifiedState implements ATMState{

    //Inject ATM
    private final ATM atm;

    public PINVerifiedState(ATM atm){
        this.atm = atm;
    }

    //Implement methods
    public void insertCard(Card card) {
        System.out.println("Card already inserted");
    }

    public void enterPin(String pin) {
        System.out.println("PIN already verified");
    }

    public void selectOperation(TransactionType transactionType) {
        System.out.println("Selected: " + transactionType);
        switch (transactionType) {
            case TransactionType.BALANCE_CHECK -> atm.checkBalance();
            case TransactionType.WITHDRAW -> System.out.println("Enter amount to withdraw");
            case TransactionType.DEPOSIT -> System.out.println("Enter amount to deposit");
        }
    }

    public void withdraw(double amount) {
        if (atm.getCurrentAccount().withdraw(amount)) {
            System.out.println("₹" + amount + " dispensed successfully");
            atm.addTransaction(new Transaction(TransactionType.WITHDRAW, amount));
        } else {
            System.out.println("Insufficient Balance");
        }
    }

    public void deposit(double amount) {
        atm.getCurrentAccount().deposit(amount);
        System.out.println("₹" + amount + " deposited successfully");
        atm.addTransaction(new Transaction(TransactionType.DEPOSIT, amount));
    }

    public void checkBalance() {
        System.out.println("Current Balance: ₹" + atm.getCurrentAccount().getBalance());
        atm.addTransaction(new Transaction(TransactionType.BALANCE_CHECK, 0));
    }

    public void ejectCard() {
        System.out.println("Thank you! Card Ejected");
        atm.setState(new IdleState(atm));
    }

}
