package BusinessLayer.Tiles;

public abstract class AbilityIMP implements BusinessLayer.Interfaces.Ability {

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
    public abstract boolean isAvailable();
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
    public void addAmount(int delta) {
        amount += delta;
    }

    @Override
    public void onTick() {

    }

    @Override
    public void setAmount(int newAmount) {
        if(newAmount > pool)
            amount = pool;
        else
            amount = newAmount;
    }

    @Override
    public abstract void use();


    public String toString(){
        return getAmount() + "/" +getPool();
    }
}
