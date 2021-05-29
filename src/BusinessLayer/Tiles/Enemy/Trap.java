package BusinessLayer.Tiles.Enemy;

import BusinessLayer.Interfaces.Visitor;
import BusinessLayer.Position;
import BusinessLayer.Tiles.Player.Player;
import BusinessLayer.Tiles.Resource;
import BusinessLayer.Tiles.Unit;

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
//delete
    @Override
    public void accept(Visitor visitor) {

    }

    @Override
    public void accept(Unit unit) {

    }

    @Override
    public void visit(Enemy e) {

    }

    @Override
    public void visit(Player player) {

    }
}
