package com.pg.student.gameLogic.organisms.plants;

import com.pg.student.gameLogic.World;
import com.pg.student.gameLogic.utils.Position;
import com.pg.student.gameLogic.utils.WorldConfig;

import java.io.Serializable;

public class Grass extends Plant  implements Serializable {
    public Grass(Position organismPosition, World world) {
        super(organismPosition, WorldConfig.PLANT_INITIATIVE, WorldConfig.GRASS_POWER, WorldConfig.GRASS_NAME, world);
    }

    @Override
    public void Action() {
        for(int i = 0; i < 3; i++)
            super.Action();
    }

    @Override
    protected void Multiply(Position newPosition) {
        world.GetOrganismsManager().AddOrganism(new Grass(newPosition, world));
    }
}
