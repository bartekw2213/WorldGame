package com.pg.student.gameLogic.organisms.animals;

import com.pg.student.gameLogic.World;
import com.pg.student.gameLogic.organisms.Organism;
import com.pg.student.gameLogic.organisms.plants.Plant;
import com.pg.student.gameLogic.utils.Position;

public abstract class Animal extends Organism {
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
        if(otherOrganism instanceof Plant)
            otherOrganism.Collision(this);
        else if(otherOrganism instanceof Animal)
            CollisionWithAnimal((Animal) otherOrganism);
    }

    private void Move() {
        Position newPosition = world.GetPositionsManager().FindRandomPositionAroundThisPosition(organismPosition);
        Organism organismOnNewPosition = world.GetPositionsManager().FindOrganismOnThisPosition(newPosition);

        if(newPosition != null) {
            lastPosition = organismPosition;
            organismPosition = newPosition;
        }

        if(organismOnNewPosition != null)
            this.Collision(organismOnNewPosition);
    }

    private void CollisionWithAnimal(Animal otherAnimal) {
        if(IsTheSameType(otherAnimal))
            MultiplyIfFreePositionIsAround();
        else
            FightAggressorVersusDefender(this, otherAnimal);
    }
}
