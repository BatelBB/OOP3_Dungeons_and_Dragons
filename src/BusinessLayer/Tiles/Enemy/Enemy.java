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

    public Enemy(Character c, String name, Resource health, int attackPoints, int defensePoints,int visionRange, int experienceValue) {
        super(c, name, health, attackPoints, defensePoints);
        this.visionRange = visionRange;
        this.experienceValue = experienceValue;
    }

    public int getExperienceValue() {
        return experienceValue;
    }

    public void setEnemyDeathCallback(EnemyDeathCallback enemyDeathCallback) {
        this.enemyDeathCallback = enemyDeathCallback;
    }

    public void onDeath(){
        enemyDeathCallback.call();
    }
}
