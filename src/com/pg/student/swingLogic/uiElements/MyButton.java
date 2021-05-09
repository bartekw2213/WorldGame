package com.pg.student.swingLogic.uiElements;

import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {
    private int fontWeight = Font.PLAIN;
    private int fontSize = 20;

    public MyButton(String text, int width, int height, Color bgColor, Color fgColor) {
        this.setText(text);
        this.setPreferredSize(new Dimension(width, height));
        this.setBackground(bgColor);
        this.setForeground(fgColor);
        this.setBorderPainted(false);
        this.setFocusPainted(false);
        this.setFont(new Font("Segoe UI", fontWeight, fontSize));
    }

    public MyButton(String text, int width, int height, Color bgColor, Color fgColor, int fontWeight, int fontSize) {
        this(text, width, height, bgColor, fgColor);
        this.fontWeight = fontWeight;
        this.fontSize = fontSize;
        this.setFont(new Font("Segoe UI", fontWeight, fontSize));
    }

}
