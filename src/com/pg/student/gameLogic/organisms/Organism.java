package com.pg.student.gameLogic.organisms;

import com.pg.student.gameLogic.utils.Position;

public abstract class Organism {
    protected Position organismPosition;

    public Organism(Position organismPosition) {
        this.organismPosition = organismPosition;
    }

    public Position GetOrganismPosition() {
        return organismPosition;
    }

    protected abstract void Action();
}
