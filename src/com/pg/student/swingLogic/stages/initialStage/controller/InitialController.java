package com.pg.student.swingLogic.stages.initialStage.controller;

import com.pg.student.Program;
import com.pg.student.gameLogic.World;
import com.pg.student.swingLogic.Controller;
import com.pg.student.swingLogic.View;
import com.pg.student.swingLogic.stages.initialStage.controller.elements.Loader;
import com.pg.student.swingLogic.stages.initialStage.view.InitialView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InitialController extends Controller {
    public enum ModesToSelect { NEW_GAME, LOAD_GAME }
    private ModesToSelect selectedMode;
    private World loadedWorld;

    public InitialController(Program mainProgram, View view) {
        super(mainProgram, view);
        this.loadedWorld = null;
        selectedMode = ModesToSelect.NEW_GAME;
    }

    public ModesToSelect GetSelectedMode() {
        return selectedMode;
    }
    
    public World GetLoadedWorld() { return loadedWorld; } 

    public void InformAboutNewGameOption() {
        selectedMode = ModesToSelect.NEW_GAME;
        super.CloseView();
        super.EndStage();
    }

    public void InformAboutLoadGameOption() {
        GetSaveFile();
    }

    public void LoadWorld(File saveFile) {
        try {
            this.loadedWorld = Loader.LoadWorld(saveFile);
            selectedMode = ModesToSelect.LOAD_GAME;
            super.CloseView();
            super.EndStage();
        } catch (IOException | ClassNotFoundException e) {
            view.ShowErrorDialog("Błąd podczas wyczytywania pliku");
        }
    }

    private void GetSaveFile() {
        ((InitialView)view).AskForSaveFile();
    }


}
