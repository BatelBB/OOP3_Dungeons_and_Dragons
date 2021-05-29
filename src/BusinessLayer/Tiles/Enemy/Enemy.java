package BusinessLayer.Tiles.Enemy;

import BusinessLayer.Position;
import BusinessLayer.Tiles.Resource;
import BusinessLayer.Tiles.Unit;

public abstract class Enemy extends Unit {
    int experienceValue;
    int visionRange;

    public Enemy(Character c, String name, Resource health, int attackPoints, int defensePoints,int visionRange, int experienceValue) {
        super(c, name, health, attackPoints, defensePoints);
        this.visionRange = visionRange;
        this.experienceValue = experienceValue;
    }
}
