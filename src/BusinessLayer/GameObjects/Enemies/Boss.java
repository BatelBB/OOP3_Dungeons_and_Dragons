package BusinessLayer.GameObjects.Enemies;

import BusinessLayer.GameObjects.Player.HeroicUnit;
import BusinessLayer.GameObjects.Player.Player;


public class Boss extends Enemy implements HeroicUnit {
    public Integer visionRange;
    public Integer abilityFrequency; //how often the boss will cast the ability during combat, constructor argument.
    public Integer combatTicks; //how long the boss remained in combat, initially 0.

    public Boss(String name, char tile, int health, int attack, int defense, int visionRange, int experienceValue) {
        super(tile, name, health, attack, defense);
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
        //The boss cast the ability: shooting at the player for an amount equals to the boss
        //attack points if the player is within vision range (the player will try to defend itself).
    }


    public void monsterMove(Player player) {
        if (getPosition().range(this, player) < visionRange) {
            if (combatTicks == abilityFrequency) {
                combatTicks = 0;
                castAbility();
            } else {
                combatTicks += 1;
                int dx = this.getPosition().xPos - player.getPosition().xPos;
                int dy = this.getPosition().yPos - player.getPosition().yPos;
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

    @Override
    public void onDeath() {

    }

    @Override
    public void processStep() {

    }
}

