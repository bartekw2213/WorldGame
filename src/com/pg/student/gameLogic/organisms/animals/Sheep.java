package com.pg.student.gameLogic.organisms.animals;

import com.pg.student.gameLogic.World;
import com.pg.student.gameLogic.utils.Position;
import com.pg.student.gameLogic.utils.WorldConfig;

public class Sheep extends Animal {
    public Sheep(Position organismPosition, World world) {
        super(organismPosition, WorldConfig.SHEEP_INITIATIVE, WorldConfig.SHEEP_POWER, WorldConfig.SHEEP_NAME, world);
    }

    @Override
    protected boolean IsTheSameType(Animal otherAnimal) {
        return otherAnimal instanceof Sheep;
    }

    @Override
    protected void Multiply(Position newPosition) {
        world.GetOrganismsManager().AddOrganism(new Sheep(newPosition, world));
    }
}
