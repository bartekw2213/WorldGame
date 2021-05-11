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
        super.AddLabel("Antelopa", "src/com/pg/student/images/organisms/antelope.png");
        super.AddLabel("Jagody", "src/com/pg/student/images/organisms/berries.png");
        super.AddLabel("Barszcz", "src/com/pg/student/images/organisms/borsch.png");
        super.AddLabel("Lis", "src/com/pg/student/images/organisms/fox.png");
        super.AddLabel("Trawa", "src/com/pg/student/images/organisms/grass.png");
        super.AddLabel("Guarana", "src/com/pg/student/images/organisms/guarana.png");
        super.AddLabel("Gracz", "src/com/pg/student/images/organisms/player.png");
        super.AddLabel("Owca", "src/com/pg/student/images/organisms/sheep.png");
        super.AddLabel("Mlecz", "src/com/pg/student/images/organisms/sonchus.png");
        super.AddLabel("Żółw", "src/com/pg/student/images/organisms/turtle.png");
        super.AddLabel("Wilk", "src/com/pg/student/images/organisms/wolf.png");
    }
}
