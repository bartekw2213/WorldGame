package com.pg.student.gameLogic.organisms.animals;

import com.pg.student.gameLogic.World;
import com.pg.student.gameLogic.organisms.Organism;
import com.pg.student.gameLogic.utils.Position;
import com.pg.student.gameLogic.utils.WorldConfig;

import java.io.Serializable;
import java.util.Random;

public class Turtle extends Animal implements Serializable {
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

    @Override
    protected void Move() {
        int randomNum = (new Random()).nextInt(4);
        if(randomNum == 3)
            super.Move();
    }

    @Override
    protected void CollisionWithAnimal(Animal otherAnimal, boolean isAggressor) {
        if(!isAggressor && otherAnimal.GetPower() < 5) {
            otherAnimal.MoveBack();
            world.GetEventLoggingManager().ReportAboutTurtleDefence(otherAnimal.GetName());
        } else
            super.CollisionWithAnimal(otherAnimal, isAggressor);
    }
}
