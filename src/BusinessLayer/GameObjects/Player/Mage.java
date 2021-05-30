package BusinessLayer.GameObjects.Player;

import BusinessLayer.GameObjects.Enemies.Enemy;
import BusinessLayer.GameObjects.Game_Tiles.Empty;
import BusinessLayer.GameObjects.Game_Tiles.Unit;
import BusinessLayer.GameObjects.Game_Tiles.Visitor;
import BusinessLayer.GameObjects.Game_Tiles.Wall;

public class Mage extends Player{
    public Integer manaPool;
    public Integer currentMana;
    public Integer manaCost;
    public Integer spellPower;
    public Integer hitCount;
    public Integer abilityRange;

    public Mage(String name, int health, int attack, int defense, int manaPool, int manaCost, int spellPower, int hitCount, int range){
        super(name, health, attack, defense);
        this.manaPool = manaPool;
        this.manaCost = manaCost;
        this.spellPower = spellPower;
        this.hitCount = hitCount;
        this.abilityRange = range;
        this.currentMana = manaPool/4;
    }
    public void onGameTick(){
        currentMana = Math.min(manaPool, currentMana+playerLevel);
    }

    public void castAbility() {
        currentMana = currentMana-manaCost;
        int hits = 0;
        //(hits < hits count) ∧ (∃ living enemy s.t. range(enemy, player) < ability range)
        while (hits < hitCount ){
            //Select random enemy within ability range.
            //Deal damage (reduce health value) to the chosen enemy for an amount equal to spell power (each enemy may try to defend itself).
            hits += 1;
        }
    }

//    public void levelUp(){
//        levelUpBasic();
//        manaPool = manaPool + 25*playerLevel;
//        currentMana = Math.min(currentMana + manaPool/4, manaPool);
//        spellPower = spellPower+10*playerLevel;
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
