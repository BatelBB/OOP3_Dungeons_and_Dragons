package BusinessLayer.Tiles.Player.Ability;

import BusinessLayer.Tiles.Player.Ability.AbilityIMP;

public class WarriorAbility extends AbilityIMP {

    public WarriorAbility(String name, String poolName, int pool){
        super(name, poolName, pool);
        amount = 0;
    }

    @Override
    public boolean isAvailable() {
        return this.amount == 0;
    }

    @Override
    public void reset() {
        this.amount = pool;
    }

    @Override
    public void addToPool(int delta) {

    }

    @Override
    //should only be 1
    public void addAmount(int delda) {
        amount += 1;
    }

    @Override
    public void onTick() {
        amount -= 1;
    }

    @Override
    public void use() {
        super.use();
        this.amount = pool;
    }
}
