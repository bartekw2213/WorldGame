package com.pg.student.swingLogic.uiElements;

import javax.swing.*;
import java.awt.*;

public class MyLabel extends JLabel {
    public MyLabel(String text, int fontWeight, int fontSize) {
        super(text);
        this.setFont(new Font("Segoe UI", fontWeight, fontSize));
    }

    public MyLabel() {

    }
}
