package lld.snakeandladdergame;

import java.util.List;

// ==================== MAIN CLASS ====================
public class SnakeAndLadderGame {

    private final Board board;
    private final Dice dice;
    private final List<Player> playerList;
    private int currentPlayerIndex = 0;
    private boolean gameOver = false;

    //Constructor
    public SnakeAndLadderGame(List<Player> playerList) {
        this.playerList = playerList;
        board = new Board(100);
        dice = new Dice();
    }

    public void playGame() {
        System.out.println("🎲 Snake and Ladder Game Started!\n");

        while (!gameOver) {
            Player currentPlayer = playerList.get(currentPlayerIndex);
            int diceRoll = dice.roll();

            System.out.println(currentPlayer.getName() + " rolled a " + diceRoll);

            int newPosition = board.getNextPosition(currentPlayer.getPosition(), diceRoll);
            currentPlayer.setPosition(newPosition);

            System.out.println(currentPlayer.getName() + " moved to position " + newPosition);

            if (board.isWinningPosition(newPosition)) {
                System.out.println("\n🏆 " + currentPlayer.getName() + " WINS THE GAME!");
                gameOver = true;
                break;
            }

            // Move to next player
            currentPlayerIndex = (currentPlayerIndex + 1) % playerList.size(); //Round robin method
            //Consider number of  players = 3, after each turn the index will be calculated for next turn
            //Index 0 - player 1 turn -> then updates currentPlayerIndex = 1 for player 2 turn
            //Index 1 - player 2 turn -> then updates currentPlayerIndex = 2 for player 3 turn
            //Index 3 - player 3 turn -> then updates currentPlayerIndex = 0 for player 1 turn
        }

        if (gameOver) {
            System.out.println("\nGame Over! Thank you for playing.");
        }

    }

}
