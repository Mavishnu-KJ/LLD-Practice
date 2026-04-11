package lld.parkinglot;

import java.time.Duration;
import java.time.LocalDateTime;

public class ParkingFeeCalculator {

    public double calculateFee(Ticket ticket, LocalDateTime exitTime) {
        long hours = Duration.between(ticket.getEntryTime(), exitTime).toHours() + 1; // ceiling to next hour
        return switch (ticket.getVehicle().getVehicleType()) {
            case MOTORCYCLE -> hours * 10;
            case COMPACT -> hours * 20;
            case LARGE -> hours * 50;
        };
    }

}
