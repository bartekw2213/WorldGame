package com.pg.student.swingLogic.stages.gameStage.view.elements;

import java.awt.*;

public class RightManualSection extends VerticalSection {
    public RightManualSection(int width, Color color) {
        super(width, color);
        AddLabels();
    }

    @Override
    protected void AddLabels() {
        super.AddLabel("Góra", "src/com/pg/student/images/manual/up.png");
        super.AddLabel("Dół", "src/com/pg/student/images/manual/down.png");
        super.AddLabel("Lewo", "src/com/pg/student/images/manual/left.png");
        super.AddLabel("Prawo", "src/com/pg/student/images/manual/right.png");
        super.AddLabel("SuperMoc", "src/com/pg/student/images/manual/s-letter.png");
    }
}
