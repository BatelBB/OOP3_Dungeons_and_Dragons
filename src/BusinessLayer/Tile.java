package BusinessLayer;

import BusinessLayer.Interfaces.Visited;
import BusinessLayer.Interfaces.Visitor;

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

    public String description(){
        return "Hi im " + tile;
    }

    @Override
    public void accept(Visitor visitor) {

    }

}
