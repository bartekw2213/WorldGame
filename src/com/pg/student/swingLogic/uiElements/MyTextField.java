package com.pg.student.swingLogic.uiElements;

import javax.swing.*;
import java.awt.*;

public class MyTextField extends JTextField {
    public MyTextField(String text, int width, int height, Color bgColor, Color fgColor, int fontSize) {
        this.setText(text);
        this.setPreferredSize(new Dimension(width, height));
        this.setFont(new Font("Segoe UI", Font.BOLD, fontSize));
        this.setBackground(bgColor);
        this.setForeground(fgColor);
        this.setHorizontalAlignment(JTextField.CENTER);
    }

    public void setPadding(int top, int right, int bottom, int left) {
        this.setBorder(BorderFactory.createCompoundBorder(this.getBorder(), BorderFactory.createEmptyBorder(top, left, bottom, right)));
    }

}
