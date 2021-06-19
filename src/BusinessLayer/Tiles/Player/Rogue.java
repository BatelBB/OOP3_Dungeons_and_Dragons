package BusinessLayer.Tiles.Player;

import BusinessLayer.Tiles.Enemy.Enemy;
import BusinessLayer.Tiles.Player.Ability.RougueAbility;

import java.util.LinkedList;
import java.util.List;

public class Rogue extends Player {
    public RougueAbility ability; // Using energy as resource. Starting energy equals to the rogue’s maximum energy which is 100
    private final int ENERGY = 100;
    private final int RANGE = 2;

    public Rogue(String name, int health, int attack, int defense, int cost){
        super(name, health, attack, defense);
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
        if(ability.isUsedThisTurn())
            ability.isUsed = false;
        else
            ability.onTick();
    }

    @Override
    public void levelUp(){
        super.levelUp();
        messanger.sendMessage(String.format("%s reached level %d: +%d Health, +%d Attack, +%d Defense",
                this.name, this.getPlayerLevel(), 10*playerLevel,
                4*playerLevel, 2*playerLevel));
        ability.reset();
        attackPoints += 3*playerLevel;
    }

    @Override
    public String description() {
        return super.description() + "\tEnergy: " + ability.toString();
    }

    @Override
    public int getAbilityAmount() {
        return ability.getAmount();
    }

    @Override
    public void accept(Player player) {

    }
}
