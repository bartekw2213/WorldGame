package com.pg.student.gameLogic.organisms.animals;

import com.pg.student.gameLogic.World;
import com.pg.student.gameLogic.organisms.Organism;
import com.pg.student.gameLogic.utils.Position;
import com.pg.student.gameLogic.utils.WorldConfig;

import java.util.ArrayList;

public class Human extends Animal {
    private WorldConfig.USER_MOVES userMove;
    private long roundsSinceSuperPowerUse;
    private boolean superPowerInUse;

    public Human(Position organismPosition, World world) {
        super(organismPosition, WorldConfig.HUMAN_INITIATIVE, WorldConfig.HUMAN_POWER, WorldConfig.HUMAN_NAME, world);
        this.roundsSinceSuperPowerUse = 10;
        this.superPowerInUse = false;
    }

    @Override
    protected boolean IsTheSameType(Animal otherAnimal) {
        return false;
    }

    @Override
    protected void Multiply(Position newPosition) { }

    @Override
    public void Action() {
        GetUserMove();
        PerformProperAction();
        UseSuperPowerIfPossible();
        CheckIfSuperPowerTerminated();
    }

    private void GetUserMove() {
        this.userMove = world.GetUserMove();
    }

    private void PerformProperAction() {
        if(UserUsedArrows())
            Move();
        else if(UserUsedSuperPower())
            ActivateSuperPower();
    }

    private boolean UserUsedArrows() {
        return userMove == WorldConfig.USER_MOVES.DOWN || userMove == WorldConfig.USER_MOVES.UP ||
                userMove == WorldConfig.USER_MOVES.LEFT || userMove == WorldConfig.USER_MOVES.RIGHT;
    }

    private boolean UserUsedSuperPower() {
        return userMove == WorldConfig.USER_MOVES.SUPER_POWER;
    }

    @Override
    protected void Move() {
        Position newPosition = GetNewPositionBasedOnUserMove();
        super.Move(newPosition);
    }

    private void ActivateSuperPower() {
        if(roundsSinceSuperPowerUse >= 5) {
            this.superPowerInUse = true;
            roundsSinceSuperPowerUse = 0;
            world.GetEventLoggingManager().ReportAboutSuperPowerUse();
        }
    }
    
    private void UseSuperPowerIfPossible() {
        if(this.superPowerInUse) {
            ArrayList<Organism> organismsAroundHuman = world.GetPositionsManager().GetOrganismsAroundThisPosition(organismPosition);

            for(Organism organism : organismsAroundHuman) {
                world.GetOrganismsManager().KillOrganism(organism);
                world.GetEventLoggingManager().ReportAboutSuperPowerVictim(organism.GetName());
            }
        }

        this.roundsSinceSuperPowerUse++;
    }
    
    private void CheckIfSuperPowerTerminated() {
        if(roundsSinceSuperPowerUse >= 5 && this.superPowerInUse) {
            this.superPowerInUse = false;
            world.GetEventLoggingManager().ReportAboutSuperPowerEnd();
        }
    }

    private Position GetNewPositionBasedOnUserMove() {
        Position newPosition = null;
        switch(userMove) {
            case UP: newPosition = new Position(organismPosition.GetX(), organismPosition.GetY() - 1); break;
            case DOWN: newPosition = new Position(organismPosition.GetX(), organismPosition.GetY() + 1); break;
            case LEFT: newPosition = new Position(organismPosition.GetX() - 1, organismPosition.GetY()); break;
            case RIGHT: newPosition = new Position(organismPosition.GetX() + 1, organismPosition.GetY()); break;
        }
        return newPosition;
    }
}
