package lld.cabbooking;

public class Vehicle {

    private final String vehicleNumber;
    private final VehicleType vehicleType;

    //Constructor
    public Vehicle(String vehicleNumber, VehicleType vehicleType) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
    }

    //Getter methods
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

}
