package BusinessLayer.Tiles;

public class RougueAbility extends AbilityIMP {
    private int cost;
    public RougueAbility(String name, String poolName, int pool, int cost){
        super(name, poolName, pool);
        this.cost = cost;
    }

    @Override
    public boolean isAvailable() {
        return amount >= cost;
    }

    @Override
    public void onTick() {
        setAmount(Math.min(amount+10, 100));
    }

    @Override
    public void use() {
        super.use();
        amount -= cost;
    }

}
