package lld.restaurantreservationsystem;

import java.time.LocalDateTime;

public class Reservation {
    private final String reservationId;
    private final User user;
    private final Restaurant restaurant;
    private final Table table;
    private final LocalDateTime timeSlot;
    private final int numberOfPeople;

    //Constructor
    public Reservation(String reservationId, User user, Restaurant restaurant, Table table, LocalDateTime timeSlot, int numberOfPeople) {
        this.reservationId = reservationId;
        this.user = user;
        this.restaurant = restaurant;
        this.table = table;
        this.timeSlot = timeSlot;
        this.numberOfPeople = numberOfPeople;
    }

    //Getter methods
    public String getReservationId() {
        return reservationId;
    }

    public User getUser() {
        return user;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Table getTable() {
        return table;
    }

    public LocalDateTime getTimeSlot() {
        return timeSlot;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

}
