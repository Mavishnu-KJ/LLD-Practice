package lld.librarymanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private final String memberId;
    private final String name;
    private final List<IssueRecord> issueRecordList = new ArrayList<>(); //Borrowed books list

    //Constructor
    public Member(String memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    //Getter methods
    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public List<IssueRecord> getIssueRecordList() {
        return issueRecordList;
    }

    //Methods
    public void addBorrowedBook(IssueRecord issueRecord){
        issueRecordList.add(issueRecord);
    }
}
