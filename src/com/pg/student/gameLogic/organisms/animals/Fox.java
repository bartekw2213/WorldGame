package com.pg.student.gameLogic.organisms.animals;

import com.pg.student.gameLogic.World;
import com.pg.student.gameLogic.utils.Position;
import com.pg.student.gameLogic.utils.WorldConfig;

public class Fox extends Animal {
    public Fox(Position organismPosition, World world) {
        super(organismPosition, WorldConfig.FOX_INITIATIVE, WorldConfig.FOX_POWER, WorldConfig.FOX_NAME,
                WorldConfig.FOX_IMG_PATH, world);
    }

    @Override
    protected boolean IsTheSameType(Animal otherAnimal) {
        return otherAnimal instanceof Fox;
    }

    @Override
    protected void Multiply(Position newPosition) {
        world.GetOrganismsManager().AddOrganism(new Fox(newPosition, world));
    }
}
