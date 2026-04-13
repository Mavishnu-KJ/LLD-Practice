package lld.bookmyshow;

public class Seat {
    private final String seatId;
    private final SeatType seatType;
    private boolean isBooked;

    //Constructor
    public Seat(String seatId, SeatType seatType) {
        this.seatId = seatId;
        this.seatType = seatType;
        this.isBooked = false;
    }

    //Getter methods
    public String getSeatId() {
        return seatId;
    }
    public SeatType getSeatType() {
        return seatType;
    }
    public boolean isBooked() {
        return isBooked;
    }

    //Methods
    public void bookSeat(){
        this.isBooked = true;
    }

    public void releaseSeat(){
        this.isBooked = false;
    }

    @Override
    public String toString() {
        return seatId;
    }
}
