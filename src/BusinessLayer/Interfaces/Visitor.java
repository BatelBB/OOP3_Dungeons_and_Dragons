package BusinessLayer.Interfaces;

import BusinessLayer.Tiles.Empty;
import BusinessLayer.Tiles.Enemy.Enemy;
import BusinessLayer.Tiles.Player.Player;
import BusinessLayer.Tiles.Unit;
import BusinessLayer.Tiles.Wall;

public interface Visitor {
    public void visit(Enemy e);
    public void visit(Player player);
    public void visit(Wall w);
    public void visit(Empty emp);

}
