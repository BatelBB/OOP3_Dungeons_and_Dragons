package BusinessLayer.Tiles.Player;
import BusinessLayer.Interfaces.Visitor;
import BusinessLayer.Tiles.Empty;
import BusinessLayer.Tiles.Enemy.Enemy;
import BusinessLayer.Tiles.Resource;
import BusinessLayer.Tiles.Unit;
import BusinessLayer.Tiles.Wall;

public class Player extends Unit {
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

    }
}

