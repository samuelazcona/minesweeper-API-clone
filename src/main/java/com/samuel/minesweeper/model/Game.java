/*
 * Copyright (c) 2020. samuel azcona
 */

package com.samuel.minesweeper.model;

import java.util.ArrayList;
import java.util.Collections;

// Game have a 1 minifield and int count of moves that the player do
// user can configure a game for that reason the game can set the value of rows, cols and mines
public class Game extends BaseEntity {

    private final MineField minefield;

    private int moves = 0;

    public Game(int rows, int cols, int mineCount) {
        this.minefield = new MineField(rows, cols);
        setMinesRandomly(mineCount);
    }

    // user sets the quantity of mines but we need to place it randomly for that reason we use collection shuffle and we set the mines as true in that position
    private void setMinesRandomly(int mineCount) {
        new ArrayList<>(minefield.getSquarees())
                .stream()
                .limit(mineCount)
                .forEach(Square::setMine);
        Collections.shuffle(minefield.getSquarees());
    }


    public MineField getMinefield() {
        return minefield;
    }

}
