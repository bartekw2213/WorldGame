package com.pg.student.swingLogic.uiElements;

import javax.swing.*;
import java.awt.*;

public class MyLabel extends JLabel {
    public MyLabel() { }

    public MyLabel(String text, int fontWeight, int fontSize) {
        super(text);
        this.setFont(new Font("Segoe UI", fontWeight, fontSize));
    }

    public void AddBorder(Color color, int width) {
        this.setBorder(BorderFactory.createLineBorder(color, width));
    }
}
