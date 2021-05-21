package com.pg.student.gameLogic.organisms.animals;

import com.pg.student.gameLogic.World;
import com.pg.student.gameLogic.utils.Position;
import com.pg.student.gameLogic.utils.WorldConfig;

import java.io.Serializable;

public class Fox extends Animal implements Serializable {
    public Fox(Position organismPosition, World world) {
        super(organismPosition, WorldConfig.FOX_INITIATIVE, WorldConfig.FOX_POWER, WorldConfig.FOX_NAME, world);
    }

    @Override
    protected boolean IsTheSameType(Animal otherAnimal) {
        return otherAnimal instanceof Fox;
    }

    @Override
    protected void Multiply(Position newPosition) {
        world.GetOrganismsManager().AddOrganism(new Fox(newPosition, world));
    }

    @Override
    protected void Move() {
        Position newPosition = world.GetPositionsManager().FindFreePositionAroundThisPosition(organismPosition);
        if(newPosition != null)
            super.Move(newPosition);
    }
}
