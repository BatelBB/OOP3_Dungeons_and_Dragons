package BusinessLayer.Interfaces;

public interface Ability {
    public String getName();
    public String getPoolName();

    public boolean isAvailable();
    public void reset();
    public void addToPool(int delta);
    public int getAmount();
    public int getPool();
    public void addAmount(int delda);
    public void onTick();
    public void setAmount(int newAmount);
    public void use();
}
