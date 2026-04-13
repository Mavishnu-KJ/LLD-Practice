package lld.bookmyshow;

import java.time.LocalDateTime;
import java.util.List;

public class Booking {

    private final String bookingId;
    private final BookMyShowUser bookMyShowUser;
    private final Show show;
    private final List<Seat> seats;
    private final double totalAmount;
    private BookingStatus bookingStatus;
    private final LocalDateTime bookingTime;

    //Constructor
    public Booking(String bookingId, BookMyShowUser bookMyShowUser, Show show, List<Seat> seats, double totalAmount) {
        this.bookingId = bookingId;
        this.bookMyShowUser = bookMyShowUser;
        this.show = show;
        this.seats = seats;
        this.totalAmount = totalAmount;
        this.bookingStatus = BookingStatus.PENDING;
        this.bookingTime = LocalDateTime.now();
    }

    //Getter methods
    public String getBookingId() {
        return bookingId;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public LocalDateTime getBookingTime() {
        return bookingTime;
    }

    //Methods
    public void confirmBooking(){
        seats.forEach(Seat::bookSeat);
        this.bookingStatus = BookingStatus.CONFIRMED;
        System.out.println("Booking confirmed : BookingId : "+bookingId+", Booked seats : "+seats);
    }

}
