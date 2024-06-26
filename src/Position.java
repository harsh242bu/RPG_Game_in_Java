// Abstraction of character location on the board. Contains x,y coordinates
public class Position {
    private int x;
    private int y;
    public Position(int x,int y){
        this.x=x;
        this.y=y;
    }

    public Position(Position position){
        this.x=position.x;
        this.y=position.y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int hashCode() {
        return (this.x+","+this.y).hashCode();
    }

    @Override
    public String toString() {
        return "Position{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return this.x==((Position)obj).x && this.y==((Position) obj).y;
    }
}
