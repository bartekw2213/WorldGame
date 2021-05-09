package com.pg.student.stages;

import javax.swing.*;
import java.awt.*;

public abstract class View extends JFrame {
    protected Controller controller = null;
    protected final int frameWidth;
    protected final int frameHeight;
    protected final Color mainColor;

    public View(int width, int height, Color color) {
        this.frameWidth = width;
        this.frameHeight = height;
        this.mainColor = color;
        this.setSize(this.frameWidth, this.frameHeight);
    }

    public void AddController(Controller controller) {
        this.controller = controller;
    }

    public void Close() {
        setVisible(false);
        dispose();
    }

    protected void InitFrame() {
        this.setTitle("World Game");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }
}
