package lld.bookmyshow;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Show {
    private final String showId;
    private final Movie movie;
    private final Screen screen;
    private final LocalDateTime showTime;
    private final Set<Seat> bookedSeats;

    //Constructor
    public Show(String showId, Movie movie, Screen screen, LocalDateTime showTime) {
        this.showId = showId;
        this.movie = movie;
        this.screen = screen;
        this.showTime = showTime;
        this.bookedSeats = new HashSet<>();
    }

    //Getter methods
    public String getShowId() {
        return showId;
    }

    public Movie getMovie() {
        return movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public Set<Seat> getBookedSeats() {
        return bookedSeats;
    }

}
