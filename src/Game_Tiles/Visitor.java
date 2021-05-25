package Game_Tiles;

public interface Visitor {
    boolean visit(Wall wall);
    boolean visit(Unit unit);
    boolean visit(Empty empty);
}
