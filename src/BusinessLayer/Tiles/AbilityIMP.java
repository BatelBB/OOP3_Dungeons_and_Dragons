package BusinessLayer.Tiles;

public class AbilityIMP implements BusinessLayer.Interfaces.Ability {

    protected String name;
    protected String poolName;
    protected int pool;
    protected int amount;

    public AbilityIMP(String name, String poolName, int pool){
        this.name = name;
        this.poolName = poolName;
        this.pool = pool;
        this.reset();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPoolName() {
        return poolName;
    }

    @Override
    public boolean isAvailable() {
        return amount > 0;
    }

    @Override
    public void reset() {
        this.amount = this.pool;
    }

    @Override
    public void addToPool(int delta) {
        pool += delta;
    }

    @Override
    public int getAmount() {
        return amount;
    }

    @Override
    public int getPool() {
        return pool;
    }

    @Override
    public void addAmount(int delda) {
        amount += delda;
    }

}
