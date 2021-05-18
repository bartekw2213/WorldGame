package com.pg.student.swingLogic.uiElements;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MyIconLabel extends MyLabel{
    private final int ICON_SIZE;

    public MyIconLabel(String text, int iconSize, String imgPath, int fontSize) {
        super(text, Font.PLAIN, fontSize);
        this.ICON_SIZE = iconSize;
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
