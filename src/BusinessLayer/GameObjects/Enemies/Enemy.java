package BusinessLayer.GameObjects.Enemies;

import BusinessLayer.GameObjects.Player.Player;
import Game_Tiles.Unit;

public abstract class Enemy extends Unit {
    Integer experienceValue;

    public double range(Enemy enemy, Player player){
        return Math.sqrt(Math.pow((enemy.xPos-player.xPos),2)+Math.pow((enemy.yPos-player.yPos),2));
    }
}
