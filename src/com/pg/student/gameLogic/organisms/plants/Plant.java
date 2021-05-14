package com.pg.student.gameLogic.organisms.plants;

import com.pg.student.gameLogic.World;
import com.pg.student.gameLogic.organisms.Organism;
import com.pg.student.gameLogic.utils.Position;
import com.pg.student.gameLogic.utils.WorldConfig;

import java.util.Random;

public abstract class Plant extends Organism {
    public Plant(Position organismPosition, int initiative, int power, String name, String pathToImage, World world) {
        super(organismPosition, initiative, power, name, pathToImage, world);
    }

    @Override
    public void Action() {
        int randomNumber = (new Random()).nextInt(100);
        if(randomNumber < WorldConfig.PERCENTAGE_CHANGE_TO_PLANT_MULTIPLY)
            MultiplyIfFreePositionIsAround();
    }

    @Override
    public void Collision(Organism otherOrganism) {

    }
}
