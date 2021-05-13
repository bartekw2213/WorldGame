package com.pg.student.gameLogic.organisms;

import com.pg.student.gameLogic.World;
import com.pg.student.gameLogic.utils.Position;

public abstract class Organism {
    protected Position organismPosition;
    protected final World world;
    protected final int initiative;
    protected int power;
    protected int age;
    protected final String name;

    public Organism(Position organismPosition, int initiative, int power, String name, World world) {
        this.organismPosition = organismPosition;
        this.world = world;
        this.initiative = initiative;
        this.power = power;
        this.age = 0;
        this.name = name;
    }

    public Position GetOrganismPosition() {
        return organismPosition;
    }

    public void IncrementAge() { this.age++; };

    public abstract void Action();

    public abstract void Collision(Organism otherOrganism);

    protected abstract void Multiply(Position newPosition);

    protected void FightAggressorVersusDefender(Organism aggressor, Organism defender) {
        if(aggressor.power < defender.power) {
            world.GetOrganismsManager().KillOrganism(aggressor);
            world.GetEventLoggingManager().ReportDeathAfterFightWith(aggressor, defender);
        } else {
            world.GetOrganismsManager().KillOrganism(defender);
            world.GetEventLoggingManager().ReportDeathAfterFightWith(defender, aggressor);
        }
    }

    protected void MultiplyIfFreePositionIsAround() {
        Position freePosition = world.GetPositionsManager().FindFreePositionAroundThisPosition(organismPosition);
        if(freePosition != null) {
            Multiply(freePosition);
            world.GetEventLoggingManager().ReportAboutNewOrganism(name);
        }
    }
}
