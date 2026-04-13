package lld.bookmyshow;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//MAIN SERVICE
public class BookMyShowService {

    //showId -> Show
    private final Map<String, Show> showsMap = new HashMap<>();

    //bookingId -> Booking
    private final Map<String, Booking> bookingsMap = new HashMap<>();

    //Getter methods

    public Map<String, Show> getShowsMap() {
        return showsMap;
    }

    public Map<String, Booking> getBookingsMap() {
        return bookingsMap;
    }


    //Methods
    //====================== USER / CUSTOMER APIs ======================
    /**
     * Main method used by customers to book tickets
     * Handles concurrency using synchronized
     */
    public synchronized Booking bookTickets(BookMyShowUser bookMyShowUser, String showId, List<String> seatIdList) {

        //Find the show
        Show show = showsMap.get(showId);
        if (show == null) {
            throw new IllegalArgumentException("Show not found");
        }

        //Ensure the seats are available and add them in selectedSeatsList
        List<Seat> selectedSeatsList = new ArrayList<>();
        for(String seatId : seatIdList){
            Seat seat = findSeatBySeatId(show.getScreen(), seatId);
            if (seat == null || seat.isBooked() || show.getBookedSeats().contains(seat)) {
                throw new IllegalArgumentException("Seat " + seatId + " is not available");
            }
            selectedSeatsList.add(seat);
        }

        //Calculate total amount
        double totalAmount = selectedSeatsList.size() * 200.0; // ₹200 per seat for LLD demo purpose

        //Create Booking
        String bookingId = "B" + System.currentTimeMillis();
        Booking booking = new Booking(bookingId, bookMyShowUser, show, selectedSeatsList, totalAmount);

        //Mock Payment Success - simplified for LLD demo purpose
        booking.confirmBooking();
        show.getBookedSeats().addAll(selectedSeatsList);

        //Store in the in-memory maps
        bookingsMap.put(bookingId, booking);

        return booking;
    }

    //Helper methods
    private Seat findSeatBySeatId(Screen screen, String seatId) {
        for (Seat seat : screen.getSeats()) {
            if (seat.getSeatId().equals(seatId)) {
                return seat;
            }
        }
        return null;
    }

    // ====================== ADMIN / THEATRE OWNER APIs ======================
    /**
     * Admin method - Used by Theatre owners or BookMyShow admins
     * to add new show timings
     */

    public void onboardTheater(Theater theater) {
        System.out.println("Admin: Theatre onboarded - " + theater.getTheaterName() + ", " + theater.getCity());
    }

    public void addScreenToTheater(Theater theater, Screen screen) {
        System.out.println("Admin: Screen added to theatre " + theater.getTheaterName());
    }

    public void addShow(Movie movie, Screen screen, LocalDateTime showTime, int numberOfShows) {

        int gapBetweenShows = 0;
        for(int i=1; i<=numberOfShows; i++){
            gapBetweenShows = gapBetweenShows + 4;
            Show show = new Show("SH-"+i, movie, screen, showTime.plusHours(gapBetweenShows));
            showsMap.put("SH-"+i, show);
            System.out.println("SH-"+i+" added, showTime : "+showTime.plusHours(gapBetweenShows));
        }

        System.out.println("Admin: "+numberOfShows+" show(s) added - " + movie.getMovieTitle() + " in the screen "+screen.getScreenName());
    }


}
