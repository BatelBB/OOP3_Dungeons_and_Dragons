package BusinessLayer;

import BusinessLayer.Interfaces.ObserverPattern.Observer;
import BusinessLayer.Interfaces.VisitorPattern.Visited;
import BusinessLayer.Interfaces.VisitorPattern.Visitor;
import BusinessLayer.Tiles.Unit;

public abstract class Tile implements Visited, Visitor, Observer {
    protected char tile;
    protected Position pos;

    public Tile(Character c){
        tile = c;
    }

    public void init(Position pos){
        this.pos = pos;
    }


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

    public abstract void onTick();

    public void notice(){
        this.onTick();
    }

}
