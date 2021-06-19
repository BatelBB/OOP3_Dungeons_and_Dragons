package BusinessLayer.Tiles.Player;
import BusinessLayer.Interfaces.CallBacks.PlayerDeathCallBack;
import BusinessLayer.Tiles.Enemy.Enemy;
import BusinessLayer.Tiles.Unit;

import java.util.List;
import java.util.Random;

public abstract class Player extends Unit {
    protected int experience = 0;
    protected int playerLevel = 1;

    protected static final int LEVEL_UP_EXP = 50;
    protected PlayerDeathCallBack playerDeathCallBack;


    public Player(String name, int health, int attack, int def) {
        super('@', name, health, attack, def);
        experience = 0;
        playerLevel = 1;
    }

    @Override
    public String description() {
        String tab = "\t";
        return name + tab + health.toString() + tab + "Attack: " + attackPoints + tab +
                "Defense: " + defensePoints + tab + "Level: " + playerLevel + tab +
                "Experience: " + experience + "/" + LEVEL_UP_EXP*playerLevel + tab;
    }
    public int getExperience(){
        return experience;
    }

    public int getPlayerLevel() {
        return playerLevel;
    }

    public int getAttackPoints() {
        return attackPoints;
    }
    public int getDefensePoints(){
        return defensePoints;
    }
    public int getHealthAmount(){
        return health.getAmount();
    }
    public abstract int getAbilityAmount();

    public void setExperience(int expGain){
        experience += expGain;
        while(experience >= LEVEL_UP_EXP * playerLevel)
            levelUp();
    }

    public void levelUp(){
        experience -= LEVEL_UP_EXP * playerLevel;
        playerLevel ++;
        messanger.sendMessage(String.format("%s reached level %d: +%d Health, +%d Attack, +%d Defense",
                this.name, this.getPlayerLevel(), 10*playerLevel,
                4*playerLevel, 2*playerLevel));

        health.addToPool(10*playerLevel);
        health.fill();

        attackPoints += 4*playerLevel;
        defensePoints = defensePoints + playerLevel;


    }

    public void accept(Unit u){
        u.visit(this);
    }

    public void visit(Enemy e){
        super.battle(e);
        if(!e.alive()){
            swichPos(e);
            onKill(e);
        }
    }

    @Override
    public void visit(Player player) {

    }

    private void onKill(Enemy e){
        e.onDeath();
        setExperience(e.getExperienceValue());
        messanger.sendMessage(String.format("%s died. %s gained %s experience.", e.getName(), this.getName(), e.getExperienceValue()));
    }


    @Override
    public void accept(Enemy enemy) {
        enemy.visit(this);
    }

    public abstract void onAbilityCast(List<Enemy> enemies);

    protected int pickRandom(int range){
        Random rnd = new Random();
        return rnd.nextInt(range);
    }

    protected abstract int getAbilityDamage();

    protected void abilityAttack(Enemy e){
        int defense = e.defend();
        int dmgDealt=Math.max(0,this.getAbilityDamage()- defense);
        messanger.sendMessage(String.format("%s hit %s for %d ability damage.", this.getName(), e.getName(), dmgDealt));
        e.health.addAmount(-dmgDealt);
        if(!e.alive())
            onKill(e);
    }

    public abstract int getRange();

    public void onTick(){
        abilityTick();
    }

    public abstract void abilityTick();

    public void died(){
        playerDeathCallBack.call();
        messanger.sendMessage("You lost.");
    }

    public void setPlayerDeathCallBack(PlayerDeathCallBack playerDeathCallBack){
        this.playerDeathCallBack = playerDeathCallBack;
    }
}

