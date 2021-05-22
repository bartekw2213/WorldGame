package com.pg.student.gameLogic.organisms.animals;

import com.pg.student.gameLogic.World;
import com.pg.student.gameLogic.organisms.Organism;
import com.pg.student.gameLogic.utils.Position;
import com.pg.student.gameLogic.utils.PositionsManager;
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
        Position newPosition = null;
        PositionsManager.PositionsAroundOnePoint positionsAround = new PositionsManager.PositionsAroundOnePoint(organismPosition);

        while(positionsAround.IsAnyPositionLeft()) {
            Position checkedPosition = positionsAround.GetRandomPosition();
            Organism possibleEnemy = world.GetPositionsManager().FindOrganismOnThisPosition(checkedPosition);

            if(possibleEnemy == null || possibleEnemy.GetPower() < power) {
                newPosition = checkedPosition;
                break;
            }
        }

        if(newPosition != null)
            super.Move(newPosition);
    }
}
