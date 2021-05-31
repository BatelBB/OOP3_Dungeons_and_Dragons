package BusinessLayer.GameObjects.Game_Tiles;

import BusinessLayer.GameObjects.Enemies.Enemy;
import BusinessLayer.GameObjects.Player.Player;

public class Empty extends Tile {

    public Empty(char c, Position position) {
        super(c);
        this.position = position;
    }

    @Override
    public String toString() {
        return ".";
    }

    @Override
    public void accept(Unit unit) {
        unit.visit(this);
    }



    @Override
    public void visit(Wall wall) {
    }



    @Override
    public void visit(Unit unit) {
    }

    @Override
    public void visit(Empty empty) {

    }

    @Override
    public void interact(Tile tile) {

    }

    @Override
    public void accept(Visitor visitor) {

    }
}
