package lld.chessgame;

public class Pawn extends Piece {

    public Pawn(PieceColor pieceColor) {
        super(pieceColor);
    }

    public Pawn(PieceColor pieceColor, PieceType pieceType) {
        super(pieceColor, pieceType);
    }

    public boolean isValidMove(Position from, Position to, Board board) {
        int direction = (pieceColor == PieceColor.WHITE) ? -1 : 1;
        return (from.col == to.col && to.row == from.row + direction);
    }

}
