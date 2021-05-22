package BusinessLayer.GameObjects.Player;

import Game_Tiles.Empty;
import Game_Tiles.Unit;
import Game_Tiles.Visitor;
import Game_Tiles.Wall;

public class Mage extends Player implements HeroicUnit{
    public Integer manaPool;
    public Integer currentMana;
    public Integer manaCost;
    public Integer spellPower;
    public Integer hitCount;
    public Integer abilityRange;

    public Mage(String name, int health, int attack, int defense, int manaPool, int manaCost, int spellPower, int hitCount, int range){

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
