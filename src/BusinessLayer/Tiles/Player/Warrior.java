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

    public Warrior(char c, String name, Resource health, int attack, int defense, int coolDownPool){
        super(c, name, health, attack, defense);
        ability = new WarriorAbility("Avenger's Shield", "CoolDown", 0);
    }

    public String description(){
        String tab = "\t";
        return name + tab + health.toString() + tab + "Attack: " + attackPoints + tab +
                "Defence: " + defensePoints + tab + "Level: " + playerLevel + tab +
                "Experience: " + experience + "/" + LEVEL_UP_EXP*playerLevel + tab;
    }

    public void onAbilityCast(List<Enemy> enemies){
        if(!ability.isAvailable())
            messanger.sendMessage(String.format("%s tried to cast %s, but there is a %s: %d", name, ability.getName(), ability.getPoolName(), ability.getAmount()));

        int newHealth = Math.min(health.getAmount() + 10*defensePoints, health.getPool());
        messanger.sendMessage(String.format("%s used %s, healing for %d", name, ability.getName(), newHealth-health.getAmount()));
        health.addAmount(newHealth-health.getAmount());

        int i = pickRandom(enemies.size());
        abilityAttack(enemies.get(i));
    }

}
