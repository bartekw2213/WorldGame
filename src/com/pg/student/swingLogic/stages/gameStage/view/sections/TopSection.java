package com.pg.student.swingLogic.stages.gameStage.view.sections;

import com.pg.student.swingLogic.uiElements.MyBorderPanel;
import com.pg.student.swingLogic.uiElements.MyFlowPanel;
import com.pg.student.swingLogic.uiElements.MyLabel;

import javax.swing.*;
import java.awt.*;

public class TopSection extends MyBorderPanel {
    public TopSection(int frameWidth, Color bgColor) {
        super(frameWidth, (int)(frameWidth * 0.1), bgColor);
        CreateHeader();
        CreateSignature();
        CreateBottomPadding((int)(PANEL_HEIGHT * 0.1));
    }

    private void CreateHeader() {
        JPanel headerPanel = new MyFlowPanel(PANEL_WIDTH, PANEL_HEIGHT / 2, PANEL_COLOR);
        JLabel headerLabel = new MyLabel("World Game", Font.BOLD, PANEL_HEIGHT * 2/5);
        headerPanel.add(headerLabel);
        this.add(headerPanel, BorderLayout.NORTH);
    }

    private void CreateSignature() {
        JPanel signaturePanel = new MyFlowPanel(PANEL_WIDTH, PANEL_HEIGHT / 4, PANEL_COLOR);
        JLabel signatureLabel = new MyLabel("Bartłomiej Wilczyński 184899", Font.BOLD, PANEL_HEIGHT / 6);
        signaturePanel.add(signatureLabel);
        this.add(signaturePanel, BorderLayout.SOUTH);
    }

    private void CreateBottomPadding(int padding) {
        this.setBorder(BorderFactory.createEmptyBorder(0, 0, padding, 0));
    }
}
