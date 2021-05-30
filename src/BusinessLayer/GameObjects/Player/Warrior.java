package BusinessLayer.GameObjects.Player;

import BusinessLayer.GameObjects.Enemies.Enemy;
import BusinessLayer.GameObjects.Game_Tiles.Empty;
import BusinessLayer.GameObjects.Game_Tiles.Unit;
import BusinessLayer.GameObjects.Game_Tiles.Visitor;
import BusinessLayer.GameObjects.Game_Tiles.Wall;
import BusinessLayer.Utils.Resource;

public class Warrior extends Player {
    public Integer abilityCooldown; // Represents the number of game ticks required to pass before the warrior can cast the ability again.
    public Integer remainingCooldown; //Represents the number of ticks remained until the warrior can cast its special ability.

    public Warrior(char ch, String name, Resource resource, int attack, int defense, int cooldown){
        super(name, resource.getAmount(), attack, defense);
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

//    public void levelUp(){
//        levelUpBasic();
//        remainingCooldown = 0;
//        healthPool = healthPool + 5*playerLevel;
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
