/*
 * Copyright (c) 2020. samuel azcona
 */

package com.samuel.minesweeper.service;

import com.samuel.minesweeper.Exception.GameException;
import com.samuel.minesweeper.model.Game;
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

    public Game createGame(final Game game){
        return gameRepository.save(game);
    }

    public Game getGame(final Long id) throws GameException{
        if(Objects.isNull(id)){
            throw new GameException("Id cant be nuill");
        }

        return gameRepository.findById(id).orElseThrow(() -> new GameException("Game not found"));
    }
}
