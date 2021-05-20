package BusinessLayer.GameObjects.Player;

public class Hunter implements Player, HeroicUnit{
    public Integer range;
    public Integer arrowsCount;
    public Integer ticksCount = 0;

    public Hunter(String name, int health, int attack, int defense, int range){

    }

    @Override
    public void castAbility() {

    }
}
