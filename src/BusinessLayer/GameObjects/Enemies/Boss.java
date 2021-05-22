package BusinessLayer.GameObjects.Enemies;

import BusinessLayer.GameObjects.Player.HeroicUnit;


public class Boss extends Enemy implements HeroicUnit {
    public Integer visionRange;
    public Integer abilityFrequency;
    public Integer combatTicks;


    @Override
    public void castAbility() {

    }
}
