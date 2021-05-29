package BusinessLayer.Tiles.Enemy;

import BusinessLayer.Position;
import BusinessLayer.Tiles.Resource;

public class Trap extends Enemy{
    private boolean isVisible;
    private int visibilityTime;
    private int invisibilityTime;

    public Trap(Character c, String name, Resource health, int attackPoints, int defensePoints, int experienceValue, int visibilityTime, int invisibilityTime) {
        super(c, name, health, attackPoints, defensePoints, 1, experienceValue);
        this.visibilityTime = visibilityTime;
        this.invisibilityTime = invisibilityTime;
    }


    @Override
    public String toString() {
        if(isVisible)
            return "" + tile;
        return ".";
    }
}
