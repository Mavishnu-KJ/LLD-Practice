package lld.cabbooking;

import java.util.HashMap;
import java.util.Map;

// ==================== MAIN SERVICE ====================
public class CabBookingService {

    //driverMap : driverId -> Driver
    private final Map<String, Driver> driverMap = new HashMap<>();

    //rideMap : rideId -> Ride
    private final Map<String, Ride> rideMap = new HashMap<>();

    // ====================== ADMIN APIs ======================
    public void onboardDriver(Driver driver) {
        driverMap.put(driver.getDriverId(), driver);
        System.out.println("Driver onboarded: " + driver.getDriverName());
    }

    //====================== USER / CUSTOMER APIs ======================
    public synchronized Ride requestRide(Rider rider, Location pickup, Location drop) {
        // Find nearest available driver
        Driver nearestDriver = findNearestAvailableDriver(pickup);
        if (nearestDriver == null) {
            System.out.println("Drivers are busy, No drivers available nearby, try again later");
            throw new RuntimeException("No drivers available nearby");
        }

        String rideId = "R" + System.currentTimeMillis();
        Ride ride = new Ride(rideId, rider, pickup, drop);

        double estimatedFare = calculateFare(pickup, drop);

        ride.assignDriver(nearestDriver, estimatedFare);
        rideMap.put(rideId, ride);

        System.out.println("Ride requested by " + rider.getRiderName() + " | Assigned to " + nearestDriver.getDriverName());
        return ride;
    }

    //Helper methods
    private Driver findNearestAvailableDriver(Location pickup) {
        Driver nearest = null;
        double minDistance = Double.MAX_VALUE;

        for (Driver driver : driverMap.values()) {
            if (driver.isAvailable()) {
                double distance = pickup.distanceTo(driver.getCurrentLocation());
                if (distance < minDistance) {
                    minDistance = distance;
                    nearest = driver;
                }
            }
        }
        return nearest;
    }

    private double calculateFare(Location pickup, Location drop) {
        double distance = pickup.distanceTo(drop);
        return Math.round(distance * 15 + 30); // Base fare + per km
    }

    //Driver accepts ride (simplified)
    public void startRide(String rideId) {
        Ride ride = rideMap.get(rideId);
        if (ride != null) {
            ride.startRide();
            System.out.println("Ride started: " + rideId);
        }
    }

    public void completeRide(String rideId) {
        Ride ride = rideMap.get(rideId);
        if (ride != null) {
            ride.completeRide();
            System.out.println("Ride completed: " + rideId + " | Fare: ₹" + ride.getFare());
        }
    }

    public void showRideDetails(String rideId){
        Ride ride = rideMap.get(rideId);

        if(ride != null){
            System.out.println("Ride details : \n"+ride);
        }

    }

}
