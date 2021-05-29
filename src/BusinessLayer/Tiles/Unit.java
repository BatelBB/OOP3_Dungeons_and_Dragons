package BusinessLayer.Tiles;

import BusinessLayer.Position;
import BusinessLayer.Tile;
import BusinessLayer.Tiles.Enemy.Enemy;
import BusinessLayer.Tiles.Player.Player;

public abstract class Unit extends Tile {
    public String name;

    public Resource health;

    public int attackPoints;
    public int defensePoints;

    public Unit(Character c, String name, Resource health, int attackPoints, int defensePoints) {
        super(c);
        this.name = name;
        this.health = health;
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
    }

    public String getName() {
        return name;
    }

    @Override
    public void visit(Wall w) { }

    @Override
    public void visit(Empty emp) {
        swichPos(emp);
    }

    protected void swichPos(Tile t){
        Position tmp = t.getPos();
        t.setPos(this.getPos());
        this.setPos(tmp);
    }

    @Override
    public abstract void visit(Enemy e);
    @Override
    public abstract void visit(Player player);

    protected void battle(Unit u){

    }

    public void interact(Tile t){
        t.accept(this);
    }

    public boolean alive(){
        return health.getAmount() >= 0;
    }

}
