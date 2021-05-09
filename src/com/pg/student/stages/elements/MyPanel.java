package com.pg.student.stages.elements;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    public MyPanel(int width, int height, Color color) {
        super();
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(color);
    }

    public MyPanel(int width, int height, Color color, int widthGap, int heightGap) {
        super(new FlowLayout(FlowLayout.CENTER, widthGap, heightGap));
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(color);
    }
}
