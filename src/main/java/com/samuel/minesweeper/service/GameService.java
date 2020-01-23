/*
 * Copyright (c) 2020. samuel azcona
 */

package com.samuel.minesweeper.service;

import com.samuel.minesweeper.Exception.GameException;
import com.samuel.minesweeper.model.Game;
import com.samuel.minesweeper.model.GameOption;
import com.samuel.minesweeper.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game newGame(final GameOption gameOption){
        return createGame(new Game(gameOption.getUserName(), gameOption.getRows(), gameOption.getCols(), gameOption.getMines()));
    }

    private Game createGame(final Game game){
        return gameRepository.save(game);
    }

    public Game getGame(final String id) throws GameException{
        validateId(id);
        return gameRepository.findById(id).orElseThrow(() -> new GameException("Game not found"));
    }

    private void validateId(final String id){
        if(Objects.isNull(id)){
            throw new GameException("Id cant be nuill");
        }
    }

    public boolean pauseGame(final String id){
        validateId(id);
        return gameRepository.findById(id).map(actualGame -> {
            actualGame.pauseToggle();
            return gameRepository.save(actualGame);
        }).orElseThrow(() -> new GameException("pause game fail")).isPaused();
    }

}
