package com.pg.student.gameLogic.organisms.plants;

import com.pg.student.gameLogic.World;
import com.pg.student.gameLogic.organisms.Organism;
import com.pg.student.gameLogic.organisms.animals.Animal;
import com.pg.student.gameLogic.utils.Position;
import com.pg.student.gameLogic.utils.WorldConfig;

import java.io.Serializable;
import java.util.ArrayList;

public class Borsch extends Plant implements Serializable {
    public Borsch(Position organismPosition, World world) {
        super(organismPosition, WorldConfig.PLANT_INITIATIVE, WorldConfig.BORSCH_POWER, WorldConfig.BORSCH_NAME, world);
    }

    @Override
    public void Action() {
        ArrayList<Organism> organismsAroundBorsch = world.GetPositionsManager().GetOrganismsAroundThisPosition(organismPosition);

        for(Organism organism : organismsAroundBorsch)
            if(organism instanceof Animal) {
                world.GetOrganismsManager().KillOrganism(organism);
                world.GetEventLoggingManager().ReportDeathAfterFightWith(organism.GetName(), this.GetName());
            }
    }

    @Override
    protected void Multiply(Position newPosition) {
        world.GetOrganismsManager().AddOrganism(new Borsch(newPosition, world));
    }

    @Override
    public void Collision(Organism otherOrganism) {
        world.GetOrganismsManager().KillOrganism(otherOrganism);
        world.GetEventLoggingManager().ReportDeathAfterFightWith(otherOrganism.GetName(), this.GetName());
    }
}
