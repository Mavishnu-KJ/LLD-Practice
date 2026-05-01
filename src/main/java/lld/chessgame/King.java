package lld.chessgame;

public class King extends Piece{

    public King(PieceColor pieceColor) {
        super(pieceColor);
    }

    public King(PieceColor pieceColor, PieceType pieceType) {
        super(pieceColor, pieceType);
    }

    public boolean isValidMove(Position from, Position to, Board board) {
        int rowDiff = Math.abs(from.row - to.row);
        int colDiff = Math.abs(from.col - to.col);
        return rowDiff <= 1 && colDiff <= 1;
    }

}
