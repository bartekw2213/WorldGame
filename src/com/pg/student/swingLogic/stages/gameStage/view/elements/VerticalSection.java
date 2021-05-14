package com.pg.student.swingLogic.stages.gameStage.view.elements;

import com.pg.student.swingLogic.uiElements.MyFlowPanel;
import com.pg.student.swingLogic.uiElements.MyIconLabel;
import java.awt.*;


abstract class VerticalSection extends MyFlowPanel {
    public VerticalSection(int width, Color color) {
        super(width, 100, color);
    }

    protected void AddLabel(String text, String imgPath) {
        this.add(new MyIconLabel(text, 60, imgPath));
    }

    protected abstract void AddLabels();
}
