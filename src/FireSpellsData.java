// Contains fire spell data data
public class FireSpellsData {
    static public ItemInventory fireSpells;

    FireSpellsData(){
        fireSpells = new ItemInventory();

//        Name/cost/required level/damage/mana cost
//        Flame_Tornado   700     4   850     300
//        Breath_of_Fire  350     1   450     100
//        Heat_Wave       450     2   600     150
//        Lava_Comet      800     7   1000    550
//        Hell_Storm      600     3   950     600


        fireSpells.addItem(new FireSpell("Flame_Tornado", 700, 4, 850, 300));
        fireSpells.addItem(new FireSpell("Breath_of_Fire", 350, 1, 450, 100));
        fireSpells.addItem(new FireSpell("Heat_Wave", 450, 2, 600, 150));
        fireSpells.addItem(new FireSpell("Lava_Comet", 800, 7, 1000, 550));
        fireSpells.addItem(new FireSpell("Hell_Storm", 600, 3, 950, 600));

    }
}
