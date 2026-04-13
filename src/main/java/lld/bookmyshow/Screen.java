package lld.bookmyshow;

import java.util.ArrayList;
import java.util.List;

public class Screen {
    private final String screenId;
    private final String screenName;
    private final List<Seat> seats;

    //Constructor
    public Screen(String screenId, String screenName, int totalSeats) {
        this.screenId = screenId;
        this.screenName = screenName;
        this.seats = new ArrayList<>();
        for(int i=0; i<totalSeats; i++){
            seats.add(
                    new Seat("S"+i,
                            i<=20 ? SeatType.PREMIUM : SeatType.REGULAR)
            );
        }
    }

    //Getter methods
    public String getScreenName() {
        return screenName;
    }

    public List<Seat> getSeats() {
        return seats;
    }

}
