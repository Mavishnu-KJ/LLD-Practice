package lld.atm;

import java.time.LocalDateTime;

public class Transaction {
    private final String transactionId;
    private final TransactionType transactionType;
    private final LocalDateTime timeStamp;
    private final double amount;

    private long transactionCounter = 0;

    //Constructor
    public Transaction(TransactionType transactionType, double amount) {
        this.transactionId = "T" + transactionCounter++;
        this.transactionType = transactionType;
        this.amount = amount;
        this.timeStamp = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return transactionId + " | "+ timeStamp + " | " + transactionType + " | ₹" + amount;
    }

}
