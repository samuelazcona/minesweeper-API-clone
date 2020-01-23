/*
 * Copyright (c) 2020. samuel azcona
 */

package com.samuel.minesweeper.model;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(description = "All details about GameOptions. ")
public class GameOption {
    private String userName;
    private int rows, cols, mines;
}
