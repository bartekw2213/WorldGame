package com.pg.student.swingLogic.stages.gameStage.view.elements;

import com.pg.student.swingLogic.uiElements.MyBorderPanel;
import com.pg.student.swingLogic.uiElements.MyFlowPanel;
import com.pg.student.swingLogic.uiElements.MyLabel;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

//public class BottomLogSection extends MyFlowPanel {
//    public BottomLogSection(Color color, int xPadding, int yPadding) {
//        super(width, 250, color, FlowLayout.LEFT, 40, 30);
//    }
//
//    public void LogEvents(ArrayList<String> events) {
//        this.removeAll();
//        RefreshPanel();
//
//        for(String event : events)
//            this.add(new EventLabel(event));
//
//        RefreshPanel();
//    }
//
//    private class EventLabel extends MyLabel {
//        public EventLabel(String text) {
//            super(text, Font.PLAIN, 24);
//        }
//    }
//
//}

public class BottomLogSection extends MyBorderPanel {
    private MyFlowPanel logsPanel;

    public BottomLogSection(int width, int height, Color color, int xPadding) {
        super(width, height, color);
        MakePadding(xPadding);
        CreateLogPanel();
    }

    public void MakePadding(int xPadding) {
        this.add(new MyFlowPanel(xPadding, PANEL_HEIGHT, PANEL_COLOR), BorderLayout.WEST);
        this.add(new MyFlowPanel(xPadding, PANEL_HEIGHT, PANEL_COLOR), BorderLayout.EAST);
    }

    public void CreateLogPanel() {
        final int gridGap = (int)(PANEL_WIDTH * 0.02);

        this.logsPanel = new MyFlowPanel(PANEL_WIDTH, PANEL_HEIGHT, PANEL_COLOR, FlowLayout.LEFT, gridGap, gridGap);
        this.add(this.logsPanel, BorderLayout.CENTER);
    }

    public void LogEvents(ArrayList<String> events) {
        logsPanel.removeAll();
        logsPanel.RefreshPanel();

        for(String event : events)
            logsPanel.add(new EventLabel(event));

        logsPanel.RefreshPanel();
    }

    private class EventLabel extends MyLabel {
        public EventLabel(String text) {
            super(text, Font.PLAIN, (int)(PANEL_HEIGHT * 0.1));
        }
    }

}
