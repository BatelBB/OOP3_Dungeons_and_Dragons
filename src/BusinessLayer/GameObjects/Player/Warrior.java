package BusinessLayer.GameObjects.Player;

import Game_Tiles.Empty;
import Game_Tiles.Unit;
import Game_Tiles.Visitor;
import Game_Tiles.Wall;

public class Warrior extends Player {
    public Integer abilityCooldown; // Represents the number of game ticks required to pass before the warrior can cast the ability again.
    public Integer remainingCooldown; //Represents the number of ticks remained until the warrior can cast its special ability.

    public Warrior(String name, int health, int attack, int defense, int cooldown){
        this.name = name;
        this.healthAmount = health;
        this.healthPool = health;
        this.attackPoints = attack;
        this.defensePoints = defense;
        this.abilityCooldown = cooldown;
        this.remainingCooldown = 0;
    }

    public void onGameTick(){
        remainingCooldown -= 1;
    }

    public void castAbility() {
        if(remainingCooldown != 0){
            //not possible
        }else{
            remainingCooldown = abilityCooldown;
            healthAmount = Math.min(healthAmount + 10*defensePoints, healthPool);
            //Randomly hits one enemy within range < 3 for an amount equals to 10% of the warrior’s health pool
        }
    }

    public void levelUp(){
        levelUpBasic();
        remainingCooldown = 0;
        healthPool = healthPool + 5*playerLevel;
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
