package Game_Tiles;

public interface Visitor {
    void visit(Wall wall);
    void visit(Unit unit);
    void visit(Empty empty);
}
