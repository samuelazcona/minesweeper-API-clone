/*
 * Copyright (c) 2020. samuel azcona
 */

package com.samuel.minesweeper.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Square extends BaseEntity {

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

    // we need to check if the square is neighbor
    public boolean isNeighbor(Square square) {
        return this != square && Math.abs(this.col - square.col) <= 1 && Math.abs(this.row - square.row) <= 1;
    }

}
