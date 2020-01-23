/*
 * Copyright (c) 2020. Samuel Azcona
 */

package com.samuel.minesweeper.repository;
import com.samuel.minesweeper.model.Game;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends MongoRepository<Game, String> {

}
