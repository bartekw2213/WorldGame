package com.pg.student;

import com.pg.student.gameLogic.World;
import com.pg.student.swingLogic.Controller;
import com.pg.student.swingLogic.stages.gameStage.controller.GameController;
import com.pg.student.swingLogic.stages.gameStage.view.GameView;
import com.pg.student.swingLogic.stages.getInitDataStage.controller.GetInitDataController;
import com.pg.student.swingLogic.stages.getInitDataStage.view.GetInitDataView;
import com.pg.student.swingLogic.stages.initialStage.controller.InitialController;
import com.pg.student.swingLogic.stages.initialStage.view.InitialView;

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
            StartGameStage(controller.GetLoadedWorld());
    }

    private void HandleGetInitDataStageFinish(GetInitDataController controller) {
        StartGameStage(controller.GetBoardSize(), controller.GetOrganismsNum());
    }

    private void StartInitialStage() {
        new InitialController(this, new InitialView());
    }

    private void StartGettingInitialDataStage() { new GetInitDataController(this, new GetInitDataView()); }

    private void StartGameStage(World loadedWorld) { new GameController(this, new GameView(), loadedWorld); }

    private void StartGameStage(int boardSize, int organismsNum) { new GameController(this, new GameView(), boardSize, organismsNum); }

}
