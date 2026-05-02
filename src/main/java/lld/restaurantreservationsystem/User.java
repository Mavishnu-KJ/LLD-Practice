package lld.restaurantreservationsystem;

public class User {
    private final String userId;
    private final String username;

    //Constructor
    public User(String userId, String username) {
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
