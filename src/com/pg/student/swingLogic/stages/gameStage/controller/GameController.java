package com.pg.student.swingLogic.stages.gameStage.controller;

import com.pg.student.Program;
import com.pg.student.gameLogic.World;
import com.pg.student.gameLogic.utils.WorldConfig;
import com.pg.student.swingLogic.Controller;
import com.pg.student.swingLogic.View;
import com.pg.student.swingLogic.stages.gameStage.controller.elements.WorldSaver;
import com.pg.student.swingLogic.stages.gameStage.view.GameView;
import com.pg.student.swingLogic.stages.gameStage.view.elements.GameField;
import com.pg.student.swingLogic.stages.gameStage.view.sections.GameSection;
import com.pg.student.swingLogic.uiElements.MyIconLabel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

public class GameController extends Controller implements KeyListener {
    private final World gameWorld;
    private final WorldSaver worldSaver;

    public GameController(Program mainProgram, View view, World world) {
        super(mainProgram, view);
        this.gameWorld = world;
        this.worldSaver = new WorldSaver(this.gameWorld);
        AddListenersToView();
        SetWorldDimensions();
        DrawGame();
    }

    public GameController(Program mainProgram, View view, int boardSize, int organismsNum) {
        this(mainProgram, view, new World(boardSize, organismsNum, view.getWidth()));
    }

    public void SaveGame(File selectedDirectory) {
        try {
            worldSaver.SaveWorld(selectedDirectory);
            view.ShowMessageDialog("Gra została zapisana!");
        } catch (IOException | ClassNotFoundException e) {
            view.ShowErrorDialog("Wystąpił błąd podczas zapisu pliku!");
        }
    }

    public void AddNewOrganismToGame(String organismName, GameField newOrganismField) {
        gameWorld.GetOrganismsFactory().AddNewOrganismSelectedByUser(organismName, newOrganismField.GetX(),
                newOrganismField.GetY());

        newOrganismField.UpdateIcon(gameWorld.GetWorldImageManager().GetOrganismIcon(organismName));
    }

    private void AddListenersToView() {
        view.addKeyListener(this);
        ((GameView)view).AddSaveListener(e -> ((GameView)view).ShowFileToSaveSelector());
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
