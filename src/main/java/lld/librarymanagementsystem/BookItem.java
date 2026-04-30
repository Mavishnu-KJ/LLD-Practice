package lld.librarymanagementsystem;

public class BookItem {

    private final String barCode;
    private boolean isIssued;

    //Constructor
    public BookItem(String barCode) {
        this.barCode = barCode;
    }

    //Getter methods
    public String getBarCode() {
        return barCode;
    }

    public boolean isIssued() {
        return isIssued;
    }

    //Methods
    public void issue(){
        this.isIssued = true;
    }

    public void returnBook(){
        this.isIssued = false;
    }

}
