// Ice spells data
public class IceSpellsData {
    static public ItemInventory iceSpells;

    IceSpellsData(){
        iceSpells = new ItemInventory();

//        Name/cost/required level/damage/mana cost
//        Snow_Cannon     500     2   650     250
//        Ice_Blade       250     1   450     100
//        Frost_Blizzard  750     5   850     350
//        Arctic_Storm    700     6   800     300


        iceSpells.addItem(new IceSpell("Snow_Cannon", 500, 2, 65, 250));
        iceSpells.addItem(new IceSpell("Ice_Blade", 250, 1, 45, 100));
        iceSpells.addItem(new IceSpell("Frost_Blizzard", 750, 5, 85, 350));
        iceSpells.addItem(new IceSpell("Arctic_Storm", 700, 6, 80, 300));

    }
}
