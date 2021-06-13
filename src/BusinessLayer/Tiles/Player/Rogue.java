package BusinessLayer.Tiles.Player;

import BusinessLayer.Tiles.AbilityIMP;
import BusinessLayer.Tiles.Enemy.Enemy;
import BusinessLayer.Tiles.Resource;

import java.util.LinkedList;
import java.util.List;

public class Rogue extends Player {
    public Integer cost;
    public AbilityIMP currentEnergy; // Using energy as resource. Starting energy equals to the rogue’s maximum energy which is 100
    private final int ENERGY = 100;

    public Rogue(char ch, String name, Resource health, int attack, int defense, int cost){
        super(ch, name, health, attack, defense);
        this.cost = cost;
        currentEnergy = new AbilityIMP("Fan of Knives", "energy", ENERGY);
    }

    @Override
    public void onAbilityCast(List<Enemy> enemiesInRange) {
        if(!currentEnergy.isAvailable())
            messanger.sendMessage(String.format("%s tried to cast %s, but there was not enough %s: %d/%d",
                    this.getName(), currentEnergy.getName(), currentEnergy.getPoolName(),currentEnergy.getAmount(), currentEnergy.getPool()));
        else{
            messanger.sendMessage(String.format("%s cast %s.", this.getName(), currentEnergy.getName()));
            List<Enemy> closerEnemy = new LinkedList<>();
            for (Enemy enemy: enemiesInRange) {
                if(this.getPos().Range(enemy.getPos().getxPos(),enemy.getPos().getyPos())<2)
                    closerEnemy.add(enemy);
            }
            if (!closerEnemy.isEmpty()) {
                for (Enemy enemy: closerEnemy) {
                    this.abilityAttack(enemy);

                }
            }
            int amount = currentEnergy.getAmount();
            currentEnergy.addAmount(amount - cost);

        }
    }

    @Override
    protected int getAbilityDamage() {
        return this.attackPoints;
    }

    @Override
    public int getRange() {
        return 0;
    }

    @Override
    public String description() {
        String tab = "\t";
        return name + tab + health.toString() + tab + "Attack: " + attackPoints + tab +
                "Defence: " + defensePoints + tab + "Level: " + playerLevel + tab +
                "Experience: " + experience + "/" + LEVEL_UP_EXP*playerLevel + tab + "Energy: " + currentEnergy.toString();
    }
}
