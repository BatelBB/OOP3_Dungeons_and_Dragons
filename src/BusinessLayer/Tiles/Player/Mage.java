package BusinessLayer.Tiles.Player;

import BusinessLayer.Tiles.Enemy.Enemy;
import BusinessLayer.Tiles.Player.Ability.MageAbility;
import java.util.List;

public class Mage extends Player {
    private int spellPower;
    private MageAbility ability;
    private final String ABILITYNAME = "Blizzard";
    private final String ABILITYPOOLNAME = "Mana";
    private int range;
    private int hitCount;

    private final int ABILITY_POOL = 25;
    private final double ABILITY_PRECENT = 0.25;

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
            messanger.sendMessage(String.format("%s cast %s.",this.getName(), ability.getName()));
            while (hits < hitCount && !enemies.isEmpty()){
                int i = pickRandom(enemies.size());
                abilityAttack(enemies.get(i));

                if(!enemies.get(i).alive())
                    enemies.remove(enemies.get(i));

                hits++;
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

    private int getSpellPower(){
        return spellPower;
    }

    public void onTick(){
        abilityTick();
    }

    @Override
    public void abilityTick() {
        if(ability.isUsedThisTurn())
            ability.isUsed = false;
        else
            ability.setAmount(Math.min(ability.getPool(), ability.getAmount() + playerLevel));
    }

    @Override
    public String description() {
        return super.description() +"\tMana: " + ability.toString() + "\tSpell Power: " + getSpellPower();
    }

    @Override
    public int getAbilityAmount() {
        return ability.getAmount();
    }

    @Override
    public void levelUp(){
        super.levelUp();
        ability.addToPool(ABILITY_POOL*playerLevel);
        ability.setAmount(Math.min(ability.getAmount() + (int)(ABILITY_PRECENT*ability.getPool()), ability.getPool()));
    }

    @Override
    public void accept(Enemy enemy) {

    }

    @Override
    public void accept(Player player) {

    }

}
