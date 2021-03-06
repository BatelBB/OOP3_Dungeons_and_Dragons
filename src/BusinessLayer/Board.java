package BusinessLayer;

import BusinessLayer.Interfaces.ObserverPattern.Observable;
import BusinessLayer.Interfaces.ObserverPattern.Observer;
import BusinessLayer.Tiles.*;
import BusinessLayer.Tiles.Enemy.Enemy;
import BusinessLayer.Tiles.Player.*;
import ServiceLayer.InputManager;

import java.util.*;

public class Board implements Observable {
    InputManager im;
    public boolean isGame;

    private LinkedList<Tile> gameMap;
    private char chosenPlayer;

    private LinkedList<Enemy> enemyList;
    private LinkedList<Enemy> movingEnemyList;
    private Player player;

    private int height;
    private int width;

    private TileFactory tileFactory;

    private List<Observer> observers;

    public Board(){
        tileFactory = new TileFactory();
        im = new InputManager();
        String output = "Select player:\n1. Jon Snow             Health: 300/300         Attack: 30              Defense: 4              Level: 1                Experience: 0/50                Cooldown: 0/3\n" +
                "2. The Hound            Health: 400/400         Attack: 20              Defense: 6              Level: 1                Experience: 0/50                Cooldown: 0/5\n" +
                "3. Melisandre           Health: 100/100         Attack: 5               Defense: 1              Level: 1                Experience: 0/50                Mana: 75/300            Spell Power: 15\n" +
                "4. Thoros of Myr        Health: 250/250         Attack: 25              Defense: 4              Level: 1                Experience: 0/50                Mana: 37/150            Spell Power: 20\n" +
                "5. Arya Stark           Health: 150/150         Attack: 40              Defense: 2              Level: 1                Experience: 0/50                Energy: 100/100\n" +
                "6. Bronn                Health: 250/250         Attack: 35              Defense: 3              Level: 1                Experience: 0/50                Energy: 100/100\n" +
                "7. Ygritte              Health: 220/220         Attack: 30              Defense: 2              Level: 1                Experience: 0/50                Arrows: 10              Range: 6 ";

        chosenPlayer = im.getInput(output);
        player = tileFactory.getPlayer(chosenPlayer);
    }

    public void startLevel(char[][] map, int level){
        im.showMessage(String.format("Level %d", level));

        isGame = true;
        height = map.length;
        width = map[0].length;

        enemyList = new LinkedList<>();
        movingEnemyList = new LinkedList<>();
        gameMap = new LinkedList<>();

        observers = new LinkedList<>();


        initMap(map);
        im.updateCLI(gameMap, width, height);
        update();
    }

    private void initMap(char[][] map){
        for (int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                if(map[i][j] == '@') {
                    gameMap.add(player);
                    player.init(new Position(j,i));
                    player.setPlayerDeathCallBack(() -> this.onPlayerDeath(player));
                    observers.add(player);
                }
                else if(map[i][j] == '#')
                    gameMap.add(new Wall('#', new Position(j,i)));
                else if(map[i][j] == '.')
                    gameMap.add(new Empty('.', new Position(j,i)));
                else{
                    Enemy e = tileFactory.getEnemy(map[i][j]);
                    gameMap.add(e);
                    e.init(new Position(j,i));
                    e.setEnemyDeathCallback(() -> this.onEnemyDeath(e));
                    enemyList.add(e);
                    observers.add(e);
                    if(!(e.tile == 'Q' || e.tile == 'B' || e.tile == 'D'))
                        movingEnemyList.add(e);
                }
            }
        }
    }

    public void update(){
        while (isGame) {
            char input = im.getInput();
            if (validInput(input)){
                playerGo(input);
                enemiesGo();


                if (enemyList.isEmpty()) {
                    isGame = false;
                }
                this.NotifyObservers();

                im.updateCLI(gameMap, width, height);
                im.showMessage(player.description());
            }

        }
    }
    private boolean validInput(char c){
        return (c == 'd' || c == 'q' || c == 'w' || c == 'a' || c == 's' || c == 'e');
    }

     private void enemiesGo(){
         for (Enemy e: movingEnemyList) {
             int dir = pickDirectionForEnemy(e);
             switch (dir){
                 case 1 -> up(e);
                 case 2 -> down(e);
                 case 3 -> left(e);
                 case 4 -> right(e);
             }
         }
     }

     private int pickDirectionForEnemy(Enemy e){
        if(e.pos.Range(player.pos) <= e.getVisionRange()){
            if(e.checkHeroic(player))
                return -1;
            else {
                double xDiff = e.pos.getxPos() - player.pos.getxPos();
                double yDiff = e.pos.getyPos() - player.pos.getyPos();

                if (Math.abs(xDiff) > Math.abs(yDiff)) {
                    if (xDiff < 0)
                        return 4;
                    return 3;
                } else {
                    if (yDiff < 0)
                        return 2;
                    return 1;
                }
            }
        }else
            return new Random().nextInt(4) + 1;
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


    public void onEnemyDeath(Enemy e){
        observers.remove(e);
        Position pos = e.pos;
        enemyList.remove(e);
        movingEnemyList.remove(e);
        gameMap.remove(e);
        gameMap.add(new Empty('.', pos));
    }

    public void onPlayerDeath(Player p){
        observers.remove(p);
        p.setTile('X');
        isGame = false;
    }

    @Override
    public void SignUp(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void NotifyObservers() {
        for (Observer o: observers) {
            o.notice();
        }
    }
}
