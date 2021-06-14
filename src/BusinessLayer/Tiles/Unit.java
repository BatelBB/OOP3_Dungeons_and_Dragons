package BusinessLayer.Tiles;

import BusinessLayer.Messenger;
import BusinessLayer.Position;
import BusinessLayer.Tile;
import BusinessLayer.Tiles.Enemy.Enemy;
import BusinessLayer.Tiles.Player.Player;

import javax.annotation.processing.Messager;
import java.util.Random;

public abstract class Unit extends Tile {
    public String name;

    public Resource health;

    public int attackPoints;
    public int defensePoints;

    public Messenger messanger;

    public Unit(Character c, String name, int health, int attackPoints, int defensePoints) {
        super(c);
        this.name = name;
        this.health = new Resource("Health", health);
        this.attackPoints = attackPoints;
        this.defensePoints = defensePoints;
        this.messanger = new Messenger();
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



    public void interact(Tile t){
        t.accept(this);
    }

    public boolean alive(){
        return health.getAmount() >= 0;
    }


    protected void battle(Unit u){
        messanger.sendMessage(String.format("%s engaged in combat with %s", this.name, u.name));
        messanger.sendMessage((this.description()));
        messanger.sendMessage((u.description()));

        int atk = this.attack();
        int def = u.defend();

        if(atk < def)
            def = atk;

        u.health.addAmount(-(atk - def));
        messanger.sendMessage(String.format("%s dealt %d damage to %s", this.name, (atk-def), u.name));
    }

    private int attack(){
        Random rnd = new Random();
        int atk = rnd.nextInt(this.attackPoints + 1);
        messanger.sendMessage(String.format("%s rolled %d attack points", this.name, atk));
        return atk;
    }

    public int defend(){
        Random rnd = new Random();
        int def = rnd.nextInt(this.defensePoints + 1);
        messanger.sendMessage(String.format("%s rolled %d defence points", this.name, def));
        return def;
    }

    public String name(){
        return name;
    }

    public abstract String description();
}
