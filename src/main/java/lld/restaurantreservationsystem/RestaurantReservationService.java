package lld.restaurantreservationsystem;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class RestaurantReservationService {

    private final Map<String, Restaurant> restaurantMap = new HashMap<>();
    private final Map<String, Reservation> reservationMap = new HashMap<>();

    //ADMIN API
    public void addRestaurant(Restaurant restaurant) {
        restaurantMap.put(restaurant.getRestaurantName().toLowerCase(), restaurant);
        System.out.println("Restaurant added: " + restaurant.getRestaurantName());
    }

    //USER APIs
    //Synchronized to handle concurrency issues
    public synchronized Reservation bookTable(User user, String restaurantName, LocalDateTime timeSlot, int numberOfPeople) {
        Restaurant restaurant = restaurantMap.get(restaurantName.toLowerCase());
        if (restaurant == null) {
            System.out.println("Restaurant not found");
            return null;
        }

        for (Table table : restaurant.getTableList()) {
            if (table.isAvailable(timeSlot) && table.getTableCapacity() >= numberOfPeople) {
                table.reserve(timeSlot);
                String reservationId = "R" + System.currentTimeMillis();
                Reservation reservation = new Reservation(reservationId, user, restaurant, table, timeSlot, numberOfPeople);
                reservationMap.put(reservationId, reservation);

                //reserve table
                reservation.getTable().reserve(reservation.getTimeSlot());

                System.out.println("Table booked for " + user.getUsername() + " at " + restaurant.getRestaurantName());
                return reservation;
            }
        }
        System.out.println("Sorry, No table available");
        return null;
    }

    public void cancelReservation(String reservationId) {
        Reservation reservation = reservationMap.remove(reservationId);
        if (reservation != null) {
            reservation.getTable().release(reservation.getTimeSlot());
            System.out.println("Reservation cancelled: " + reservationId);
        }
    }

}
