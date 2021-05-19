package Player;

public class Mage implements Player, HeroicUnit{
    public Integer manaPool;
    public Integer currentMana;
    public Integer manaCost;
    public Integer spellPower;
    public Integer hitCount;
    public Integer abilityRange;

    public Mage(String name, int health, int attack, int defense, int manaPool, int manaCost, int spellPower, int hitCount, int range){

    }

    @Override
    public void castAbility() {

    }
}
