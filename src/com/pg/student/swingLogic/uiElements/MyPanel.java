package com.pg.student.swingLogic.uiElements;

import javax.swing.*;
import java.awt.*;

abstract class MyPanel extends JPanel {
    protected final int PANEL_WIDTH;
    protected final int PANEL_HEIGHT;
    protected final Color PANEL_COLOR;

    public MyPanel(LayoutManager layout, int width, int height, Color color) {
        super(layout);
        this.PANEL_WIDTH = width;
        this.PANEL_HEIGHT = height;
        this.PANEL_COLOR = color;

        this.setPreferredSize(new Dimension(this.PANEL_WIDTH, this.PANEL_HEIGHT));
        this.setBackground(this.PANEL_COLOR);
    }
}