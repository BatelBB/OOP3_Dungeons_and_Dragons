package BusinessLayer.Tiles.Player;

import BusinessLayer.Tiles.AbilityIMP;
import BusinessLayer.Tiles.Enemy.Enemy;
import BusinessLayer.Tiles.Resource;
import BusinessLayer.Tiles.RougueAbility;

import java.util.LinkedList;
import java.util.List;

public class Rogue extends Player {
    //public Integer cost;
    public RougueAbility ability; // Using energy as resource. Starting energy equals to the rogue’s maximum energy which is 100
    private final int ENERGY = 100;
    private final int RANGE = 2;

    public Rogue(String name, int health, int attack, int defense, int cost){
        super(name, health, attack, defense);
        //this.cost = cost;
        ability = new RougueAbility("Fan of Knives", "energy", ENERGY, cost);
    }

    @Override
    public void onAbilityCast(List<Enemy> enemiesInRange) {
        if(!ability.isAvailable())
            messanger.sendMessage(String.format("%s tried to cast %s, but there was not enough %s: %d/%d",
                    this.getName(), ability.getName(), ability.getPoolName(),ability.getAmount(), ability.getPool()));
        else{
            messanger.sendMessage(String.format("%s cast %s.", this.getName(), ability.getName()));
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
            ability.use();
        }
    }

    @Override
    protected int getAbilityDamage() {
        return this.attackPoints;
    }

    @Override
    public int getRange() {
        return RANGE;
    }

    @Override
    public void abilityTick() {
        ability.onTick();
    }

    @Override
    public void levelUp(){}

    @Override
    public String description() {
        return getDescription();
    }

    @Override
    public void accept(Player player) {

    }
}
