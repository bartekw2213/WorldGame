package com.pg.student.swingLogic.stages.gameStage.view.elements;

import com.pg.student.swingLogic.colors.ColorPalette;
import com.pg.student.swingLogic.stages.gameStage.view.GameView;
import com.pg.student.swingLogic.stages.gameStage.view.sections.GameSection;
import com.pg.student.swingLogic.uiElements.MyIconLabel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameField extends MyIconLabel {
    private final int x;
    private final int y;
    private boolean isOccupied;
    private final GameView view;

    public GameField(int x, int y, GameView view) {
        this.x = x;
        this.y = y;
        this.isOccupied = false;
        this.view = view;
        this.AddBorder(Color.decode(ColorPalette.DARK_ORANGE), 1);
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.addMouseListener(new ClickListener());
    }

    public GameField(int x, int y, GameView view, ImageIcon image) {
        this(x, y, view);
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
