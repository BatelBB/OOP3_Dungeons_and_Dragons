package BusinessLayer;

import BusinessLayer.Tiles.Player.Player;

public class GameController {
    Board board;

    public void passInput(String input){

    }

    public void start(char[][] map){
        board = new Board(map);
    }

    private void update(){

    }
}
