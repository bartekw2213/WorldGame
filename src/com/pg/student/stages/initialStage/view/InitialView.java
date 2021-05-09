package com.pg.student.stages.initialStage.view;

import com.pg.student.colors.ColorPalette;
import com.pg.student.stages.View;
import com.pg.student.stages.elements.MyButton;
import com.pg.student.stages.elements.MyFlowPanel;
import com.pg.student.stages.initialStage.controller.InitialController;

import javax.swing.*;
import java.awt.*;

public class InitialView extends View {
    private JButton newGameButton = null;
    private JButton loadGameButton = null;

    public InitialView() {
        super(1000, 300, Color.decode(ColorPalette.ORANGE));
    }

    @Override
    protected void CreateLayout() {
        super.SetYPadding((int)(frameHeight/4.25));
        CreateButtonsPanel();
    }

    private void CreateButtonsPanel() {
        JPanel buttonsPanel = new MyFlowPanel(frameWidth, frameHeight, mainColor, 50, 0);

        CreateButtons(buttonsPanel);
        AttachListenersToButtons();

        this.add(buttonsPanel, BorderLayout.CENTER);
    }

    private void CreateButtons(JPanel buttonsPanel) {
        this.newGameButton = new MyButton("Nowa Gra", 300, 80, Color.decode(ColorPalette.DARK_GREEN),
                Color.decode(ColorPalette.YELLOW), Font.BOLD, 26);
        this.loadGameButton = new MyButton("Wczytaj Grę", 300, 80, Color.decode(ColorPalette.DARK_GREEN),
                Color.decode(ColorPalette.YELLOW), Font.BOLD, 26);
        buttonsPanel.add(newGameButton);
        buttonsPanel.add(loadGameButton);
    }

    private void AttachListenersToButtons() {
        this.newGameButton.addActionListener(e -> ((InitialController)controller).InformAboutNewGameOption());
        this.loadGameButton.addActionListener(e -> ((InitialController)controller).InformAboutLoadGameOption());
    }

}
