package lld.chessgame;

public class Board {
    private Piece[][] squares = new Piece[8][8];

    //Constructor

    public Board() {
        initializeBoard();
    }

    private void initializeBoard() {
        // Simplified initialization - White at bottom
        squares[0][0] = new Rook(PieceColor.BLACK);
        // ... (full setup omitted for brevity, you can expand)
        squares[7][4] = new King(PieceColor.WHITE);
        // Add other pieces similarly
    }

    //Methods
    public Piece getPiece(Position pos) {
        return squares[pos.row][pos.col];
    }

    public void movePiece(Position from, Position to) {
        squares[to.row][to.col] = squares[from.row][from.col];
        squares[from.row][from.col] = null;
    }

    public boolean isPathClear(Position from, Position to) {
        // Simplified - implement for Rook/Queen/Bishop
        return true;
    }

}
