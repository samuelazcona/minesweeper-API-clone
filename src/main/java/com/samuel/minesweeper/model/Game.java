/*
 * Copyright (c) 2020. samuel azcona
 */

package com.samuel.minesweeper.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// Game have a 1 minifield and int count of moves that the player do
// user can configure a game for that reason the game can set the value of rows, cols and mines
@JsonIgnoreProperties(ignoreUnknown = true)
public class Game extends BaseEntity {

    private String userName;
    private final MineField minefield;
    private int moves = 0;
    private boolean isPaused;

    public Game(int rows, int cols, int mineCount) {
        this.minefield = new MineField(rows, cols);
        setMinesRandomly(mineCount);
        this.onCreate();
    }

    // user sets the quantity of mines but we need to place it randomly for that reason we use collection shuffle and we set the mines as true in that position
    private void setMinesRandomly(int mineCount) {
        new ArrayList<>(minefield.getSquares())
                .stream()
                .limit(mineCount)
                .forEach(Square::setMine);
        Collections.shuffle(minefield.getSquares());
    }


    public MineField getMinefield() {
        return minefield;
    }

    public void openSquare(Square square) {
        //if the game is over or square is flagged we cant open or increase moves
        if (square.isFlagged() || isOver()) {
            return;
        }
        increaseMove();
        openNearSquare(square);
    }

    public int getMoves() {
        return this.moves;
    }

    private void increaseMove() {
        this.moves++;
    }

    private void openNearSquare(Square square) {
        square.setOpen();
        List<Square> neighbors = minefield.getNeighbors(square);
        if (!isOver() && neighbors.stream().noneMatch(Square::isMine)) {
            neighbors.stream().filter(s -> !s.isOpen() && !s.isFlagged()).collect(Collectors.toList()).forEach(this::openNearSquare);

        }
    }

    // you won when game is completed
    public boolean isGameWin() {
        return gameIsCompleted();
    }

    // you lost game when you get a mine
    public boolean isGameLost() {
        return minefield.getSquares().stream().anyMatch(square -> square.isOpen() && square.isMine());
    }

    public boolean isOver() {
        return isGameWin() || isGameLost();
    }

    // game is complete when all square are visible
    private boolean gameIsCompleted() {
        return minefield.getSquares().stream().noneMatch(square -> !square.isOpen() && !square.isMine());
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isPaused() {
        return isPaused;
    }

    public void pauseToggle() {
        this.isPaused = !isPaused;
    }
}
