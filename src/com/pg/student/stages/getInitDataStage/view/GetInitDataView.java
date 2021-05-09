package com.pg.student.stages.getInitDataStage.view;

import com.pg.student.colors.ColorPalette;
import com.pg.student.stages.View;
import com.pg.student.stages.elements.MyButton;
import com.pg.student.stages.elements.MyFlowPanel;
import com.pg.student.stages.elements.MyTextField;
import com.pg.student.stages.getInitDataStage.controller.GetInitDataController;

import javax.swing.*;
import java.awt.*;

public class GetInitDataView extends View {
    private JPanel mainPanel;
    private JTextField boardSizeTextField;
    private JTextField organismsNumTextField;

    public GetInitDataView() {
        super(500, 600, Color.decode(ColorPalette.ORANGE));
    }

    @Override
    protected void CreateLayout() {
        super.SetYPadding(frameHeight/5);
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
        this.mainPanel = new MyFlowPanel(frameWidth, frameHeight, mainColor, 10, 10);
        this.add(this.mainPanel, BorderLayout.CENTER);
    }

    private void CreateTextFields() {
        boardSizeTextField = new MyTextField("Wielkość Planszy", 400, 70,
                Color.decode(ColorPalette.DARK_GREEN), Color.decode(ColorPalette.YELLOW), 26);
        organismsNumTextField = new MyTextField("Ilość Organizmów", 400, 70,
                Color.decode(ColorPalette.DARK_GREEN), Color.decode(ColorPalette.YELLOW), 26);

        this.mainPanel.add(boardSizeTextField);
        this.mainPanel.add(organismsNumTextField);
    }

    private void CreateButton() {
        JButton button = new MyButton("Dalej", 400, 70, Color.decode(ColorPalette.YELLOW),
                Color.decode(ColorPalette.DARK_GREEN), Font.PLAIN, 30);
        button.addActionListener(e -> ((GetInitDataController)controller).InformAboutInitialGameData(
                boardSizeTextField.getText(), organismsNumTextField.getText()));

        this.mainPanel.add(button);
    }
}
