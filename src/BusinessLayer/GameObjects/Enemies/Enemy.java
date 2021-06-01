package BusinessLayer.GameObjects.Enemies;

import BusinessLayer.GameObjects.Game_Tiles.Position;
import BusinessLayer.GameObjects.Player.Player;
import BusinessLayer.GameObjects.Game_Tiles.Unit;
import BusinessLayer.Utils.Resource;
import BusinessLayer.callbacks.EnemyDeathCallback;

public abstract class Enemy extends Unit {
    protected int experienceValue;

    protected EnemyDeathCallback enemyDeathCallback;

    protected Enemy(char tile, String name, Resource resource, int attack, int defense, int experienceValue) {
        super(tile, name, resource.getAmount(), attack, defense);
        this.experienceValue = experienceValue;
    }

    public int getExperienceValue(){
        return experienceValue;
    }

    public void setDeathCallback(EnemyDeathCallback enemyDeathCallback){
        this.enemyDeathCallback = enemyDeathCallback;
    }

}
