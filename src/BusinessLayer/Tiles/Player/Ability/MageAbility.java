package BusinessLayer.Tiles.Player.Ability;


public class MageAbility extends AbilityIMP {

    private int cost;

    public MageAbility(String name, String poolName, int pool, int cost) {
        super(name, poolName, pool);
        this.cost = cost;
    }

    @Override
    public boolean isAvailable() {
        return amount >= cost;
    }

    @Override
    public void onTick() {
        throw new IllegalArgumentException("cant use");
    }

    @Override
    public void use() {
        super.use();
        amount -= cost;
    }
}
