package com.pg.student.swingLogic.stages.gameStage.controller;

import com.pg.student.Program;
import com.pg.student.gameLogic.World;
import com.pg.student.gameLogic.utils.WorldConfig;
import com.pg.student.swingLogic.Controller;
import com.pg.student.swingLogic.View;
import com.pg.student.swingLogic.stages.gameStage.view.GameView;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameController extends Controller implements KeyListener {
    private World gameWorld;

    public GameController(Program mainProgram, View view, int boardSize, int organismsNum) {
        super(mainProgram, view);
        this.gameWorld = new World(boardSize, organismsNum, view.getWidth());
        AddListenerToView();
        SetWorldDimensions();
        DrawGame();
    }

    private void AddListenerToView() {
        view.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyReleased(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_RIGHT: TriggerWorldRound(WorldConfig.USER_MOVES.RIGHT); break;
            case KeyEvent.VK_LEFT: TriggerWorldRound(WorldConfig.USER_MOVES.LEFT); break;
            case KeyEvent.VK_UP: TriggerWorldRound(WorldConfig.USER_MOVES.UP); break;
            case KeyEvent.VK_DOWN: TriggerWorldRound(WorldConfig.USER_MOVES.DOWN); break;
            case KeyEvent.VK_S: TriggerWorldRound(WorldConfig.USER_MOVES.SUPER_POWER); break;
        }
    }

    private void TriggerWorldRound(WorldConfig.USER_MOVES userMove) {
        gameWorld.SetUserMove(userMove);
        gameWorld.TriggerRound();
        DrawGame();
    }

    private void SetWorldDimensions() {
        ((GameView)this.view).SetWorldDimensions(gameWorld.GetWorldSize());
    }

    private void DrawGame() {
        ((GameView)this.view).DrawWorld(gameWorld.GetWorldImageManager().GetImagesOfOrganismsOnEachPosition());
        ((GameView)this.view).DrawEventsLogs(gameWorld.GetEventLoggingManager().GetEvents());
    }


}
