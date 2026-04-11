package lld.parkinglot;

public class ParkingSpot {
    private int spotNumber;
    private SpotType spotType;
    private Vehicle currentVehicle;

    public ParkingSpot(int spotNumber, SpotType spotType) {
        this.spotNumber = spotNumber;
        this.spotType = spotType;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    //Method to check if spot available or not
    public boolean isAvailable() {
        return currentVehicle == null;
    }

    // Checks if this spot can accommodate the vehicle
    public boolean canPark(Vehicle vehicle) {
        if (!isAvailable()) return false;

        return switch (spotType) {
            case MOTORCYCLE -> true;                    // Bike can park anywhere
            case COMPACT -> vehicle.getVehicleType() != VehicleType.LARGE; // Car cannot park in Large only? Wait, Large can take Car? No, usually Large is for bigger vehicles
            case LARGE -> true;                         // Large spot can take any vehicle
        };
    }

    public void park(Vehicle vehicle) {
        if (!canPark(vehicle)) {
            throw new IllegalArgumentException("Spot cannot accommodate this vehicle");
        }
        this.currentVehicle = vehicle;
    }

    public Vehicle unpark() {
        Vehicle vehicle = currentVehicle;
        currentVehicle = null;
        return vehicle;
    }

}
