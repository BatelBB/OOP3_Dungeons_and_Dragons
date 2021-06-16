package ServiceLayer;

import BusinessLayer.Board;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LevelManager {
    private boolean isLevel;
    private int level;
    private File[] levelsDir;
    List<File> levels;
    private Board b;
    private boolean keepGoing;

    public LevelManager(String levelsDirPath){
        keepGoing = true;
        this.level = 1;
        getLevels(levelsDirPath);
        start();
    }

    private void getLevels(String levelsDirPath){
        levelsDir = new File(levelsDirPath).listFiles();
        levels  = new ArrayList<>();

        for (File lvl : levelsDir) {
            if (lvl.getName().contains("level"))
                levels.add(lvl);
        }
    }

    public char[][] loadNextLevel(){
        List<String> lines = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(levels.get(level-1)));
            String next;
            while ((next = reader.readLine()) != null) {
                lines.add(next);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found " + levels.get(level));
        } catch (IOException e) {
            System.out.println(e.getMessage() + "\n" + e.getStackTrace());
        }

        char[][] map = new char[lines.size()][lines.get(0).length()];
        for (int i = 0; i < lines.size(); i++) {
            String s = lines.get(i);
            for (int j = 0; j < s.length(); j++) {
                map[i][j] = s.charAt(j);
            }
        }

        return map;
    }

    private void start(){
        b = new Board();
        update();
    }

    private void update(){
        while (keepGoing) {
            try {
                char[][] lvl = loadNextLevel();
                b.startLevel(lvl, level);
                level++;
            } catch (Exception e) {
                keepGoing = false;
                new InputManager().showMessage("You Won!");
            }
        }

    }

}
