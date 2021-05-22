package Game_Tiles;

public class Unit extends Tile{
    public String name;
    public Integer healthPool;
    public Integer healthAmount;
    public Integer attackPoints;
    public Integer defensePoints;

    // Returns the name of the unit. Use it to print the names upon combat engagement on ability cast.
    public String getName(){
        return name;
    }

    // String, returns full information of the current unit,  String, returns full information of the current unit
    public String description(){
        //String s = name +"\tHealth: "+healthAmount+"/"+healthPool+"\tAttack: "+attackPoints+"\tDefense: "+defensePoints;
        return null;
    }

    @Override
    public void accept(Visitor visitor) {

    }

    @Override
    public void visit(Wall wall) {

    }

    @Override
    public void visit(Unit unit) {

    }

    @Override
    public void visit(Empty empty) {

    }
}
