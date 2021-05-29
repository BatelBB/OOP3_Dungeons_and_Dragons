package BusinessLayer.Tiles;

import BusinessLayer.Position;
import BusinessLayer.Tile;

public class Empty extends Tile {

    public Empty(Character c) {
        super(c);
    }

    @Override
    public String toString() {
        return "#";
    }
}
