package com.pg.student.swingLogic.uiElements;

import java.awt.*;

public class MyGridPanel extends MyPanel {
    public MyGridPanel(int width, int height, Color color) {
        super(new GridLayout(), width, height, color);
    }
}
