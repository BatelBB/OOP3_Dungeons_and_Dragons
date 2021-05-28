package BusinessLayer.GameObjects.Game_Tiles;

import BusinessLayer.GameObjects.Enemies.Enemy;
import BusinessLayer.GameObjects.Player.Player;

public class Position {
    public int xPos;
    public int yPos;

    public double range(Enemy enemy, Player player){
        return Math.sqrt(Math.pow((enemy.getPosition().xPos-player.getPosition().xPos),2)+Math.pow((enemy.getPosition().yPos-player.getPosition().yPos),2));
    }

    public int compareTo(Position position) {
        return 0;
    }
}
