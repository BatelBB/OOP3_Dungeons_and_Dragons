package BusinessLayer.Tiles.Player;

import BusinessLayer.Tiles.Enemy.Enemy;
import BusinessLayer.Tiles.Resource;

import java.security.SecureRandomSpi;
import java.util.List;
import java.util.Random;

public class Warrior extends Player {

    private Resource coolDown;

    public Warrior(char c, String name, Resource health, int attack, int defense, int coolDownPool){
        super(c, name, health, attack, defense);
        coolDown = new Resource("Cooldown", coolDownPool);
    }

    public String description(){
        String tab = "\t";
        return name + tab + health.toString() + tab + "Attack: " + attackPoints + tab +
                "Defence: " + defensePoints + tab + "Level: " + playerLevel + tab +
                "Experience: " + experience + "/" + LEVEL_UP_EXP*playerLevel + tab +
                coolDown.toString();
    }

    public void onAbilityCast(List<Enemy> enemies){
        Random rnd = new Random();
        //int i =
    }

}
