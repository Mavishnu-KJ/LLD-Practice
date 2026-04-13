package lld.bookmyshow;

public class Movie {
    private final String movieId;
    private final String movieTitle;
    private final String movieGenre;

    //Constructor
    public Movie(String movieId, String movieTitle, String movieGenre) {
        this.movieId = movieId;
        this.movieTitle = movieTitle;
        this.movieGenre = movieGenre;
    }

    //Getter methods
    public String getMovieTitle() {
        return movieTitle;
    }
}
