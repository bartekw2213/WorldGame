package com.pg.student.gameLogic.organisms.animals;

import com.pg.student.gameLogic.World;
import com.pg.student.gameLogic.organisms.Organism;
import com.pg.student.gameLogic.utils.Position;
import com.pg.student.gameLogic.utils.WorldConfig;

public class Human extends Animal {
    private WorldConfig.USER_MOVES userMove;

    public Human(Position organismPosition, World world) {
        super(organismPosition, WorldConfig.HUMAN_INITIATIVE, WorldConfig.HUMAN_POWER, WorldConfig.HUMAN_NAME, WorldConfig.HUMAN_IMG_PATH, world);
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
    }

    private void GetUserMove() {
        this.userMove = world.GetUserMove();
    }

    private void PerformProperAction() {
        if(UserUsedArrows())
            Move();
        else if(UserUsedSuperPower())
            UseSuperPower();
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

    private void UseSuperPower() {

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
