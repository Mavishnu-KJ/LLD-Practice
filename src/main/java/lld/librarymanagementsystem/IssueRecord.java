package lld.librarymanagementsystem;

import java.time.LocalDate;
import java.time.Period;

public class IssueRecord {

    private final String issueId;
    private final Member member;
    private final BookItem bookItem;
    private final LocalDate issueDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    //Constructor
    public IssueRecord(Member member, BookItem bookItem) {
        this.issueId = "I" + System.currentTimeMillis();
        this.member = member;
        this.bookItem = bookItem;
        this.issueDate = LocalDate.now();
        this.dueDate = issueDate.plusDays(10);
    }

    //Getter methods
    public String getIssueId() {
        return issueId;
    }

    public Member getMember() {
        return member;
    }

    public BookItem getBookItem() {
        return bookItem;
    }

    //Methods
    public double calculateFine(){
        if (returnDate == null || returnDate.isBefore(dueDate)) {
            return 0;
        }

        long daysLate = Period.between(dueDate, returnDate).getDays();
        double fineAmount = daysLate * 10.0; // ₹10 per day for demo purpose

        return fineAmount;
    }

    public void returnBook(){
        this.returnDate = LocalDate.now();
        bookItem.returnBook();
    }

}
