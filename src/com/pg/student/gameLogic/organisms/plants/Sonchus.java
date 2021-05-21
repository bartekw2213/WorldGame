package com.pg.student.gameLogic.organisms.plants;

import com.pg.student.gameLogic.World;
import com.pg.student.gameLogic.utils.Position;
import com.pg.student.gameLogic.utils.WorldConfig;

import java.io.Serializable;

public class Sonchus extends Plant implements Serializable {
    public Sonchus(Position organismPosition, World world) {
        super(organismPosition, WorldConfig.PLANT_INITIATIVE, WorldConfig.SONCHUS_POWER, WorldConfig.SONCHUS_NAME, world);
    }

    @Override
    protected void Multiply(Position newPosition) {
        world.GetOrganismsManager().AddOrganism(new Sonchus(newPosition, world));
    }
}
