package BusinessLayer.GameObjects.Enemies;

import BusinessLayer.GameObjects.Player.Player;
import BusinessLayer.Utils.Resource;

public class Trap extends Enemy{
    public Integer visibilityTime; // amount of ticks that the trap remains visible, a constructor argument
    public Integer invisibilityTime; //amount of ticks that the trap remains invisible, a constructor argument.
    public Integer ticksCount; //counts the number of ticks since last visibility state change. Initially 0.
    public boolean visible; //indicates whether the trap is currently visible. Initially true

    public Trap(String name, char tile, Resource resource, int attack, int defense, int experienceValue, int visibilityTime, int invisibilityTime){
        super(tile, name, resource, attack, defense, experienceValue);
        this.visibilityTime = visibilityTime;
        this.invisibilityTime = invisibilityTime;
        this.ticksCount = 0;
        this.visible = true;
    }

    public void updateState(Player player){
        visible = ticksCount < visibilityTime;
        if(ticksCount == (visibilityTime + invisibilityTime))
            ticksCount = 0;
        else
            ticksCount +=1;
        if(position.range(this, player)<2)
            attack(player);
    }

    private void attack(Player player){

    }

    public String toString(){
        return "Im a: " + name;
    }


    @Override
    public void onDeath() {

    }

    @Override
    public void processStep() {

    }
}
