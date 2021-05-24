package UI;

import BusinessLayer.GameController;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    File[] levels;
    String levelPath;
    GameController gc;
    List<String> map;
    int player;
    int nextLevel;
    int currentLevel;
    boolean isGame;

    public Game(){

        currentLevel = 0;
        nextLevel = 0;
        levelPath = System.getProperty("user.dir") + "\\out\\production\\Dungeons and Dragons\\levels_dir";
        levels = new File(levelPath).listFiles();
        start();

    }

    public void start(){
        Scanner scanner = new Scanner(System.in);
        map = loadLevel(nextLevel);
        System.out.println("choose class");
        player = scanner.nextInt();

        gc = new GameController(map, player);

        draw(map);
        isGame = true;
        update();
    }

    public void update(){

        while(isGame) {
            char input = getInput();
            gc.play(input);
        }
    }

    public void draw(List<String> drawMap){
        for (String line: drawMap) {
            System.out.println(line);
        }
    }

    public char getInput(){
        /////need to make
        return 'a';
    }



    private List<String> loadLevel(int level) {
        String path = System.getProperty("user.dir") + "levels_dir" + "level1";
        List<String> lines = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(levels[0]));
            String next;
            while ((next = reader.readLine()) != null) {
                lines.add(next);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + path);
        } catch (IOException e) {
            System.out.println(e.getMessage() + "\n" + e.getStackTrace());
        }
        return lines;
    }
}
