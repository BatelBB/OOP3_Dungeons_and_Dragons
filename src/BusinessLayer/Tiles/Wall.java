package BusinessLayer.Tiles;

import BusinessLayer.Position;
import BusinessLayer.Tile;

public class Wall extends Tile{

    public Wall(Character c) {
        super(c);
    }

    @Override
    public String toString() {
        return "#";
    }


}
