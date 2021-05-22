package com.pg.student.swingLogic.stages.gameStage.view.elements;

import com.pg.student.gameLogic.utils.WorldConfig;
import com.pg.student.swingLogic.stages.gameStage.controller.GameController;
import com.pg.student.swingLogic.stages.gameStage.view.GameView;
import com.pg.student.swingLogic.stages.gameStage.view.sections.GameSection;
import com.pg.student.swingLogic.uiElements.MyIconLabel;

import javax.swing.*;

public class OrganismPicker extends JOptionPane {
    private final GameView view;
    private final GameController controller;
    private final GameSection.GameField organismField;
    private String[] availableOrganisms;

    public OrganismPicker(GameView view, GameController controller, GameSection.GameField organismField) {
        this.view = view;
        this.controller = controller;
        this.organismField = organismField;
        InitAvailableOrganisms();
        ShowPane();
    }

    private void ShowPane() {
        String newOrganismName = (String) JOptionPane.showInputDialog(view,
                "Wybierz organizm do dodania", "Dodaj Organizm",
                JOptionPane.QUESTION_MESSAGE, null, availableOrganisms,
                WorldConfig.ANTELOPE_NAME);

        controller.AddNewOrganismToGame(newOrganismName, organismField);
    }

    private void InitAvailableOrganisms() {
        this.availableOrganisms = new String[] { WorldConfig.ANTELOPE_NAME, WorldConfig.BERRY_NAME,
            WorldConfig.BORSCH_NAME, WorldConfig.FOX_NAME, WorldConfig.GRASS_NAME, WorldConfig.GUARANA_NAME,
            WorldConfig.SHEEP_NAME, WorldConfig.SONCHUS_NAME, WorldConfig.TURTLE_NAME, WorldConfig.WOLF_NAME };
    }
}
