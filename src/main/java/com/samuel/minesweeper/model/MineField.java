/*
 * Copyright (c) 2020. samuel azcona
 */

package com.samuel.minesweeper.model;

import java.util.ArrayList;
import java.util.List;

// MineField has a height width and also square class that represents all the "Squarees of mineField" that squares can be:
// Mine, flag, or be open
public class MineField extends BaseEntity {

    private final List<Square> squares;
    private final int height;
    private final int width;

    public MineField(int rows, int cols) {
        this.height = rows;
        this.width = cols;
        this.squares = createSquares(rows, cols);
    }

    // create the squares based on the height and width
    private static List<Square> createSquares(int height, int width) {
        List<Square> squares = new ArrayList<>();
        for (int row=0; row<height; row++) {
            for (int column=0; column<width; column++) {
                squares.add(new Square(row, column));
            }
        }
        return squares;
    }

    public Square getSquare(int row, int col) {
        return this.squares.get(row * this.width + col);
    }

    public List<Square> getSquarees() {
        return new ArrayList<>(this.squares);
    }
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
