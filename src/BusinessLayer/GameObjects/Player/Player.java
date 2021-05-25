package BusinessLayer.GameObjects.Player;

import Game_Tiles.Unit;


public abstract class Player extends Unit {
    public Integer experience = 0;
    public Integer playerLevel = 1;

    public void levelUpBasic() {
        this.experience = this.experience - 50 * this.playerLevel;
        this.playerLevel += 1;
        this.healthPool = this.healthPool + 10 * this.playerLevel;
        this.healthAmount = this.healthPool;
        this.attackPoints = this.attackPoints + 4 * this.playerLevel;
        this.defensePoints = this.defensePoints + this.playerLevel;
    }
}
