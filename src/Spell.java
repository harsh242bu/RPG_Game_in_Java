// Spell class

public class Spell extends Item {
    private int damage;
    private int manaCost;
    private int attrAffected;

    Spell(String name, int cost, int reqLevel, int damage, int manaCost, int attrAffected) {
        super(name, cost, reqLevel);
        this.damage = damage;
        this.manaCost = manaCost;
        this.attrAffected = attrAffected;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void setManaCost(int manaCost) {
        this.manaCost = manaCost;
    }

    public int getAttrAffected() {
        return attrAffected;
    }

    public void setAttrAffected(int attrAffected) {
        this.attrAffected = attrAffected;
    }

    @Override
    public Spell clone() {
        Spell spell = null;
        try{
            spell = (Spell) super.clone();
        }
        catch(Exception e){
            spell = new Spell(getName(), getCost(), getReqLevel(), getDamage(), getManaCost(), getAttrAffected());
        }
        return spell;
    }

    public void getHeader() {
//        Name/cost/required level/damage/mana cost
//        System.out.println("Name\tCost\tLevel\tDamage\tMana cost\tCategory");
        String output = String.format("%-4s %-35s %-10s %-18s %-10s %-15s %-10s", "No.", "Name", "Cost", "Required Level", "Damage", "Mana Cost", "Category");
        System.out.println(output);
    }

    @Override
    public void printItem() {
//        System.out.print(getName() +"\t" + getCost() + "\t" + getReqLevel() + "\t" + getDamage() +
//                "\t" + getManaCost() + "\t" );
        String output = String.format(" %-35s %-10s %-18s %-10s %-15s ", getName(), getCost(), getReqLevel(), getDamage(), getManaCost());

        System.out.print(output);
    }
}
