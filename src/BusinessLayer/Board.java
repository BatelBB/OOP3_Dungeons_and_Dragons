package BusinessLayer;

import BusinessLayer.Tiles.Empty;
import BusinessLayer.Tiles.Enemy.Enemy;
import BusinessLayer.Tiles.Player.Player;
import BusinessLayer.Tiles.Player.Warrior;
import BusinessLayer.Tiles.Resource;
import BusinessLayer.Tiles.Unit;
import BusinessLayer.Tiles.Wall;
import ServiceLayer.InputManager;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Board {
    InputManager im;


    private Tile[][] gameMap;
    private LinkedList<Enemy> enemyList;
    private Player player;

    private HashMap<Character, Enemy> enemyHashMap;
    private HashMap<Character, Player> playerHashMap;

    public Board(char[][] map){
        im = new InputManager();

        enemyList = new LinkedList<>();

        enemyHashMap = new HashMap<>();
        playerHashMap = new HashMap<>();
        loadHashMaps();

    }

    private void loadHashMaps(){
        //public Warrior(char c, String name, Health health, int attack, int defense, Resource resource){

        //tileHashMap.put('#', new Wall('#'));
        //tileHashMap.put('.', new Empty('.'));

        playerHashMap.put('1', new Warrior('1', "Jon Snow", new Resource("Health", 300), 30, 4, 3));
        playerHashMap.put('2', new Warrior('2', "The Hound", new Resource("Health",400), 20, 6, 5));

        /*playerHashMap.put(3, new Mage("Melisandra", 100, 5, 1, 300, 30, 15, 5, 6));
        playerHashMap.put(4, new Mage("Thoros of Myr", 250, 25, 4, 150, 20, 20, 3, 4));

        playerHashMap.put(5, new Rogue("Arya Stark", 150, 40, 2, 20));
        playerHashMap.put(6, new Rogue("Bronn", 250, 35, 3, 50));*/

        /*enemyHashMap.put('s' ,new Monster("Lannister Soldier", 's', 80, 8, 3, 3, 25));
        enemyHashMap.put('k' ,new Monster("Lannister Knight", 'k', 200, 14, 8, 4, 50));
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
                if(map[i][j] != '@' && map[i][j] != '#' && map[i][j] != '.') {
                    enemyList.addFirst(enemyHashMap.get(map[i][j]));
                    gameMap[i][j] = enemyList.getFirst();
                    gameMap[i][j].init(new Position(j,i));
                }
                else if(map[i][j] == '@') {
                    player = playerHashMap.get(map[i][j]);
                    gameMap[i][j] = player;
                }
            }
        }
    }

    public void update(){
        playerGo(im.getInput());
    }

    private void playerGo(char input){
        if(input != 'q' && input != 'e'){
            if(input == 'w')
                up(player);
        }
    }



    private void up(Unit u){
        Position p = u.pos.translate(0,1);
        u.interact(gameMap[p.getxPos()][p.getyPos()]);

        u.interact(list.find(p));
    }

    private void down(Unit u){

    }

    private void left(Unit u){

    }

    private void right(Unit u){

    }


}
