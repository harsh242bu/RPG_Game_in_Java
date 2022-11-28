// Represents an item inside the game. Ex: spell, potion, weapon, armor
public abstract class Item implements Cloneable{
    private String name;
    private int cost;
    private int reqLevel;

    Item(String name, int cost, int reqLevel){
        this.name = name;
        this.cost = cost;
        this.reqLevel = reqLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getReqLevel() {
        return reqLevel;
    }

    public void setReqLevel(int reqLevel) {
        this.reqLevel = reqLevel;
    }

    @Override
    public Item clone() throws CloneNotSupportedException {
        return (Item) super.clone();
    }

    public abstract void getHeader();

    public abstract void printItem();
}
