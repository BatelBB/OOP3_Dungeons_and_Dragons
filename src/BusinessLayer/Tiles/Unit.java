package BusinessLayer.Tiles;

import BusinessLayer.Position;
import BusinessLayer.Tile;

public abstract class Unit extends Tile {
    public String name;

    public Resource health;

    public int attackPoints;
    public int defensePoints;

    public Unit(Character c, String name, Resource health, int attackPoints, int defensePoints) {
        super(c);
        this.name = name;
        this.health = health;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
    }

    public String getName() {
        return name;
    }


}
