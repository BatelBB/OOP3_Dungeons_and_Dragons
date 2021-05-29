package BusinessLayer.GameObjects.Game_Tiles;

import BusinessLayer.GameObjects.Enemies.Enemy;
import BusinessLayer.GameObjects.Player.Player;
import BusinessLayer.Utils.Resource;
import BusinessLayer.callbacks.MessageCallback;

import java.util.Random;

public abstract class Unit extends Tile {
//    protected static Map<Position, Function<Unit, Movement>> movementMap = new HashMap<Position, Function<Unit, Movement>>(){
//        {
//            put(Position.Up, Movement.Up::new);
//            put(Position.Down, Movement.Down::new);
//            put(Position.Right, Movement.Right::new);
//            put(Position.Left, Movement.Left::new);
//            put(Position.NoOperation, Movement.NoOperation::new);
//        }
//    };

    protected static Random random = new Random(123);

    protected String name;
    protected int healthPool;
    protected int healthAmount;
    protected int attackPoints;
    protected int defensePoints;
    protected Resource health;

    protected MessageCallback messageCallback;

    protected Unit(char tile, String name, int healthCapacity, int attack, int defense) {
        super(tile);
        this.tile = tile;
        this.name = name;
        this.health = new Resource(healthCapacity, healthCapacity);
        this.attackPoints = attack;
        this.defensePoints = defense;
    }

    protected void initialize(Position position, MessageCallback messageCallback) {
        super.initialize(position);
        this.messageCallback = messageCallback;
    }

    public abstract void onDeath();
    @Override
    public void accept(Unit unit) {

    }

    // Returns the name of the unit. Use it to print the names upon combat engagement on ability cast.
    public String getName() {
        return name;
    }

    public Resource getHealth() {
        return health;
    }

    public int getAttack() {
        return attackPoints;
    }

    public int getDefense() {
        return defensePoints;
    }

    // String, returns full information of the current unit,  String, returns full information of the current unit
    public String description() {
        return String.format("%s\t\tHealth: %s\t\tAttack: %d\t\tDefense: %d", getName(), getHealth(), getAttack(), getDefense());

    }

    public boolean alive() {
        return getHealth().getAmount()>0;
    }

    protected int attack() {
        int result = random.nextInt(attackPoints);
        messageCallback.send(String.format("%s rolled %attack points.", getName(), result));
        return result;
    }

    public int defend() {
        int result = random.nextInt(defensePoints);
        messageCallback.send(String.format("%s rolled %defense points.", getName(), result));
        return result;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void visit(Wall wall) {
    }

    @Override
    public void visit(Player player) {

    }

    @Override
    public void visit(Enemy enemy) {

    }

    @Override
    public void visit(Unit unit) {

    }

    @Override
    public void visit(Empty empty) {
        switchPosition(empty);
    }

    protected void switchPosition(Tile tile) {
        Position position = tile.getPosition();
        tile.setPosition(this.getPosition());
        this.setPosition(position);
    }


    @Override
    public int compareTo(Tile o) {
        return 0;
    }

    protected void battle(Unit unit) {
        messageCallback.send(String.format("%s engaged in combat with %s.\n%s\n%s", getName(), unit.getName(), description(), unit.description()));
        int damageDone = Math.max(attack() - unit.defend(), 0);
        unit.health.reduceAmount(damageDone);
        messageCallback.send(String.format("%s dealt %d damage to %s.", getName(), damageDone, unit.getName()));
    }

    public void interact(Tile tile) {
        tile.accept(this);
    }

    public abstract void processStep();
}
