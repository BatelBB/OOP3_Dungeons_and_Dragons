package BusinessLayer.GameObjects.Enemies;

import BusinessLayer.GameObjects.Game_Tiles.Position;
import BusinessLayer.GameObjects.Player.Player;
import BusinessLayer.GameObjects.Game_Tiles.Unit;
import BusinessLayer.callbacks.EnemyDeathCallback;

public abstract class Enemy extends Unit {
    protected int experienceValue;
    protected Position position;

    protected EnemyDeathCallback enemyDeathCallback;

    protected Enemy(char tile, String name, int healthCapacity, int attack, int defense) {
        super(tile, name, healthCapacity, attack, defense);
    }

    public int getExperienceValue(){
        return experienceValue;
    }

    public void setDeathCallback(EnemyDeathCallback enemyDeathCallback){
        this.enemyDeathCallback = enemyDeathCallback;
    }

}
