package lld.snakeandladdergame;

import java.util.HashMap;
import java.util.Map;

public class Board {

    private final int size;
    private final Map<Integer, Integer> snakeMap;       // head -> tail
    private final Map<Integer, Integer> ladderMap;      // bottom -> top

    public Board(int size) {
        this.size = size;
        snakeMap = new HashMap<>();
        ladderMap = new HashMap<>();
        initializeSnakeAndLadderMap();
    }

    //Helper method
    private void initializeSnakeAndLadderMap(){
        // Ladders
        ladderMap.put(4, 14);
        ladderMap.put(9, 31);
        ladderMap.put(21, 42);
        ladderMap.put(28, 84);
        ladderMap.put(51, 67);
        ladderMap.put(71, 91);

        // Snakes
        snakeMap.put(17, 7);
        snakeMap.put(54, 34);
        snakeMap.put(62, 19);
        snakeMap.put(64, 60);
        snakeMap.put(87, 24);
        snakeMap.put(93, 73);
        snakeMap.put(95, 75);
        snakeMap.put(99, 78);
    }

    //Methods
    public int getNextPosition(int currentPos, int diceRoll) {
        int newPos = currentPos + diceRoll;
        if (newPos > size) return currentPos; // Overshoot → stay at same position

        // Check Ladder
        if (ladderMap.containsKey(newPos)) {
            return ladderMap.get(newPos);
        }

        // Check Snake
        if (snakeMap.containsKey(newPos)) {
            return snakeMap.get(newPos);
        }

        return newPos;
    }

    public boolean isWinningPosition(int position) {
        return position == size;
    }

}
