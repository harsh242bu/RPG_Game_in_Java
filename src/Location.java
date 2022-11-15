// Abstraction of heroes location on the board

public class Location {
    private int x;
    private int y;

    Location(int x, int y){
        this.x = x;
        this.y = y;
    }
    Location(Location newloc){
        this.x = newloc.getX();
        this.y = newloc.getY();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return x == location.x && y == location.y;
    }

}
