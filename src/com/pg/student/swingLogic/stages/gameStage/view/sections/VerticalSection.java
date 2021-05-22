package com.pg.student.swingLogic.stages.gameStage.view.sections;

import com.pg.student.swingLogic.uiElements.MyFlowPanel;
import com.pg.student.swingLogic.uiElements.MyIconLabel;
import java.awt.*;


abstract class VerticalSection extends MyFlowPanel {
    public VerticalSection(int width, Color color) {
        super(width, 100, color);
    }

    protected void AddLabel(String text, String imgPath) {
        this.add(new MyIconLabel(text, (int)(PANEL_WIDTH * 0.3), imgPath, (int)(PANEL_WIDTH * 0.1)));
    }

    protected abstract void AddLabels();
}
