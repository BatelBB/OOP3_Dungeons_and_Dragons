package BusinessLayer.Tiles;

public class WarriorAbility extends AbilityIMP {

    public WarriorAbility(String name, String poolName, int pool){
        super(name, poolName, pool);
    }

    @Override
    public boolean isAvailable() {
        return this.amount > 0;
    }

    @Override
    public void reset() {
        this.amount = this.pool;
    }

}
