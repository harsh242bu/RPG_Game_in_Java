// Weapon class
public class Weapon extends Item {
    int damage;
    int reqHands;

    Weapon(String name, int cost, int reqLevel, int damage, int reqHands) {
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
//        System.out.println("Name\t\tCost\tRequired level\tDamage\tRequired hands");
        String output = String.format("%-5s %-17s %-10s %-18s %-10s %-10s", "No.", "Name", "Cost", "Required Level", "Damage", "Required Hands");
//        System.out.println("Name\t\tCost\tRequired level\tDamage");
        System.out.println(output);
    }

    @Override
    public void printItem() {
//        System.out.println(getName() + "\t\t" + getCost() + "\t" + getReqLevel() + "\t" +
//                getDamage() + "\t" + getReqLevel());
        String output = String.format("  %-17s %-10s %-18s %-10s %-10s", getName(), getCost(), getReqLevel(), getDamage(), getReqHands());

        System.out.println(output);
    }
}
