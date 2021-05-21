package com.pg.student.gameLogic.organisms.plants;

import com.pg.student.gameLogic.World;
import com.pg.student.gameLogic.organisms.Organism;
import com.pg.student.gameLogic.organisms.animals.Animal;
import com.pg.student.gameLogic.utils.Position;
import com.pg.student.gameLogic.utils.WorldConfig;

import java.io.Serializable;

public class Guarana extends Plant implements Serializable {
    public Guarana(Position organismPosition, World world) {
        super(organismPosition, WorldConfig.PLANT_INITIATIVE, WorldConfig.GUARANA_POWER, WorldConfig.GUARANA_NAME, world);
    }

    @Override
    protected void Multiply(Position newPosition) {
        world.GetOrganismsManager().AddOrganism(new Guarana(newPosition, world));
    }

    @Override
    public void Collision(Organism otherOrganism) {
        if(otherOrganism instanceof Animal) {
            ((Animal)otherOrganism).IncrementPower(3);
            world.GetEventLoggingManager().ReportAboutGuaranaEffect(otherOrganism.GetName());
        }

        super.Collision(otherOrganism);
    }
}
