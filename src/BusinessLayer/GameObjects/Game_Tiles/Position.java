package BusinessLayer.GameObjects.Game_Tiles;

import BusinessLayer.GameObjects.Enemies.Enemy;
import BusinessLayer.GameObjects.Player.Player;

public class Position {
    public int xPos;
    public int yPos;

    public Position (int x, int y){
        this.xPos = x;
        this.yPos = y;
    }
    public double range(Enemy enemy, Player player){
        return Math.sqrt(Math.pow((enemy.getPosition().xPos-player.getPosition().xPos),2)+Math.pow((enemy.getPosition().yPos-player.getPosition().yPos),2));
    }
    public Position translate(int dx, int dy){
        return new Position(this.xPos + dx, this.yPos + dy);
    }
    public boolean equals(Position p){
        return this.xPos == p.xPos && this.yPos == p.yPos;
    }
    public int compareTo(Position position) {
        return 0;
    }

    public int getYPos() {
        return yPos;
    }

    public int getxPos() {
        return xPos;
    }
}
