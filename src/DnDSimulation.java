import Enemies.Monster;
import Enemies.Trap;
import Player.Mage;
import Player.Rogue;
import Player.Warrior;

public class DnDSimulation {
    public static void main(String[] args) {
        Warrior jonSnow = new Warrior("Jon Snow", 300, 30, 4, 3);
        Warrior theHound = new Warrior("The Hound", 400, 20, 6, 5);

        Mage melisandra = new Mage("Melisandra", 100, 5, 1, 300, 30, 15, 5, 6);
        Mage thorosOfMyr = new Mage("Thoros of Myr", 250, 25, 4, 150, 20, 20, 3, 4);

        Rogue aryaStark = new Rogue("Arya Stark", 150, 40, 2, 20);
        Rogue bronn = new Rogue("Bronn", 250, 35, 3, 50);

        Monster lannisterSoldier = new Monster("Lannister Soldier", 's', 80, 8, 3, 3, 25);
        Monster lannisterKnight = new Monster("Lannister Knight", 'k', 200, 14, 8, 4, 50);
        Monster queensGuard = new Monster("Queen's Guard", 'q', 400, 20, 15, 5, 100);
        Monster wright = new Monster("Wright", 'z', 600, 30, 15, 3, 100);
        Monster bearWright = new Monster("Bear-Wright", 'b', 1000, 75, 30, 4, 250);
        Monster giantWright;
        Monster whiteWalker;
        Monster theMountain;
        Monster queenCersei;
        Monster nightsKing;

        Trap bonusTrap;
        Trap queensTrap;
        Trap deathTrap;
    }
}
