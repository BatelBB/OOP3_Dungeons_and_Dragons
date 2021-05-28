package BusinessLayer.GameObjects.Enemies;


import BusinessLayer.GameObjects.Player.Player;

public class Monster extends Enemy{
    public Integer visionRange;

    public Monster(String name, char tile, int health, int attack, int defense, int visionRange, int experienceValue){
        super(tile, name, health, attack, defense);
        this.name = name;
        this.tile = tile;
        this.healthAmount = health;
        this.healthPool = health;
        this.attackPoints = attack;
        this.defensePoints = defense;
        this.visionRange = visionRange;
        this.experienceValue = experienceValue;
    }

    @Override
    public void onDeath() {

    }

    @Override
    public String description(){
        return name +"\tHealth: "+healthAmount+"/"+healthPool+"\tAttack: "+attackPoints+"\tDefense: "+defensePoints+
                "\tExperience Value: "+experienceValue+"\tVision Range: "+visionRange;
    }

    @Override
    public void processStep() {

    }

    public void monsterMove(Player player){
        if(getPosition().range(this,player) < visionRange){
            int dx = this.getPosition().xPos - player.getPosition().xPos;
            int dy = this.getPosition().yPos - player.getPosition().yPos;
            if(Math.abs(dx) > Math.abs(dy)) {
                if(dx>0)
                    moveLeft();
                else
                    moveRight();
            }else
                if(dy>0)
                    moveUp();
                else
                    moveDown();
        }else {
            //Perform a random movement action: left, right, up, down or stay at the same place.
        }

    }

    private void moveUp() {
    }

    private void moveDown() {
    }

    private void moveRight() {
    }

    private void moveLeft() {
    }
}
