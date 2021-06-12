package BusinessLayer.Tiles.Player;
import BusinessLayer.Interfaces.Visitor;
import BusinessLayer.Tiles.Empty;
import BusinessLayer.Tiles.Enemy.Enemy;
import BusinessLayer.Tiles.Resource;
import BusinessLayer.Tiles.Unit;
import BusinessLayer.Tiles.Wall;

import java.util.List;
import java.util.Random;

public abstract class Player extends Unit {
    protected int experience = 0;
    protected int playerLevel = 1;

    protected static final int LEVEL_UP_EXP = 50;

    public Player(Character c, String name, Resource health, int attack, int def) {
        super(c, name, health, attack, def);
        experience = 0;
        playerLevel = 1;
    }


    public int getExperience(){
        return experience;
    }

    public int getPlayerLevel() {
        return playerLevel;
    }

    public void setExperience(int expGain){
        experience += expGain;
        if(experience >= LEVEL_UP_EXP * playerLevel)
            levelUp();
    }

    public void levelUp(){
        experience -= LEVEL_UP_EXP * 50;

        messanger.sendMessage(String.format("%s reached level %d: +%d Health, +%d Attack, +%d Defense", this.name, this.getPlayerLevel()+1, 10*playerLevel,
                4*playerLevel, playerLevel));

        health.addToPool(10*playerLevel);
        health.fill();

        attackPoints += 4*playerLevel;
        defensePoints += playerLevel;

        playerLevel ++;
    }

    public void accept(Unit u){
        u.visit(this);
    }

    public void visit(Enemy e){
        super.battle(e);
        if(!e.alive()){
            swichPos(e);
            onKill(e);
            e.onDeath();
        }
    }

    @Override
    public void visit(Player player) {

    }

    private void onKill(Enemy e){
        setExperience(e.getExperienceValue());
    }


    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
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
        messanger.sendMessage(String.format("%s dealt %d damage to %s", this.getName(), dmgDealt, e.getName()));
        e.health.addAmount(-dmgDealt);
    }

    public abstract int getRange();

}

