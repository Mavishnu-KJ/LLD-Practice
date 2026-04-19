package lld.cabbooking;

public class Location {

    private final String area;
    private final double latitude;
    private final double longitude;

    //Constructor
    public Location(String area, double latitude, double longitude) {
        this.area = area;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    //Getter methods
    public String getArea() {
        return area;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    //Method
    //Method to calculate distance
    public double distanceTo(Location other){
        return Math.abs(this.latitude - other.latitude) + Math.abs(this.longitude - other.longitude);
    }

}
