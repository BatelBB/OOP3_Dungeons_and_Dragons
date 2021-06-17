package BusinessLayer.Interfaces.VisitorPattern;

import BusinessLayer.Tiles.Empty;
import BusinessLayer.Tiles.Enemy.Enemy;
import BusinessLayer.Tiles.Player.Player;
import BusinessLayer.Tiles.Unit;
import BusinessLayer.Tiles.Wall;

public interface Visitor {
    void visit(Enemy e);
    void visit(Player player);
    void visit(Wall w);
    void visit(Empty emp);

}
