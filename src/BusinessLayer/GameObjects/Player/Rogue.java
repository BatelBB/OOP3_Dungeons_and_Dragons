package BusinessLayer.GameObjects.Player;

import BusinessLayer.GameObjects.Enemies.Enemy;
import BusinessLayer.GameObjects.Game_Tiles.Empty;
import BusinessLayer.GameObjects.Game_Tiles.Unit;
import BusinessLayer.GameObjects.Game_Tiles.Visitor;
import BusinessLayer.GameObjects.Game_Tiles.Wall;

public class Rogue extends Player {
    public Integer cost;
    public Integer currentEnergy; // Using energy as resource. Starting energy equals to the rogue’s maximum energy which is 100

    public Rogue(char ch, String name, int health, int attack, int defense, int cost){
        super(ch, name, health, attack, defense);
        this.cost = cost;
        this.currentEnergy = 100;
    }

    public void onGameTick(){
        currentEnergy = Math.min(currentEnergy+10, 100);
    }

    public void castAbility() {
        currentEnergy = currentEnergy - cost;
        if(currentEnergy < cost) {
            //cannot cast ability
            //generate an appropriate error message.
        }
        else{
            //For each enemy within range < 2, deal damage (reduce health value) equals to the rogue’s
            //attack points (each enemy will try to defend itself
        }
    }

//    public void levelUp(){
//        levelUpBasic();
//        currentEnergy += 100;
//        attackPoints = attackPoints + 3*playerLevel;
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
