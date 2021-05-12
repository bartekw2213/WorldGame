package com.pg.student.swingLogic.stages.gameStage.controller;

import com.pg.student.Program;
import com.pg.student.gameLogic.World;
import com.pg.student.swingLogic.Controller;
import com.pg.student.swingLogic.View;

public class GameController extends Controller {
    private World gameWorld;

    public GameController(Program mainProgram, View view, int boardSize, int organismsNum) {
        super(mainProgram, view);
        this.gameWorld = new World(boardSize, organismsNum);
    }
}
