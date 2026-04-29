package lld.atm;

public interface ATMState {
    void insertCard(Card card);
    void enterPin(String pin);
    void selectOperation(TransactionType transactionType);
    void withdraw(double amount);
    void deposit(double amount);
    void checkBalance();
    void ejectCard();
}
