package BusinessLayer.Tiles;

import BusinessLayer.Interfaces.Visitor;
import BusinessLayer.Position;
import BusinessLayer.Tile;
import BusinessLayer.Tiles.Enemy.Enemy;
import BusinessLayer.Tiles.Player.Player;

public class Wall extends Tile{

    public Wall(Character c) {
        super(c);
    }
    public Wall(Character c, Position p) {
        super(c);
        this.pos = p;
    }

    @Override
    public void accept(Unit unit) {
        unit.visit(this);
    }

    @Override
    public void interact(Tile tile) {

    }

    @Override
    public String toString() {
        return "#";
    }


    @Override
    public void accept(Visitor visitor) {

    }

    @Override
    public void visit(Enemy e) {

    }

    @Override
    public void visit(Player player) {

    }

    @Override
    public void visit(Wall w) {

    }

    @Override
    public void visit(Empty emp) {

    }
}
