package com.Chess;

public class Position {
    private int row;
    private int col;
    public static final int MAX_ROW_AND_COL = 8;

    public Position() {
        row = 0;
        col = 0;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }
}
