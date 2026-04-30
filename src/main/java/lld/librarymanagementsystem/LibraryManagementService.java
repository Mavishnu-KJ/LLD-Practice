package lld.librarymanagementsystem;

import java.util.HashMap;
import java.util.Map;

// ==================== MAIN CLASS ====================
public class LibraryManagementService {

    //bookList : title -> Book
    private final Map<String, Book> bookList = new HashMap<>();

    //memberList : name -> Member
    private final Map<String, Member> memberList = new HashMap<>();

    public void addBook(Book book) {
        bookList.put(book.getTitle().toLowerCase(), book);
        System.out.println("Added book: " + book.getTitle());
    }

    public void registerMember(Member member){
        memberList.put(member.getMemberId(), member);
    }

    public Book searchBook(String title) {
        return bookList.get(title.toLowerCase());
    }

    public IssueRecord issueBook(String memberId, String bookTitle) {
        Member member = memberList.get(memberId);
        Book book = searchBook(bookTitle);

        if (member == null || book == null) {
            System.out.println("Invalid member or book");
            return null;
        }

        // Find available copy
        BookItem availableCopy = book.getBookCopyList().stream()
                .filter(b -> !b.isIssued())
                .findFirst()
                .orElse(null);

        if (availableCopy == null) {
            System.out.println("Book is out of stock");
            return null;
        }

        if (member.getIssueRecordList().size() >= 5) {
            System.out.println("Member reached maximum borrow limit");
            return null;
        }

        IssueRecord record = new IssueRecord(member, availableCopy);
        availableCopy.issue();
        member.addBorrowedBook(record);

        System.out.println("Book issued successfully to " + member.getName());
        return record;
    }

    public void returnBook(String memberId, String bookTitle) {
        Member member = memberList.get(memberId);
        if (member == null) return;

        for (IssueRecord record : member.getIssueRecordList()) {
            if (record.getBookItem().getBarCode().toLowerCase().contains(bookTitle.toLowerCase())) {
                double fine = record.calculateFine();
                record.returnBook();
                member.getIssueRecordList().remove(record);
                System.out.println("Book returned. Fine: ₹" + fine);
                return;
            }
        }
        System.out.println("No matching issued book found");
    }

}
