package com.pg.student.swingLogic.stages.initialStage.view;

import com.pg.student.swingLogic.colors.ColorPalette;
import com.pg.student.swingLogic.View;
import com.pg.student.swingLogic.uiElements.MyButton;
import com.pg.student.swingLogic.uiElements.MyFlowPanel;
import com.pg.student.swingLogic.stages.initialStage.controller.InitialController;

import javax.swing.*;
import java.awt.*;

public class InitialView extends View {
    private JButton newGameButton = null;
    private JButton loadGameButton = null;

    public InitialView() {
        super(0.4, 0.2, Color.decode(ColorPalette.ORANGE));
    }

    @Override
    protected void CreateLayout() {
        super.SetYPadding((int)(frameHeight/4.25));
        CreateButtonsPanel();
    }

    private void CreateButtonsPanel() {
        JPanel buttonsPanel = new MyFlowPanel(frameWidth, frameHeight, mainColor, (int)(frameWidth * 0.1), 0);

        CreateButtons(buttonsPanel);
        AttachListenersToButtons();

        this.add(buttonsPanel, BorderLayout.CENTER);
    }

    private void CreateButtons(JPanel buttonsPanel) {
        this.newGameButton = new InitialViewButton("Nowa Gra");
        this.loadGameButton = new InitialViewButton("Wczytaj Grę");
        buttonsPanel.add(newGameButton);
        buttonsPanel.add(loadGameButton);
    }

    private void AttachListenersToButtons() {
        this.newGameButton.addActionListener(e -> ((InitialController)controller).InformAboutNewGameOption());
        this.loadGameButton.addActionListener(e -> ((InitialController)controller).InformAboutLoadGameOption());
    }

    private class InitialViewButton extends MyButton {
        public InitialViewButton(String text) {
            super(text, (int)(frameWidth * 0.3), (int)(frameHeight * 0.3), Color.decode(ColorPalette.DARK_GREEN),
                    Color.decode(ColorPalette.YELLOW), Font.BOLD, (int)(frameHeight * 0.1));
        }
    }

}
