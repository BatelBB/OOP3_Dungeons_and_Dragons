import BusinessLayer.GameObjects.Enemies.Monster;
import BusinessLayer.GameObjects.Enemies.Trap;
import BusinessLayer.GameObjects.Player.Hunter;
import BusinessLayer.GameObjects.Player.Mage;
import BusinessLayer.GameObjects.Player.Rogue;
import BusinessLayer.GameObjects.Player.Warrior;

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
        Monster giantWright = new Monster("Giant-Wright",'g', 1500, 100, 40, 5, 500);
        Monster whiteWalker = new Monster("White Walker", 'w', 2000, 150, 50, 6, 1000);
        Monster theMountain = new Monster("The Mountain", 'M', 1000, 60, 25, 6, 500);
        Monster queenCersei = new Monster("Queen Cersei",'C', 100, 10, 10, 1,1000);
        Monster nightsKing = new Monster("Night's King", 'K', 5000, 300, 150, 8, 5000);

        Trap bonusTrap = new Trap("Bonus Trap", 'B', 1, 1, 1, 250, 1, 5);
        Trap queensTrap =new Trap("Queen's Trap", 'Q', 250, 50, 10, 100, 3, 7);
        Trap deathTrap = new Trap("Death Trap", 'D', 500, 100, 20, 250, 1, 10);

        Hunter ygritte = new Hunter("Ygritte", 220, 30, 2, 6);
    }
}
