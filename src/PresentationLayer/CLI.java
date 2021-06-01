package PresentationLayer;

import java.util.Scanner;

public class CLI {
    Scanner s;
    public char input;

    public CLI() {
        s = new Scanner(System.in);
    }

    public void drawBoard(char[][] b) {
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++)
                System.out.print(b[i][j]);
            System.out.println();
        }
    }

    public void printPlayerStats(String ps) {
        System.out.println(ps);
    }

    public void printCombatInfo(String ci) {
        System.out.println(ci);
    }

    public void lvlUpNotify(String notification) {
        System.out.println(notification);
    }

    public void setInput() {
        char ch = s.next().charAt(0);
        if (ch == 'd' || ch == 'q' || ch == 'w' || ch == 'a' || ch == 's' || ch == 'e')
            input = ch;
    }

    public char getInput() {
        return input;
    }

    public char getInput(String msg) {
        System.out.println(msg);
        return s.next().charAt(0);
    }
}
