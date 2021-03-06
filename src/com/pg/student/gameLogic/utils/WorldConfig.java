package com.pg.student.gameLogic.utils;

import java.io.Serializable;

public class WorldConfig implements Serializable {
    public enum USER_MOVES { UP, DOWN, LEFT, RIGHT, SUPER_POWER }
    public static final double INITIAL_ANIMALS_TO_PLANTS_RATIO = 1.5;
    public static final int ANIMALS_NUM = 6;
    public static final int PLANTS_NUM = 5;
    public static final int PERCENTAGE_CHANGE_TO_PLANT_MULTIPLY = 10;

    public static final int ANTELOPE_POWER = 4;
    public static final int ANTELOPE_INITIATIVE = 4;
    public static final int CYBER_SHEEP_POWER = 11;
    public static final int CYBER_SHEEP_INITIATIVE = 4;
    public static final int FOX_POWER = 3;
    public static final int FOX_INITIATIVE = 7;
    public static final int HUMAN_POWER = 5;
    public static final int HUMAN_INITIATIVE = 4;
    public static final int SHEEP_POWER = 4;
    public static final int SHEEP_INITIATIVE = 4;
    public static final int TURTLE_POWER = 2;
    public static final int TURTLE_INITIATIVE = 1;
    public static final int WOLF_POWER = 9;
    public static final int WOLF_INITIATIVE = 5;

    public static final int BERRY_POWER = 99;
    public static final int BORSCH_POWER = 10;
    public static final int GRASS_POWER = 0;
    public static final int GUARANA_POWER = 0;
    public static final int SONCHUS_POWER = 0;
    public static final int PLANT_INITIATIVE = 0;

    public static final String ANTELOPE_NAME = "Antelopa";
    public static final String CYBER_SHEEP_NAME = "Cyber Owca";
    public static final String FOX_NAME = "Lis";
    public static final String HUMAN_NAME = "Człowiek";
    public static final String SHEEP_NAME = "Owca";
    public static final String TURTLE_NAME = "Żółw";
    public static final String WOLF_NAME = "Wilk";
    public static final String BERRY_NAME = "Wilcze Jagody";
    public static final String BORSCH_NAME = "Barszcz Sosnowskiego";
    public static final String GRASS_NAME = "Trawa";
    public static final String GUARANA_NAME = "Guarana";
    public static final String SONCHUS_NAME = "Mlecz";

    public static final String ANTELOPE_IMG_PATH = "src/com/pg/student/images/organisms/antelope.png";
    public static final String CYBER_SHEEP_IMG_PATH = "src/com/pg/student/images/organisms/cyber-sheep.png";
    public static final String BERRY_IMG_PATH = "src/com/pg/student/images/organisms/berry.png";
    public static final String BORSCH_IMG_PATH = "src/com/pg/student/images/organisms/borsch.png";
    public static final String FOX_IMG_PATH = "src/com/pg/student/images/organisms/fox.png";
    public static final String GRASS_IMG_PATH = "src/com/pg/student/images/organisms/grass.png";
    public static final String GUARANA_IMG_PATH = "src/com/pg/student/images/organisms/guarana.png";
    public static final String HUMAN_IMG_PATH = "src/com/pg/student/images/organisms/human.png";
    public static final String SHEEP_IMG_PATH = "src/com/pg/student/images/organisms/sheep.png";
    public static final String SONCHUS_IMG_PATH = "src/com/pg/student/images/organisms/sonchus.png";
    public static final String TURTLE_IMG_PATH = "src/com/pg/student/images/organisms/turtle.png";
    public static final String WOLF_IMG_PATH = "src/com/pg/student/images/organisms/wolf.png";
}
