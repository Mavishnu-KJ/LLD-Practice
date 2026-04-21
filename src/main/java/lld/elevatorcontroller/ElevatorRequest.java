package lld.elevatorcontroller;

public class ElevatorRequest {

    private final int elevatorId;
    private final int targetFloorId;

    //Constructor
    public ElevatorRequest(int elevatorId, int targetFloorId) {
        this.elevatorId = elevatorId;
        this.targetFloorId = targetFloorId;
    }

    //Getter methods
    public int getElevatorId() {
        return elevatorId;
    }

    public int getTargetFloorId() {
        return targetFloorId;
    }

}
