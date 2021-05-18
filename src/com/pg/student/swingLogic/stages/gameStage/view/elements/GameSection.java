package com.pg.student.swingLogic.stages.gameStage.view.elements;

import com.pg.student.swingLogic.colors.ColorPalette;
import com.pg.student.swingLogic.uiElements.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GameSection extends MyGridPanel {
    private final int BORDER_WIDTH = 5;

    public GameSection(int frameWidth, Color color) {
        super(frameWidth, 100, color);
        CreateBorder(frameWidth);
    }

    private void CreateBorder(int frameWidth) {
        this.setBorder(BorderFactory.createLineBorder(Color.decode(ColorPalette.RED), BORDER_WIDTH));
    }

    public void SetWorldSize(int worldSize) {
        this.setLayout(new GridLayout(worldSize, worldSize));
    }

    public void DrawWorld(ArrayList<ImageIcon> images) {
        int fieldBorderWidth = 1;
        this.removeAll();

        for(ImageIcon image : images) {
            if(image == null) {
                MyLabel emptyField = new MyLabel();
                emptyField.AddBorder(Color.decode(ColorPalette.DARK_ORANGE), fieldBorderWidth);
                this.add(emptyField);
            } else {
                MyLabel organismField = new MyIconLabel(image);
                organismField.AddBorder(Color.decode(ColorPalette.DARK_ORANGE), fieldBorderWidth);
                organismField.setHorizontalAlignment(SwingConstants.CENTER);
                this.add(organismField);
            }
        }

        RefreshPanel();
    }
}
