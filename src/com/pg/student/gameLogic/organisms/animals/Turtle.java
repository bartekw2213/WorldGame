package com.pg.student.gameLogic.organisms.animals;

import com.pg.student.gameLogic.World;
import com.pg.student.gameLogic.utils.Position;
import com.pg.student.gameLogic.utils.WorldConfig;

public class Turtle extends Animal {
    public Turtle(Position organismPosition, World world) {
        super(organismPosition, WorldConfig.TURTLE_INITIATIVE, WorldConfig.TURTLE_POWER, WorldConfig.TURTLE_NAME, world);
    }

    @Override
    protected boolean IsTheSameType(Animal otherAnimal) {
        return otherAnimal instanceof Turtle;
    }

    @Override
    protected void Multiply(Position newPosition) {
        world.GetOrganismsManager().AddOrganism(new Turtle(newPosition, world));
    }
}
