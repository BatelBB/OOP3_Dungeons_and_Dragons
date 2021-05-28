import BusinessLayer.GameObjects.Enemies.Boss;
import BusinessLayer.GameObjects.Enemies.Monster;
import BusinessLayer.GameObjects.Enemies.Trap;
import BusinessLayer.GameObjects.Player.Hunter;
import BusinessLayer.GameObjects.Player.Mage;
import BusinessLayer.GameObjects.Player.Rogue;
import BusinessLayer.GameObjects.Player.Warrior;
import UI.Game;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DnDSimulation {
    public static void main(String[] args) {
        new Game(args[0]);
    }
}
