package lld.atm;

import java.util.ArrayList;
import java.util.List;

// ==================== MAIN CLASS ====================
public class ATM {

    private ATMState currentState;
    private Card currentCard;
    private Account currentAccount;
    private final List<Transaction> transactionList = new ArrayList<>();

    //default constructor
    public ATM(){
        this.currentState = new IdleState(this);
    }

    public void setState(ATMState atmState){
        this.currentState = atmState;
    }

    public void setCurrentCard(Card card){
        this.currentCard = card;
    }

    public void setCurrentAccount(Account account){
        this.currentAccount = account;
    }

    //Delegate to current state
    public void insertCard(Card card) {
        currentState.insertCard(card);
    }

    public void enterPin(String pin) {
        currentState.enterPin(pin);
    }

    public void selectOperation(TransactionType transactionType) {
        currentState.selectOperation(transactionType);
    }

    public void withdraw(double amount) {
        currentState.withdraw(amount);
    }

    public void deposit(double amount) {
        currentState.deposit(amount);
    }

    public void checkBalance() {
        currentState.checkBalance();
    }

    public void ejectCard() {
        currentState.ejectCard();
    }

    public void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
    }

    public void printTransactions() {
        System.out.println("\n=== Transaction History ===");
        transactionList.forEach(System.out::println);
    }

    //Getter methods
    public ATMState getCurrentState() {
        return currentState;
    }

    public Card getCurrentCard() {
        return currentCard;
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }
}
