// Fire spell - reduces the defense of the target
public class FireSpell extends Spell{
    FireSpell(String name, int cost, int reqLevel, int damage, int manaCost){
        super(name, cost, reqLevel, damage, manaCost, Modifiable.DEFENSE);
    }

    @Override
    public FireSpell clone() {
        return (FireSpell) super.clone();
    }

    @Override
    public void printItem(){
        super.printItem();
        System.out.println("Defense");
    }

    @Override
    public String getName(){
        String str = "Fire spell " + super.getName();
        return str;
    }
}
