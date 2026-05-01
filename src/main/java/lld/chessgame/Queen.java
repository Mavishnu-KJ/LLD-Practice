package lld.chessgame;

public class Queen extends Piece{

    public Queen(PieceColor pieceColor) {
        super(pieceColor);
    }

    public Queen(PieceColor pieceColor, PieceType pieceType) {
        super(pieceColor, pieceType);
    }

    public boolean isValidMove(Position from, Position to, Board board) {
        return isStraightMove(from, to) || isDiagonalMove(from, to);
    }
    private boolean isStraightMove(Position from, Position to) {
        return from.row == to.row || from.col == to.col;
    }
    private boolean isDiagonalMove(Position from, Position to) {
        return Math.abs(from.row - to.row) == Math.abs(from.col - to.col);
    }

}
