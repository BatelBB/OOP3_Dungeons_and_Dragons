package BusinessLayer;

import BusinessLayer.Interfaces.EnemyDeathCallback;
import BusinessLayer.Interfaces.Visited;
import BusinessLayer.Interfaces.Visitor;
import BusinessLayer.Tiles.Empty;
import BusinessLayer.Tiles.Unit;

public abstract class Tile implements Visited, Visitor {
    protected char tile;
    protected Position pos;

    public Tile(Character c){
        tile = c;
    }

    public void init(Position pos){
        this.pos = pos;
    }
    public int getChar() {
        return tile;
    }

    /*public String description(){
        return "Hi im " + tile;
    }*/

    public abstract void accept(Unit unit);

    public Position getPos(){return pos;}

    public void setPos(Position newPos){
        pos = newPos;
    }

    public abstract void interact(Tile tile);

    public String toString(){
        return String.valueOf(tile);
    }

    public char getTile(){
        return tile;
    }

    public void setTile(char c){
        this.tile = c;
    }

}
