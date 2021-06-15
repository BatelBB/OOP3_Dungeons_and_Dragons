package BusinessLayer.Tiles.Player;

import BusinessLayer.Messenger;
import BusinessLayer.Tiles.Enemy.Enemy;
import BusinessLayer.Tiles.Resource;
import BusinessLayer.Tiles.WarriorAbility;

import java.security.SecureRandomSpi;
import java.util.List;
import java.util.Random;

public class Warrior extends Player {

    private WarriorAbility ability;
    private final int RANGE = 3;

    public Warrior(String name, int health, int attack, int defense, int coolDownPool) {
        super(name, health, attack, defense);
        ability = new WarriorAbility("Avenger's Shield", "CoolDown", coolDownPool);
    }

    public String description() {
        return getDescription();
    }

    public void onAbilityCast(List<Enemy> enemies) {
        if (!ability.isAvailable())
            messanger.sendMessage(String.format("%s tried to cast %s, but there is a %s: %d", name, ability.getName(), ability.getPoolName(), ability.getAmount()));
        else {
            ability.use();

            int newHealth = Math.min(health.getAmount() + 10 * defensePoints, health.getPool());
            messanger.sendMessage(String.format("%s used %s, healing for %d", name, ability.getName(), newHealth - health.getAmount()));
            health.addAmount(newHealth - health.getAmount());

            if (!enemies.isEmpty()) {
                int i = pickRandom(enemies.size());
                abilityAttack(enemies.get(i));
            }
        }
    }

    @Override
    protected int getAbilityDamage() {
        return (int) (health.getPool() * 0.1);
    }

    public int getRange() {
        return RANGE;
    }

    @Override
    public void abilityTick() {
        ability.onTick();
    }

    @Override
    public void accept(Player player) {

    }
}
