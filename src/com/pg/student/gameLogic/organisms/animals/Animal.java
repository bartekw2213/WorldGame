package com.pg.student.gameLogic.organisms.animals;

import com.pg.student.gameLogic.World;
import com.pg.student.gameLogic.organisms.Organism;
import com.pg.student.gameLogic.organisms.plants.Plant;
import com.pg.student.gameLogic.utils.Position;

import java.io.Serializable;

public abstract class Animal extends Organism implements Serializable {
    protected Position lastPosition;

    public Animal(Position organismPosition, int initiative, int power, String name, World world) {
        super(organismPosition, initiative, power, name, world);
        this.lastPosition = organismPosition;
    }

    protected abstract boolean IsTheSameType(Animal otherAnimal);

    @Override
    public void Action() {
        Move();
    }

    @Override
    public void Collision(Organism otherOrganism) {
        Collision(otherOrganism, true);
    }

    public void IncrementPower(int increment) {
        this.power += increment;
    }

    protected void Collision(Organism otherOrganism, boolean isAggressor) {
        if(otherOrganism instanceof Plant)
            otherOrganism.Collision(this);
        else if(otherOrganism instanceof Animal)
            CollisionWithAnimal((Animal) otherOrganism, isAggressor);
    }

    protected void Move() {
        Position newPosition = world.GetPositionsManager().FindRandomPositionAroundThisPosition(organismPosition);
        Move(newPosition);
    }

    protected void Move(Position newPosition) {
        Organism organismOnNewPosition = world.GetPositionsManager().FindOrganismOnThisPosition(newPosition);

        if(newPosition != null && world.GetPositionsManager().IsThisPositionWithinGameBounds(newPosition)) {
            lastPosition = organismPosition;
            organismPosition = newPosition;

            if(organismOnNewPosition != null)
                this.Collision(organismOnNewPosition);
        }
    }

    @Override
    public void MoveBack() {
        organismPosition = lastPosition;
    }

    protected void CollisionWithAnimal(Animal otherAnimal, boolean isAggressor) {
        if(IsTheSameType(otherAnimal))
            MultiplyIfFreePositionIsAround();
        else if(isAggressor && otherAnimal instanceof Turtle)
            otherAnimal.Collision(this, false);
        else if(isAggressor && otherAnimal instanceof Antelope)
            otherAnimal.Collision(this, false);
        else if(isAggressor)
            FightAggressorVersusDefender(this, otherAnimal);
        else
            FightAggressorVersusDefender(otherAnimal, this);
    }
}
