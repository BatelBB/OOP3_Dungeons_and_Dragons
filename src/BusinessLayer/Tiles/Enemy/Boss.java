package BusinessLayer.Tiles.Enemy;

import BusinessLayer.Interfaces.HeroicUnit;
import BusinessLayer.Tiles.Player.Player;
import BusinessLayer.Tiles.Unit;

public class Boss extends Enemy implements HeroicUnit {
    private int abilityFreq;
    private int combatTicks;

    public Boss(char tile, String name,  int health, int attack, int defense, int experienceValue, int  visionRange, int abilityFreq) {
        super(tile, name, health, attack, defense, visionRange, experienceValue);
        this.abilityFreq = abilityFreq;
        this.combatTicks = 0;
    }

    @Override
    public void accept(Enemy enemy) {

    }

    @Override
    public void accept(Player player) {
        player.battle(this);
    }

    @Override
    public void accept(Unit unit) {
        unit.visit(this);
    }

    @Override
    public void visit(Enemy e) {

    }

    @Override
    public void visit(Player player) {
        super.battle(player);
        if(!player.alive()){
            swichPos(player);
            player.died();
        }
    }

    @Override
    public String description() {
        return super.description();
    }

    @Override
    public boolean checkHeroic() {
        if(combatTicks == abilityFreq){
            combatTicks=0;
            castSpecialAbility();
            return true;
        }else{
            combatTicks++;
            return false;
        }

    }

    @Override
    public void castSpecialAbility() {

    }
}
