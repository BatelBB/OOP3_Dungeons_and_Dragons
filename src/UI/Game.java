package UI;

import BusinessLayer.GameController;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {
    File[] files;
    List<File> levels = new ArrayList<>();
    String levelPath;
    GameController gc;
    List<String> map;
    int player;
    int nextLevel;
    int currentLevel;
    boolean isGame;

    public Game(String levelsPath){
        currentLevel = 0;
        nextLevel = 0;
        files = new File(levelsPath).listFiles();
        for (File file : files) {
            if (file.getName().contains("level"))
                levels.add(file);
        }
        start();
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);
        map = loadLevel(nextLevel);
        gc = new GameController(map);
        System.out.println("Select Player:");
        int playerHasSize = gc.playerHashMap.size();
        int playerNum = 1;
        for(int i = 0; i<playerHasSize; i++) {
            System.out.println(playerNum + ". "+ gc.playerHashMap.get(playerNum).toString());
            playerNum++;
        }
        //player = scanner.nextInt();
        gc.setPlayer(scanner.nextInt());
        //gc = new GameController(map, player);

        draw(map);
        isGame = true;
        update();
    }

    public void update(){
        Scanner scanner = new Scanner(System.in);
        char ch;
        while(scanner.hasNext()) {
            while (isGame) {
                //char input = getInput();
                ch = scanner.next().charAt(0);
                if(ch=='d' || ch == 'q'|| ch == 'w'|| ch == 'a'|| ch == 's'|| ch == 'e')
                    gc.play(ch);
            }
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
        //String path = System.getProperty("user.dir") + "levels_dir" + "level1";
        List<String> lines = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(levels.get(level)));
            String next;
            while ((next = reader.readLine()) != null) {
                lines.add(next);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + levels.get(level));
        } catch (IOException e) {
            System.out.println(e.getMessage() + "\n" + e.getStackTrace());
        }
        return lines;
    }
}
