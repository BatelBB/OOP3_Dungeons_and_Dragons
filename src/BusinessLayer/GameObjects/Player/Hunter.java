package BusinessLayer.GameObjects.Player;

import Game_Tiles.Empty;
import Game_Tiles.Unit;
import Game_Tiles.Visitor;
import Game_Tiles.Wall;

public class Hunter extends Player implements HeroicUnit {
    public Integer range;
    public Integer arrowsCount;
    public Integer ticksCount = 0;

    public Hunter(String name, int health, int attack, int defense, int range){

    }

    @Override
    public void castAbility() {

    }

    @Override
    public void accept(Visitor visitor) {

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
}
