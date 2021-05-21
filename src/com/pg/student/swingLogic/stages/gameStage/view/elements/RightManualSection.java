package com.pg.student.swingLogic.stages.gameStage.view.elements;

import com.pg.student.swingLogic.colors.ColorPalette;
import com.pg.student.swingLogic.uiElements.MyButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class RightManualSection extends VerticalSection {
    private MyButton saveButton;

    public RightManualSection(int width, Color color) {
        super(width, color);
        AddLabels();
        AddSaveButton();
    }

    public void AddSaveListener(ActionListener listener) {
        saveButton.addActionListener(listener);
    }

    @Override
    protected void AddLabels() {
        super.AddLabel("Góra", "src/com/pg/student/images/manual/up.png");
        super.AddLabel("Dół", "src/com/pg/student/images/manual/down.png");
        super.AddLabel("Lewo", "src/com/pg/student/images/manual/left.png");
        super.AddLabel("Prawo", "src/com/pg/student/images/manual/right.png");
        super.AddLabel("SuperMoc", "src/com/pg/student/images/manual/s-letter.png");
    }

    private void AddSaveButton() {
        this.saveButton = new MyButton("Zapisz", (int)(PANEL_WIDTH * 0.75), (int)(PANEL_WIDTH * 0.4),
                Color.decode(ColorPalette.DARK_GREEN), Color.decode(ColorPalette.YELLOW));
        this.saveButton.setFocusable(false);
        this.add(this.saveButton);
    }
}
