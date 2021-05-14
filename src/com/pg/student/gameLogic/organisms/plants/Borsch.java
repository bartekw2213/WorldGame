package com.pg.student.gameLogic.organisms.plants;

import com.pg.student.gameLogic.World;
import com.pg.student.gameLogic.utils.Position;
import com.pg.student.gameLogic.utils.WorldConfig;

public class Borsch extends Plant {
    public Borsch(Position organismPosition, World world) {
        super(organismPosition, WorldConfig.PLANT_INITIATIVE, WorldConfig.BORSCH_POWER, WorldConfig.BORSCH_NAME, WorldConfig.BORSCH_IMG_PATH, world);
    }

    @Override
    protected void Multiply(Position newPosition) {
        world.GetOrganismsManager().AddOrganism(new Borsch(newPosition, world));
    }
}
