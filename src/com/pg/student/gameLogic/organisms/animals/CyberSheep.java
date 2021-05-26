package com.pg.student.gameLogic.organisms.animals;

import com.pg.student.gameLogic.World;
import com.pg.student.gameLogic.utils.Position;
import com.pg.student.gameLogic.utils.WorldConfig;

import java.io.Serializable;

public class CyberSheep extends Animal implements Serializable {
    public CyberSheep(Position organismPosition, World world) {
        super(organismPosition, WorldConfig.CYBER_SHEEP_INITIATIVE, WorldConfig.CYBER_SHEEP_POWER,
                WorldConfig.CYBER_SHEEP_NAME, world);
    }

    @Override
    protected boolean IsTheSameType(Animal otherAnimal) {
        return otherAnimal instanceof CyberSheep;
    }

    @Override
    protected void Multiply(Position newPosition) {
        world.GetOrganismsManager().AddOrganism(new CyberSheep(newPosition, world));
    }

    @Override
    protected void Move() {
        Position borschPosition = world.GetPositionsManager().FindNearestBorschPosition(organismPosition);

        if(borschPosition != null) {
            int x = organismPosition.GetX();
            int y = organismPosition.GetY();

            if(x > borschPosition.GetX())
                super.Move(new Position(x - 1, y));
            else if(x < borschPosition.GetX())
                super.Move(new Position(x + 1, y));
            else if(y > borschPosition.GetY())
                super.Move(new Position(x, y - 1));
            else if(y < borschPosition.GetY())
                super.Move(new Position(x, y + 1));
        } else
            super.Move();
    }

}
