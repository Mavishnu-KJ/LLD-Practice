package lld.cabbooking;

public class Driver {

    private final String driverId;
    private final String driverName;
    private final Vehicle vehicle;
    private Location currentLocation;
    private boolean isAvailable;

    //Constructor
    public Driver(String driverId, String driverName, Vehicle vehicle, Location currentLocation) {
        this.driverId = driverId;
        this.driverName = driverName;
        this.vehicle = vehicle;
        this.currentLocation = currentLocation;
        this.isAvailable = true;
    }

    //Getter methods
    public String getDriverId() {
        return driverId;
    }

    public String getDriverName() {
        return driverName;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    //Methods
    public void setAvailable(boolean available){
        this.isAvailable = available;
    }

    public void updateLocation(Location location){
        this.currentLocation = location;
    }

}
