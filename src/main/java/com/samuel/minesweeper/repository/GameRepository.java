/*
 * Copyright (c) 2020. samuel azcona
 */

package com.samuel.minesweeper.repository;
import com.samuel.minesweeper.model.Game;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface GameRepository extends MongoRepository<Game, Long> {


}
