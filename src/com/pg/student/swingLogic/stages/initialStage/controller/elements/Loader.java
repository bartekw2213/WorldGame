package com.pg.student.swingLogic.stages.initialStage.controller.elements;

import com.pg.student.gameLogic.World;

import java.io.*;

public class Loader {
    public static World LoadWorld(File saveFile) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(saveFile);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        World world = (World) objectInputStream.readObject();
        objectInputStream.close();
        return world;
    }
}
