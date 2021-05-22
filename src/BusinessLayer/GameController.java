package BusinessLayer;

import BusinessLayer.GameObjects.Enemies.Enemy;
import BusinessLayer.GameObjects.Enemies.Monster;
import BusinessLayer.GameObjects.Player.Player;
import BusinessLayer.GameObjects.Player.Warrior;

import java.util.HashMap;

public class GameController {
    HashMap<Character, Enemy> enemyHashMap;
    HashMap<Integer, Player> playerHashMap;
    public GameController(){
        enemyHashMap = new HashMap<>();
        playerHashMap = new HashMap<>();
        enemyHashMap.put('s',new Monster("Lannister Soldier", 's', 80, 8, 3, 3, 25));

        playerHashMap.put(1, new Warrior("Jon Snow", 300, 30, 4, 3));
    }
}
