package lld.bookmyshow;

import java.util.ArrayList;
import java.util.List;

public class Theater {
    private final String theaterId;
    private final String theaterName;
    private final String city;
    private final List<Screen> screens;

    //Constructor
    public Theater(String theaterId, String theaterName, String city) {
        this.theaterId = theaterId;
        this.theaterName = theaterName;
        this.city = city;
        this.screens = new ArrayList<>();
    }

    //Getter methods
    public String getTheaterName() {
        return theaterName;
    }

    public String getCity() {
        return city;
    }

    public List<Screen> getScreens() {
        return screens;
    }

    //Method
    public void addScreen(Screen screen){
        screens.add(screen);
    }

}
