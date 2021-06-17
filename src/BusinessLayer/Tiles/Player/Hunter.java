package BusinessLayer.Tiles.Player;

import BusinessLayer.Tiles.AbilityIMP;
import BusinessLayer.Tiles.Enemy.Enemy;
import BusinessLayer.Tiles.HunterAbility;
import BusinessLayer.Tiles.Resource;

import java.util.List;

public class Hunter extends Player {
    public Integer range;
    public HunterAbility ability;
    public Integer ticksCount;
    private final int ARROWSADDCOUNT = 10;
    private final int TICKSCOUNTFORREFILL = 10;
    private int tickCount;

    public Hunter(String name, int health, int attack, int defense, int range){
        super(name, health, attack, defense);
        this.range = range;
        ability = new HunterAbility("Shoot", "Arrows", ARROWSADDCOUNT*playerLevel);
    }
    @Override
    public String description() {
        String tab = "\t";
        return name + tab + health.toString() + tab + "Attack: " + attackPoints + tab +
                "Defence: " + defensePoints + tab + "Level: " + playerLevel + tab +
                "Experience: " + experience + "/" + LEVEL_UP_EXP*playerLevel + tab;
    }

    @Override
    public void onAbilityCast(List<Enemy> enemiesInRange) {
        String output="";
        if(!ability.isAvailable()){//no arrows left
            output=getName()+" tried to cast "+ability.getName()+", but there are no arrows left.\n";
            messanger.sendMessage(output);
        }else{ //there are arrows
            Enemy toAttackEnemy = null;
            for (Enemy enemy: enemiesInRange) {
                if (toAttackEnemy == null) //if there are no monsters around
                    toAttackEnemy = enemy;
                else { //if there is a monster around we need to check if there is a clsoer one
                    if (this.getPos().Range(enemy.getPos().getxPos(), enemy.getPos().getyPos())
                            < this.getPos().Range(toAttackEnemy.getPos().getxPos(), toAttackEnemy.getPos().getyPos()))
                        toAttackEnemy = enemy;
                }
            }
            if (toAttackEnemy != null) {
                output = getName() + " fired an arrow at " + toAttackEnemy.getName();
                messanger.sendMessage(output);
                this.abilityAttack(toAttackEnemy);
                ability.use();
            }else{
                output = getName()+" tried to shoot an arrow but there were no enemies in range.";
                messanger.sendMessage(output);
            }
        }
    }

    @Override
    protected int getAbilityDamage() {
        return this.attackPoints;
    }

    @Override
    public int getRange() {
        return range;
    }

    @Override
    public void abilityTick() {
        if(ability.isUsedThisTurn())
            ability.isUsed = false;
        else if(ability.getPool() >= TICKSCOUNTFORREFILL)
            ability.addAmount(10*playerLevel);
    }

    @Override
    public void accept(Enemy enemy) {

    }

    @Override
    public void accept(Player player) {

    }

    @Override
    public void levelUp(){
        super.levelUp();
        ability.addAmount(10*playerLevel);
        attackPoints += 2*playerLevel;
        defensePoints += playerLevel;
    }

    @Override
    public void onTick(){
        super.onTick();
        tickCount ++;
        if(tickCount == 10){
            ability.addAmount(playerLevel);
            tickCount = 0;
        }
        else
            tickCount += 1;
    }
}
