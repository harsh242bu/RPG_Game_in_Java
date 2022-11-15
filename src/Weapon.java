// Weapon class
public class Weapon extends Item{
    int damage;
    int reqHands;

    Weapon(String name, int cost, int reqLevel, int damage, int reqHands){
        super(name, cost, reqLevel);
        this.damage = damage;
        this.reqHands = reqHands;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getReqHands() {
        return reqHands;
    }

    public void setReqHands(int reqHands) {
        this.reqHands = reqHands;
    }

    @Override
    public void getHeader() {
        System.out.println("Name\t\tCost\tRequired level\tDamage\tRequired hands");
    }

    @Override
    public void printItem() {
        System.out.println(getName() + "\t\t" + getCost() + "\t" + getReqLevel() + "\t" +
                getDamage() + "\t" + getReqLevel() );
    }
}
