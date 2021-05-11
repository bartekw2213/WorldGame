package com.pg.student.swingLogic.stages.gameStage.view.elements;

import com.pg.student.swingLogic.colors.ColorPalette;
import com.pg.student.swingLogic.uiElements.MyBorderPanel;
import com.pg.student.swingLogic.uiElements.MyFlowPanel;

import javax.swing.*;
import java.awt.*;

public class BoardSection extends MyBorderPanel {
    private final int BORDER_WIDTH = 10;

    public BoardSection(int frameWidth, Color color) {
        super(frameWidth, 100, color);
        CreateBorder(frameWidth);
    }

    private void CreateBorder(int frameWidth) {
        this.setBorder(BorderFactory.createLineBorder(Color.decode(ColorPalette.RED), BORDER_WIDTH));
    }
}
