package BusinessLayer.Tiles;

import BusinessLayer.Interfaces.Visitor;
import BusinessLayer.Tiles.Enemy.Enemy;
import BusinessLayer.Tiles.Player.Player;

public class Trap extends Enemy {

    private int visibilityTime;
    private int invisibilityTime;
    private int tickCount;




    public Trap(Character c, String name, int health, int attackPoints, int defensePoints, int visionRange, int experienceValue) {
        super(c, name, health, attackPoints, defensePoints, visionRange, experienceValue);
    }


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

    @Override
    public String description() {
        return null;
    }
}
