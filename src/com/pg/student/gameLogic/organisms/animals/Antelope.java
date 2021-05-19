package com.pg.student.gameLogic.organisms.animals;

import com.pg.student.gameLogic.World;
import com.pg.student.gameLogic.utils.Position;
import com.pg.student.gameLogic.utils.WorldConfig;

import java.util.Random;

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

    @Override
    protected void Move() {
        int randomXOffset = (((new Random()).nextInt(3)) - 1) * 2;
        int randomYOffset = (((new Random()).nextInt(3)) - 1) * 2;
        Position newPosition = new Position(organismPosition.GetX() + randomXOffset,
                organismPosition.GetY() + randomYOffset);

        if(world.GetPositionsManager().IsThisPositionWithinGameBounds(newPosition))
            super.Move(newPosition);
    }

    @Override
    protected void CollisionWithAnimal(Animal otherAnimal, boolean isAggressor) {
        int randomNum = (new Random()).nextInt(2);

        if(!isAggressor && randomNum == 1){
            Move();
            world.GetEventLoggingManager().ReportAboutAntelopeEscape(otherAnimal.GetName());
        }
        else
            super.CollisionWithAnimal(otherAnimal, isAggressor);
    }
}
