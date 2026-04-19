package lld.cabbooking;

import java.time.LocalDateTime;

public class Ride {

    private final String rideId;
    private final Rider rider;
    private Driver driver;
    private final Location pickupLocation;
    private final Location dropLocation;
    private RideStatus rideStatus;
    private final LocalDateTime requestTime;
    private double fare;

    //Constructor
    public Ride(String rideId, Rider rider, Location pickupLocation, Location dropLocation) {
        this.rideId = rideId;
        this.rider = rider;
        this.pickupLocation = pickupLocation;
        this.dropLocation = dropLocation;
        this.requestTime = LocalDateTime.now();
    }

    //Getter methods
    public String getRideId() {
        return rideId;
    }

    public Rider getRider() {
        return rider;
    }

    public Driver getDriver() {
        return driver;
    }

    public Location getPickupLocation() {
        return pickupLocation;
    }

    public Location getDropLocation() {
        return dropLocation;
    }

    public RideStatus getRideStatus() {
        return rideStatus;
    }

    public LocalDateTime getRequestTime() {
        return requestTime;
    }

    public double getFare() {
        return fare;
    }

    //Methods
    public void assignDriver(Driver driver, double fare) {
        this.driver = driver;
        this.fare = fare;
        this.rideStatus = RideStatus.DRIVER_ASSIGNED;
        driver.setAvailable(false);
    }

    public void startRide() {
        this.rideStatus = RideStatus.IN_PROGRESS;
    }

    public void completeRide() {
        this.rideStatus = RideStatus.COMPLETED;
        if (driver != null) driver.setAvailable(true);
    }

    @Override
    public String toString() {
        return "Ride{" +
                "rideId='" + rideId +
                ", riderName=" + rider.getRiderName() +
                ", driverId=" + driver.getDriverId() +
                ", driverName=" + driver.getDriverName() +
                ", pickupLocation=" + pickupLocation.getArea() +
                ", dropLocation=" + dropLocation.getArea() +
                ", rideStatus=" + rideStatus +
                ", requestTime=" + requestTime +
                ", fare=" + fare +
                '}';
    }
}
