package com.pg.student.swingLogic;

import com.pg.student.swingLogic.uiElements.MyFlowPanel;

import javax.swing.*;
import java.awt.*;

public abstract class View extends JFrame {
    protected Controller controller = null;
    protected final int frameWidth;
    protected final int frameHeight;
    protected final Color mainColor;
    protected final Dimension screenDimension;

    public View(double frameWidthToScreenWidth, double frameHeightToScreenHeight, Color color) {
        this.screenDimension = Toolkit.getDefaultToolkit().getScreenSize();
        this.frameWidth = (int)(frameWidthToScreenWidth * this.screenDimension.width);
        this.frameHeight = (int)(frameHeightToScreenHeight * this.screenDimension.height);
        this.mainColor = color;
        this.setSize(this.frameWidth, this.frameHeight);
        this.CreateLayout();
        this.InitFrame();
    }

    public void AddController(Controller controller) {
        this.controller = controller;
    }

    public void Close() {
        setVisible(false);
        dispose();
    }

    public void ShowErrorDialog(String errorMessage) {
        JOptionPane.showMessageDialog(null, errorMessage, "Błąd!", JOptionPane.WARNING_MESSAGE);
    }

    public void ShowMessageDialog(String message) {
        JOptionPane.showMessageDialog(null, message, "Sukces!", JOptionPane.PLAIN_MESSAGE);
    }

    protected void InitFrame() {
        this.setTitle("World Game");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    protected void SetYPadding(int padding) {
        this.add(new MyFlowPanel(frameWidth, padding, mainColor), BorderLayout.NORTH);
        this.add(new MyFlowPanel(frameWidth, padding, mainColor), BorderLayout.SOUTH);
    }

    protected abstract void CreateLayout();
}
