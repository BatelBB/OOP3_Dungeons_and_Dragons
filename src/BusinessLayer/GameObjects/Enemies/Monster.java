package BusinessLayer.GameObjects.Enemies;


import BusinessLayer.GameObjects.Player.Player;
import BusinessLayer.Utils.Resource;

public class Monster extends Enemy{
    public Integer visionRange;

    public Monster(char ch, String name, Resource resource, int attack, int defense, int visionRange, int experienceValue){
        super(ch, name, resource, attack, defense, experienceValue);
        this.visionRange = visionRange;
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
//        if(getPosition().range(this,player) < visionRange){
//            int dx = this.getPosition().xPos - player.getPosition().xPos;
//            int dy = this.getPosition().yPos - player.getPosition().yPos;
//            if(Math.abs(dx) > Math.abs(dy)) {
//                if(dx>0)
//                    moveLeft();
//                else
//                    moveRight();
//            }else
//                if(dy>0)
//                    moveUp();
//                else
//                    moveDown();
//        }else {
//            //Perform a random movement action: left, right, up, down or stay at the same place.
//        }

    }

    @Override
    public void visit(Player player) {
        super.battle(player);
        if(!player.alive()){
            switchPosition(player);
        }
    }
}
