package com.pg.student.gameLogic.organisms.animals;

import com.pg.student.gameLogic.World;
import com.pg.student.gameLogic.utils.Position;
import com.pg.student.gameLogic.utils.WorldConfig;

public class Antelope extends Animal {
    public Antelope(Position organismPosition, World world) {
        super(organismPosition, WorldConfig.ANTELOPE_INITIATIVE, WorldConfig.ANTELOPE_POWER, WorldConfig.ANTELOPE_NAME, world);
    }

    @Override
    protected boolean IsTheSameType(Animal otherAnimal) {
        return otherAnimal instanceof Antelope;
    }

    @Override
    protected void Multiply(Position newPosition) {
        world.GetOrganismsManager().AddOrganism(new Antelope(newPosition, world));
    }
}
