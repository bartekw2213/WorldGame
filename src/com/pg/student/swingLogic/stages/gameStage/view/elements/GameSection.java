package com.pg.student.swingLogic.stages.gameStage.view.elements;

import com.pg.student.swingLogic.colors.ColorPalette;
import com.pg.student.swingLogic.uiElements.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameSection extends MyGridPanel {
    private final int BORDER_WIDTH = 10;
    private int worldSize;

    public GameSection(int frameWidth, Color color) {
        super(frameWidth, 100, color);
        CreateBorder(frameWidth);
    }

    private void CreateBorder(int frameWidth) {
        this.setBorder(BorderFactory.createLineBorder(Color.decode(ColorPalette.RED), BORDER_WIDTH));
    }

    public void SetWorldSize(int worldSize) {
        this.worldSize = worldSize;
        this.setLayout(new GridLayout(worldSize, worldSize));
    }

    public void DrawWorld(ArrayList<String> pathsToImages) {
        for(String path : pathsToImages) {
            if(path.isEmpty())
                this.add(new MyLabel());
            else
                this.add(new MyIconLabel("", 40, path));
        }
    }
}
