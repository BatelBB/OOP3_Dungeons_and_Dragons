package BusinessLayer.GameObjects.Player;

import Game_Tiles.Empty;
import Game_Tiles.Unit;
import Game_Tiles.Visitor;
import Game_Tiles.Wall;

public class Hunter extends Player  {
    public Integer range;
    public Integer arrowsCount;
    public Integer ticksCount;

    public Hunter(String name, int health, int attack, int defense, int range){
        this.name = name;
        this.healthAmount = health;
        this.healthPool = health;
        this.attackPoints = attack;
        this.defensePoints = defense;
        this.range = range;
        arrowsCount = 10*playerLevel;
        ticksCount = 0;
    }
    public void onGameTick(){
        if(ticksCount == 10){
            arrowsCount = arrowsCount + playerLevel;
            ticksCount = 0;
        }else
            ticksCount +=1;
    }

    public void castAbility() {
       // The hunter cannot cast the ability if arrows count = 0 ∨ @ enemy s.t. range(enemy, player) ≤ range.
        if(arrowsCount == 0){
            //cannot cast
        }else{
            arrowsCount -= 1;
            //Deal damage equals to attack points to the closest enemy within range (The enemy will try to defend itself).
        }
    }

    public void levelUp(){
        levelUpBasic();
        arrowsCount = arrowsCount + 10*playerLevel;
        attackPoints = attackPoints + 2*playerLevel;
        defensePoints = defensePoints + playerLevel;
    }

    @Override
    public boolean accept(Visitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public boolean visit(Wall wall) {
        return wall.visit(this);
    }

    @Override
    public boolean visit(Unit unit) {
        return unit.visit(this);
    }

    @Override
    public boolean visit(Empty empty) {
        return empty.visit(this);
    }
}
