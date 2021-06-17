package Tests;

import BusinessLayer.Position;
import BusinessLayer.Tiles.Empty;
import BusinessLayer.Tiles.Enemy.Monster;
import BusinessLayer.Tiles.Player.Hunter;
import BusinessLayer.Tiles.Player.Player;
import BusinessLayer.Tiles.Wall;
import org.junit.*;

public class VisitorTests {
    Player dragon;
    Player fluffy;
    Monster whiteWalker;
    Monster butterfly;
    Wall wall;
    Empty empty;

    @Before
    public void initTests() {
        dragon = new Hunter("Vhagar",1000,1000,1000, 10);
        fluffy = new TestPlayer("Fluffy", 0,0,1);
        dragon.setPos(new Position(1,1));
        fluffy.setPos(new Position(1,1));

        whiteWalker = new TestEnemy('W', "White Walker", 1000, 1000, 1000, 10, 10);
        butterfly = new TestEnemy('O', "Buttery", 0,0,1,10,10);
        whiteWalker.setPos(new Position(2,2));
        butterfly.setPos(new Position(3,3));

        wall = new Wall('#', new Position(4,4));
        empty = new Empty('.', new Position(5,5));
    }
}
