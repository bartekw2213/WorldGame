package com.pg.student.swingLogic.stages.gameStage.view.sections;

import com.pg.student.swingLogic.colors.ColorPalette;
import com.pg.student.swingLogic.stages.gameStage.view.GameView;
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
                this.add(new GameField(currentX, currentY));
            else
                this.add(new GameField(currentX, currentY, image));

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

    public class GameField extends MyIconLabel {
        //@TODO tą klase mozna przeniesc do innego pliku
        private final int x;
        private final int y;
        private boolean isOccupied;

        public GameField(int x, int y) {
            this.x = x;
            this.y = y;
            this.isOccupied = false;
            this.AddBorder(Color.decode(ColorPalette.DARK_ORANGE), 1);
            this.setHorizontalAlignment(SwingConstants.CENTER);
            this.addMouseListener(new ClickListener());
        }

        public GameField(int x, int y, ImageIcon image) {
            this(x, y);
            this.isOccupied = true;
            super.SetImage(image);
        }

        public int GetX() {
            return this.x;
        }

        public int GetY() {
            return this.y;
        }

        public void UpdateIcon(ImageIcon newIcon) {
            this.removeAll();
            SetImage(newIcon);
            this.revalidate();
            this.repaint();
        }

        private class ClickListener implements MouseListener {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!isOccupied)
                    view.ShowAnimalPicker(GameField.this);
            }

            @Override
            public void mousePressed(MouseEvent e) { }

            @Override
            public void mouseReleased(MouseEvent e) { }

            @Override
            public void mouseEntered(MouseEvent e) { }

            @Override
            public void mouseExited(MouseEvent e) { }
        }
    }
}
