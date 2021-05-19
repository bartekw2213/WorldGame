package com.pg.student.gameLogic.organisms.plants;

import com.pg.student.gameLogic.World;
import com.pg.student.gameLogic.organisms.Organism;
import com.pg.student.gameLogic.utils.Position;
import com.pg.student.gameLogic.utils.WorldConfig;

public class Berry extends Plant {
    public Berry(Position organismPosition, World world) {
        super(organismPosition, WorldConfig.PLANT_INITIATIVE, WorldConfig.BERRY_POWER, WorldConfig.BERRY_NAME, world);
    }

    @Override
    protected void Multiply(Position newPosition) {
        world.GetOrganismsManager().AddOrganism(new Berry(newPosition, world));
    }

    @Override
    public void Collision(Organism otherOrganism) {
        world.GetOrganismsManager().KillOrganism(otherOrganism);
        world.GetEventLoggingManager().ReportDeathAfterFightWith(otherOrganism.GetName(), this.GetName());
    }
}
