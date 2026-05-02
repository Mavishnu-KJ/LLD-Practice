package lld.restaurantreservationsystem;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Table {
    private final int tableNumber;
    private final int tableCapacity;

    private final Map<LocalDateTime, TableStatus> availabilityMap = new HashMap<>();

    //Constructor
    public Table(int tableNumber, int tableCapacity) {
        this.tableNumber = tableNumber;
        this.tableCapacity = tableCapacity;
    }

    //Getter methods
    public int getTableNumber() {
        return tableNumber;
    }

    public int getTableCapacity() {
        return tableCapacity;
    }

    public Map<LocalDateTime, TableStatus> getAvailabilityMap() {
        return availabilityMap;
    }

    //Methods
    public boolean isAvailable(LocalDateTime timeSlot) {

        if(availabilityMap.getOrDefault(timeSlot, TableStatus.AVAILABLE) == TableStatus.AVAILABLE){
            return true;
        }

        return false;
    }

    public void reserve(LocalDateTime timeSlot) {
        availabilityMap.put(timeSlot, TableStatus.RESERVED);
    }

    public void release(LocalDateTime timeSlot) {
        availabilityMap.put(timeSlot, TableStatus.AVAILABLE);
    }

}
