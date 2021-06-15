package BusinessLayer;

import BusinessLayer.Interfaces.EnemyDeathCallback;
import BusinessLayer.Tiles.*;
import BusinessLayer.Tiles.Enemy.Enemy;
import BusinessLayer.Tiles.Enemy.Monster;
import BusinessLayer.Tiles.Player.*;
import ServiceLayer.InputManager;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Board /*implements EnemyDeathCallback*/ {
    InputManager im;
    public boolean isGame;

    private LinkedList<Tile> gameMap;
    private char chosenPlayer;

    private LinkedList<Enemy> enemyList;
    private Player player;

    private int height;
    private int width;

    private TileFactory tileFactory;



    public Board(){

        im = new InputManager();

        chosenPlayer = im.getInput("choose wisely");


    }

    public void startLevel(char[][] map, int level){
        im.showMessage(String.format("Level %d", level));
        tileFactory = new TileFactory();
        isGame = true;
        height = map.length;
        width = map[0].length;

        enemyList = new LinkedList<>();
        gameMap = new LinkedList<>();

        initMap(map);

        update();
    }

    private void initMap(char[][] map){
        for (int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                if(map[i][j] == '@') {
                    player = tileFactory.getPlayer(chosenPlayer);
                    gameMap.add(player);
                    player.init(new Position(j,i));
                    player.setPlayerDeathCallBack(() -> this.onPlayerDeath(player));
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
                }
            }
        }
    }

    public void update(){
        while (isGame) {
            im.updateCLI(gameMap, width, height);
            playerGo(im.getInput());
            enemiesGo();

            //after all updates
            im.updateCLI(gameMap, width, height);

            if(enemyList.isEmpty()){
                isGame = false;
            }
        }
     }

     private void enemiesGo(){
         for (Enemy e: enemyList) {
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
            double xDiff = e.pos.getxPos() - player.pos.getxPos();
            double yDiff = e.pos.getyPos() - player.pos.getyPos();

            if(Math.abs(xDiff) > Math.abs(yDiff)){
                if(xDiff < 0)
                    return 4;
                return 3;
            }
            else {
                if (yDiff < 0)
                    return 2;
                return 1;
            }
        }
        else
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

    public void onPlayerDeath(Player p){
        p.setTile('X');
        isGame = false;
    }

}
