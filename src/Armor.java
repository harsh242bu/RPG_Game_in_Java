// Armor class - Contains attribute specific to Armor
public class Armor extends Item {
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

    public void getHeader() {
        String output = String.format("%-5s %-17s %-10s %-18s %-10s", "No.", "Name", "Cost", "Required Level", "Damage");
        System.out.println(output);
    }

    @Override
    public Armor clone() {
        Armor armor = null;
        try{
            armor = (Armor) super.clone();
        }
        catch(Exception e){
            armor = new Armor(getName(), getCost(), getReqLevel(), getDamageReduction());
        }

        return armor;
    }

    @Override
    public void printItem() {
        String output = String.format("  %-17s %-10s %-18s %-10s", getName(), getCost(), getReqLevel(), getDamageReduction());

        System.out.println(output);
    }
}
