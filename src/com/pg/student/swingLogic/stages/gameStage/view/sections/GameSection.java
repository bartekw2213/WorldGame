package com.pg.student.swingLogic.stages.gameStage.view.sections;

import com.pg.student.swingLogic.colors.ColorPalette;
import com.pg.student.swingLogic.stages.gameStage.view.GameView;
import com.pg.student.swingLogic.stages.gameStage.view.elements.GameField;
import com.pg.student.swingLogic.uiElements.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class GameSection extends MyGridPanel {
    private final int BORDER_WIDTH = 5;
    private final GameView view;
    private int worldSize;

    public GameSection(int frameWidth, int gameSize, Color color, GameView view) {
        super(frameWidth, 100, color);
        this.worldSize = 0;
        this.view = view;
        CreateBorder(frameWidth);
    }

    private void CreateBorder(int frameWidth) {
        this.setBorder(BorderFactory.createLineBorder(Color.decode(ColorPalette.RED), BORDER_WIDTH));
    }

    public void SetWorldSize(int worldSize) {
        this.setLayout(new GridLayout(worldSize, worldSize));
        this.worldSize = worldSize;
    }

    public void DrawWorld(ArrayList<ImageIcon> images) {
        this.removeAll();
        int currentX = 0, currentY = 0;

        for(ImageIcon image : images) {
            if(image == null)
                this.add(new GameField(currentX, currentY, view));
            else
                this.add(new GameField(currentX, currentY, view, image));

            currentX = getCurrentX(currentX);
            currentY = getCurrentY(currentX, currentY);
        }

        RefreshPanel();
    }

    private int getCurrentX(int x) {
        return (++x) % worldSize;
    }

    private int getCurrentY(int x, int y) {
        return (x == 0) ? ++y : y;
    }
}
