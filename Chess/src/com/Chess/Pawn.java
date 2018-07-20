package com.Chess;

public class Pawn extends ChessPiece {
    @Override
    public boolean isValidMovement(Position position, Board board) {
        if (position.getCol() != this.getCol()) {
            return false;
        }
        if (position.getRow() != this.getRow() + 1 ||
                position.getRow() != this.getRow() + 2 ||
                position.getRow() != this.getRow() - 1 ||
                position.getRow() != this.getRow() - 2) {
            return false;

        }
        return true;
    }
}
