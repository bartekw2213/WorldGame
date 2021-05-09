package com.pg.student;

import com.pg.student.stages.Controller;
import com.pg.student.stages.getInitDataStage.controller.GetInitDataController;
import com.pg.student.stages.getInitDataStage.view.GetInitDataView;
import com.pg.student.stages.initialStage.controller.InitialController;
import com.pg.student.stages.initialStage.view.InitialView;

public class Program {
    public void StartProgram() {
        StartInitialStage();
    }

    public void ReactToStageFinish(Controller controller) {
        if(controller instanceof InitialController)
            HandleInitialStageFinish((InitialController) controller);
        else if(controller instanceof GetInitDataController)
            HandleGetInitDataStageFinish((GetInitDataController) controller);
    }

    private void HandleInitialStageFinish(InitialController controller) {
        if(controller.GetSelectedMode() == InitialController.ModesToSelect.NEW_GAME)
            StartGettingInitialDataStage();
        else if(controller.GetSelectedMode() == InitialController.ModesToSelect.LOAD_GAME)
            StartLoadGameStage();
    }

    private void HandleGetInitDataStageFinish(GetInitDataController controller) {

    }

    private void StartInitialStage() {
        new InitialController(this, new InitialView());
    }

    private void StartGettingInitialDataStage() { new GetInitDataController(this, new GetInitDataView()); }

    private void StartLoadGameStage() {
        System.out.println("Zaczyna wczytywac gre");
    }

    private void StartGameStage() {

    }

}
