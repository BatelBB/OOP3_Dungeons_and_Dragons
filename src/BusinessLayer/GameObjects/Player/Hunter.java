package BusinessLayer.GameObjects.Player;

import BusinessLayer.GameObjects.Enemies.Enemy;
import BusinessLayer.GameObjects.Game_Tiles.Empty;
import BusinessLayer.GameObjects.Game_Tiles.Unit;
import BusinessLayer.GameObjects.Game_Tiles.Visitor;
import BusinessLayer.GameObjects.Game_Tiles.Wall;

public class Hunter extends Player  {
    public Integer range;
    public Integer arrowsCount;
    public Integer ticksCount;

    public Hunter(String name, int health, int attack, int defense, int range){
        super(name, health, attack, defense);
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

//    public void levelUp(){
//        levelUpBasic();
//        arrowsCount = arrowsCount + 10*playerLevel;
//        attackPoints = attackPoints + 2*playerLevel;
//        defensePoints = defensePoints + playerLevel;
//    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void visit(Wall wall) {
    }

    @Override
    public void visit(Player player) {

    }

    @Override
    public void visit(Enemy enemy) {

    }

    @Override
    public void visit(Unit unit) {
        unit.visit(this);
    }

    @Override
    public void visit(Empty empty) {
        empty.visit(this);
    }

    @Override
    public void processStep() {

    }
}
