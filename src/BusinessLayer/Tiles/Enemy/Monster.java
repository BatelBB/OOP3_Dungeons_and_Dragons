package BusinessLayer.Tiles.Enemy;

import BusinessLayer.Interfaces.Visitor;
import BusinessLayer.Tiles.Player.Player;
import BusinessLayer.Tiles.Resource;
import BusinessLayer.Tiles.Unit;

public class Monster extends Enemy{


    public Monster(Character c, String name, Resource health, int attackPoints, int defensePoints, int experienceValue, int visionRnge) {
        super(c, name, health, attackPoints, defensePoints, visionRnge, experienceValue);

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
        super.battle(player);
        if(!player.alive()){
            swichPos(player);
        }
    }
}
