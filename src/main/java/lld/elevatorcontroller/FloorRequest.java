package lld.elevatorcontroller;

public class FloorRequest {

    private final int floorId;
    private final Direction direction;

    //Constructor
    public FloorRequest(int floor, Direction direction) {
        this.floorId = floor;
        this.direction = direction;
    }

    //Getter methods
    public int getFloorId() {
        return floorId;
    }

    public Direction getDirection() {
        return direction;
    }

}

