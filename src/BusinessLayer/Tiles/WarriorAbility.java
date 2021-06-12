package BusinessLayer.Tiles;

import BusinessLayer.Interfaces.Ability;

public class WarriorAbility /*implements Ability*/ {
    public String name;
    public int cooldown;

    public WarriorAbility(String name, int cooldown) {
        this.name = name;
        this.cooldown = cooldown;
    }
/*
    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getPoolName() {
        return null;
    }

    @Override
    public boolean isAvailable() {
        return false;
    }

    @Override
    public void fill() {

    }

    @Override
    public void addToPool() {

    }

    @Override
    public int getAmount() {
        return 0;
    }

    @Override
    public int getPool() {
        return 0;
    }*/
}
