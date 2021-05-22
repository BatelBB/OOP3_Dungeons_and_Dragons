package BusinessLayer.GameObjects.Enemies;

import BusinessLayer.GameObjects.Player.HeroicUnit;
import BusinessLayer.GameObjects.Player.Player;


public class Boss extends Enemy implements HeroicUnit {
    public Integer visionRange;
    public Integer abilityFrequency; //how often the boss will cast the ability during combat, constructor argument.
    public Integer combatTicks; //how long the boss remained in combat, initially 0.

    public Boss(String name, char tile, int health, int attack, int defense, int visionRange, int experienceValue) {
        this.name = name;
        this.tile = tile;
        this.healthAmount = health;
        this.healthPool = health;
        this.attackPoints = attack;
        this.defensePoints = defense;
        this.visionRange = visionRange;
        this.experienceValue = experienceValue;
        combatTicks = 0;
    }

    @Override
    public void castAbility() {

    }


    public void monsterMove(Player player) {
        if (range(this, player) < visionRange) {
            if (combatTicks == abilityFrequency) {
                combatTicks = 0;
                castAbility();
            } else {
                combatTicks += 1;
                int dx = this.xPos - player.xPos;
                int dy = this.yPos - player.yPos;
                if (Math.abs(dx) > Math.abs(dy)) {
                    if (dx > 0)
                        moveLeft();
                    else
                        moveRight();
                } else if (dy > 0)
                    moveUp();
                else
                    moveDown();
            }

        } else {
            //Perform a random movement action: left, right, up, down or stay at the same place.
        }
    }

    private void moveDown() {
    }

    private void moveUp() {
    }


    private void moveLeft() {
    }

    private void moveRight() {
    }
}

