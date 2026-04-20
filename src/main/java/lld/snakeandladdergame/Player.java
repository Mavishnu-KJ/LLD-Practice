package lld.snakeandladdergame;

public class Player {

    private final String name;
    private int position;

    //Constructor
    public Player(String name, int position) {
        this.name = name;
        this.position = position;
    }

    //Getter methods
    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
