package Tests;

import BusinessLayer.Position;
import BusinessLayer.Tiles.Enemy.Enemy;
import BusinessLayer.Tiles.Enemy.Monster;
import BusinessLayer.Tiles.Player.*;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class PlayerTest {
    Player hunter;
    Player warrior;
    Player mage;
    Player rogue;
    Monster monsterClose;
    Monster monsterFar;
    List<Enemy> closeEnemyList;
    List<Enemy> farEnemyList;


    @Before
    public void setUp() throws Exception {
        closeEnemyList = new LinkedList<>();
        farEnemyList = new LinkedList<>();

        hunter = new Hunter("Hunter",1000,1000,1000, 10);
        warrior = new Warrior("Warrior", 200,30,100,3);
        mage = new Mage("Mage", 200, 100, 10, 100, 1, 100, 3, 4);
        rogue = new Rogue("Rogue", 200, 100,100,10);
        hunter.setPos(new Position(1,1));
        warrior.setPos(new Position(1,1));
        mage.setPos(new Position(1,1));
        rogue.setPos(new Position(1,1));

        monsterClose = new Monster('W', "White Walker", 1000, 1000, 1000, 10, 10);
        monsterClose.setPos(new Position(2,2));
        closeEnemyList.add(monsterClose);

        monsterFar = new Monster('W', "White Walker", 1000, 1000, 1000, 10, 10);
        monsterFar.setPos(new Position(100,100));
        farEnemyList.add(monsterFar);
    }

    @Test
    public void levelUp_hunter() {
        hunter.levelUp();
        int hunterLevel = hunter.getPlayerLevel();
        int attackPointsHunter = hunter.getAttackPoints();
        int defensePointsHunter = hunter.getDefensePoints();
        int abilityHunter = hunter.getAbilityAmount();
        int healthHunter = hunter.getHealthAmount();
        assertEquals(2, hunterLevel);
        assertEquals(1012,attackPointsHunter);
        assertEquals(1004, defensePointsHunter);
        assertEquals(30, abilityHunter);
        assertEquals(1020, healthHunter);
    }

    @Test
    public void levelUp_rogue() {
        rogue.levelUp();
        int RogueLevel = rogue.getPlayerLevel();
        int attackPointsRogue = rogue.getAttackPoints();
        int defensePointsRogue = rogue.getDefensePoints();
        int abilityRogue = rogue.getAbilityAmount();
        int healthRogue = rogue.getHealthAmount();
        assertEquals(2, RogueLevel);
        assertEquals(114, attackPointsRogue);
        assertEquals(102, defensePointsRogue);
        assertEquals(100, abilityRogue);
        assertEquals(220, healthRogue);
    }

    @Test
    public void levelUp_mage() {
        mage.levelUp();
        int MageLevel = mage.getPlayerLevel();
        int attackPointsMage = mage.getAttackPoints();
        int defensePointsMage = mage.getDefensePoints();
        int abilityMage = mage.getAbilityAmount();
        int healthMage = mage.getHealthAmount();
        assertEquals(2, MageLevel);
        assertEquals(108, attackPointsMage);
        assertEquals(12, defensePointsMage);
        assertEquals(137, abilityMage);
        assertEquals(220, healthMage);
    }

    @Test
    public void levelUp_warrior() {
        warrior.levelUp();
        int warriorLevel = warrior.getPlayerLevel();
        int attackPointsWarrior = warrior.getAttackPoints();
        int defensePointsWarrior = warrior.getDefensePoints();
        int abilityWarrior = warrior.getAbilityAmount();
        int healthWarrior = warrior.getHealthAmount();
        assertEquals(2, warriorLevel);
        assertEquals(42,attackPointsWarrior);
        assertEquals(104, defensePointsWarrior);
        assertEquals(3, abilityWarrior);
        assertEquals(220, healthWarrior);
    }

    

    @Test
    public void onAbilityCast1() {
        hunter.onAbilityCast(closeEnemyList);
        int abilityHunterClose = hunter.getAbilityAmount();
        assertEquals(9, abilityHunterClose);

    }

    @Test
    public void onAbilityCast2() {
        hunter.onAbilityCast(farEnemyList);
        int abilityHunterFar = hunter.getAbilityAmount();
        assertEquals(10, abilityHunterFar);

    }

    @Test
    public void abilityAttack() {
    }

    @Test
    public void onTick() {
    }

    @Test
    public void abilityTick() {
    }
}