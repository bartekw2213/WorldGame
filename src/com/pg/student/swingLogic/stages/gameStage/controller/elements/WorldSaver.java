package com.pg.student.swingLogic.stages.gameStage.controller.elements;

import com.pg.student.gameLogic.World;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WorldSaver {
    private final World world;

    public WorldSaver(World world) {
        this.world = world;
    }

    public void SaveWorld(File directory) throws IOException, ClassNotFoundException {
        File saveFile = CreateFileToSaveTo(directory);
        FileOutputStream fileOutputStream = new FileOutputStream(saveFile);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(world);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    private File CreateFileToSaveTo(File directory) throws IOException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd_MM_HH:mm:ss");
        Date date = new Date();
        String fileName = "zapis_gry_" + formatter.format(date);
        File saveFile = new File(directory.getAbsolutePath() + "/" + fileName);
        saveFile.createNewFile(); //@TODO nie ignorować tego
        return saveFile;
    }
}
