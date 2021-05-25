package Game_Tiles;

public abstract class Tile implements Visitor, Visited {
    public char tile;
    public int xPos;
    public int yPos;

    public String toString() {//Returns the tile character. Use it to print the board
        return null;
    }

    @Override
    public boolean visit(Wall wall) {
        return false;
    }

    @Override
    public boolean visit(Unit unit) {
        return false;
    }

    @Override
    public boolean visit(Empty empty) {
        return false;
    }

}
