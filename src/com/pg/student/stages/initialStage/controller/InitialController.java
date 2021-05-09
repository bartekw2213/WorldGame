package com.pg.student.stages.initialStage.controller;

import com.pg.student.Program;
import com.pg.student.stages.Controller;
import com.pg.student.stages.View;

public class InitialController extends Controller {
    public enum ModesToSelect { NEW_GAME, LOAD_GAME };
    private ModesToSelect selectedMode;

    public InitialController(Program mainProgram, View view) {
        super(mainProgram, view);
        selectedMode = ModesToSelect.NEW_GAME;
    }

    public ModesToSelect GetSelectedMode() {
        return selectedMode;
    }

    public void InformAboutNewGameOption() {
        selectedMode = ModesToSelect.NEW_GAME;
        super.CloseView();
        super.EndStage();
    }

    public void InformAboutLoadGameOption() {
        selectedMode = ModesToSelect.LOAD_GAME;
        super.CloseView();
        super.EndStage();
    }
}
