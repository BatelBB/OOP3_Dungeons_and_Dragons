package BusinessLayer;

import BusinessLayer.Interfaces.EnemyDeathCallback;
import BusinessLayer.Tiles.Empty;
import BusinessLayer.Tiles.Enemy.Enemy;
import BusinessLayer.Tiles.Enemy.Monster;
import BusinessLayer.Tiles.Player.*;
import BusinessLayer.Tiles.Resource;
import BusinessLayer.Tiles.Unit;
import BusinessLayer.Tiles.Wall;
import ServiceLayer.InputManager;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Board /*implements EnemyDeathCallback*/ {
    InputManager im;

    public boolean isGame;

    private LinkedList<Tile> gameMap;
    private char chosenPlayer;

    //private Tile[][] gameMap;
    private LinkedList<Enemy> enemyList;
    private Player player;

    private HashMap<Character, Enemy> enemyHashMap;
    private HashMap<Character, Player> playerHashMap;

    private int height;
    private int width;


    public Board(char[][] map){
        isGame = true;
        height = map.length;
        width = map[0].length;

        im = new InputManager();

        chosenPlayer = im.getInput("choose wisely");


        enemyList = new LinkedList<>();
        gameMap = new LinkedList<>();

        enemyHashMap = new HashMap<>();
        playerHashMap = new HashMap<>();
        loadHashMaps();
        init(map);

        im.updateCLI(gameMap, width, height);
        update();
    }




    private void loadHashMaps(){
        //public Warrior(char c, String name, Health health, int attack, int defense, Resource resource){

        //tileHashMap.put('#', new Wall('#'));
        //tileHashMap.put('.', new Empty('.'));

        playerHashMap.put('1', new Warrior('@', "Jon Snow", new Resource("Health", 300), 30, 4, 3));
        playerHashMap.put('2', new Warrior('@', "The Hound", new Resource("Health",400), 20, 6, 5));
        playerHashMap.put('5', new Rogue('@', "Arya Stark", new Resource("Health", 150), 40, 2, 20));
        playerHashMap.put('7', new Hunter('@', "Ygritte", new Resource("Health", 220), 30, 2, 6));
        playerHashMap.put('3', new Mage('@', "Melisandra", new Resource("Health", 100), 5, 1, 300, 30, 15, 5, 6));
                                     //char c, String name, Resource health, int attack, int def, int manaPool, int manaCost, int spellPower, int hitCount, int range
        /*playerHashMap.put(4, new Mage("Thoros of Myr", 250, 25, 4, 150, 20, 20, 3, 4));

        playerHashMap.put(5, new Rogue("Arya Stark", 150, 40, 2, 20));
        playerHashMap.put(6, new Rogue("Bronn", 250, 35, 3, 50));*/

        enemyHashMap.put('s' ,new Monster('s', "Lannister Soldier", new Resource("Health", 80), 8, 3, 25, 3));
        /*enemyHashMap.put('k' ,new Monster("Lannister Knight", 'k', 200, 14, 8, 4, 50));
        enemyHashMap.put('q' ,new Monster("Queen's Guard", 'q', 400, 20, 15, 5, 100));
        enemyHashMap.put('z' ,new Monster("Wright", 'z', 600, 30, 15, 3, 100));
        enemyHashMap.put('b' ,new Monster("Bear-Wright", 'b', 1000, 75, 30, 4, 250));
        enemyHashMap.put('g' ,new Monster("Giant-Wright",'g', 1500, 100, 40, 5, 500));
        enemyHashMap.put('w' ,new Monster("White Walker", 'w', 2000, 150, 50, 6, 1000));
        /*enemyHashMap.put('M' ,new Boss("The Mountain", 'M', 1000, 60, 25, 6, 500));
        enemyHashMap.put('C' ,new Boss("Queen Cersei",'C', 100, 10, 10, 1,1000));
        enemyHashMap.put('K' ,new Boss("Night's King", 'K', 5000, 300, 150, 8, 5000));

        enemyHashMap.put('B' ,new Trap("Bonus Trap", 'B', 1, 1, 1, 250, 1, 5));
        enemyHashMap.put('Q' ,new Trap("Queen's Trap", 'Q', 250, 50, 10, 100, 3, 7));
        enemyHashMap.put('D' ,new Trap("Death Trap", 'D', 500, 100, 20, 250, 1, 10));*/

    }

    private void init(char[][] map){
        for (int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                /*if(map[i][j] != '@' && map[i][j] != '#' && map[i][j] != '.') {
                    enemyList.addFirst(enemyHashMap.get(map[i][j]));
                    gameMap.add(enemyList.getFirst());
                    enemyList.getFirst().init(new Position(j,i));
                }*/
                if(map[i][j] == 's'){
                    Enemy e = new Monster('s', "Lannister Soldier", new Resource("Health", 1), 8, 3, 25, 3);
                    gameMap.add(e);
                    e.init(new Position(j,i));
                    e.setEnemyDeathCallback(() -> this.onEnemyDeath(e));
                    enemyList.add(e);
                }
                else if(map[i][j] == '@') {
                    player = playerHashMap.get(chosenPlayer);
                    gameMap.add(player);
                    player.init(new Position(j,i));
                }
                else if(map[i][j] == '#')
                    gameMap.add(new Wall('#', new Position(j,i)));
                else if(map[i][j] == '.')
                    gameMap.add(new Empty('.', new Position(j,i)));
            }
        }
    }

    public void update(){
        while (isGame) {
            playerGo(im.getInput());
    //        enemiesGo();

            //after all updates
            im.updateCLI(gameMap, width, height);
        }
     }

     private void enemiesGo(){
         Random rand = new Random();
         for (Enemy e: enemyList) {
             int a = rand.nextInt(4) + 1;
             switch (a){
                 case 1 -> up(e);
                 case 2 -> down(e);
                 case 3 -> left(e);
                 case 4 -> right(e);
             }
         }
     }

    //translate UserInput to gameLogic
    private void playerGo(char input){
        switch (input){
            case 'w' -> up(player);
            case 's' -> down(player);
            case 'a' -> left(player);
            case 'd' -> right(player);
            case 'e' -> castAbility();
        }
        player.onTick();
    }

    private void castAbility(){
        List<Enemy> enemiesInRange = new LinkedList<>();

        for (Enemy e: enemyList) {
            if(e.pos.Range(player.pos) < player.getRange())
                enemiesInRange.add(e);
        }

        player.onAbilityCast(enemiesInRange);
    }

    //goes over the board and finds the tile in wanted pos
    private Tile find(Position p){
        for (Tile t: gameMap) {
            if(t.getPos().equals(p))
                return t;
        }
        return null;
    }

    private void up(Tile u){
        Position p = u.getPos().translate(0,-1);
        u.interact(find(p));
    }

    private void down(Unit u){
        Position p = u.getPos().translate(0,1);
        u.interact(find(p));
    }

    private void left(Unit u){
        Position p = u.getPos().translate(-1,0);
        u.interact(find(p));
    }

    private void right(Unit u){
        Position p = u.getPos().translate(1,0);
        u.interact(find(p));
    }

    public void handleEnemyDeath(Tile e){
        e = new Empty('.', e.pos);
    }

    public void onEnemyDeath(Enemy e){
        Position pos = e.pos;
        enemyList.remove(e);
        gameMap.remove(e);
        gameMap.add(new Empty('.', pos));
    }

}
