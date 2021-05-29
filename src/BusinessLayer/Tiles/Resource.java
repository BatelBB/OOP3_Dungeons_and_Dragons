package BusinessLayer.Tiles;

public class Resource {
    private int pool;
    private int amount;
    private String name;

    public Resource(String name, int p){
        pool = p;
        fill();
        this.name = name;
    }

    public int getAmount() { return amount; }

    public int getPool() { return pool; }

    public void addAmount(int da) {
        this.amount += da;
        if(amount > pool)
            amount = pool;
    }

    public void addToPool(int dp) { this.pool += dp; }

    public void fill(){ amount = pool; }

    public String getName() { return name; }

    public String toString(){
        return name + ": " + amount + "/" + pool;
    }
}
