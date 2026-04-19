package lld.cabbooking;

public class Rider {
    private final String riderId;
    private final String riderName;

    //Constructor
    public Rider(String riderId, String riderName) {
        this.riderId = riderId;
        this.riderName = riderName;
    }

    //Getter methods
    public String getRiderId() {
        return riderId;
    }

    public String getRiderName() {
        return riderName;
    }

}
