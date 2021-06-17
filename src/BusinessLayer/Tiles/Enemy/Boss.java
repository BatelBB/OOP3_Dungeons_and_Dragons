package BusinessLayer.Tiles.Enemy;

import BusinessLayer.Tiles.Player.Player;
import BusinessLayer.Tiles.Unit;

public class Boss extends Enemy{
    public Boss(char tile, String name,  int health, int attack, int defense, int experienceValue, int  visionRange) {
        super(tile, name, health, attack, defense, visionRange, experienceValue);
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
        return super.description();
    }
}
