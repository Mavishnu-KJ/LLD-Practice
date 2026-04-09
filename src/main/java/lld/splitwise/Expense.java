package lld.splitwise;

import java.time.LocalDateTime;

public class Expense {

    private String expenseId;
    private String description;
    private double amount;
    private User paidBy;
    private Group group;
    private SplitType splitType;
    private LocalDateTime date;

    public Expense(String expenseId, String description, double amount,
                   User paidBy, Group group, SplitType splitType) {
        this.expenseId = expenseId;
        this.description = description;
        this.amount = amount;
        this.paidBy = paidBy;
        this.group = group;
        this.splitType = splitType;
        this.date = LocalDateTime.now();
    }

    public double getAmount() { return amount; }
    public User getPaidBy() { return paidBy; }
    public Group getGroup() { return group; }
    public SplitType getSplitType() { return splitType; }

}
