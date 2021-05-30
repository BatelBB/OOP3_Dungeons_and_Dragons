package BusinessLayer.GameObjects.Game_Tiles;

import BusinessLayer.GameObjects.Enemies.Enemy;
import BusinessLayer.GameObjects.Player.Player;

public abstract class Tile implements Visitor, Visited, Comparable<Tile> {
    protected char tile;
    protected Position position;

    protected Tile(char tile){
        this.tile = tile;
    }

    public char getTile(){
        return tile;
    }

    public Position getPosition(){
        return position;
    }
    public void setPosition(int x, int y){
        this.position.xPos = x;
        this.position.yPos = y;
    }

    public void init(Position pos){
        this.position = pos;
    }
    public int getYPos(){
        return this.position.yPos;
    }
    @Override
    public String toString() {//Returns the tile character. Use it to print the board
        return String.valueOf(tile);
    }

    public abstract void accept(Unit unit);

    @Override
    public int compareTo(Tile tile) {
        return getPosition().compareTo(tile.getPosition());
    }

    @Override
    public void visit(Wall wall) {
    }

    public abstract void visit(Player player);
    public abstract void visit(Enemy enemy);
    @Override
    public void visit(Unit unit) {
    }

    @Override
    public void visit(Empty empty) {

    }

    public abstract void interact(Tile tile);
}
