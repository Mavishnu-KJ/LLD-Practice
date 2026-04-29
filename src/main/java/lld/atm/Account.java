package lld.atm;

import java.math.BigDecimal;

public class Account {
    private final String accountNumber;
    private double balance;

    //Constructor
    public Account(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    //Getter methods
    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    //Methods
    public boolean withdraw(double amount){
        if(balance >= amount){
            balance = balance - amount;
            return true;
        }
        return false;
    }

    public void deposit(double amount){
        balance = balance + amount;
    }

}
