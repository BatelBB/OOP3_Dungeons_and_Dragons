package BusinessLayer.GameObjects.Game_Tiles;

public abstract class Tile implements Visitor, Visited {
    protected char tile;
    protected Position position;

    protected Tile(char tile) {
        this.tile = tile;
    }

    public void initialize(Position position) {
        this.position = position;
    }

    public char getTile() {
        return tile;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position newPosition) {
        position = newPosition;
    }

    @Override
    public String toString() {//Returns the tile character. Use it to print the board
        return String.valueOf(tile);
    }

    public abstract void accept(Unit unit);

//    @Override
//    public int compareTo(Tile tile) {
//        return getPosition().compareTo(tile.getPosition());
//    }

    public abstract void interact(Tile tile);
}
