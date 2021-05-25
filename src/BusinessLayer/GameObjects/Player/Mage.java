package BusinessLayer.GameObjects.Player;

import Game_Tiles.Empty;
import Game_Tiles.Unit;
import Game_Tiles.Visitor;
import Game_Tiles.Wall;

public class Mage extends Player{
    public Integer manaPool;
    public Integer currentMana;
    public Integer manaCost;
    public Integer spellPower;
    public Integer hitCount;
    public Integer abilityRange;

    public Mage(String name, int health, int attack, int defense, int manaPool, int manaCost, int spellPower, int hitCount, int range){
        this.name = name;
        this.healthAmount = health;
        this.healthPool = health;
        this.attackPoints = attack;
        this.defensePoints = defense;
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

    public void levelUp(){
        levelUpBasic();
        manaPool = manaPool + 25*playerLevel;
        currentMana = Math.min(currentMana + manaPool/4, manaPool);
        spellPower = spellPower+10*playerLevel;
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
