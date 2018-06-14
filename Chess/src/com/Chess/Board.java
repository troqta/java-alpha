package com.Chess;

import javafx.geometry.Pos;

import java.util.ArrayList;

public class Board extends Position {
    private int numberOfBlackPieces;
    private int numberOfWhitePieces;
    private int deadBlackPieces;
    private int deadWhitePieces;
    private ArrayList<ChessPiece> pieces;
    public Board(){
        super();
        numberOfBlackPieces=0;
        numberOfWhitePieces=0;
        deadBlackPieces=0;
        deadWhitePieces=0;
        pieces = new ArrayList<>();
    }

    public int getNumberOfBlackPieces() {
        return numberOfBlackPieces;
    }

    public void setNumberOfBlackPieces(int numberOfBlackPieces) {
        this.numberOfBlackPieces = numberOfBlackPieces;
    }

    public int getNumberOfWhitePieces() {
        return numberOfWhitePieces;
    }

    public void setNumberOfWhitePieces(int numberOfWhitePieces) {
        this.numberOfWhitePieces = numberOfWhitePieces;
    }

    public int getDeadBlackPieces() {
        return deadBlackPieces;
    }

    public void setDeadBlackPieces(int deadBlackPieces) {
        this.deadBlackPieces = deadBlackPieces;
    }

    public int getDeadWhitePieces() {
        return deadWhitePieces;
    }

    public void setDeadWhitePieces(int deadWhitePieces) {
        this.deadWhitePieces = deadWhitePieces;
    }

    public ArrayList<ChessPiece> getPieces() {
        return pieces;
    }

    public void setPieces(ArrayList<ChessPiece> pieces) {
        this.pieces = pieces;
    }
    public static boolean isSpotTaken(Position position, Board board){
        for (ChessPiece piece: board.getPieces()) {
            if(position.getCol() == piece.getCol() &&
                    position.getRow() == piece.getRow()){
                return true;
            }

        }
        return false;
    }
    public void removePiece(ChessPiece chessPiece){
        this.getPieces().remove(chessPiece);
        if(chessPiece.isWhite()){
            this.setNumberOfWhitePieces(this.getNumberOfWhitePieces()-1);
            this.setDeadWhitePieces(this.getDeadWhitePieces()+1);
        }
        else{
            this.setNumberOfBlackPieces(this.getNumberOfBlackPieces()-1);
            this.setDeadBlackPieces(this.getDeadBlackPieces()+1);
        }
    }
    public void addPiece(ChessPiece chessPiece){
       this.getPieces().add(chessPiece);
        if(chessPiece.isWhite()){
            this.setNumberOfWhitePieces(this.getNumberOfWhitePieces()+1);
        }
        else{
            this.setNumberOfBlackPieces(this.getNumberOfBlackPieces()+1);
        }
    }
    public ChessPiece findPiceByPosition(Position position){
        for (ChessPiece chesspiece:
             this.getPieces()) {
            if(chesspiece.getCol()==position.getCol() && chesspiece.getRow()==position.getRow()){
                return chesspiece;
            }
        }
        return null;
    }
}
