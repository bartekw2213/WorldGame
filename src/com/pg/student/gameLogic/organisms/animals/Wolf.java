package com.pg.student.gameLogic.organisms.animals;

import com.pg.student.gameLogic.World;
import com.pg.student.gameLogic.utils.Position;
import com.pg.student.gameLogic.utils.WorldConfig;

public class Wolf extends Animal {
    public Wolf(Position organismPosition, World world) {
        super(organismPosition, WorldConfig.WOLF_INITIATIVE, WorldConfig.WOLF_POWER, WorldConfig.WOLF_NAME, world);
    }

    @Override
    protected boolean IsTheSameType(Animal otherAnimal) {
        return false;
    }

    @Override
    protected void Multiply(Position newPosition) {
        world.GetOrganismsManager().AddOrganism(new Wolf(newPosition, world));
    }
}
