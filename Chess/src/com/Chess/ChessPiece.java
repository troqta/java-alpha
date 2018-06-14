package com.Chess;

import java.util.function.BinaryOperator;

public class ChessPiece extends Position{
    private boolean White;
    public ChessPiece(boolean White){
        this.White = White;
    }
    public ChessPiece(){
        White =false;
    }
    public void move(Position position, Board board){
        if(isValidMovement(position, board)){
           setRow(position.getRow());
           setCol(position.getCol());
        }
        if(Board.isSpotTaken(position, board)){
            kill(position, board);
        }
    }
    public boolean isValidMovement(Position position, Board board){
        if(Board.isSpotTaken(position, board)){
            return false;
        }
     return true;
    }

    public void kill(Position position, Board board){
        ChessPiece chessPieceAtPosition = board.findPiceByPosition(position);
        if(chessPieceAtPosition!=null){
            board.removePiece(chessPieceAtPosition);
        }
        else{
            System.out.println("Nuffin on this position");
        }
    }

    public boolean isWhite() {
        return White;
    }

    public void setWhite(boolean white) {
        White = white;
    }
}