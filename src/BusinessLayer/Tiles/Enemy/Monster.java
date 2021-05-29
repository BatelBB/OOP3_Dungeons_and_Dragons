package BusinessLayer.Tiles.Enemy;

import BusinessLayer.Tiles.Resource;

public class Monster extends Enemy{


    public Monster(Character c, String name, Resource health, int attackPoints, int defensePoints, int experienceValue, int visionRnge) {
        super(c, name, health, attackPoints, defensePoints, visionRnge, experienceValue);

    }
}
