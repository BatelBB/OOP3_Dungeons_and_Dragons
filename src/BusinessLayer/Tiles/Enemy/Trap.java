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
    private int tickCount;


    public Trap(Character c, String name, int health, int attackPoints, int defensePoints, int experienceValue, int visibilityTime, int invisibilityTime) {
        super(c, name, health, attackPoints, defensePoints, 1, experienceValue);
        this.visibilityTime = visibilityTime;
        this.invisibilityTime = invisibilityTime;
        isVisible = true;
    }

    @Override
    public void accept(Enemy enemy) {

    }

    @Override
    public void accept(Player player) {
        player.battle(this);
    }


    @Override
    public void accept(Unit unit) {
        unit.visit(this);
    }

    @Override
    public String toString() {
        if(isVisible)
            return "" + tile;
        return ".";
    }

    @Override
    public void visit(Enemy e) {

    }

    @Override
    public void visit(Player player) {

    }

    @Override
    public String description() {
        return getDescription();
    }

    @Override
    public void onTick() {
        isVisible = tickCount < visibilityTime;
        if(tickCount == visibilityTime + invisibilityTime)
            tickCount = 0;
        else
            tickCount++;
    }
}
