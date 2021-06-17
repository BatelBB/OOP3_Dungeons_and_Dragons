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

        hunter = new Hunter("Hunter",1000,1000,1000, 1);
        warrior = new Warrior("Warrior", 200,30,100,3);
        mage = new Mage("Mage", 200, 100, 10, 100, 1, 100, 3, 4);
        rogue = new Rogue("Rogue", 200, 100,100,10);
        hunter.setPos(new Position(1,1));
        warrior.setPos(new Position(1,1));
        mage.setPos(new Position(1,1));
        rogue.setPos(new Position(1,1));

        monsterClose = new Monster('W', "White Walker", 10, 10, 100, 10, 10);
        monsterClose.setPos(new Position(2,2));
        closeEnemyList.add(monsterClose);
        monsterClose.setEnemyDeathCallback(() -> System.out.println("MONSTER DEAD"));

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
    public void onAbilityCastClose() {
        hunter.onAbilityCast(closeEnemyList);
        int abilityHunterClose = hunter.getAbilityAmount();
        assertEquals(9, abilityHunterClose);

        warrior.onAbilityCast(closeEnemyList);
        int abilityWarriorClose = warrior.getAbilityAmount();
        assertEquals(3, abilityWarriorClose);

        mage.onAbilityCast(closeEnemyList);
        int abilityMageClose = mage.getAbilityAmount();
        assertEquals(99, abilityMageClose);

        rogue.onAbilityCast(closeEnemyList);
        int abilityRogueClose = rogue.getAbilityAmount();
        assertEquals(90, abilityRogueClose);

    }




    @Test
    public void onTick() {
        for(int i=0; i<10; i++) {
            hunter.onTick();
        }
        int abilityHunter = hunter.getAbilityAmount();
        assertEquals(10,abilityHunter);

        mage.onTick();
        int abilityMage = mage.getAbilityAmount();
        assertEquals(100, abilityMage);

    }


}