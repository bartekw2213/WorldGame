package com.pg.student;

import com.pg.student.stages.Controller;
import com.pg.student.stages.View;
import com.pg.student.stages.initialStage.controller.InitialController;
import com.pg.student.stages.initialStage.view.InitialView;

public class Program {
    public void StartProgram() {
        StartInitialStage();
    }

    public void ReactToStageFinish(Controller controller) {
        if(controller instanceof InitialController)
            HandleInitialStageFinish((InitialController) controller);
    }

    private void HandleInitialStageFinish(InitialController controller) {
        if(controller.GetSelectedMode() == InitialController.ModesToSelect.NEW_GAME)
            StartGettingInitialDataStage();
        else if(controller.GetSelectedMode() == InitialController.ModesToSelect.LOAD_GAME)
            StartLoadGameStage();
    }

    private void StartInitialStage() {
        new InitialController(this, new InitialView());
    }

    private void StartGettingInitialDataStage() {
        System.out.println("Zaczyna Pobieranie danych od uzytkownika");
    }

    private void StartLoadGameStage() {
        System.out.println("Zaczyna wczytywac gre");
    }

    private void StartGameStage() {

    }

}
