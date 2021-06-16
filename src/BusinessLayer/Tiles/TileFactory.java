package BusinessLayer.Tiles;

import BusinessLayer.Tiles.Enemy.Boss;
import BusinessLayer.Tiles.Enemy.Enemy;
import BusinessLayer.Tiles.Enemy.Monster;
import BusinessLayer.Tiles.Enemy.Trap;
import BusinessLayer.Tiles.Player.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class TileFactory {
    private List<Supplier<Player>> playersList;
    private Map<Character, Supplier<Enemy>> enemiesMap;

    public TileFactory(){
        enemiesMap = initEnemies();
        playersList = initPlayers();
    }

    private Map<Character, Supplier<Enemy>> initEnemies() {
        List<Supplier<Enemy>> enemies = Arrays.asList(
                () -> new Monster('s', "Lannister Solider", 8, 8, 3,25, 10),
                () -> new Monster('k', "Lannister Knight", 2, 14, 8, 50,   4),
                () -> new Monster('q', "Queen's Guard", 4, 20, 15, 100,  5),
                () -> new Boss('M', "The Mountain", 1, 60, 25,  500, 6),
                () -> new Boss('C', "Queen Cersei", 1, 10, 10,1000, 1),
                () -> new Trap('B', "Bonus Trap", 1, 1, 1, 250,  1, 10),
                () -> new Trap('Q', "Queen's Trap", 250, 50, 10, 100, 3, 10),

                () -> new Monster('z', "Wright", 600, 30, 15,100, 3),
                () -> new Monster('b', "Bear-Wright", 1000, 75, 30, 250,  4),
                () -> new Monster('g', "Giant-Wright",1500, 100, 40,500,   5),
                () -> new Monster('w', "White Walker", 2000, 150, 50, 1000, 6),
                () -> new Boss('K', "Night's King", 5000, 300, 150, 5000, 8),
                () -> new Trap('D', "Death Trap", 500, 100, 20, 250, 1, 10)
        );

        return enemies.stream().collect(Collectors.toMap(s -> s.get().getTile(), Function.identity()));
    }

    private List<Supplier<Player>> initPlayers() {
        return Arrays.asList(
                () -> new Warrior("Jon Snow", 300, 30, 4, 3),
                () -> new Warrior("The Hound", 400, 20, 6, 5),
                () -> new Mage("Melisandre", 100, 5, 1, 300, 30, 15, 5, 6),
                () -> new Mage("Thoros of Myr", 250, 25, 4, 150, 20, 20, 3, 4),
                () -> new Rogue("Arya Stark", 150, 40, 2, 20),
                () -> new Rogue("Bronn", 250, 35, 3, 50),
                () -> new Hunter("Ygritte", 220, 30, 2, 6)
        );
    }

    public Enemy getEnemy(char c){
        return enemiesMap.get(c).get();
    }

    public Player getPlayer(char c){
        return playersList.get(Integer.valueOf(String.valueOf(c))-1).get();
    }
}