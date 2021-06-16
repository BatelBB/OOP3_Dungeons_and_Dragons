package Tests;

import BusinessLayer.Tiles.Enemy.Enemy;
import BusinessLayer.Tiles.Enemy.Monster;
import BusinessLayer.Tiles.Player.Player;
import BusinessLayer.Tiles.Unit;

public class TestEnemy extends Monster {

    public TestEnemy(char character, String name, int attack, int defence, int health, int vision, int expValue) {
        super(character, name, attack, defence,  health, vision, expValue);
    }
    @Override
    public void accept(Enemy enemy) {

    }

    @Override
    public void accept(Player player) {

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
