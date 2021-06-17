package Tests;

import BusinessLayer.Board;
import BusinessLayer.Position;
import BusinessLayer.Tiles.Empty;
import BusinessLayer.Tiles.Enemy.Enemy;
import BusinessLayer.Tiles.Enemy.Monster;
import BusinessLayer.Tiles.Enemy.Trap;
import BusinessLayer.Tiles.Player.Player;
import BusinessLayer.Tiles.Player.Warrior;
import BusinessLayer.Tiles.Unit;
import BusinessLayer.Tiles.Wall;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MonsterTest {

    private Board board;
    private final int HEALTH = 100;

    private Unit monster;
    private Unit monster2;
    private Trap trap;

    private Unit player;

    private Enemy monsterE;
    private Enemy monster2E;

    private Player playerP;

    @Before
    public void setUp() throws Exception {
        monster = new Monster('s', "nicetert", HEALTH, 5, 0, 25, 10);
        monster2 = new Monster('s', "nicetert", HEALTH, 5, 0, 25, 10);
        player = new Warrior("warIsNice", HEALTH, 5, 0, 1);
        trap = new Trap('t', "trap", HEALTH, 5, 0, 25, 1, 1);

        monsterE = new Monster('s', "nicetert", HEALTH, 5, 0, 25, 10);
        monster2E = new Monster('s', "nicetert", HEALTH, 5, 0, 25, 10);
        playerP = new Warrior("warIsNice", HEALTH, 5, 0, 1);

        Wall walle = new Wall('#');
        Empty nothing = new Empty('.');

        //board = new Board('1');

    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void monster_accept_unit_player() {
        //accept(unit is player) -> player attacks monster

        for(int i = 0; i < 5; i++) {
            monster.accept(player);
        }

        if(monster.health.isFull())
            Assert.fail("player doesnot attack enemy on enemy.accept(unit == player)");

    }

    @Test
    public void monster_accept2_unit_enemy() {
        //accept(unit is enemy) -> do nothing

        for(int i = 0; i < 5; i++) {
            monster.accept(monster2);
        }

        if(!monster.health.isFull() || !monster2.health.isFull())
            Assert.fail("enemy attacks enemy on  enemy.accept(unit == enemy)");
    }

    @Test
    public void monster_visit_monster() {
        //visit(enemy) -> do nothing

        for(int i = 0; i < 5; i++) {
            monster.visit(monster2E);
        }

        if(!monsterE.health.isFull() || !monster2E.health.isFull())
            Assert.fail("enemy attacks enemy on  enemy.visit(enemy)");
    }

    @Test
    public void monster_Visit_player() {
        //visit playEr -> attack player

        for(int i = 0; i < 5; i++) {
            monsterE.visit(playerP);
        }

        if(playerP.health.isFull())
            Assert.fail("enemy does not attack player on  enemy.visit(Player)");
    }

    @Test
    public void trap_accept_Unit_enemy(){
        trap.accept(monster);

        if(!monster.health.isFull() || !trap.health.isFull())
            Assert.fail("monster attacked trap on trap.accept(Unit == monster)");
    }

    @Test
    public void trap_accept_unit_player(){
        trap.accept(player);

        if(trap.health.isFull())
            Assert.fail("player unit failed to attack trap on trap.accept(Unit == player)");
    }

    @Test
    public void trap_accept_Enemy_enemy(){
        trap.accept(monsterE);

        if(!monsterE.health.isFull() || !trap.health.isFull())
            Assert.fail("monster attacked trap on trap.accept(Unit == monster)");
    }

    @Test
    public void trap_accept_Player_player(){

    }

    @Test
    public void empty_accept_unit(){

    }

    @Test
    public void wall_accept_unit(){

    }

}