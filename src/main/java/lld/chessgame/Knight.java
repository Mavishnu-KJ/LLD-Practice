package lld.chessgame;

public class Knight extends Piece{

    public Knight(PieceColor pieceColor) {
        super(pieceColor);
    }

    public Knight(PieceColor pieceColor, PieceType pieceType) {
        super(pieceColor, pieceType);
    }

    public boolean isValidMove(Position from, Position to, Board board) {
        int rowDiff = Math.abs(from.row - to.row);
        int colDiff = Math.abs(from.col - to.col);
        return (rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2);
    }

}
