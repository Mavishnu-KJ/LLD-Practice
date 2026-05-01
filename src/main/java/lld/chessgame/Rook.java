package lld.chessgame;

public class Rook extends Piece{

    public Rook(PieceColor pieceColor) {
        super(pieceColor);
    }

    public Rook(PieceColor pieceColor, PieceType pieceType) {
        super(pieceColor, pieceType);
    }

    public boolean isValidMove(Position from, Position to, Board board) {
        return from.row == to.row || from.col == to.col;
    }

}
