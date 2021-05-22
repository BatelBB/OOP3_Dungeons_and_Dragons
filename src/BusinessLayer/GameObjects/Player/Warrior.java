package BusinessLayer.GameObjects.Player;

import Game_Tiles.Empty;
import Game_Tiles.Unit;
import Game_Tiles.Visitor;
import Game_Tiles.Wall;

public class Warrior extends Player implements HeroicUnit {
    public Integer abilityCooldown;
    public Integer remainingCooldown = 0;

    public Warrior(String name, int health, int attack, int defense, int cooldown){

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
