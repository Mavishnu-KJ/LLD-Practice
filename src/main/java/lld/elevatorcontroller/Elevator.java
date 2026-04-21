package lld.elevatorcontroller;

import java.util.Set;
import java.util.TreeSet;

public class Elevator {
    private final int elevatorId;
    private int currentFloorId;
    private Direction direction;
    private ElevatorStatus elevatorStatus;

    //Set floorId
    private final Set<Integer> stopRequestsSet = new TreeSet<>();       //Sorted stops

    //Constructor
    public Elevator(int elevatorId, int currentFloorId) {
        this.elevatorId = elevatorId;
        this.currentFloorId = currentFloorId;
        this.direction = Direction.IDLE;
        this.elevatorStatus = ElevatorStatus.STOPPED;
    }

    //Getter methods
    public int getElevatorId() {
        return elevatorId;
    }

    public int getCurrentFloorId() {
        return currentFloorId;
    }

    public Direction getDirection() {
        return direction;
    }

    public ElevatorStatus getElevatorStatus() {
        return elevatorStatus;
    }

    //Methods
    public void addStop(int floor) {
        stopRequestsSet.add(floor);
        if (direction == Direction.IDLE) {
            direction = (floor > currentFloorId) ? Direction.UP : Direction.DOWN;
        }
    }

    public void move() {
        if (stopRequestsSet.isEmpty()) {
            direction = Direction.IDLE;
            elevatorStatus = ElevatorStatus.STOPPED;
            return;
        }

        elevatorStatus = ElevatorStatus.MOVING;

        int nextStop = direction == Direction.UP ?
                stopRequestsSet.iterator().next() :
                ((TreeSet<Integer>) stopRequestsSet).last();

        if (currentFloorId == nextStop) {
            System.out.println("Elevator " + elevatorId + " stopped at floor " + currentFloorId);
            stopRequestsSet.remove(currentFloorId);
        } else {
            currentFloorId = currentFloorId + ((direction == Direction.UP) ? 1 : -1);
            System.out.println("Elevator " + elevatorId + " moving " + direction + " to floor " + currentFloorId);
        }
    }
}
