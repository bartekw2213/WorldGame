package com.pg.student.gameLogic.organisms.animals;

import com.pg.student.gameLogic.organisms.Organism;
import com.pg.student.gameLogic.utils.Position;

public abstract class Animal extends Organism {
    protected Position lastPosition;

    public Animal(Position organismPosition) {
        super(organismPosition);
    }

    @Override
    protected void Action() {

    }
}
