package BusinessLayer.GameObjects.Enemies;

import BusinessLayer.GameObjects.Player.HeroicUnit;

public class Boss implements Enemy, HeroicUnit {
    public Integer visionRange;
    public Integer abilityFrequency;
    public Integer combatTicks;


    @Override
    public void castAbility() {

    }
}
