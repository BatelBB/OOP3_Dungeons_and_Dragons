package Enemies;

public class Trap implements Enemy{
    public Integer visibilityTime;
    public Integer invisibilityTime;
    public Integer ticksCount = 0;
    public boolean visible = true;

    public Trap(String name, char tile, int health, int attack, int defense, int experienceValue, int visibilityTime, int invisibilityTime){

    }
}
