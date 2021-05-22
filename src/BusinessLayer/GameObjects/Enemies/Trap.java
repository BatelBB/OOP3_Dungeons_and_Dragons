package BusinessLayer.GameObjects.Enemies;

import BusinessLayer.GameObjects.Player.Player;

public class Trap extends Enemy{
    public Integer visibilityTime; // amount of ticks that the trap remains visible, a constructor argument
    public Integer invisibilityTime; //amount of ticks that the trap remains invisible, a constructor argument.
    public Integer ticksCount; //counts the number of ticks since last visibility state change. Initially 0.
    public boolean visible; //indicates whether the trap is currently visible. Initially true

    public Trap(String name, char tile, int health, int attack, int defense, int experienceValue, int visibilityTime, int invisibilityTime){
        this.name = name;
        this.tile = tile;
        this.healthAmount = health;
        this.healthPool = health;
        this.attackPoints = attack;
        this.defensePoints = defense;
        this.visibilityTime = visibilityTime;
        this.invisibilityTime = invisibilityTime;
        this.experienceValue = experienceValue;
        this.ticksCount = 0;
        this.visible = true;
    }

    public void updateState(Player player){
        visible = ticksCount < visibilityTime;
        if(ticksCount == (visibilityTime + invisibilityTime))
            ticksCount = 0;
        else
            ticksCount +=1;
        if(range(this, player)<2)
            attack(player);
    }

    private void attack(Player player){

    }




}
