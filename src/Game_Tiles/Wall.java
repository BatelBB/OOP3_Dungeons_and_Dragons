package Game_Tiles;

public class Wall extends Tile{

    @Override
    public String toString() {
        return "#";
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
