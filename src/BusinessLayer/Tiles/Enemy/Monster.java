package BusinessLayer.Tiles.Enemy;

import BusinessLayer.Interfaces.Visitor;
import BusinessLayer.Tiles.Empty;
import BusinessLayer.Tiles.Player.Player;
import BusinessLayer.Tiles.Resource;
import BusinessLayer.Tiles.Unit;

public class Monster extends Enemy{


    public Monster(Character c, String name, int health, int attackPoints, int defensePoints, int experienceValue, int visionRnge) {
        super(c, name, health, attackPoints, defensePoints, visionRnge, experienceValue);

    }


    @Override
    public void accept(Unit unit) {
        unit.visit(this);
    }

    @Override
    public void visit(Enemy e) {

    }

    @Override
    public void visit(Player player) {
        super.battle(player);
        if(!player.alive()){
            swichPos(player);
            player.died();
        }
    }

    @Override
    public String description() {
        return getDescription();
    }

    @Override
    public void accept(Enemy enemy) {

    }

    @Override
    public void accept(Player player) {

    }
}
