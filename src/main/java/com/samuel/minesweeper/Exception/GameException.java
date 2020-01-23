/*
 * Copyright (c) 2020. samuel azcona
 */

package com.samuel.minesweeper.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GameException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public GameException() {
        super();
    }

    public GameException(final String message) {
        super(message);
    }
}
