package com.pg.student.gameLogic.organisms.animals;

import com.pg.student.gameLogic.World;
import com.pg.student.gameLogic.utils.Position;
import com.pg.student.gameLogic.utils.WorldConfig;

import java.io.Serializable;

public class Wolf extends Animal implements Serializable {
    public Wolf(Position organismPosition, World world) {
        super(organismPosition, WorldConfig.WOLF_INITIATIVE, WorldConfig.WOLF_POWER, WorldConfig.WOLF_NAME, world);
    }

    @Override
    protected boolean IsTheSameType(Animal otherAnimal) {
        return otherAnimal instanceof Wolf;
    }

    @Override
    protected void Multiply(Position newPosition) {
        world.GetOrganismsManager().AddOrganism(new Wolf(newPosition, world));
    }
}
