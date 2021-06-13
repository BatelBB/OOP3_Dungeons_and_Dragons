package BusinessLayer.Tiles;

import BusinessLayer.Interfaces.CallBack;

public class HunterAbility extends AbilityIMP{

    public HunterAbility(String name, String poolName, int amount) {
        super(name, poolName, 0);
        this.amount = amount;
    }

    @Override
    public boolean isAvailable() {
        return amount > 0;
    }

    @Override
    public void use() {
        amount--;
    }

    @Override
    public void onTick() {
        pool++;
    }

    @Override
    public void addAmount(int delta){
        super.addAmount(delta);
        pool = 0;
    }
}
