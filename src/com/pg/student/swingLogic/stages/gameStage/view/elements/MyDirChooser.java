package com.pg.student.swingLogic.stages.gameStage.view.elements;

import com.pg.student.swingLogic.stages.gameStage.controller.GameController;
import com.pg.student.swingLogic.stages.gameStage.view.GameView;

import javax.swing.*;

public class MyDirChooser extends JFileChooser {
    public MyDirChooser(GameController controller, GameView view) {
        this.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int option = this.showOpenDialog(view);
        if(option == JFileChooser.APPROVE_OPTION){
            controller.SaveGame(this.getSelectedFile());
        }
    }
}
