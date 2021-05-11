package com.pg.student.swingLogic.stages.gameStage.view;

import com.pg.student.swingLogic.View;
import com.pg.student.swingLogic.colors.ColorPalette;
import com.pg.student.swingLogic.stages.gameStage.view.elements.LeftLegendSection;
import com.pg.student.swingLogic.stages.gameStage.view.elements.RightManualSection;
import com.pg.student.swingLogic.stages.gameStage.view.elements.TopSection;

import java.awt.*;

public class GameView extends View {
    private final int VERTICAL_SECTIONS_WIDTH = 200;

    public GameView() {
        super(1500, 1000, Color.decode(ColorPalette.ORANGE));
    }

    @Override
    protected void CreateLayout() {
        CreateTopSection();
        CreateLeftLegendSection();
        CreateRightManualSection();
    }

    private void CreateTopSection() {
        this.add(new TopSection(frameWidth, mainColor), BorderLayout.NORTH);
    }

    private void CreateLeftLegendSection() {
        this.add(new LeftLegendSection(VERTICAL_SECTIONS_WIDTH, mainColor), BorderLayout.WEST);
    }

    private void CreateRightManualSection() {
        this.add(new RightManualSection(VERTICAL_SECTIONS_WIDTH, mainColor), BorderLayout.EAST);
    }
}
