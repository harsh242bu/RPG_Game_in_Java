// Armor class - Contains attribute specific to Armor
public class Armor extends Item{
    int damageReduction;

    public Armor(String name, int cost, int reqLevel, int damageReduction) {
        super(name, cost, reqLevel);
        this.damageReduction = damageReduction;
    }

    public int getDamageReduction() {
        return damageReduction;
    }

    public void setDamageReduction(int damageReduction) {
        this.damageReduction = damageReduction;
    }

    public void getHeader(){
        System.out.println("Name\t\tCost\tRequired level\tDamage");
    }

    @Override
    public void printItem() {
        System.out.println(getName() + "\t\t" + getCost() + "\t" + getReqLevel() + "\t" + getDamageReduction() );
    }
}
