package com.pg.student.swingLogic.stages.gameStage.view;

import com.pg.student.swingLogic.View;
import com.pg.student.swingLogic.colors.ColorPalette;
import com.pg.student.swingLogic.stages.gameStage.view.elements.*;

import java.awt.*;

public class GameView extends View {
    private final int VERTICAL_SECTIONS_WIDTH = 230;

    public GameView() {
        super(1700, 1200, Color.decode(ColorPalette.ORANGE));
        this.setResizable(true);
    }

    @Override
    protected void CreateLayout() {
        CreateTopSection();
        CreateLeftLegendSection();
        CreateRightManualSection();
        CreateBoardSection();
        CreateBottomLogSection();
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

    private void CreateBoardSection() {
        this.add(new BoardSection(frameWidth, mainColor), BorderLayout.CENTER);
    }

    private void CreateBottomLogSection() {
        this.add(new BottomLogSection(frameWidth, mainColor), BorderLayout.SOUTH);
    }
}
