// Ice spell - subclass of spell
public class IceSpell extends Spell {
    IceSpell(String name, int cost, int reqLevel, int damage, int manaCost){
        super(name, cost, reqLevel, damage, manaCost, Modifiable.DAMAGE);
    }

    @Override
    public void printItem(){
        super.printItem();
        System.out.println("Damage");
    }

    @Override
    public String getName(){
        String str = "Ice spell " + super.getName();
        return str;
    }
}
