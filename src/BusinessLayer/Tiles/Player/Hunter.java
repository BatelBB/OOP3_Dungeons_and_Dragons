package BusinessLayer.Tiles.Player;

import BusinessLayer.Tiles.AbilityIMP;
import BusinessLayer.Tiles.Enemy.Enemy;
import BusinessLayer.Tiles.Resource;

import java.util.List;

public class Hunter extends Player {
    public Integer range;
    public AbilityIMP arrowsCount;
    public Integer ticksCount;
    private final int ARROWSADDCOUNT = 10;
    private final int TICKSCOUNT = 0;

    public Hunter(char ch, String name, Resource health, int attack, int defense, int range){
        super(ch, name, health, attack, defense);
        this.range = range;
        arrowsCount = new AbilityIMP("Shoot", "Arrows", ARROWSADDCOUNT*playerLevel);
        arrowsCount.addToPool(ARROWSADDCOUNT*playerLevel);
        ticksCount = TICKSCOUNT;
    }
    @Override
    public String description() {
        return null;
    }

    @Override
    public void onAbilityCast(List<Enemy> enemiesInRange) {
        String output="";
        if(!arrowsCount.isAvailable()){//no arrows left
            output=getName()+" tried to cast "+arrowsCount.getName()+", but there are no arrows left.\n";
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
                arrowsCount.addAmount(-1);
            }
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
}
