package com.pg.student.swingLogic.stages.gameStage.view.elements;

import com.pg.student.swingLogic.uiElements.MyFlowPanel;
import com.pg.student.swingLogic.uiElements.MyLabel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

abstract class VerticalSection extends MyFlowPanel {
    public VerticalSection(int width, Color color) {
        super(width, 100, color);
    }

    protected void AddLabel(String text, String imgPath) {
        this.add(new IconLabel(text, imgPath));
    }

    protected abstract void AddLabels();

    private class IconLabel extends MyLabel {
        private final int ICON_SIZE = 60;

        public IconLabel(String text, String imgPath) {
            super(text, Font.PLAIN, 26);
            SetImage(imgPath);
        }

        private void SetImage(String imgPath) {
            BufferedImage image = LoadImage(imgPath);
            assert image != null;
            Image resizedImage = GetResizedImage(image);
            this.setIcon(new ImageIcon(resizedImage));
        }

        private BufferedImage LoadImage(String imgPath) {
            try {
                return ImageIO.read(new File(imgPath));
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        private Image GetResizedImage(BufferedImage image) {
            return image.getScaledInstance(ICON_SIZE, ICON_SIZE, Image.SCALE_SMOOTH);
        }
    }
}
