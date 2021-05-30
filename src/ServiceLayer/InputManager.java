package ServiceLayer;

import BusinessLayer.GameObjects.Game_Tiles.Tile;
import PresentationLayer.CLI;

import java.util.Iterator;
import java.util.LinkedList;

public class InputManager {
    CLI cli;

    public InputManager(){
        cli = new CLI();
    }

    public char getInput(){
        return cli.getInput();
    }

    public char getInput(String msg){
        return cli.getInput(msg);
    }

    public void updateCLI(LinkedList<Tile> b, int w, int h){
        char[][] map = new char[h][w];
        Iterator<Tile> iter = b.iterator();

        while (iter.hasNext()) {
            Tile t = iter.next();
            map[t.getPosition().getYPos()][t.getPosition().getxPos()] = t.toString().charAt(0);
        }

        cli.drawBoard(map);
        cli.getInput();
    }

}
