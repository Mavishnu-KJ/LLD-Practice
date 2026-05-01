package lld.chessgame;

public class Bishop extends Piece{

    public Bishop(PieceColor pieceColor) {
        super(pieceColor);
    }

    public Bishop(PieceColor pieceColor, PieceType pieceType) {
        super(pieceColor, pieceType);
    }

    public boolean isValidMove(Position from, Position to, Board board) {
        return Math.abs(from.row - to.row) == Math.abs(from.col - to.col);
    }

}
