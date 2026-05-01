package lld.chessgame;

// ==================== MAIN SERVICE ====================
public class ChessGame {

    private final Board board;
    private PieceColor currentTurn = PieceColor.WHITE; //White starts first
    private boolean gameOver = false;

    //Constructor
    public ChessGame() {
        this.board = new Board();
    }

    public boolean makeMove(Position from, Position to) {
        Piece piece = board.getPiece(from);
        if (piece == null || piece.getPieceColor() != currentTurn) return false;

        if (piece.isValidMove(from, to, board)) {
            board.movePiece(from, to);
            currentTurn = (currentTurn == PieceColor.WHITE) ? PieceColor.BLACK : PieceColor.WHITE;
            return true;
        }
        return false;
    }

    public boolean isGameOver() {
        return gameOver;
    }

}
