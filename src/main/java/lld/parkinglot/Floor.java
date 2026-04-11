package lld.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class Floor {
    private int floorNumber;
    private List<ParkingSpot> parkingSpots = new ArrayList<>();

    //Constructor
    public Floor(int floorNumber, int motoSpots, int compactSpots, int largeSpots) {
        this.floorNumber = floorNumber;
        int spotId = 1;

        for (int i = 0; i < motoSpots; i++) parkingSpots.add(new ParkingSpot(spotId++, SpotType.MOTORCYCLE));
        for (int i = 0; i < compactSpots; i++) parkingSpots.add(new ParkingSpot(spotId++, SpotType.COMPACT));
        for (int i = 0; i < largeSpots; i++) parkingSpots.add(new ParkingSpot(spotId++, SpotType.LARGE));
    }

    //Getter methods
    public int getFloorNumber() {
        return floorNumber;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }

    //Method
    public ParkingSpot findAvailableSpot(Vehicle vehicle) {
        for (ParkingSpot parkingSpot : parkingSpots) {
            if (parkingSpot.canPark(vehicle)) {
                return parkingSpot;
            }
        }
        return null;
    }



}
