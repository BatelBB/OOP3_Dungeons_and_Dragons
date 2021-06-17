package BusinessLayer.Tiles.Enemy;

import BusinessLayer.Interfaces.EnemyDeathCallback;
import BusinessLayer.Position;
import BusinessLayer.Tile;
import BusinessLayer.Tiles.Empty;
import BusinessLayer.Tiles.Resource;
import BusinessLayer.Tiles.Unit;

public abstract class Enemy extends Unit {
    private int experienceValue;
    private int visionRange;

    protected EnemyDeathCallback enemyDeathCallback;

    public Enemy(Character c, String name, int health, int attackPoints, int defensePoints,int visionRange, int experienceValue) {
        super(c, name, health, attackPoints, defensePoints);
        this.visionRange = visionRange;
        this.experienceValue = experienceValue;
    }

    public int getExperienceValue() {
        return experienceValue;
    }
    public int getVisionRange(){return visionRange;}

    public void setEnemyDeathCallback(EnemyDeathCallback enemyDeathCallback) {
        this.enemyDeathCallback = enemyDeathCallback;
    }

    public void onDeath(){
        enemyDeathCallback.call();

    }

    public void onTick(){

    }
    @Override
    public String description() {
        String tab = "\t";
        return name + tab + health.toString() + tab + "Attack: " + attackPoints + tab +
                "Defense: " + defensePoints + tab +
                "Experience Value: " + this.getExperienceValue() + tab + "Vision Range:" + this.getVisionRange();
    }
    public abstract boolean checkHeroic();

}
