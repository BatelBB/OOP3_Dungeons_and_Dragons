package BusinessLayer.Tiles.Player;

import BusinessLayer.Tiles.Enemy.Enemy;
import BusinessLayer.Tiles.Resource;

import java.util.List;

public class Hunter extends Player {
    public Integer range;
    public Integer arrowsCount;
    public Integer ticksCount;
    private final int ARROWSADDCOUNT = 10;
    private final int TICKSCOUNT = 0;

    public Hunter(char ch, String name, Resource health, int attack, int defense, int range){
        super(ch, name, health, attack, defense);
        this.range = range;
        arrowsCount = ARROWSADDCOUNT*playerLevel;
        ticksCount = TICKSCOUNT;
    }
    @Override
    public String description() {
        return null;
    }

    @Override
    public void onAbilityCast(List<Enemy> enemies) {
//        if(arrowsCount==0 || )
//        arrowsCount -= 1;

    }
}
