package BusinessLayer;

import BusinessLayer.GameObjects.Enemies.Boss;
import BusinessLayer.GameObjects.Enemies.Enemy;
import BusinessLayer.GameObjects.Enemies.Monster;
import BusinessLayer.GameObjects.Enemies.Trap;
import BusinessLayer.GameObjects.Player.Mage;
import BusinessLayer.GameObjects.Player.Player;
import BusinessLayer.GameObjects.Player.Rogue;
import BusinessLayer.GameObjects.Player.Warrior;
import Game_Tiles.Empty;
import Game_Tiles.Tile;
import Game_Tiles.Wall;

import java.util.HashMap;
import java.util.List;

public class GameController {
    public HashMap<Character, Enemy> enemyHashMap;
    public HashMap<Integer, Player> playerHashMap;

    public Game_Tiles.Tile[][] gameMap;

    private Player myPlayer;

    public GameController(List<String> map, int player){
        enemyHashMap = new HashMap<>();
        playerHashMap = new HashMap<>();
        bringToLife();
        gameMap = new Tile[map.size()][map.get(0).length()];
        start(map, player);
    }

    private void bringToLife(){
        playerHashMap.put(1, new Warrior("Jon Snow", 300, 30, 4, 3));
        playerHashMap.put(2, new Warrior("The Hound", 400, 20, 6, 5));

        playerHashMap.put(3, new Mage("Melisandra", 100, 5, 1, 300, 30, 15, 5, 6));
        playerHashMap.put(4, new Mage("Thoros of Myr", 250, 25, 4, 150, 20, 20, 3, 4));

        playerHashMap.put(5, new Rogue("Arya Stark", 150, 40, 2, 20));
        playerHashMap.put(6, new Rogue("Bronn", 250, 35, 3, 50));

        enemyHashMap.put('s' ,new Monster("Lannister Soldier", 's', 80, 8, 3, 3, 25));
        enemyHashMap.put('k' ,new Monster("Lannister Knight", 'k', 200, 14, 8, 4, 50));
        enemyHashMap.put('q' ,new Monster("Queen's Guard", 'q', 400, 20, 15, 5, 100));
        enemyHashMap.put('z' ,new Monster("Wright", 'z', 600, 30, 15, 3, 100));
        enemyHashMap.put('b' ,new Monster("Bear-Wright", 'b', 1000, 75, 30, 4, 250));
        enemyHashMap.put('g' ,new Monster("Giant-Wright",'g', 1500, 100, 40, 5, 500));
        enemyHashMap.put('w' ,new Monster("White Walker", 'w', 2000, 150, 50, 6, 1000));
        enemyHashMap.put('M' ,new Boss("The Mountain", 'M', 1000, 60, 25, 6, 500));
        enemyHashMap.put('C' ,new Boss("Queen Cersei",'C', 100, 10, 10, 1,1000));
        enemyHashMap.put('K' ,new Boss("Night's King", 'K', 5000, 300, 150, 8, 5000));

        enemyHashMap.put('B' ,new Trap("Bonus Trap", 'B', 1, 1, 1, 250, 1, 5));
        enemyHashMap.put('Q' ,new Trap("Queen's Trap", 'Q', 250, 50, 10, 100, 3, 7));
        enemyHashMap.put('D' ,new Trap("Death Trap", 'D', 500, 100, 20, 250, 1, 10));


        //Hunter ygritte = new Hunter("Ygritte", 220, 30, 2, 6);
    }

    public void start(List<String> map, int player){
        for (int i = 0; i < map.size(); i++) {
            String line = map.get(i);
            for (int j = 0; j < line.length(); j++){
                if(line.charAt(j) == '.')
                    gameMap[i][j] = new Empty();
                else if(line.charAt(j) == '@')
                    gameMap[i][j] = playerHashMap.get(player);
                else {
                    if (line.charAt(j) == '#')
                        gameMap[i][j] = new Wall();
                    else {
                        gameMap[i][j] = enemyHashMap.get(line.charAt(j));
                    }
                    gameMap[i][j].yPos = i;
                    gameMap[i][j].xPos = j;
                }
            }
        }
    }

    public void play(char input){

    }
}
