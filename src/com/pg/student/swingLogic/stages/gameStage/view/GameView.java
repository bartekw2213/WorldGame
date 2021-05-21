package com.pg.student.swingLogic.stages.gameStage.view;

import com.pg.student.swingLogic.View;
import com.pg.student.swingLogic.colors.ColorPalette;
import com.pg.student.swingLogic.stages.gameStage.controller.GameController;
import com.pg.student.swingLogic.stages.gameStage.view.elements.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;

public class GameView extends View {
    private final double VERTICAL_SECTION_WIDTH_TO_FRAME_WIDTH = 0.15;
    private RightManualSection rightManualSection;
    private GameSection gameSection;
    private BottomLogSection logSection;

    public GameView() {
        super(0.5, 0.9, Color.decode(ColorPalette.ORANGE));
        this.setResizable(true);
    }

    public void AddSaveListener(ActionListener listener) {
        this.rightManualSection.AddSaveListener(listener);
    }

    @Override
    protected void CreateLayout() {
        CreateTopSection();
        CreateLeftLegendSection();
        CreateRightManualSection();
        CreateGameSection();
        CreateBottomLogSection();
    }

    private void CreateTopSection() {
        this.add(new TopSection(frameWidth, mainColor), BorderLayout.NORTH);
    }

    private void CreateLeftLegendSection() {
        this.add(new LeftLegendSection((int)(frameWidth * VERTICAL_SECTION_WIDTH_TO_FRAME_WIDTH), mainColor), BorderLayout.WEST);
    }

    private void CreateRightManualSection() {
        this.rightManualSection = new RightManualSection((int)(frameWidth * VERTICAL_SECTION_WIDTH_TO_FRAME_WIDTH), mainColor);
        this.add(this.rightManualSection, BorderLayout.EAST);
    }

    private void CreateGameSection() {
        this.gameSection = new GameSection(frameWidth, mainColor);
        this.add(this.gameSection, BorderLayout.CENTER);
    }

    private void CreateBottomLogSection() {
        logSection = new BottomLogSection(frameWidth, (int)(frameHeight * 0.2), mainColor,
                (int)(frameWidth * VERTICAL_SECTION_WIDTH_TO_FRAME_WIDTH));
        this.add(this.logSection, BorderLayout.SOUTH);
    }

    public void SetWorldDimensions(int worldSize) {
        this.gameSection.SetWorldSize(worldSize);
    }

    public void DrawWorld(ArrayList<ImageIcon> images) {
        this.gameSection.DrawWorld(images);
    }

    public void DrawEventsLogs(ArrayList<String> events) {
        this.logSection.LogEvents(events);
    }

    public void ShowFileToSaveSelector() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int option = fileChooser.showOpenDialog(this);
        if(option == JFileChooser.APPROVE_OPTION){
            ((GameController)controller).SaveGame(fileChooser.getSelectedFile());
        }
        //@TODO to schowac mozna do innego pliku
    }
}
