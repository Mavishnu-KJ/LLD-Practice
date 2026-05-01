package lld.chessgame;

abstract class Piece {

    protected PieceColor pieceColor;
    protected PieceType pieceType;

    //Constructor
    public Piece(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public Piece(PieceColor pieceColor, PieceType pieceType) {
        this.pieceColor = pieceColor;
        this.pieceType = pieceType;
    }

    //Getter methods
    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    //Abstract methods
    public abstract boolean isValidMove(Position from, Position to, Board board);

}
