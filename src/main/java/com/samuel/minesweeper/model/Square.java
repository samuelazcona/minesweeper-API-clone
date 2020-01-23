/*
 * Copyright (c) 2020. samuel azcona
 */

package com.samuel.minesweeper.model;


public class Square {

    private boolean isMine;

    private boolean isOpen;

    private boolean isFlagged;

    private final int row;

    private final int col;

    public Square(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public boolean isMine() {
        return isMine;
    }

    public void setMine() {
        this.isMine = true;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen() {
        this.isOpen = true;
    }

    public boolean isFlagged() {
        return isFlagged;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void flagToggle() {
        this.isFlagged = !isFlagged;
    }
}
