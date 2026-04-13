package lld.bookmyshow;

public class BookMyShowUser {

    private final String userId; //Gmail Id preferred
    private final String username;

    //Constructor
    public BookMyShowUser(String userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    //Getter methods
    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }
}

