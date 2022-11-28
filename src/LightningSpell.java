// Represents a Lightning spell. Subclass of spell
public class LightningSpell extends Spell{
    LightningSpell(String name, int cost, int reqLevel, int damage, int manaCost){
        super(name, cost, reqLevel, damage, manaCost, Modifiable.AGILITY);
    }

    @Override
    public LightningSpell clone() {
        return (LightningSpell) super.clone();
    }

    @Override
    public void printItem(){
        super.printItem();
        System.out.println("Dodge");
    }

    @Override
    public String getName(){
        String str = "Lightning spell " + super.getName();
        return str;
    }
}
