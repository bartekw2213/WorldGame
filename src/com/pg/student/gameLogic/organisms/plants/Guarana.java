package com.pg.student.gameLogic.organisms.plants;

import com.pg.student.gameLogic.World;
import com.pg.student.gameLogic.utils.Position;
import com.pg.student.gameLogic.utils.WorldConfig;

public class Guarana extends Plant {
    public Guarana(Position organismPosition, World world) {
        super(organismPosition, WorldConfig.PLANT_INITIATIVE, WorldConfig.GUARANA_POWER, WorldConfig.GUARANA_NAME, world);
    }

    @Override
    protected void Multiply(Position newPosition) {
        world.GetOrganismsManager().AddOrganism(new Guarana(newPosition, world));
    }
}
