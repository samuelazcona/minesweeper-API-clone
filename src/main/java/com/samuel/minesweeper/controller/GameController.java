/*
 * Copyright (c) 2020. samuel azcona
 */

package com.samuel.minesweeper.controller;

import com.samuel.minesweeper.model.Game;
import com.samuel.minesweeper.model.GameOption;
import com.samuel.minesweeper.service.GameService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/game")
@CrossOrigin
@Api(value="MinesWeeper Game controller", description="Manage the game")
public class GameController {

    private final GameService service;

    @Autowired
    public GameController(GameService service) {
        this.service = service;
    }


    @GetMapping("{gameId}")
    @ResponseBody
    @ResponseStatus
    @ApiOperation(value = "Return Game by id", response = Game.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    public ResponseEntity<?> getGame(@PathVariable String gameId) {
        return ResponseEntity.ok(service.getGame(gameId));
    }

    @PostMapping
    @ResponseBody
    @ResponseStatus
    @ApiOperation(value = "Create new Game", response = Game.class)
    public ResponseEntity<?> createGame(@ApiParam(value = "GameOptions with game params", required = true) @Valid GameOption gameOptions) {
        return ResponseEntity.ok(service.newGame(gameOptions));
    }

}
