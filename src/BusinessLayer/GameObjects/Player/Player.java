package BusinessLayer.GameObjects.Player;

import BusinessLayer.GameObjects.Enemies.Enemy;
import BusinessLayer.GameObjects.Game_Tiles.Position;
import BusinessLayer.GameObjects.Game_Tiles.Unit;
import BusinessLayer.callbacks.MessageCallback;
import BusinessLayer.callbacks.PlayerDeathCallback;


public abstract class Player extends Unit implements HeroicUnit {
    public static final char PlayerTile = '@';
    protected static final int REQ_EXP = 50;
    protected static final int ATTACK_BONUS = 4;
    protected static final int DEFENSE_BONUS = 1;
    protected static final int HEALTH_BONUS = 10;

    protected int experience;
    protected int playerLevel;

    protected PlayerDeathCallback deathCallback;
    //protected InputProvider inputProvider;

    protected Player(String name, int healthCapacity, int attack, int defense) {
        super(PlayerTile, name, healthCapacity, attack, defense);
        this.experience = 0;
        this.playerLevel = 1;
    }

    // public Player initialize(Position position, MessageCallback messageCallback, PlayerDeathCallback playerDeathCallback, InputProvider inputProvider){
//        super.initialize(position, messageCallback);
//        this.deathCallback = playerDeathCallback;
//        this.inputProvider = inputProvider;
//    }
    @Override
    public String toString() {
        return alive() ? super.toString() : "X";
    }

    public void levelUp() {
        this.playerLevel++;
        this.experience = this.experience - REQ_EXP * this.playerLevel;
        this.healthPool = this.healthPool + HEALTH_BONUS * this.playerLevel;
        this.healthAmount = this.healthPool;

        int healthGained = gainHealth();
        int attackGained = gainAttack();
        int defenseGained = gainDefense();
        health.addCapacity(healthGained);
        health.restore();
        attackPoints += attackGained;
        defensePoints += defenseGained;
        messageCallback.send(String.format("%s reached level %d: +%d Health, +%d Attack, +%d Defense", getName(), getLevel(), healthGained, attackGained, defenseGained));
    }

    public int getLevel() {
        return playerLevel;
    }

    public int getExperience() {
        return experience;
    }

    protected int gainHealth() {
        return playerLevel * HEALTH_BONUS;
    }

    protected int gainAttack() {
        return playerLevel * ATTACK_BONUS;
    }

    protected int gainDefense() {
        return playerLevel * DEFENSE_BONUS;
    }

    private int levelUpRequirements() {
        return REQ_EXP * playerLevel;
    }

    public void accept(Unit unit) {
        unit.visit(this);
    }

    public void visit(Enemy enemy) {
        super.battle(enemy);
        if (!enemy.alive()) {
            switchPosition(enemy);
            onKill(enemy);
        }
    }

    public void visit(Player player) {

    }

//    public Action getAction(){
//        return getInputProvider().inputQuery().apply(this);
//    }

    protected void abilityDamage(Enemy enemy, int abilityDamage) {
        int damageDone = Math.max(abilityDamage - enemy.defend(), 0);
        enemy.getHealth().reduceAmount(damageDone);
        messageCallback.send(String.format("%s hit %s for %d ability damage.", getName(), enemy.getName(), damageDone));
    }

    protected void onKill(Enemy enemy) {
        int experienceGained = enemy.getExperienceValue();
        messageCallback.send(String.format("%s died. %s gained %d experience.", enemy.getName(), getName(), experienceGained));
        addExperience(experienceGained);
        enemy.onDeath();
    }

    @Override
    public void onDeath() {
        messageCallback.send("You lost.");
        deathCallback.call();
    }

    protected void addExperience(int experienceGained) {
        this.experience += experienceGained;
        int nextLevelReq = levelUpRequirements();
        while (experience >= nextLevelReq) {
            levelUp();
            experience -= nextLevelReq;
            nextLevelReq = levelUpRequirements();
        }
    }

    public String description() {
        return String.format("%s\t\tLevel: %d\t\tExperience: %d/%d", super.description(), getLevel(), getExperience(), levelUpRequirements());
    }

    public void moveRight() {
        System.out.println("Moved right");
    }

    public void moveDown() {
        System.out.println("Moved down");
    }

    public void moveLeft() {
        System.out.println("Moved left");
    }

    public void moveUp() {
        System.out.println("Moved Up");
    }

    public void castAbility() {
        System.out.println("Cast ability");
    }

    public void doNothing() {
        System.out.println("Do Nothing");
    }
}
