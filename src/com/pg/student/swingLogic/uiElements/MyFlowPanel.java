package com.pg.student.swingLogic.uiElements;

import java.awt.*;

public class MyFlowPanel extends MyPanel {
    public MyFlowPanel(int width, int height, Color color) {
        super(new FlowLayout(), width, height, color);
    }

    public MyFlowPanel(int width, int height, Color color, int widthGap, int heightGap) {
        super(new FlowLayout(FlowLayout.CENTER, widthGap, heightGap), width, height, color);
    }

    public MyFlowPanel(int width, int height, Color color, int align, int widthGap, int heightGap) {
        super(new FlowLayout(align, widthGap, heightGap), width, height, color);
    }
}
