package BusinessLayer.Interfaces;

import BusinessLayer.Tiles.Enemy.Enemy;

public interface EnemyDeathCallback {
    public void onEnemyDeath(Enemy e);
}
