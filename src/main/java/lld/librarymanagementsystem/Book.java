package lld.librarymanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private final String bookId;
    private final String title;
    private final String author;
    private final String category;
    private final List<BookItem> bookCopyList = new ArrayList<>();

    //Constructor
    public Book(String bookId, String title, String author, String category, int copiesCount) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        for(int i=1; i<=copiesCount; i++){
            this.bookCopyList.add(new BookItem(title + "_C" + i));
        }
    }

    //Getter methods
    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public List<BookItem> getBookCopyList() {
        return bookCopyList;
    }
}
