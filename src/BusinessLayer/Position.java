package BusinessLayer;

public class Position {
    private int xPos;
    private int yPos;

    public Position(int x, int y){
        xPos = x;
        yPos = y;
    }

    public int getxPos(){
        return xPos;
    }

    public int getyPos() { return yPos; }

    public Position translate(int dx, int dy){
        return new Position(this.xPos + dx, this.yPos + dy);
    }

    public double Range(int x, int y){
        return(Math.sqrt(Math.pow(xPos-x,2) + Math.pow(yPos-y, 2)));
    }

    public double Range(Position p){
        return(Math.sqrt(Math.pow(xPos-p.xPos,2) + Math.pow(yPos-p.yPos, 2)));
    }

    public boolean equals(Position p){
        return this.xPos == p.xPos && this.yPos == p.yPos;
    }
}
