package com.pg.student.swingLogic.uiElements;

import javax.swing.*;
import java.awt.*;

public class MyFlowPanel extends JPanel {
    public MyFlowPanel(int width, int height, Color color) {
        super();
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(color);
    }

    public MyFlowPanel(int width, int height, Color color, int widthGap, int heightGap) {
        super(new FlowLayout(FlowLayout.CENTER, widthGap, heightGap));
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(color);
    }
}
