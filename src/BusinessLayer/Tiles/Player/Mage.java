package BusinessLayer.Tiles.Player;

import BusinessLayer.Tiles.Enemy.Enemy;
import BusinessLayer.Tiles.MageAbility;
import BusinessLayer.Tiles.Resource;

import java.lang.reflect.Field;
import java.util.List;

public class Mage extends Player {
    private int spellPower;
    //private
    private MageAbility ability;
    private final String ABILITYNAME = "Blizzard";
    private final String ABILITYPOOLNAME = "Mana";
    private int range;
    private int hitCount;

    public Mage(String name, int health, int attack, int def, int manaPool, int manaCost, int spellPower, int hitCount, int range) {
        super(name, health, attack, def);
        this.ability = new MageAbility(ABILITYNAME, ABILITYPOOLNAME, manaPool, manaCost);
        this.range = range;
        this.hitCount = hitCount;
        this.spellPower = spellPower;
    }

    @Override
    public void onAbilityCast(List<Enemy> enemies) {
        if(!ability.isAvailable())
            messanger.sendMessage(String.format("%s tried to cast %s, but there was not enough %s: %d/%d",
                    this.getName(), ability.getName(), ability.getPoolName(),ability.getAmount(), ability.getPool()));
        else {
            int hits = 0;
            while (hits < hitCount && !enemies.isEmpty()){
                int i = pickRandom(enemies.size());
                abilityAttack(enemies.get(i));

                if(!enemies.get(i).alive())
                    enemies.remove(enemies.get(i));

                hits--;
            }

            ability.use();
        }
    }

    @Override
    protected int getAbilityDamage() {
        return spellPower;
    }

    @Override
    public int getRange() {
        return range;
    }

    public void onTick(){
        abilityTick();
    }

    @Override
    public void abilityTick() {
        ability.setAmount(Math.min(ability.getPool(), ability.getAmount() + playerLevel));
    }

    @Override
    public String description() {
        return null;
    }

    @Override
    public void levelUp(){
        super.levelUp();
        ability.addToPool(25*playerLevel);
        ability.setAmount(Math.min(ability.getAmount() + (int)(0.25*ability.getPool()), ability.getPool()));
    }

    @Override
    public void accept(Enemy enemy) {

    }

    @Override
    public void accept(Player player) {

    }

}
