package com.pg.student.swingLogic.stages.gameStage.view.elements;

import com.pg.student.swingLogic.colors.ColorPalette;
import com.pg.student.swingLogic.uiElements.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Set;

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
        this.removeAll();

        for(ImageIcon image : images) {
            if(image == null)
                this.add(new GameField());
            else
                this.add(new GameField(image));
        }

        RefreshPanel();
    }

    private class GameField extends MyIconLabel {
        public GameField(ImageIcon image) {
            super(image);
            SetInitialLook();
        }

        public GameField() {
            SetInitialLook();
        }

        private void SetInitialLook() {
            this.AddBorder(Color.decode(ColorPalette.DARK_ORANGE), 1);
            this.setHorizontalAlignment(SwingConstants.CENTER);
        }
    }
}
