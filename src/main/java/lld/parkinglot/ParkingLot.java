package lld.parkinglot;

/*
@startuml
public class ParkingLot{
    -private List<Floor> floors;
    -private Map<VehicleType, List<ParkingSpot>> availableSpots;
    +public Ticket parkVehicle(Vehicle vehicle);
    +public Payment exitVehicle(String ticketId);
    +public int numberOfAvailableSpots(VehicleType vehicleType);
}
@enduml
*/


import java.util.List;
import java.util.Map;

//Composition class
public class ParkingLot {
    private List<Floor> floors;
    private Map<VehicleType, List<ParkingSpot>> availableSpots;
    public Ticket parkVehicle(Vehicle vehicle) {return null; };
    public Payment exitVehicle(String ticketId) {return null; };
    public int numberOfAvailableSpots(VehicleType vehicleType) {return 0; };
}
