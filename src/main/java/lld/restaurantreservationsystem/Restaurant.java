package lld.restaurantreservationsystem;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private final String restaurantId;
    private final String restaurantName;
    private final String location;
    private final List<Table> tableList = new ArrayList<>();

    //Constructor
    public Restaurant(String restaurantId, String restaurantName, String location, int numberOfTables) {
        this.restaurantId = restaurantId;
        this.restaurantName = restaurantName;
        this.location = location;
        for(int i=0; i<numberOfTables; i++){
            tableList.add(new Table(i, 4)); //4 seater table for demo
        }
    }

    //Getter methods
    public String getRestaurantId() {
        return restaurantId;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public String getLocation() {
        return location;
    }

    public List<Table> getTableList() {
        return tableList;
    }

}
