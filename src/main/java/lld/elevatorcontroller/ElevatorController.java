package lld.elevatorcontroller;

import java.util.ArrayList;
import java.util.List;

// ==================== MAIN CLASS ====================
public class ElevatorController {

    private final List<Elevator> elevators = new ArrayList<>();

    //Constructor with initialization
    public ElevatorController(int numberOfElevators, int totalFloors) {
        for (int i = 1; i <= numberOfElevators; i++) {
            elevators.add(new Elevator(i, 1)); // All start at ground floor
        }
    }

    //USER APIs
    //User presses button on a floor
    public void requestElevator(int floor, Direction direction) {
        Elevator bestElevator = findBestElevator(floor, direction);
        if (bestElevator != null) {
            bestElevator.addStop(floor);
            System.out.println("Elevator " + bestElevator.getElevatorId() + " assigned for floor " + floor);
        } else {
            System.out.println("No elevator available");
        }
    }

    // User presses button inside elevator
    public void requestFloor(int elevatorId, int targetFloor) {
        for (Elevator e : elevators) {
            if (e.getElevatorId() == elevatorId) {
                e.addStop(targetFloor);
                System.out.println("Floor " + targetFloor + " requested in Elevator " + elevatorId);
                return;
            }
        }
    }

    //Helper methods
    private Elevator findBestElevator(int floor, Direction direction) {
        Elevator best = null;
        int minDistance = Integer.MAX_VALUE;

        for (Elevator e : elevators) {
            if (e.getElevatorStatus() == ElevatorStatus.MAINTENANCE) continue;

            int distance = Math.abs(e.getCurrentFloorId() - floor);
            if (distance < minDistance) {
                minDistance = distance;
                best = e;
            }
        }
        return best;
    }

    public void simulateMovement() {
        for (Elevator e : elevators) {
            e.move();
        }
    }

}
