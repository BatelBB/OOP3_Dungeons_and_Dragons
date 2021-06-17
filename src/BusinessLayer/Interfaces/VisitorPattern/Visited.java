package BusinessLayer.Interfaces.VisitorPattern;

import BusinessLayer.Tiles.Enemy.Enemy;
import BusinessLayer.Tiles.Player.Player;

public interface Visited {
    void accept(Enemy enemy);
    void accept(Player player);
}
