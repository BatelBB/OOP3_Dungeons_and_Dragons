package BusinessLayer.Interfaces;

public interface Ability {
    public String getName();
    public String getPoolName();

    public boolean isAvailable();
    public void fill();
    public void addToPool();
    public int getAmount();
    public int getPool();


}
