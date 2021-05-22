package com.pg.student.gameLogic.utils;

import com.pg.student.gameLogic.World;
import com.pg.student.gameLogic.organisms.Organism;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

public class WorldImageManager implements Serializable {
    PositionsManager positionsManager;
    private final int gameImagesSize;
    private ImageIcon ANTELOPE_IMAGE;
    private ImageIcon FOX_IMAGE;
    private ImageIcon HUMAN_IMAGE;
    private ImageIcon SHEEP_IMAGE;
    private ImageIcon TURTLE_IMAGE;
    private ImageIcon WOLF_IMAGE;
    private ImageIcon BERRY_IMAGE;
    private ImageIcon BORSCH_IMAGE;
    private ImageIcon GRASS_IMAGE;
    private ImageIcon GUARANA_IMAGE;
    private ImageIcon SONCHUS_IMAGE;

    public WorldImageManager(PositionsManager positionsManager, int frameWidth) {
        this.positionsManager = positionsManager;
        this.gameImagesSize = (int)(frameWidth * 0.03);
        LoadImages();
    }

    public ArrayList<ImageIcon> GetImagesOfOrganismsOnEachPosition() {
        ArrayList<Organism> organismOnEachPosition = positionsManager.FindWhoStandsOnEachPosition();
        ArrayList<ImageIcon> imagesOfOrganismsOnEachPosition = new ArrayList<>(organismOnEachPosition.size());

        for(Organism organism : organismOnEachPosition) {
            if(organism == null)
                imagesOfOrganismsOnEachPosition.add(null);
            else
                imagesOfOrganismsOnEachPosition.add(GetOrganismIcon(organism.GetName()));
        }

        return imagesOfOrganismsOnEachPosition;
    }

    public ImageIcon GetOrganismIcon(String organismName) {
        ImageIcon returnedImage = null;

        switch(organismName) {
            case WorldConfig.ANTELOPE_NAME: returnedImage = ANTELOPE_IMAGE; break;
            case WorldConfig.FOX_NAME: returnedImage = FOX_IMAGE; break;
            case WorldConfig.HUMAN_NAME: returnedImage = HUMAN_IMAGE; break;
            case WorldConfig.SHEEP_NAME: returnedImage = SHEEP_IMAGE; break;
            case WorldConfig.TURTLE_NAME: returnedImage = TURTLE_IMAGE; break;
            case WorldConfig.WOLF_NAME: returnedImage = WOLF_IMAGE; break;
            case WorldConfig.BERRY_NAME: returnedImage = BERRY_IMAGE; break;
            case WorldConfig.BORSCH_NAME: returnedImage = BORSCH_IMAGE; break;
            case WorldConfig.GRASS_NAME: returnedImage = GRASS_IMAGE; break;
            case WorldConfig.GUARANA_NAME: returnedImage = GUARANA_IMAGE; break;
            case WorldConfig.SONCHUS_NAME: returnedImage = SONCHUS_IMAGE; break;
        }

        return returnedImage;
    }

    private void LoadImages() {
        ANTELOPE_IMAGE = LoadAndResizeImage(WorldConfig.ANTELOPE_IMG_PATH);
        FOX_IMAGE = LoadAndResizeImage(WorldConfig.FOX_IMG_PATH);
        HUMAN_IMAGE = LoadAndResizeImage(WorldConfig.HUMAN_IMG_PATH);
        SHEEP_IMAGE = LoadAndResizeImage(WorldConfig.SHEEP_IMG_PATH);
        TURTLE_IMAGE = LoadAndResizeImage(WorldConfig.TURTLE_IMG_PATH);
        WOLF_IMAGE = LoadAndResizeImage(WorldConfig.WOLF_IMG_PATH);
        BERRY_IMAGE = LoadAndResizeImage(WorldConfig.BERRY_IMG_PATH);
        BORSCH_IMAGE = LoadAndResizeImage(WorldConfig.BORSCH_IMG_PATH);
        GRASS_IMAGE = LoadAndResizeImage(WorldConfig.GRASS_IMG_PATH);
        GUARANA_IMAGE = LoadAndResizeImage(WorldConfig.GUARANA_IMG_PATH);
        SONCHUS_IMAGE = LoadAndResizeImage(WorldConfig.SONCHUS_IMG_PATH);
    }

    private ImageIcon LoadAndResizeImage(String path) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        assert image != null;
        return new ImageIcon(image.getScaledInstance(gameImagesSize, gameImagesSize, Image.SCALE_SMOOTH));
    }
}
