package com.pg.student.swingLogic.stages.gameStage.view.elements;

import com.pg.student.swingLogic.uiElements.MyFlowPanel;
import com.pg.student.swingLogic.uiElements.MyLabel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class LeftLegendSection extends VerticalSection {
    public LeftLegendSection(int width, Color color) {
        super(width, color);
        AddLabels();
    }

    @Override
    protected void AddLabels() {
        super.AddLabel("Antelopa", "src/com/pg/student/images/antelope.png");
        super.AddLabel("Jagody", "src/com/pg/student/images/berries.png");
        super.AddLabel("Barszcz", "src/com/pg/student/images/borsch.png");
        super.AddLabel("Lis", "src/com/pg/student/images/fox.png");
        super.AddLabel("Trawa", "src/com/pg/student/images/grass.png");
        super.AddLabel("Guarana", "src/com/pg/student/images/guarana.png");
        super.AddLabel("Gracz", "src/com/pg/student/images/player.png");
        super.AddLabel("Owca", "src/com/pg/student/images/sheep.png");
        super.AddLabel("Mlecz", "src/com/pg/student/images/sonchus.png");
        super.AddLabel("Żółw", "src/com/pg/student/images/turtle.png");
        super.AddLabel("Wilk", "src/com/pg/student/images/wolf.png");
    }
}
