package Game_Tiles;

public class Empty extends Tile {
    public Empty() {
        this.tile = '.';
    }

    @Override
    public String toString() {
        return String.valueOf(tile);
    }

    @Override
    public boolean accept(Visitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public boolean visit(Wall wall) {
        return true;
    }

    @Override
    public boolean visit(Unit unit) {
        return true;
    }

    @Override
    public boolean visit(Empty empty) {
        return true;
    }
}
