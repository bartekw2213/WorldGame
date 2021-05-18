package com.pg.student.swingLogic.stages.getInitDataStage.view;

import com.pg.student.swingLogic.colors.ColorPalette;
import com.pg.student.swingLogic.View;
import com.pg.student.swingLogic.uiElements.MyButton;
import com.pg.student.swingLogic.uiElements.MyFlowPanel;
import com.pg.student.swingLogic.uiElements.MyTextField;
import com.pg.student.swingLogic.stages.getInitDataStage.controller.GetInitDataController;

import javax.swing.*;
import java.awt.*;

public class GetInitDataView extends View {
    private JPanel mainPanel;
    private JTextField boardSizeTextField;
    private JTextField organismsNumTextField;

    public GetInitDataView() {
        super(0.2, 0.4, Color.decode(ColorPalette.ORANGE));
    }

    @Override
    protected void CreateLayout() {
        super.SetYPadding(frameHeight/10);
        CreateMainPanel();
        CreateTextFields();
        CreateButton();
    }

    @Override
    public void ShowErrorDialog(String errorMessage) {
        this.boardSizeTextField.setText("Wielkość Planszy");
        this.organismsNumTextField.setText("Ilość Organizmów");
        super.ShowErrorDialog(errorMessage);
    }

    private void CreateMainPanel() {
        this.mainPanel = new MyFlowPanel(frameWidth, frameHeight, mainColor, (int)(frameWidth*0.05), (int)(frameHeight*0.05));
        this.add(this.mainPanel, BorderLayout.CENTER);
    }

    private void CreateTextFields() {
        boardSizeTextField = new GetInitDataTextField("Wielkość Planszy");
        organismsNumTextField = new GetInitDataTextField("Ilość Organizmów");
        this.mainPanel.add(boardSizeTextField);
        this.mainPanel.add(organismsNumTextField);
    }

    private void CreateButton() {
        JButton button = new GetInitDataButton("Dalej");
        button.addActionListener(e -> ((GetInitDataController)controller).InformAboutInitialGameData(
                boardSizeTextField.getText(), organismsNumTextField.getText()));

        this.mainPanel.add(button);
    }

    private class GetInitDataTextField extends MyTextField {
        public GetInitDataTextField(String text) {
            super(text, (int)(frameWidth * 0.7), (int)(frameHeight * 0.15), Color.decode(ColorPalette.DARK_GREEN),
                    Color.decode(ColorPalette.YELLOW), (int)(frameHeight * 0.05));
        }
    }

    private class GetInitDataButton extends MyButton {
        public GetInitDataButton(String text) {
            super(text, (int)(frameWidth * 0.7), (int)(frameHeight * 0.15), Color.decode(ColorPalette.YELLOW),
                    Color.decode(ColorPalette.DARK_GREEN), Font.PLAIN, (int)(frameHeight * 0.05));
        }
    }
}
