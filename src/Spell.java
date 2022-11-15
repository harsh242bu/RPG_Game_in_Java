// Spell class

public class Spell extends Item {
    private int damage;
    private int manaCost;
    private int attrAffected;

    Spell(String name, int cost, int reqLevel, int damage, int manaCost, int attrAffected){
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

    public void getHeader(){
//        Name/cost/required level/damage/mana cost
        System.out.println("Name\tCost\tLevel\tDamage\tMana cost\tCategory");
    }

    @Override
    public void printItem(){
        System.out.print(getName() +"\t" + getCost() + "\t" + getReqLevel() + "\t" + getDamage() +
                "\t" + getManaCost() + "\t" );
    }
}
