package BusinessLayer.GameObjects.Player;

import Game_Tiles.Empty;
import Game_Tiles.Unit;
import Game_Tiles.Visitor;
import Game_Tiles.Wall;

public class Rogue extends Player {
    public Integer cost;
    public Integer currentEnergy; // Using energy as resource. Starting energy equals to the rogue’s maximum energy which is 100

    public Rogue(String name, int health, int attack, int defense, int cost){
        this.name = name;
        this.healthAmount = health;
        this.healthPool = health;
        this.attackPoints = attack;
        this.defensePoints = defense;
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

    public void levelUp(){
        experience = experience - 50*playerLevel;
        playerLevel += 1;
        healthPool = healthPool + 10*playerLevel;
        healthAmount = healthPool;
        attackPoints = attackPoints + 4*playerLevel;
        defensePoints = defensePoints + playerLevel;
        currentEnergy += 100;
        attackPoints = attackPoints + 3*playerLevel;
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
