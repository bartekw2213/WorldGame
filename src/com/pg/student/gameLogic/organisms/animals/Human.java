package com.pg.student.gameLogic.organisms.animals;

import com.pg.student.gameLogic.World;
import com.pg.student.gameLogic.utils.Position;
import com.pg.student.gameLogic.utils.WorldConfig;

public class Human extends Animal {
    public Human(Position organismPosition, World world) {
        super(organismPosition, WorldConfig.HUMAN_INITIATIVE, WorldConfig.HUMAN_POWER, WorldConfig.HUMAN_NAME, world);
    }

    @Override
    protected boolean IsTheSameType(Animal otherAnimal) {
        return false;
    }

    @Override
    protected void Multiply(Position newPosition) {

    }
}
