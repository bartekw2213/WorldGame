package com.pg.student.gameLogic.utils;

import java.io.Serializable;

public class Position implements Serializable {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int GetX() {
        return x;
    }

    public void SetX(int x) {
        this.x = x;
    }

    public int GetY() {
        return y;
    }

    public void SetY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Position) {
            Position comparedPosition = (Position)obj;
            return this.x == comparedPosition.GetX() && this.y == comparedPosition.GetY();
        }
        return false;
    }
}
