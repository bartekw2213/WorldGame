package com.pg.student.stages;

import com.pg.student.Program;

import java.awt.event.WindowEvent;

public abstract class Controller {
    private Program mainProgram;
    protected View view;

    public Controller(Program mainProgram, View view) {
        this.mainProgram = mainProgram;
        this.view = view;
        this.view.AddController(this);
    }

    protected void EndStage() {
        mainProgram.ReactToStageFinish(this);
    }

    protected void CloseView() {
        this.view.Close();
    }
}
