package com.pg.student.swingLogic.stages.gameStage.controller;

import com.pg.student.Program;
import com.pg.student.gameLogic.World;
import com.pg.student.swingLogic.Controller;
import com.pg.student.swingLogic.View;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameController extends Controller implements KeyListener {
    private World gameWorld;

    public GameController(Program mainProgram, View view, int boardSize, int organismsNum) {
        super(mainProgram, view);
        view.addKeyListener(this);
        this.gameWorld = new World(boardSize, organismsNum);
    }

    @Override
    public void keyTyped(KeyEvent e) { }

    @Override
    public void keyReleased(KeyEvent e) { }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_RIGHT: System.out.println("Przycisk nacisniety"); break;
            case KeyEvent.VK_LEFT: System.out.println("Przycisk nacisniety"); break;
            case KeyEvent.VK_UP: System.out.println("Przycisk nacisniety"); break;
            case KeyEvent.VK_DOWN: System.out.println("Przycisk nacisniety"); break;
            case KeyEvent.VK_S: System.out.println("Przycisk nacisniety"); break;
        }
    }

}
