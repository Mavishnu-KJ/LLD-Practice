package lld.parkinglot;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//MAIN CLASS
public class ParkingLot {
    private List<Floor> floors = new ArrayList<>();
    //Map ticketId -> Ticket
    private Map<String, Ticket> activeTickets = new HashMap<>();
    ParkingFeeCalculator parkingFeeCalculator = new ParkingFeeCalculator();

    //Constructor to create a parking lot with given number of floors
    public ParkingLot(int numberOfFloors) {
        for (int i = 1; i <= numberOfFloors; i++) {
            // Floor 1 has more compact spots
            floors.add(new Floor(i, 100, 500, 100));
        }
    }

    //Methods
    public Ticket parkVehicle(Vehicle vehicle) {
        for (Floor floor : floors) {
            ParkingSpot spot = floor.findAvailableSpot(vehicle);
            if (spot != null) {
                spot.park(vehicle);
                String ticketId = "T" + System.currentTimeMillis();
                Ticket ticket = new Ticket(ticketId, vehicle, spot);
                activeTickets.put(ticketId, ticket);

                System.out.println("✅ Parked " + vehicle.getVehicleType() + " (" + vehicle.getLicensePlate()
                        + ") → Floor " + floor.getFloorNumber() + ", Spot " + spot.getSpotNumber());
                return ticket;
            }
        }
        throw new RuntimeException("Sorry, no parking spot available for " + vehicle.getVehicleType());
    }

    public double exitVehicle(String ticketId, LocalDateTime exitTime) {
        Ticket ticket = activeTickets.remove(ticketId);
        if (ticket == null) {
            throw new RuntimeException("Invalid or expired ticket");
        }

        ParkingSpot spot = ticket.getParkingSpot();
        spot.unpark();

        double fee = parkingFeeCalculator.calculateFee(ticket, exitTime);

        //Create payment
        Payment payment = new Payment(ticket, fee);
        payment.markAsSuccess();        // In real system, call payment gateway here

        System.out.println("✅ Vehicle "+ticket.getVehicle().getLicensePlate()+" exited. Total Parking Fee: ₹" + fee);
        return fee;
    }

    public void findAvailableSpots() {
        System.out.println("\n=== Parking Lot Status ===");
        for (Floor floor : floors) {
            long available = floor.getParkingSpots().stream().filter(ParkingSpot::isAvailable).count();
            System.out.println("Floor " + floor.getFloorNumber() + " → Available Spots: " + available);
        }
    }

}
