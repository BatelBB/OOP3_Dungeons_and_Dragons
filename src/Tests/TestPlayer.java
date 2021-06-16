package Tests;

import BusinessLayer.Tiles.Enemy.Enemy;
import BusinessLayer.Tiles.Player.Player;

import java.util.List;

public class TestPlayer extends Player {

    public TestPlayer(String name, int attack, int defence, int health) {
        super(name, attack, defence, health);
    }
    @Override
    public void accept(Player player) {

    }

    @Override
    public void onAbilityCast(List<Enemy> enemies) {

    }

    @Override
    protected int getAbilityDamage() {
        return 0;
    }

    @Override
    public int getRange() {
        return 0;
    }

    @Override
    public void abilityTick() {

    }

    @Override
    public String description() {
        return null;
    }
}
