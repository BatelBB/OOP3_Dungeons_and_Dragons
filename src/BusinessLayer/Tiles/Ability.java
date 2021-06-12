package BusinessLayer.Tiles;

public class Ability implements BusinessLayer.Interfaces.Ability {

    private String name;
    private String poolName;
    private int pool;
    private int amount;

    public Ability(String name, String poolName, int pool, int addAmount){
        this.name = name;
        this.poolName = poolName;
        this.pool = pool;
        this.fill();
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
    public void fill() {
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
}
