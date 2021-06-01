package BusinessLayer;

import BusinessLayer.GameObjects.Enemies.Boss;
import BusinessLayer.GameObjects.Enemies.Enemy;

import BusinessLayer.GameObjects.Enemies.Monster;
import BusinessLayer.GameObjects.Enemies.Trap;
import BusinessLayer.GameObjects.Game_Tiles.*;
import BusinessLayer.GameObjects.Player.Mage;
import BusinessLayer.GameObjects.Player.Player;
import BusinessLayer.GameObjects.Player.Rogue;
import BusinessLayer.GameObjects.Player.Warrior;
import BusinessLayer.Utils.Resource;
import ServiceLayer.InputManager;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Board {
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
        chosenPlayer = im.getInput("Select player:");


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

        playerHashMap.put('3', new Mage('@',"Melisandra", new Resource("Health", 100), 5, 1, 300, 30, 15, 5, 6));
        playerHashMap.put('4', new Mage('@',"Thoros of Myr", new Resource("Health", 250), 25, 4, 150, 20, 20, 3, 4));

        playerHashMap.put('5', new Rogue('@',"Arya Stark", new Resource("Health", 150), 40, 2, 20));
        playerHashMap.put('6', new Rogue('@',"Bronn", new Resource("Health", 250), 35, 3, 50));

        enemyHashMap.put('s' ,new Monster('s', "Lannister Soldier", new Resource("Health", 80), 8, 3, 25, 3));
        enemyHashMap.put('k' ,new Monster('k',"Lannister Knight", new Resource("Health", 200), 14, 8, 4, 50));
        enemyHashMap.put('q' ,new Monster('q',"Queen's Guard", new Resource("Health", 400), 20, 15, 5, 100));
        enemyHashMap.put('z' ,new Monster('z',"Wright", new Resource("Health", 600), 30, 15, 3, 100));
        enemyHashMap.put('b' ,new Monster('b',"Bear-Wright", new Resource("Health", 1000), 75, 30, 4, 250));
        enemyHashMap.put('g' ,new Monster('g',"Giant-Wright",new Resource("Health", 1500), 100, 40, 5, 500));
        enemyHashMap.put('w' ,new Monster('w',"White Walker", new Resource("Health", 2000), 150, 50, 6, 1000));
        enemyHashMap.put('M' ,new Boss('M',"The Mountain", new Resource("Health", 1000), 60, 25, 6, 500));
        enemyHashMap.put('C' ,new Boss('C',"Queen Cersei",new Resource("Health", 100), 10, 10, 1,1000));
        enemyHashMap.put('K' ,new Boss('K',"Night's King", new Resource("Health", 5000), 300, 150, 8, 5000));

        enemyHashMap.put('B' ,new Trap('B',"Bonus Trap", new Resource("Health", 1), 1, 1, 250, 1, 5));
        enemyHashMap.put('Q' ,new Trap('Q',"Queen's Trap", new Resource("Health", 250),50, 10, 100, 3, 7));
        enemyHashMap.put('D' ,new Trap('D',"Death Trap", new Resource("Health", 500), 100, 20, 250, 1, 10));

    }

    private void init(char[][] map){
        for (int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                if(map[i][j] != '@' && map[i][j] != '#' && map[i][j] != '.') {
                    enemyList.addFirst(enemyHashMap.get(map[i][j]));
                    gameMap.add(enemyList.getFirst());
                    enemyList.getFirst().initialize(new Position(j,i));
                }
                else if(map[i][j] == '@') {
                    player = playerHashMap.get(chosenPlayer);
                    gameMap.add(player);
                    player.initialize(new Position(j,i));
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
            im.setCliInput();
            char ch = im.getInput();
            if (ch == 'd' || ch == 'q' || ch == 'w' || ch == 'a' || ch == 's' || ch == 'e') {
                playerGo(ch);
                enemiesGo();

                //after all updates
                im.updateCLI(gameMap, width, height);
            }
        }
     }

     private void enemiesGo(){
         Random rand = new Random(12);
         for (Enemy e: enemyList) {
             int a = rand.nextInt(5);
             switch (a){
                 case 1 -> up(e);
                 case 2 -> down(e);
                 case 3 -> left(e);
                 case 4 -> right(e);
             }
         }
     }


    private void playerGo(char input){
        switch (input){
            case 'w' -> up(player);
            case 's' -> down(player);
            case 'a' -> left(player);
            case 'd' -> right(player);
        }
    }

    private Tile find(Position p){
        for (Tile t: gameMap) {
            if(t.getPosition().equals(p))
                return t;
        }
        return null;
    }

    private void up(Tile u){
        Position p = u.getPosition().translate(0,-1);
        u.interact(find(p));

    }

    private void down(Unit u){
        Position p = u.getPosition().translate(0,1);
        u.interact(find(p));
    }

    private void left(Unit u){
        Position p = u.getPosition().translate(-1,0);
        u.interact(find(p));
    }

    private void right(Unit u){
        Position p = u.getPosition().translate(1,0);
        u.interact(find(p));
    }


}
