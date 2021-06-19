package BusinessLayer.Tiles.Enemy;

import BusinessLayer.Tiles.Player.Player;
import BusinessLayer.Tiles.Unit;

public class Trap extends Enemy{
    private boolean isVisible;
    private int visibilityTime;
    private int invisibilityTime;
    private int tickCount;
    private final int INIT_TICKS = 0;


    public Trap(Character c, String name, int health, int attackPoints, int defensePoints,
                int experienceValue, int visibilityTime, int invisibilityTime) {
        super(c, name, health, attackPoints, defensePoints, 1, experienceValue);
        this.visibilityTime = visibilityTime;
        this.invisibilityTime = invisibilityTime;
        isVisible = true;
        tickCount = INIT_TICKS;
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
        String tab = "\t\t";
        return name + tab + health.toString() + tab + "Attack: " + attackPoints + tab +
                "Defense: " + defensePoints + tab +
                "Experience Value: " + this.getExperienceValue();
    }


    @Override
    public void onTick() {
        tickCount++;
        if(tickCount>visibilityTime && isVisible){
            isVisible = false;
            tickCount = 0;
        }else if(!isVisible && tickCount > invisibilityTime){
            isVisible = true;
            tickCount = 0;
        }
    }
}
